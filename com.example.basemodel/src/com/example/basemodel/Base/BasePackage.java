/**
 */
package com.example.basemodel.Base;

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
 * @see com.example.basemodel.Base.BaseFactory
 * @model kind="package"
 * @generated
 */
public interface BasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Base";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://com.example/models/base/1/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MyBaseModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BasePackage eINSTANCE = com.example.basemodel.Base.impl.BasePackageImpl.init();

	/**
	 * The meta object id for the '{@link com.example.basemodel.Base.impl.AnAbstractClassImpl <em>An Abstract Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.example.basemodel.Base.impl.AnAbstractClassImpl
	 * @see com.example.basemodel.Base.impl.BasePackageImpl#getAnAbstractClass()
	 * @generated
	 */
	int AN_ABSTRACT_CLASS = 0;

	/**
	 * The number of structural features of the '<em>An Abstract Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AN_ABSTRACT_CLASS_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>An Abstract Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AN_ABSTRACT_CLASS_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.example.basemodel.Base.AnAbstractClass <em>An Abstract Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>An Abstract Class</em>'.
	 * @see com.example.basemodel.Base.AnAbstractClass
	 * @generated
	 */
	EClass getAnAbstractClass();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BaseFactory getBaseFactory();

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
		 * The meta object literal for the '{@link com.example.basemodel.Base.impl.AnAbstractClassImpl <em>An Abstract Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.example.basemodel.Base.impl.AnAbstractClassImpl
		 * @see com.example.basemodel.Base.impl.BasePackageImpl#getAnAbstractClass()
		 * @generated
		 */
		EClass AN_ABSTRACT_CLASS = eINSTANCE.getAnAbstractClass();

	}

} //BasePackage
