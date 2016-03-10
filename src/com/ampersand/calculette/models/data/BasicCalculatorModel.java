package com.ampersand.calculette.models.data;

public class BasicCalculatorModel {

	/*
	 * Attributes
	 */
	private double m_firstOperand;
	private double m_secondOperand;
	private String m_operator;
	private String m_current_number;

	/*
	 * Methods
	 */

	// CONSTRUCTORS

	public BasicCalculatorModel() {

		clear();
	}

	// ACCESSORS AND MUTATORS

	/**
	 * @return the current_number
	 */
	public String getCurrentNumber() {
		return m_current_number;
	}

	/**
	 * @return the m_operand
	 */
	public double getFirstOperand() {
		return m_firstOperand;
	}

	/**
	 * @return the operator
	 */
	public String getOperator() {
		return m_operator;
	}

	/**
	 * @return the secondOperand
	 */
	public double getSecondOperand() {
		return m_secondOperand;
	}

	/**
	 * @param current_number
	 *            the current_number to set
	 */
	public void setCurrentNumber(String current_number) {
		m_current_number = current_number;
	}

	/**
	 * @param m_firstOperand
	 *            the m_operand to set
	 */
	public void setFirstOperand(double operand) {
		m_firstOperand = operand;
	}

	/**
	 * @param operator
	 *            the operator to set
	 */
	public void setOperator(String operator) {
		m_operator = operator;
	}

	/**
	 * @param secondOperand
	 *            the secondOperand to set
	 */
	public void setSecondOperand(double secondOperand) {
		m_secondOperand = secondOperand;
	}

	// IMPLEMENTED METHODS

	public void clear() {

		setFirstOperand(0);
		setSecondOperand(0);
		setOperator("");
		setCurrentNumber("0");
	}
}
