package JOC.Tiles;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile
{
    public static final int NO_TILES   = 32;
    public static Tile[] tiles          = new Tile[NO_TILES];
    public boolean collision = false;

    public static Tile strat1           = new TileTypes.Strat1(1);
    public static Tile strat2           = new TileTypes.Strat2(2);
    public static Tile stratB1          = new TileTypes.StratB1(3);
    public static Tile stratB2          = new TileTypes.StratB2(4);
    public static Tile apa              = new TileTypes.Apa(5);
    public static Tile nor1              = new TileTypes.Nor1 (10);
    public static Tile nor2              = new TileTypes.Nor2 (11);
    public static Tile transparent       = new TileTypes.Transparent(0);
    public static Tile bolovan           = new TileTypes.Bolovan(15);
    public static Tile tufis1            = new TileTypes.Tufis1(12);
    public static Tile tufis2            = new TileTypes.Tufis2(13);

    public static final int TILE_WIDTH  = 48;
    public static final int TILE_HEIGHT = 48;

    protected BufferedImage img;
    protected final int id;

    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    /*! \fn public void Update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void Update()
    {

    }

    public void Draw(Graphics g, int x, int y)
    {
        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    /*! \fn public boolean IsSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean IsSolid()
    {
        return collision;
    }

    public int GetId()
    {
        return id;
    }
}
