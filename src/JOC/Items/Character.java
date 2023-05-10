package JOC.Items;
import JOC.Game;
import JOC.RefLinks;
import JOC.States.PlayState;

public abstract class Character extends Item {

    public static final int DEFAULT_LIFE            = 10;
    public static final float DEFAULT_SPEED         = 3.0f;
    public static final int DEFAULT_CREATURE_WIDTH  = 50;
    public static final int DEFAULT_CREATURE_HEIGHT = 50;
    public static String direction = "right";
    protected int life;
    public static float speed;
    protected float xMove;
    protected float yMove;

    public Character(RefLinks refLink, float x, float y, int width, int height)
    {

        super(refLink, x,y, width, height);

        life    = DEFAULT_LIFE;
        speed   = DEFAULT_SPEED;
        xMove   = 0;
        yMove   = 0;

    }
    public void Move()
    {
        MoveX();
        MoveY();
    }
    public void MoveX()
    {
        x += xMove;
    }
    public void MoveY()
    {
        y += yMove;
    }
    public int GetLife()
    {
        return life;
    }
    public float GetSpeed()
    {
        return speed;
    }
    public void SetLife(int life)
    {
        this.life = life;
    }
    public void SetSpeed(float speed) {
        this.speed = speed;
    }
    public float GetXMove()
    {
        return xMove;
    }
    public float GetYMove()
    {
        return yMove;
    }
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }

}
