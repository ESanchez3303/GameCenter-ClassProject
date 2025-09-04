/**
 *
 * @author Emanuel
 */
package classproject;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
       



public class PingPong {
    // SET AND FORGET CUSTOM VARIABLES:
    int PLAYER_STEP = 5;
    int BALL_STEP = 5;
    List<Integer> deltaEdges = new ArrayList<>(Arrays.asList(18,36,54,72,90,108,126,144,162,180,198,216,234,252,270,288,306,324,342,360));
    List<Integer> ballMovesX_list = new ArrayList<>(Arrays.asList(0,1,2,3,4,4,3,2,1,0,0,-1,-2,-3,-4,-4,-3,-2,-1,0));
    List<Integer> ballMovesY_list = new ArrayList<>(Arrays.asList(-4,-3,-2,-1,0,0,1,2,3,4,4,3,2,1,0,0,-1,-2,-3,-4));
    
    // SET UP FUNCTION (CONSTRUCTOR):
    public void setUp(JPanel p, JPanel c, JPanel b, int tR){
        // Setting up variables:
        player = p;
        computer = c;
        ball = b;
        tick = tR;  
    }
    
    
    
    // Variables:
    Timer clock;     // Clock that keeps everything in sync
    JPanel player;   // Panel that is the player
    JPanel computer; // Panel that is the computer
    JPanel ball;     // Panel that is the ball
    int tick;        // Tick that the game speed wil be set at (milliseconds)
    int beta;        // The extra that is added when a player and ball are going the same direction
    int delta;       // The current angle of the ball (0-360)
    
    // Movement Variables:
    boolean upPressed = false;
    boolean downPressed = false;
    boolean playerBusy = false;
    int ballMoveX;
    int ballMoveY;
    
    
    
    // PUBLIC FUNCTIONS: 
    public void reset(){
        player.setLocation(50,225);
        computer.setLocation(660,225);
        ball.setLocation(350,240);
    }
    
    public void stopGame(){
        if(clock != null) 
            clock.stop();
    }
    
    public void startGame(){
        reset();                                              // Just in case, move everything again
        int minStartingDegree = 200;
        int maxStartingDegree = 340;
        delta = (int)(Math.random() * ((maxStartingDegree-minStartingDegree) + 1)) + minStartingDegree; // Chooses a delta between 240 and 300
        System.out.println("Starting delta: " + Integer.toString(delta));
        startTimer();                                         // Starts the clock
    }
    
    
    
    public void upPressed(){if(!playerBusy){upPressed = true; playerBusy = true;}}  
    public void downPressed(){if(!playerBusy){downPressed = true; playerBusy = true;}}
    public void upReleased(){upPressed = false; playerBusy = false;}
    public void downReleased(){downPressed = false; playerBusy = false;}
    
    
    // CLOCK TICK;
    private void startTimer(){
        clock = new Timer(tick,e->{
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
            
            
            // Move Computer (revalidate) --------------------------------------------------------------------------------------------------------------------
            
            // Move Ball (while validating): -----------------------------------------------------------------------------------------------------------------
            // Logic: split quad into 5 pieces (leaving 360 be 0 at that instance)
            //  UP-RIGHT (quad 4) example:
            //    o if in 270-287 ----> 4 left
            //    o if in 288-205 ----> 3 left, 1 up
            //    o if in 306-323 ----> 2 left, 2 up
            //    o if in 324-359 ----> 4 up
            
            getBallMoveUsingDelta();
            if(ballMoveX == -9 || ballMoveY == -9){   // Check if the delta was in bounds
                System.out.println("GAME 3 CRASHED"); // This could be handled better using a joptionpane
                stopGame();
                return;
            }
            
            // Check if ball will put ball out of bounds, then move ball
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
            
            
            
             
            // Check if ball touched a wall, change the delta to "reflect" off it 
            //if(newBallLocationY == 0)  // If ball touched top wall
                
            //if(newBallLocationY == 480)// If ball touched the bottom wall
                
            // Check if ball touched player/computer
            // Check if ball touched goal
        });
        clock.start();
    }
            
    
    
    
    // HELPER FUNCTIONS:
    private void getBallMoveUsingDelta(){
        if(delta < 0){
            ballMoveX = -9;
            ballMoveY = -9;
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
            System.out.println("here");
            ballMoveX = -9;
            ballMoveY = -9;
            return;
        }
        
        
        // Setting the ball moves accordingly
        ballMoveX = ballMovesX_list.get(insideOfEdge);
        ballMoveY = ballMovesY_list.get(insideOfEdge);
    }
    
    
    
    
}

























