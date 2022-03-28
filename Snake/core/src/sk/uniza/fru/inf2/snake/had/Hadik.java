package sk.uniza.fru.inf2.snake.had;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hadik {

    private Hlava hlava;
    private Smer smer;

    public Hadik() {
        this.hlava = new Hlava(new Vector2(10, 7));
        this.smer = Smer.VLAVO;
    }

    public void vykresli(SpriteBatch batch) {
        this.hlava.vykresliSa(batch);
    }

    public void pohniSa() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.smer = Smer.HORE;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.smer = Smer.DOLE;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.smer = Smer.VLAVO;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.smer = Smer.VPRAVO;
        }
        this.hlava.posunSa(this.smer);
    }
}
