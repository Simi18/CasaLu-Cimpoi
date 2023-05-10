package JOC.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

import JOC.GameWindow.GameWindow;
import JOC.RefLinks;
import JOC.Graphics.Assets;
import JOC.States.PlayState;
import JOC.Tiles.Tile;


public class Baiat extends Character {
    private BufferedImage image;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int spriteCounterClip1 = 0;
    public int spriteCounterClip2 = 0;
    public int spriteStat = 1;
    public boolean inAir = false;
    public int jumpStrength=0;
    private static Baiat singleton;

    private Baiat(RefLinks refLink, float x, float y)
    {
        super(refLink, x,y, 60, 106);
        image = Assets.baiatuStaD;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 5;
        normalBounds.y = 10;
        normalBounds.width = 40;
        normalBounds.height = 87;

        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea de atac
        attackBounds.x = 0;
        attackBounds.y = 0;
        attackBounds.width = 60;
        attackBounds.height = 106;
    }

    public static Baiat getInstance(RefLinks refLink, float x, float y)
    {
        if(singleton == null) {
            singleton = new Baiat(refLink,x,y);
        }
        return singleton;
    }

    @Override
    public void Update() {

        GetInput();

        collisionOn = false;
        PlayState.cChecker.checkTile(this);

        if (!collisionOn)
            switch (direction) {
                case "left":
                    if (x > 0)
                        xMove -= speed;
                    break;
                case "right":
                    if (x < refLink.GetWidth()-5)
                        xMove += speed;
                    break;
            }

        if(refLink.GetKeyManager().jump && !inAir)
        {
            inAir = true;
            jumpStrength = 24;
            System.out.println("SPACE");
        }

        if (inAir || !PlayState.cChecker.onTheGround(this)) {

            if(inAir) {
                y -= jumpStrength;
                jumpStrength -= 1;
            }
            if(!PlayState.cChecker.onTheGround(this)) {
                y += 8;
            }

            if (PlayState.cChecker.onTheGround(this)) {
                    inAir = false; // Sfârșitul săriturii
                    System.out.println("inAir FALSE");
            }
        }

        Move();

        switch(direction)
        {
            case "left":
                if(spriteNum == 1)
                    image = Assets.baiatuMergeS1;
                if(spriteNum == 2)
                    image = Assets.baiatuMergeS2;
                if(spriteNum == 3)
                    image = Assets.baiatuMergeS3;
                if(spriteNum == 4)
                    image = Assets.baiatuMergeS4;
                break;

            case "right":
                if(spriteNum == 1)
                    image = Assets.baiatuMergeD1;
                if(spriteNum == 2)
                    image = Assets.baiatuMergeD2;
                if(spriteNum == 3)
                    image = Assets.baiatuMergeD3;
                if(spriteNum == 4)
                    image = Assets.baiatuMergeD4;
                break;
            case "rightSta":
                if(spriteStat == 1)
                    image = Assets.baiatuStaD;
                else
                    image = Assets.baiatuStaClipD;
                break;
            case "leftSta":
                if(spriteStat == 1)
                    image = Assets.baiatuStaS;
                else
                    image = Assets.baiatuStaClipS;
                break;
        }
    }

    private void GetInput()
    {
        xMove = 0;
       // yMove = 0;

            if (refLink.GetKeyManager().left) {
                direction = "left";
            }

            if (refLink.GetKeyManager().right ) {
                direction = "right";
            }

            if (!refLink.GetKeyManager().right && !refLink.GetKeyManager().left && Objects.equals(direction, "right")) {
                direction = "rightSta";
                spriteCounter = 0;
            }

            if (!refLink.GetKeyManager().right && !refLink.GetKeyManager().left && Objects.equals(direction, "left")) {
                direction = "leftSta";
                spriteCounter = 0;
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1)
                    spriteNum = 2;
                else if (spriteNum == 2)
                    spriteNum = 3;
                else if (spriteNum == 3)
                    spriteNum = 4;
                else if (spriteNum == 4)
                    spriteNum = 1;
                spriteCounter = 0;
            }

            spriteCounterClip1++;
            spriteCounterClip2++;
            if (spriteCounterClip1 > 90) {
                spriteStat = 2;
                spriteCounterClip1 = 0;
            }
            if (spriteCounterClip2 > 15) {
                spriteStat = 1;
                spriteCounterClip2 = 0;
            }
    }


    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, width, height, null);

        //doar pentru debug daca se doreste vizualizarea dreptunghiului de coliziune altfel se vor comenta urmatoarele doua linii
        g.setColor(Color.blue);
        g.drawRect((int)(x + bounds.x), (int)(y + bounds.y), bounds.width, bounds.height);
    }
}
