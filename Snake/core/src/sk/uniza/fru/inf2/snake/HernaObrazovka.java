package sk.uniza.fru.inf2.snake;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import sk.uniza.fru.inf2.snake.had.Hadik;

public class HernaObrazovka extends ScreenAdapter {

    private SpriteBatch batch;
    private Hadik hadik;
    private float pocitadlo;

    public HernaObrazovka() {
        this.batch = new SpriteBatch();
        this.hadik = new Hadik();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 1, 0, 1);

        //Update state
        this.pocitadlo += delta;
        if (this.pocitadlo > 0.25) {
            this.hadik.pohniSa();
            this.pocitadlo = 0;
        }

        //Render
        batch.begin();
        this.hadik.vykresli(this.batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
