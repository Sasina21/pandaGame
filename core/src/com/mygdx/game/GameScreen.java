package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
 
public class GameScreen extends ScreenAdapter {
	private PandaGame pandaGame;
	private Texture pandaImg;
	private int x;
    private int y;
	
	public GameScreen(PandaGame pandaGame){
		this.pandaGame = pandaGame;
		pandaImg = new Texture("panda.png");
		x = 0;
        y = 170;
	}
	
	@Override
    public void render(float delta) {
		update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		SpriteBatch batch = pandaGame.batch;
        batch.begin();
        batch.draw(pandaImg, x, y);
        batch.end();
    }
	 private void update(float delta) {
	        x += 10;    
	    }
 
}