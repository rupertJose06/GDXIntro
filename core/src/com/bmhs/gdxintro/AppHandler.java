package com.bmhs.gdxintro;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.bmhs.gdxintro.gfx.utils.TileHandler;

public class AppHandler extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	TextureRegion subImg;

	int x, y;


	int[][] Canvas = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
					  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 9, 5, 5, 0, 9, 5, 5, 9, 0, 0, 1, 1, 1, 1},
					  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 5, 9, 8, 8, 0, 0, 0, 8, 8, 5, 5, 8, 0, 1, 1, 1},
					  {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 8, 8, 0, 0, 5, 5, 5, 0, 0, 0, 0, 8, 8, 0, 1, 1},
					  {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 8, 0, 0, 9, 9, 0, 0, 5, 5, 0, 9, 5, 0, 0, 0, 1, 1},
					  {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 8, 5, 5, 9, 9, 9, 8, 0, 9, 9, 9, 8, 8, 0, 1, 1},
					  {1, 1, 1, 1, 1, 1, 1, 0, 7, 0, 8, 8, 8, 9, 9, 9, 8, 8, 0, 5, 5, 8, 8, 8, 0, 1, 1},
					  {1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 0, 0, 1, 1},
					  {1, 1, 1, 0, 3, 0, 0, 7, 0, 7, 6, 0, 0, 0, 8, 8, 8, 0, 0, 0, 0, 0, 0, 6, 0, 0, 1},
					  {1, 1, 1, 0, 3, 3, 0, 0, 0, 7, 0, 0, 7, 6, 0, 0, 0, 6, 0, 6, 6, 6, 0, 0, 7, 7, 0},
					  {1, 1, 1, 0, 3, 3, 3, 3, 4, 0, 0, 0, 0, 6, 6, 0, 6, 0, 0, 6, 0, 7, 7, 0, 7, 0, 0},
					  {1, 1, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 0, 0, 0, 0, 0, 4, 0, 0, 6, 0, 7, 0, 7, 0},
					  {1, 0, 3, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 0, 4, 4, 4, 0, 0, 7, 0, 6, 0},
					  {0, 0, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 2, 2, 0, 4, 0, 4, 4, 4, 0, 0, 0, 1},
					  {0, 0, 4, 3, 3, 3, 3, 3, 3, 4, 4, 3, 3, 3, 2, 2, 0, 4, 4, 4, 0, 4, 4, 1, 0, 1, 1},
					  {0, 3, 3, 3, 3, 3, 3, 3, 4, 3, 0, 0, 3, 4, 4, 4, 0, 4, 0, 4, 0, 4, 1, 0, 1, 1, 1},
					  {1, 0, 3, 3, 3, 3, 3, 3, 4, 0, 2, 1, 4, 4, 4, 4, 4, 4, 4, 0, 1, 0, 0, 1, 1, 1, 1},
					  {1, 0, 0, 3, 3, 3, 3, 3, 0, 1, 1, 3, 4, 4, 4, 0, 4, 4, 4, 0, 1, 1, 1, 1, 1, 1, 1},
					  {1, 1, 0, 4, 3, 0, 3, 3, 3, 4, 4, 4, 4, 4, 0, 0, 4, 4, 4, 4, 0, 1, 1, 1, 1, 1, 1},
					  {1, 1, 1, 0, 0, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 4, 4, 4, 4, 1, 0, 1, 1, 1, 1, 1, 1},
					  {1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 4, 1, 0, 1, 1, 1, 1, 1, 1, 1},
					  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}};

//	int[][] Canvas = new int[22][27];

	@Override
	public void create () {
		batch = new SpriteBatch();

//		setRandomArray();
		x = 0;
		y = 0;
	}

//	 private void setRandomArray() {
//		for(int r = 0; r < Canvas.length; r++) {
//			 for(int c = 0; c < Canvas[r].length; c++) {
//				 Canvas[r][c] =  MathUtils.random(4);
//			 }
//		}
//	 }

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();

		for(int r = 0; r < Canvas.length; r++) {
			for(int c = 0; c < Canvas[r].length; c++) {
				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(Canvas[r][c]).getTexture(), c * 32, Gdx.graphics.getHeight() - 32 - r * 32);
			}
		}

//		for(int r = 0; r < Gdx.graphics.getHeight(); r+=64) {
//			for(int c = 0; c < Gdx.graphics.getWidth(); c+=64) {
//				batch.draw(TileHandler.getTileHandler().getWorldTileArray().get(x++).getTexture(), c, r);
//				if(x > 5) {
//					x = 0;
//				}
//			}
//		}

		batch.end();

		checkInput();
	}

	public void checkInput() {
//		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
//			y += 10;
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
//			x -= 10;
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
//			y -= 10;
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
//			x += 10;
//		}
//
//		System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
//
//		x = Gdx.input.getX() - img.getWidth() / 2;
//		y = Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight() / 2;
//
//		if(x < (Gdx.input.getX() - img.getWidth() / 2)) {
//			x += 10;
//		}
//		if(x > (Gdx.input.getX() - img.getWidth() / 2)) {
//			x -= 10;
//		}
//		if(y > (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight() / 2)) {
//			y -= 10;
//		}
//		if(y < (Gdx.graphics.getHeight() - Gdx.input.getY() - img.getHeight() / 2)) {
//			y += 10;
//		}

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
