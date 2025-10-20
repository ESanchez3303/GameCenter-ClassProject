package classproject;
import javax.swing.*;
import java.awt.Color;

public class CastleDefense {
    // MAIN GAME VARIABLES:
    int STARTING_CASH = 400;
    int CASTLE_HEALTH = 10000;
    
    // PRICES
    int TOWER1_COST = 200;
    int TOWER1_CAT1_COST = 200;
    int TOWER1_CAT2_COST = 400;
    int TOWER1_CAT3_COST = 600;
    
    int TOWER2_COST = 400;
    int TOWER2_CAT1_COST = 400;
    int TOWER2_CAT2_COST = 800;
    int TOWER2_CAT3_COST = 100;
    
    int TOWER3_COST = 1000;
    int TOWER3_CAT1_COST = 1000;
    int TOWER3_CAT2_COST = 1000;
    int TOWER3_CAT3_COST = 1000;
    
    int TOWER4_COST = 20000; 
    int TOWER4_CAT1_COST = 10000;
    int TOWER4_CAT2_COST = 10000;
    int TOWER4_CAT3_COST = 10000;
    
    String[] allDescriptions = {"tower1", "tower2", "tower3", "tower4"};
    
    Color buttonColor = new Color(202,157,123);
    Color redColor    = new Color(255,51,0);
    
    
    // Holding Variables:
    JLabel[] allPlacements;
    int[] allTowerTypes;
    int[] cat1;
    int[] cat2;
    int[] cat3;
    JButton buyTower1Button;
    JButton buyTower2Button;
    JButton buyTower3Button;
    JButton buyTower4Button;
    JPanel menu;
    JButton menuButton;
    JLabel tower1;
    JLabel tower2;
    JLabel tower3;
    JLabel tower4;
    JLabel cashText;
    JProgressBar castleHealth;
    JPanel upgradeMenu;
    JButton cat1Button;
    JButton cat2Button;
    JButton cat3Button;
    JProgressBar cat1Progress;
    JProgressBar cat2Progress;
    JProgressBar cat3Progress;
    JLabel upgradeTower;
    JLabel upgradeDescription;
    
    
    // Dynamic Variables:
    int cash;
    boolean selectionMode = false;
    JButton flashingButton;
    int flashingCounter;
    JButton savedButton;
    int savedIndex;
    
    // Construction Function:
    public void setUp(JLabel[] aP, JButton bt1, JButton bt2, JButton bt3, JButton bt4, 
                      JPanel m, JButton mb, JLabel t1, JLabel t2, JLabel t3, JLabel t4,
                      JLabel cT, JProgressBar ch, JPanel um, JButton c1, JButton c2, JButton c3,
                      JProgressBar c1p, JProgressBar c2p, JProgressBar c3p, JLabel ut, JLabel ud){
        allPlacements = aP;
        
        cat1 = new int[allPlacements.length];
        cat2 = new int[allPlacements.length];
        cat3 = new int[allPlacements.length];
        allTowerTypes = new int[allPlacements.length];
        for(int i = 0; i < allPlacements.length; i++)
            cat1[i] = cat2[i] = cat3[i] = allTowerTypes[i] = 0;
        buyTower1Button = bt1;
        buyTower2Button = bt2;
        buyTower3Button = bt3;
        buyTower4Button = bt4;
        buyTower1Button.setText(buyTower1Button.getText() + " $" + TOWER1_COST);
        buyTower2Button.setText(buyTower2Button.getText() + " $" + TOWER2_COST);
        buyTower3Button.setText(buyTower3Button.getText() + " $" + TOWER3_COST);
        buyTower4Button.setText(buyTower4Button.getText() + " $" + TOWER4_COST);
        menu = m;
        menuButton = mb;
        tower1 = t1;
        tower2 = t2;
        tower3 = t3;
        tower4 = t4;
        cashText = cT;
        castleHealth = ch;
        upgradeMenu = um;
        cat1Button = c1;
        cat2Button = c2;
        cat3Button = c3;
        cat1Progress = c1p;
        cat2Progress = c2p;
        cat3Progress = c3p;
        upgradeTower = ut;
        upgradeDescription = ud;
    }
    
    


