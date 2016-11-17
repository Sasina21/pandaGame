package com.mygdx.game;

public class World {
    private Panda panda;
    public World(PandaGame pandaGame) {
        panda = new Panda(0,50);
    }
 
    Panda getPanda() {
        return panda;
    }

    public void update(float delta) {
       panda.update();
    }
}
