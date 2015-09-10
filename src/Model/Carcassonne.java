package Model;

/*Carcassonne-Life-History-Simulation, 2015

Created Sep 08, 2015 by Team Life History Simulation

Copyright © 2015. All rights reserved.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Carcassonne extends JFrame implements MouseListener {

    /** The main window */
    JFrame mainWindow;

    /** The main game timer loop */
    Timer runLoop;

    /** The width of the window */
    final int WIDTH = 1024;

    /** The height of the window */
    final int HEIGHT = 768;

    /** The current frame count. Resets at 2^64 */
    private long frame = 0;

    /** Terminates the current runloop timer, deallocates resources, and safely exits the program */
    public void abort(){
        // TODO: Add resource deallocation as needed
        runLoop.stop();
        mainWindow = null;
        java.lang.System.exit(0);
    }

    /** Terminates the current runloop timer, deallocates resources, and safely exits the program */
    public void exit(){
        abort();
    }

    public static void main(String[] args) {
        Carcassonne main = new Carcassonne();
        main.run();
    }

    public Carcassonne() {
        setTitle("Carcassonne - The bitchinest game in all of christendom.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        //setUndecorated(true); // Get rid of that pesky top bar
        setLayout(null);
        setFocusable(true);
        setBackground(Color.BLUE);
        setLocationRelativeTo(null); // Open our window in the center of the display
        addMouseListener(this); // We can receive mouse events like clicks

        getContentPane().removeAll();   // Start from scratch
    }

    /**
     * Initializes the main game runloop, which is based on a JavaX Swing Timer running at ~50 fps (20 ms delay).
     */
    private void run(){
        runLoop = new Timer(20, new ActionListener() {    // This is a lamba closure, don't be conufesd here!!
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frameCycle();
            }
        });
        runLoop.setRepeats(true);
        runLoop.start();

    }

    /**
     * A single frame cycle in the runtime loop. This is a dispatch method which evokes the input and render loops.
     */
    private void frameCycle(){
        // Each frame cycle takes user input, processes game data, and renders the frame, then releases
        frame++;
        parseInput();
        updateMechanics();
        draw();
    }

    /**
     * Accepts and parses user's input. Directs input to appropriate containers in the view hierarchy.
     */
    private void parseInput(){
        // Takes the user's input and directs it towards the appropriate data models

    }

    /**
     * Performs updates to game mechanics and physics, if necessary, in preparation for rendering
     */
    private void updateMechanics(){
        // Perform any mathematics and physics simulations in preparation for draw()

    }


    /**
     * The main rendering loop. This method draws to the main container inside the JFrame which describes the game window.
     */
    private void draw(){
        //  Draw the main game grid and user interface elements here

        // TODO: Draw the user interface components like scores
        // TODO: Draw the gameboard and players

    }


    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
}
