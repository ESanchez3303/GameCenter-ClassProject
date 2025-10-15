package classproject;
import javax.swing.*;


public class Tag {
    // Holding Variables:
    JPanel player1;
    JPanel player2;
    JLabel boost1;
    JLabel boost2;
    JLabel player1Flag;
    JLabel player2Flag;
    JPanel[] floors;
    
    
    // Main Variables:
    int GAME_TICK = 2; // General Game Tick
    
    // Player Variables
    JPanel currentTagger = null;    // This is the current tagger
    boolean player1Frozen = false;  // Player is frozen after tagged
    boolean player2Frozen = false;  // Player is frozen after tagged
    boolean p1PressingLeft = false;  // Player 1 is pressing left
    boolean p1PressingRight = false; // PLayer 1 is pressing right
    boolean p1OnFloor = false;       // Player 1 is currently on the ground
    boolean p2PressingLeft = false;  // Player 2 is pressing left
    boolean p2PressingRight = false; // Player 2 is pressing right 
    boolean p2OnFloor = false;       // Player 2 is currenly on the ground
    
    

    
    // Constructor Function:
    public void setUp(JPanel p1, JPanel p2, JLabel b1, JLabel b2, JPanel[] f,
                      JLabel p1F, JLabel p2F){
        player1 = p1;
        player2 = p2;
        boost1 = b1;
        boost2 = b2;
        floors = f;
        player1Flag = p1F;
        player2Flag = p2F;
    }
    
    
    // Public Functions:
    // Main starting function to reset the game and set up variables
    public void start(int startingPlayer){
        // Setting the starting tagger and changing 
        if(startingPlayer == 1)
            currentTagger = player2; // Setting to 2, so that changeCurrentRunner can change it to 1
        else
            currentTagger = player1;
        changeCurrentRunner();       // Correcting to the correct startig player -> needed to set up other variables
        
        // Resetting other variables
        player1Frozen = player2Frozen = false; // Resetting the frozen players
    }
    
    
    // Stops all timers of the game 
    public void stopGame(){
        clock.stop();
    }
    
    
    
    // TIMERS:
    Timer clock = new Timer(GAME_TICK, e->{
        
    });
    
    
    
    
    // Private Functions
    private void changeCurrentRunner(){
        if(currentTagger == player1){      // If player 1 is tagger, change to player 2
            player2Flag.setVisible(true);  // Showing indicator that player 2 is new tagger
            player1Flag.setVisible(false); // Showing indicator that player 1 is new runner
            currentTagger = player2;       // Saving this info
            player2Frozen = true;          // Setting the flag to freeze player 2 since they are new tagger
        }
        else{ // If player 2 is tagger, change to player 2
            player1Flag.setVisible(true);
            player2Flag.setVisible(false);
            currentTagger = player1;
            player1Frozen = true;
        }
    }
    
    // Player inputs - pressing and releasing of left and right and up buttons
    private void player1LeftPressed(){ if(!p1PressingRight) p1PressingLeft  = true; }
    private void player1RightPressed(){ if(!p1PressingLeft) p1PressingRight = true; }
    private void player2LeftPressed(){ if(!p2PressingRight) p2PressingLeft  = true; }
    private void player2RightPressed(){ if(!p2PressingLeft) p2PressingRight = true; }
    private void player1LeftReleased()  { p1PressingLeft  = false; }
    private void player1RightReleased() { p1PressingRight = false; }
    private void player2LeftReleased()  { p2PressingLeft  = false; }
    private void player2RightReleased() { p2PressingRight = false; }
    
    private void player1UpPressed(){ 
        if(!p1OnFloor){
            // Give this player a plus on vector in Y
        }
    }
    private void player2UpPressed(){ 
        if(!p2OnFloor){ 
            // Give this player a plus on vector in Y
        }
    } 
    

    
    
    
}
