package JOC.Items;

import JOC.GameWindow.GameWindow;
import JOC.RefLinks;

import java.awt.*;
public abstract class Item {
    //jump/gravity
    public float airSpeed = 0f;
    public float gravity = 0.04f + GameWindow.SCALE;
    public float jumpSpeed = -2.25f * GameWindow.SCALE;
    public float fallSpeedAfterCollision = 0.5f * GameWindow.SCALE;

    public static float x;
    public static float y;
    protected int width;
    public int height;
    public static Rectangle bounds;
    protected Rectangle normalBounds;
    protected Rectangle attackBounds;
    protected RefLinks refLink;
    public static boolean collisionOn = false;


    public Item(RefLinks refLink, float x, float y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.refLink = refLink;

        normalBounds = new Rectangle(0, 0, width, height);
        attackBounds = new Rectangle(0, 0, width, height);

        bounds = normalBounds;
    }
    public abstract void Update();
    public abstract void Draw(Graphics g);
    public float GetX()
    {
        return x;
    }
    public float GetY()
    {
        return y;
    }
    public int GetWidth()
    {
        return width;
    }
    public int GetHeight()
    {
        return height;
    }
    public void SetX(float x)
    {
        this.x = x;
    }
    public void SetY(float y)
    {
        this.y = y;
    }
    public void SetWidth(int width)
    {
        this.width = width;
    }
    public void SetHeight(int height)
    {
        this.height = height;
    }
    public void SetNormalMode()
    {
        bounds = normalBounds;
    }
    public void SetAttackMode()
    {
        bounds = attackBounds;
    }
}
