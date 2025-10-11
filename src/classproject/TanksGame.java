package classproject;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;

public class TanksGame {
    // Variables Holders:
    char heart = '♥';
    String fullHealth = "♥   ♥   ♥";
    JPanel mapItem1;
    JPanel mapItem2;
    JPanel mapItem3;
    JLabel player1;
    JLabel player2;
    JLabel player1Lifes;
    JLabel player2Lifes;
    JProgressBar gasBar;
    JLabel ball;
    JPanel gameBox;
    
    
    // BIG GAME VARIABLES:
    int GAME_TICK = 10;
    int TANK_STEP = 1;
    int MAX_GAS = 100;
    double TURRET_STEP = 1;
    int TURRET_DEAD_ZONE = 15; // Degrees where turret can't go into
    
    // Game Variables:
    int floor;
    int minLocation = 2;
    int maxLocation;
    int map = 0;
    boolean ballIsFlying = false;
    
    
    // Player Variables
    int gasLeft = 0;
    JLabel currentPlayer;
    TurretPanel player1Turret;
    double player1TurretAngle = 0;
    TurretPanel player2Turret;
    double player2TurretAngle = 0;
    
    
    
    // Private Functions
    
    // "Constructor" Function
    public void setUp(JPanel mi1, JPanel mi2, JPanel mi3,
                      JLabel p1, JLabel p2, JLabel p1L, JLabel p2L,
                      JProgressBar g, JLabel b, JPanel gb){
        
        // Set up variables with this function instead of a constructor
        mapItem1 = mi1; 
        mapItem2 = mi2; 
        mapItem3 = mi3;
        player1 = p1;
        player2 = p2;
        player1Lifes = p1L;
        player2Lifes = p2L;
        gasBar = g;
        ball = b;
        floor = player1.getLocation().y;
        gameBox = gb;
        currentPlayer = player1;
        maxLocation = gameBox.getWidth() - currentPlayer.getWidth() - 2; // Sets up the max location a player can be according to game box (-2 for visual)
        
        // Making the turrents:
        player1Turret = new TurretPanel(new Color(5,180,89));
        player1Turret.setBounds(20, 0, 60, 60); // x, y, width, height
        player1.add(player1Turret);
        player1Turret.setVisible(true);
        player1Turret.setAngle(0 + TURRET_DEAD_ZONE);
        player1TurretAngle = 0 + TURRET_DEAD_ZONE;
        
        player2Turret = new TurretPanel(new Color(204,72,0));
        player2Turret.setBounds(0, 0, 60, 60); // x, y, width, height
        player2.add(player2Turret);
        player2Turret.setVisible(true);
        player2Turret.setAngle(180 - TURRET_DEAD_ZONE);
        player2TurretAngle = 180 - TURRET_DEAD_ZONE;
    }
    
