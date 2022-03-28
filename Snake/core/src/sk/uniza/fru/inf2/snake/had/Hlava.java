package sk.uniza.fru.inf2.snake.had;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import sk.uniza.fru.inf2.snake.Policko;

public class Hlava extends Policko {

    public Hlava(Vector2 pozicia) {
        super(new Texture("hlava.png"), pozicia);
    }

    public void posunSa(Smer smer) {
        Vector2 staraPozicia = this.getPozicia();
        this.setPozicia(new Vector2(
                (staraPozicia.x + smer.getPosunX() + 20) % 20,
                (staraPozicia.y + smer.getPosunY() + 15) % 15));
    }
}
