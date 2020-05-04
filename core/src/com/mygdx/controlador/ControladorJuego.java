package com.mygdx.controlador;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.Controles;
import com.mygdx.game.Audio;
import com.mygdx.game.MiJuegoGame;
import com.mygdx.modelo.ElementoMovil;
import com.mygdx.modelo.Mundo;
import com.mygdx.modelo.PersonajePrincipal;
import com.mygdx.pantallas.PantallaInicio;
import com.mygdx.pantallas.PantallaJuego;
import com.mygdx.pantallas.PantallaPausa;

import java.util.HashMap;

public class ControladorJuego {
    private Mundo miMundo;
    private PersonajePrincipal personajePrincipal;
    private MiJuegoGame miJuegoGame;
    private boolean pulsado;
    private int aumentoV=1, rival, c=5, aumentoVP=1;
    private Array<ElementoMovil> elementoMovil;
    private String elementoMovilFinal, elementoMovilActual;
    public ControladorJuego (Mundo mundo){
        this.miMundo=mundo;
        personajePrincipal = miMundo.getPersonajePrincipal();

    }
    private void controlarPersonajeP(float delta) {
        // Actualiza el Personaje principal
        personajePrincipal.update(delta);
        if(pulsado==true){
            personajePrincipal.setVelocidadY(personajePrincipal.velocidad_max+aumentoVP);
            pulsado=false;
        }
        if(personajePrincipal.getPosicion().y > 130){
            personajePrincipal.setVelocidadY(-personajePrincipal.velocidad_max-aumentoVP);
        }
        if(personajePrincipal.getPosicion().y <= 50){
            personajePrincipal.setPosicion(15, 50);
        }
    }
    private void controlarElementosMoviles(float delta){
        for(ElementoMovil elementoMovil: miMundo.getElementosMoviles()){
            elementoMovil.update(delta);
            elementoMovilFinal= ""+miMundo.getElementosMoviles().get(5);
            elementoMovilActual = ""+elementoMovil;
             if (elementoMovil.getPosicion().x<=-elementoMovil.getTamano().x) {
                 if(elementoMovilActual.equals(elementoMovilFinal)) {
                     miMundo.getElementosMoviles().removeIndex(0);
                     miMundo.getElementosMoviles().removeIndex(0);
                     miMundo.getElementosMoviles().removeIndex(0);
                     miMundo.getElementosMoviles().removeIndex(0);
                     miMundo.getElementosMoviles().removeIndex(0);
                     miMundo.getElementosMoviles().removeIndex(0);
                     aumentoV = aumentoV + 4;
                     aumentoVP = aumentoVP + 13;
                     rival = (int) (Math.random() * 4 + 1);
                     if (rival == 1) {

                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(250,
                                 50), Mundo.TAMANO_ROCA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(300,
                                 50), Mundo.TAMANO_ARANA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ARANA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(350,
                                 50), Mundo.TAMANO_MADERA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(380,
                                 95), Mundo.TAMANO_ABEJA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ABEJA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(430,
                                 50), Mundo.TAMANO_ROCA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(480,
                                 50), Mundo.TAMANO_ARANA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ARANA));

                         //miMundo.getElementosMoviles().removeValue(elementoMovil, true);


                     } else if (rival == 2) {

                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(250,
                                 50), Mundo.TAMANO_ROCA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(280,
                                 95), Mundo.TAMANO_ABEJA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ABEJA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(330,
                                 50), Mundo.TAMANO_MADERA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(360,
                                 95), Mundo.TAMANO_ABEJA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ABEJA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(410,
                                 50), Mundo.TAMANO_ARANA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ARANA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(460,
                                 50), Mundo.TAMANO_ROCA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
                         //miMundo.getElementosMoviles().removeValue(elementoMovil, true);

                     } else if (rival == 3) {
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(250,
                                 50), Mundo.TAMANO_MADERA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(280,
                                 95), Mundo.TAMANO_ABEJA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ABEJA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(330,
                                 50), Mundo.TAMANO_ARANA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ARANA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(380,
                                 50), Mundo.TAMANO_ROCA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(430,
                                 50), Mundo.TAMANO_MADERA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(460,
                                 95), Mundo.TAMANO_ABEJA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ABEJA));
                         //miMundo.getElementosMoviles().removeValue(elementoMovil, true);

                     } else {
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(250,
                                 50), Mundo.TAMANO_MADERA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(300,
                                 50), Mundo.TAMANO_ROCA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(350,
                                 50), Mundo.TAMANO_MADERA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(380,
                                 95), Mundo.TAMANO_ABEJA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ABEJA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(430,
                                 50), Mundo.TAMANO_ARANA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ARANA));
                         miMundo.getElementosMoviles().add(new ElementoMovil(new Vector2(480,
                                 50), Mundo.TAMANO_ROCA.cpy(), -25 - aumentoV, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
                         //miMundo.getElementosMoviles().removeValue(elementoMovil, true);
                     }
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
        miMundo.updateCronometro(delta);
        controlarElementosMoviles(delta);
        controlarPersonajeP(delta);
    }
}