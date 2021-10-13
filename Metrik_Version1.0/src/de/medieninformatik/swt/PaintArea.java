package de.medieninformatik.swt;

/**
 * @author Jessica Herrmann, 29060
 * @author Frieda Kolbe, m29061
 * Software engineering, practical training, task 1
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

/**
 * The class offers a Canvas to paint on and manages the action which happens on mouse clicks.
 */
public class PaintArea extends Canvas implements MouseListener {
    private int douClX, douClY, douClX1, douClY1;
    private int circleCount;
    private boolean reset;
    private final int DIA = 20;

    /**
     * Setting standards of the area and calls method to initialize the declared variables.
     */
    public PaintArea() {
        setSize(500, 400);
        addMouseListener(this);
        resetValues();
    }

    /**
     * Following variables get a first value:
     * 2 coordinates for the center point of each circle
     * counter for circles
     * boolean which should become true when area needs to be renewed
     */
    private void resetValues() {
        douClX = douClY = douClX1 = douClY1 = -1;
        circleCount = 0;
        reset = false;
    }

    /**
     * Calls methods to draw first and second circle and to clear the area after that.
     * @param g for painting
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        if (circleCount == 1) drawEllipse(douClX1, douClY1, g2d);
        drawEllipse(douClX, douClY, g2d);

        if (reset) {
            g.clearRect(0, 0, 500, 400);
            resetValues();
        }
    }

    /**
     * Actual painting of a circle/ellipse happens here.
     * Pre-condition: a double mouse click has already set the coordinates (from default -1).
     * @param x coordinate of center point
     * @param y second coordinate of center point
     * @param g2d for painting
     */
    private void drawEllipse(int x, int y, Graphics2D g2d) {
        if (x >= 0 && y >= 0) {
            Ellipse2D ellipse2D1 = new Ellipse2D.Float(x, y, DIA, DIA);
            g2d.draw(ellipse2D1);
            circleCount++;
        }
    }

    /**
     * When mouse is double clicked the new coordinates for the next circle are saved or reset will be activated.
     * The offset of - DIA/2 shifts the origin point of the circle so that the mouse position really is the center.
     * To apply the changes we call repaint().
     * @param me a mouse click
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getClickCount() == 2) {
            switch (circleCount) {
                case 0 -> {
                    douClX = me.getX() - DIA/2;
                    douClY = me.getY() - DIA/2;
                }
                case 1 -> {
                    douClX1 = me.getX() - DIA/2;
                    douClY1 = me.getY() - DIA/2;
                }
                case 3 -> reset = true;
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}
