package sk.uniza.fru.inf2.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class SnakeGame extends Game {

	@Override
	public void create() {
		this.setScreen(new HernaObrazovka(this));
	}
}
