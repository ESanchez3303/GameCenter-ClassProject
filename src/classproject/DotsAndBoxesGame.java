/**
 *
 * @author Emanuel
 */
package classproject;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

public class DotsAndBoxesGame {
    // Variables:
    private int turn = 1;
    private Color playerActiveColor = new Color(200,151,115);   // The color to switch top to when player is IN TURN
    private Color playerInactiveColor = new Color(153,135,108); // The color to switch top to when player is OUT OF TURN
    private Color player1Color = new Color(255,102,102);        // Color of player 1 lines and symbol
    private Color player2Color = new Color(102,102,255);        // Color of player 2 lines and symbol
    private Color inactiveLine = new Color(153,153,153);
    private String player1Icon;                                 // Holds the icon we use to present p1, triangle
    private String player2Icon;                                 // Holds the icon we use to present p2,  a square
    private JPanel player1Panel;                                // Holds the panel that we are going to be changing the color of
    private JPanel player2Panel;                                // Holds the panel that we are going to be changing the color of
    private List<JPanel> lines = new ArrayList<>();             // Holds the  lines
    private List<JPanel> outsideHorzLines = new ArrayList<>();  // Holds the outside horizontal lines
    private List<JPanel> outsideVertLines = new ArrayList<>();  // Holds the outside vertical lines
    private List<JLabel> boxes = new ArrayList<>();             // Holds the boxes that can be changed to p1/p2 icons
    private List<JLabel> claimedBoxes = new ArrayList<>();      // Holds boxes we that have already been claimed (aka don't check these)
    private List<JPanel> claimedLines = new ArrayList<>();      // Holds the lines that have already been checked
    
    // Mapping the lines to each box:
    List<JPanel> box1 = new ArrayList<>(); List<JPanel> box6  = new ArrayList<>(); List<JPanel> box11 = new ArrayList<>(); List<JPanel> box16 = new ArrayList<>();
    List<JPanel> box2 = new ArrayList<>(); List<JPanel> box7  = new ArrayList<>(); List<JPanel> box12 = new ArrayList<>(); List<JPanel> box17 = new ArrayList<>();
    List<JPanel> box3 = new ArrayList<>(); List<JPanel> box8  = new ArrayList<>(); List<JPanel> box13 = new ArrayList<>(); List<JPanel> box18 = new ArrayList<>();
    List<JPanel> box4 = new ArrayList<>(); List<JPanel> box9  = new ArrayList<>(); List<JPanel> box14 = new ArrayList<>(); 
    List<JPanel> box5 = new ArrayList<>(); List<JPanel> box10 = new ArrayList<>();List<JPanel> box15  = new ArrayList<>(); 
    
    List<List<JPanel>> boxMap = new ArrayList<>();
    
    
    