    // PLAYER MOVEMENTS =====================================================================
    boolean upPressed = false, downPressed = false, leftPressed = false, rightPressed = false, playerMoving = false;
    public void upPressed()   {if(playerMoving) return; upPressed = true; playerMoving = true;}
    public void downPressed() {if(playerMoving) return; downPressed = true; playerMoving = true;}
    public void leftPressed() {if(playerMoving) return; leftPressed = true; playerMoving = true;}
    public void rightPressed(){if(playerMoving) return; rightPressed = true; playerMoving = true;}
    public void upReleased()  {upPressed = false; playerMoving = false;}
    public void downReleased()  {downPressed = false; playerMoving = false;}
    public void leftReleased()  {leftPressed = false; playerMoving = false;}
    public void rightReleased()  {rightPressed = false; playerMoving = false;}
    public void spacePressed() {
        // CODE THIS SECTION LATER
        if(currentPlayer == player1) 
            currentPlayer = player2;
        else 
            currentPlayer = player1;
        gasBar.setValue(100);
        gasLeft = 100;
    } 
    //=======================================================================================
    
    
    // Loading a map and match ==============================================================
    public void drawMap(int chosenMap){
        // Setting the map chosen
        map = chosenMap;
        
        // Resetting the drawing to be zero 
        mapItem1.setVisible(false);
        mapItem2.setVisible(false);
        mapItem3.setVisible(false);
       
        // Drawing the map using the given blocks (limited to 3 for this program)
        switch ( chosenMap ){
            case 1 -> {
                mapItem1.setLocation(337,215);           // Moving the block
                mapItem1.setSize(80,250);                // Resizing the block
                mapItem1.setVisible(true);               // Making visible this block
            }
            case 2 -> {
                mapItem1.setLocation(337,385);    
                mapItem1.setSize(80,80);
                mapItem1.setVisible(true);  
                
                mapItem2.setLocation(30,320);    
                mapItem2.setSize(150,40);
                mapItem2.setVisible(true);  
                
                mapItem3.setLocation(585,320);    
                mapItem3.setSize(150,40);
                mapItem3.setVisible(true);  
            }
            case 3 -> {
                mapItem1.setLocation(30,2);    
                mapItem1.setSize(700,150);
                mapItem1.setVisible(true);  
                
                mapItem2.setLocation(2,200);    
                mapItem2.setSize(200,40);
                mapItem2.setVisible(true);  
                
                mapItem3.setLocation(563,200);    
                mapItem3.setSize(200,40);
                mapItem3.setVisible(true);  
            }
        }
        
        // Resetting other visuals
        player1.setLocation(20,402);       // Moving player 1 to start
        player2.setLocation(655,402);      // Moving player 2 to start
        currentPlayer = player1;           // Setting the current player to player1
        player1Lifes.setText(fullHealth);  // Resetting the lives
        player2Lifes.setText(fullHealth);  // Resetting the lives
        gasBar.setMaximum(MAX_GAS);        // Setting up max gas
        gasBar.setValue(100);              // Resetting the gas
        gasLeft = 100;                     // Resetting the pixels moved by player1 to zero 
        ball.setVisible(false);            // Hidding the ball
        ballIsFlying = false;              // Setting ball is flying back to F
        upPressed = downPressed = leftPressed = rightPressed = false; // Setting all to F
        
        player1Turret.setAngle(0 + TURRET_DEAD_ZONE);   // Moving turrent to regular pos
        player1TurretAngle = 0 + TURRET_DEAD_ZONE;      // Moving mem. of turret to pos
        player2Turret.setAngle(180 - TURRET_DEAD_ZONE); // Moving turrent to regular pos
        player2TurretAngle = 180- TURRET_DEAD_ZONE;     // Moving mem. of turret to pos
       
        
        // Setting up the walls and boundaries of the map - seperated for easy-to-read code
        // NOTE-TO-SELF: This could actually be mapped instead! try to before hard coding it
        switch ( chosenMap ){
            case 1 -> {
                
            }
            case 2 -> {
                
            }
            case 3 -> {
                
            }
        }
        
        clock.start(); // Starting inside so that each match can start its own timer
    }
    
    // =======================================================================================
    
    
    
    
    
    
    // TIMERS ===============================================================================
    public void stopGame(){ if(clock.isRunning()) clock.stop(); }
    
