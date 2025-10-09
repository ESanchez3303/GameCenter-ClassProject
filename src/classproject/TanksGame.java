package classproject;
import javax.swing.JPanel;

public class TanksGame {
    // Variables
    JPanel mapItem1;
    JPanel mapItem2;
    JPanel mapItem3;
    
    
    // Private Functions
    
    // Publics Functions
    public void setUp(JPanel mi1, JPanel mi2, JPanel mi3){
        // Set up variables with this function instead of a constructor
        mapItem1 = mi1; mapItem2 = mi2; mapItem3 = mi3;
        
    }
    public void drawMap(int chosenMap){
        // Resetting the drawing to be zero 
        mapItem1.setVisible(false);
        mapItem2.setVisible(false);
        mapItem3.setVisible(false);
        
        // Drawing the map using the given blocks (limited to 3 for this program)
        switch ( chosenMap ){
            case 1 -> {
                mapItem1.setVisible(true);
                mapItem1.setLocation(357, 165);           // <-------- Figure out why this here does not work!!! AGHHhh
                mapItem1.revalidate(); 
                mapItem1.repaint();
                //mapItem1.setSize(50,300);
            }
            case 2 -> {
            }
            case 3 -> {
            }
        }
        
        // Setting up the walls and boundaries of the map - seperated for easy-to-read code
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
