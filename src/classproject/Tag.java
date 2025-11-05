package classproject;
import javax.swing.*;
import java.awt.*;


public class Tag {
    
    // Main Variables:
    private final int GAME_TICK    = 15;  // General Game Tick
    private int GAME_MAX_TIME      = 30;  // Max time being tagged           <------------------(in seconds)
    private int RUNNER_STEP        = 2;   // The steps that the runner tages
    private int TAGGER_STEP        = 3;   // The steps that the tagger takes
    private int TIME_FROZEN        = 1;   // Time that frozen causes  <-------------------------(in seconds)
    private int BOOST_STEP         = 2;   // The extra steps for the boost that is grabbed
    private int BOOST_RESPAWN_TIME = 10;  // Time that the boost takes to respawn <-------------(in seconds)
    private int BOOSTED_TIME       = 4;   // Time that the boost last in the player <-----------(in seconds)
    private double GRAVITY         = 0.5; // Gravity 
    private final double JUMP_POWER= -11; // Power going up (negative because its y)
    private double MAX_FALL_SPEED  = 10;  // Since gravity is accel., giving a max falling speed to cap 
    private int[] ORIGINAL_VARIABLES;
    private double ORIGINAL_GRAVITY;
    
    
    
    // Holding Variables:
    private JPanel player1;
    private JPanel player2;
    private JLabel boost1;
    private JLabel boost2;
    private JPanel[] floors;
    private JPanel gameBox;
    private JLabel p1Indicator;
    private JLabel p2Indicator;
    private JProgressBar p1Time;
    private JProgressBar p2Time;
    private JPanel winningPanel;
    private JLabel winningPlayerText;
    

    
    // Dynamic Variables
    private JPanel currentTagger = null;     // This is the current tagger
    private boolean p1Frozen = false;        // Player is frozen after tagged
    private boolean p2Frozen = false;        // Player is frozen after tagged
    private int p1FrozenTime = 0;            // Keeps track of tick of player being frozen
    private int p2FrozenTime = 0;            // Keeps track of tick of player being frozen
    private boolean p1PressingLeft = false;  // Player 1 is pressing left
    private boolean p1PressingRight = false; // PLayer 1 is pressing right
    private boolean p1OnFloor = false;       // Player 1 is currently on the ground
    private boolean p2PressingLeft = false;  // Player 2 is pressing left
    private boolean p2PressingRight = false; // Player 2 is pressing right 
    private boolean p2OnFloor = false;       // Player 2 is currenly on the ground
    private Rectangle player1Rect;           // Holder for the rectangle bounds of a player
    private Rectangle player2Rect;           // Holder for the rectangle bounds of a player
    private Rectangle boost1Rect;            // Holder for the rectangle bounds of boost1 
    private Rectangle boost2Rect;            // Holder for the rectangle bounds of boost2
    private int p1Boost = 0;                 // The extra velocity this player has
    private int p2Boost = 0;                 // The extra velocity this player has
    private int boost1RespawnCounter = 0;    // Counter for the boost1
    private int boost2RespawnCounter = 0;    // Counter for the boost2
    private double p1VelocityY = 0;          // Player 1 vertical speed
    private double p2VelocityY = 0;          // Player 2 vertical speed
    private int p1BoostedTime = 0;           // Keeps track of how long player 1 has been boosted
    private int p2BoostedTime = 0;           // Keeps track of how long player 2 has been boosted
    private int boost1X;                     // Holds the x of boost 1
    private int boost1Y;                     // Holds the y of boost 1
    private int boost2X;                     // Holds the x of boost 2
    private int boost2Y;                     // Holds the y of boost 2
    private int indicatorX;                  // Holds the x of the indicators of the players
    private int indicatorY;                  // Holds the y of the indicators of the players
    

    
    // Constructor Function:
    public void setUp(JPanel p1, JPanel p2, JLabel b1, JLabel b2, JPanel[] f,
                      JPanel gb, JLabel p1I, JLabel p2I, JProgressBar p1T, JProgressBar p2T,
                      JPanel wp, JLabel wpt){
        // Setting up variables that we need from outside
        player1 = p1;
        player2 = p2;
        boost1 = b1;
        boost2 = b2;
        floors = f;
        gameBox = gb;
        boost1X = boost1.getX();
        boost1Y = boost1.getY();
        boost2X = boost2.getX();
        boost2Y = boost2.getY();
        p1Indicator = p1I;
        p2Indicator = p2I;
        indicatorX = p1Indicator.getX();
        indicatorY = p1Indicator.getY();
        p1Time = p1T;
        p2Time = p2T;
        winningPanel = wp;
        winningPlayerText = wpt;
        
        // Converting time variables on top to real game ticks
        GAME_MAX_TIME      = (int)(GAME_MAX_TIME * (1000.0 / GAME_TICK));
        TIME_FROZEN        = (int)(TIME_FROZEN * (1000.0 / GAME_TICK));
        BOOST_RESPAWN_TIME = (int)(BOOST_RESPAWN_TIME * (1000.0 / GAME_TICK));
        BOOSTED_TIME       = (int)(BOOSTED_TIME * (1000.0 / GAME_TICK));
        
        // Setting up the original variables so that user doesnt have to do that manully every time
        ORIGINAL_VARIABLES = new int[] {GAME_MAX_TIME, RUNNER_STEP, TAGGER_STEP, TIME_FROZEN, BOOST_STEP, BOOST_RESPAWN_TIME, BOOSTED_TIME};
        ORIGINAL_GRAVITY = GRAVITY;
    }
    
    
    // Public Functions:
    public void changeSettings(int gmt, int rs, int ts, int tf, int bs, int brt, int bt, double g){
        GAME_MAX_TIME = gmt;     
        RUNNER_STEP = rs;       
        TAGGER_STEP = ts;       
        TIME_FROZEN = tf;      
        BOOST_STEP = bs;         
        BOOST_RESPAWN_TIME = brt;
        BOOSTED_TIME = bt;  
        GRAVITY = g;     
        
        // Setting again into variable we use taking GAME_TICK into respect
        GAME_MAX_TIME      = (int)(GAME_MAX_TIME * (1000.0 / GAME_TICK));
        TIME_FROZEN        = (int)(TIME_FROZEN * (1000.0 / GAME_TICK));
        BOOST_RESPAWN_TIME = (int)(BOOST_RESPAWN_TIME * (1000.0 / GAME_TICK));
        BOOSTED_TIME       = (int)(BOOSTED_TIME * (1000.0 / GAME_TICK));
    }
    
