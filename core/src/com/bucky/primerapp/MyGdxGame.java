package com.bucky.primerapp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import static java.awt.Color.*;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{

	private SpriteBatch batch;
	private BitmapFont font;
	private int screenWidth, screenHeight;
	private String message = "Touch me";

	@Override
	public void create () {
		batch = new SpriteBatch();
		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		font = new BitmapFont();
		font.setColor(Color.GREEN);
		font.scale(5);

		Gdx.input.setInputProcessor(this);
	}

	public void dispose(){
		batch.dispose();
		font.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		BitmapFont.TextBounds textSize = font.getBounds(message);
		float x = screenWidth/2 - textSize.width/2;
		float y = screenHeight/2 + textSize.height/2;




		batch.begin();

		font.draw(batch,message,x,y);

		batch.end();

	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		message = "Touch down at " + screenX + "," + screenY;message = "Touch down at " + screenX + "," + screenY;
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		message = "Touch up at " + screenX + "," + screenY;
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		message = "Dragging at " + screenX + "," + screenY;
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
