package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Panda {
	private Vector2 position;
	public static final int SPEED = 10;
	 
    public Panda(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
    
    private static final int [][] DIR_OFFSETS = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_LEFT = 4;
    
    
    public void move(int dir) { 
        position.x += SPEED * DIR_OFFSETS[dir][0];
        
    }
}