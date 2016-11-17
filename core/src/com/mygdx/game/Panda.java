package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;

public class Panda {
	
	private static final int HEIGHT_PANDA = 225;
	private static final int WIDTH_PANDA = 140;
	
	Vector2 position;
	public static final int SPEED = 10;
	private int currentDirection;
    private int nextDirection;
    PandaGame pandaGame;
    World world;
    WorldRenderer worldRenderer;
   

	 
    public Panda(float x, float y) {
        position = new Vector2(x,0);
        
        currentDirection = DIRECTION_STILL;
        
        nextDirection = DIRECTION_STILL;
 
        
    }   
    
    public void setNextDirection(int dir) {
        nextDirection = dir;
    }
 
    public Vector2 getPosition() {
        return position;    
    }
    
    private static final int [][] DIR_OFFSETS = new int [][] {
        {1,0},
        {-1,0},
        {0,0},
    
    };
    
    public static final int DIRECTION_RIGHT = 0;
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_STILL = 2;
 
    public boolean collisionWith (float x, float y, float xPanda, float yPanda) {
    	System.out.println( y + " " +(HEIGHT_PANDA/2) + " " +xPanda + "  " +x+ "  " + (xPanda+WIDTH_PANDA));
    	if (y<= HEIGHT_PANDA/2 && xPanda >= x && xPanda<=x+90) {
    		return true;
    	}
    	return false;
    }
    
    public void move(int dir) { 
        position.x += SPEED * DIR_OFFSETS[dir][0];
       
    }
    public void update() {
        currentDirection = nextDirection;
        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
    }
    
}
   
 
