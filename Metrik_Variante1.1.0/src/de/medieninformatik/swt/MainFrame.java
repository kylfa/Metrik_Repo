package de.medieninformatik.swt;

/**
 * @author Frieda Kolbe, m29061
 * Software engineering, practical training, task 1
 */

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
        setTitle("Metrik Version 1.1.0");
        setSize(500, 400);
        setResizable(false);
        setBackground(Color.WHITE);

        initializeMenu();
        addWindowListener(this);
        add(_paintArea);
    }

    /**
     * The method builds the menu for the choice of background color.
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
