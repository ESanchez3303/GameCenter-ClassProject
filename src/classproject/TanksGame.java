package classproject;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JSeparator;
import javax.swing.*;
import java.awt.*;

public class TanksGame {
    // Variables Holders:
    String noHeart = "";
    String oneHeart = "     ♥     ";
    String twoHeart = "  ♥   ♥  ";
    String threeHeart = "♥   ♥   ♥";
    JPanel mapItem1;
    JPanel mapItem2;
    JPanel mapItem3;
    JLabel player1;
    JLabel player2;
    JLabel player1Lifes;
    JLabel player2Lifes;
    JProgressBar gasBar;
    JProgressBar powerBar;
    JLabel ball;
    JPanel gameBox;
    int floorLineYLocation;
    
    
    // BIG GAME VARIABLES:
    int GAME_TICK = 30;
    int TANK_STEP = 1;
    int MAX_GAS = 100;
    double TURRET_STEP = 1;
    int TURRET_DEAD_ZONE = 15; // Degrees where turret can't go into
    int POWER_BAR_MAX = 100;
    int POWER_TIMER_TICK = 10;
    int POWER_STEP = 1;
    int CYCLES_WAIT_AFTER_IMPACT = 10; // Time to wait after an impact
    
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
    TurretPanel player2Turret;
    double player1TurretAngle = 0;
    double player2TurretAngle = 0;
    
    
    // Ball Variables
    int power;
    double angle;
    int cyclesWaited = 0;     // Keeps track of cycles waited
    double ballVelX = 0;
    double ballVelY = 0;
    double GRAVITY = 0.4;     // Arc shape (vel. going downward)
    double SPEED_SCALE = 0.3; // Arc shape (vel. long wise)
    
    
    
    
    // Private Functions
    
