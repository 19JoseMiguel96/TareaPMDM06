package com.mygdx.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.MiJuegoGame;
import com.mygdx.modelo.Mundo;

public class PantallaDerrota implements Screen, InputProcessor {
    private MiJuegoGame mijuegogame;
    private OrthographicCamera camara2d;
    private SpriteBatch spritebatch;
    private static Texture fondoDerrota;

    public PantallaDerrota(MiJuegoGame mijuegogame){
        this.mijuegogame=mijuegogame;
        camara2d = new OrthographicCamera();
        spritebatch = new SpriteBatch();
        FileHandle imagenFondoDerrota = Gdx.files.internal("Graficos/PantallaDerrota.png");
        fondoDerrota = new Texture(imagenFondoDerrota);
    }


    @Override
    public void render(float delta) {
        spritebatch.begin();
        spritebatch.draw(fondoDerrota,0,0, Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
        spritebatch.end();
        if (Gdx.input.justTouched()) {
            float posx = Gdx.input.getX();
            float posy = Gdx.input.getY();
            Vector3 temp = new Vector3(posx,posy,0);
            camara2d.unproject(temp);
            Circle dedo = new Circle(temp.x,temp.y,2);
            Rectangle botonNo = new Rectangle(104,296,
                    17,26);
            Rectangle botonSi = new Rectangle(127,296,
                    17,26);
            if (Intersector.overlaps(dedo, botonNo)) {
                mijuegogame.setScreen(new PantallaInicio(mijuegogame));

            }
            if (Intersector.overlaps(dedo, botonSi)) {
                mijuegogame.setScreen(new PantallaJuego(mijuegogame));

            }

        }
    }

    @Override
    public void resize(int width, int height) {
        camara2d.setToOrtho(false, Mundo.TAMANO_MUNDO_ANCHO, Mundo.TAMANO_MUNDO_ALTO);
        camara2d.update();
        spritebatch.setProjectionMatrix(camara2d.combined);
        spritebatch.disableBlending();
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }
    @Override
    public void pause() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        spritebatch.dispose();
        fondoDerrota.dispose();
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
