package model.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageStore {
	
	public static BufferedImage airplane;
	public static BufferedImage car;
	public static BufferedImage dog;
	public static BufferedImage bird;

	static {
		airplane = readImage("model/image/plane.jpg", 80, 60);
		car = readImage("model/image/car.jpg", 80, 60);
		dog = readImage("model/image/dog.png", 70, 50);
		bird = readImage("model/image/bird.png", 70, 50);
	}
	public static BufferedImage readImage(String path, int width, int height){
		try{
			BufferedImage originalImage = ImageIO.read(new File(path));
			Image tmp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = resizedImage.createGraphics();
			g2.drawImage(tmp, 0, 0, null);
			g2.dispose();
			return resizedImage;
		}catch(Exception e){
			System.out.println("Image file load error:");
			e.printStackTrace();
		}

		return null;
	}

}
