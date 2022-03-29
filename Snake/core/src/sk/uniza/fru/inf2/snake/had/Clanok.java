package sk.uniza.fru.inf2.snake.had;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import sk.uniza.fru.inf2.snake.Policko;

public class Clanok extends Policko {
    public Clanok(Vector2 pozicia) {
        super(new Texture("clanok.png"), pozicia);
    }

    public void nasleduj(Hlava hlava) {
        this.setPozicia(new Vector2(hlava.getPozicia()));
    }
}
