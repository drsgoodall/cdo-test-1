package com.example.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.cdo.net4j.CDONet4jSession;
import org.eclipse.emf.cdo.net4j.CDONet4jSessionConfiguration;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.server.CDOServerExporter.XML;
import org.eclipse.emf.cdo.server.CDOServerUtil;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.IStore;
import org.eclipse.emf.cdo.server.db.CDODBUtil;
import org.eclipse.emf.cdo.server.db.IDBStore;
import org.eclipse.emf.cdo.server.db.mapping.IMappingStrategy;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.db.DBUtil;
import org.eclipse.net4j.db.IDBAdapter;
import org.eclipse.net4j.db.IDBConnectionProvider;
import org.eclipse.net4j.db.h2.H2Adapter;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;
import org.h2.jdbcx.JdbcDataSource;

/**
 * A service to manage a CDO session.
 * 
 */
public class CDOSessionWrapper {

	private final String repositoryName;

	private final CDOSessionManager parent;

	private CDOSession session = null;

	private IRepository repository;

	/**
	 * The constructor
	 * 
	 * @param cdoSessionProvider
	 * @param registryHook
	 * @param migrationService
	 * @param migrationRegistry2
	 */
	public CDOSessionWrapper(final CDOSessionManager cdoSessionProvider, final int version) {
		parent = cdoSessionProvider;
		this.repositoryName = createKey(version);
	}

	public void dispose() {

		if (repository != null) {
			LifecycleUtil.deactivate(repository);
		}
		if (session != null) {
			LifecycleUtil.deactivate(session);
		}
	}

	/**
	 * // * Returns the shared instance // * // * @return the shared instance //
	 */
	public CDOSessionManager getSessionProvider() {
		return parent;
	}

	/**
	 * Getter for session including lazy initialization
	 * 
	 * @return the CDO session
	 * @throws Exception
	 */
	public synchronized CDOSession getSession() throws Exception {
		if (session == null) {

			final IManagedContainer container = parent.getContainer();
			final IConnector connector = parent.getConnector();
			if (true) {

				{

					final URL url = getClass().getResource("/data/marker.txt");
					URL fileURL = FileLocator.toFileURL(url);
					File markerFile = new File(fileURL.toURI());
					final String respositoryPath = String.format("%s/%s", markerFile.getParent(), getRepositoryName());
					final String dataSourceStr = String.format("jdbc:h2:%s", respositoryPath);

					final JdbcDataSource dataSource = getJdbcDataSource(dataSourceStr);

					final IStore cdoStore = getStore(dataSource);

					repository = getRepository(cdoStore);

					CDOServerUtil.addRepository(container, repository);
				}
			}

			session = getSession(connector);
		}
		return session;
	}

	private CDOSession getSession(final IConnector connector) {
		final CDONet4jSessionConfiguration config = CDONet4jUtil.createNet4jSessionConfiguration();
		config.setConnector(connector);
		config.setRepositoryName(getRepositoryName());
		final CDONet4jSession session = config.openNet4jSession();
		session.options().setCommitTimeout(10);

		return session;
	}

	public void dumpXMLTo(final File target) {
		final XML x = new XML(repository);

		try {
			x.exportRepository(new FileOutputStream(target));
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private JdbcDataSource getJdbcDataSource(final String url) {
		// Setup JdbcDataSource
		final JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL(url);
		return dataSource;
	}

	private IStore getStore(final JdbcDataSource dataSource) {
		// Setup Store
		final IMappingStrategy mappingStrategy = CDODBUtil.createHorizontalMappingStrategy(true, true);

		final Map<String, String> mappingStrategyProps = new HashMap<>();
		mappingStrategyProps.put(IMappingStrategy.PROP_QUALIFIED_NAMES, "true");
		mappingStrategyProps.put(IMappingStrategy.PROP_FORCE_NAMES_WITH_ID, "true");
		mappingStrategy.setProperties(mappingStrategyProps);

		// TODO : change Adapter if an other DB is used.
		final IDBAdapter dbAdapter = new H2Adapter();
		final IDBConnectionProvider dbConnectionProvider = DBUtil.createConnectionProvider(dataSource);

		final Map<String, String> storeProps = new HashMap<String, String>();
		storeProps.put(IDBStore.Props.CONNECTION_KEEPALIVE_PERIOD, "60");
		storeProps.put(IDBStore.Props.READER_POOL_CAPACITY, "20");
		storeProps.put(IDBStore.Props.WRITER_POOL_CAPACITY, "20");

		return CDODBUtil.createStore(mappingStrategy, dbAdapter, dbConnectionProvider, storeProps);
	}

	private IRepository getRepository(final IStore store) {
		// Setup Repository
		final Map<String, String> props = new HashMap<>();
		props.put(IRepository.Props.OVERRIDE_UUID, "");
		props.put(IRepository.Props.SUPPORTING_AUDITS, "true");
		props.put(IRepository.Props.SUPPORTING_BRANCHES, "true");
		// Setting this to true requires a *large* commit time out
		// props.put(IRepository.Props.ENSURE_REFERENTIAL_INTEGRITY, "true");
		props.put(IRepository.Props.ENSURE_REFERENTIAL_INTEGRITY, "false");
		props.put(IRepository.Props.ALLOW_INTERRUPT_RUNNING_QUERIES, "true");
		props.put(IRepository.Props.ID_GENERATION_LOCATION, "STORE");
		props.put(IRepository.Props.SERIALIZE_COMMITS, "false");
		props.put(IRepository.Props.OPTIMISTIC_LOCKING_TIMEOUT, "20000");
		// props.put(IRepository.Props.CURRENT_LRU_CAPACITY, "100000");
		// props.put(IRepository.Props.REVISED_LRU_CAPACITY, "10000");
		return CDOServerUtil.createRepository(getRepositoryName(), store, props);
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public static String createKey(final int version) {
		return String.format("repository_%d", version);
	}
}