    // "Constructor" Function
    public void setUp(JPanel mi1, JPanel mi2, JPanel mi3,
                      JLabel p1, JLabel p2, JLabel p1L, JLabel p2L,
                      JProgressBar g, JLabel b, JPanel gb, JProgressBar p,
                      JSeparator fl){
        
        // Set up variables with this function instead of a constructor
        player1 = p1;
        player2 = p2;
        currentPlayer = player1;
        mapItem1 = mi1; 
        mapItem2 = mi2; 
        mapItem3 = mi3;
        player1Lifes = p1L;
        player2Lifes = p2L;
        gasBar = g;
        gasBar.setMaximum(MAX_GAS);
        ball = b;
        floor = player1.getLocation().y;
        gameBox = gb;
        maxLocation = gameBox.getWidth() - currentPlayer.getWidth() - 2; // Sets up the max location a player can be according to game box (-2 for visual)
        powerBar = p;
        powerBar.setMaximum(POWER_BAR_MAX);
        floorLineYLocation = fl.getLocation().y;
        
        
        
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
        powerTimer.start();
    } 
    public void spaceReleased(){
        powerTimer.stop();        // Stopping the power growing
        
        // Game clock will then use these saved variables to call moveBall()
        ballIsFlying = true;      // Setting to flying so clock can show this
        angle = (currentPlayer == player1 ? player1TurretAngle : player2TurretAngle); // Saving angle
        power = (powerBar.getValue() > POWER_BAR_MAX ? POWER_BAR_MAX : powerBar.getValue()); // Saving power
       
        
        // Moving the ball to starting position according to player
        int startingX, startingY;
        int bufferX = 20;
        int bufferY = 15;
        if(currentPlayer == player1){
            startingX = player1.getLocation().x + player1.getWidth() + bufferX;
            startingY = player1.getLocation().y - bufferY;
        }
        else{
            startingX = player2.getLocation().x - bufferX;
            startingY = player2.getLocation().y - bufferY;
        }
        ball.setLocation(startingX, startingY);
        
        
        // Calculate initial velocity
        double radians = Math.toRadians(angle);
        ballVelX = Math.cos(radians) * power * SPEED_SCALE;
        ballVelY = Math.sin(radians) * power * SPEED_SCALE;

        // Reverse X direction for player2 (shooting left)
        if (currentPlayer == player2) {
            if(ballVelX > 0)
                ballVelX *= -1;
        }
        
        // Making ball visible
        ball.setVisible(true);
        
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
        currentPlayer = player2;           // Setting the current player to player1
        player1Lifes.setText(threeHeart);  // Resetting the lives
        player2Lifes.setText(threeHeart);  // Resetting the lives
        gasBar.setValue(100);              // Resetting the gas
        gasLeft = 100;                     // Resetting the pixels moved by player1 to zero 
        ball.setVisible(false);            // Hidding the ball
        ballIsFlying = false;              // Setting ball is flying back to F
        upPressed = downPressed = leftPressed = rightPressed = false; // Setting all to F
        powerBar.setValue(0);              // Resetting the powerBar back to zero
        cyclesWaited = 0;                  // Resetting the cycles waiting 
        
        
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
    public void stopGame(){ 
        if(clock.isRunning()) clock.stop(); 
        if(powerTimer.isRunning()) powerTimer.stop();
    }
    
    
    Timer clock = new Timer(GAME_TICK, e->{
        // If ball is in air, then NO player cannot move at all
        if(!ballIsFlying){
            // Moving players according to which player it is and sends direction so we can find bounds first
            if(leftPressed) movePlayer("left");
            if(rightPressed) movePlayer("right");
            if(upPressed) moveTurrent("up");
            if(downPressed) moveTurrent("down");
        }
        
        // If ball is flying, check for impacts
        else{
            // If the ball hit a player or a wall, reset everything
            if(checkForPlayerHit() || checkForWallHit()){
                cyclesWaited++;
                
                
                // Only enters here after the wanted waiting cycles passes
                if(cyclesWaited >= CYCLES_WAIT_AFTER_IMPACT){
                    cyclesWaited = 0;            // Resetting the waiting cycles
                    
                    // If what was hit is a player, then take away health and check for end game
                    if(checkForPlayerHit()){
                        // Check health, check for end game, end clock if so
                        System.out.println("Ball hit player!");
                        if(takeHeart()){
                            // game has ended
                            System.out.println("Game has ended"); // temp
                            ((Timer)e.getSource()).stop();        // Stop timer to end the match
                            // show pause menu to continue the match later <=============================== here!!!
                        }
                    }
                    
                    ballIsFlying = false;        // Make ball is flying back to false so we can exit here
                    if(currentPlayer == player1) 
                        currentPlayer = player2; // Switch players
                    else 
                        currentPlayer = player1; // Swith Players
                    gasBar.setValue(100);        // Give Players full gas
                    gasLeft = 100;               // Give Players full gas
                    powerBar.setValue(0);        // Resetting the powerbar back to zero

                    
                    
                    ball.setVisible(false); // Remove ball from play
                }
                
            }
            // If ball has not hit anything then move ball again
            else{
                moveBall();
            }
        }
    });
    
    // Clock that keeps track of how long the user is holding the shoot button
    Timer powerTimer = new Timer(POWER_TIMER_TICK, e->{
        powerBar.setValue(powerBar.getValue() + POWER_STEP);
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
    
    private void moveBall(){
        // Current position
        int x = ball.getX();
        int y = ball.getY();

        // Update position based on velocity
        x += ballVelX;
        y -= ballVelY;  // -Y because lower y is upward

        // Apply gravity (reduces upward speed over time until speed is neg.)
        ballVelY -= GRAVITY;

        // Move the ball visually
        ball.setLocation(x, y);
    }
    
    
    
    private boolean checkForPlayerHit(){
        // Setting up rectangles for each one
        Rectangle ballRect = ball.getBounds();
        Rectangle p1Rect = player1.getBounds();
        Rectangle p2Rect = player2.getBounds();

        // Checkinf if the ball touches either player
        return ballRect.intersects(p1Rect) || ballRect.intersects(p2Rect);
    }
    
    private boolean checkForWallHit(){
        // Setting up the rectangles
        Rectangle ballRect = ball.getBounds();
        JPanel[] walls = { mapItem1, mapItem2, mapItem3 };
        
        // Checking if the wall is visible in this map and is intersected
        for (JPanel wall : walls) {
            if (wall.isVisible() && ballRect.intersects(wall.getBounds())) {
                return true;
            }
        }

        // Check for hitting the game box edges and roof and the floorlineYlocation
        //   -> Floor line is top of the grass, so if it hits this then it touched the "floor"
        
        int ballRight = ball.getX() + ball.getWidth();
        int ballBottom = ball.getY() + ball.getHeight();

        if (ball.getX() <= 0 || ballRight >= gameBox.getWidth() ||
            ball.getY() <= 0 || ballBottom >= floorLineYLocation) {
            return true;
        }

        return false;
    }
    
    private boolean takeHeart(){
        // If its player 1 turn and made shot, affect player 2 lifes
        if(currentPlayer == player1){
            if(player2Lifes.getText().equals(threeHeart))
                player2Lifes.setText(twoHeart);
            else if(player2Lifes.getText().equals(twoHeart))
                player2Lifes.setText(oneHeart);
            else if(player2Lifes.getText().equals(oneHeart)){
                player2Lifes.setText(noHeart);
                return true;
            }
            
            return false;
        }
        // current player is 2, affect player 1 lifes
        else{
            if(player1Lifes.getText().equals(threeHeart))
                player1Lifes.setText(twoHeart);
            else if(player1Lifes.getText().equals(twoHeart))
                player1Lifes.setText(oneHeart);
            else if(player1Lifes.getText().equals(oneHeart)){
                player1Lifes.setText(noHeart);
                return true;
            }
            
            return false;
        }
        
    }
    
    // =======================================================================================
    
    
    

}



// CLASS FOR TURRET DRAWING ==================================================================
class TurretPanel extends JPanel {
    private double angle = 0; // in degrees, 0 = right, 90 = up, 180 = left
    private final Color turretColor;
    int saved_endX;
    int saved_endY;
    
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
    
    // Gets the angle for when calculating the shot
    public double getAngle(){
        return angle;
    }
    
    
    // Getting the location of the end of the turrent
    public int getEndX() { return saved_endX; }
    public int getEndY() { return saved_endY; }

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
        
        // Saving these variables for when shooting
        saved_endX = endX;
        saved_endY = endY;

        // Drawing the turret
        g2.drawLine(baseX, baseY, endX, endY);   // Actual line based on calculations above
        g2.fillOval(baseX - 4, baseY - 4, 8, 8); // Ball at the bottom to make more natural
    }
}

    // =======================================================================================