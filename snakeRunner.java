package Snake;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import Snake.Sound;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Image;

import java.awt.GradientPaint;
import java.awt.image.BufferedImage;
import java.io.File;

import Snake.Particles2;
import utilities.GDV5;

public class snakeRunner extends GDV5 implements MouseListener{
	/* GameState 0 = splash page
	 * 1 = game
	 * 2= choose style
	 */
	private mouse playButton = new mouse(330, 265, 140, 90);
	private Point mouseLoc;
	private int mouseX;
	private int mouseY;
	private images yellowSnake = new images();
	private images purpleSnake = new images();
	private images blueSnake = new images();
	private images trophy = new images();
	private images title = new images();
	private images lotus = new images();
	private images trophy2 = new images();
	private int gameState = 0;
	private int initialSnakeLength= 5;
	private Color red = new Color (229,79,36);
	private Color green = new Color (73,197,39);
	private Color pink = new Color (238,117,92);
	private Color darkGreenShadow = new Color (78,122,235);
	private Color purple = new Color(156,108,224);
	private Color lightGreen = new Color(170,214,81);
	private Color blue = new Color(78,122,235);
	private Color darkGreen = new Color(162,209,73);
	private Color darkBlue = new Color(43,76,182);
	private Color navy = new Color(28,43,80);
	private Color skyBlue = new Color(112,200,250);
	private Color skyBlueLight = new Color(152,216,250);
	private Color skyBlueLight2 = new Color(135,207,250);
	private boolean switchPattern = false;
	private boolean createApples = true;
	private apple scoreboardApple = new apple(120,11);
	private int numberApples = 3;
	private int counter=0;
	private int movementDirection=1;
	private int previousDirection=1;
	private boolean createSnake = true;
	private ArrayList<snakeBody> snake = new ArrayList<snakeBody>();
	private ArrayList<apple> apples = new ArrayList<apple>();	
	private board[][] boardArray = new board[20][20];
	private boolean initializeBoard = true;
	private int applesEaten = 0;
	private apple splashApple = new apple(680,430);
	private boolean endGame = false;
	private ArrayList<apple> eatenApple = new ArrayList<apple>();
	private Color skyOrange = new Color(250,137,135);
	private Color skyYellow = new Color(250,224,187);
	private Color skyPeach = new Color(250,109,109);
	private GradientPaint skyGradient = new GradientPaint(400,0,blue, 400,500, skyBlue);
	private GradientPaint warmGradient = new GradientPaint(400,-100,skyOrange, 400,500, skyYellow);
	private Particles2[] appleParticles;
	private Particles[] wallCollisionParticle;
	private ArrayList<apple> poisonousApplesArray = new ArrayList<apple>();
	private int numPoisonousApples = 2;
	private boolean createPApples = false;
	boolean displayGameOver = false;
	private ArrayList<bush> bushes = new ArrayList<bush>();
	boolean remakeApple = true;
	boolean level2 = false;
	boolean underwaterMode = false;
	boolean level3 = false;
	
	public static void main(String[] args) {
		snakeRunner runner = new snakeRunner();
		runner.addMouseListener(runner);
		runner.start();
	}
	private int rowCount = -1;
	private int columnCount = 0;
	public void update() {
		mouseLoc = MouseInfo.getPointerInfo().getLocation();
		mouseX = mouseLoc.x;
		mouseY = mouseLoc.y;
		playButton();
		gameState0();
		gameState1();
		

	}
	
