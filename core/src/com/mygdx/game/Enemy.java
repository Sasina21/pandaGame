package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	public static final float LEFT_EDGE_ENEMY = -25;
	public static final float RIGHT_EDGE_ENEMY = 380;
	public static final int WIDTH = 130;
	public static final int HEIGHT = 130;
	static Texture snakeLeft;
	static Texture snakeRight;
	static Texture koalaLeft;
	static Texture koalaRight;
	float x, y;
	int speed = ScrollingBackground.SPEED;

	private int temp;
	public boolean remove = false;
	private Random random;
	Panda panda;


		public Enemy () {
		
			this.y = Gdx.graphics.getHeight();
			
			
			snakeLeft = new Texture ("snakeLeft.png");
			koalaLeft = new Texture ("koalaLeft.png");
			snakeRight = new Texture ("snakeRight.png");
			koalaRight = new Texture ("koalaRight.png");
			
			
			
			temp = MathUtils.random(3);
			
			if (temp == 0) {
				x = LEFT_EDGE_ENEMY;
			} else if (temp == 1) {
				x = LEFT_EDGE_ENEMY;
			} else if (temp == 2) {
				x = RIGHT_EDGE_ENEMY;
			} else if (temp == 3) {
				x = RIGHT_EDGE_ENEMY;
			}
	
		}
		
		
		
		public void update (float deltaTime) {
			y -= speed * deltaTime;
			if (y < -HEIGHT)
				remove = true;
			
			
		}
		
		public void render (SpriteBatch batch) {
			
			batch.begin();
			if (temp == 0) {
			
			batch.draw(snakeLeft, LEFT_EDGE_ENEMY, y , WIDTH, HEIGHT);
			} else if (temp == 1) {
			
				batch.draw(koalaLeft, LEFT_EDGE_ENEMY, y, WIDTH, HEIGHT);
			} else if (temp == 2) {
		
				batch.draw(snakeRight, RIGHT_EDGE_ENEMY, y, WIDTH, HEIGHT);
			} else if (temp == 3) {
		
				batch.draw(koalaRight, RIGHT_EDGE_ENEMY, y, WIDTH, HEIGHT);
			}
			
			batch.end();
			
			
		}
		
}