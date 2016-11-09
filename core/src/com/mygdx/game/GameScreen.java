package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	private PandaGame pandaGame;
	private Texture pandaImg;
	private Panda panda;
	World world;
	WorldRenderer worldRenderer;
	public static final int pos_LeftEdge = 0;
	public static final int pos_RightEdge = 420;
	
	public GameScreen(PandaGame pandaGame) {
		this.pandaGame = pandaGame;
		world = new World(pandaGame);
		worldRenderer = new WorldRenderer(pandaGame,world);
		pandaImg = new Texture("panda.png");
		
		
	}
	
	@Override
    public void render(float delta) {
		update(delta);
		stoppedpos();
		/*if (worldRenderer.pos().x <= pos_LeftEdge ||worldRenderer.pos().x >= pos_RightEdge ) {
			world.getPanda().setNextDirection(Panda.DIRECTION_STILL);	
		}
		*/
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render(delta);
		
    }
	
	public void stoppedpos () {
		if (worldRenderer.pos().x == pos_LeftEdge ||worldRenderer.pos().x == pos_RightEdge ) {
			world.getPanda().setNextDirection(Panda.DIRECTION_STILL);	
		}
	}
	
	private void update(float delta) {
		 if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			 if (worldRenderer.pos().x == pos_LeftEdge && worldRenderer.pos().x < pos_RightEdge ){
				
				world.getPanda().setNextDirection(Panda.DIRECTION_RIGHT);			

		 }

			 if(worldRenderer.pos().x == pos_RightEdge && worldRenderer.pos().x > pos_LeftEdge) {
			 
				 world.getPanda().setNextDirection(Panda.DIRECTION_LEFT);
		 
		 }
		 }
		 world.update(delta);
		 
	 }
}

	 
	 