	public void gameState0() {
		if (gameState == 0) {
			//playButton.mouseClicked(null);
			if (KeysPressed[KeyEvent.VK_1]) {
				appleParticles = Particles2.makeParticles();
				wallCollisionParticle = Particles.makeParticles();
				gameState = 1;
				level2 = false;
				automateSnakeMovement = false;
				
			
			}
			if (KeysPressed[KeyEvent.VK_2]) {
				appleParticles = Particles2.makeParticles();
				wallCollisionParticle = Particles.makeParticles();
				gameState = 1;
				level3 = true;
				automateSnakeMovement = false;
				
			
			}
			if (KeysPressed[KeyEvent.VK_3]) {
				appleParticles = Particles2.makeParticles();
				wallCollisionParticle = Particles.makeParticles();
				gameState = 1;
				level2 = true;
				automateSnakeMovement = false;
				
			
			}
			if (KeysPressed[KeyEvent.VK_4]) {
				appleParticles = Particles2.makeParticles();
				wallCollisionParticle = Particles.makeParticles();
				gameState = 1;
				level2 = true;
				level3 = true;
				automateSnakeMovement = false;
				
			
			}
			
		}
	}
	public void gameState1() {
if (gameState == 1) {
			
			if (endGame == false) {
				if (initializeBoard) {
					fillBoardArray();
					previousDirection = 1;
					initializeBoard = false;
				}
				if (createSnake) {
					for (int i =0; i <initialSnakeLength; i++) {
						snakeBody x = new snakeBody(80-i*40,200);
						snake.add(x);
						if (i == 0) {
							snake.get(i).setFirstBlock();
						}
						if (i == initialSnakeLength-1) {
							snake.get(i).setLastBlock(true);
						}
					}
					createSnake = false;
					if (level2 == true) {
						bushes.add(new bush(360,40));
						bushes.add(new bush(360,80));
						bushes.add(new bush(360,120));
						bushes.add(new bush(360,120));
						bushes.add(new bush(240-40,280));
						bushes.add(new bush(240-40,320));
						bushes.add(new bush(240-40,360));
						bushes.add(new bush(240-40,400));
						bushes.add(new bush(240-40,440));
						bushes.add(new bush(240,440));
						bushes.add(new bush(280,440));
						bushes.add(new bush(320,440));
						bushes.add(new bush(360,440));
						bushes.add(new bush(360,440));
						bushes.add(new bush(440,640));
						bushes.add(new bush(480,640));
						bushes.add(new bush(520,640));
						bushes.add(new bush(560,640));
						bushes.add(new bush(600,640));
						bushes.add(new bush(600,680));
						bushes.add(new bush(600,720));
						bushes.add(new bush(760,400));
						bushes.add(new bush(720,400));
						bushes.add(new bush(0,760));
						bushes.add(new bush(0,80));
						bushes.add(new bush(0,120));
						bushes.add(new bush(80,680));
						bushes.add(new bush(120,680));
						bushes.add(new bush(640,120));
					}
					
				}
				checkSnakeWallCollision();
				System.out.print(bushes.size());
				if (createApples) {
					for (int i =0; i <numberApples; i++) {
						apple x = new apple(40*(int)(Math.random()*16+2),40*(int)(Math.random()*16+2));
						apples.add(x);
						createApples = false;
						apple.setUnderWaterMode(underwaterMode);
						snakeBody.setUnderWaterMode(underwaterMode);
					}
					
				}
				if (createPApples) {
					while (poisonousApplesArray.size() != numPoisonousApples) {
						apple x = new apple(40*(int)(Math.random()*16+2),40*(int)(Math.random()*16+2));
						poisonousApplesArray.add(x);
						//poisonousApplesArray.get(i).setPoisonousApple(true);
						//createPApples = false;
					}
					for (int i =0; i <numPoisonousApples; i++) {
						poisonousApplesArray.get(i).setPoisonousApple(true);
						//createPApples = false;
					}
				}
				
				moveSnake();
				for (int i = apples.size()-1; i>=0; i--) {
					if (level3 == true) {
						apples.get(i).moveApples();
					}
					if (snake.get(0).getXCoord()>= apples.get(i).getXCoord()-5 && snake.get(0).getXCoord()<= apples.get(i).getXCoord()+40 && snake.get(0).getYCoord()>= apples.get(i).getYCoord()-5 && snake.get(0).getYCoord()<= apples.get(i).getYCoord()+40) {
					//if (apples.get(i).getXCoord() == snake.get(0).getXCoord() && apples.get(i).getYCoord() == snake.get(0).getYCoord()) {
						Particles2.makeParticles2((int)apples.get(i).getXCoord(),(int)apples.get(i).getYCoord(), red);
						Particles2.setParticleSize(3);
						Sound.play();
						apple r = new apple(apples.get(i).getXCoord(), apples.get(i).getYCoord());
						//eatenApple.add(r);
						apples.remove(i);
						remakeApple = true;
						
						int tempX = -1;
						int tempY = -1;
						int tempCounter = 0;
						while (remakeApple) {
							tempX = 40*(int)(Math.random()*16+2);
							tempY = 40*(int)(Math.random()*16+2);
							tempCounter = 0;
							if (level2 == true) {
								for (int m = 0; m<bushes.size();m++) {
									if (tempX != bushes.get(m).getX() && tempY != bushes.get(m).getY()) {
										tempCounter++;
										System.out.println("stuck in for loop");
									}
								}
								if (tempCounter == bushes.size()) {
									remakeApple = false;
									System.out.println("stuck iif");
								}
							}
							if (level2 == false) {
								remakeApple = false;
							}
							
						}
						apple x = new apple(tempX, tempY);
						apples.add(x);
						applesEaten++;
				
						increaseSnakeLength();
					}
				}
				for (int i = poisonousApplesArray.size()-1; i>=0; i--) {
					if (poisonousApplesArray.get(i).getXCoord() == snake.get(0).getXCoord() && poisonousApplesArray.get(i).getYCoord() == snake.get(0).getYCoord()) {
						Sound.lifeLoss();
						Particles2.makeParticles2((int)poisonousApplesArray.get(i).getXCoord(),(int)poisonousApplesArray.get(i).getYCoord(), purple);
						Particles2.setParticleSize(3);
						apple r = new apple(poisonousApplesArray.get(i).getXCoord(), poisonousApplesArray.get(i).getYCoord());
						eatenApple.add(r);
						poisonousApplesArray.remove(i);
						int tempX = -1;
						int tempY = -1;
						int tempCounter = 0;
						remakeApple = true;
						while (remakeApple) {
							tempX = 40*(int)(Math.random()*16+2);
							tempY = 40*(int)(Math.random()*16+2);
							tempCounter = 0;
							if (level2 == true) {
								for (int m = 0; m<bushes.size();m++) {
									if (tempX != bushes.get(m).getX() && tempY != bushes.get(m).getY()) {
										tempCounter++;
										System.out.println("stuck in for loop");
									}
								}
								if (tempCounter == bushes.size()) {
									remakeApple = false;
									System.out.println("stuck iif");
								}
							}
							if (level2 == false) {
								remakeApple = false;
							}
							
						}
						apple x = new apple(tempX, tempY);
						poisonousApplesArray.add(x);
						applesEaten--;
				
						increaseSnakeLength();
					}
				}
				if (applesEaten == 5) {
					createPApples = true;
				}
			}
			Particles2.moveParticles();
			Particles.moveParticles();
			
			if (endGame) {
				if (Particles.getParticleSize() == 0) {
					snake = new ArrayList<snakeBody>();
					apples = new ArrayList<apple>();
					poisonousApplesArray = new ArrayList<apple>();
					createApples = true;
					createPApples = false;
					createSnake = true;
					initializeBoard = true;
					//applesEaten = 0;
					tempX = new ArrayList<Integer>();
					tempY = new ArrayList<Integer>();
					bushes = new ArrayList<bush>();
					turnDirections = new ArrayList<Integer>();
					countBlocksTurned = new ArrayList<Integer>();
					turnBlocks = new ArrayList<snakeBody>();
					eatenApple = new ArrayList<apple>();
					//gameState = 0;
					displayGameOver = true;
					mmm = false;
					automateSnakeMovement = false;
					level2 = false;
					level3 = false;
					//endGame = false;
				}
			}
		}
	}
	
	
	public void increaseSnakeLength() {
		if (snake.get(snake.size()-1).getBlockDirection()==1) {
			snake.get(snake.size()-1).setLastBlock(false);
			snakeBody x = new snakeBody(snake.get(snake.size()-1).getXCoord()-40,snake.get(snake.size()-1).getYCoord());
			x.setBlockDirection(1);
			x.setLastBlock(true);
			snake.add(x);
			
		}
		if (snake.get(snake.size()-1).getBlockDirection()==2) {
			snake.get(snake.size()-1).setLastBlock(false);
			snakeBody x = new snakeBody(snake.get(snake.size()-1).getXCoord()+40,snake.get(snake.size()-1).getYCoord());
			x.setBlockDirection(2);
			x.setLastBlock(true);
			snake.add(x);
		}
		if (snake.get(snake.size()-1).getBlockDirection()==3) {
			snake.get(snake.size()-1).setLastBlock(false);
			snakeBody x = new snakeBody(snake.get(snake.size()-1).getXCoord(),snake.get(snake.size()-1).getYCoord()-40);
			x.setBlockDirection(3);
			x.setLastBlock(true);
			snake.add(x);
		}
		if (snake.get(snake.size()-1).getBlockDirection()==4) {
			snake.get(snake.size()-1).setLastBlock(false);
			snakeBody x = new snakeBody(snake.get(snake.size()-1).getXCoord(),snake.get(snake.size()-1).getYCoord()+40);
			x.setBlockDirection(4);
			x.setLastBlock(true);
			snake.add(x);
		}

	}
	
