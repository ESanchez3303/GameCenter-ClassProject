/**
 *
 * @author Emanuel
 */
package classproject;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
       



public class PingPong {
    // MAIN GAME VARIABLES:
    private final int GAME_TIME = 120;
    private final int SECONDS_BEFORE_BOOSTING = 5;
    private final int GAME_TICK = 10;
    private final int PLAYER_STEP = 4;
    private int COMPUTER_STEP = 1;         // Not final because this is changed when computer gets "better"
    private final int SCORE_FOR_GOOD_GOAL = 100;
    private final int SCORE_FOR_BAD_GOAL = -50;
    private final List<Integer> deltaEdges = new ArrayList<>(Arrays.asList(18,36,54,72,90,108,126,144,162,180,198,216,234,252,270,288,306,324,342,360));
    private final List<Integer> ballMovesX_list = new ArrayList<>(Arrays.asList(0,1,2,3,4,4,3,2,1,0,0,-1,-2,-3,-4,-4,-3,-2,-1,0));
    private final List<Integer> ballMovesY_list = new ArrayList<>(Arrays.asList(-4,-3,-2,-1,0,0,1,2,3,4,4,3,2,1,0,0,-1,-2,-3,-4));
     
    // BOOSTED BALL MOVES:
    private int boostedBallMultiply = 1;
    private int boostedBallCountKeeper = 0;                       
    private List<Integer> boostedBallMovesX = new ArrayList<>();
    private List<Integer> boostedBallMovesY = new ArrayList<>();
   
    
    
    
    
    
    // Holding Variables:
    private JPanel player;   // Panel that is the player
    private JPanel computer; // Panel that is the computer
    private JPanel ball;     // Panel that is the ball
    private JLabel playerScore;   // Players score keeper
    private JLabel computerScore; // Computer score keeper
    private JLabel countDownLabel;// Label that will be the countdown between goals
    private JLabel score;         // Panel that shows the score
    private int delta;            // The current angle of the ball (0-360)
    private JProgressBar timerBar;
    private JLabel countDownTimerText;
    private JLabel points;
    private HighscoreManager scores_fromOutside;
    private String currentUser_fromOutside;
    private JPanel resetCover;
    private boolean twoPlayerMode = false;
    
    // Dynamic Movement Variables:
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean playerBusy = false;
    private boolean upPressed2 = false;
    private boolean downPressed2 = false;
    private boolean playerBusy2 = false;
    private int ballMoveX;
    private int ballMoveY;
    private int computerPlaysAtTick = 5; // Computer is allowed to move every x ticks of the game clock (this slows down the computer to be fair)
    private int computerTick = 0;        // Keeps track of which tick we are in, this will cycle between 0-x (x being computerPlaysAtTick)
    private boolean betweenRounds = false;
    private int timePassed = 0;
    
    
    
    
    
    // CONSTRUCTOR
    public void setUp(JPanel p, JPanel c, JPanel b, JLabel pS, JLabel cS, JLabel cT, JLabel pP, JProgressBar t,
                      JLabel cdt, JLabel pts, JPanel rc){
        // Setting up variables:
        player = p;
        computer = c; // this will also be the player input instead of computer when we are in 2 player mode
        ball = b;
        playerScore = pS;
        computerScore = cS;
        countDownLabel = cT;
        score = pP;
        timerBar = t;
        countDownTimerText = cdt;
        points = pts;
        resetCover = rc;
        boostBall();
    }
    
    
    // Get Functions:
    public boolean isTwoPlayerMode(){return twoPlayerMode;}
    public int getGameTime(){return GAME_TIME;}
    
    
    
    // MOVEMENT FUNCTIONS:
    public void upPressed(){if(!playerBusy){upPressed = true; playerBusy = true;}}  
    public void downPressed(){if(!playerBusy){downPressed = true; playerBusy = true;}}
    public void upReleased(){upPressed = false; playerBusy = false;}
    public void downReleased(){downPressed = false; playerBusy = false;}
    
