package com.mygdx.modelo;

import com.badlogic.gdx.math.Vector2;

public class PersonajePrincipal extends Personaje {

    private Vector2 velocidad;

    public PersonajePrincipal(Vector2 posicion, Vector2 tamano, float velocidade_max) {
        super(posicion, tamano, velocidade_max);
        velocidad = new Vector2(0,0);
        getRectangulo().setSize(tamano.x/2);

    }


    public float getVelocidadX(){
        return velocidad.x;
    }
    public float getVelocidadY(){
        return velocidad.y;
    }

    public void setVelocidadX(float x){
        velocidad.x = x;

    }
    public void setVelocidadY(float y){
        velocidad.y = y;
    }
    @Override
    public void actualizarRectangulo(){

        getRectangulo().x = getPosicion().x+getTamano().x/4;
        getRectangulo().y = getPosicion().y+getTamano().y/4;

    }

    @Override
    public void update(float delta) {
        // TODO Auto-generated method stub
        setPosicion(getPosicion().x+velocidad.x*delta, getPosicion().y+velocidad.y*delta);
    }
}
