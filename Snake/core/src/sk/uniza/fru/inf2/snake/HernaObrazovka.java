package sk.uniza.fru.inf2.snake;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import sk.uniza.fru.inf2.snake.had.Hadik;

import java.util.Random;

public class HernaObrazovka extends ScreenAdapter {

    private final SnakeGame game;
    private SpriteBatch batch;
    private Hadik hadik;
    private Jedlo jedlo;
    private Random generator;

    public HernaObrazovka(SnakeGame snakeGame) {
        this.game = snakeGame;
        this.batch = new SpriteBatch();
        this.hadik = new Hadik(this);
        this.jedlo = new Jedlo();
        this.generator = new Random();
        this.umiestniJedlo();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);

        //Update state
        this.hadik.pohniSa(delta, this.jedlo);

        //Render
        batch.begin();
        this.jedlo.vykresliSa(this.batch);
        this.hadik.vykresli(this.batch);
        batch.end();
    }

    public void umiestniJedlo() {
        this.jedlo.setPozicia(new Vector2(generator.nextInt(20), generator.nextInt(15)));
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    public void zobrazGameOver() {
        this.game.setScreen(new GameOverObrazovka(this.game));
    }
}
