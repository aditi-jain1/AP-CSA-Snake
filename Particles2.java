package Snake;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import utilities.GDV5;

public class Particles2 extends Rectangle{
	private static int numParticles = 100;
	private static Particles2[] shimmerEffect = new Particles2[numParticles];
	private static int dxeee;
	private static int dyeee;
	private static int particleSize=2;

	public Particles2(int x, int y, Color c, int dx, int dy, int size) {
		super(x,y,size, size);
	}
	
	public static Particles2[] makeParticles() {
		for (int i=0; i<numParticles; i++) {
			dxeee = randomInt(-200,-300);
			dyeee = randomInt(-200,-300);
			shimmerEffect[i] = new Particles2(dxeee,dyeee, Color.white, dxeee, dyeee, randomInt(1,4));
			particleSize = 5;
		}
		return shimmerEffect;
	}
	private static int counter = 0;
	private static int speed = 1;
	public static void moveParticles() {
		counter++;
 		for (int i=0; i<numParticles; i++) {
 			if (i<numParticles/8) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x,shimmerEffect[i].y+speed, Color.white, 1,1,particleSize);
 			}
 			else if (i<2*(numParticles/8)) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x+speed,shimmerEffect[i].y, Color.white, 1,1,particleSize);
 			}
 			else if (i<3*(numParticles/8)) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x-speed,shimmerEffect[i].y, Color.white, 1,1,particleSize);
 			}
 			else if (i<4*(numParticles/8)) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x-speed,shimmerEffect[i].y-speed, Color.white, 1,1,particleSize);
 			}
 			else if (i<5*(numParticles/8)) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x+speed,shimmerEffect[i].y+speed, Color.white, 1,1,particleSize);
 			}
 			else if (i<6*(numParticles/8)) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x-speed,shimmerEffect[i].y+speed, Color.white, 1,1,particleSize);
 			}
 			else if (i<8*(numParticles/8)) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x+speed,shimmerEffect[i].y-speed, Color.white, 1,1,particleSize);
 			}
 			else  {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x,shimmerEffect[i].y-speed, Color.white, 1,1,particleSize);
 			}
 		}
 		/*
 		if (counter%8==0) {
 			speed = -speed;
 		}	
 		*/
 		if (counter%40==0 && particleSize != 0) {
 			particleSize--;
 		}
 	}
	
	
	public static void moveParticles2() {
		counter++;
 		for (int i=0; i<numParticles; i++) {
 			if (i<numParticles/4) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x,shimmerEffect[i].y+speed, Color.white, 1,1,particleSize);
 			}
 			else if (i<2*(numParticles/4)) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x+speed,shimmerEffect[i].y, Color.white, 1,1,particleSize);
 			}
 			else if (i<3*(numParticles/4)) {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x-speed,shimmerEffect[i].y, Color.white, 1,1,particleSize);
 			}
 			else  {
 				shimmerEffect[i] = new Particles2(shimmerEffect[i].x,shimmerEffect[i].y-speed, Color.white, 1,1,particleSize);
 			}
 			shimmerEffect[i] = new Particles2(shimmerEffect[i].x,shimmerEffect[i].y+3, Color.white, 1,1,particleSize);
 		}
 		/*
 		if (counter%8==0) {
 			speed = -speed;
 		}	
 		
 		*/
 	}
	
	public static void setParticleSize(int size) {
		particleSize = size;
		counter = 0;
	}
	
	private static int dissolveParticlesCounter = 0;
	
	public static Particles2[] makeParticles2(int brickX, int brickY, Color col) {
		for (int i=0; i<numParticles; i++) {
			dissolveParticlesCounter++;
			dxeee = randomInt(brickX-10,brickX+50);
			dyeee = randomInt(brickY-10,brickY+50);
			shimmerEffect[i] = new Particles2(dxeee,dyeee, col, dxeee, dyeee,2);
		}
		return shimmerEffect;
	}
	
	public static int randomInt(int min,int max) { // min and max included 
		  return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}
	
	
	public void draw(Graphics2D pb, Color c) {
		pb.setColor(c);
		pb.fill(this);	
	}
	
	
	
}
