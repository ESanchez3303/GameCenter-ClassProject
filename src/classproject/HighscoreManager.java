/**
 *
 * @author Emanuel
 */
package classproject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class HighscoreManager {
    // LIST OF GAMES FOR EASY ADDING:
    private final List<String> gameSymbols = new ArrayList<>();
    private final List<String> usernames   = new ArrayList<>();
    private final List<String> highscores  = new ArrayList<>();
    
    // Cosntructor 
    HighscoreManager(){
        // THESE ARE THE GAMES THAT WE ARE KEEPING TRACK OF -- ADD GAMES HERE AS WE GO!
        gameSymbols.add("MG");
        gameSymbols.add("PP");
        gameSymbols.add("CD");
        
        for (String gameSymbol : gameSymbols) { // Just add this AMOUNT of usernames and highscores, we don't actually NEED "gameSymbol"
            usernames.add("Not Set");
            highscores.add("Not Set");
        }
        loadFromFile();
    }
    
    
    public String getUsername(String targetGame){
        int targetIndex = gameSymbols.indexOf(targetGame); // Getting the game position
        if(targetIndex >= 0){                              // If game exists
             return usernames.get(targetIndex);            // Return username of highscorer
        }
        else{                                             // If game was NOT FOUND, return error string and print message
            System.out.println("Could not get username because game symbol was not found");
            return "N/A";
        }
    }
    
    public String getHighscore(String targetGame){
        int targetIndex = gameSymbols.indexOf(targetGame); // Getting the game position
        if(targetIndex >= 0){                              // If game exists
             return highscores.get(targetIndex);           // Return highscore of highscorer
        }
        else{                                             // If game was NOT FOUND, return error string and print message
            System.out.println("Could not get highscores because game symbol was not found");
            return "N/A";
        }
    }
    
    
    // REPORT SCORE FUNCTION: || Returns T: new highscore was saved, F: no new highscore set
    public boolean reportScore(String targetGame, String newUser, String newScore){
        if(newScore.equals("0")) // NO! we are not counting 0 as a highscore duh
            return false;
        int targetIndex = gameSymbols.indexOf(targetGame);
        if(targetIndex >= 0){
            if(usernames.get(targetIndex).equals("Not Set")){ // Not score has been set yet -> this becomes the highscore
                usernames.set(targetIndex, newUser);
                highscores.set(targetIndex, newScore);
                saveToFile();
                return true;
            }
            else{                                               // Need to compare the scores first
                if(Integer.parseInt(newScore) > Integer.parseInt(highscores.get(targetIndex))){ // New highscore set!!
                    usernames.set(targetIndex, newUser);
                    highscores.set(targetIndex, newScore);
                    saveToFile();
                    return true;
                }
                else{                                                                            // :( no new highscore, return false
                    return false;
                }
            }
        }
        else{
            System.out.println("Error: Could not report score because game was not found.");
            return false;
        }
    }
    
    
    
    // File Functions: ================================================================================================
    private void loadFromFile(){
        try {
            File inputFile = new File("highscores.txt"); 

            if (!inputFile.exists()) { // If the file does not exist, make and leave
                inputFile.createNewFile();
                return;
            }

            try (BufferedReader input = new BufferedReader(new FileReader(inputFile))) {
                String currLine;
                while ((currLine = input.readLine()) != null) {
                    if(currLine.trim().isEmpty())
                        continue;
                    int targetIndex = gameSymbols.indexOf(currLine);
                    usernames.set(targetIndex, input.readLine());
                    highscores.set(targetIndex, input.readLine());
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error: Error when loading highscores file. (IO)");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: Error when loading highscores file. (GENERAL)");
            e.printStackTrace();
        }
    }
    
    private void saveToFile(){
         try {
            File file = new File("highscores.txt");
            
            if (!file.exists()) 
                file.createNewFile(); // Just in case it got deleted while the program was running

            try (BufferedWriter output = new BufferedWriter(new FileWriter(file))) {
                for(int i = 0; i < gameSymbols.size(); i++){
                    if(!usernames.get(i).equals("Not Set")){
                        output.write(gameSymbols.get(i)); output.newLine();
                        output.write(usernames.get(i)); output.newLine();
                        output.write(highscores.get(i)); output.newLine();
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error: Error when saving highscores file. (IO)");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: Error when loading highscores file. (GENERAL)");
            e.printStackTrace();
        }
    }
    
}















