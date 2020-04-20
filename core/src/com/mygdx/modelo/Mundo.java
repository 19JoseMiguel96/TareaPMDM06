package com.mygdx.modelo;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Mundo {
    public static final int TAMANO_MUNDO_ANCHO=250;
    public static final int TAMANO_MUNDO_ALTO=500;
    public final static Vector2 TAMANO_MADERA = new Vector2(10,30);
    public final static Vector2 TAMANO_ROCA = new Vector2(10,30);
    public final static Vector2 TAMANO_ARANA = new Vector2(10,30);
    public final static Vector2 TAMANO_ABEJA = new Vector2(10,30);
    private PersonajePrincipal personP;
    private Array<ElementoMovil> elementoMovil;
    private Array<Enemigo> enemigo;

    public Mundo(){
        personP = new PersonajePrincipal(new Vector2(15,50), new Vector2(10,30),120);
        elementoMovil = new Array<ElementoMovil>();
        enemigo = new Array<Enemigo>();
        enemigo.add(new Enemigo(new Vector2(60,95),TAMANO_ABEJA.cpy(),-25, Enemigo.TIPOS_ELEMENTOS.ABEJA));
        elementoMovil.add(new ElementoMovil(new Vector2(90,50),TAMANO_MADERA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
        enemigo.add(new Enemigo(new Vector2(130,95),TAMANO_ABEJA.cpy(),-25, Enemigo.TIPOS_ELEMENTOS.ABEJA));
        elementoMovil.add(new ElementoMovil(new Vector2(170,50),TAMANO_ROCA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.ROCA));
        enemigo.add(new Enemigo(new Vector2(210,50),TAMANO_ARANA.cpy(),-25, Enemigo.TIPOS_ELEMENTOS.ARANA));
        elementoMovil.add(new ElementoMovil(new Vector2(250,50),TAMANO_MADERA.cpy(),-25, ElementoMovil.TIPOS_ELEMENTOS.MADERA));
    }

    public PersonajePrincipal getPersonajePrincipal() {
        return personP;
    }
    public Array<ElementoMovil> getElementosMoviles() {
        return elementoMovil;
    }
    public Array<Enemigo> getEnemigos() {
        return enemigo;
    }

}
