package com.mygdx.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.Controles;
import com.mygdx.game.MejoresPuntuaciones;
import com.mygdx.game.MiJuegoGame;
import com.mygdx.modelo.Mundo;

public class PantallaPuntuaciones implements Screen, InputProcessor {
    private boolean pausa;
    private boolean finjuego;
    private boolean salir;
    private MiJuegoGame mijuegogame;
    private OrthographicCamera camara2d;
    private SpriteBatch spritebatch, spritebatch2;
    private static Texture fondoPuntuaciones;
    private BitmapFont bitMapFont;

    public PantallaPuntuaciones(MiJuegoGame mijuegogame){
        this.mijuegogame=mijuegogame;
        camara2d = new OrthographicCamera();
        spritebatch = new SpriteBatch();
        spritebatch2 = new SpriteBatch();
        FileHandle imagenFondoPuntuaciones = Gdx.files.internal("Graficos/PantallaPuntuaciones.png");
        fondoPuntuaciones = new Texture(imagenFondoPuntuaciones);
        bitMapFont = new BitmapFont();
    }
    private void dibujarPuntuaciones(){
        bitMapFont.setColor(Color.WHITE);
        bitMapFont.getData().setScale(0.4f, 1.6f);
        bitMapFont.draw(spritebatch2, MejoresPuntuaciones.puntuacionesAltas[0] , 102, 412);
        bitMapFont.draw(spritebatch2, MejoresPuntuaciones.puntuacionesAltas[1] , 102, 373);
        bitMapFont.draw(spritebatch2, MejoresPuntuaciones.puntuacionesAltas[2] , 102, 335);
        bitMapFont.draw(spritebatch2, MejoresPuntuaciones.puntuacionesAltas[3] , 102, 297);
        bitMapFont.draw(spritebatch2, MejoresPuntuaciones.puntuacionesAltas[4] , 102, 262);
    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        MejoresPuntuaciones.cargarPuntuaciones();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spritebatch.begin();
            spritebatch.draw(fondoPuntuaciones,0,0, Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
        spritebatch.end();
        spritebatch2.begin();
            dibujarPuntuaciones();
        spritebatch2.end();
        if (Gdx.input.justTouched()) {
            float posx = Gdx.input.getX();
            float posy = Gdx.input.getY();
            Vector3 temp = new Vector3(posx,posy,0);
            camara2d.unproject(temp);
            Circle dedo = new Circle(temp.x,temp.y,2);
            Rectangle botonVolver = new Rectangle(111,110,
                    34,40);
            if (Intersector.overlaps(dedo, botonVolver)) {
                mijuegogame.setScreen(new PantallaInicio(mijuegogame));

            }

        }
    }

    @Override
    public void resize(int width, int height) {
        camara2d.setToOrtho(false, Mundo.TAMANO_MUNDO_ANCHO, Mundo.TAMANO_MUNDO_ALTO);
        camara2d.update();
        spritebatch.setProjectionMatrix(camara2d.combined);
        spritebatch2.setProjectionMatrix(camara2d.combined);
        spritebatch.disableBlending();
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
