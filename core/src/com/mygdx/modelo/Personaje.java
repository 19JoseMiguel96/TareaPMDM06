package com.mygdx.modelo;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Personaje {
    private Rectangle rectangulo;
    /**
     * Constructor por defecto
     */
    public Personaje(){
        rectangulo = new Rectangle();
    }
    /**
     * Instancia un personaje
     *
     * @param posicion
     * @param tamano
     * @param velocidad_max
     */
    public Personaje(Vector2 posicion, Vector2 tamano, float velocidad_max) {
        this.posicion = posicion;
        this.tamano = tamano;
        this.velocidad_max = velocidad_max;

        rectangulo = new Rectangle(posicion.x,posicion.y,tamano.x,tamano.y);
    }
    public void setTamanoRectangulo(float width,float height){
        rectangulo.setWidth(width);
        rectangulo.setHeight(height);
    }
    /**
     * Actualiza a posición do rectángulo asociado á forma do gráfico
     *
     */
    public void actualizarRectangulo(){
        rectangulo.x=posicion.x;
        rectangulo.y=posicion.y;
    }

    /**
     * Devolve o rectángulo asociado
     * @return rectangulo
     */
    public Rectangle getRectangulo(){
        return rectangulo;
    }

    /**
     * Velocidad que toma cuando se mueve.
     */
    public float velocidad_max;
    /**
     * Velocidad actual
     */
    protected float velocidad = 0;
    /**
     * Posición
     */
    protected Vector2 posicion;
    /**
     * Tamaño
     */
    protected Vector2 tamano;

    /**
     * Devuelve la posicion
     * @return posicion
     */
    public Vector2 getPosicion() {
        return posicion;
    }

    /**
     * Modifica la posición
     * @param posicion: la nueva posicion
     */
    public void setPosicion(Vector2 posicion) {
        this.posicion = posicion;
        actualizarRectangulo();
    }

    /**
     * Modifica la posición
     *
     * @param x: nueva posición x
     * @param y: nueva posición y
     */
    public void setPosicion(float x, float y) {
        posicion.x = x;
        posicion.y = y;
        actualizarRectangulo();
    }

    /**
     * Modifica la velocidad
     * @param velocidade: la nueva velocidad
     */
    public void setVelocidad(float velocidade) {
        this.velocidad = velocidade;
    }

    /**
     * Devuelve la velocidad
     * @return velocidad
     */
    public float getVelocidad() {
        return velocidad;
    }

    /**
     * Devuelve el tamaño
     * @return tamano
     */
    public Vector2 getTamano() {
        return tamano;
    }
    /**
     * Modifica el tamaño
     * @param tamano: el nuevo tamano.
     */
    public void setTamano(Vector2 tamano) {
        this.tamano=tamano;
        setTamanoRectangulo(tamano.x,tamano.y);
    }
    /**
     * Modifica el tamaño
     *
     * @param width: nuevo tamano de ancho
     * @param height: nuevo tamano de alto
     */
    public void setTamano(float width, float height) {
        this.tamano.set(width,height);
        setTamanoRectangulo(width, height);
    }

    /**
     * Actualiza la posición en función de la velocidad
     * @param delta: tiempo entre una llamada y la siguiente
     */
    public abstract void update(float delta);
}