	public void checkSnakeWallCollision() {
		if (!endGame) {
			if (automateSnakeMovement == false) {
				for (int i = 3; i<snake.size(); i++) {
					int x1 = snake.get(i).getXCoord();
					int y1 = snake.get(i).getYCoord();
					int x2 = x1+40;
					int y2 = y1+40;
					if (snake.get(0).getXCoord() <x2 && snake.get(0).getXCoord() > x1 &&  snake.get(0).getYCoord() <y2 && snake.get(0).getYCoord() > y1 ) {
						endGame = true;
						Sound.winSound();
						System.out.println("COLLISION");
						Particles.makeParticles2((int)snake.get(0).getXCoord(),(int)snake.get(0).getYCoord(), blue);
						Particles.setParticleSize(5);
					}
				}
			}
			for (int i = 0; i<bushes.size(); i++) {
				if (bushes.get(i).getX() == snake.get(0).getXCoord() &&bushes.get(i).getY() == snake.get(0).getYCoord()) {
					System.out.println("hit bush");
					endGame = true;
					Sound.winSound();
					Particles.makeParticles2((int)snake.get(0).getXCoord(),(int)snake.get(0).getYCoord(), blue);
					Particles.setParticleSize(5);
				}
			}
			if (snake.get(0).getBlockDirection()==1) {
				if (snake.get(0).getXCoord() >= 760) {
					System.out.println("hit wall");
					endGame = true;
					Sound.winSound();
					Particles.makeParticles2((int)snake.get(0).getXCoord(),(int)snake.get(0).getYCoord(), blue);
					Particles.setParticleSize(5);
				}
			}
			if (snake.get(0).getBlockDirection()==2) {
				if (snake.get(0).getXCoord() <= 20) {
					System.out.println("hit wall");
					endGame = true;
					Sound.winSound();
					
					Particles.makeParticles2((int)snake.get(0).getXCoord(),(int)snake.get(0).getYCoord(), blue);
					Particles.setParticleSize(5);
				}
			}
			if (snake.get(0).getBlockDirection()==3) {
				if (snake.get(0).getYCoord() >= 760) {
					System.out.println("hit wall");
					endGame = true;
					Sound.winSound();
					Particles.makeParticles2((int)snake.get(0).getXCoord(),(int)snake.get(0).getYCoord(), blue);
					Particles.setParticleSize(5);
				}
			}
			if (snake.get(0).getBlockDirection()==4) {
				if (snake.get(0).getYCoord() <= 60) {
					System.out.println("hit wall");
					endGame = true;
					Sound.winSound();
					Particles.makeParticles2((int)snake.get(0).getXCoord(),(int)snake.get(0).getYCoord(), blue);
					Particles.setParticleSize(5);
				}
			}
			
		}
		
	}
	
