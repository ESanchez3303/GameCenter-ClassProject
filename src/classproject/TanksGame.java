package classproject;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.JSeparator;
import java.awt.*;

public class TanksGame {
    // BIG GAME VARIABLES:
    private int GAME_TICK = 30;
    private int TANK_STEP = 1;
    private int MAX_GAS = 100;
    private double TURRET_STEP = 1;
    private int TURRET_DEAD_ZONE = 15; // Degrees where turret can't go into
    private int POWER_BAR_MAX = 100;
    private int POWER_TIMER_TICK = 10;
    private int POWER_STEP = 1;
    private int CYCLES_WAIT_AFTER_IMPACT = 10; // Time to wait after an impact
    private double GRAVITY = 0.7;     // Arc shape (vel. going downward)
    private double SPEED_SCALE = 0.3; // Arc shape (vel. long wise)
    private int FALLING_STEP = 10;
    
    // Variables Holders:
    private String noHeart = "";
    private String oneHeart = "     ♥     ";
    private String twoHeart = "  ♥   ♥  ";
    private String threeHeart = "♥   ♥   ♥";
    private JPanel mapItem1;
    private JPanel mapItem2;
    private JPanel mapItem3;
    private JLabel player1;
    private JLabel player2;
    private JLabel player1Lifes;
    private JLabel player2Lifes;
    private JProgressBar gasBar;
    private JProgressBar powerBar;
    private JLabel ball;
    private JPanel gameBox;
    private int floorLineYLocation;
    private JPanel matchCover;
    private JLabel matchWinnerText;
    private JLabel player1Score;
    private JLabel player2Score;
    private JLabel explosion;
    private JLabel player1Indicator;
    private JLabel player2Indicator;
    
    
    // Game Variables:
    private int minLocation = 2;
    private int maxLocation;
    private int map = 0;
    private boolean ballIsFlying = false;
    private int matchWonBy = 0;
    
    
    // Player Variables
    private int gasLeft = 0;
    private boolean playerIsFalling = false;
    private JLabel currentPlayer;
    private TurretPanel player1Turret;
    private TurretPanel player2Turret;
    private double player1TurretAngle = 0;
    private double player2TurretAngle = 0;
    
    
    // Ball Variables
    private int power;
    private double angle;
    private int cyclesWaited = 0;     // Keeps track of cycles waited
    private double ballVelX = 0;
    private double ballVelY = 0;
    
    
    
    
    
