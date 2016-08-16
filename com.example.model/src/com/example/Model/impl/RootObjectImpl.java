/**
 */
package com.example.Model.impl;

import com.example.Model.ModelPackage;
import com.example.Model.RootObject;

import com.example.basemodel.Base.impl.AnAbstractClassImpl;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Root Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.example.Model.impl.RootObjectImpl#getAttrib1 <em>Attrib1</em>}</li>
 *   <li>{@link com.example.Model.impl.RootObjectImpl#getAttrib2 <em>Attrib2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RootObjectImpl extends AnAbstractClassImpl implements RootObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RootObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ROOT_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrib1() {
		return (Integer)eGet(ModelPackage.Literals.ROOT_OBJECT__ATTRIB1, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrib1(int newAttrib1) {
		eSet(ModelPackage.Literals.ROOT_OBJECT__ATTRIB1, newAttrib1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAttrib2() {
		return (Integer)eGet(ModelPackage.Literals.ROOT_OBJECT__ATTRIB2, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttrib2(int newAttrib2) {
		eSet(ModelPackage.Literals.ROOT_OBJECT__ATTRIB2, newAttrib2);
	}

} //RootObjectImpl
