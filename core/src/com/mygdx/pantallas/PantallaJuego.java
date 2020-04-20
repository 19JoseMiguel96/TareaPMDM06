package com.mygdx.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.Controles;
import com.mygdx.controlador.ControladorJuego;
import com.mygdx.game.MiJuegoGame;
import com.mygdx.modelo.Mundo;
import com.mygdx.modelo.PersonajePrincipal;
import com.mygdx.renderer.RendererJuego;

public class PantallaJuego implements Screen, InputProcessor {

    private boolean pausa;
    private boolean finJuego;
    private boolean salir;

    private MiJuegoGame miJuegoGame;
    private RendererJuego rendererJuego;
    private ControladorJuego controladorJuego;

    Mundo miMundo;
    private PersonajePrincipal personajePrincipal;


    public PantallaJuego(MiJuegoGame mijuegogame){
        miMundo = new Mundo();
        this.miJuegoGame =mijuegogame;
        rendererJuego=new RendererJuego(miMundo);
        controladorJuego = new ControladorJuego(miMundo);
        personajePrincipal = miMundo.getPersonajePrincipal();
    }



    @Override
    public void render(float delta) {
        rendererJuego.render(delta);
        controladorJuego.update(delta);

        if (pausa){
            miJuegoGame.setScreen(new PantallaPausa(miJuegoGame, this));
            return;
        }
    }


    @Override
    public void resize(int width, int height) {
        rendererJuego.resize(width, height);
    }

    @Override
    public void pause() {
        Gdx.input.setInputProcessor(null);
        if (!finJuego) {
            pausa = true;
        }
    }

    @Override
    public void resume() {
        Gdx.input.setInputProcessor(this);
        pausa=false;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        pausa=false;
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        rendererJuego.dispose();
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
        if(personajePrincipal.getPosicion().y <= 50){
            controladorJuego.saltar(true);
        }

        Vector3 vecTemporal = new Vector3(screenX,screenY,0);
        rendererJuego.getCamara2d().unproject(vecTemporal);
        Circle dedo = new Circle(vecTemporal.x,vecTemporal.y,2);
        Rectangle recTemporal = new Rectangle();
        recTemporal.set(Controles.CONTROL_PAUSA.x, Controles.CONTROL_PAUSA.y,Controles.CONTROL_PAUSA.width,Controles.CONTROL_PAUSA.height);

        if (Intersector.overlaps(dedo, recTemporal)){
            pausa = true;
        }
        recTemporal.set(Controles.CONTROL_SALIR.x,Controles.CONTROL_SALIR.y,Controles.CONTROL_SALIR.width,Controles.CONTROL_SALIR.height);
        if (Intersector.overlaps(dedo, recTemporal)){
            dispose();
            miJuegoGame.setScreen(new PantallaInicio(miJuegoGame));
        }
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
