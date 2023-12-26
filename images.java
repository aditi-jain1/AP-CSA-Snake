package Snake;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class images {
	BufferedImage yellowSnake; {
		try {
			File file = new File("src/Snake/yellowSnake.png");
			FileInputStream fis = new FileInputStream(file);
			yellowSnake = ImageIO.read(file);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage purpleSnake; {
		try {
			File file = new File("src/Snake/purpleSnake.png");
			FileInputStream fis = new FileInputStream(file);
			purpleSnake = ImageIO.read(file);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	BufferedImage lotus2; {
		try {
			File file = new File("src/Snake/lotus2.png");
			FileInputStream fis = new FileInputStream(file);
			lotus2 = ImageIO.read(file);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	BufferedImage blueSnake; {
		try {
			File file = new File("src/Snake/blueSnake.png");
			FileInputStream fis = new FileInputStream(file);
			blueSnake = ImageIO.read(file);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	BufferedImage trophy; {
		try {
			File file = new File("src/Snake/trophy.png");
			FileInputStream fis = new FileInputStream(file);
			trophy = ImageIO.read(file);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	BufferedImage title; {
		try {
			File file = new File("src/Snake/title.png");
			FileInputStream fis = new FileInputStream(file);
			title = ImageIO.read(file);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	
	BufferedImage lotus; {
		try {
			File file = new File("src/Snake/lotus.png");
			FileInputStream fis = new FileInputStream(file);
			lotus = ImageIO.read(file);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	
	BufferedImage trophy2; {
		try {
			File file = new File("src/Snake/trophy2.png");
			FileInputStream fis = new FileInputStream(file);
			trophy2 = ImageIO.read(file);
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}
	

}
