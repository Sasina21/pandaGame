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
	public static final int HEIGHT = 700;
	public static final int WIDTH = 500;
	public SpriteBatch batch;
	//Texture background;
	//OrthographicCamera camera;
	/*TextureRegion bamboo_left;
	TextureRegion bamboo_right;
	
	*/
	
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		//setScreen(new GameScreen(this));
		//background = new Texture("view.jpg");
		
	/*
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 500, 700);
		bamboo_left = new TextureRegion(new Texture("bamboo-left.png"));
		bamboo_right = new TextureRegion(new Texture("bamboo-right.png"));
		*/
	}
	

	private void drawWorld() {
		/*batch.begin();

		batch.draw(bamboo_left, 0, 0);
		batch.draw(bamboo_left, 0 ,bamboo_left.getRegionHeight());
		batch.draw(bamboo_right, 395, 0);
		batch.draw(bamboo_right, 395,bamboo_right.getRegionHeight());

		batch.end();
		*/
	}
	@Override
	public void render () {
		super.render();
		/*
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	//camera.update();
		//batch.setProjectionMatrix(camera.combined);
		/*
		batch.begin();
		batch.draw(background, 0, 0);
		batch.end();*/
		//drawWorld();
		
	}
	
	@Override
	public void dispose () {
		 batch.dispose();
		 //background.dispose();
		
	}
}
