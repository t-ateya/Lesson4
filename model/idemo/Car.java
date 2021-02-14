package model.idemo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Car extends Vehicle {

	private String type;
	public Car(int x, int y, String make, double price, String type){
		super(x,y,make,price);
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public String toString(){
		return ( "[Car] " + super.toString() + " Type = " + type);
	}

	@Override
	public String getSound(){
		return "[Car] vr rr roooooom ----";
	}
	
	@Override
	public void render(Graphics2D g2){
		g2.drawImage(getImage(), null, getX(), getY());
		g2.setColor(Color.red);
		g2.drawString("Type = " + type, getX(), getY());
	}
}