    // "Constructor" Function
    public void setUp(JPanel mi1, JPanel mi2, JPanel mi3,
                      JLabel p1, JLabel p2, JLabel p1L, JLabel p2L,
                      JProgressBar g, JLabel b, JPanel gb, JProgressBar p,
                      JSeparator fl, JPanel c, JLabel mw, JLabel p1s, JLabel p2s, 
                      JLabel ex, JLabel pI1, JLabel pI2){
        
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
        gameBox = gb;
        maxLocation = gameBox.getWidth() - currentPlayer.getWidth() - 2; // Sets up the max location a player can be according to game box (-2 for visual)
        powerBar = p;
        powerBar.setMaximum(POWER_BAR_MAX);
        floorLineYLocation = fl.getLocation().y;
        matchCover = c;
        matchWinnerText = mw;
        player1Score = p1s;
        player2Score = p2s;
        explosion = ex;
        player1Indicator = pI1;
        player2Indicator = pI2;
        
        
        
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
    
    // Get Functtions =================================
    public int getMap(){ return map; }
    public int getMatchWonBy() {return matchWonBy; } 
    
    
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
        if(ballIsFlying)
            return;
        powerTimer.start();
    } 
    public void spaceReleased(){
        if(ballIsFlying)
            return;
        powerTimer.stop();        // Stopping the power growing
        
        // Game clock will then use these saved variables to call moveBall()
        ballIsFlying = true;      // Setting to flying so clock can show this
        angle = (currentPlayer == player1 ? player1TurretAngle : player2TurretAngle); // Saving angle
        power = (powerBar.getValue() > POWER_BAR_MAX ? POWER_BAR_MAX : powerBar.getValue()); // Saving power
       
        
        // Getting the starting position of the ball
        TurretPanel turret = (currentPlayer == player1) ? player1Turret : player2Turret; // Determine which turret to use

        // Getting the x and y in player of the end of turret || NOTE TO SELF: wowwwww so .getX() is the same as .getLocation().x bruhhhh
        int endXInPlayer = turret.getX() + turret.getEndX();
        int endYInPlayer = turret.getY() + turret.getEndY();

        // Converting this to game box locations
        int endXInGameBox = currentPlayer.getX() + endXInPlayer;
        int endYInGameBox = currentPlayer.getY() + endYInPlayer;
        int startingX = endXInGameBox - ball.getWidth() / 2;
        int startingY = endYInGameBox - ball.getHeight() / 2;

        // Set the ball’s initial position
        ball.setLocation(startingX, startingY);
        
        
        // Calculate initial velocity
        double radians = Math.toRadians(angle);
        ballVelX = Math.cos(radians) * power * SPEED_SCALE;
        ballVelY = Math.sin(radians) * power * SPEED_SCALE;

        // Reverse X direction for player2 (shooting left)
        if (currentPlayer == player2 && ballVelX > 0) {
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
            case 1:
                mapItem1.setLocation(337,215);           // Moving the block
                mapItem1.setSize(80,250);                // Resizing the block
                mapItem1.setVisible(true);               // Making visible this block
                break;
                
            case 2:
                mapItem1.setLocation(337,385);    
                mapItem1.setSize(80,80);
                mapItem1.setVisible(true);  
                
                mapItem2.setLocation(30,320);    
                mapItem2.setSize(150,40);
                mapItem2.setVisible(true);  
                
                mapItem3.setLocation(585,320);    
                mapItem3.setSize(150,40);
                mapItem3.setVisible(true);  
                break;
                
            case 3:
                mapItem1.setLocation(330,350);    
                mapItem1.setSize(100,100);
                mapItem1.setVisible(true);  
                
                mapItem2.setLocation(330,60);    
                mapItem2.setSize(100,230);
                mapItem2.setVisible(true);  
                
                mapItem3.setLocation(110,110);    
                mapItem3.setSize(550,40);
                mapItem3.setVisible(true);  
                break;
        }
        
        // Resetting other visuals
        if(map == 3){
            player1.setLocation(130,48);
            player2.setLocation(560,48);
            playerIsFalling = false;
        }
        else{
            player1.setLocation(20,402);       // Moving player 1 to start
            player2.setLocation(655,402);      // Moving player 2 to start
        }
        currentPlayer = player1;               // Setting the current player to player1
        
        if(currentPlayer == player1){  
            player1Indicator.setText("--> [ Player 1"); // Changing the indicator on which player is current playing
            player2Indicator.setText("Player 2 ]");
        }
        else{  
            player2Indicator.setText("Player 2 ] <--");
            player1Indicator.setText("[Player 1");
        }
        player1Lifes.setText(threeHeart);  // Resetting the lives
        player2Lifes.setText(threeHeart);  // Resetting the lives
        gasBar.setValue(100);              // Resetting the gas
        gasLeft = 100;                     // Resetting the pixels moved by player1 to zero 
        ball.setVisible(false);            // Hidding the ball
        ballIsFlying = false;              // Setting ball is flying back to F
        upPressed = downPressed = leftPressed = rightPressed = false; // Setting all to F
        powerBar.setValue(0);              // Resetting the powerBar back to zero
        cyclesWaited = 0;                  // Resetting the cycles waiting 
        matchCover.setVisible(false);      // Hiding the match cover that ends the match
        matchWonBy = 0;                    // Resetting the who won by 
        explosion.setVisible(false);       // Hiding the explosion
        
        
        player1Turret.setAngle(0 + TURRET_DEAD_ZONE);   // Moving turrent to regular pos
        player1TurretAngle = 0 + TURRET_DEAD_ZONE;      // Moving mem. of turret to pos
        player2Turret.setAngle(180 - TURRET_DEAD_ZONE); // Moving turrent to regular pos
        player2TurretAngle = 180- TURRET_DEAD_ZONE;     // Moving mem. of turret to pos
        
        clock.start(); // Starting inside so that each match can start its own timer
    }
    
