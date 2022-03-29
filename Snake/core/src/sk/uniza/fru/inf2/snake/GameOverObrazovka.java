package sk.uniza.fru.inf2.snake;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverObrazovka extends ScreenAdapter {

    private final SnakeGame game;
    private SpriteBatch batch;
    private BitmapFont font;

    public GameOverObrazovka(SnakeGame game) {
        this.font = new BitmapFont();
        this.game = game;
        this.batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        ScreenUtils.clear(1, 0, 0, 1);

        this.batch.begin();

        this.font.setColor(Color.GOLD);
        this.font.draw(this.batch, "Game Over", 200, 200, 200f,30, false);

        this.batch.end();

    }
}
