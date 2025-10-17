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
import javax.swing.JProgressBar;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

        
public class MatchingGame {
    
    // Main Game Variables:
    private final int matchScoreIncrease = 200;
    private final int timeLeftScoreIncrease = 100;
    private final int previewTime = 500;
    private final int GAME_TIME = 60;
    
    // Holding Variables:
    private List<JLabel> values;
    private List<JLabel> images;
    private JLabel scoreBoard;
    private JProgressBar timerBar;
    private JPanel disableCover;
    private int timePassed = 0;
    private JButton startButton;
    private JLabel score;
    private HighscoreManager scores_fromOutside;
    private String currentUser_fromOutside;
    Timer gameTimer;
   
    // Constructor Function:
    public void setUp(List<JLabel> newValues, List<JLabel> newImages, JLabel sb, JProgressBar tb,
                      JPanel dc, JButton b, JLabel s){
        values = newValues; // Adding the values to the values list
        images = newImages; // Adding the images to the images list
        scoreBoard = sb;    // Setting the scoreboard
        timerBar = tb;      // Setting the timer bar
        disableCover = dc;
        score = s;
        shuffle();          // Shuffles and resets the cards
    }
    
    
    // Get Functions:
    public int getMatchScoreIncrease(){return matchScoreIncrease;}
    public int getTimeLeftScoreIncrease(){return timeLeftScoreIncrease;}
    public boolean isBusy() {return busy;}
    public List<JLabel> getImages() {return images;}
    public int getRemainingTime() { return GAME_TIME - timePassed;}
    
    
    // Public Functions:
    public void stopGame(){
        gameTimer.stop();
    }
    public void start(){
        timePassed = 0;                      // Resettinig the timePassed to 0 so that it can start at this amount
        timerBar.setMaximum(GAME_TIME);  // Setting the max to that amount so each tick is that much
        timerBar.setValue(0);             // Setting the bar to 0, as time goes, it will grow
        
        gameTimer = new Timer(1000,e->{  // Function for each tick of the timer (every 1 second)
           timePassed++;                       // Up the amount by 1
           timerBar.setValue(timePassed);      // Set the bar to this amount
           
           if(timePassed >= GAME_TIME){        // When the timer reaches Full Time:
               ((Timer)e.getSource()).stop();  // Stop the timer
               disableCover.setVisible(true);  // Disable the game using the cover
               timerBar.setVisible(false);     // Hide the timer bar 
               startButton.setVisible(true);   // Show the start button which now says "play again!"
               
               gameFinishedMessage("Times Up!", score.getText(), "0"); // Calls function to show the end of the game message
           }
        });
        
        gameTimer.start();                   // Start the timer 
    } 
    
    public void gameFinishedMessage(String gMessage, String matchingPoints, String timePoints){
        int maxMatchingScore = matchScoreIncrease * 9;
        int maxTimeScore = GAME_TIME * timeLeftScoreIncrease;
        
        String message = gMessage;                                               // The top section of message is added
        message +=  "\nMatching Points: "     + matchingPoints;                  // Matching points that were made
        message += "/" + Integer.toString(maxMatchingScore);                     // Showing the max possible matching points
        message +=  "\nTime Points:         " + timePoints;                      // Time Points given
        message += "/" + Integer.toString(maxTimeScore);                         // SHowing the max possible time points
        message += "\n--------------------------------------------------------"; // Line for Visual
        message += "\nTotal Points:         " + score.getText();              // Total Points given
        message += "/" + Integer.toString(maxMatchingScore + maxTimeScore);   // Total points possible (time+matching)
        if(scores_fromOutside.reportScore("MG", currentUser_fromOutside, score.getText()))            // If this user made a new high score
            message = message + "\nYOU SET THE NEW HIGH SCORE!";
        
         // Show all data to users
        JOptionPane.showMessageDialog(null, message);        
    }
    
    public void updateScore(HighscoreManager inputScores, String inputUser){
        scores_fromOutside = inputScores;
        currentUser_fromOutside = inputUser;
    }
    
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
    
    public void addTimeScore(){
        int timeLeft = GAME_TIME - timePassed;
        int currentScore = Integer.parseInt(scoreBoard.getText());
        currentScore += timeLeft * timeLeftScoreIncrease;
        scoreBoard.setText(Integer.toString(currentScore));
    }
}
