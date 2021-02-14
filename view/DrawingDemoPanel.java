package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.ShapeDemoListener;

public class DrawingDemoPanel {

	private JFrame window;
	private DrawingDemoCanvas canvas;
	private JRadioButton circleButton = new JRadioButton("Circle");
	private JRadioButton recButton = new JRadioButton("Rectangle");
	private JRadioButton triButton = new JRadioButton("Triangle");
	private JRadioButton smallSize = new JRadioButton("Small");
	private JRadioButton medSize = new JRadioButton("Medium");
	private JRadioButton largeSize = new JRadioButton("Large");

	private JRadioButton whiteColor = new JRadioButton("White");
	private JRadioButton yellowColor = new JRadioButton("Yellow");
	private JRadioButton redColor = new JRadioButton("Red");

	private JCheckBox filledBox = new JCheckBox("Filled");
	
	private JButton sortXButton = new JButton("Sort by X");
	private JButton sortYButton = new JButton("Sort by Y");
	private JButton showAllButton = new JButton("Show All");
	private JButton showOrderButton = new JButton("Show order");
	private JButton clearButton = new JButton("clear");
	private JButton exitButton = new JButton("Exit");

	public DrawingDemoPanel(JFrame window){
		this.window = window;
	}

	public void init(){
		Container cp = window.getContentPane();

		canvas = new DrawingDemoCanvas(this);
		cp.add(BorderLayout.CENTER, canvas);

		JPanel southPanel = new JPanel();
		
		southPanel.setLayout(new GridLayout(4,1));
		JPanel shapePanel = new JPanel();
		JPanel colorPanel = new JPanel();
		JPanel sizePanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		southPanel.add(shapePanel);
		southPanel.add(colorPanel);
		southPanel.add(sizePanel);
		southPanel.add(buttonPanel);

		shapePanel.setBorder(BorderFactory.createTitledBorder("Shape"));
		ButtonGroup shapeGroup = new ButtonGroup();

		shapePanel.add(circleButton);
		shapePanel.add(recButton);
		shapePanel.add(triButton);
		shapeGroup.add(circleButton);
		shapeGroup.add(recButton);
		shapeGroup.add(triButton);
		circleButton.setSelected(true);

		colorPanel.setBorder(BorderFactory.createTitledBorder("Color"));
		ButtonGroup colorGroup = new ButtonGroup();
		colorPanel.add(whiteColor);
		colorPanel.add(yellowColor);
		colorPanel.add(redColor);
		colorPanel.add(filledBox);
		colorGroup.add(whiteColor);
		colorGroup.add(yellowColor);
		colorGroup.add(redColor);
		whiteColor.setSelected(true);

		sizePanel.setBorder(BorderFactory.createTitledBorder("Size"));
		ButtonGroup sizeGroup = new ButtonGroup();
		sizePanel.add(smallSize);
		sizePanel.add(medSize);
		sizePanel.add(largeSize);
		sizeGroup.add(smallSize);
		sizeGroup.add(medSize);
		sizeGroup.add(largeSize);
		smallSize.setSelected(true);

		buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
		buttonPanel.add(sortXButton);
		buttonPanel.add(sortYButton);
		buttonPanel.add(showAllButton);
		buttonPanel.add(showOrderButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(exitButton);

		cp.add(BorderLayout.SOUTH, southPanel);

		ShapeDemoListener listener = new ShapeDemoListener(this);
		canvas.addMouseListener(listener);
		clearButton.addActionListener(listener);
		exitButton.addActionListener(listener);
		showOrderButton.addActionListener(listener);
		showAllButton.addActionListener(listener);
		sortXButton.addActionListener(listener);
		sortYButton.addActionListener(listener);

	}

	public JRadioButton getCircleButton() {
		return circleButton;
	}

	public DrawingDemoCanvas getCanvas() {
		return canvas;
	}

	public JButton getClearButton() {
		return clearButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public JCheckBox getFilledBox() {
		return filledBox;
	}

	public JRadioButton getRecButton() {
		return recButton;
	}

	public JButton getShowAllButton() {
		return showAllButton;
	}

	public JButton getShowOrderButton() {
		return showOrderButton;
	}

	public JButton getSortXButton() {
		return sortXButton;
	}

	public JButton getSortYButton() {
		return sortYButton;
	}

	public JRadioButton getTriButton() {
		return triButton;
	}

	public JRadioButton getRedColor() {
		return redColor;
	}

	public JRadioButton getWhiteColor() {
		return whiteColor;
	}

	public JRadioButton getYellowColor() {
		return yellowColor;
	}

	public JRadioButton getLargeSize() {
		return largeSize;
	}

	public JRadioButton getMedSize() {
		return medSize;
	}

	public JRadioButton getSmallSize() {
		return smallSize;
	}

	public JFrame getWindow() {
		return window;
	}
	
}