    public void setTwoPlayerMode(boolean input) {twoPlayerMode = input;}
    public void upPressed2(){if(!playerBusy2){upPressed2 = true; playerBusy2 = true;}}  
    public void downPressed2(){if(!playerBusy2){downPressed2 = true; playerBusy2 = true;}}
    public void upReleased2(){upPressed2 = false; playerBusy2 = false;}
    public void downReleased2(){downPressed2 = false; playerBusy2 = false;}
    

    
    // Public Functions:
    public void reset(){
        player.setLocation(50,225);
        computer.setLocation(660,225);
        ball.setLocation(350,240);
        upPressed = downPressed = playerBusy = false;
        upPressed2 = downPressed2 = playerBusy2 = false;
        computerTick = 0;
        delta = getLaunchDegree();
        
        boostedBallCountKeeper = (int)(SECONDS_BEFORE_BOOSTING*1000)/GAME_TICK;
        boostedBallMultiply = 1;
        ball.setBackground(new Color(255,255,255)); // Setting the ball color to white again (for when we change color)
    }
    
    public void stopGame(){
        clock.stop();
        countDownTimer.stop();
    }
    
    public void pauseGame(){
        clock.stop();
        countDownTimer.stop();
        countDownLabel.setText("Game Paused");
        countDownLabel.setVisible(true);
    }
    
    public void continueGame(){
        // Reset the player inputs
        upPressed = downPressed = playerBusy = upPressed2 = downPressed2 = playerBusy2 = false;
        
        countDownLabel.setText("3");
        countDownLabel.setVisible(true);
        Timer continueTimer = new Timer(1000, e->{
            int continueTime = Integer.parseInt(countDownLabel.getText());
            continueTime--;
            if(continueTime <= 0){
                ((Timer)e.getSource()).stop();
                countDownLabel.setVisible(false);
                clock.start();
            }
            else{
                countDownLabel.setText(Integer.toString(continueTime));
            }
        });
        continueTimer.start();
    }
    
    public void startGame(){
        // Reset the player inputs
        upPressed = downPressed = playerBusy = upPressed2 = downPressed2 = playerBusy2 = false;
        
        countDownLabel.setText("3");
        countDownLabel.setVisible(true);
        betweenRounds = true;    
        countDownTimer.start();  // Starts the countdown which also starts the game
        startGameTimer();        // Starts the timer that keeps track of how long the game has been played (general lenght timer)
    }
    
    
    
    // TIMERS:
    private void startGameTimer(){
        timePassed = 0;
        timerBar.setMaximum(GAME_TIME);
        timerBar.setValue(0);
        
        Timer gameTimer = new Timer(1000, e->{
            if(countDownTimerText.isVisible() && timePassed != GAME_TIME){ // DO NOT COUNT WHEN WE ARE IN A COUNTDOWN, unless!! the game is waiting for next point
                return;
            }
            timePassed++;
            
            if(timePassed >= GAME_TIME) // Clamping time passed to be at a max of full tiem
                timePassed = GAME_TIME;
            
            timerBar.setValue(timePassed);
            if(timePassed >= GAME_TIME){
                if(!twoPlayerMode){ // If in single player mode, report score and show score
                    ((Timer)e.getSource()).stop();
                    stopGame();
                    String message = "Game Finsihed!\nPoints: " + points.getText();
                    if(scores_fromOutside.reportScore("PP", currentUser_fromOutside, points.getText()))
                        message = message + "\nYOU SET THE NEW HIGH SCORE!";
                    JOptionPane.showMessageDialog(null, message);    
                    resetCover.setVisible(true);
                }
                else{ // If in two player mode
                    if(countDownTimerText.isVisible()){   // When the countdown timer becomes visible, end the game
                        countDownTimerText.setVisible(false); // Remake invisible
                        ((Timer)e.getSource()).stop();
                        stopGame();
                        
                        // Build the end of game message
                        String message = "Game Finished!\n";
                        if(Integer.parseInt(playerScore.getText()) > Integer.parseInt(computerScore.getText()))
                            message += "Player 1 Wins!";
                        else if(Integer.parseInt(playerScore.getText()) < Integer.parseInt(computerScore.getText()))
                            message += "Player 2 Wins";
                        else
                            message += "Its a draw!";
                        JOptionPane.showMessageDialog(null, message);  
                        resetCover.setVisible(true);
                    }
                }
            }
        });
        gameTimer.start();
    }
    