    // Set Functions:
    public void resetVariables(String target){
        switch(target){
            case "GameMaxTime"      : GAME_MAX_TIME      = ORIGINAL_VARIABLES[0]; break;
            case "RunnerStep"       : RUNNER_STEP        = ORIGINAL_VARIABLES[1]; break;
            case "TaggerStep"       : TAGGER_STEP        = ORIGINAL_VARIABLES[2]; break;
            case "TimeFrozen"       : TIME_FROZEN        = ORIGINAL_VARIABLES[3]; break;
            case "BoostedStep"      : BOOST_STEP         = ORIGINAL_VARIABLES[4]; break; 
            case "BoostRespawnTime" : BOOST_RESPAWN_TIME = ORIGINAL_VARIABLES[5]; break;
            case "BoostedTime"      : BOOSTED_TIME       = ORIGINAL_VARIABLES[6]; break;
            case "Gravity"          : GRAVITY            = ORIGINAL_GRAVITY;      break;
        }
    }

    // Get Functions
    public int getGameMaxTime(){return (GAME_MAX_TIME / (1000/GAME_TICK));}
    public int getRunnerStep() {return RUNNER_STEP;}
    public int getTaggerStep() {return TAGGER_STEP;}
    public int getTimeFrozen() {return (TIME_FROZEN / (1000/GAME_TICK));}
    public int getBoostStep()  {return BOOST_STEP;}
    public int getBoostedTime(){return (BOOSTED_TIME / (1000/GAME_TICK));}
    public double getGravity() {return GRAVITY;}
    public int getBoostRespawnTime() {return (BOOST_RESPAWN_TIME / (1000/GAME_TICK));}
    
    
    // PLAYER INPUTS ==========================================================================
    // Player input: Buttons pressed
    public void p1LeftPressed() { p1PressingLeft  = true; }
    public void p1RightPressed(){ p1PressingRight = true; }
    public void p2LeftPressed() { p2PressingLeft  = true; }
    public void p2RightPressed(){ p2PressingRight = true; }
    
