package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MejoresPuntuaciones {
    public static String[] puntuacionesAltas = { "0", "0", "0", "0", "0" };
    public static FileHandle altasPuntuaciones= Gdx.files.local("PuntuacionesMasAltas.txt");
    private static String path=Gdx.files.getLocalStoragePath();
    public static String puntuaciones;
    private static SpriteBatch spritebatch;
    private static BitmapFont bitMapFont;

    public static void cargarPuntuaciones(){
        Gdx.app.log("LOG1", ""+path+ altasPuntuaciones);
        if(altasPuntuaciones.exists()){
            puntuaciones = altasPuntuaciones.readString();
            puntuacionesAltas = puntuaciones.split(",");
        }
        else{
            altasPuntuaciones.writeString(0+","
                    +0+","+0+","+
                    0+","+0, false);
        }
    }

    public static void añadirPuntuacion(int puntuacion){
                if(Integer.parseInt(puntuacionesAltas[0])<puntuacion){
                    puntuacionesAltas[4]=puntuacionesAltas[3];
                    puntuacionesAltas[3]=puntuacionesAltas[2];
                    puntuacionesAltas[2]=puntuacionesAltas[1];
                    puntuacionesAltas[1]=puntuacionesAltas[0];
                    puntuacionesAltas[0]=String.valueOf(puntuacion);
                    guardarPuntuaciones();
                }
                else if(Integer.parseInt(puntuacionesAltas[1])<puntuacion){

                    puntuacionesAltas[4]=puntuacionesAltas[3];
                    puntuacionesAltas[3]=puntuacionesAltas[2];
                    puntuacionesAltas[2]=puntuacionesAltas[1];
                    puntuacionesAltas[1]=String.valueOf(puntuacion);
                    guardarPuntuaciones();
                }
                else if(Integer.parseInt(puntuacionesAltas[2])<puntuacion){

                    puntuacionesAltas[4]=puntuacionesAltas[3];
                    puntuacionesAltas[3]=puntuacionesAltas[2];
                    puntuacionesAltas[2]=String.valueOf(puntuacion);
                    guardarPuntuaciones();
                }
                else if(Integer.parseInt(puntuacionesAltas[3])<puntuacion){

                    puntuacionesAltas[4]=puntuacionesAltas[3];
                    puntuacionesAltas[3]=String.valueOf(puntuacion);
                    guardarPuntuaciones();
                }
                else if(Integer.parseInt(puntuacionesAltas[4])<puntuacion){
                    puntuacionesAltas[4]=String.valueOf(puntuacion);
                    guardarPuntuaciones();
                }

    }
    public String[] getPuntuacionesAltas(){
        return puntuacionesAltas;

    }
    private static void guardarPuntuaciones(){

        altasPuntuaciones.writeString(puntuacionesAltas[0]+","
                +puntuacionesAltas[1]+","+puntuacionesAltas[2]+","+
                puntuacionesAltas[3]+","+puntuacionesAltas[4], false);
    }
}
