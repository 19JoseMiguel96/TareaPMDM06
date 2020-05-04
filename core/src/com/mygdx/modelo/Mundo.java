package com.mygdx.modelo;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Mundo {
    public static final int TAMANO_MUNDO_ANCHO=250;
    public static final int TAMANO_MUNDO_ALTO=500;
    public final static Vector2 TAMANO_MADERA = new Vector2(10,30);
    public final static Vector2 TAMANO_ROCA = new Vector2(10,30);
    public final static Vector2 TAMANO_ARANA = new Vector2(12,35);
    public final static Vector2 TAMANO_ABEJA = new Vector2(10,30);
    private PersonajePrincipal personP;
    private Array<ElementoMovil> elementoMovil;
    private final static int TEMPO_INICIAL=0;
    private float cronometro;

    public Mundo(){
        personP = new PersonajePrincipal(new Vector2(15,50), new Vector2(6,37),120);
        elementoMovil = new Array<ElementoMovil>();
            elementoMovil.add(new ElementoMovil(new Vector2(100,50),TAMANO_MADERA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
        elementoMovil.add(new ElementoMovil(new Vector2(150,50),TAMANO_ROCA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
        elementoMovil.add(new ElementoMovil(new Vector2(200,50),TAMANO_MADERA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
        elementoMovil.add(new ElementoMovil(new Vector2(250,50),TAMANO_MADERA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
        elementoMovil.add(new ElementoMovil(new Vector2(300,50),TAMANO_ROCA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
        elementoMovil.add(new ElementoMovil(new Vector2(350,50),TAMANO_MADERA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
        cronometro=TEMPO_INICIAL;
    }

    public PersonajePrincipal getPersonajePrincipal() {
        return personP;
    }
    public Array<ElementoMovil> getElementosMoviles() {
        return elementoMovil;
    }
    public int getCronometro() {
        return (int)cronometro;
    }

    public void setCronometro(float cronometro) {
        this.cronometro = cronometro;
    }

    public void updateCronometro(float delta){
        cronometro+=delta;
    }

}
