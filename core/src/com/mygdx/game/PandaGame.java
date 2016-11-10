package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class PandaGame extends Game {
	WorldRenderer worldRenderer;
	GameScreen gameScreen;
	public static final int HEIGHT = 700;
	public static final int WIDTH = 500;
	public SpriteBatch batch;
	public ScrollingBackground scrollingBackground;
	
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		setScreen(new MainMenuScreen(this));
		//setScreen(new GameScreen(this));
		this.scrollingBackground = new ScrollingBackground();

	}
	
	@Override
	public void render () {
		super.render();
		
	}
	
	public void resize (int width, int height) {
		 this.scrollingBackground.resize(width, height);
		 super.resize(width, height);
		 
	 }
	 
	
	@Override
	public void dispose () {
		 batch.dispose();
		
	}
}
