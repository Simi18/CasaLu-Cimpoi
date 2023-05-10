package JOC.Maps;
import JOC.GameWindow.GameWindow;
import JOC.RefLinks;
import JOC.Tiles.Tile;
import JOC.Tiles.TileTypes;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map {

    private RefLinks refLink;
    private int width;
    private int height;
    public int [][]tiles;


    public Map(RefLinks refLink)
    {
        this.refLink = refLink;
        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        loadMap("/Maps/map.txt");
    }
    /*! \fn public  void Update()
       \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
    */
    public  void Update()
    {

    }
    public void Draw(Graphics g)
    {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        for(int y = 0; y < refLink.GetGame().GetHeight()/Tile.TILE_HEIGHT; y++)
        {
            for(int x = 0; x < refLink.GetGame().GetWidth()/Tile.TILE_WIDTH; x++)
            {
                GetTile(x, y).Draw(g, (int)x * Tile.TILE_HEIGHT, (int)y * Tile.TILE_WIDTH);
            }

        }
    }
    public Tile GetTile(int x, int y)
    {
        if(x < 0 || y < 0 || x >= width || y >= height)
        {
            return Tile.transparent;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.apa;
        }
        return t;
    }

//    private void LoadWorld() {
//        //atentie latimea si inaltimea trebuiesc corelate cu dimensiunile ferestrei sau
//        //se poate implementa notiunea de camera/cadru de vizualizare al hartii
//        ///Se stabileste latimea hartii in numar de dale.
//        width = 16;
//        ///Se stabileste inaltimea hartii in numar de dale
//        height = 12;
//        ///Se construieste matricea de coduri de dale
//        tiles = new int[width][height];
//        //Se incarca matricea cu coduri
//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                tiles[x][y] = MiddleEastMap(y, x);
//            }
//        }
//    }
//        private int MiddleEastMap(int x ,int y)
//        {
//            ///Definire statica a matricei de coduri de dale.
//            final int map[][] = {
//                    {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//            return map[x][y];
//        }

        public void loadMap(String path)
        {
            try {
                InputStream is = getClass().getResourceAsStream(path);
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                width = 16;
                height = 12;
                tiles = new int[width][height];
                int col = 0;
                int row = 0;


                String line;
                String numbers[];

                while (col < GameWindow.maxScreenCol && row < GameWindow.maxScreenRow) {
                    line = br.readLine();
                    while (col < GameWindow.maxScreenCol) {
                        numbers = line.split(" ");
                        int num = Integer.parseInt((numbers[col]));
                        tiles[col][row] = num;
                        col++;
                    }
                    if (col == GameWindow.maxScreenCol) {
                        col = 0;
                        row++;
                    }
                }
                //br.close();
            }
            catch(Exception e)
            {

            }
//            int i;
//            int j;
//            for(i = 0; i<10;i++) {
//                for (j = 0; j < 10; j++) {
//                    System.out.println(tiles[i][j]);
//                    System.out.println((" "));
//                }
//                System.out.println("\n");
//            }
        }

    }

