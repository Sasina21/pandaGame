package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollingBackground {
	
	public static final int DEFAULT_SPEED = 900;
	public static final int GOAL_REACH_ACCELERATION = 100;
	
	Texture bamboo; 
	float y1 ,y2;
	int speed;
	int goalSpeed;
	float imageScale;
	boolean speedFixed;
	
	public ScrollingBackground () {
		bamboo = new Texture("bamboo.png");
		y1 = 0;
		y2 = bamboo.getHeight();
		speed = 0;
		goalSpeed = DEFAULT_SPEED;
		imageScale = 0;
		speedFixed = true;
	}
	public void updateAndRender (float deltaTime, SpriteBatch batch) {
		if (speed < goalSpeed) {
			speed += GOAL_REACH_ACCELERATION * deltaTime;
			if (speed > goalSpeed) {
				speed = goalSpeed;	
				
		}
	}
		y1 -= speed * deltaTime;
		y2 -= speed * deltaTime;
		
		if (y1 + bamboo.getHeight() * imageScale <= 0) {
			y1 = y2 + bamboo.getHeight() * imageScale;
		}
		if (y2 + bamboo.getHeight() * imageScale <= 0) {
			y2 = y1 + bamboo.getHeight() * imageScale;
		}
		batch.begin();
		batch.draw(bamboo , 0, y1, Gdx.graphics.getWidth(), bamboo.getHeight() * imageScale);
		batch.draw(bamboo , 0, y2, Gdx.graphics.getWidth(), bamboo.getHeight() * imageScale);
		batch.end();
		
	}
	public void resize (int width, int height) {
		imageScale = width / bamboo.getWidth();
	}
	
}

		
