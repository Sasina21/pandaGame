package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrollingBackground {
	
	public static final int SPEED = 650;
	
	Texture bamboo; 
	float y1 ,y2;
	float imageScale;
	
	public ScrollingBackground () {
		bamboo = new Texture("bamboo.png");
		y1 = 0;
		y2 = bamboo.getHeight();
		
		imageScale = 0;
	}
	public void updateAndRender (float deltaTime, SpriteBatch batch) {
	
		y1 -= SPEED * deltaTime;
		y2 -= SPEED * deltaTime;
		
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

		