	private int eyeSizeIncrease = 20;
	private int eyeCounter=0;
	private int eyeSizeChange;
	private int eyeSizeAdd=1;
	private int eye1X = 407;
	private int eye1Y = 357;
	private int eye2X = 367;
	private int eye2Y = 362;
	private boolean subtract = false;
	private int tongueX = 640;
	private int tongueCounter = 0;
	private int tongueIncrease = 1;
	private int yellowSCounter =0;
	private int purpleSCounter = 0;
	private int blueSCounter = 0;
	private int outsideCircleX = 360;
	private int insideCircleX = 367;
	private boolean changeButtonColor = false;
	public void draw(Graphics2D win) {
		if (gameState == 0) {
			moveToggle();
			drawGameBoard(win, darkGreen, lightGreen);
			if (underwaterMode) {
				drawGameBoard(win, skyBlue, skyBlueLight2);
			}
			
			//win.setColor(skyBlue);
			win.setPaint(skyGradient);
			if (underwaterMode) {
				win.setPaint(warmGradient);
			}
			win.fillRect(0, 0, 800, 520);
			if (!underwaterMode) {
				win.drawImage(trophy.trophy, 10,250,240,240,this);
			}
			else {
				win.drawImage(trophy2.trophy2, 10,250,240,240,this);
			}
			win.setColor(navy);
			win.fillOval(740, 13, 40, 40);
			win.setFont(new Font("Helvetica", Font.BOLD, 30));
			win.setColor(skyBlue);
			if (underwaterMode) {
				win.setColor(skyOrange);
			}
			win.drawString("i", 755, 43);
			win.setColor(blue);
			win.fillPolygon(new int[]{0,0,500,540,545,520}, new int[] {520,440,400,420,470,520}, 6);
			win.fillOval(485,397,55,55);
			win.fillOval(476,450,70,70);
			win.fillOval(400, 350+eyeSizeIncrease, 50, 50);
			win.fillOval(360, 355+eyeSizeIncrease, 50, 50);
			win.setColor(Color.white);
			win.fillOval(407, 357+eyeSizeIncrease, 35, 35);
			win.fillOval(367, 362+eyeSizeIncrease, 35,35);
			win.setColor(darkBlue);
			win.fillRect(350,445,190,4);
			win.fillOval(500, 420, 5, 7);
			win.fillOval(520, 420, 5, 7);
			win.setColor(navy);
			win.fillOval(eye1X+eyeSizeAdd, eye1Y+eyeSizeAdd+eyeSizeIncrease, 20, 20);
			win.fillOval(eye2X+eyeSizeAdd, eye2X+eyeSizeAdd+eyeSizeIncrease,20,20);
			win.setColor(red);
			win.fillPolygon(new int[] {540,540, tongueX,tongueX}, new int[] {445,443, 440,450}, 4);
			//win.setColor();
			if (!underwaterMode) {
				splashApple.appleShiver();
				splashApple.drawSplashApple(win);
			}
			else {
				win.drawImage(lotus.lotus, 650, 400, 160, 160, this);
			}
			
			tongueCounter++;
			if (tongueCounter%3 == 0) {
				tongueX+=tongueIncrease;
			}
			if (tongueCounter%120 == 0) {
				tongueIncrease*=-1;
			}
			eyeCounter++;
			if ( eyeCounter%10==0) {
				if (subtract == false) {
					eyeSizeAdd++;
				}
				else {
					eyeSizeAdd--;
				}
			}
			if (eyeCounter%100 == 0) {
				subtract = !subtract;
			}
			
			yellowSCounter++;
			win.drawImage(yellowSnake.yellowSnake, 600-4*yellowSCounter,525,250,250,this);
			if (yellowSCounter == 250) yellowSCounter = 0;
			purpleSCounter++;
			win.drawImage(purpleSnake.purpleSnake, -400+5*purpleSCounter,445,350,350,this);
			if (purpleSCounter == 300) purpleSCounter = 0;
			blueSCounter++;
			win.drawImage(blueSnake.blueSnake, -400+6*blueSCounter,590,400,400,this);
			if (blueSCounter == 250) purpleSCounter = 0;
			if (blueSCounter == 400) {
				blueSCounter = 0;
			}
			
			win.drawImage(title.title, 130,-80,580,350,this);
			win.setFont(new Font("Helvetica", Font.BOLD, 30));
			win.setColor(navy);
			win.drawString("ADITI JAIN", 320, 180);
			//win.drawImage(fruits.fruits, -60,250,470,280,this);
			if (underwaterMode == false) {
				win.setColor(blue);
				win.fillRect(370,220,60,20);
				win.fillOval(360,220,20,20);
				win.fillOval(420,220,20,20);
				win.setColor(skyBlueLight);
				win.fillOval(outsideCircleX,210,40,40);
				win.setColor(skyBlue);
				win.fillOval(insideCircleX,217,26,26);
				
			}
			else {
				win.setColor(skyPeach);
				win.fillRect(370,220,60,20);
				win.fillOval(360,220,20,20);
				win.fillOval(420,220,20,20);
				win.setColor(new Color(250,195,178));
				win.fillOval(outsideCircleX,210,40,40);
				win.setColor(skyOrange);
				win.fillOval(insideCircleX,217,26,26);
				win.setColor(skyOrange);
				
			}
			//changeButtonColor = false;
			
			win.drawImage(lotus.lotus, 285, 195, 70,70, this);
			win.setColor(darkGreen);
			win.fillOval(460, 200, 45,45);
			drawLevels(win);
			
		}
		if (gameState == 1) {
			//checkSnakeWallCollision();
			counter++;
			if (automateSnakeMovement == true) {
				if (KeysPressed[KeyEvent.VK_X]) {
					endGame = true;
					System.out.println("COLLISION");
					//Particles.makeParticles2((int)snake.get(0).getXCoord(),(int)snake.get(0).getYCoord(), blue);
					//Particles.setParticleSize(5);
				}
			}
			if (automateSnakeMovement == true && endGame == true) {
				snake = new ArrayList<snakeBody>();
				apples = new ArrayList<apple>();
				poisonousApplesArray = new ArrayList<apple>();
				createApples = true;
				createPApples = false;
				createSnake = true;
				initializeBoard = true;
				//applesEaten = 0;
				tempX = new ArrayList<Integer>();
				tempY = new ArrayList<Integer>();
				bushes = new ArrayList<bush>();
				turnDirections = new ArrayList<Integer>();
				countBlocksTurned = new ArrayList<Integer>();
				turnBlocks = new ArrayList<snakeBody>();
				eatenApple = new ArrayList<apple>();
				//gameState = 0;
				displayGameOver = true;
				mmm = false;
				automateSnakeMovement = false;
				level2 = false;
				level3 = false;
				//endGame = false;
				gameState = 5;
			}
			
			drawGameBoard(win, darkGreen, lightGreen);
			if (underwaterMode) {
				drawGameBoard(win, skyBlue, skyBlueLight2);
			}
			ArrayList<snakeBody> snakeShadow = new ArrayList<snakeBody>();
			for (bush b: bushes) {
				b.drawBush(win);
			}
			for (int i = 0; i<snake.size(); i++) {
				snakeBody temp = new snakeBody(snake.get(i).getXCoord(), snake.get(i).getYCoord()+10);
				snakeShadow.add(temp);
			}
			for (int i = 0; i<turnBlocks.size(); i++) {
				snakeBody temp = new snakeBody(turnBlocks.get(i).getXCoord(), turnBlocks.get(i).getYCoord()+10);
				snakeShadow.add(temp);
			}
			for (int i = 0; i <snakeShadow.size(); i++) {
				if (endGame == false) {
					snakeShadow.get(i).drawShadow(win);
				}
			}
			for (int a = 0; a<apples.size(); a++) {
				apples.get(a).drawApple(win);
				apples.get(a).appleShiver();
			}
			for (int m = 0; m<poisonousApplesArray.size(); m++) {
				poisonousApplesArray.get(m).drawApple(win);
				poisonousApplesArray.get(m).appleShiver();
			}
			for (Particles2 p:appleParticles) {
				p.draw(win, red);
			}
			for (Particles p:wallCollisionParticle) {
				p.draw(win, blue);
			}
			
			
			for (int i = 0; i<snake.size(); i++) {
				if (endGame == false) {
					snake.get(i).drawBody(win);
				}
				
			}
			if (!endGame) {
				if (eatenApple.size() > 0) {
					int snakeIndex = snake.size()-1;
					for (int i = eatenApple.size()-1; i>=0; i--) {
						eatenApple.get(i).drawEatenApple(win);
						if (eatenApple.get(i).getXCoord() == snake.get(snakeIndex).getXCoord() && eatenApple.get(i).getYCoord() == snake.get(snakeIndex).getYCoord() ) {
							System.out.println("Apple destroy");
							eatenApple.remove(i);
						}
					}
					
				}
			}
			if (automateSnakeMovement == true) {
				win.setColor(blue);
				win.fillOval(760,5,30,30);
				win.setFont(new Font("Helvetica", Font.BOLD, 30));
				win.setColor(skyBlue);
				win.drawString("x", 766, 28);
			}
			
			
			win.setFont(new Font("Helvetica", Font.BOLD, 100));
			drawTurnBlock(win);
			win.setFont(new Font("Helvetica", Font.BOLD, 30));
			win.setColor(Color.white);
			win.drawString(""+applesEaten, 230, 32);
			//win.drawString(""+snake.size(), 230, 100);
			/*
			for (int i=0; i<snake.size();i++) {
				snake.get(i).drawBody(win);
			}
			*/
			displayGameOverPage(win);
			if (endGame == false) {
				for (int i = 0; i<snake.size(); i++) {
					snake.get(i).drawEyes(win);
				}
			}
		}
		if (gameState == 5) {
			counter5++;
			drawGameBoard(win, darkGreen, lightGreen);
			if (underwaterMode) {
				drawGameBoard(win, skyBlue, skyBlueLight2);
			}
			
			//win.setColor(skyBlue);
			win.setPaint(skyGradient);
			if (underwaterMode) {
				win.setPaint(warmGradient);
			}
			win.fillRect(0, 0, 800, 520);
			yellowSCounter++;
			win.drawImage(yellowSnake.yellowSnake, 600-4*yellowSCounter,525,250,250,this);
			if (yellowSCounter == 250) yellowSCounter = 0;
			purpleSCounter++;
			win.drawImage(purpleSnake.purpleSnake, -400+5*purpleSCounter,445,350,350,this);
			if (purpleSCounter == 300) purpleSCounter = 0;
			blueSCounter++;
			win.drawImage(blueSnake.blueSnake, -400+6*blueSCounter,590,400,400,this);
			if (blueSCounter == 250) purpleSCounter = 0;
			if (blueSCounter == 400) {
				blueSCounter = 0;
			}
			win.setFont(new Font("Helvetica", Font.BOLD, 50));
			win.setColor(navy);
			win.drawString("INSTRUCTIONS", 230, 60);
			win.setFont(new Font("Helvetica", Font.ITALIC, 25));
			win.drawString("Maneuver your snake to eat as many apples as possible!", 100, 120);
			win.setFont(new Font("Helvetica", Font.ITALIC, 20));
			win.drawString("Use the arrow keys to move the snake head.", 100, 150);
			win.drawString("Eat the red apples while avoiding the purple apples!", 100, 180);
			win.drawString("Don't hit the bushes or your snake will die", 100, 210);
			if (underwaterMode == false) {
				win.setColor(skyBlue);
				if (changeButtonColor) {
					win.setColor(skyBlueLight);
				}
				win.fillRect(340+10, 275, 100,70);
				win.fillRect(330+10, 275, 10,70);
				win.fillRect(440+10, 275, 10,70);
				win.fillRect(340+10, 265, 100,10);
				win.fillRect(340+10, 345, 100,10);
				win.fillOval(330+10, 265,20,20);
				win.fillOval(430+10, 265,20,20);
				win.fillOval(330+10, 265+70,20,20);
				win.fillOval(430+10, 265+70,20,20);
				win.setColor(skyBlueLight);
				if (changeButtonColor) {
					win.setColor(blue);
				}
				win.fillPolygon(new int[]{366+10,366+10,420+10}, new int[] {285,340,310}, 3);
			}
			else {
				win.setColor(skyOrange);
				if (changeButtonColor) {
					win.setColor(skyPeach);
				}
				win.fillRect(340+10, 275, 100,70);
				win.fillRect(330+10, 275, 10,70);
				win.fillRect(440+10, 275, 10,70);
				win.fillRect(340+10, 265, 100,10);
				win.fillRect(340+10, 345, 100,10);
				win.fillOval(330+10, 265,20,20);
				win.fillOval(430+10, 265,20,20);
				win.fillOval(330+10, 265+70,20,20);
				win.fillOval(430+10, 265+70,20,20);
				win.setColor(new Color(250,195,178));
				if (changeButtonColor) {
					win.setColor(skyOrange);
				}
				win.fillPolygon(new int[]{366+10,366+10,420+10}, new int[] {285,340,310}, 3);
			}
		}
		
		
	}
	private int levelMargin = 50;
	public void drawLevels(Graphics2D win) {
		if (underwaterMode) {
			win.setColor(navy);
			win.fillRect(260+levelMargin, 290,180 ,70);
			win.fillOval(229+levelMargin, 290,70,70);
			win.fillOval(400+levelMargin, 290,70,70);
			win.setColor(new Color(250,195,178));
			win.fillRect(270 +levelMargin, 300, 50, 50);
			win.fillOval(240 +levelMargin,300,50,50);
			win.setColor(Color.pink);
			win.fillOval(290 +levelMargin,300,50,50);
			win.fillRect(320 +levelMargin, 300,50,50);
			win.setColor(skyOrange);
			win.fillOval(340 +levelMargin,300,50,50);
			win.fillRect(370+levelMargin, 300,50,50);
			win.setColor(skyPeach);
			win.fillOval(390 +levelMargin,300,50,50);
			win.fillRect(420 +levelMargin, 300,20,50);
			win.fillOval(410 +levelMargin,300,50,50);
			win.setFont(new Font("Helvetica", Font.BOLD, 30));
			win.setColor(skyPeach);
			win.drawString("1", 310, 335);
			win.setColor(skyOrange);
			win.drawString("2", 360, 335);
			win.setColor(Color.pink);
			win.drawString("3", 410, 335);
			win.setColor(new Color(250,195,178));
			win.drawString("4", 465, 335);
		}
		else {
			win.setColor(navy);
			win.fillRect(260+levelMargin, 290,180 ,70);
			win.fillOval(229+levelMargin, 290,70,70);
			win.fillOval(400+levelMargin, 290,70,70);
			win.setColor(new Color(195,231,240));
			win.fillRect(270 +levelMargin, 300, 50, 50);
			win.fillOval(240 +levelMargin,300,50,50);
			win.setColor(skyBlueLight);
			win.fillOval(290 +levelMargin,300,50,50);
			win.fillRect(320 +levelMargin, 300,50,50);
			win.setColor(skyBlue);
			win.fillOval(340 +levelMargin,300,50,50);
			win.fillRect(370+levelMargin, 300,50,50);
			win.setColor(blue);
			win.fillOval(390 +levelMargin,300,50,50);
			win.fillRect(420 +levelMargin, 300,20,50);
			win.fillOval(410 +levelMargin,300,50,50);
			win.setFont(new Font("Helvetica", Font.BOLD, 30));
			win.setColor(blue);
			win.drawString("1", 310, 335);
			win.setColor(skyBlue);
			win.drawString("2", 360, 335);
			win.setColor(skyBlueLight);
			win.drawString("3", 410, 335);
			win.setColor(new Color(195,231,240));
			win.drawString("4", 465, 335);
		}
		
	}
	