    Timer clock = new Timer(GAME_TICK, e->{
        // Checking if we need to boost the ball -------------------------------------------------------------------------------------
        if(twoPlayerMode){
            if(boostedBallCountKeeper <= 0 ){
                boostedBallCountKeeper = (int)(SECONDS_BEFORE_BOOSTING*1000)/GAME_TICK;
                boostedBallMultiply++;
                boostBall();
            }
            else if(boostedBallCountKeeper <= 100){
                if(boostedBallCountKeeper % 10 == 0)
                    ball.setBackground(new Color(255,255,255));
                else
                    ball.setBackground(new Color(255,0,0));
            }
            boostedBallCountKeeper--;
        }
        
        // Move Player (while validating): ----------------------------------------------------------------------------------------------------------
            if(upPressed){                                                                     // Player is pushing up --> move player up
                if(player.getLocation().y > 0){                                                // Player is NOT at max upward position, player is allowed to move
                    if(player.getLocation().y - PLAYER_STEP < 0)                               // If this move will put player above max position
                        player.setLocation(player.getLocation().x, 0);                         // Move to max position 
                    else
                        player.setLocation(player.getLocation().x, player.getLocation().y - PLAYER_STEP); // Move player UP by the STEP amount (2) if was a valid position
                }
            }
            else if(downPressed){                                                              // Player is pushinng down --> move player down
                if(player.getLocation().y < 450){                                              // Player is NOT at the max downward position, player is allowed to move
                    if(player.getLocation().y + PLAYER_STEP > 450)                             // If this move will put player below min position 
                        player.setLocation(player.getLocation().x, 450);                       // Move player to min position ONLY
                    else
                        player.setLocation(player.getLocation().x, player.getLocation().y + PLAYER_STEP); // Move player DOWN up the STEP amount (2) if was a vlid position
                
                }
            } 
            // ELSE() ---> If player is not pushing anything, leave player there for this tick
            
            // Check if two players are playing if so do this, if not do the else:
            if(twoPlayerMode){
                if(upPressed2){                                                                     // Player is pushing up --> move player up
                    if(computer.getLocation().y > 0){                                               // Player is NOT at max upward position, player is allowed to move
                        if(computer.getLocation().y - PLAYER_STEP < 0)                              // If this move will put player above max position
                            computer.setLocation(computer.getLocation().x, 0);                      // Move to max position 
                        else
                            computer.setLocation(computer.getLocation().x, computer.getLocation().y - PLAYER_STEP); // Move player UP by the STEP amount (2) if was a valid position
                    }
                }
                else if(downPressed2){                                                              // Player is pushinng down --> move player down
                    if(computer.getLocation().y < 450){                                             // Player is NOT at the max downward position, player is allowed to move
                        if(computer.getLocation().y + PLAYER_STEP > 450)                            // If this move will put player below min position 
                            computer.setLocation(computer.getLocation().x, 450);                    // Move player to min position ONLY
                        else
                            computer.setLocation(computer.getLocation().x, computer.getLocation().y + PLAYER_STEP); // Move player DOWN up the STEP amount (2) if was a vlid position

                    }
                } 
            }
            else{
                // Move Computer (revalidate) --------------------------------------------------------------------------------------------------------------------
                computerTick++; // Increasing to check if computer plays this tick
                if(computerTick >= computerPlaysAtTick){
                    computerTick = 0; // Reseting the tick to restart cycle
                    if(ball.getLocation().y <= computer.getLocation().y){           // If ball y is higher than computer y, move up
                        if(computer.getLocation().y - COMPUTER_STEP  < 0)           // If this move would put computer out of bounds
                            computer.setLocation(computer.getLocation().x,0);       // Move to 0 position
                        else
                            computer.setLocation(computer.getLocation().x, computer.getLocation().y - COMPUTER_STEP); // Move to location by step
                    }
                    else{                                                            // If ball y is lower than computer y, move down
                        if(computer.getLocation().y + COMPUTER_STEP > 450)           // If this move would put computer out of bounds
                            computer.setLocation(computer.getLocation().x, 450);     // Move to 450 position
                        else
                            computer.setLocation(computer.getLocation().x, computer.getLocation().y + COMPUTER_STEP); // Move to location by step
                    }

                }
            }
            
            
            
            // Move Ball (while validating): -----------------------------------------------------------------------------------------------------------------
            // Logic: split quad into 5 pieces (leaving 360 be 0 at that instance)
            //  UP-RIGHT (quad 4) example:
            //    o if in 270-287 ----> 4 left
            //    o if in 288-205 ----> 3 left, 1 up
            //    o if in 306-323 ----> 2 left, 2 up
            //    o if in 324-359 ----> 4 up
            
            getBallMoveUsingDelta();
            if(ballMoveX == -999 || ballMoveY == -999){   // Check if the delta was in bounds
                System.out.println("GAME 3 CRASHED"); // This could be handled better using a joptionpane
                stopGame();
                return;
            }
            
            // Check if ball will put ball out of bounds, then move ball ----------------------------------------------------------------
            int newBallLocationX = ball.getLocation().x + ballMoveX;
            int newBallLocationY = ball.getLocation().y + ballMoveY;
            
            // Clamp ball in: (0,30) to (670,480)
            if(newBallLocationX < 30)
                newBallLocationX = 30;
            if(newBallLocationX > 670)
                newBallLocationX = 670;
            if(newBallLocationY < 0)
                newBallLocationY = 0;
            if(newBallLocationY > 480)
                newBallLocationY = 480;
            
            // Moving the ball to this location, now that it is safe
            ball.setLocation(newBallLocationX, newBallLocationY);
            
            
            
             
            // Check if ball touched a wall, change the delta to "reflect" off it ----------------------------------------------
            if(newBallLocationY == 0){      // If ball touched top wall
                if(delta >= 342 || delta < 18) // If ball came at wall in striahgt line
                    delta = 110;     // Changing delta to be 100 which is bottom right angle, slow rate
                else{
                    if(delta >= 180)     // If ball is moving left
                        addToDelta(-90); // Subtracts to reduce the total delta by this reflect amount
                    else
                        addToDelta(90);  // Adds to incrase total delta by this reflect amount
                }
            }
            if(newBallLocationY == 480){    // If ball touched the bottom wall
                if(delta >= 162 && delta < 198) // If ball came at wall in straight line
                    delta = 290;     // Changing delta to be 290 which is up left angle, slow rate
                else{
                    if(delta >= 180)     // If ball is moving left
                        addToDelta(90);  // Adds to incrase total delta by this reflect amount
                    else
                        addToDelta(-90); // Subtracts to reduce the total delta by this reflect amount
                }
            }
            
            int ballPlayAreaLeft = 45;
            int ballPlayAreaRight = 665;
            
            // Check if ball touched player/computer (make sure to change ball direction) ----------------------------------------------
            if(ball.getLocation().x >= ballPlayAreaLeft && ball.getLocation().x <= ballPlayAreaRight){ // If ball is still inside the playable area
                int ballGraceSize = ball.getWidth() - 3;                   // 20-3 = 18, grace size that is still considered a hit
                if(delta >= 180){                                          // Ball is moving left (towards player)
                    if(ball.getLocation().x <= (player.getLocation().x + player.getWidth())){ // If ball is in valid x value to check of touching paddle
                        int playerTopY    = player.getLocation().y;                           // Save the top y of player 
                        int playerBottomY = player.getLocation().y + player.getHeight();      // Save the bottom y of player

                        if((ball.getLocation().y + ballGraceSize) >= playerTopY && ball.getLocation().y <= playerBottomY){
                            if(delta >= 252 && delta < 288) // If ball came in a straight line
                                addToDelta(161);             // 180 - 18 - 1, flipping ball aroudn and sub. one instead of just straight bacl
                            else{
                                if(delta >= 270){                    // If ball is moving upward
                                    addToDelta(90);                  // Add regular 90 reflection
                                    if(upPressed) addToDelta(20);    // If user is going up at the same time, then add extra 20 
                                    if(downPressed) addToDelta(-20); // If user is going down at the same tiem, take away extra 20
                                }
                                else{                                // If ball is moving downward
                                    addToDelta(-90);                 // Sub regular 90 reflection
                                    if(upPressed) addToDelta(-20);    // If user is going up at the same time, then sub extra 20 
                                    if(downPressed) addToDelta(20); // If user is going down at the same tiem, then add  extra 20
                                }
                            }
                            
                            // Double checking that delta does not go straight up into a wall
                            if(delta >= 342 || delta < 18) // If delta is going straight up, change to going up right
                                delta = 19;
                            if(delta >= 162 && delta < 198) // If delta is going straight down, change to going down right
                                delta = 197;
                        }

                    }
                    
                    
                }
                else{
                    if((ball.getLocation().x + ball.getWidth()) >= (computer.getLocation().x)){
                        int computerTopY = computer.getLocation().y;
                        int computerBottomY = computer.getLocation().y + computer.getHeight();

                        if((ball.getLocation().y + ballGraceSize) >= computerTopY && ball.getLocation().y <= computerBottomY ){
                            if(delta >= 72 && delta < 108)
                                addToDelta(199);    // 180 + 18 + 1, flipping ball around and adding one iter up instead of just straight back
                            else{
                                if(delta <= 90){
                                    addToDelta(-90);                 // If ball is moving upward, sub 90
                                    if(upPressed2) addToDelta(-20);  // If up is pressed, add extra
                                    if(downPressed2) addToDelta(20); // If dpwn is pressed, add extra
                                }
                                else{
                                    addToDelta(90);                   // If ball is moving downward, add 90
                                    if(upPressed2) addToDelta(20);    // If up is pressed, add extra
                                    if(downPressed2) addToDelta(-20); // If dpwn is pressed, add extra
                                }
                            }
                        }
                        
                        // Double checking that delta does not go straight into a wall
                        if(delta >= 342 || delta < 18) // If delta is going straight up, change to going up right
                                delta = 341;
                        if(delta >= 162 && delta < 198)// If delta is going straight down, change to going down right
                                delta = 199;
                    }
                }
            }
            
            
                
            // Check if ball touched goal
            if(ball.getLocation().x < ballPlayAreaLeft) // Goal made by computer
                 goalMade(false);
            
            if(ball.getLocation().x > ballPlayAreaRight) // Goal madde by player
                goalMade(true);
            
                
    });
    
    

