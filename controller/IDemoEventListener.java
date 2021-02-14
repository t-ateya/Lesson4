package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;

import java.awt.Rectangle;

import model.idemo.IRender;
import view.IDemoPanel;
import view.MenuScreen;

public class IDemoEventListener implements MouseListener, KeyListener, ActionListener{

	public static final int UNIT_MOVE = 5;
	private IDemoPanel panel;


	public IDemoEventListener(IDemoPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ArrayList<IRender> pictures = panel.getCanvas().getPictures();
		for (int i = 0; i < pictures.size(); i++) {
			Rectangle r = pictures.get(i).getBoundingBox();

			if (r.contains(e.getX(), e.getY())) {
				panel.getCanvas().setSelectIndex(i);
				panel.getCanvas().repaint();
				return;
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) { }

	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }


	@Override
	public void keyPressed(KeyEvent e) {
		var key = e.getKeyCode();
		int selectIndex  = panel.getCanvas().getSelectIndex();
		IRender pic = panel.getCanvas().getPictures().get(selectIndex);
		if(selectIndex < 0) return;
		switch(key){
			case KeyEvent.VK_LEFT:
				pic.translate(-UNIT_MOVE, 0);
				break;
			case KeyEvent.VK_RIGHT:
				pic.translate(UNIT_MOVE, 0);
				break;
			case KeyEvent.VK_UP:
				pic.translate(0, -UNIT_MOVE);
				break;
			case KeyEvent.VK_DOWN:
				pic.translate(0, UNIT_MOVE);
				break;
		}
		panel.getCanvas().repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) { }


	@Override
	public void keyReleased(KeyEvent e) { }

	@Override
	public void actionPerformed(ActionEvent e){
		if(panel.getQuitButton() == e.getSource()){
			JFrame window = panel.getWindow();

			window.getContentPane().removeAll();
			var menu = new MenuScreen(window);

			menu.init();
			window.pack();
			window.revalidate();
		}
	}
	
}