	public void moveToggle() {
		if (underwaterMode) {
			if (insideCircleX != 367) {
				insideCircleX-=2;
				outsideCircleX-=2;
			}
		}
		else {
			if (outsideCircleX != 400) {
				insideCircleX+=2;
				outsideCircleX+=2;
			}
		}
	}
	
	public void displayGameOverPage(Graphics2D win) {
		if (displayGameOver) {
			win.setColor(navy);
			win.fillRect(150, 150, 500, 500);
			
			snakeBody.drawDeadSnake(win);
			win.setFont(new Font("Helvetica", Font.BOLD, 100));
			win.setColor(blue);
			win.drawString(""+applesEaten, 445, 310);
			if (KeysPressed[KeyEvent.VK_ENTER]) {
				gameState = 0;
				endGame = false;
				displayGameOver = false;
				applesEaten = 0;
			}
		}
		
	}
	
	public void fillBoardArray() {
		for (int row = 0; row<20; row++) {
			for (int column = 0; column<20; column++) {
				board temporary = new board(column*40, row*40, 0);
				boardArray[row][column] = temporary;
				
			}
		}
	}
	
	public void drawCoordinates(Graphics2D win) {
		for (int row = 0; row<20; row++) {
			for (int column = 0; column<20; column++) {
				win.setFont(new Font("Helvetica", Font.BOLD, 10));
				win.drawString ("" + boardArray[row][column].getX() + ", "+ boardArray[row][column].getY(), column*40, row*40);
			}
		}
	}
	
