/**
 */
package com.example.Model;

import com.example.basemodel.Base.BasePackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.example.Model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.example/models/2/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MyModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = com.example.Model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.example.Model.impl.RootObjectImpl <em>Root Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.example.Model.impl.RootObjectImpl
	 * @see com.example.Model.impl.ModelPackageImpl#getRootObject()
	 * @generated
	 */
	int ROOT_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Attrib1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OBJECT__ATTRIB1 = BasePackage.AN_ABSTRACT_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attrib2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OBJECT__ATTRIB2 = BasePackage.AN_ABSTRACT_CLASS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Root Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OBJECT_FEATURE_COUNT = BasePackage.AN_ABSTRACT_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Root Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OBJECT_OPERATION_COUNT = BasePackage.AN_ABSTRACT_CLASS_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link com.example.Model.RootObject <em>Root Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Object</em>'.
	 * @see com.example.Model.RootObject
	 * @generated
	 */
	EClass getRootObject();

	/**
	 * Returns the meta object for the attribute '{@link com.example.Model.RootObject#getAttrib1 <em>Attrib1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attrib1</em>'.
	 * @see com.example.Model.RootObject#getAttrib1()
	 * @see #getRootObject()
	 * @generated
	 */
	EAttribute getRootObject_Attrib1();

	/**
	 * Returns the meta object for the attribute '{@link com.example.Model.RootObject#getAttrib2 <em>Attrib2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attrib2</em>'.
	 * @see com.example.Model.RootObject#getAttrib2()
	 * @see #getRootObject()
	 * @generated
	 */
	EAttribute getRootObject_Attrib2();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.example.Model.impl.RootObjectImpl <em>Root Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.example.Model.impl.RootObjectImpl
		 * @see com.example.Model.impl.ModelPackageImpl#getRootObject()
		 * @generated
		 */
		EClass ROOT_OBJECT = eINSTANCE.getRootObject();

		/**
		 * The meta object literal for the '<em><b>Attrib1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT_OBJECT__ATTRIB1 = eINSTANCE.getRootObject_Attrib1();

		/**
		 * The meta object literal for the '<em><b>Attrib2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOT_OBJECT__ATTRIB2 = eINSTANCE.getRootObject_Attrib2();

	}

} //ModelPackage
