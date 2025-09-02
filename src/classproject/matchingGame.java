/**
 *
 * @author Emanuel
 */
package classproject;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.util.Collections;

        
public class MatchingGame {
    // CUSTOM VARIABLES
    private int matchScoreIncrease;
    private int timeLeftScoreIncrease;
    private int previewTime;
   
    // ONE TIME USE! Sets the List below! (LIKE A CONSTRUCTOR BUT A FUNCTION INSTEAD)
    public void setUp(List<JLabel> newValues, List<JLabel> newImages, JLabel sb, int matchSI, int timeLeftSI, int pT){
        values = newValues; // Adding the values to the values list
        images = newImages; // Adding the images to the images list
        scoreBoard = sb;    // Setting the scoreboard
        matchScoreIncrease = matchSI;
        timeLeftScoreIncrease = timeLeftSI;
        previewTime = pT;
        shuffle();          // Shuffles and resets the cards
    }
    
    // Lists
    private List<JLabel> values;
    private List<JLabel> images;
    private JLabel scoreBoard;
    
    // Shuffle Function 
    public void shuffle(){
        // Making a list of the symbols with 9 sets of symbols 
        List<String> symbols = new ArrayList<>(Arrays.asList("▲","■","♠","♦","♥","○","●","▼","⇨",
                                                             "▲","■","♠","♦","♥","○","●","▼","⇨"));
        Collections.shuffle(symbols); // Shuffles the list around
        
        
        // Now that its random, setting the values text to these symbol through iter, should stay random either way
        for (int i = 0; i < values.size(); i++) {
            values.get(i).setText(symbols.get(i));
            values.get(i).setVisible(false);   // Hide the symbols
            images.get(i).setVisible(true);    // Show the back sides
        }
        
        // Resetting the matches made to 0, once this hits 9, we know we are finished with the game
        matchesMade = 0;
    }
    
    
    // When calling selectCard, T: all matches have been found, F: There are still matches not made
    private int matchesMade = 0;
    private int selection1 = -1;
    private boolean busy = false;
    public boolean selectCard(int card){
        if(card < 0 || card >= values.size()) return false;  // Shouldn't ever be this case, but just in case
        if (busy) return false;                             // If busy, don't enter
        
        // This is the first card being selected if selection1 is -1
        if(selection1 == -1){
            selection1 = card; // Save this selection for comparing later
            images.get(card).setVisible(false); // Hide the card back
            values.get(card).setVisible(true);  // Show the value (star, etc)
            return false;
        }
        
        // If selection1 has value, then we now have selected two
        images.get(card).setVisible(false); // Hide the card back
        values.get(card).setVisible(true);  // Show the value (star, etc)
        
        // If values are NOT equal, then show cards for 1 second then hide them and leave
        if(!values.get(selection1).getText().equals(values.get(card).getText())){
            busy = true;                                                         // Setting to busy so user won't use this function
            new Timer(previewTime, e -> {                                               // Wait 1 second for tick, then do this:
                ((Timer)e.getSource()).stop();
                
                // Flipping back over the two cards
                values.get(card).setVisible(false);
                images.get(card).setVisible(true);
                
                values.get(selection1).setVisible(false);
                images.get(selection1).setVisible(true);
                selection1 = -1; // Resetting the trigger to know when we have not chosen first card
                busy = false;    // Resetting busy signal
            }).start();
        }
        else{ // If cards DO match, then leave values showing ( THIS WILL BE TRIGER FOR OUTSIDE TO KNOW WHEN FLIPPED )
            int currentScore = Integer.parseInt(scoreBoard.getText());
            currentScore += matchScoreIncrease;
            scoreBoard.setText(Integer.toString(currentScore)); // Increase the score to signal a match!
            selection1 = -1; // Resetting the trigger to know when we have not chosen first card
            matchesMade++;
            if(matchesMade >= 9)
                return true;
        }
        return false;
    }
    
    public void addTimeScore(int timeLeft){
        int currentScore = Integer.parseInt(scoreBoard.getText());
        currentScore += timeLeft * timeLeftScoreIncrease;
        scoreBoard.setText(Integer.toString(currentScore));
    }
    
    
    public boolean isBusy(){
        return busy;
    }
    
    public List<JLabel> getImages(){  // We need this to search through it 
        return images;
    }
}
