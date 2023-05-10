package JOC.Collision;

import JOC.GameWindow.GameWindow;
import JOC.Items.Character;
import JOC.RefLinks;
import JOC.States.PlayState;
import JOC.Tiles.Tile;

public class ColissionChecker {

    PlayState playState;
    public int tileNum;
    public int tileNum1;
    public int tileNum2;
    public ColissionChecker(PlayState playState) {
        this.playState = playState;
    }


    public void checkTile(Character character) {
        float CharacterLeftWorldX = character.x + character.bounds.x;
        float CharacterRightWorldX = character.x + character.bounds.x + character.bounds.width;

        float CharacterTopWorldY = character.y + character.bounds.y;
        float CharacterBottomWorldY = character.y + character.bounds.y + character.bounds.height;

        int CharacterMidWorldY = (int) (character.y + character.bounds.y + (character.bounds.height/2));


        int CharacterLeftCol = (int) ((int) CharacterLeftWorldX / GameWindow.TILES_SIZE);
        int CharacterRightCol = (int) ((int) CharacterRightWorldX / GameWindow.TILES_SIZE);
        int CharacterTopRow = (int) ((int) CharacterTopWorldY / GameWindow.TILES_SIZE);
        int CharacterBottomRow = (int) ((int) CharacterBottomWorldY / GameWindow.TILES_SIZE);

        int CharacterMid = (int) (CharacterMidWorldY / GameWindow.TILES_SIZE);


        int tileNum1, tileNum2,tileNum3;


        switch (character.direction) {
            case "up":
                CharacterTopRow = (int) ((int) (CharacterTopWorldY - character.speed) / GameWindow.TILES_SIZE);
                tileNum1 = PlayState.map.tiles[CharacterLeftCol][CharacterTopRow];
                tileNum2 = PlayState.map.tiles[CharacterRightCol][CharacterTopRow];
                if (Tile.tiles[tileNum1].collision || Tile.tiles[tileNum2].collision) {
                    character.collisionOn = true;
                }
                break;
            case "down":
                CharacterBottomRow = (int) ((int) (CharacterBottomWorldY + character.speed) / GameWindow.TILES_SIZE);
                tileNum1 = PlayState.map.tiles[CharacterLeftCol][CharacterBottomRow];
                tileNum2 = PlayState.map.tiles[CharacterRightCol][CharacterBottomRow];
                if (Tile.tiles[tileNum1].collision || Tile.tiles[tileNum2].collision) {
                    character.collisionOn = true;
                }
                break;
            case "left":
                CharacterLeftCol = (int) ((int) (CharacterLeftWorldX - character.speed) / GameWindow.TILES_SIZE);
                tileNum1 = PlayState.map.tiles[CharacterLeftCol][CharacterTopRow];
                tileNum2 = PlayState.map.tiles[CharacterLeftCol][CharacterBottomRow];

                tileNum3 = PlayState.map.tiles[CharacterLeftCol][CharacterMid];

                if (Tile.tiles[tileNum1].collision || Tile.tiles[tileNum2].collision || Tile.tiles[tileNum3].collision) {
                    character.collisionOn = true;
                }
                break;
            case "right":
                CharacterRightCol = (int) ((int) (CharacterRightWorldX + character.speed) / GameWindow.TILES_SIZE);
                tileNum1 = PlayState.map.tiles[CharacterRightCol][CharacterTopRow];
                tileNum2 = PlayState.map.tiles[CharacterRightCol][CharacterBottomRow];

                tileNum3 = PlayState.map.tiles[CharacterRightCol][CharacterMid];
                if (Tile.tiles[tileNum1].collision || Tile.tiles[tileNum2].collision || Tile.tiles[tileNum3].collision) {
                    character.collisionOn = true;
                }
                break;

        }
    }
    public boolean onTheGround(Character character)
    {
        int CharacterRow = (int) ((character.y + character.bounds.y + character.bounds.height + 10) /GameWindow.TILES_SIZE);
        int CharacterCol1  = (int) ((character.x + character.bounds.x + 3) / GameWindow.TILES_SIZE);
        int CharacterCol2  = (int) ((character.x + character.bounds.width - 3) / GameWindow.TILES_SIZE);
        //System.out.println(CharacterCol);

        System.out.println("Row: " + CharacterRow);
        //System.out.println("Col: " + CharacterCol);

        tileNum1 = PlayState.map.tiles[CharacterCol1][CharacterRow];
        tileNum2 = PlayState.map.tiles[CharacterCol2][CharacterRow];

        if(Tile.tiles[tileNum1].collision || Tile.tiles[tileNum2].collision)
            return true;
        else return false;
    }
}