    // Player input: Buttons released
    public void p1LeftReleased()  { p1PressingLeft  = false; }
    public void p1RightReleased() { p1PressingRight = false; }
    public void p2LeftReleased()  { p2PressingLeft  = false; }
    public void p2RightReleased() { p2PressingRight = false; }
    
    // Player input: Up Buttons Pressed
    public void p1UpPressed(){ 
        if(p1OnFloor){
            p1VelocityY = JUMP_POWER;
            p1OnFloor = false; // Showing that the player is now jumping - will untrigger in the clock
        }
    }
    public void p2UpPressed(){ 
        if(p2OnFloor){ 
            p2VelocityY = JUMP_POWER; // Giving velocity to move player up
            p2OnFloor = false; // Showing that the player is now jumping - will untrigger in the clock
        }
    } 
    
    // ============================================================================================
    
    // Main starting function to reset the game and set up variables
    public void start(int startingPlayer){
        
        // Setting the starting tagger and changing 
        if(startingPlayer == 1)
            currentTagger = player2; // Setting to 2, so that changeCurrentRunner can change it to 1
        else
            currentTagger = player1;
        
        changeCurrentTagger();       // Correcting to the correct startig player -> needed to set up other variables
        
        // Re-hide indicators after layout is ready ||  (this is only needed for the first time we switch it)
        SwingUtilities.invokeLater(() -> {
            if (currentTagger == player1) {
                p2Indicator.setLocation(-200, -200);
            } else {
                p1Indicator.setLocation(-200, -200);
            }
        });
        
        
        // Resetting other variables
        p1Frozen = p2Frozen = false;    // Resetting the frozen players
        p1OnFloor = p2OnFloor = false;  // Both players start in the air, so showing 
        p1PressingLeft = p1PressingRight = false; // Resetting the triggers
        p2PressingLeft = p2PressingRight = false; // Resetting the triggers 
        p1FrozenTime = p2FrozenTime = 0;          // Resetting the amount of time frozen
        p1Boost = p2Boost = 0;                    // Resetting the amount of extra boost
        boost1RespawnCounter = boost2RespawnCounter = 0; // Resetting the boost counter
        p1VelocityY = p2VelocityY = 0;            // Resetting the velocity of both players back to 0
        p1BoostedTime = p2BoostedTime = 0;        // Resetting the amount of time each player has been boosted back to 0
        p1Time.setMaximum(GAME_MAX_TIME);         // Setting the max time for the player
        p2Time.setMaximum(GAME_MAX_TIME);         // Setting the max time for the player
        p1Time.setValue(0);                       // Resetting the tagged time for player
        p1Time.setValue(0);                       // Resetting the tagged time for player
        
        clock.start();                            // Start the game clock!!!
        if(currentTagger == player1)              // Setting up the indicator for whoever is tagger
            p2Indicator.setLocation(-200,-200);
        else
            p1Indicator.setLocation(-200,-200);
    }
    
    
    // Stops all timers of the game 
    public void stopGame(){
        clock.stop();
    }
    
    
    
