package JOC.Graphics;

import java.awt.image.BufferedImage;

public class Assets {

    public static BufferedImage baiatuStaD;
    public static BufferedImage baiatuMergeD1;
    public static BufferedImage baiatuMergeD2;
    public static BufferedImage baiatuMergeD3;
    public static BufferedImage baiatuMergeD4;
    public static BufferedImage baiatuStaClipD;
    public static BufferedImage baiatuStaS;
    public static BufferedImage baiatuMergeS1;
    public static BufferedImage baiatuMergeS2;
    public static BufferedImage baiatuMergeS3;
    public static BufferedImage baiatuMergeS4;
    public static BufferedImage baiatuStaClipS;
    //____________________________________________________
    public static BufferedImage strat1;
    public static BufferedImage strat2;
    public static BufferedImage nor1;
    public static BufferedImage nor2;
    public static BufferedImage tufis1;
    public static BufferedImage tufis2;
    public static BufferedImage stratB1;
    public static BufferedImage stratB2;
    public static BufferedImage bolovan;
    public static BufferedImage apa;
    public static BufferedImage transparent;



    public static void Init()
    {
        SpriteSheet baiatuD = new SpriteSheet(ImageLoader.LoadImage("/textures/baiatuD.png"));

        baiatuStaD    = baiatuD.crop(14 ,13,73,142);
        baiatuStaClipD= baiatuD.crop(95 ,13,73,142);
        baiatuMergeD1 = baiatuD.crop(174,13,73,142);
        baiatuMergeD2 = baiatuD.crop(268,13,73,142);
        baiatuMergeD3 = baiatuD.crop(356,13,78,142);
        baiatuMergeD4 = baiatuD.crop(449,13,73,142);

        SpriteSheet baiatuS = new SpriteSheet(ImageLoader.LoadImage("/textures/baiatuS.png"));

        baiatuStaS    = baiatuS.crop(681,13,73,142);
        baiatuStaClipS= baiatuS.crop(600,13,73,142);
        baiatuMergeS1 = baiatuS.crop(521,13,73,142);
        baiatuMergeS2 = baiatuS.crop(427,13,73,142);
        baiatuMergeS3 = baiatuS.crop(334,13,78,142);
        baiatuMergeS4 = baiatuS.crop(247,13,73,142);

        SpriteSheet Platformer1 = new SpriteSheet(ImageLoader.LoadImage("/tile/Platfor_Tiles_Free.png"));
        strat1 = Platformer1.crop(773,1350,257,257);
        strat2 = Platformer1.crop(773,1092,257,257);
        nor1 = Platformer1.crop(0,0,301,201);
        nor2 = Platformer1.crop(302,0,300,201);
        tufis1 = Platformer1.crop(0,202,254,169);
        tufis2 = Platformer1.crop(255,202,255,169);
        stratB1 = Platformer1.crop(1031,455,257,257);
        stratB2 = Platformer1.crop(515,1276,257,257);
        bolovan = Platformer1.crop(0,877,256,178);
        apa = Platformer1.crop(257,1318,257,176);
        transparent = Platformer1.crop(1445,1060,1,1);
    }
}

