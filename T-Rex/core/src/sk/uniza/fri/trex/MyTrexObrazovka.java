package sk.uniza.fri.trex;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.LinkedList;
import java.util.Random;

public class MyTrexObrazovka extends ScreenAdapter {
    public static final int SIRKA_PLOCHY = 800;
    public static final int VYSKA_PLOCHY = 600;


    private final MyTrexGame myTrexGame;
    private final SpriteBatch batch;
    private final ShapeRenderer shapeRenderer;

    private Camera kamera;
    private Viewport viewport;

    private final Texture img;
    private double yPos = 10;
    private boolean inJump = false;
    private boolean rising = true;
    private final int jumpHeight = 150;

    private final LinkedList<Prekazka> prekazky = new LinkedList<Prekazka>();
    private final Random rnd = new Random();
    private BitmapFont font;

    public MyTrexObrazovka(MyTrexGame myTrexGame) {
        this.myTrexGame = myTrexGame;
        this.batch = new SpriteBatch();
        this.shapeRenderer = new ShapeRenderer();
        this.img = new Texture("badlogic.jpg");
        this.font = new BitmapFont();

        this.kamera = new OrthographicCamera();
        this.viewport = new FitViewport(SIRKA_PLOCHY, VYSKA_PLOCHY, this.kamera);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.RED);

        //Input spracovanie
        if (!this.inJump && Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            this.inJump = true;
            this.rising = true;
            this.yPos = 10;
        }

        if (this.inJump) {
            System.out.println("Jump");
            if (this.rising) {
                this.yPos = (this.yPos + delta * Math.sqrt(2*(this.jumpHeight - this.yPos)) * 40);
                if (this.yPos > this.jumpHeight) {
                    this.rising = false;
                    this.yPos = this.jumpHeight -1;
                }
            }
            else {
                this.yPos = (this.yPos - delta * Math.sqrt(2*(this.jumpHeight - this.yPos)) * 30);
                if (this.yPos < 10) {
                    this.inJump = false;
                    this.yPos = 10;
                }
            }
            System.out.println("pos " + this.yPos);
        }

        //Posun prekazok
        for (Prekazka prekazka : this.prekazky) {
            prekazka.x -= delta * 250;
        }

        //odstranenie starych prekazok
        while (this.prekazky.size() > 0 && this.prekazky.getFirst().x < 0) {
            this.prekazky.removeFirst();
        }

        //Pridanie novych
        if (this.rnd.nextInt() < 10 && (this.prekazky.size() == 0 || this.prekazky.getLast().x < 200)) {
            this.prekazky.add(new Prekazka(Gdx.graphics.getWidth(), this.rnd.nextInt(2) + 1, this.rnd.nextBoolean()));
        }


        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        this.shapeRenderer.setColor(Color.GREEN);
        this.shapeRenderer.rect(10, (float) this.yPos, 40, 100);

        //Vykrelsenie prekazok
        for (Prekazka prekazka : this.prekazky) {
            this.shapeRenderer.setColor(Color.BLACK);
            this.shapeRenderer.rect(prekazka.x, 10, prekazka.width, prekazka.height);
        }
        this.shapeRenderer.end();

        this.batch.begin();
        this.font.draw(this.batch, Gdx.graphics.getFramesPerSecond()+"fps", 10, Gdx.graphics.getHeight() - 20);
        this.batch.end();

    }

    @Override
    public void resize(int width, int height) {
        this.viewport.update(width, height, true);
        this.batch.setProjectionMatrix(this.kamera.combined);
        this.shapeRenderer.setProjectionMatrix(this.kamera.combined);
    }

    @Override
    public void dispose() {
        this.batch.dispose();
        this.img.dispose();
    }


    public class Prekazka {
        int x;
        int width;
        int height;

        public Prekazka(int x, int length, boolean big) {
            this.x = x;
            this.width = 30 * length;
            this.height = big ? 60 : 30;
        }


    }
}
