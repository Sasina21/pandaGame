package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PandaGame extends Game {
	public static final int HEIGHT = 700;
	public static final int WIDTH = 500;
	public SpriteBatch batch;
	public ScrollingBackground scrollingBackground;
	public int count = 0;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		setScreen(new MainMenuScreen(this));
		this.scrollingBackground = new ScrollingBackground();
	}
	
	@Override
	public void render() {
		super.render();
	}
	
	public void resize(int width, int height) {
		 this.scrollingBackground.resize(width, height);
		 super.resize(width, height);
	}
	 
	@Override
	public void dispose() {
		 batch.dispose();
	}
	
}
