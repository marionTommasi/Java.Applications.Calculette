package com.ampersand.calculette.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import com.ampersand.calculette.models.data.BasicCalculatorModel;
import com.ampersand.calculette.views.BasicCalculatorView;
import com.ampersand.lcu.interfaces.IController;

public class BasicCalculatorController implements IController {

	/*
	 * Attributes
	 */

	private final BasicCalculatorModel m_basic_calculator_model;
	private final BasicCalculatorView m_basic_calculator_view;

	private DigitListener m_digit_listener;
	private OperatorListener m_operator_listener;

	/*
	 * Methods
	 */

	// CONSTRUCTORS

	public BasicCalculatorController(BasicCalculatorModel model, BasicCalculatorView view) {

		m_basic_calculator_model = model;
		m_basic_calculator_view = view;
	}

	// IMPLEMENTED METHODS

	private void calculateResult() {

		final double current_number = Double.parseDouble(m_basic_calculator_model.getCurrentNumber());

		if (m_basic_calculator_model.getSecondOperand() == 0) {

			m_basic_calculator_model.setSecondOperand(current_number);
		} else {

			m_basic_calculator_model.setFirstOperand(current_number);
		}

		if (m_basic_calculator_model.getOperator().equals("+")) {

			m_basic_calculator_model.setCurrentNumber(String
					.valueOf(m_basic_calculator_model.getFirstOperand() + m_basic_calculator_model.getSecondOperand()));
		} else if (m_basic_calculator_model.getOperator().equals("-")) {

			m_basic_calculator_model.setCurrentNumber(String
					.valueOf(m_basic_calculator_model.getFirstOperand() - m_basic_calculator_model.getSecondOperand()));
		} else if (m_basic_calculator_model.getOperator().equals("x")
				|| m_basic_calculator_model.getOperator().equals("*")) {

			m_basic_calculator_model.setCurrentNumber(String
					.valueOf(m_basic_calculator_model.getFirstOperand() * m_basic_calculator_model.getSecondOperand()));
		} else if (m_basic_calculator_model.getOperator().equals("/")) {

			try {

				m_basic_calculator_model.setCurrentNumber(String.valueOf(
						m_basic_calculator_model.getFirstOperand() / m_basic_calculator_model.getSecondOperand()));
			} catch (final ArithmeticException exception) {

				exception.printStackTrace();
			}
		}
	}

	@Override
	public void control() {

		m_digit_listener = new DigitListener();
		m_operator_listener = new OperatorListener();

		m_basic_calculator_view.get7Button().addActionListener(m_digit_listener);
		m_basic_calculator_view.get8Button().addActionListener(m_digit_listener);
		m_basic_calculator_view.get9Button().addActionListener(m_digit_listener);
		m_basic_calculator_view.get4Button().addActionListener(m_digit_listener);
		m_basic_calculator_view.get5Button().addActionListener(m_digit_listener);
		m_basic_calculator_view.get6Button().addActionListener(m_digit_listener);
		m_basic_calculator_view.get1Button().addActionListener(m_digit_listener);
		m_basic_calculator_view.get2Button().addActionListener(m_digit_listener);
		m_basic_calculator_view.get3Button().addActionListener(m_digit_listener);

		m_basic_calculator_view.getCommaButton().addActionListener(m_operator_listener);
		m_basic_calculator_view.getClearButton().addActionListener(m_operator_listener);

		m_basic_calculator_view.getDivideButton().addActionListener(m_operator_listener);
		m_basic_calculator_view.getMultiplyButton().addActionListener(m_operator_listener);
		m_basic_calculator_view.getSubstractButton().addActionListener(m_operator_listener);
		m_basic_calculator_view.getAddButton().addActionListener(m_operator_listener);
		m_basic_calculator_view.getResultButton().addActionListener(m_operator_listener);

		m_basic_calculator_view.addKeyListener(m_digit_listener);
		m_basic_calculator_view.addKeyListener(m_operator_listener);
	}

	@Override
	public void updateView() {

		m_basic_calculator_view.getScreen().setText(m_basic_calculator_model.getCurrentNumber());
	}

	// LISTENERS

	class DigitListener implements ActionListener, KeyListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (m_basic_calculator_model.getCurrentNumber().equals("0")) {

				m_basic_calculator_model.setCurrentNumber(((JButton) e.getSource()).getText());
			} else {

				m_basic_calculator_model.setCurrentNumber(
						m_basic_calculator_model.getCurrentNumber() + ((JButton) e.getSource()).getText());
			}

			updateView();
		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_NUMPAD0
					|| e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_NUMPAD1
					|| e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_NUMPAD2
					|| e.getKeyCode() == KeyEvent.VK_3 || e.getKeyCode() == KeyEvent.VK_NUMPAD3
					|| e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_NUMPAD4
					|| e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_NUMPAD5
					|| e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_NUMPAD6
					|| e.getKeyCode() == KeyEvent.VK_7 || e.getKeyCode() == KeyEvent.VK_NUMPAD7
					|| e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_NUMPAD8
					|| e.getKeyCode() == KeyEvent.VK_9 || e.getKeyCode() == KeyEvent.VK_NUMPAD9) {

				if (m_basic_calculator_model.getCurrentNumber().equals("0")) {

					m_basic_calculator_model.setCurrentNumber(String.valueOf(e.getKeyChar()));
				} else {

					m_basic_calculator_model.setCurrentNumber(
							m_basic_calculator_model.getCurrentNumber() + String.valueOf(e.getKeyChar()));
				}

				updateView();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}

	class OperatorListener implements ActionListener, KeyListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource().equals(m_basic_calculator_view.getCommaButton())) {

				if (!m_basic_calculator_model.getCurrentNumber().contains(".")) {

					m_basic_calculator_model.setCurrentNumber(m_basic_calculator_model.getCurrentNumber() + ".");
				}
			} else if (e.getSource().equals(m_basic_calculator_view.getClearButton())) {

				m_basic_calculator_model.clear();
			} else if (e.getSource().equals(m_basic_calculator_view.getResultButton())) {

				calculateResult();
			} else {

				m_basic_calculator_model
						.setFirstOperand(Double.parseDouble(m_basic_calculator_model.getCurrentNumber()));
				m_basic_calculator_model.setSecondOperand(0);
				m_basic_calculator_model.setOperator(((JButton) e.getSource()).getText());
				m_basic_calculator_model.setCurrentNumber("0");
			}

			updateView();
		}

		@Override
		public void keyPressed(KeyEvent e) {

			if (e.getKeyCode() == KeyEvent.VK_DECIMAL) {

				if (!m_basic_calculator_model.getCurrentNumber().contains(".")) {

					m_basic_calculator_model.setCurrentNumber(m_basic_calculator_model.getCurrentNumber() + ".");
				}
			} else if (e.getKeyCode() == KeyEvent.VK_CLEAR) {

				m_basic_calculator_model.clear();
			} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				calculateResult();
			} else if (e.getKeyCode() == KeyEvent.VK_ADD || e.getKeyCode() == KeyEvent.VK_SUBTRACT
					|| e.getKeyCode() == KeyEvent.VK_MULTIPLY || e.getKeyCode() == KeyEvent.VK_DIVIDE) {

				m_basic_calculator_model
						.setFirstOperand(Double.parseDouble(m_basic_calculator_model.getCurrentNumber()));
				m_basic_calculator_model.setSecondOperand(0);
				m_basic_calculator_model.setOperator(String.valueOf(e.getKeyChar()));
				m_basic_calculator_model.setCurrentNumber("0");
			}

			updateView();
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
	}
}
