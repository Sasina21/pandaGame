package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	public static final float LEFT_EDGE_ENEMY = -28;
	public static final float RIGHT_EDGE_ENEMY = 430;
	public static final int WIDTH = 99;
	public static final int HEIGHT = 132;
	private static Texture snakeLeft;
	private static Texture snakeRight;
	private static Texture koalaLeft;
	private static Texture koalaRight;
	float x, y;
	int speed = ScrollingBackground.SPEED;
	Vector2 position;
	int temp;
	public boolean remove = false;
	private Random random;


		public Enemy (int x) {
			this.x = x;
			this.y = Gdx.graphics.getHeight();
			snakeLeft = new Texture ("snakeLeft.png");
			koalaLeft = new Texture ("koalaLeft.png");
			snakeRight = new Texture ("snakeRight.png");
			koalaRight = new Texture ("koalaRight.png");
			position = new Vector2();
			temp = MathUtils.random(3);
	
		}
		
		
		public void update (float deltaTime) {
			
			y -= speed * deltaTime;
			if (y < -HEIGHT)
				remove = true;
			
		}
		
		public void render (SpriteBatch batch) {
			batch.begin();
			if (temp == 0) {
			batch.draw(snakeLeft, LEFT_EDGE_ENEMY, y);
			} else if (temp == 1) {
				batch.draw(koalaLeft, LEFT_EDGE_ENEMY, y);
			} else if (temp == 1) {
				batch.draw(snakeRight, RIGHT_EDGE_ENEMY, y);
			} else {
				batch.draw(koalaRight, RIGHT_EDGE_ENEMY-50, y);
			}
			
			batch.end();
		}
}
