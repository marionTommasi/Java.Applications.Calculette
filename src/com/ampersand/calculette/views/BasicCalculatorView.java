package com.ampersand.calculette.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import com.ampersand.lcu.gui.color.ColorPalette;
import com.ampersand.lcu.gui.component.button.HighlightButton;
import com.ampersand.lcu.gui.font.FontManager;

public class BasicCalculatorView extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 6859561980767748741L;

	private JLabel m_screenLabel;

	private HighlightButton m_0Button;
	private HighlightButton m_1Button;
	private HighlightButton m_2Button;
	private HighlightButton m_3Button;
	private HighlightButton m_4Button;
	private HighlightButton m_5Button;
	private HighlightButton m_6Button;
	private HighlightButton m_7Button;
	private HighlightButton m_8Button;
	private HighlightButton m_9Button;
	private HighlightButton m_commaButton;
	private HighlightButton m_clearButton;
	private HighlightButton m_addButton;
	private HighlightButton m_substractButton;
	private HighlightButton m_multiply;
	private HighlightButton m_divideButton;
	private HighlightButton m_resultButton;

	private JPanel m_centerPanel;
	private JPanel m_eastPanel;

	/*
	 * Methods:
	 */

	// CONSTRUCTOR

	public BasicCalculatorView() {

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (final ClassNotFoundException e) {

			e.printStackTrace();
		} catch (final InstantiationException e) {

			e.printStackTrace();
		} catch (final IllegalAccessException e) {

			e.printStackTrace();
		} catch (final UnsupportedLookAndFeelException e) {

			e.printStackTrace();
		}

		// View Settings
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("res/icons/app.png")).getImage());
		setTitle("BasiCalculator");
		setSize(450, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		getContentPane().setBackground(Color.DARK_GRAY);

		init();
	}

	// ACCESSORS AND MUTATORS

	/**
	 * @return the 0 button
	 */
	public HighlightButton get0Button() {
		return m_0Button;
	}

	/*
	 * Attributes:
	 */

	/**
	 * @return the 1 button
	 */
	public HighlightButton get1Button() {
		return m_1Button;
	}

	/**
	 * @return the 2 button
	 */
	public HighlightButton get2Button() {
		return m_2Button;
	}

	/**
	 * @return the 3 button
	 */
	public HighlightButton get3Button() {
		return m_3Button;
	}

	/**
	 * @return the 4 button
	 */
	public HighlightButton get4Button() {
		return m_4Button;
	}

	/**
	 * @return the 5 button
	 */
	public HighlightButton get5Button() {
		return m_5Button;
	}

	/**
	 * @return the 6 button
	 */
	public HighlightButton get6Button() {
		return m_6Button;
	}

	/**
	 * @return the 7 button
	 */
	public HighlightButton get7Button() {
		return m_7Button;
	}

	/**
	 * @return the 8 button
	 */
	public HighlightButton get8Button() {
		return m_8Button;
	}

	/**
	 * @return the 9 button
	 */
	public HighlightButton get9Button() {
		return m_9Button;
	}

	/**
	 * @return the add button
	 */
	public HighlightButton getAddButton() {
		return m_addButton;
	}

	/**
	 * @return the clear button
	 */
	public HighlightButton getClearButton() {
		return m_clearButton;
	}

	/**
	 * @return the comma button
	 */
	public HighlightButton getCommaButton() {
		return m_commaButton;
	}

	/**
	 * @return the divide button
	 */
	public HighlightButton getDivideButton() {
		return m_divideButton;
	}

	/**
	 * @return the multiply button
	 */
	public HighlightButton getMultiplyButton() {
		return m_multiply;
	}

	/**
	 * @return the result button
	 */
	public HighlightButton getResultButton() {
		return m_resultButton;
	}

	public JLabel getScreen() {
		return m_screenLabel;
	}

	/**
	 * @return the substract button
	 */
	public HighlightButton getSubstractButton() {
		return m_substractButton;
	}

	// IMPLEMENTED METHODS
	// INISIALIZATIONS

	public void init() {

		// NORTH
		initScreen();

		// CENTER && EAST
		initKeyboard();
	}

	public void initKeyboard() {

		m_7Button = new HighlightButton("7", Color.WHITE, Color.BLACK);
		m_7Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_8Button = new HighlightButton("8", Color.WHITE, Color.BLACK);
		m_8Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_9Button = new HighlightButton("9", Color.WHITE, Color.BLACK);
		m_9Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_4Button = new HighlightButton("4", Color.WHITE, Color.BLACK);
		m_4Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_5Button = new HighlightButton("5", Color.WHITE, Color.BLACK);
		m_5Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_6Button = new HighlightButton("6", Color.WHITE, Color.BLACK);
		m_6Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_1Button = new HighlightButton("1", Color.WHITE, Color.BLACK);
		m_1Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_2Button = new HighlightButton("2", Color.WHITE, Color.BLACK);
		m_2Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_3Button = new HighlightButton("3", Color.WHITE, Color.BLACK);
		m_3Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_0Button = new HighlightButton("0", Color.WHITE, Color.BLACK);
		m_0Button.setFont(FontManager.CENTURY_GOTHIC_30);

		m_commaButton = new HighlightButton(",", Color.WHITE, Color.DARK_GRAY, ColorPalette.CADET_BLUE);
		m_commaButton.setFont(FontManager.CENTURY_GOTHIC_30);

		m_clearButton = new HighlightButton("C", Color.WHITE, Color.DARK_GRAY, ColorPalette.CADET_BLUE);
		m_clearButton.setFont(FontManager.CENTURY_GOTHIC_30);

		m_centerPanel = new JPanel(new GridLayout(4, 3));
		m_centerPanel.add(m_7Button);
		m_centerPanel.add(m_8Button);
		m_centerPanel.add(m_9Button);
		m_centerPanel.add(m_4Button);
		m_centerPanel.add(m_5Button);
		m_centerPanel.add(m_6Button);
		m_centerPanel.add(m_1Button);
		m_centerPanel.add(m_2Button);
		m_centerPanel.add(m_3Button);
		m_centerPanel.add(m_0Button);
		m_centerPanel.add(m_commaButton);
		m_centerPanel.add(m_clearButton);
		m_centerPanel.setBorder(new LineBorder(Color.GRAY, 5));

		getContentPane().add(m_centerPanel, BorderLayout.CENTER);

		m_divideButton = new HighlightButton("/", Color.WHITE, Color.DARK_GRAY, ColorPalette.ORANGE_RED);
		m_divideButton.setFont(FontManager.CENTURY_GOTHIC_30);

		m_multiply = new HighlightButton("x", Color.WHITE, Color.DARK_GRAY, ColorPalette.ORANGE_RED);
		m_multiply.setFont(FontManager.CENTURY_GOTHIC_30);

		m_substractButton = new HighlightButton("-", Color.WHITE, Color.DARK_GRAY, ColorPalette.ORANGE_RED);
		m_substractButton.setFont(FontManager.CENTURY_GOTHIC_30);

		m_addButton = new HighlightButton("+", Color.WHITE, Color.DARK_GRAY, ColorPalette.ORANGE_RED);
		m_addButton.setFont(FontManager.CENTURY_GOTHIC_30);

		m_eastPanel = new JPanel(new GridLayout(4, 1));
		m_eastPanel.add(m_divideButton);
		m_eastPanel.add(m_multiply);
		m_eastPanel.add(m_substractButton);
		m_eastPanel.add(m_addButton);
		m_eastPanel.setBorder(new LineBorder(Color.GRAY, 5));
		m_eastPanel.setPreferredSize(new Dimension(100, 30));

		getContentPane().add(m_eastPanel, BorderLayout.EAST);

		// SOUTH
		m_resultButton = new HighlightButton("=", Color.WHITE, Color.DARK_GRAY, ColorPalette.CADET_BLUE);
		m_resultButton.setFont(FontManager.CENTURY_GOTHIC_30);

		getContentPane().add(m_resultButton, BorderLayout.SOUTH);
	}

	public void initScreen() {

		m_screenLabel = new JLabel("0");
		m_screenLabel.setBorder(new LineBorder(Color.BLACK));
		m_screenLabel.setFont(FontManager.CENTURY_GOTHIC_50);
		m_screenLabel.setForeground(Color.WHITE);
		m_screenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		m_screenLabel.setPreferredSize(new Dimension(getWidth(), 110));

		getContentPane().add(m_screenLabel, BorderLayout.NORTH);
	}
}
