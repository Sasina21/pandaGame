package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.List;

public class World {
    private Panda panda;
   
    private PandaGame pandaGame;
	private WorldRenderer worldRenderer;
	
    public World(PandaGame pandaGame) {
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
