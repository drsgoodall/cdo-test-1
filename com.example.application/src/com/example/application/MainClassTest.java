package com.example.application;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.junit.Ignore;
import org.junit.Test;

import com.example.Model.ModelFactory;
import com.example.Model.RootObject;

public class MainClassTest {

	@Test

	public void loadV1Data() throws Exception {

		CDOSessionManager manager = new CDOSessionManager();
		manager.start();

		CDOSessionWrapper session = manager.getSession(1);
		session.getSession().options().setGeneratedPackageEmulationEnabled(true);
		CDOView view = session.getSession().openView();

		CDOResource resource = view.getResource("/resource");
		EObject rootObject = resource.getContents().get(0);
		System.out.println(rootObject.eGet(rootObject.eClass().getEStructuralFeature("attrib1")));

		view.close();

	}

	@Test
	@Ignore("Used to generate v1 data")
	public void generateV1Data() throws Exception {

		CDOSessionManager manager = new CDOSessionManager();
		manager.start();

		CDOSessionWrapper session = manager.getSession(1);
		CDOTransaction transaction = session.getSession().openTransaction();

		CDOResource resource = transaction.createResource("/resource");

		RootObject rootObject = ModelFactory.eINSTANCE.createRootObject();
		rootObject.setAttrib1(10);
		resource.getContents().add(rootObject);

		transaction.commit();
		transaction.close();

	}

}
