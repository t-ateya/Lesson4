package model.idemo;

import java.awt.Rectangle;

import java.awt.Graphics2D;

public interface IRender {
	
	void render(Graphics2D g2);
	Rectangle getBoundingBox();
	void translate(int dx, int dy);
}