    // TIMERS:
    private final Timer clock = new Timer(GAME_TICK, e->{
        // ADDING TIME TO TAGGER ===============================================================
        // Player 1 is tagger and is not frozen
        if(currentTagger == player1 && !p1Frozen){ 
            p1Time.setValue(p1Time.getValue() + 1);   // Increase the value
            if(p1Time.getValue() >= GAME_MAX_TIME){   // Check if this makes end of game
                ((Timer)e.getSource()).stop();        // Stopping the game
                winningPanel.setVisible(true);        // Showing the panel
                winningPlayerText.setText("Player 2");// Updating the winner text
            }
                
        }
        // Player 2 is tagger and is not frozen
        else if (currentTagger == player2 && !p2Frozen){
            p2Time.setValue(p2Time.getValue() + 1);
            if(p2Time.getValue() >= GAME_MAX_TIME){
                ((Timer)e.getSource()).stop();
                winningPanel.setVisible(true);
                winningPlayerText.setText("Player 1");
            }
        }
        // =====================================================================================
        
        
        // PLAYER MOVEMENT =====================================================================
        int newX;
        
        // Player 1 movement left/right ------------------------------------------
        if(p1PressingLeft && !p1Frozen){ 
            // Getting the new player position, minus the move that player is suppose to take
            newX = player1.getX() - (currentTagger == player1 ? TAGGER_STEP : RUNNER_STEP) - p1Boost; 
            
            // Clamping at 0 when moving left
            if(newX < 0)
                newX = 0;
            
            // Moving player IF we are not touching a wall
            if (!isPlayerTouchingWall(player1, newX)) {
                player1.setLocation(newX, player1.getY());
            }
        }
        if(p1PressingRight && !p1Frozen){ // No use on checking pressing right if p1 is moving left (else-if)
            // Getting new player location, PLUS the move that player is suppose to take
            newX = player1.getX() + (currentTagger == player1 ? TAGGER_STEP : RUNNER_STEP) + p1Boost;
            
            // Clamping the newX for a max of the position it can be to still be inside the game box
            if(newX > (gameBox.getWidth() - player1.getWidth())){
                newX = gameBox.getWidth() - player1.getWidth();
            }
            
            // Moving player IF we are not touching a wall
            if (!isPlayerTouchingWall(player1, newX)) {
                player1.setLocation(newX, player1.getY());
            }
        }
        
        if(p1Frozen){
            p1FrozenTime++;
            if (p1FrozenTime >= TIME_FROZEN) {
                p1FrozenTime = 0;
                p1Frozen = false;
            }
        }
        
        // Check if this move sets the player in the air (steps off an edge)
        if (!isPlayerTouchingFloor(player1) && !p1Frozen) {
            p1OnFloor = false; // Set to player is in air
            if (p1VelocityY == 0)
                p1VelocityY = GRAVITY;
        } 
        
        // Player 2 movement left/right ------------------------------------------
        if(p2PressingLeft && !p2Frozen){
            // Getting the new player position, minus the move that player is suppose to take
            newX = player2.getX() - (currentTagger == player2 ? TAGGER_STEP : RUNNER_STEP) - p2Boost; 
            
            // Clamping at 0 when moving left
            if(newX < 0)
                newX = 0;
            
            // Moving player IF we are not touching a wall
            if (!isPlayerTouchingWall(player2, newX)) {
                player2.setLocation(newX, player2.getY());
            }
        }
        if(p2PressingRight && !p2Frozen){
            // Getting new player location, PLUS the move that player is suppose to take
            newX = player2.getX() + (currentTagger == player2 ? TAGGER_STEP : RUNNER_STEP) + p2Boost;
            
            // Clamping the newX for a max of the position it can be to still be inside the game box
            if(newX > (gameBox.getWidth() - player2.getWidth())){
                newX = gameBox.getWidth() - player2.getWidth();
            }
            
            // Moving player IF we are not touching a wall
            if (!isPlayerTouchingWall(player2, newX)) {
                player2.setLocation(newX, player2.getY());
            }
        }
        if(p2Frozen){
            p2FrozenTime++;
            if (p2FrozenTime >= TIME_FROZEN) {
                p2FrozenTime = 0;
                p2Frozen = false;
            }
        }
        
        // Check if this move sets the player in the air (steps off an edge)
        if (!isPlayerTouchingFloor(player2) && !p2Frozen) {
            p2OnFloor = false; // Set to player is in air
            if (p2VelocityY == 0)
                p2VelocityY = GRAVITY;
        } 
        
        // Player 1 Y-Movement ----------------------------------------------------
        if (!p1OnFloor && !p1Frozen) {
            p1VelocityY += GRAVITY; // Apply gravity
            if (p1VelocityY > MAX_FALL_SPEED)
                p1VelocityY = MAX_FALL_SPEED; // Cap speed at max fall speed

            int newY = (int)(player1.getY() + p1VelocityY);
            player1.setLocation(player1.getX(), newY);
            
            // Checking if this made the player touch teh bottom of a floor, then make their velocity 0 again
            player1Rect = player1.getBounds();
            for (JPanel floor : floors) {
                Rectangle floorRect = floor.getBounds();
                if (p1VelocityY < 0 && player1Rect.intersects(floorRect)) {
                    player1.setLocation(player1.getX(), floorRect.y + floorRect.height);
                    p1VelocityY = 0;
                    break;
                }
            }

            // Check if now touching a floor
            if (isPlayerTouchingFloor(player1)) {
                p1OnFloor = true;
                p1VelocityY = 0;

                // Snap to floor so player doesn’t “sink” in
                for (JPanel floor : floors) {
                    if (floor.getBounds().intersects(player1.getBounds())) {
                        player1.setLocation(player1.getX(), floor.getY() - player1.getHeight());
                        break;
                    }
                }
            }
        }
        
        // Player 2 Y-Movement ----------------------------------------------------
        if (!p2OnFloor && !p2Frozen) {
            p2VelocityY += GRAVITY;
            if (p2VelocityY > MAX_FALL_SPEED) 
                p2VelocityY = MAX_FALL_SPEED;

            int newY = (int)(player2.getY() + p2VelocityY);
            player2.setLocation(player2.getX(), newY);
            
            // Checking if this made the player touch teh bottom of a floor, then make their velocity 0 again
            player2Rect = player2.getBounds();
            for (JPanel floor : floors) {
                Rectangle floorRect = floor.getBounds();    
                if (p2VelocityY < 0 && player2Rect.intersects(floorRect)) {
                    player2.setLocation(player2.getX(), floorRect.y + floorRect.height);
                    p2VelocityY = 0;
                    break;
                }
            }
           
            
            // Check for floor collision
            if (isPlayerTouchingFloor(player2)) {
                p2OnFloor = true;
                p2VelocityY = 0;

                // Snap to floor so player doesn’t “sink” in
                for (JPanel floor : floors) {
                    if (floor.getBounds().intersects(player2.getBounds())) {
                        player2.setLocation(player2.getX(), floor.getY() - player2.getHeight());
                        break;
                    }
                }
            }
        }
        // =====================================================================================
        
        
        // CHECK IF TAGGER TOUCHED RUNNER ======================================================
        handleTagCollision(); // Checks if the players connected and move them apart if they do
        // =====================================================================================
        
        
        
        
        
        // CHECK IF A PLAYER HAS TOUCHED THE BOOST =============================================
        // If boost is visible, check if player has touched it (CHECKING BOOST 1)
        if(boost1.getX() == boost1X){
            boost1Rect = boost1.getBounds();
            if(player1Rect.intersects(boost1Rect)){    
                if(p1Boost == BOOST_STEP){ // Checking if the player already has the boost, just add the time instead of doing the ELSE
                    p1BoostedTime = 0;
                }
                else{
                    p1Boost = BOOST_STEP;
                    boost1.setLocation(-200, -200); // Moving it out of range
                }
            }
            else if(player2Rect.intersects(boost1Rect)){
                if(p2Boost == BOOST_STEP){
                    p1BoostedTime = 0;
                }
                else{
                    p2Boost = BOOST_STEP;
                    boost1.setLocation(-200, -200); // Moving it out of range
                }
            }
        }
        // If this boost is not visible, continue the ticks to make it later visible
        else{
            boost1RespawnCounter++;
            if(boost1RespawnCounter >= BOOST_RESPAWN_TIME){
                boost1RespawnCounter = 0;             // Resetting the respawn counter
                boost1.setLocation(boost1X, boost1Y); // Moving back to its position
            }
        }
        
        
        // CHECKING BOOST 2:
        if(boost2.getX() == boost2X){
            boost2Rect = boost2.getBounds();
            if(player1Rect.intersects(boost2Rect)){
                if(p1Boost == BOOST_STEP){
                    p1BoostedTime = 0;
                }
                else{
                    p1Boost = BOOST_STEP;
                    boost2.setLocation(-200,-200);
                }
            }
            else if(player2Rect.intersects(boost2Rect)){
                if(p2Boost == BOOST_STEP){
                    p2BoostedTime = 0;
                }
                else{
                    p2Boost = BOOST_STEP;
                    boost2.setLocation(-200,-200);
                }
            }
        }
        // If this boost is not visible, continue ticks to make it visible later
        else{
            boost2RespawnCounter++;
            if(boost2RespawnCounter >= BOOST_RESPAWN_TIME){
                boost2RespawnCounter = 0;             // Resetting the respawn coutner
                boost2.setLocation(boost2X, boost2Y); // Moving back to its position
            }
        }
        
        
        
        
        // Checking if boost of player 1 should be removed
        if(p1Boost == BOOST_STEP){
            p1BoostedTime++;       // Increasing the boosted tick
            
            // Checking if its time for the boost to be removed
            if(p1BoostedTime >= BOOSTED_TIME){
                p1BoostedTime = 0; // Resetting the ticker back to zero
                p1Boost = 0;       // Resetting the boost of the player back to 0
            }
        }
        
        // Checking if boost of player 2 should be removed
        if(p2Boost == BOOST_STEP){
            p2BoostedTime++;       // Increasing the boosted tick
            
            // Checking if its time for the boost to be removed
            if(p2BoostedTime >= BOOSTED_TIME){
                p2BoostedTime = 0; // Resetting the ticker back to zero
                p2Boost = 0;       // Resetting the boost of the player back to 0
            }
        }
        
        
        
        
        // =====================================================================================
    });
    
    
    
    
    // Private Functions
    private void handleTagCollision() {
        player1Rect = player1.getBounds();
        player2Rect = player2.getBounds();

        if (player1Rect.intersects(player2Rect)) {
            // Find out who is tagger:
            if (currentTagger == player1 && !p1Frozen) { // If tagger was p1, push p2 away
                p2Frozen = true;

                // Push runner away from tagger
                int push = player1.getWidth() + 1; // small offset
                int newX;
                if (player2.getX() < player1.getX()) {
                    newX = player2.getX() - push;
                    
                     // If this push would move the p2 outside of the game box, push player 1 instead
                    if(newX < 0)
                        player1.setLocation(player1.getX() + push, player1.getY());
                    else
                        player2.setLocation(newX, player2.getY());
                    
                } else {
                    newX = player2.getX() + push;
                    
                    // If this push would move the p2 outside of the game box, push p1 instead 
                    if(newX > gameBox.getWidth() - player2.getWidth())
                        player1.setLocation(player1.getX() - push, player1.getY());
                    else
                        player2.setLocation(newX, player2.getY());
                }
                changeCurrentTagger();
                
                
            } else if(currentTagger == player2 && !p2Frozen){
                p1Frozen = true;

                int push = player2.getWidth() + 1;
                int newX;
                if (player1.getX() < player2.getX()) {
                    newX = player1.getX() - push;
                    
                    if(newX < 0)
                        player2.setLocation(player2.getX() + push, player2.getY());
                    else
                        player1.setLocation(newX, player1.getY());
                } else {
                    newX = player1.getX() + push;
                    
                    if(newX > gameBox.getWidth() - player1.getWidth())
                        player2.setLocation(player2.getX() - push, player2.getY());
                    else
                        player1.setLocation(newX, player1.getY());
                }

                changeCurrentTagger();
            }
        }
    }
    
    
    private boolean isPlayerTouchingFloor(JPanel targetPlayer){
        Rectangle player = targetPlayer.getBounds();
        int playerBottom = player.y + player.height;
        int playerLeft = player.x;
        int playerRight = player.x + player.width;

        for (JPanel floor : floors) {
            Rectangle currentFloor = floor.getBounds();

            int floorTop = currentFloor.y;
            int floorLeft = currentFloor.x;
            int floorRight = currentFloor.x + currentFloor.width;

            // Conditions for standing on top of the floor 
            boolean horizontallyOverlaps = playerRight > floorLeft + 5 && playerLeft < floorRight - 5;
            boolean touchingTop = playerBottom >= floorTop && playerBottom <= floorTop + 10; 

            if (horizontallyOverlaps && touchingTop) {
                return true;
            }
        }
        return false;
    }
    
    private boolean isPlayerTouchingWall(JPanel player, int newX) {
        Rectangle futurePos = new Rectangle(newX, player.getY(), player.getWidth(), player.getHeight());

        for (JPanel floor : floors) {
            Rectangle f = floor.getBounds();

            // Only count collision if player is not standing on top or under
            boolean verticalOverlap = futurePos.y + futurePos.height > f.y + 5 &&
                                      futurePos.y < f.y + f.height - 5;

            if (futurePos.intersects(f) && verticalOverlap) {
                return true;
            }
        }
        return false;
    }
    
    private void changeCurrentTagger(){
        if(currentTagger == player1){      // If player 1 is tagger, change to player 2
            p1Indicator.setLocation(-200,-200);              // Moving indicator out of view
            p2Indicator.setLocation(indicatorX, indicatorY); // Moving indicator INTO view
            currentTagger = player2;                         // Saving this info
            p2Frozen = true;                                 // Setting the flag to freeze player 2 since they are new tagger
        }
        else{ // If player 2 is tagger, change to player 1
            p2Indicator.setLocation(-200,-200);
            p1Indicator.setLocation(indicatorX, indicatorY);
            currentTagger = player1;
            p1Frozen = true;
        }
        
    }
   
}
