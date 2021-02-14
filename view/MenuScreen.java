package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MenuScreen {
	
	private JFrame window;

	public MenuScreen(JFrame window){
		this.window = window;
	}

	public void init(){
		Container cp = window.getContentPane();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 200));
		panel.setLayout(new GridLayout(2,1));

		JButton idemoButton = new JButton("Interface Demo");
		JButton drawingButton = new JButton("Drawing Demo");
		panel.add(idemoButton);
		panel.add(drawingButton);

		cp.add(BorderLayout.CENTER, panel);

		//actionlisteners
		idemoButton.addActionListener( e ->{
			window.getContentPane().removeAll();
			var p = new IDemoPanel(window);

			p.init();
			window.pack();
			window.revalidate();
		});

		
		drawingButton.addActionListener( e ->{
			window.getContentPane().removeAll();
			var p = new DrawingDemoPanel(window);

			p.init();
			window.pack();
			window.revalidate();
		});


	}

}
