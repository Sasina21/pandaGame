package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenuScreen implements Screen {
	private static final int PLAY_BUTTON_WIDTH = 100;
	private static final int PLAY_BUTTON_HEIGHT = 50;
	private static final int PLAY_BUTTON_Y = 375;
	PandaGame pandaGame;
	Texture background_menu;
	Texture playButtonActive;
	Texture playButtonInactive;
	
	public MainMenuScreen(PandaGame pandaGame) {
		this.pandaGame = pandaGame;
		playButtonActive = new Texture ("playActive.png");
		playButtonInactive = new Texture ("playInactive.png");
		background_menu = new Texture ("mainmenu.jpg");
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		SpriteBatch batch = pandaGame.batch;
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.4f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background_menu, 0, 0);
        batch.end();
        playButton();
	}
	
	public void playButton() {
		int x = PandaGame.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
		pandaGame.batch.begin();
        if (Gdx.input.getX() < x + PLAY_BUTTON_WIDTH && Gdx.input.getX() > x && PandaGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && PandaGame.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y ) {
        	pandaGame.batch.draw(playButtonActive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH ,PLAY_BUTTON_HEIGHT);
        	if (Gdx.input.isTouched()) {
        		this.dispose();
        		pandaGame.setScreen(new GameScreen(pandaGame));
        	}
        } else {
        	pandaGame.batch.draw(playButtonInactive, x, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH ,PLAY_BUTTON_HEIGHT);
        }
        pandaGame.batch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
