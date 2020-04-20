package com.mygdx.modelo;

import com.badlogic.gdx.math.Vector2;

public class Enemigo extends Personaje {
    public static enum TIPOS_ELEMENTOS {ARANA, ABEJA};
    private TIPOS_ELEMENTOS tipo;

    public Enemigo(Vector2 posicion, Vector2 tamano, float velocidad_max, TIPOS_ELEMENTOS tipo) {
        super(posicion, tamano, velocidad_max);
        setVelocidad(velocidad_max);
        this.tipo=tipo;
    }
    public TIPOS_ELEMENTOS getTipo() {
        return tipo;
    }
    @Override
    public void update(float delta) {
        setPosicion(posicion.add(velocidad*delta,0));
    }
}
