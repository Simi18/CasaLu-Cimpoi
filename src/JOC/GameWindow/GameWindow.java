package JOC.GameWindow;

import java.awt.Color;
import java.awt.GradientPaint;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GameWindow {

    private JFrame wndFrame;
    private String wndTitle;

    public static final int tileSize = 48;
    public final static float SCALE = 1f;
    public final static float TILES_SIZE = tileSize * SCALE;
    public static int maxScreenCol = 16;
    public static int maxScreenRow = 12;
    private int wndWidth;
    private int wndHeight;
    public int width = (int) TILES_SIZE * maxScreenCol;
    public int height = (int) TILES_SIZE * maxScreenRow;
    private Canvas canvas;

    public GameWindow(String title)
    {
        wndTitle = title;
        wndWidth = width;
        wndHeight = height;
        wndFrame = null;
    }

    public void BuildGameWindow() {
        if (wndFrame != null)
            return;

        wndFrame = new JFrame(wndTitle);
        wndFrame.setSize(wndWidth, wndHeight);
        wndFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wndFrame.setLocationRelativeTo(null);
        wndFrame.setVisible(true);
        wndFrame.getContentPane().setBackground(new Color(182, 208, 226, 250));

        canvas = new Canvas();
        canvas.setFocusable(false);
        canvas.setPreferredSize(new Dimension(wndWidth, wndHeight));
        canvas.setMaximumSize(new Dimension(wndWidth, wndHeight));
        canvas.setMinimumSize(new Dimension(wndWidth, wndHeight));
        wndFrame.add(canvas);
        wndFrame.pack();
    }


    public int GetWndWidth() {
        return wndWidth;
    }

    public int GetWndHeight() {
        return wndHeight;
    }

    public Canvas GetCanvas() {
        return canvas;
    }

    public JFrame GetWndFrame() {
        return wndFrame;
    }


}
