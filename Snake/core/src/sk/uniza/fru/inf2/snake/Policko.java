package sk.uniza.fru.inf2.snake;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Policko {

    private Texture textura;

    private Vector2 pozicia;

    public Policko(Texture textura, Vector2 pozicia) {
        this.textura = textura;
        this.pozicia = pozicia;
    }

    public void vykresliSa(SpriteBatch batch) {
        batch.draw(this.textura, pozicia.x * 32, pozicia.y * 32);
    }

    public Vector2 getPozicia() {
        return pozicia;
    }

    protected void setPozicia(Vector2 pozicia) {
        this.pozicia = pozicia;
    }

    public boolean koliduje(Policko policko) {
        return this.pozicia.equals(policko.pozicia);
    }
}