	public void drawTurnBlock(Graphics2D win) {
		if (endGame == false) {
			for (int i = 0; i<turnBlocks.size(); i++) {
				turnBlocks.get(i).drawBody(win);
				
			}
		}
	}
	
	public void drawGameBoard(Graphics2D win, Color dark, Color light) {
		
		for (int y = 0; y<40; y++) {
			switchPattern = !switchPattern;
			for (int i = 0; i<40; i++) {
				if (switchPattern) {
					if (i%2 == 0) {
						win.setColor(dark);
						win.fillRect(40*i, y*40, 40, 40);
					}
					else {
						win.setColor(light);
						win.fillRect(40*i, y*40, 40, 40);
					}
				}
				else {
					if (i%2 != 0) {
						win.setColor(dark);
						win.fillRect(40*i, y*40, 40, 40);
					}
					else {
						win.setColor(light);
						win.fillRect(40*i, y*40, 40, 40);
					}
				}
			}
		}
		win.setColor(navy);
		win.fillRect(0,0, 800, 40);
		scoreboardApple.drawScoreApple(win);
	}
	
	public void printDirections() {
		for (board[] row: boardArray) {
			for (board column: row) {
				if (column.getDirection() != 0 && column.getDidTurn()) {
					System.out.println("" +column.getX() + ", "+ column.getY() + " = " +column.getDirection());
				}
			}
		}
	}
	private boolean mmm = false;
	private boolean automateSnakeMovement = false;
	private ArrayList<Integer> tempX = new ArrayList<Integer>();
	private ArrayList<Integer> tempY = new ArrayList<Integer>();
	private ArrayList<Integer> turnDirections = new ArrayList<Integer>();
	private ArrayList<Integer> countBlocksTurned = new ArrayList<Integer>();
	private ArrayList<snakeBody> turnBlocks = new ArrayList<snakeBody>();
	private boolean activateTurn = false;
	public void moveSnake() {
		if (automateSnakeMovement == false) {
			if (KeysPressed[KeyEvent.VK_UP]) {
				if (movementDirection != 3) {
					movementDirection =4;
				}
			}
			if (KeysPressed[KeyEvent.VK_DOWN]) {
				if (movementDirection != 4) {
					movementDirection =3;
					
				}
					
			}
			if (KeysPressed[KeyEvent.VK_LEFT]) {
				if (movementDirection != 1) {
					movementDirection =2;
					
				}
			}
			if (KeysPressed[KeyEvent.VK_RIGHT]) {
				if (movementDirection != 2) {
					movementDirection =1;
					
				}
			}
		}
		if (automateSnakeMovement) {
			snake.get(0).automateSnake(true);
			if (snake.get(0).getXCoord() > apples.get(0).getXCoord()) {
				if (movementDirection != 1) {
					movementDirection =2;
				}
			}
			else if (snake.get(0).getXCoord() < apples.get(0).getXCoord()) {
				if (movementDirection != 2) {
					movementDirection =1;
				}
			}
			else if (snake.get(0).getYCoord() < apples.get(0).getYCoord()) {
				if (movementDirection != 4) {
					movementDirection =3;
				}
			}	
			else  {
				if (movementDirection != 3) {
					movementDirection =4;
				}
			}
		}
		if (snake.get(0).getXCoord()%40 == 0 && snake.get(0).getYCoord()%40 == 0) {
			if (previousDirection != movementDirection) {
				System.out.println("U");
				tempX.add(snake.get(0).getXCoord());
				tempY.add(snake.get(0).getYCoord());
				snakeBody x = new snakeBody(snake.get(0).getXCoord(), snake.get(0).getYCoord());
				turnBlocks.add(x);
				turnDirections.add(movementDirection);
				countBlocksTurned.add(0);
				activateTurn = true;
			}
			if (tempX.size()==0 && tempY.size() == 0 && turnDirections.size()==0 && countBlocksTurned.size() == 0) {
				System.out.println("UF");
				tempX.add(0);
				tempY.add(0);
				turnDirections.add(1);
				countBlocksTurned.add(5000);
				snakeBody x = new snakeBody(-100, -100);
				turnBlocks.add(x);
			}
			previousDirection = movementDirection;
		}
		for (int i =0; i<snake.size();i++) {
			for (int m = tempX.size()-1; m>0; m--) {
				if (tempX.size() >= 2) {
					if (snake.get(i).getXCoord() == tempX.get(m) && snake.get(i).getYCoord() == tempY.get(m)) {
						snake.get(i).setBlockDirection(turnDirections.get(m));
						mmm=true;
						countBlocksTurned.set(m, countBlocksTurned.get(m)+1);
						if (i==snake.size() -1) {
							activateTurn = false;
						}
					}
				}
				if (countBlocksTurned.get(m)>=snake.size()) {
					
					tempX.remove(m);
					tempY.remove(m);
					turnDirections.remove(m);
					countBlocksTurned.remove(m);
					turnBlocks.remove(m);
				}
			}
			
			if (mmm==false) {
				snake.get(i).setBlockDirection(1);
			}
			snake.get(i).turn(snake.get(i).getBlockDirection());
		}
	}
	
