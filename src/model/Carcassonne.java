package model;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Carcassonne extends JFrame implements MouseListener {

    /** The main window */
    JFrame mainWindow;

    /** The main game model */
    CarcassonneView gameView;

    /** The absence of player panel */
    PlayerView playerView;
    
    /**Number of players*/
    int playahs;

    /** the player panel*/
    JPanel playerPanel = new JPanel();

    /** The main game timer loop */
    Timer runLoop;

    /** The width of the window */
    final static int WIDTH = 1024;

    /** The height of the window */
    final static int HEIGHT = 768;

    /** The current frame count. Resets at 2^64 */
    private long frame = 0;

    /** Terminates the current runloop timer, deallocates resources, and safely exits the program */
    public void abort(){
        // TODO: Add resource deallocation as needed
        runLoop.stop();
        mainWindow = null;
        gameView = null;
        playerView = null;
        getContentPane().removeAll();
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
        setTitle("Carcassonne - The keenest game in all of christendom.");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        //start player panels//
        setLayout(new GridBagLayout()); //Changed view to Gridbag
        GridBagConstraints c = new GridBagConstraints();

        setFocusable(true);
        setBackground(Color.BLUE);
        setLocationRelativeTo(null); // Open our window in the center of the display
        addMouseListener(this); // We can receive mouse events like clicks

        getContentPane().removeAll();   // Start from scratch
        gameView = new CarcassonneView();
        playahs = gameView.getPlayers();

        c.ipadx = WIDTH;
        c.ipady = HEIGHT  - 100;
        c.gridheight = HEIGHT - 200;
        add(gameView, c);

        playerPanel.setLayout(new GridLayout(1, 6));
        playerPanel.setSize(Carcassonne.WIDTH, 200);

        c.ipady = 0;
        c.ipadx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.anchor = GridBagConstraints.SOUTH;
        add(playerPanel, c);

        for (int i = 0; i < playahs; i++){
        	Player currentPlayer = gameView.game.players.get(i);
        	playerView = new PlayerView(currentPlayer);
        	playerPanel.add(playerView);
        }
       gameView.game.players.get(1).addScore(12);
       revalidate();
       repaint();

       setVisible(true);

    }

    /**
     * Initializes the main game runloop, which is based on a JavaX Swing Timer running at ~50 fps (20 ms delay).
     */
    private void run(){

        gameView = new CarcassonneView();
        add(gameView);

        runLoop = new Timer(2000, new ActionListener() {    // This is a lamba closure, don't be conufesd here!!
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
        getContentPane().repaint();
        gameView.repaint();

        // TODO: Draw the user interface components like scores
        // TODO: Draw the gameboard and players

    }


    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        System.out.println("Mouse exited");
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        System.out.println("Mouse released");
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("Mouse pressed");
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("Mouse clicked");
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        System.out.println("Mouse entered");
    }
}


