package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	public static final int pos_LeftEdge = 0;
	public static final int pos_RightEdge = 380;
	public static final float MIN_ENEMY_SPAWN_TIME = 0.4f;
	public static final float MAX_ENEMY_SPAWN_TIME = 1.7f;
	private PandaGame pandaGame;
	private Panda panda;
	public World world;
	public WorldRenderer worldRenderer;
	public int x,y;
	public int count = 0;
	public float enemySpawnTimer;
	public static Texture pandaImg_Mid;
	public Random random;
	public ArrayList<Enemy> enemyies;
	public Texture gameOver;
	static Texture pandaImg_Left;
	static Texture pandaImg_Right;
	
	public GameScreen(PandaGame pandaGame) {
		this.pandaGame = pandaGame;
		pandaImg_Left = new Texture("panda_left.png");
		pandaImg_Right = new Texture("panda_right.png");
		pandaImg_Mid = new Texture("panda_mid.png");
		gameOver = new Texture("gameover.jpg");
		world = new World(pandaGame);
		worldRenderer = new WorldRenderer(pandaGame);
		panda = new Panda(x,y);
		new Enemy();
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
	
	public void EnemyRender(float delta) {
		boolean check = false;
		if (pandaGame.count == 0) {
			picPanda();
			enemySpawnTimer -= delta;
			if ( enemySpawnTimer <=0) {
				enemySpawnTimer = MathUtils.random(MAX_ENEMY_SPAWN_TIME , MIN_ENEMY_SPAWN_TIME);
				enemyies.add(new Enemy());
			}
			ArrayList<Enemy> enemysToRemove = new ArrayList<Enemy>();
			for (Enemy enemy :enemyies) {
				enemy.update(delta);
				check = panda.collisionWith(enemy.x, enemy.y, pos().x, pos().y);
				if (enemy.remove) {
					enemysToRemove.add(enemy);
				}
				if (check) {
					pandaGame.count++;
					break;
				}
			}	
			enemyies.removeAll(enemysToRemove);
			for (Enemy enemy : enemyies) {
				enemy.render(pandaGame.batch);
			}
		}
	}
	public void stoppedPos() {
		if (pos().x == pos_LeftEdge || pos().x == pos_RightEdge) {
			world.getPanda().setNextDirection(Panda.DIRECTION_STILL);	
			}
	}
	
	private void update(float delta) {
		 if (Gdx.input.isKeyPressed(Keys.SPACE)) {
			 if (pos().x == pos_LeftEdge && pos().x < pos_RightEdge) {
				world.getPanda().setNextDirection(Panda.DIRECTION_RIGHT);
				}
			 if (pos().x == pos_RightEdge && pos().x > pos_LeftEdge) {
				 world.getPanda().setNextDirection(Panda.DIRECTION_LEFT);
				 }
		 }
		 world.update(delta);
	 }
	
	public void picPanda() {
		SpriteBatch batch = pandaGame.batch;
		if (pos().x == GameScreen.pos_LeftEdge) {
			batch.begin(); 
	        batch.draw(pandaImg_Left, pos().x, pos().y,120,180);
	        batch.end();
		} else if (pos().x == GameScreen.pos_RightEdge) {
			batch.begin(); 
	        batch.draw(pandaImg_Right, pos().x, pos().y,120,180);
	        batch.end();
		} else {
			batch.begin(); 
	        batch.draw(pandaImg_Mid, pos().x, pos().y,100,150);
	        batch.end();
		}
	}
	
	public Vector2 pos() {
		return world.getPanda().getPosition();
	}
	
}