package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy {
public static final int LEFT_EDGE_ENERMY = -28;
public static final int WIDTH = 99;
public static final int HEIGHT = 132;
private static Texture snakeLeft;
float x, y;
int speed = ScrollingBackground.SPEED;

int temp;
Random random;
public boolean remove = false;

	public Enemy (int x) {
		this.x = x;
		this.y = Gdx.graphics.getHeight();
		
		if( snakeLeft == null)
			snakeLeft = new Texture ("snakeLeft.png");
	}
	
	public void update (float deltaTime) {
		y -= speed * deltaTime;
		if (y < -HEIGHT)
			remove = true;
	}
	
	public void render (SpriteBatch batch) {
		batch.begin();
		batch.draw(snakeLeft, LEFT_EDGE_ENERMY, y);
		batch.end();
		
		
		
		
	}
}
