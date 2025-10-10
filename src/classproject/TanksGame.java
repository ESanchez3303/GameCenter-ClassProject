package classproject;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class TanksGame {
    // Variables Holders:
    char heart = '♥';
    String fullHealth = "♥   ♥   ♥";
    JPanel mapItem1;
    JPanel mapItem2;
    JPanel mapItem3;
    JLabel player1;
    JLabel player2;
    JLabel player1Lifes;
    JLabel player2Lifes;
    JProgressBar gasBar;
    JLabel ball;
    
    
    // Game Variables:
    int currentPlayer = 1;
    
    
    // Private Functions
    
    // Publics Functions
    public void setUp(JPanel mi1, JPanel mi2, JPanel mi3,
                      JLabel p1, JLabel p2, JLabel p1L, JLabel p2L,
                      JProgressBar g, JLabel b){
        
        // Set up variables with this function instead of a constructor
        mapItem1 = mi1; 
        mapItem2 = mi2; 
        mapItem3 = mi3;
        player1 = p1;
        player2 = p2;
        player1Lifes = p1L;
        player2Lifes = p2L;
        gasBar = g;
        ball = b;
    }
    
    public void drawMap(int chosenMap){
        // Resetting the drawing to be zero 
        mapItem1.setVisible(false);
        mapItem2.setVisible(false);
        mapItem3.setVisible(false);
       
        // Drawing the map using the given blocks (limited to 3 for this program)
        switch ( chosenMap ){
            case 1 -> {
                mapItem1.setLocation(337,215);           // Moving the block
                mapItem1.setSize(80,250);                // Resizing the block
                mapItem1.setVisible(true);               // Making visible this block
            }
            case 2 -> {
                mapItem1.setLocation(337,385);    
                mapItem1.setSize(80,80);
                mapItem1.setVisible(true);  
                
                mapItem2.setLocation(30,320);    
                mapItem2.setSize(150,40);
                mapItem2.setVisible(true);  
                
                mapItem3.setLocation(585,320);    
                mapItem3.setSize(150,40);
                mapItem3.setVisible(true);  
            }
            case 3 -> {
                mapItem1.setLocation(30,2);    
                mapItem1.setSize(700,150);
                mapItem1.setVisible(true);  
                
                mapItem2.setLocation(2,200);    
                mapItem2.setSize(200,40);
                mapItem2.setVisible(true);  
                
                mapItem3.setLocation(563,200);    
                mapItem3.setSize(200,40);
                mapItem3.setVisible(true);  
            }
        }
        
        // Resetting other visuals
        player1.setLocation(20,402);       // Moving player 1 to start
        player2.setLocation(655,402);      // Moving player 2 to start
        currentPlayer = 1;                 // Giving player 1 move
        player1Lifes.setText(fullHealth);  // Resetting the lives
        player2Lifes.setText(fullHealth);  // Resetting the lives
        gasBar.setValue(100);              // Resetting the gas
        ball.setVisible(false);            // Hidding the ball
       
        
        // Setting up the walls and boundaries of the map - seperated for easy-to-read code
        // NOTE-TO-SELF: This could actually be mapped instead! try to before hard coding it
        switch ( chosenMap ){
            case 1 -> {
            }
            case 2 -> {
            }
            case 3 -> {
            }
        }
    }
}
