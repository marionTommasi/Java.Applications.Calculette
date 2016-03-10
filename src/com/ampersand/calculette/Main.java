package com.ampersand.calculette;

import javax.swing.SwingUtilities;

import com.ampersand.calculette.controllers.BasicCalculatorController;
import com.ampersand.calculette.models.data.BasicCalculatorModel;
import com.ampersand.calculette.views.BasicCalculatorView;

public class Main {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			final BasicCalculatorModel model = new BasicCalculatorModel();
			final BasicCalculatorView view = new BasicCalculatorView();

			final BasicCalculatorController controller = new BasicCalculatorController(model, view);
			controller.control();
		});
	}
}
