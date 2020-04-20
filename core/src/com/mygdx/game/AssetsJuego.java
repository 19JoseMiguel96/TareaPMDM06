package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class AssetsJuego {
    public static Texture texturaPersonajeP, texturaMadera, texturaRoca, texturaArana, texturaAbeja,
            texturaFondo, texturaPuntoNegro, texturaPausa, texturaSalir;
    /**
     * Método encargado de cargar todas las texturas.
     */
    public static void cargarTexturas(){
        FileHandle imageFileHandle = Gdx.files.internal("Graficos/Personaje.png");
        texturaPersonajeP = new Texture(imageFileHandle);
        FileHandle imageFileHandle2 = Gdx.files.internal("Graficos/Madera.png");
        texturaMadera = new Texture(imageFileHandle2);
        FileHandle imageFileHandle3 = Gdx.files.internal("Graficos/Roca.png");
        texturaRoca = new Texture(imageFileHandle3);
        FileHandle imageFileHandle4 = Gdx.files.internal("Graficos/Araña.png");
        texturaArana = new Texture(imageFileHandle4);
        FileHandle imageFileHandle5 = Gdx.files.internal("Graficos/Abeja.png");
        texturaAbeja = new Texture(imageFileHandle5);
        FileHandle imageFileHandle6 = Gdx.files.internal("Graficos/Puntonegro.jpg");
        texturaPuntoNegro = new Texture(imageFileHandle6);
        FileHandle imagenFondo = Gdx.files.internal("Graficos/FondoMundo.png");
        texturaFondo = new Texture(imagenFondo);
        FileHandle imagenPausa = Gdx.files.internal("Graficos/Pausa.png");
        texturaPausa = new Texture(imagenPausa);
        FileHandle imagenSalir = Gdx.files.internal("Graficos/Salir.png");
        texturaSalir = new Texture(imagenSalir);

    }


    /**
     * Método encargado de liberar todas as texturas.
     */
    public static void liberarTexturas(){
        texturaPersonajeP.dispose();
        texturaMadera.dispose();
        texturaRoca.dispose();
        texturaArana.dispose();
        texturaAbeja.dispose();
    }
}
