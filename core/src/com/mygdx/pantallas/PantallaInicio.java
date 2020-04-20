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

public class PantallaInicio implements Screen, InputProcessor {
    private boolean pausa;
    private boolean finjuego;
    private boolean salir;
    private MiJuegoGame mijuegogame;
    private OrthographicCamera camara2d;
    private SpriteBatch spritebatch;
    private static Texture fondoInicio;

    public PantallaInicio(MiJuegoGame mijuegogame){
        this.mijuegogame=mijuegogame;
        camara2d = new OrthographicCamera();
        spritebatch = new SpriteBatch();
        FileHandle imagenFondoInicio = Gdx.files.internal("Graficos/PantallaInicio.png");
        fondoInicio = new Texture(imagenFondoInicio);
        Vector3 temp = new Vector3();
        Circle dedo;
    }
    @Override
    public void render(float delta) {
        spritebatch.begin();
        spritebatch.draw(fondoInicio,0,0, Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
        spritebatch.end();

        if (Gdx.input.justTouched()) {
            float posx = Gdx.input.getX();
            float posy = Gdx.input.getY();
            Vector3 temp = new Vector3(posx,posy,0);
            camara2d.unproject(temp);
            Circle dedo = new Circle(temp.x,temp.y,2);
            Rectangle botonJugar = new Rectangle(106,258,
                    40,47);
            Rectangle botonPuntuaciones = new Rectangle(106,210,
                    40,47);
            Rectangle botonSalir = new Rectangle(106,157,
                    40,47);
            if (Intersector.overlaps(dedo, botonJugar)) {
                mijuegogame.setScreen(new PantallaJuego(mijuegogame));

            }
            if (Intersector.overlaps(dedo, botonPuntuaciones)) {
                //mijuegogame.setScreen(new PantallaPuntuaciones(mijuegogame));

            }
            if (Intersector.overlaps(dedo, botonSalir)) {
                Gdx.app.exit();

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
        fondoInicio.dispose();
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
