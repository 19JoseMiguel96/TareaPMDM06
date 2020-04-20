package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MiJuegoGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Salta!";
		DisplayMode displaymode = LwjglApplicationConfiguration
				.getDesktopDisplayMode();
		config.width = displaymode.width;
		config.height = displaymode.height;
		config.fullscreen = true;
		/*
		config.width = 800;
		config.height = 480;
		*/
		config.resizable=true;
		config.addIcon("iconoJuego.png", Files.FileType.Internal);
		new LwjglApplication(new MiJuegoGame(), config);
	}
}
