package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class World {
    private Panda panda;
    private PandaGame pandaGame;
    
    World(PandaGame pandaGame) {
        this.pandaGame = pandaGame;
        panda = new Panda(0,170);
    }
    
 
    Panda getPanda() {
        return panda;
    }
    public void update(float delta) {
       panda.update();
    }
}