	public void playButton() {
		if (gameState == 5) {
			if (mouseX>= 610 && mouseX<=735 && mouseY>=293 && mouseY<=384) {
				changeButtonColor = true;
			}
			else {
				changeButtonColor = false;
			}
		}
	}
	
	


	private int counter5 = 0;

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//win.drawRect(360, 210,80,43);
		if (gameState == 0) {
			if (arg0.getX() >= 360 && arg0.getX()<=440 && arg0.getY() >= 210 && arg0.getY() <= 253) {
				System.out.println("djshdjhsk");
				underwaterMode = !underwaterMode;
				
			}
			//(740, 13, 40, 40);
			if (arg0.getX() >= 740 && arg0.getX()<=780 && arg0.getY() >= 13 && arg0.getY() <= 53) {
				gameState = 5;
				
			}
			if (arg0.getX() >= 330 && arg0.getX() <= 470 && arg0.getY() <= 265+90 && arg0.getY() >= 265) {
				changeButtonColor = true;
				System.out.println("smsnkdnsj");
				
			}
		}
		if (gameState == 5) {
			if (arg0.getX() >= 330 && arg0.getX() <= 470 && arg0.getY() <= 265+90 && arg0.getY() >= 265) {
					gameState = 1;
					automateSnakeMovement = true;
					appleParticles = Particles2.makeParticles();
					wallCollisionParticle = Particles.makeParticles();
					gameState = 1;
					level2 = false;
			}
		
			if (arg0.getX()<= 50 && arg0.getY()<=50) {
				gameState = 0;
			}
			
			
		}
		
	}




	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if (gameState == 0) {
			if (arg0.getY()> 400) {
				System.out.println("sajhadkadkas");
			}
			if (arg0.getXOnScreen() >= 330 && arg0.getXOnScreen() <= 470 && arg0.getYOnScreen()  <= 265+90 && arg0.getYOnScreen() >= 265) {
				changeButtonColor = true;
				System.out.println("smsnkdnsj");
				
			}
		}
		
	}




	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

		if (gameState == 0) {
			if (arg0.getY()> 400) {
				System.out.println("s");
			}
			if (arg0.getX() >= 330 && arg0.getX() <= 470 && arg0.getY()  <= 265+90 && arg0.getY() >= 265) {
				changeButtonColor = true;
				System.out.println("sm");
				
			}
		}
		
	}




	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

package Snake;
import utilities.GDV5;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;


public class snakeBody extends Rectangle{
	private int xCoord;
	private int yCoord;
	private static apple scoreBoardRedApple = new apple(305,370);
	private static images trophy = new images();
	private static images trophy2 = new images();
	private Color blue = new Color(78,122,235);
	private static Color snakeBlue = new Color(78,122,235);
	private Color darkBlue = new Color(43,76,182);
	private static Color darkBlue2 = new Color(43,76,182);
	private int blockDirection;
	private Color darkGreen = new Color (140,199,107);
	private boolean firstBlock = false;
	private boolean lastBlock = false;
	private static boolean underwaterMode = false;
	private static int nonAutomateSpeed = 5;
	private static int blockSpeed = nonAutomateSpeed;
	private static int automateSpeed = 4;
	public snakeBody(int xCoordinate, int yCoordinate) {
		super(xCoordinate,yCoordinate,40, 40);
		xCoord = xCoordinate;
		yCoord = yCoordinate;
	}
	public void setBlockDirection(int x) {
		blockDirection = x;
	}
	
	public void setFirstBlock() {
		firstBlock = true;
	}
	public void setLastBlock(boolean m) {
		lastBlock = m;
	}
	public boolean getFirstBlock() {
		return firstBlock;
	}
	public boolean getLastBlock() {
		return lastBlock;
	}
	public int getBlockDirection() {
		return blockDirection;
	}
	
	public void drawBody(Graphics2D win) {
	
		win.setColor(blue);
		win.fillRect(xCoord, yCoord, 40, 40);
		if (firstBlock == true) {
			if (blockDirection == 1) {
				win.setColor(blue);
				win.fillOval(xCoord+20, yCoord, 40, 40);
				win.fillOval(xCoord+10, yCoord-10, 30,30);
				win.fillOval(xCoord+10, yCoord+20, 30,30);
				win.setColor(Color.white);
				win.fillOval(xCoord+15, yCoord-5, 20,20);
				win.fillOval(xCoord+15, yCoord+25, 20,20);
				win.setColor(darkBlue);
				win.fillOval(xCoord+25, yCoord+2, 10, 10);
				win.fillOval(xCoord+25, yCoord+31, 10, 10);
			}
			if (blockDirection == 2) {
				win.setColor(blue);
				win.fillOval(xCoord-20, yCoord, 40, 40);
				win.fillOval(xCoord+10, yCoord-10, 30,30);
				win.fillOval(xCoord+10, yCoord+20, 30,30);
				win.setColor(Color.white);
				win.fillOval(xCoord+15, yCoord-5, 20,20);
				win.fillOval(xCoord+15, yCoord+25, 20,20);
				win.setColor(darkBlue);
				win.fillOval(xCoord+25, yCoord+2, 10, 10);
				win.fillOval(xCoord+25, yCoord+31, 10, 10);
			}
			if (blockDirection == 3) {
				win.setColor(blue);
				win.fillOval(xCoord, yCoord+20, 40, 40);
				win.fillOval(xCoord-10, yCoord+10, 30,30);
				win.fillOval(xCoord+20, yCoord+10, 30,30);
				win.setColor(Color.white);
				win.fillOval(xCoord-5, yCoord+15, 20,20);
				win.fillOval(xCoord+25, yCoord+15, 20,20);
				win.setColor(darkBlue);
				win.fillOval(xCoord+2, yCoord+25, 10, 10);
				win.fillOval(xCoord+31, yCoord+25, 10, 10);
			}
			if (blockDirection == 4) {
				win.setColor(blue);
				win.fillOval(xCoord, yCoord-20, 40, 40);
				win.fillOval(xCoord-10, yCoord+10, 30,30);
				win.fillOval(xCoord+20, yCoord+10, 30,30);
				win.setColor(Color.white);
				win.fillOval(xCoord-5, yCoord+15, 20,20);
				win.fillOval(xCoord+25, yCoord+15, 20,20);
				win.setColor(darkBlue);
				win.fillOval(xCoord+2, yCoord+25, 10, 10);
				win.fillOval(xCoord+31, yCoord+25, 10, 10);
			}
		}
		win.setColor(blue);
		if (lastBlock == true) {
			if (blockDirection == 1) {
				win.fillOval(xCoord-20, yCoord, 40, 40);
			}
			if (blockDirection == 2) {
				win.fillOval(xCoord+20, yCoord, 40, 40);
			}
			if (blockDirection == 3) {
				win.fillOval(xCoord, yCoord-20, 40, 40);
			}
			if (blockDirection == 4) {
				win.fillOval(xCoord, yCoord+20, 40, 40);
			}
		}
		//win.fillOval(xCoord+20, yCoord, 40, 40);
		//win.fillOval(xCoord-20, yCoord, 40, 40);
	}
	