    // USE THIS FUNCTION AS A "CONSTRUCTOR" to keep gui code clean
    public void setUp(String p1, String p2, JPanel p1p, JPanel p2p, List<JPanel> l, List<JPanel> oH, List<JPanel> oV, List<JLabel> b){
        // Setting up the variables:
        player1Icon = p1; 
        player2Icon = p2;
        player1Panel = p1p;
        player2Panel = p2p;
        lines = l;
        outsideHorzLines = oH;
        outsideVertLines = oV;
        boxes = b;
        
        resetBoard(); // Resetting board after setting up
        
        // Mapping the lines to each box 
        box1.add(lines.get(0));  box1.add(lines.get(6));  box1.add(lines.get(7));  box1.add(lines.get(13));
        box2.add(lines.get(1));  box2.add(lines.get(7));  box2.add(lines.get(8));  box2.add(lines.get(14));
        box3.add(lines.get(2));  box3.add(lines.get(8));  box3.add(lines.get(9));  box3.add(lines.get(15));
        box4.add(lines.get(3));  box4.add(lines.get(9));  box4.add(lines.get(10)); box4.add(lines.get(16));
        box5.add(lines.get(4));  box5.add(lines.get(10)); box5.add(lines.get(11)); box5.add(lines.get(17));
        box6.add(lines.get(5));  box6.add(lines.get(11)); box6.add(lines.get(12)); box6.add(lines.get(18));
        
        box7.add(lines.get(13));  box7.add(lines.get(19));  box7.add(lines.get(20));  box7.add(lines.get(26));
        box8.add(lines.get(14));  box8.add(lines.get(20));  box8.add(lines.get(21));  box8.add(lines.get(27));
        box9.add(lines.get(15));  box9.add(lines.get(21));  box9.add(lines.get(22));  box9.add(lines.get(28));
        box10.add(lines.get(16)); box10.add(lines.get(22)); box10.add(lines.get(23)); box10.add(lines.get(29));
        box11.add(lines.get(17)); box11.add(lines.get(23)); box11.add(lines.get(24)); box11.add(lines.get(30));
        box12.add(lines.get(18)); box12.add(lines.get(24)); box12.add(lines.get(25)); box12.add(lines.get(31));
        
        box13.add(lines.get(26)); box13.add(lines.get(32)); box13.add(lines.get(33)); box13.add(lines.get(39));
        box14.add(lines.get(27)); box14.add(lines.get(33)); box14.add(lines.get(34)); box14.add(lines.get(40));
        box15.add(lines.get(28)); box15.add(lines.get(34)); box15.add(lines.get(35)); box15.add(lines.get(41));
        box16.add(lines.get(29)); box16.add(lines.get(35)); box16.add(lines.get(36)); box16.add(lines.get(42));
        box17.add(lines.get(30)); box17.add(lines.get(36)); box17.add(lines.get(37)); box17.add(lines.get(43));
        box18.add(lines.get(31)); box18.add(lines.get(37)); box18.add(lines.get(38)); box18.add(lines.get(44));
        
        // Set up the map list of list of panels (boxes) ik confusing, but we got this!
        boxMap.add(box1); boxMap.add(box2); boxMap.add(box3); boxMap.add(box4); boxMap.add(box5); boxMap.add(box6);
        boxMap.add(box7); boxMap.add(box8); boxMap.add(box9); boxMap.add(box10); boxMap.add(box11); boxMap.add(box12); 
        boxMap.add(box13); boxMap.add(box14); boxMap.add(box15); boxMap.add(box16); boxMap.add(box17); boxMap.add(box18);
    }
   
    
    public void resetBoard(){
        for(JPanel line : lines){      // Changing Color of all horizontal lines
            line.setBackground(inactiveLine);
            line.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        for(JLabel box : boxes)           // Hiding all boxes
            box.setVisible(false);
        
        claimedBoxes = new ArrayList<>(); // Resetting the boxes that have been claimed
        claimedLines = new ArrayList<>(); // Resetting the lines that have been claimed
        turn = 2;                         // Setting to 2 so increase can change to 1
        switchTurn();                     // Sets visual on top for players
    }
    
    private void switchTurn(){
        if(turn == 1) // If RIGHT NOW its player 1, make player 2 be in turn
            turn = 2; 
        else          // If RIGHT NOW its player 2, make player 1 be in turn
            turn = 1;
        
        // Changing the view of the top section to show whos turn it is
        if(turn == 1){ 
            player1Panel.setBackground(playerActiveColor);
            player2Panel.setBackground(playerInactiveColor);
        }else{
            player2Panel.setBackground(playerActiveColor);   
            player1Panel.setBackground(playerInactiveColor);
        }
    }
    
    
    
    
    
    private void claimBox(JLabel targetBox){
        targetBox.setText      (turn == 1 ? player1Icon  : player2Icon); // Setting the icon for the box
        targetBox.setForeground(turn == 1 ? player1Color : player2Color);// Setting the color for the icon 
        targetBox.setVisible(true);                                      // Making visible
        claimedBoxes.add(targetBox);                                     // Adding to disabled boxes
    }
    
    
    private boolean claimLine(JPanel targetLine){
        targetLine.setBackground(turn == 1 ? player1Color : player2Color); // Setting the line color
        targetLine.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));           // Setting the cursor to normal 
        claimedLines.add(targetLine);                                      // Adding to claimed lines
        
        
        boolean boxWasClaimed = false;                   // Returning variable 
        for(int i = 0; i < boxMap.size(); i++){          // Going through the mapping
            List<JPanel> boxLines = boxMap.get(i);       // Getting the map list => box1 = line1,line2,line3,line4
            JLabel boxLabel = boxes.get(i);              // Getting the corresponding box JLabel to see if box has already been claimed

            if(boxLines.contains(targetLine) && !claimedBoxes.contains(boxLabel)){ // If box is not claimed AND box contains this line in mapping
                boolean allLinesClaimed = true;         // Setting that this box is claimed
                for(JPanel line : boxLines){            // Going through the map list
                    if(!claimedLines.contains(line)){   // If a line IS NOT in the list
                        allLinesClaimed = false;        // --> Change the box is claimed to false and leave
                        break;
                    }
                }
                if(allLinesClaimed){                    // If all lines were already claimed
                    claimBox(boxLabel);                 // --> claim this box
                    boxWasClaimed = true;               // --> set returning variable (note that it there is no "=false" for the 2 boxes case)
                }
            }
        }

        return boxWasClaimed;                            // Return if a box was claimed
    }
    

    
    public boolean lineClicked(JPanel targetLine){     // Returns true if game has ended
        if(claimedLines.contains(targetLine))          // This line has already been chosen, ignore this click
            return false;
       
        boolean boxWasClaimed = claimLine(targetLine); // Claim the line visually and claim box if this move does so, save if claimed to NOT switch turns
        
        if(claimedBoxes.size() == boxes.size()) // If all boxes have been claimed, then the game is finished!
            return true;             
       
        // --- GAME IS NOT FINISHED ---
        if(!boxWasClaimed){  // If box was not claimed, switch the turn
            switchTurn();
        }
        
        return false; // Game has not yet ended
    }
    
    public int getWinner(){ // Gets 0 or 1 or 2 for the player won (0=draw), ONLY call when lineClicked return true 
        if(claimedBoxes.size() != boxes.size()){
            System.out.println("Error: getWinner() was called before game was finished!");
            return 0;
        }
        int player1Count = 0;
        int player2Count = 0;
        for(JLabel box : boxes){
            if(box.getText().equals(player1Icon))
                player1Count++;
            else
                player2Count++;
        }
        
        if(player1Count == player2Count)
            return 0;
        
        return (player1Count > player2Count ? 1 : 2);
    }
    
    public boolean gameOver(){
        return claimedBoxes.size() == boxes.size();
    }
    
    
}
