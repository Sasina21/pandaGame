package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Panda {
	private Vector2 position;
	public static final int SPEED = 10;
	private int currentDirection;
    private int nextDirection;
    World world;
 
  
	 
    public Panda(int x, int y) {
        position = new Vector2(x,y);
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
 
    
    
    public void move(int dir) { 
        position.x += SPEED * DIR_OFFSETS[dir][0];
        
    }
    
    
    public void update() {
        currentDirection = nextDirection;
        position.x += SPEED * DIR_OFFSETS[currentDirection][0];
 
    }
    
   }
   
 
