package com.bmhs.gdxintro.gfx.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.bmhs.gdxintro.gfx.assets.Tile;
import com.bmhs.gdxintro.gfx.assets.WorldTile;


public class TileHandler {

    public static TileHandler tileHandler = null;

    private int spriteOnSheetHeight, spriteOnSheetWidth;

    private String primaryColorSheetPath = "primaryColorSheet.png";


    private Array<WorldTile> worldTileArray;

    private TileHandler() {
        worldTileArray = new Array<>();
        spriteOnSheetHeight = Tile.ON_SCREEN_DEFAULT_HEIGHT;
        spriteOnSheetWidth = Tile.ON_SCREEN_DEFAULT_WIDTH;

        Texture tempTexture = new Texture(primaryColorSheetPath);

        TextureRegion tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 2, spriteOnSheetHeight * 0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blackWorldTile = new WorldTile(tempRegion, 0, "black");
        worldTileArray.add(blackWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 1, spriteOnSheetHeight * 0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile whiteWorldTile = new WorldTile(tempRegion, 1, "white");
        worldTileArray.add(whiteWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 2, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile redWorldTile = new WorldTile(tempRegion, 2, "red");
        worldTileArray.add(redWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 8, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blueWorldTile = new WorldTile(tempRegion, 3, "blue");
        worldTileArray.add(blueWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 9, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile pinkWorldTile = new WorldTile(tempRegion, 4, "pink");
        worldTileArray.add(pinkWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 4, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile yellowWorldTile = new WorldTile(tempRegion, 5, "yellow");
        worldTileArray.add(yellowWorldTile);

    }

    public Array<WorldTile> getWorldTileArray() {
        return worldTileArray;
    }

    public static TileHandler getTileHandler() {
        if(tileHandler == null) {
            tileHandler = new TileHandler();
        }
        return tileHandler;
    }

}
