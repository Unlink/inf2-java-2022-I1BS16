package sk.uniza.fru.inf2.snake.had;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import sk.uniza.fru.inf2.snake.HernaObrazovka;
import sk.uniza.fru.inf2.snake.Jedlo;

import java.util.LinkedList;

public class Hadik {

    private final HernaObrazovka hernaObrazovka;
    private Hlava hlava;
    private Smer smer;
    private LinkedList<Clanok> telo;
    private float pocitadlo;

    public Hadik(HernaObrazovka hernaObrazovka) {
        this.hernaObrazovka = hernaObrazovka;
        this.hlava = new Hlava(new Vector2(10, 7));
        this.telo = new LinkedList<>();
        this.telo.add(new Clanok(new Vector2(11, 7)));
        this.telo.add(new Clanok(new Vector2(12, 7)));
        this.telo.add(new Clanok(new Vector2(12, 8)));
        this.smer = Smer.VLAVO;
    }

    public void vykresli(SpriteBatch batch) {
        for (Clanok clanok : this.telo) {
            clanok.vykresliSa(batch);
        }

        this.hlava.vykresliSa(batch);
    }

    public void pohniSa(float delta, Jedlo jedlo) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.smer = Smer.HORE;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.smer = Smer.DOLE;
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.smer = Smer.VLAVO;
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.smer = Smer.VPRAVO;
        }

        this.pocitadlo += delta;
        if (this.pocitadlo < 0.25) {
            return;
        }
        this.pocitadlo = 0;


        Clanok posledny = this.telo.removeLast();

        Vector2 poziciaPosledneho = posledny.getPozicia();

        posledny.nasleduj(this.hlava);
        this.telo.addFirst(posledny);
        this.hlava.posunSa(this.smer);

        if (this.hlava.koliduje(jedlo)) {
            this.telo.addLast(new Clanok(poziciaPosledneho));
            hernaObrazovka.umiestniJedlo();
        }

        for (Clanok clanok : this.telo) {
            if (this.hlava.koliduje(clanok)) {
                hernaObrazovka.zobrazGameOver();
            }
        }
    }
}