    // =======================================================================================
    
    
    
    
    
    
    // TIMERS ===============================================================================
    public void stopGame(){ 
        if(clock.isRunning()) clock.stop(); 
        if(powerTimer.isRunning()) powerTimer.stop();
    }
    
    // MAJOR GAME TIMER 
    private Timer clock = new Timer(GAME_TICK, e->{
        // If player is falling, show that animation until finished
        if(playerIsFalling){
            int newY = currentPlayer.getLocation().y + FALLING_STEP;
            if(newY >= 402){ // If we have reached the floor level, then change to 402 and change flag to get out of this inner loop
                playerIsFalling = false;
                newY = 402;
            }
            
            currentPlayer.setLocation(currentPlayer.getLocation().x, newY); // Moving the player to new position
            return; // Returning to make an inner loop inside clock
        }
        
        // If ball is in air, then NO player cannot move at all
        if(!ballIsFlying){//                                                                  <====================== ball is not flying, aka player still has not shot
            // Moving players according to which player it is and sends direction so we can find bounds first
            if(leftPressed) movePlayer("left");
            if(rightPressed) movePlayer("right");
            if(upPressed) moveTurrent("up");
            if(downPressed) moveTurrent("down");
        }
        
        // If ball is flying, check for impacts                                                <===================== ball is flying
        else{
            // If the ball hit a player or a wall, reset everything  5 180 89 green | 237,28,36 <==================== ball hits something
            if(checkForPlayerHit() || checkForWallHit()){
                cyclesWaited++;
                // During wait inner loop, show the explosion (dont keep calculating, only make visible one)
                if(checkForPlayerHit() && !explosion.isVisible()){
                    // Calculate the middle of the ball
                    int ballMiddleX = ball.getX() + ball.getWidth() / 2;
                    int ballMiddleY = ball.getY() + ball.getHeight() / 2;
                    
                    // Get the position from the middle half way lenght of explosion from middle 
                    int newX = ballMiddleX - explosion.getWidth() / 2;
                    int newY = ballMiddleY - explosion.getHeight() / 2;
                    
                    // Set and make visible
                    explosion.setLocation(newX, newY);
                    explosion.setVisible(true);
                }
                
                // Only enters here after the wanted waiting cycles passes
                if(cyclesWaited >= CYCLES_WAIT_AFTER_IMPACT){
                    cyclesWaited = 0;            // Resetting the waiting cycles
                    explosion.setVisible(false); // Making invisible again
                    
                    // If what was hit is a player, then take away health and check for end game <=================== player gets hit
                    if(checkForPlayerHit()){
                        
                        // Hurt health, check for end game, end clock if so
                        if(takeHeart()){                                                      // <=================== match ends
                            ((Timer)e.getSource()).stop();        // Stop timer to end the match
                            matchWinnerText.setText("Player " + (currentPlayer == player1 ? "1":"2") + " WINS!"); // Changing the match cover text to winner
                            matchWonBy = (currentPlayer == player1 ? 1 : 2);                                      // Saving in unit who won
                            
                            // Changing the indicators back to normal
                            player1Indicator.setText("[ Player 1");
                            player2Indicator.setText("Player 2 ]");
                            
                            if(currentPlayer == player1)                                                          // Changing the score on top
                                player1Score.setText(Integer.toString(Integer.parseInt(player1Score.getText()) + 1));
                            else
                                player2Score.setText(Integer.toString(Integer.parseInt(player2Score.getText()) + 1));
                            
                            matchCover.setVisible(true);
                        }
                        
                    }
                    
                    ballIsFlying = false;        // Make ball is flying back to false so we can exit here
                    if(currentPlayer == player1){ 
                        currentPlayer = player2; // Switch player from 1 to 2
                        player2Indicator.setText("Player 2 ] <--");
                        player1Indicator.setText("[Player 1");
                    }
                    else{ 
                        currentPlayer = player1; // Swith player from 2 to 1
                        player1Indicator.setText("--> [ Player 1");
                        player2Indicator.setText("Player 2 ]");
                    }
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
                currentPlayer.setLocation(minLocation, currentPlayer.getLocation().y);
                return;
            }
        }
        else{ // moving "right"
            newLocation = currentPlayer.getLocation().x + TANK_STEP;
            if(newLocation > maxLocation){
                currentPlayer.setLocation(maxLocation, currentPlayer.getLocation().y);
                return;
            }
        }
        
        
        // If player 1 is moving right and hits the middle section
        if(currentPlayer == player1 && !direction.equals("left")){
            newLocation = currentPlayer.getLocation().x + TANK_STEP;
            if(newLocation + currentPlayer.getWidth() > mapItem1.getLocation().x){
                currentPlayer.setLocation(mapItem1.getLocation().x - currentPlayer.getWidth(), currentPlayer.getLocation().y);
                return;
            }
        }
        // If player 2 is moveing left and hits the middle section
        else if(currentPlayer == player2 && direction.equals("left")){
            newLocation = currentPlayer.getLocation().x - TANK_STEP;
            if(newLocation < mapItem1.getLocation().x + mapItem1.getWidth()){
                currentPlayer.setLocation(mapItem1.getLocation().x + mapItem1.getWidth(), currentPlayer.getLocation().y);
                return;
            }
        }
        
        // If we are in map 3 and the current player is still on top layer
        if(map == 3 && currentPlayer.getLocation().y == 48){ // Will not enter if not in map3 or location is not on top
            if(currentPlayer.getLocation().x <= 40 || currentPlayer.getLocation().x >= 655){
                playerIsFalling = true;
                currentPlayer.setLocation(currentPlayer.getLocation().x, currentPlayer.getLocation().y + FALLING_STEP);
                return;
            }
        }
        
        // If no boundary is hit, then just move regulary
        newLocation = (direction.equals("left") ? currentPlayer.getLocation().x - TANK_STEP : currentPlayer.getLocation().x + TANK_STEP);
        currentPlayer.setLocation(newLocation, currentPlayer.getLocation().y);
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

        // Check if the ball hits an opponent depending on who shot 
        return (currentPlayer == player1 ? ballRect.intersects(p2Rect) : ballRect.intersects(p1Rect));
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
            if(player2Lifes.getText().equals(threeHeart)){
                player2Lifes.setText(twoHeart);
            }
            else if(player2Lifes.getText().equals(twoHeart)){
                player2Lifes.setText(oneHeart);
            }
            else if(player2Lifes.getText().equals(oneHeart)){
                player2Lifes.setText(noHeart);
                return true;
            }
            
            return false;
        }
        // current player is 2, affect player 1 lifes
        else{
            if(player1Lifes.getText().equals(threeHeart)){
                player1Lifes.setText(twoHeart);
                
            }
            else if(player1Lifes.getText().equals(twoHeart)){
                player1Lifes.setText(oneHeart);
            }
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
    private int saved_endX;
    private int saved_endY;
    
    // Constructor & to save the color
    public TurretPanel(Color c) {
        setOpaque(false); // transparent background so tank body shows
        turretColor = c;
    }

    // Set Functions:
    public void setAngle(double newAngle) {
        angle = newAngle;
        repaint();
    }
    
    // Get Functions
    public double getAngle(){ return angle; }
    public int getEndX() { return saved_endX; }
    public int getEndY() { return saved_endY; }

    
    // Painting Overide Function 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // smoother lines apperantly
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
        
        // Saving these  variables for when shooting
        saved_endX = endX;
        saved_endY = endY;

        // Drawing the turret
        g2.drawLine(baseX, baseY, endX, endY);   // Actual line based on calculations above
        g2.fillOval(baseX - 4, baseY - 4, 8, 8); // Ball at the bottom to make more "natural"
    }
}

    // =======================================================================================