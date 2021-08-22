package ru.gb.stargame;


import com.badlogic.gdx.Game;

import ru.gb.stargame.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create () {
		setScreen(new MenuScreen(this));
	}

}
