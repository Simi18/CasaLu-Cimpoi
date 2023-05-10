package JOC.Tiles;
import JOC.Graphics.Assets;

import java.awt.*;

public class TileTypes{

    public static class Strat1 extends Tile
    {
        public Strat1(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.strat1, id);
            collision = true;
        }
    }

    public static class Strat2 extends Tile
    {
        public Strat2(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.strat2, id);
            collision = true;
        }
    }
    public static class Nor1 extends Tile
    {
        public Nor1(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.nor1, id);

        }
    }
    public static class Nor2 extends Tile
    {
        public Nor2(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.nor2, id);
        }
    }
    public static class Tufis1 extends Tile
    {
        public Tufis1(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.tufis1, id);
        }
    }
    public static class Tufis2 extends Tile
    {
        public Tufis2(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.tufis2, id);
        }
    }
    public static class StratB1 extends Tile
    {
        public StratB1(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.stratB1, id);
            collision = true;
        }
    }public static class StratB2 extends Tile
    {
        public StratB2(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.stratB2, id);
            collision = true;
        }
    }public static class Bolovan extends Tile
    {
        public Bolovan(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.bolovan, id);
            collision = true;
        }
    }
    public static class Apa extends Tile
    {
        public Apa(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.apa, id);
        }
    }
    public static class Transparent extends Tile
    {
        public Transparent(int id)
        {
            /// Apel al constructorului clasei de baza
            super(Assets.transparent, id);
        }
    }






}
