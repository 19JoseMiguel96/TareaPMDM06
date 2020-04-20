package com.mygdx.controlador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.mygdx.Controles;
import com.mygdx.modelo.ElementoMovil;
import com.mygdx.modelo.Enemigo;
import com.mygdx.modelo.Mundo;
import com.mygdx.modelo.PersonajePrincipal;

import java.util.HashMap;

public class ControladorJuego {
    private Mundo miMundo;
    private PersonajePrincipal personajePrincipal;

    private boolean pulsado;
    public ControladorJuego (Mundo mundo){
        this.miMundo=mundo;
        personajePrincipal = miMundo.getPersonajePrincipal();

    }
    private void controlarPersonajeP(float delta) {
        // Actualiza el Personaje principal
        personajePrincipal.update(delta);
        if(pulsado==true){
            personajePrincipal.setVelocidadY(personajePrincipal.velocidad_max);
            pulsado=false;
        }
        if(personajePrincipal.getPosicion().y > 130){
            personajePrincipal.setVelocidadY(-personajePrincipal.velocidad_max);
        }
        if(personajePrincipal.getPosicion().y <= 50){
            personajePrincipal.setPosicion(15, 50);
        }
        for (ElementoMovil elementoMovil : miMundo.getElementosMoviles()){
            if (Intersector.overlaps(elementoMovil.getRectangulo(), personajePrincipal.getRectangulo())){
                Gdx.app.log("logjuego",  "CHOQUE!!!!");
            }
        }
        for (Enemigo enemigo : miMundo.getEnemigos()){
            if (Intersector.overlaps(enemigo.getRectangulo(), personajePrincipal.getRectangulo())){
                Gdx.app.log("logjuego",  "CHOQUE!!!!");
            }
        }


    }
    private void controlarElementosMoviles(float delta){
        for(ElementoMovil elementoMovil: miMundo.getElementosMoviles()){
            elementoMovil.update(delta);
            if (elementoMovil.getVelocidad()>0){	// Si va izquierda a derecha
                if (elementoMovil.getPosicion().x>=Mundo.TAMANO_MUNDO_ANCHO){
                    elementoMovil.setPosicion(-Mundo.TAMANO_ROCA.x, elementoMovil.getPosicion().y);
                }
            }
            else{	// Si va de derecha a izquierda
                if (elementoMovil.getPosicion().x<=-elementoMovil.getTamano().x){
                    elementoMovil.setPosicion(Mundo.TAMANO_MUNDO_ANCHO, elementoMovil.getPosicion().y);
                }
            }
        }
    }
    private void controlarEnemigos(float delta){
        for(Enemigo enemigo: miMundo.getEnemigos()){
            enemigo.update(delta);
            if (enemigo.getVelocidad()>0){	// Si va izquierda a derecha
                if (enemigo.getPosicion().x>=Mundo.TAMANO_MUNDO_ANCHO){
                    enemigo.setPosicion(-Mundo.TAMANO_ABEJA.x, enemigo.getPosicion().y);
                }
            }
            else{	// Si va de derecha a izquierda
                if (enemigo.getPosicion().x<=-enemigo.getTamano().x){
                    enemigo.setPosicion(Mundo.TAMANO_MUNDO_ANCHO, enemigo.getPosicion().y);
                }
            }
        }
    }

    public void saltar(boolean pulsado2){
        pulsado=pulsado2;
    }

    /**
     * Va a llamar a todos los métodos para mover y controlar los personajes
     * También gestionará los eventos producidos por el usuario y que vienen desde la clase PantallaJuego
     * @param delta
     */
    public void update(float delta){
        controlarElementosMoviles(delta);
        controlarEnemigos(delta);
        controlarPersonajeP(delta);
    }
}