    Timer clock = new Timer(GAME_TICK, e->{
        // Moving players according to which player it is and sends direction so we can find bounds first
        if(leftPressed) movePlayer("left");
        if(rightPressed) movePlayer("right");
        if(upPressed) moveTurrent("up");
        if(downPressed) moveTurrent("down");
                
    });
    
    
    // PRIVATE FUNCTIONS =====================================================================
    // Moves player with limits of maps are taking into consideration
    private void movePlayer(String direction){
        // Checking if player has any more gas to move
        if(gasLeft <= 0){
            return;
        }
        
        // Checking if this move will move the player out of the map, then just set to map max
        int newLocation;
        if(direction.equals("left")){
            newLocation = currentPlayer.getLocation().x - TANK_STEP;
            if(newLocation < minLocation){
                currentPlayer.setLocation(minLocation, floor);
                return;
            }
        }
        else{ // moving "right"
            newLocation = currentPlayer.getLocation().x + TANK_STEP;
            if(newLocation > maxLocation){
                currentPlayer.setLocation(maxLocation, floor);
                return;
            }
        }
        
        // NOTE: Map 1 and 2 have the middle section they cannot cross, Map 3 has no middle section
        if(map != 3){
            // If player 1 is moving right and hits the middle section
            if(currentPlayer == player1 && !direction.equals("left")){
                newLocation = currentPlayer.getLocation().x + TANK_STEP;
                if(newLocation + currentPlayer.getWidth() > mapItem1.getLocation().x){
                    currentPlayer.setLocation(mapItem1.getLocation().x - currentPlayer.getWidth(), floor);
                    return;
                }
            }
            // If player 2 is moveing left and hits the middle section
            else if(currentPlayer == player2 && direction.equals("left")){
                newLocation = currentPlayer.getLocation().x - TANK_STEP;
                if(newLocation < mapItem1.getLocation().x + mapItem1.getWidth()){
                    currentPlayer.setLocation(mapItem1.getLocation().x + mapItem1.getWidth(), floor);
                    return;
                }
            }
        }
        
        // If no boundary is hit, then just move regulary
        newLocation = (direction.equals("left") ? currentPlayer.getLocation().x - TANK_STEP : currentPlayer.getLocation().x + TANK_STEP);
        currentPlayer.setLocation(newLocation, floor);
        gasLeft--;
        gasBar.setValue(gasLeft);
    }
    
    
    // Moves the turrent of each player accordingly
    private void moveTurrent(String direction) {
        if(currentPlayer == player1){
            // Move Turret
            if (direction.equals("up"))
                player1TurretAngle += TURRET_STEP;
            else if (direction.equals("down"))
                player1TurretAngle -= TURRET_STEP;

            // Clamp from max to min
            if (player1TurretAngle < 0 + TURRET_DEAD_ZONE) player1TurretAngle = 0 + TURRET_DEAD_ZONE;
            if (player1TurretAngle > 90 - TURRET_DEAD_ZONE) player1TurretAngle = 90 - TURRET_DEAD_ZONE;
            
            // Update Turret
            player1Turret.setAngle(player1TurretAngle);
        }
        else{ // current player is 2
            // Move Turret
            if (direction.equals("up"))
                player2TurretAngle -= TURRET_STEP;
            else if (direction.equals("down"))
                player2TurretAngle += TURRET_STEP;

            // Clamp from 90 to 180
            if (player2TurretAngle < 90 + TURRET_DEAD_ZONE) player2TurretAngle = 90 + TURRET_DEAD_ZONE;
            if (player2TurretAngle > 180 - TURRET_DEAD_ZONE) player2TurretAngle = 180 - TURRET_DEAD_ZONE;
            
            // Update Turret
            player2Turret.setAngle(player2TurretAngle);
        }
        
        
    }
    // =======================================================================================
    
    
    

}



class TurretPanel extends JPanel {
    private double angle = 0; // in degrees, 0 = right, 90 = up, 180 = left
    private final Color turretColor;
    
    // Constructor to save the color
    public TurretPanel(Color c) {
        setOpaque(false); // transparent background so tank body shows
        turretColor = c;
    }

    // Sets the angle and repaints
    public void setAngle(double newAngle) {
        angle = newAngle;
        repaint();
    }

    // Painting Overide Function 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // smoother lines
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
        g2.setColor(turretColor);
        g2.setStroke(new BasicStroke(4));

        int baseX = getWidth() / 2;
        int baseY = getHeight() / 2;
        int barrelLength = 25;

        // Convert degrees to radians
        double radians = Math.toRadians(angle);

        // For drawing, 0° = right, 90° = up, 180° = left
        int endX = baseX + (int) (Math.cos(radians) * barrelLength);
        int endY = baseY - (int) (Math.sin(radians) * barrelLength);

        // Drawing the turret
        g2.drawLine(baseX, baseY, endX, endY);   // Actual line based on calculations above
        g2.fillOval(baseX - 4, baseY - 4, 8, 8); // Ball at the bottom to make more natural
    }
}