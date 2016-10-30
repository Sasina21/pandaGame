package com.mygdx.game;

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
}
