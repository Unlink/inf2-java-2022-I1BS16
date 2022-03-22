package sk.uniza.fri.prva;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;

public class MojaHra extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Point pozicia;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		pozicia = new Point(0, 0);
	}

	@Override
	public void render () {
		if (Gdx.input.justTouched()) {
			pozicia.setLocation(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
		}


		ScreenUtils.clear(1, 0.5f, 0, 1);

		int x = (Gdx.graphics.getWidth() / 2) - (img.getWidth() / 2);
		int y = (Gdx.graphics.getHeight() / 2) - (img.getHeight() / 2);

		batch.begin();
		batch.draw(img, pozicia.x, pozicia.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
