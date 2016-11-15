package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
 
public class GameScreen extends ScreenAdapter {
	public static final int pos_LeftEdge = 0;
	public static final int pos_RightEdge = 380;
	
	public static final float MIN_ENEMY_SPAWN_TIME = 0.5f;
	public static final float MAX_ENEMY_SPAWN_TIME = 1.7f;
	
	private PandaGame pandaGame;
	private Panda panda;
	World world;
	WorldRenderer worldRenderer;
	
	
	float enemySpawnTimer;
	
	Random random;
	ArrayList<Enemy> enemyies;
	
	public GameScreen(PandaGame pandaGame) {
		
		this.pandaGame = pandaGame;
		world = new World(pandaGame);
		worldRenderer = new WorldRenderer(pandaGame,world);
		
		enemyies = new ArrayList<Enemy>();
		
		random = new Random();
		enemySpawnTimer = MathUtils.random(MAX_ENEMY_SPAWN_TIME , MIN_ENEMY_SPAWN_TIME);
	
	}
	
	@Override
    public void render(float delta) {
		
		update(delta);
		stoppedPos();
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render(delta);
		EnemyRender(delta);
	}
	
	public void EnemyRender (float delta) {
		enemySpawnTimer -= delta;
		if ( enemySpawnTimer <=0) {
			enemySpawnTimer = MathUtils.random(MAX_ENEMY_SPAWN_TIME , MIN_ENEMY_SPAWN_TIME);
			enemyies.add(new Enemy(random.nextInt(Gdx.graphics.getWidth() - Enemy.WIDTH)));
		}
		
		ArrayList<Enemy> enemysToRemove = new ArrayList<Enemy>();
		for (Enemy enemy :enemyies) {
			enemy.update(delta);
			if(enemy.remove)
				enemysToRemove.add(enemy);
			}
		enemyies.removeAll(enemysToRemove);
    
		
		for (Enemy enemy : enemyies) {
			enemy.render(pandaGame.batch);
		}
	}
	public void stoppedPos() {
		SpriteBatch batch = pandaGame.batch;
		if (worldRenderer.pos().x == pos_LeftEdge || worldRenderer.pos().x == pos_RightEdge) {
			world.getPanda().setNextDirection(Panda.DIRECTION_STILL);	
			}
	}
	
	private void update(float delta) {
		 if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			 if (worldRenderer.pos().x == pos_LeftEdge && worldRenderer.pos().x < pos_RightEdge) {
				world.getPanda().setNextDirection(Panda.DIRECTION_RIGHT);
				}
			 if (worldRenderer.pos().x == pos_RightEdge && worldRenderer.pos().x > pos_LeftEdge) {
				 world.getPanda().setNextDirection(Panda.DIRECTION_LEFT);
				 }
		 }
		 world.update(delta);
	 }

}

	 
	 