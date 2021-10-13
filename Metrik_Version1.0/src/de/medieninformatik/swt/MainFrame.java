package de.medieninformatik.swt;

/**
 * @author Jessica Herrmann, 29060
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
        setTitle("Metrik Version 1.0");
        setSize(500, 400);
        setResizable(false);
        setBackground(Color.WHITE);

        addWindowListener(this);
        add(_paintArea);
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