	public void drawShadow(Graphics2D win) {
		win.setColor(darkGreen);
		win.fillRect(xCoord, yCoord, 40, 40);
	}
	public void drawEyes(Graphics2D win) {
		if (firstBlock == true) {
			if (blockDirection == 1) {
				win.setColor(blue);
				win.fillOval(xCoord+20, yCoord, 40, 40);
				win.fillOval(xCoord+10, yCoord-10, 30,30);
				win.fillOval(xCoord+10, yCoord+20, 30,30);
				win.setColor(Color.white);
				win.fillOval(xCoord+15, yCoord-5, 20,20);
				win.fillOval(xCoord+15, yCoord+25, 20,20);
				win.setColor(darkBlue);
				win.fillOval(xCoord+25, yCoord+2, 10, 10);
				win.fillOval(xCoord+25, yCoord+31, 10, 10);
			}
			if (blockDirection == 2) {
				win.setColor(blue);
				win.fillOval(xCoord-20, yCoord, 40, 40);
				win.fillOval(xCoord+10, yCoord-10, 30,30);
				win.fillOval(xCoord+10, yCoord+20, 30,30);
				win.setColor(Color.white);
				win.fillOval(xCoord+15, yCoord-5, 20,20);
				win.fillOval(xCoord+15, yCoord+25, 20,20);
				win.setColor(darkBlue);
				win.fillOval(xCoord+15, yCoord+2, 10, 10);
				win.fillOval(xCoord+15, yCoord+31, 10, 10);
			}
			if (blockDirection == 3) {
				win.setColor(blue);
				win.fillOval(xCoord, yCoord+20, 40, 40);
				win.fillOval(xCoord-10, yCoord+10, 30,30);
				win.fillOval(xCoord+20, yCoord+10, 30,30);
				win.setColor(Color.white);
				win.fillOval(xCoord-5, yCoord+15, 20,20);
				win.fillOval(xCoord+25, yCoord+15, 20,20);
				win.setColor(darkBlue);
				win.fillOval(xCoord+2, yCoord+25, 10, 10);
				win.fillOval(xCoord+31, yCoord+25, 10, 10);
			}
			if (blockDirection == 4) {
				win.setColor(blue);
				win.fillOval(xCoord, yCoord-20, 40, 40);
				win.fillOval(xCoord-10, yCoord+10, 30,30);
				win.fillOval(xCoord+20, yCoord+10, 30,30);
				win.setColor(Color.white);
				win.fillOval(xCoord-5, yCoord+15, 20,20);
				win.fillOval(xCoord+25, yCoord+15, 20,20);
				win.setColor(darkBlue);
				win.fillOval(xCoord+2, yCoord+15, 10, 10);
				win.fillOval(xCoord+31, yCoord+15, 10, 10);
			}
		}
	}
	public void move(int direction) {
		if (direction == 1) {
			xCoord++;
		}
		if (direction == 2) {
			xCoord--;
		}
		if (direction == 3) {
			yCoord++;
		}
		if (direction == 4) {
			yCoord--;
		}
	}
	
	public void automateSnake(boolean mm) {
		if (mm == true) {
			blockSpeed = automateSpeed;
		}
	}
	public static void setUnderWaterMode(boolean isUnderWater) {
		underwaterMode = isUnderWater;
	}
	public void turn(int direction) {
		if (direction == 1) {
			xCoord+=blockSpeed;
		}
		if (direction == 2) {
			xCoord-=blockSpeed;
		}
		if (direction == 3) {
			yCoord+=blockSpeed;
		}
		if (direction == 4) {
			yCoord-=blockSpeed;
		}
	}
	private static int eyeCounter = 0;
	private static int timeCounter = 0;
	private static int movementDirection = 1;
	private static int eyeCounter2 = 0;
	private static int movementDirection2 =1;
	
	public static void drawDeadSnake(Graphics2D win) {
		timeCounter++;
		if (timeCounter % 1==0) {
			eyeCounter+= movementDirection;
		}
		if (eyeCounter%20==0) {
			movementDirection*=-1;
		}
		if (timeCounter % 5==0) {
			eyeCounter2+= movementDirection2;
		}
		if (eyeCounter2%13==0) {
			movementDirection2*=-1;
		}
		win.setColor(snakeBlue);
		win.fillRect(250, 400+80, 300, 60);
		win.fillOval(220,400+80,60,60);
		win.fillOval(520,400+80,60,60);
		win.fillOval(470, 370+80, 60, 60);
		win.fillOval(480, 440+80, 40, 40);
		win.setColor(Color.white);
		win.fillOval(480,380+80,40,40);
		win.fillOval(487,445+80,25,25);
		win.setColor(darkBlue2);
		win.fillOval(485,385+80,30,30);
		win.fillOval(490, 448+80,19,19);
		win.setColor(snakeBlue);
		win.fillRect(480,380+80, eyeCounter,40);
		win.fillRect(520-eyeCounter,380+80, eyeCounter,40);
		win.fillRect(487+25-eyeCounter2, 445+80, eyeCounter2, 25);
		win.fillRect(487, 445+80, eyeCounter2, 25);
		win.setColor(darkBlue2);
		win.fillOval(550, 415+80, 8,8);
		win.fillOval(550, 440+80, 8,8);
		if (underwaterMode == false) {
			win.drawImage(trophy.trophy, 275, 170, 170,170, null);
		}
		else {
			win.drawImage(trophy2.trophy2, 275, 170, 170,170, null);
		}
		
		//scoreBoardRedApple.drawGameOverApple(win);
		//scoreBoardRedApple.appleShiver();
	
	}
	
	public int getXCoord() {
		return xCoord;
	}
	public int getYCoord() {
		return yCoord;
	}

}
