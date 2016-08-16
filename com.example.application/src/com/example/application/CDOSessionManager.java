package com.example.application;

import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.jvm.IJVMAcceptor;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.tcp.ITCPAcceptor;
import org.eclipse.net4j.tcp.TCPUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.LifecycleUtil;

/**
 * A service to manage a CDO session.
 * 
 */
public class CDOSessionManager {

	private IManagedContainer container;
	private IConnector connector;
	private ITCPAcceptor tcpAcceptor;
	private IJVMAcceptor jvmAcceptor;

	public void start() throws Exception {

		container = IPluginContainer.INSTANCE;

		// Start the JVM transport
		jvmAcceptor = JVMUtil.getAcceptor(container, "data");
		JVMUtil.prepareContainer(container);
		// Open a JVM connection
		connector = JVMUtil.getConnector(container, "data");
	}

	public void enableTCPConnector(final short port) {
		if (tcpAcceptor == null) {
			// Start the TCP transport
			TCPUtil.prepareContainer(container);
			tcpAcceptor = TCPUtil.getAcceptor(container, String.format("127.0.0.1:%d", port));
		}
	}

	public void disableTCPConnector() {
		if (tcpAcceptor != null) {
			LifecycleUtil.deactivate(tcpAcceptor);
			tcpAcceptor = null;
		}
	}

	public void stop() throws Exception {

		if (jvmAcceptor != null)
			LifecycleUtil.deactivate(jvmAcceptor);
		if (tcpAcceptor != null)
			LifecycleUtil.deactivate(tcpAcceptor);
		if (connector != null)
			LifecycleUtil.deactivate(connector);
	}

	public CDOSessionWrapper getSession(final int version) {
		final CDOSessionWrapper w = new CDOSessionWrapper(this, version);
		return w;
	}

	public IManagedContainer getContainer() {
		return container;
	}

	public IConnector getConnector() {
		return connector;
	}
}
