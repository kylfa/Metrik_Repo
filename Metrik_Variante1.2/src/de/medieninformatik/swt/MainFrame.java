package de.medieninformatik.swt;

/**
 * @author Jessica Herrmann, 29060
 * @author Frieda Kolbe, m29061
 * Software engineering, practical training, task 1
 */

import java.awt.*;
import java.awt.event.*;

/**
 * This class creates the frame and adds a WindowListener.
 * Within the frame a new PaintArea object is initialized.
 */
public class MainFrame extends Frame implements WindowListener {

    private static final PaintArea _paintArea = new PaintArea();

    /**
     * The constructor sets some standard settings.
     */
    public MainFrame() {
        setTitle("Metrik Version 1.2");
        setSize(500, 400);
        setResizable(false);
        setBackground(Color.WHITE);

        initializeMenu();
        addWindowListener(this);
        add(_paintArea);
    }

    /**
     * The method builds the menu for the choice of background color and the diameter of the circle.
     */
    private void initializeMenu() {
        MenuBar mbar = new MenuBar();
        Menu mFile = new Menu("Background");

        initializeColor(mFile, "Dark Gray", Color.DARK_GRAY);
        initializeColor(mFile, "Gray", Color.GRAY);
        initializeColor(mFile, "White", Color.WHITE);
        initializeColor(mFile, "Blue", Color.BLUE);
        initializeColor(mFile, "Cyan", Color.CYAN);
        initializeColor(mFile, "Yellow", Color.YELLOW);
        initializeColor(mFile, "Orange", Color.ORANGE);
        initializeColor(mFile, "Pink", Color.PINK);
        initializeColor(mFile, "Magenta", Color.MAGENTA);

        mbar.add(mFile);

        Menu mCircle = new Menu("Circle diameter");
        initializeDia(mCircle, "10 Pixel", 10);
        initializeDia(mCircle, "20 Pixel", 20);
        initializeDia(mCircle, "50 Pixel", 50);
        initializeDia(mCircle, "80 Pixel", 80);
        initializeDia(mCircle, "100 Pixel", 100);
        initializeDia(mCircle, "150 Pixel", 150);

        mbar.add(mCircle);

        setMenuBar(mbar);
    }

    /**
     * This smaller method deals with the item for each color.
     * @param mFile Menu where the item needs to be added
     * @param label name of color
     * @param color color itself
     */
    private void initializeColor(Menu mFile, String label, Color color) {
        MenuItem mi = new MenuItem(label);
        mFile.add(mi);
        mi.addActionListener(e -> _paintArea.setBackground(color));
    }


    /**
     * Just like the previous method but for the circle diameter.
     * @param mCircle Menu to which the items are added
     * @param label name of the option
     * @param dia circle diameter
     */
    private void initializeDia(Menu mCircle, String label, int dia) {
        MenuItem mi = new MenuItem(label);
        mCircle.add(mi);
        mi.addActionListener(e -> _paintArea.setDIA(dia));
    }

    @Override
    public void windowOpened(WindowEvent e) { }

    /**
     * Window can be closed and this ends the running program.
     * @param event e.g. click on red cross
     */
    @Override
    public void windowClosing(WindowEvent event) {
        event.getWindow().dispose();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) { }

    @Override
    public void windowIconified(WindowEvent e) { }

    @Override
    public void windowDeiconified(WindowEvent e) { }

    @Override
    public void windowActivated(WindowEvent e) { }

    @Override
    public void windowDeactivated(WindowEvent e) { }
}
