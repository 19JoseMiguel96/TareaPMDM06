package com.mygdx.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.Controles;
import com.mygdx.game.AssetsJuego;
import com.mygdx.modelo.ElementoMovil;
import com.mygdx.modelo.Mundo;
import com.mygdx.modelo.PersonajePrincipal;

public class RendererJuego implements InputProcessor {
    private SpriteBatch spritebatch;
    private ShapeRenderer shaperender;
    private OrthographicCamera camara2d;
    private Vector3 temporal;
    private boolean debugger=false;
    private StringBuilder cronometro;
    private BitmapFont bitMapFont;
    private Mundo miMundo;
    private PersonajePrincipal personajePrincipal;

    public RendererJuego(Mundo mundo) {
        this.miMundo = mundo;
        personajePrincipal = mundo.getPersonajePrincipal();
        camara2d = new OrthographicCamera();
        spritebatch = new SpriteBatch();
        shaperender = new ShapeRenderer();
        bitMapFont = new BitmapFont();
    }
    private void dibujarPersonajePrincipal(){
        spritebatch.draw(AssetsJuego.texturaPersonajeP,
                personajePrincipal.getPosicion().x,personajePrincipal.getPosicion().y,personajePrincipal.getTamano().x,personajePrincipal.getTamano().y);
    }
    private void dibujarElementosMoviles(float delta){
        Texture textura=null;
        for (ElementoMovil elementoM : miMundo.getElementosMoviles()){
            switch(elementoM.getTipo()){
                case MADERA:
                    textura = AssetsJuego.texturaMadera;
                    break;
                case ROCA:
                    textura = AssetsJuego.texturaRoca;
                    break;
                case ARANA:
                    textura = AssetsJuego.texturaArana;
                    break;
                default:
                    textura = AssetsJuego.texturaAbeja;
                    break;
            }
            if (elementoM.getVelocidad()<0){
                spritebatch.draw(textura,elementoM.getPosicion().x+elementoM.getTamano().x,elementoM.getPosicion().y,-elementoM.getTamano().x,elementoM.getTamano().y);
            }
            else{
                spritebatch.draw(textura,elementoM.getPosicion().x,elementoM.getPosicion().y,elementoM.getTamano().x,elementoM.getTamano().y);
            }
        }
    }
    private void dibujarFondo(){
        spritebatch.draw(AssetsJuego.texturaFondo,
                0,0,Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
    }

    private void dibujarControles(){

        // Fondo negro
        spritebatch.draw(AssetsJuego.texturaPuntoNegro, Controles.FONDO_NEGRO.x,Controles.FONDO_NEGRO.y,Controles.FONDO_NEGRO.width,Controles.FONDO_NEGRO.height);
        spritebatch.draw(AssetsJuego.texturaPausa, Controles.CONTROL_PAUSA.x,Controles.CONTROL_PAUSA.y,Controles.CONTROL_PAUSA.width,Controles.CONTROL_PAUSA.height);
        spritebatch.draw(AssetsJuego.texturaSalir, Controles.CONTROL_SALIR.x,Controles.CONTROL_SALIR.y,Controles.CONTROL_SALIR.width,Controles.CONTROL_SALIR.height);
    }
    private void dibujarCronometro(){
        cronometro = new StringBuilder();
        cronometro.append(miMundo.getCronometro());
        int posx=Controles.POSXCRONOMETRO;
        int posy=Controles.POSYCRONOMETRO;
        bitMapFont.setColor(Color.WHITE);
        bitMapFont.getData().setScale(0.3f, 1.2f);
        bitMapFont.draw(spritebatch,cronometro, posx, posy);
    }


    /**
     * Dibuja todos los elementos gráficos de la pantalla.
     * @param delta: tiempo que pasa entre un frame y el siguiente.
    */
    public void render(float delta){
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        spritebatch.begin();
            dibujarFondo();
            dibujarElementosMoviles(delta);
            dibujarPersonajePrincipal();
            dibujarControles();
            dibujarCronometro();
        spritebatch.end();

        if (debugger){
            debugger();
        }
    }

    public void resize(int width, int height) {
        camara2d.setToOrtho(false,Mundo.TAMANO_MUNDO_ANCHO,Mundo.TAMANO_MUNDO_ALTO);
        camara2d.update();
        spritebatch.setProjectionMatrix(camara2d.combined);
        shaperender.setProjectionMatrix(camara2d.combined);
    }
    public void dispose(){
        Gdx.input.setInputProcessor(null);
        spritebatch.dispose();
        bitMapFont.dispose();
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
        temporal.set(screenX,screenY,0);
        camara2d.unproject(temporal);
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
    /**
     * Debibuja los gráficos en forma de figuras geométricas.
     */
    private void debugger(){

        shaperender.begin(ShapeRenderer.ShapeType.Line);
        shaperender.setColor(Color.BLUE);
        shaperender.rect(200,100,10,10);
        shaperender.end();

    }

    public OrthographicCamera getCamara2d() {
        return camara2d;
    }
}
