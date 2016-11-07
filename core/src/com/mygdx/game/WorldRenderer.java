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
	private Texture pandaImg;
	public static final int BEAR_SIZE = 92;

	
 

	public WorldRenderer(PandaGame pandaGame, World world) {
		this.pandaGame = pandaGame;
        SpriteBatch batch = pandaGame.batch;
        this.world = world;
        pandaImg = new Texture("panda.png");
        background = new Texture("view.jpg");
	}
	
	public void render(float delta) {
		
		SpriteBatch batch = pandaGame.batch;
        batch.begin();
        Vector2 pos = world.getPanda().getPosition();
        batch.draw(background, 0, 0);
        batch.end();
        
        pandaGame.scrollingBackground.updateAndRender(delta, pandaGame.batch);
        
        batch.begin(); 
        batch.draw(pandaImg, pos.x, pos.y);
        batch.end();
    }
}

