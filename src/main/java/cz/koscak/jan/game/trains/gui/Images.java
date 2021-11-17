package cz.koscak.jan.game.trains.gui;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	
	public static final String RESOURCES_PATH = "src/main/resources/";
	public static final String IMAGES_PATH = RESOURCES_PATH + "images/";
	
	public static BufferedImage railsUpDown;
	public static BufferedImage railsLeftRight;
	public static BufferedImage railsCurveBottomRight;
	public static BufferedImage railsCurveRightUp;
	public static BufferedImage railsCurveUpLeft;
	public static BufferedImage railsCurveLeftBottom;
	public static BufferedImage railsCross;
	public static BufferedImage railsJunctionBottomToTopRight;
	public static BufferedImage railsJunctionBottomTopRight;
	public static BufferedImage train1Locomotive;
	public static BufferedImage train1Coach;
	public static BufferedImage train1Truck;
	public static BufferedImage train2Locomotive;
	public static BufferedImage train2Coach;
	public static BufferedImage train2Truck;
	public static BufferedImage train3Locomotive;
	public static BufferedImage train3Coach;
	public static BufferedImage train3Truck;
	
	public static void loadIamges() {
		
		try {
			railsUpDown = loadImage("rails.png");
			railsLeftRight = rotateImageBy90Degrees(railsUpDown);
			railsCurveBottomRight = loadImage("rails-curve.png");
			railsCurveRightUp = rotateImageBy90Degrees(railsCurveBottomRight);
			railsCurveUpLeft = rotateImageBy90Degrees(railsCurveRightUp);
			railsCurveLeftBottom = rotateImageBy90Degrees(railsCurveUpLeft);
			railsCross = loadImage("rails-cross.png");
			railsJunctionBottomToTopRight = loadImage("rails-junction.png");
			railsJunctionBottomTopRight = loadImage("rails-junction-2.png");
			train1Locomotive = loadImage("train-1-locomotive.png");
			train1Coach = loadImage("train-1-coach.png");
			train1Truck = loadImage("train-1-truck.png");
			train2Locomotive = loadImage("train-2-locomotive.png");
			train2Coach = loadImage("train-2-coach.png");
			train2Truck = loadImage("train-2-truck.png");
			train3Locomotive = loadImage("train-3-locomotive.png");
			train3Coach = loadImage("train-3-coach.png");
			train3Truck = loadImage("train-3-truck.png");
		} catch (IOException e) {
			System.err.println("ERROR WHILE LOADING IMAGES: " + e);
			e.printStackTrace();
		}
	
	}
	
	public static BufferedImage loadImage(String imageFileName) throws IOException {
		
		try {
			return ImageIO.read(new File(IMAGES_PATH + imageFileName));
		} catch (IOException e) {
			System.err.println("ERROR WHILE LOADING IMAGE: " + e);
			throw e;
		}
	
	}
	
	public static BufferedImage rotateImageBy90Degrees(BufferedImage image) {
		double rotationRequired = Math.PI / 2; //Math.toRadians(90);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op.filter(image, null);
	}
	
/*	public static BufferedImage rotateImageBy45Degrees(BufferedImage image) {
		double rotationRequired = Math.toRadians(45);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		return op.filter(image, null);
	}*/

}
