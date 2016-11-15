package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Align;

public class GameOverScreen implements Screen {
	Texture background;
	Texture replayButtonActive;
	Texture replayButtonInactive;
	BitmapFont scoreFont;
	private static final int REPLAY_BUTTON_WIDTH = 100;
	private static final int REPLAY_BUTTON_HEIGHT = 100;
	private static final int REPLAY_BUTTON_Y = 100;
	PandaGame pandaGame;
	int score;
	
	public GameOverScreen (PandaGame pandaGame, int score) {
		this.pandaGame = pandaGame;
		this.score = WorldRenderer.score;
		scoreFont = new BitmapFont();
		background = new Texture ("gameover.jpg");
		replayButtonActive = new Texture ("replaybutton.png");
		replayButtonInactive = new Texture ("replaybutton2.png");
		
	}
	
	public void replayButton () {
		int x = pandaGame.WIDTH / 2 - REPLAY_BUTTON_WIDTH / 2;
		pandaGame.batch.begin();
        if (Gdx.input.getX() < x + REPLAY_BUTTON_WIDTH && Gdx.input.getX() > x && PandaGame.HEIGHT - Gdx.input.getY() < REPLAY_BUTTON_Y + REPLAY_BUTTON_HEIGHT && PandaGame.HEIGHT - Gdx.input.getY() > REPLAY_BUTTON_Y ) {
        	pandaGame.batch.draw(replayButtonActive, x, REPLAY_BUTTON_Y, REPLAY_BUTTON_WIDTH ,REPLAY_BUTTON_HEIGHT);
        	if (Gdx.input.isTouched()) {
        		this.dispose();
        		pandaGame.setScreen(new GameScreen(pandaGame));
        	}
        } else {
        	pandaGame.batch.draw(replayButtonInactive, x, REPLAY_BUTTON_Y, REPLAY_BUTTON_WIDTH ,REPLAY_BUTTON_HEIGHT);
        }
        pandaGame.batch.end();
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        pandaGame.batch.begin();
        pandaGame.batch.draw(background, 0, 0);
        
        GlyphLayout scoreLayout = new GlyphLayout(scoreFont,"Score: " + score ,Color.BLACK, 0, Align.left, false);
		scoreFont.draw(pandaGame.batch, scoreLayout, Gdx.graphics.getWidth() /2 - scoreLayout.width /2, Gdx.graphics.getHeight()/2 - 1);
        pandaGame.batch.end();
        replayButton();
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
