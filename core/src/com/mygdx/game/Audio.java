package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Audio {
    public static Sound sonidoSalto, sonidoChoque;
    public static void inicializarSonidos() {
        sonidoSalto = Gdx.audio.newSound(Gdx.files.internal("MUSICA/Salto.ogg"));
        sonidoChoque = Gdx.audio.newSound(Gdx.files.internal("MUSICA/Choque.ogg"));
    }
    public static void liberarSonidos(){
        sonidoSalto.dispose();
        sonidoChoque.dispose();
    }
}
