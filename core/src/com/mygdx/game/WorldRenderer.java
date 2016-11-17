package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;

public class WorldRenderer {
	Texture backgroundOver;
	Texture replayButtonActive;
	Texture replayButtonInactive;

	private static final int REPLAY_BUTTON_WIDTH = 100;
	private static final int REPLAY_BUTTON_HEIGHT = 100;
	private static final int REPLAY_BUTTON_Y = 100;
	PandaGame pandaGame;
	
	private BitmapFont scoreFont;
	Texture background;

	static Texture pandaImg_Left;
	static Texture pandaImg_Right;
	static Texture pandaImg_Mid;
	private SpriteBatch batch;
	static int score;
	int lastScore;
	public WorldRenderer(PandaGame pandaGame) {
		this.pandaGame = pandaGame;
        scoreFont = new BitmapFont();
        score = 0;
        lastScore = 0;
        pandaImg_Left = new Texture("panda_left.png");
		pandaImg_Right = new Texture("panda_right.png");
		pandaImg_Mid = new Texture("panda_mid.png");
		
        background = new Texture("view.jpg");
        this.batch = pandaGame.batch;
        
        scoreFont = new BitmapFont();
		backgroundOver = new Texture ("gameover.jpg");
		replayButtonActive = new Texture ("replaybutton.png");
		replayButtonInactive = new Texture ("replaybutton2.png");
		
	}
	 
	
	public void render(float delta) {
	
        if(pandaGame.count == 0) {
        	score += 1 ;
        	batch.begin();
	        batch.draw(background, 0, 0);	
	        GlyphLayout scoreLayout = new GlyphLayout(scoreFont,"Score: " + score ,Color.BLACK, 0, Align.left, false);
	        scoreFont.draw(batch ,scoreLayout, Gdx.graphics.getWidth() /2 - scoreLayout.width / 2, Gdx.graphics.getHeight() - scoreLayout.height - 10);
	        pandaGame.scrollingBackground.updateAndRender(delta, batch);
	        batch.end();
        } else if(pandaGame.count == 1) {
        
        	Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            replayButton();
        }
        
    }
	 private void replayButton () {
 		int x = PandaGame.WIDTH / 2 - REPLAY_BUTTON_WIDTH / 2;
 		lastScore = score;
 		pandaGame.batch.begin();
 		pandaGame.batch.draw(backgroundOver, 0, 0);
 		GlyphLayout scoreLayout = new GlyphLayout(scoreFont,"Score: " + lastScore ,Color.BLACK, 0, Align.left, false);
 		scoreFont.draw(pandaGame.batch, scoreLayout, Gdx.graphics.getWidth() /2 - scoreLayout.width /2, Gdx.graphics.getHeight()/2 - 1);
 		if (Gdx.input.getX() < x + REPLAY_BUTTON_WIDTH && Gdx.input.getX() > x && PandaGame.HEIGHT - Gdx.input.getY() < REPLAY_BUTTON_Y + REPLAY_BUTTON_HEIGHT && PandaGame.HEIGHT - Gdx.input.getY() > REPLAY_BUTTON_Y ) {
         	pandaGame.batch.draw(replayButtonActive, x, REPLAY_BUTTON_Y, REPLAY_BUTTON_WIDTH ,REPLAY_BUTTON_HEIGHT);
         	if (Gdx.input.isTouched()) {
         
         		pandaGame.setScreen(new GameScreen(pandaGame));
         		pandaGame.count = 0;
         	}
         } else {
         	pandaGame.batch.draw(replayButtonInactive, x, REPLAY_BUTTON_Y, REPLAY_BUTTON_WIDTH ,REPLAY_BUTTON_HEIGHT);
         }
 		
         pandaGame.batch.end();
 	}

}