package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	private PandaGame pandaGame;
	
	private Texture pandaImg;
	
	private Panda panda;
	
	World world;
	
	public GameScreen(PandaGame pandaGame){
		this.pandaGame = pandaGame;
		pandaImg = new Texture("panda.png");
		world = new World(pandaGame);
		//panda = world.getPanda();

	}
	
	@Override
    public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = pandaGame.batch;
        batch.begin();
        Vector2 pos = world.getPanda().getPosition();
        batch.draw(pandaImg, pos.x, pos.y);
        batch.end();
    }
	
	 private void update(float delta) {
		 if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			 world.getPanda().move(Panda.DIRECTION_LEFT);
	        }
		 if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			 world.getPanda().move(Panda.DIRECTION_RIGHT);
	        }
	    }
	 }