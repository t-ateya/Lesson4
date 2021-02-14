package controller;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFrame;

import model.shapes.Circle;
import model.shapes.IShapeDraw;
import model.shapes.Rectangle;
import model.shapes.Shape;
import model.shapes.Triangle;
import view.DrawingDemoPanel;
import view.MenuScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class ShapeDemoListener implements MouseListener, ActionListener {
	public static final int SIZE_SMALL = 40;
	public static final int SIZE_MID = 60;
	public static final int SIZE_LARGE = 80;

	private DrawingDemoPanel panel;

	public ShapeDemoListener(DrawingDemoPanel panel){
		this.panel = panel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		panel.getCanvas().setSingleStepIndex(-1);
		boolean filled= panel.getFilledBox().isSelected();
		Color color = getColor();
		int size = getSize();
		IShapeDraw shape = getShape(e.getX(), e.getY(), color, size, filled);
		panel.getCanvas().getShapes().add(shape);
		panel.getCanvas().repaint();

	}

	private IShapeDraw getShape(int x, int y, Color color, int size, boolean filled){
		if(panel.getCircleButton().isSelected()){
			return (new Circle(x, y, size, color, filled));
		}else if(panel.getRecButton().isSelected()){
			return new Rectangle(x, y, size, size, color, filled);
		}else if(panel.getTriButton().isSelected()){
			return new Triangle(x, y, size, color, filled);
		}
		return new Circle(x, y, size, color, filled);
	}
	private int getSize(){
		if(panel.getSmallSize().isSelected()){
			return SIZE_SMALL;
		}else if(panel.getMedSize().isSelected()){
			return SIZE_MID;
		}else if(panel.getLargeSize().isSelected()){
			return SIZE_LARGE;
		}
		return SIZE_MID;
	}
	private Color getColor(){
		if(panel.getWhiteColor().isSelected()){
			return Color.white;
		}else if(panel.getYellowColor().isSelected()){
			return Color.yellow;
		}else if(panel.getRedColor().isSelected()){
			return Color.red;
		}
		return Color.white;
	}

	@Override
	public void mouseClicked(MouseEvent e) { }

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == panel.getClearButton()){
			panel.getCanvas().setSingleStepIndex(-1);
			panel.getCanvas().getShapes().clear();
			panel.getCanvas().repaint();
		}else if(e.getSource() == panel.getExitButton()){
			panel.getCanvas().setSingleStepIndex(-1);
			JFrame window = panel.getWindow();
			window.getContentPane().removeAll();
			var menu = new MenuScreen(window);
			menu.init();
			window.pack();
			window.revalidate();
		}else if(e.getSource() == panel.getShowOrderButton()){
			panel.getCanvas().incrementSigleStepIndex();
			panel.getCanvas().repaint();
		}else if(e.getSource() == panel.getShowAllButton()){
			panel.getCanvas().setSingleStepIndex(-1);
			panel.getCanvas().repaint();
		}else if(e.getSource() == panel.getSortXButton()){
			
			// class SortX implements Comparator<IShapeDraw>{
			// 	@Override
			// 	public int compare(IShapeDraw o1, IShapeDraw o2) {
			// 		Shape s1 = (Shape) o1;
			// 		Shape s2 = (Shape) o2;
			// 		if(s1.getX() < s2.getX()) return -1;
			// 		else if(s1.getX() < s2.getX()) return 1;
			// 		return 0;
			// 	}
			// }

			//Above code re-written in a lamda function:
			Collections.sort(panel.getCanvas().getShapes(), (o1, o2) ->{
				Shape s1 = (Shape) o1;
				Shape s2 = (Shape) o2;
				if(s1.getX() < s2.getX()) return -1;
				else if(s1.getX() < s2.getX()) return 1;
				return 0;
			});
			panel.getCanvas().setSingleStepIndex(-1);
			panel.getCanvas().repaint();
		}else if(e.getSource() == panel.getSortYButton()){
			Collections.sort(panel.getCanvas().getShapes(), (o1, o2) ->{
				Shape s1 = (Shape) o1;
				Shape s2 = (Shape) o2;
				if(s1.getY() < s2.getY()) return -1;
				else if(s1.getY() < s2.getY()) return 1;
				return 0;
			});
			panel.getCanvas().setSingleStepIndex(-1);
			panel.getCanvas().repaint();
		}


	}
	
}
