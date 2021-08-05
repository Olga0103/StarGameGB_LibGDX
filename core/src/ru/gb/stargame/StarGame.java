package ru.gb.stargame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class StarGame extends ApplicationAdapter {

	SpriteBatch batch;
	Texture img;
	private Vector2 pos;
	private Vector2 v;
	private Vector2 move;
	private float length;

	@Override
	public void create() {
		super.create();
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		//img = new Texture("background.jpg");
		pos = new Vector2(100, 100);
		v = new Vector2(1, 1);
		move = new Vector2(0, 0);
	}

	@Override
	public void render(float delta) {

		super.render(delta);
		batch.begin();
		batch.draw(img, pos.x, pos.y);
		batch.end();
		if (move.len() >= length) {
			v.setZero();
			move.setZero();
		}
		pos.add(v);
		move.add(v);
	}


	@Override
	public void dispose() {
		super.dispose();
//		batch.dispose();
//		img.dispose();
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		move.setZero();
		screenY = Gdx.graphics.getHeight() - screenY;
		float x = pos.x - screenX;
		float y = pos.y - screenY;
		v.sub(new Vector2(x,y).scl(1/Math.min(Math.abs(x),Math.abs(y))));
		length = new Vector2(x,y).len();
		return super.touchDown(screenX, screenY, pointer, button);
	}
}
