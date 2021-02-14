package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.IDemoEventListener;
import model.idemo.Airplane;
import model.idemo.Bird;
import model.idemo.Car;
import model.idemo.Dog;
import model.idemo.IRender;
import model.image.ImageStore;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

public class IDemoPanel {
	
	private JFrame window;
	private JButton quitButton = new JButton("Quit");
	private IDemoCanvas canvas;

	public IDemoPanel(JFrame window){
		this.window = window;
	}

	public void init(){
		Container cp = window.getContentPane();
		canvas = new IDemoCanvas(this);

		JPanel southPanel = new JPanel();
		southPanel.add(quitButton);

		cp.add(BorderLayout.CENTER, canvas);
		cp.add(BorderLayout.SOUTH, southPanel);

		populatePicture();

		//actionlisteners
		IDemoEventListener listener = new IDemoEventListener(this);
		canvas.addMouseListener(listener);

		// key listener needs requestfocusInwindow and setfocusable
		//to function properly
		canvas.addKeyListener(listener);	
		canvas.requestFocusInWindow();
		canvas.setFocusable(true);	//This should be true only for the canvas receiving the event, 
									//everything else should have setFocusable false
		
		quitButton.setFocusable(false);	
		quitButton.addActionListener(listener);			


	}

	private void populatePicture(){
		ArrayList<IRender> pics = canvas.getPictures();
		Car c = new Car(50, 50, "Ford", 9000, "SUV");
		pics.add(c);
		c.setImage(ImageStore.car);
		Airplane p = new Airplane(150, 50, "Boeing", 1200000, 350);
		pics.add(p);
		p.setImage(ImageStore.airplane);
		Bird b = new Bird(150, 150, "Eagle", 5, 10);
		pics.add(b);
		b.setImage(ImageStore.bird);
		Dog d = new Dog(50, 150, "Bulldog", 3, "white");
		pics.add(d);
		d.setImage(ImageStore.dog);



	}

	public IDemoCanvas getCanvas(){
		return canvas;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public JFrame getWindow() {
		return window;
	}
}
