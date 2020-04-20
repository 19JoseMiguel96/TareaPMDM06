package com.mygdx.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MiJuegoGame;

public class PantallaPausa implements Screen, InputProcessor {
    private boolean pausa;
    private boolean finjuego;
    private boolean salir;
    private MiJuegoGame mijuegogame;
    private OrthographicCamera camara2d;
    private SpriteBatch spritebatch;
    private static Texture fondoPausa;
    private Screen pantallaJuego;

    public PantallaPausa(MiJuegoGame mijuegogame, PantallaJuego pantallaJuego){
        this.mijuegogame=mijuegogame;
        this.pantallaJuego = pantallaJuego;
        camara2d = new OrthographicCamera();
        spritebatch = new SpriteBatch();
        FileHandle imagenFondoPausa = Gdx.files.internal("Graficos/PantallaInicio.png");
        fondoPausa = new Texture(imagenFondoPausa);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        mijuegogame.setScreen(pantallaJuego);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
