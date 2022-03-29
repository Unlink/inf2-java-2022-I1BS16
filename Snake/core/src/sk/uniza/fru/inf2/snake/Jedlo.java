package sk.uniza.fru.inf2.snake;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import sk.uniza.fru.inf2.snake.Policko;

public class Jedlo extends Policko {
    public Jedlo() {
        super(new Texture("jedlo.png"), new Vector2(0, 0));
    }
}
