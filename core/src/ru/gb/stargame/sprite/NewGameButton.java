package ru.gb.stargame.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.gb.stargame.base.BaseButton;
import ru.gb.stargame.math.Rect;
import ru.gb.stargame.screen.GameScreen;

public class NewGameButton extends BaseButton {

    private static final float HEIGHT = 0.06f;
    private static final float ANIMATE_INTERVAL = 0.05f;

    private GameScreen gameScreen;

    private float animateTimer;
    private boolean scaleUp = false;

    public NewGameButton(TextureAtlas atlas, GameScreen gameScreen) {
        super(atlas.findRegion("button_new_game"));
        this.gameScreen = gameScreen;
    }

    @Override
    public void update(float delta) {
        animateTimer += delta;
        if (animateTimer > ANIMATE_INTERVAL) {
            animateTimer = 0f;
            if (scaleUp) {
                scale += delta;
            } else {
                scale -= delta;
            }
            if (scale <= 0.9f) {
                scaleUp = true;
            }
            if (scale >= 1) {
                scaleUp = false;
            }
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        setHeightProportion(HEIGHT);
        setTop(worldBounds.pos.y);
    }

    @Override
    public void action() {
        gameScreen.startNewGame();
    }
}