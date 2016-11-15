package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
public static final float LEFT_EDGE_ENERMY = -28;
public static final float RIGHT_EDGE_ENERMY = 430;
public static final int WIDTH = 99;
public static final int HEIGHT = 132;
private static Texture texture;
float x, y;
int speed = ScrollingBackground.SPEED;
Vector2 position;
int temp;
public boolean remove = false;
private Random random;

	public Enemy (int x) {
		this.x = x;
		this.y = Gdx.graphics.getHeight();
		
		position = new Vector2();
		temp = MathUtils.random(3);
				switch (temp) {
					case 0: position.x = LEFT_EDGE_ENERMY; 
						texture = new Texture ("snakeLeft.png");
							break;
					case 1: position.x = RIGHT_EDGE_ENERMY; 
						texture = new Texture ("snakeRight.png");
							break;
					case 2: position.x = LEFT_EDGE_ENERMY; 
						texture = new Texture ("koalaLeft.png");
							break;
					case 3: position.x = RIGHT_EDGE_ENERMY-50; 
						texture = new Texture ("koalaRight.png");
							break;
				}



		
		/*if( texture == null)
			texture = new Texture ("snakeLeft.png");
			*/
	}
	
	public void update (float deltaTime) {
		
		y -= speed * deltaTime;
		if (y < -HEIGHT)
			remove = true;
		
	}
	
	public void render (SpriteBatch batch) {
		
		batch.begin();
		batch.draw(texture, position.x, y);
		batch.end();
	}
}
