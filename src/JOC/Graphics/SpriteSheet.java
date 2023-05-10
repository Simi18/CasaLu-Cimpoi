package JOC.Graphics;

import java.awt.image.BufferedImage;
public class SpriteSheet {

    private BufferedImage  spriteSheet;
    //private static final int    tileWidth   = 1;
    //private static final int    tileHeight  = 1;

    public SpriteSheet(BufferedImage buffImg)
    {
        spriteSheet = buffImg;
    }
    public BufferedImage crop(int x, int y,int w,int h)
    {
        return spriteSheet.getSubimage(x, y ,w, h);
    }
}
