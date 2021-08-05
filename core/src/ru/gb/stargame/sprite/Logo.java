package ru.gb.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.stargame.base.Sprite;
import ru.gb.stargame.math.Rect;

public class Logo extends Sprite {

    private static final float V_LEN = 0.001f;
    private Vector2 touch;
    private Vector2 v;


    public Logo(TextureRegion region) {
        super(region);
        this.touch = new Vector2();
        this.v = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
        pos.set(0f, -0.35f);
    }

    @Override
    public void draw(SpriteBatch batch) {
        v.set(touch);
        if (v.sub(pos).len() <=v.len()) {
            pos.set(touch);
        }else{
            pos.add(v);
        }
        super.draw(batch);
    }

    @Override
    public void update(float delta) {
        if (touch.dst(pos) > V_LEN) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }
}
