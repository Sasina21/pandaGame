package com.mygdx.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class World {
    private Panda panda;
    private Panda rightpanda;
    private PandaGame pandaGame;
    
    World(PandaGame pandaGame) {
        this.pandaGame = pandaGame;
        panda = new Panda(0,50);
    
    }
 
    Panda getPanda() {
        return panda;
    }
    public void update(float delta) {
       panda.update();
       
		
	
		
    }
}
