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
    
    // Player Variables
    JPanel currentTagger = null; 
    boolean player1Frozen = false;
    boolean player2Frozen = false;
    

    
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
        
        // Reseting variables
        boost1.setVisible(true); // Showing the boost
        boost2.setVisible(true); // Showing the boost
        player1Frozen = player2Frozen = false; // Resetting the frozen players
    }
    
    
    // Stops all timers of the game 
    public void stopGame(){
        
    }
    
    
    
    // TIMERS:
    
    
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

    
    
    
}
