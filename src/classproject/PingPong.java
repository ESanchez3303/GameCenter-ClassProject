/**
 *
 * @author Emanuel
 */
package classproject;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JPanel;



public class PingPong {
    // SET AND FORGET CUSTOM VARIABLES:
    int PLAYER_STEP = 5;
    int BALL_STEP = 5;
    
    
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
    boolean busy = false;
    
    
    
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
        delta = (int)(Math.random() * ((300-240) + 1)) + 240; // Chooses a delta between 240 and 300
        System.out.println("Starting delta: " + Integer.toString(delta));
        startTimer();                                         // Starts the clock
    }
    
    
    
    public void upPressed(){if(!busy){upPressed = true; busy = true;}}  
    public void downPressed(){if(!busy){downPressed = true; busy = true;}}
    public void upReleased(){upPressed = false; busy = false;}
    public void downReleased(){downPressed = false; busy = false;}
    
    
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
            
            int quad = getQuad();
                switch(quad){
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        System.out.println("wrong quad lol");                        
                        break;
                    case 4:
                        
                        break;
                    case 0:
                        System.out.println("GAME 3 CRASHED"); // ofc this could be handled better using a joptionpane if needed 
                        stopGame();
                        break;
                }
            
            
            
             
            // Check if ball touched a wall
            // Check if ball touched player/computer
            // Check if ball touched goal
        });
        clock.start();
    }
            
    
    
    
    // HELPER FUNCTIONS:
    private int getQuad(){
        if(delta >= 0 && delta <= 89)
            return 1;
        if(delta >= 90 && delta <= 179)
            return 2;
        if(delta >= 180 && delta <= 269) 
            return 3;
        if(delta >= 270 && delta <= 359)
            return 4;
        return 0; // If returned zero then something went wrong in calculating quad
    }
    
    
    
    
}

