    // Get Functions
    public JLabel[] getAllPlacements() { return allPlacements; }
    public boolean getSelectionMode() { return selectionMode; }
    
    
    
    
    // Public Functions:
    public void resetGame(){
        // Reseting the visuals of the placements, the icons and borders
        for(JLabel placement : allPlacements){
            placement.setIcon(null);
            placement.setBorder(null);
        }
        
        // Reseting Variables
        cash = STARTING_CASH; 
        buyTower1Button.setBackground(buttonColor);
        buyTower2Button.setBackground(buttonColor);
        buyTower3Button.setBackground(buttonColor);
        buyTower4Button.setBackground(buttonColor);
        menu.setLocation(0,535); 
        selectionMode = false;
        menuButton.setText("Open Menu");
        cashText.setText(Integer.toString(cash));
        castleHealth.setMaximum(CASTLE_HEALTH);
        castleHealth.setValue(CASTLE_HEALTH);
        upgradeMenu.setVisible(false);
        cat1Progress.setMaximum(99);
        cat2Progress.setMaximum(99);
        cat3Progress.setMaximum(99);
    }
    
    
    
    
    public void menuButtonClicked(){
        // If we are currently in selection mode, then this click means cancel instead
        if(selectionMode){
            selectionMode = false;            // Canceling the selection mode
            menuButton.setText("Close Menu"); // Resetting the menu button 
            menu.setLocation(0,40);           // Moving menu back to open
            highlightPlacement(null);         // Unhighlighting every placement in case it gets stuck
            return;                           // Getting out so user can go back into menu as needed
        }
        
        if(menuButton.getText().equals("Close Upgrades")){
            upgradeMenu.setVisible(false);
            menuButton.setText("Open Menu");
            menu.setLocation(0,535);
            return;
        }
        
        // If the menu is currently CLOSED, we are OPENING it now
        if(menuButton.getText().equals("Open Menu")){
            upgradeMenu.setVisible(false);       // Hhiding the upgrade menu in case its open
            menuButton.setText("Close Menu");    // Change the button text
            menu.setLocation(0, 40);
        }
        
        
        // If the menu is currently OPENED, we are now CLOSING
        else{
            menuButton.setText("Open Menu");     // Change the button text
            menu.setLocation(0,535);
        }
    }
    
    
    
    
    public void buyTowerButtonClicked(int clickedTower, JButton clickedButton){
        // Setting the amount that this tower would cost to buy and saving the clicked button
        int cost = 0;
        switch(clickedTower){
            case 1 -> { cost = TOWER1_COST; }
            case 2 -> { cost = TOWER2_COST; }
            case 3 -> { cost = TOWER3_COST; }
            case 4 -> { cost = TOWER4_COST; }
        }
        
        // If the user has enough money to buy this tower
        if(cash >= cost){
            selectionMode = true;             // Turning on the selection mode
            savedButton = clickedButton;      // Saving this button so we know what tower was bought
            menuButton.setText("Cancel Buy"); // Changing this button to be a cancel button
            menu.setLocation(0,535);          // Hiding the menu from the user
        }
        // The user does NOT have enough money to buy this tower, flash the button with red
        else{
            flashButton(clickedButton);       // FLashing the button to let user know they can't buy this
        }
    }
    
    
    
    
    public void placementClicked(JLabel placementClicked){
        // Check if we are in selection mode && the border is showing selected
        // --> Then user wants to place a tower here
        if(selectionMode && placementClicked.getBorder() != null){
            buyTowerOfficially(savedButton, placementClicked);
            return;
        }        

        // Check if the placement already has an icon, if so, user is trying to open upgrade menu
        // NOTE: also make sure that we are NOT in selection mode
        // SHOW UPGRADE MENU!!!!
        if(placementClicked.getIcon() != null && !selectionMode){
            // Update the MENU BUTTON and hide the MENU
            menuButton.setText("Close Upgrades"); // Change button to be a close button
            menu.setLocation(0,535);              // Hide in case its not
            
            
            // Update the UPGRADE MENU
            savedIndex = getPlacementIndex(placementClicked);
            upgradeTower.setIcon(placementClicked.getIcon());        // Updating the chosen tower
            upgradeDescription.setText(allDescriptions[allTowerTypes[savedIndex]-1]); // Update the description
            cat1Progress.setValue(cat1[savedIndex] * 33);            // Updating cat 1 
            cat2Progress.setValue(cat2[savedIndex] * 33);            // Updating cat 2 
            cat3Progress.setValue(cat3[savedIndex] * 33);            // Updating cat 3 
            
            // Show the UPGRADE MENU
            upgradeMenu.setVisible(true);         // Show the upgrade menu
        }
    }
    
    
    public void highlightPlacement(JLabel targetPlacement){
        // Give the target the border and set the other borders to NULL
        // (do not highlight the labels that already have a tower)
        for(JLabel placement : allPlacements){
            if(placement == targetPlacement && placement.getIcon() == null)
                placement.setBorder(BorderFactory.createSoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
            else
                placement.setBorder(null);
        }
    }
    
    
    public void catButtonClicked(JButton catButtonClicked){
        // Check which category was clicked and for which index (should already be in saved index)
        
    }
    
    
    
    // GAME CLOCK ===========================
    public void stopGame(){
        
    }
    
    
    
    // Private Functions:
    private int getPlacementIndex(JLabel targetLabel){
        int count = 0;
        for(JLabel placement : allPlacements){
            if(placement == targetLabel)
                break;
            count++;
        }
        return count;
    }
    
    
    private void buyTowerOfficially(JButton buttonOfTower, JLabel placementClicked){
        int cost = 0;
        JLabel towerBought = null;
        int towerType = 0;
        if(buttonOfTower == buyTower1Button){
            towerBought = tower1;
            cost = TOWER1_COST;
            towerType = 1;
        }
        else if(buttonOfTower == buyTower2Button){
            towerBought = tower2;
            cost = TOWER2_COST;
            towerType = 2;
        }
        else if(buttonOfTower == buyTower3Button){
            towerBought = tower3;
            cost = TOWER3_COST;
            towerType = 3;
        }
        else if(buttonOfTower == buyTower4Button){
            towerBought = tower4;
            cost = TOWER4_COST;
            towerType = 4;
        }
        
        // JUSTTT IN CASE: we will cancel the transaction if something happened weird
        if(cost == 0 || towerBought == null)
            return;
        
        // Saving the purchase into the allTowerTypes ====== IMPORTANT for later knowing where the towers are
        int indexOfPlacement = 0;
        for(JLabel placement : allPlacements){
            if(placement == placementClicked)
                break;
            indexOfPlacement++;
        }
        allTowerTypes[indexOfPlacement] = towerType; // Setting the tower type into this index
        
        
        // Applying the purchase and building the tower! (also leaving the selectionMode)
        cash -= cost;
        placementClicked.setIcon(towerBought.getIcon());
        placementClicked.setBorder(null);
        selectionMode = false;
        
        // Closing the menu
        menuButton.setText("Open Menu");
        menu.setLocation(0,535); 
        
        // Updating the cash on the bottom right
        cashText.setText(Integer.toString(cash));
    }
    
    
    private void flashButton(JButton targetButton){
        flashingButton = targetButton;  // Saving the target button so lambda can use it 
        flashingCounter = 0;            // Resetting the counter to 0
        flashingButton.setBackground(redColor); // First flash to feel instant
        Timer tempTimer = new Timer(100, e->{
            flashingCounter++;                               // Increasing count
            if(flashingCounter >= 6){                        // If >6, then stop and set back to normal
                ((Timer)e.getSource()).stop();
                flashingButton.setBackground(buttonColor);
            }
            else{                                            // If not, then continue bouncing
                if(flashingCounter % 2 != 0)
                    flashingButton.setBackground(buttonColor);
                else
                    flashingButton.setBackground(redColor);
            }
        });
        tempTimer.start();
    }
    
}
