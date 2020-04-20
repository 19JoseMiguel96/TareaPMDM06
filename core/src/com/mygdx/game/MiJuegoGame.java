package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.pantallas.PantallaInicio;
import com.mygdx.pantallas.PantallaJuego;

public class MiJuegoGame extends Game {
    @Override
    public void create() {
        AssetsJuego.cargarTexturas();
        setScreen(new PantallaInicio(this));
    }
    @Override
    public void dispose(){
        super.dispose();
        AssetsJuego.liberarTexturas();
    }
}