    Timer countDownTimer = new Timer(1000, e->{
        countDownLabel.setVisible(true);                              // Show the countdown label
        int currentTime = Integer.parseInt(countDownLabel.getText()); // Get the number that is in the countdown label
        currentTime--;                                                // Decrease the countdown
        if(currentTime <= 0){                                         // When countdown reaches 0
            ((Timer)e.getSource()).stop();    // Stop timer
            countDownLabel.setVisible(false); // Hide the countdown 
            delta = getLaunchDegree();        // Set a new delta
            betweenRounds = false;            // Remove the between rounds signal
            
            // Reset the player inputs
            upPressed = downPressed = playerBusy = upPressed2 = downPressed2 = playerBusy2 = false;
        
            clock.start();                    // Start game clock
        }
        else{
            countDownLabel.setText(Integer.toString(currentTime));    // Show the new decreased countdown
        }
    });
    
    
    
    
    
    
    

            
            
    
    
    
    // HELPER FUNCTIONS:
    private void getBallMoveUsingDelta(){
        if(delta < 0){
            ballMoveX = -999;
            ballMoveY = -999;
            return;
        }
        
        int insideOfEdge = 0;
        for(int  edge : deltaEdges){
            if(delta < edge)
                break;
            insideOfEdge++; 
        }
        
        // If insideOfEdge is out of bounds then we know that delta is out of bounds
        if(insideOfEdge >= deltaEdges.size()){
            ballMoveX = -999;
            ballMoveY = -999;
            return;
        }
        
        
        // Setting the ball moves accordingly
        if(boostedBallMultiply == 1){ // If we are in regular speed (we dont change boostBall if we are in regular)
            ballMoveX = ballMovesX_list.get(insideOfEdge);
            ballMoveY = ballMovesY_list.get(insideOfEdge);
        }
        else{                 // If we are in boosted ball mode - use the boosted ball list instead of regular
            ballMoveX = boostedBallMovesX.get(insideOfEdge);
            ballMoveY = boostedBallMovesY.get(insideOfEdge);
        }
    }
    
