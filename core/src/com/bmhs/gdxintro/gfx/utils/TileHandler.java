package com.bmhs.gdxintro.gfx.utils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.bmhs.gdxintro.gfx.assets.Tile;
import com.bmhs.gdxintro.gfx.assets.WorldTile;


public class TileHandler {

    public static TileHandler tileHandler = null;

    private int spriteOnSheetHeight, spriteOnSheetWidth;

    private String primaryColorSheetPath = "primary color spritesheet.png";


    private Array<WorldTile> worldTileArray;

    private TileHandler() {
        worldTileArray = new Array<>();
        spriteOnSheetHeight = Tile.ON_SCREEN_DEFAULT_HEIGHT;
        spriteOnSheetWidth = Tile.ON_SCREEN_DEFAULT_WIDTH;

        Texture tempTexture = new Texture(primaryColorSheetPath);

        TextureRegion tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 4, spriteOnSheetHeight * 0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blackWorldTile = new WorldTile(tempRegion, 0, "black");
        worldTileArray.add(blackWorldTile);
//good
        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 2, spriteOnSheetHeight * 0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile whiteWorldTile = new WorldTile(tempRegion, 1, "white");
        worldTileArray.add(whiteWorldTile);
//good
        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 1, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile redWorldTile = new WorldTile(tempRegion, 2, "red");
        worldTileArray.add(redWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 15, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile lightBlueWorldTile = new WorldTile(tempRegion, 3, "lightblue");
        worldTileArray.add(lightBlueWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 17, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile blueWorldTile = new WorldTile(tempRegion, 4, "blue");
        worldTileArray.add(blueWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 8, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile yellowWorldTile = new WorldTile(tempRegion, 5, "yellow");
        worldTileArray.add(yellowWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 2, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile greenWorldTile = new WorldTile(tempRegion, 6, "green");
        worldTileArray.add(greenWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 7, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile lightGreenWorldTile = new WorldTile(tempRegion, 7, "lightgreen");
        worldTileArray.add(lightGreenWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 6, spriteOnSheetHeight * 0, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile darkPinkWorldTile = new WorldTile(tempRegion, 8, "darkerpink");
        worldTileArray.add(darkPinkWorldTile);

        tempRegion = new TextureRegion(tempTexture, spriteOnSheetWidth * 0, spriteOnSheetHeight * 19, spriteOnSheetWidth, spriteOnSheetHeight);
        WorldTile pinkWorldTile = new WorldTile(tempRegion, 9, "pink");
        worldTileArray.add(pinkWorldTile);

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