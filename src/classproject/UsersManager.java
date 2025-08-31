// @author Emanuel
package classproject;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

// ________________________________________________________________________________________________________________________________________________
// ********************************************************* SINGLE USER OBJECT *******************************************************************
class User{
    // Constructors:
    User(){}
    User(String newUser, String newPassword){
        username = newUser; password = newPassword;
    }
    
    // Variables
    private String username;
    private String password;
   
    // Get Functions
    public String getUsername(){return username;}
    public String getPassword(){return password;}   
    
    // Set Functions
    public void setName(String newUser){username = newUser;}
    public void setPassword(String newPass){password = newPass;}
}









// ___________________________________________________________________________________________________________________________________________________________________
// ****************************************************** USER MANAGER CLASS TO ORGANIZE AND HOLD USERS **************************************************************

public class UsersManager {
    // Constructor =====================================================================================================================================================
    UsersManager(){
        Users = new ArrayList<>(); // Make users list object
        loadFromFile();            // Read and load users into list
    }
    
    // Variables =======================================================================================================================================================
    private List<User> Users;
    
    
    
    // Set Functions ===================================================================================================================================================
    public boolean addUser(String newUser, String newPass){                      // Adds the user AFTER checking one more time if the name is valid
        if(!validUsername(newUser))
            return false;   // Returns false if the person could not be added
        
        
        // Adding the user to the LIST
        User temp = new User(newUser, newPass);                                  // Not encrypting saved password since it wont be accessed from anywhere
        Users.add(temp);
        
        // Saving the to the file
        saveToFile();
        
       
        return true;        // Returns true if the person was added
    }
    
    public void setUsername(String target, String newUsername){
        for(User person: Users){
            if(person.getUsername().equals(target)){
                person.setName(newUsername);
                saveToFile();
                return;
            }
        }
    }
    
    public void setPassword(String target, String newPassword){
        for(User person: Users){
            if(person.getUsername().equals(target)){
                person.setPassword(newPassword);
                saveToFile();
                return;
            }
        }
    }
    
    // Get Functions ===================================================================================================================================================
    
    /// As of now, i dont really need to get a user because it just holds the usernanme and password and we know that infomation when the person inputs it into login.
    
    
    
    
    // Helper Functions ================================================================================================================================================
    public boolean validUsername(String newUser){                                // Checks if a username is valid before adding a user
        for(User person : Users){
            if(person.getUsername().equalsIgnoreCase(newUser)){                  // If username is found already, return false
                return false;
            }
        }
        return true;                                                             // If username was not found in users, return true (valid username)
    }
    
    
    
    
    public boolean checkCredentials(String targetUser, String targetPass){       // Checks if the credentials sent are valid
        for(User person : Users){
            if(person.getUsername().equalsIgnoreCase(targetUser)){               // If username is found
                if(person.getPassword().equals(targetPass))                      // If password matches, return true
                    return true;
                else                                                             // If password does not match, but user did, return false
                    return false;
            }
        }
        return false;                                                            // If username was not found, return false
    }
    // =================================================================================================================================================================
    
    
    
    // Not Password Things =============================================================================================================================================
    private static int shift = 4;
    private String encrypt(String targetInput){
        StringBuilder coded_string = new StringBuilder();
        for(char curr : targetInput.toCharArray()){
            if(Character.isLowerCase(curr)) 
                coded_string.append((char) ( 'a' + ( ((curr - 'a') + shift + 26) % 26 ) )); 
            else if(Character.isUpperCase(curr))
                coded_string.append((char) ( 'A' + ( ((curr - 'A') + shift + 26) % 26 ) ));
            else 
                coded_string.append(curr);
        }
        return coded_string.toString();
    }
    // =================================================================================================================================================================
    
    
    // File Functions =============================================================================================================================================
    
    
    private void loadFromFile(){
        shift = -shift;            // Flipping the shift while reading to decode passwords
        try {
            Users = new ArrayList<>(); // Forgetting the previous refrence, GC will take care of it 
            File inputFile = new File("users.txt"); 

            if (!inputFile.exists()) { // If the file does not exist, make and leave
                inputFile.createNewFile();
                return;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                String currLine;
                while ((currLine = br.readLine()) != null) {
                    String[] parts = currLine.split(",", 2);
                    if (parts.length == 2) {
                        String username = parts[0];              // Reads username
                        String password = encrypt(parts[1]);     // Reads and decodes password
                        Users.add(new User(username, password)); // Adds to list
                    }
                }
            }
            
            
        } catch (IOException e) {
            System.out.println("Error: Error when loading users file.");
            e.printStackTrace();
            
        }
        shift = -shift; // Flipping back the shift after to move back to encrypt 
    }

    
    private void saveToFile(){ 
        try {
            if (Users == null) return; // If users list was not init, then return (shouldn't ever happen since we init)

            File file = new File("users.txt");
            
            if (!file.exists()) 
                file.createNewFile(); // Just in case it got deleted while the program was running

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                for (User u : Users) {
                    String encodedPassword = encrypt(u.getPassword()); // Encodes password
                    bw.write(u.getUsername() + "," + encodedPassword); // Writes username,password
                    bw.newLine();
                }
            }
            
            
            
        } catch (IOException e) {
            System.out.println("Error: Error when saving users file.");
            e.printStackTrace();
        }
    }
    
    
    // =================================================================================================================================================================
    
}



