    private void addToDelta(int amountToIncrease){
        delta += amountToIncrease; // Increase/decrease delta by this amount 
        if(delta < 0)              // If this made delta negative 
            delta = 365 + delta;       // Do 365 + (-35) = 330 [example]: this keeps withing 0-365 
        else if(delta == 365)      // If this made delta exactly 365, just change to 0 and leave alone for catch
            delta = 0;
        else if(delta > 365)       // If this made over 365
            delta = delta - 365;       // Take the bigger number (delta) and take away the 365 to cycle back to 0
    }
    
    
    private void goalMade(boolean goalByPlayer){
        if(betweenRounds)
            return;
        clock.stop(); // Stop the game tick
        
        // Give the point to the person that made the goal
        if(goalByPlayer){
           
            int currentScore = Integer.parseInt(playerScore.getText());
            currentScore++;
            playerScore.setText(Integer.toString(currentScore));

            if(!twoPlayerMode){ // If we are in single player mode, increase computer diff. and add score 
                // Increase the difficulty of the computer as we go (first inscrease the computer play rate, then the speed of computer)
                computerPlaysAtTick--;
                if(computerPlaysAtTick <= 0){
                    computerPlaysAtTick = 0;
                    COMPUTER_STEP++;
                    if(COMPUTER_STEP >= 5)
                        COMPUTER_STEP = 5;
                }
                // Add to the score
                score.setText(Integer.toString(Integer.parseInt(score.getText()) + SCORE_FOR_GOOD_GOAL));
            }
            
            
        }
        else{
            int currentScore = Integer.parseInt(computerScore.getText());
            currentScore++;
            computerScore.setText(Integer.toString(currentScore));
            
            if(!twoPlayerMode){ // If in single player mode, incrase score
                // Subtract from the score (its a negative so we technically add it)
                score.setText(Integer.toString(Integer.parseInt(score.getText()) + SCORE_FOR_BAD_GOAL));
            }
        }
        
        // Reset the player inputs to false
        upPressed = downPressed = playerBusy = upPressed2 = downPressed2 = playerBusy2 = false;
        
        // Reset game and do a countdown before starting again
        reset(); // Move everything to reset position
        countDownLabel.setVisible(true);
        countDownLabel.setText("3");
        countDownTimer.start();
    }

    
    private int getLaunchDegree(){
        int side = (int)(Math.random() * ((2-1) + 1)) + 1; // Choose what side to throw to
        int minStartingDegree = 200;
        int maxStartingDegree = 340;
        
        // Choose a random delta on that side
        if(side == 1){
            minStartingDegree = 200;
            maxStartingDegree = 340;
        }else{
            minStartingDegree = 20;
            maxStartingDegree = 160;
        }
        
        return (int)(Math.random() * ((maxStartingDegree-minStartingDegree) + 1)) + minStartingDegree; // Chooses a delta between 240 and 300
        
        
    }
    
    
    
    private void boostBall(){
        boostedBallMovesX.clear();
        boostedBallMovesY.clear();
        for(int i = 0; i < ballMovesX_list.size(); i++){
            boostedBallMovesX.add(ballMovesX_list.get(i) * boostedBallMultiply);
            boostedBallMovesY.add(ballMovesY_list.get(i) * boostedBallMultiply);
        }
        
        // Repainting ball
        switch(boostedBallMultiply){
            case 2: ball.setBackground(new Color(255,150,50)); break;
            case 3: ball.setBackground(new Color(255,50,50)); break;
            case 4: ball.setBackground(new Color(255,0,0)); break;
        }
    }
    
    
    public void updateScores(HighscoreManager s, String c){
        scores_fromOutside = s;
        currentUser_fromOutside = c;
    }
}

























