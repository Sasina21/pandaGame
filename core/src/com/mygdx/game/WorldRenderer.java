package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	Texture background;

	private PandaGame pandaGame;
	private World world;
	private Texture pandaImg_Left;
	private Texture pandaImg_Right;
	private Texture pandaImg_Mid;

	public WorldRenderer(PandaGame pandaGame, World world) {
		this.pandaGame = pandaGame;
        this.world = world;
        
        pandaImg_Left = new Texture("panda_left.png");
		pandaImg_Right = new Texture("panda_right.png");
		pandaImg_Mid = new Texture("panda_mid.png");
        background = new Texture("view.jpg");
       
	}
	
	public void render(float delta) {
		pos();
		SpriteBatch batch = pandaGame.batch;
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
        pandaGame.scrollingBackground.updateAndRender(delta, pandaGame.batch);
        picPanda();
        
        
        
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

