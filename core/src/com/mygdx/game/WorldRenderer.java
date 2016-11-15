package com.mygdx.game;

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
	private World world;
	private PandaGame pandaGame;
	private BitmapFont scoreFont;
	Texture background;

	static Texture pandaImg_Left;
	static Texture pandaImg_Right;
	static Texture pandaImg_Mid;
	
	static int score;
	public WorldRenderer(PandaGame pandaGame, World world) {
		this.pandaGame = pandaGame;
        this.world = world;
        scoreFont = new BitmapFont();
        score = 0;
        pandaImg_Left = new Texture("panda_left.png");
		pandaImg_Right = new Texture("panda_right.png");
		pandaImg_Mid = new Texture("panda_mid.png");
		
        background = new Texture("view.jpg");
       
	}
	 
	
	public void render(float delta) {
		score += 1 ;
		pos();
		SpriteBatch batch = pandaGame.batch;
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
        pandaGame.scrollingBackground.updateAndRender(delta, pandaGame.batch);
        picPanda();
        
        batch.begin();
        
        GlyphLayout scoreLayout = new GlyphLayout(scoreFont,"Score: " + score ,Color.BLACK, 0, Align.left, false);
        scoreFont.draw(pandaGame.batch ,scoreLayout, Gdx.graphics.getWidth() /2 - scoreLayout.width / 2, Gdx.graphics.getHeight() - scoreLayout.height - 10);
        batch.end();
        
    }
	
	public void picPanda () {
		SpriteBatch batch = pandaGame.batch;
		if (pos().x == GameScreen.pos_LeftEdge) {
			batch.begin(); 
	        batch.draw(pandaImg_Left, pos().x, pos().y,120,180);
	        batch.end();
		}else if(pos().x == GameScreen.pos_RightEdge) {
			batch.begin(); 
	        batch.draw(pandaImg_Right, pos().x, pos().y,120,180);
	        batch.end();
		}else {
			batch.begin(); 
	        batch.draw(pandaImg_Mid, pos().x, pos().y,100,150);
	        batch.end();
		}
	}
	
	public Vector2 pos () {
		return world.getPanda().getPosition();
	}
	
	
	
}


