package classproject;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class Tower{
    private final JLabel placement;
    private int towerType = 0;
    private int cat1Level = 0;
    private int cat2Level = 0;
    private int cat3Level = 0;
    private int power;
    private int range;
    private int ability;
    private final int[] upgradeCosts;
    private final int[] powerList;
    private final int[] rangeList;
    private final int[] abilityList;
    private final JProgressBar cat1ProgressBar;
    private final JProgressBar cat2ProgressBar;
    private final JProgressBar cat3ProgressBar;

    
    // Constructor 
    public Tower(JLabel placementInput, int towerTypeInput, int[] upgradeCostsInput, int[] powerListInput, int[] rangeListInput, int[] abilityListInput,
                 JProgressBar c1Progress, JProgressBar c2Progress, JProgressBar c3Progress){
        // Setting up the variables
        placement = placementInput;
        cat1Level = cat2Level = cat3Level = 0;
        towerType = towerTypeInput;
        upgradeCosts = upgradeCostsInput;
        powerList = powerListInput;
        rangeList = rangeListInput;
        abilityList = abilityListInput;
        cat1ProgressBar = c1Progress;
        cat2ProgressBar = c2Progress;
        cat3ProgressBar = c3Progress;
        
        // Setting the power, range, and ability
        power = powerList[cat1Level];
        range = rangeList[cat2Level];
        ability = abilityList[cat3Level];
    }
    
    // Get Functions
    public JLabel getPlacement() { return placement; }
    public int getTowerType() { return towerType; }
    public int getcat1Level() { return cat1Level; }
    public int getcat2Level() { return cat2Level; }
    public int getcat3Level() { return cat3Level; }
    public int getPower()     { return power;   }
    public int getRange()     { return range;   }
    public int getAbility()   { return ability; }
    
    // Helper Functions
    public int getCurrentUpgradeCost(int targetCategory){
        switch (targetCategory) {
            case 1  -> { return upgradeCosts[cat1Level]; }
            case 2  -> { return upgradeCosts[cat2Level]; }
            default -> { return upgradeCosts[cat3Level]; }
        }
    }
    
    // Tries to upgrade a category, returns false if not possible, returns true AND does it if it is possible
    public boolean upgradeCategory(int targetCategory, int cash){
        
        //  Checking if we can afford this upgrade
        switch (targetCategory) {
            
            // If category is cat1: power
            case 1 -> {
                if(cat1Level >= 3)                   // If category level is maxed out, return false
                    return false;
                if(cash < upgradeCosts[cat1Level+1]) // If we have less cash than next upgrade cost, return false
                    return false;
                
                // If possible to upgrade, then upgrade and return true
                cat1Level++;
                power = powerList[cat1Level];
                cat1ProgressBar.setValue(cat1ProgressBar.getValue() + 33);
            }
            
            // If category is cat2: range
            case 2 -> {
                if(cat2Level >= 3)                   // If category level is maxed out, return false
                    return false;
                if(cash < upgradeCosts[cat2Level+1]) // If we have less cash than next upgrade cost, return false
                    return false;
                
                // If possible to upgrade, then upgrade and return true
                cat2Level++;
                range = rangeList[cat2Level];
                cat2ProgressBar.setValue(cat2ProgressBar.getValue() + 33);
            }
            
            // If category is cat3: ability
            default -> {
                if(cat3Level >= 3)                   // If category level is maxed out, return false
                    return false;
                if(cash < upgradeCosts[cat3Level+1]) // If we have less cash than next upgrade cost, return false
                    return false;
                
                // If possible to upgrade, then upgrade and return true
                cat3Level++;
                ability = abilityList[cat3Level];
                cat3ProgressBar.setValue(cat3ProgressBar.getValue() + 33);
            }
        }
        // FINALLLL! Return true so that it does not flash 
        return true;
    }
}


class Enemy{
    private final JLabel hitBox; // This is the actual enemy itself
    private int health;          // Amount of health this object has 
    private int moneyDrop;       // Amount of money the obeject drops
    private int damage;          // Amount of damage the object can make
    
    // Constructor:
    public Enemy(JLabel hitBoxInput, int currentRound, int startingHealth, int healthIncrease, int startingDrop, int dropIncrese,
                 int startingDamage, int damageIncrease){
        hitBox = hitBoxInput;
        health = startingHealth + (healthIncrease * currentRound);
        moneyDrop = startingDrop + (dropIncrese * currentRound);
        damage = startingDamage + (damageIncrease * currentRound);
    }

    // Get Functions:
    public int getX(){ return hitBox.getX(); }
    public int getY(){ return hitBox.getY(); }
    public int getHealth() { return health; }
    public int getMoneyDrop() { return moneyDrop; }
    
}


public class CastleDefense {
    // MAIN GAME VARIABLES:
    int ROUND_TICK = 10;            // Tick for the round
    int STARTING_CASH = 20000;      // Starting money
    int CASTLE_HEALTH = 10000;      // Amount of health the castle has
    int ENEMY_STARTING_HEALTH = 100;// Starting health of the enemy
    int ENEMY_HEALTH_INCREASE = 10; // Amount of more health per round
    int ENEMY_STARTING_DROP = 100;  // Amount of money the enemy drops in beginning
    int ENEMY_DROP_INCREASE = 100;  // Amount more money per round the enemy drops
    int ENEMY_STARTING_DAMAGE = 10; // Amount of damage the enemy does on round 1
    int ENEMY_DAMAGE_INCREASE = 1;  // Amount of damage the enemy does every round after
    int ENEMIES_PER_ROUND = 2;      // How many enemies are made per round -> Round=2 * enemies_per_round=2 = 4 enemies
    int ENEMY_STEP = 2;             // Speed of the enmies through the map
    
    
    // TOWER INFOMRATION: ====================================
    int TOWER1_COST = 200;
    int[] TOWER1_UPGRADE_COST = {0,200,400,600};
    int[] TOWER1_POWER_LIST = {1,2,3,4};
    int[] TOWER1_RANGE_LIST = {1,2,3,4};
    int[] TOWER1_ABILITY_LIST = {1,2,3,4};
    
    
    int TOWER2_COST = 400;
    int[] TOWER2_UPGRADE_COST = {0,400,800,1000};
    int[] TOWER2_POWER_LIST = {1,2,3,4};
    int[] TOWER2_RANGE_LIST = {1,2,3,4};
    int[] TOWER2_ABILITY_LIST = {1,2,3,4};
    
    int TOWER3_COST = 1000;
    int[] TOWER3_UPGRADE_COST = {0,1000,1000,1000};
    int[] TOWER3_POWER_LIST = {1,2,3,4};
    int[] TOWER3_RANGE_LIST = {1,2,3,4};
    int[] TOWER3_ABILITY_LIST = {1,2,3,4};
    
    int TOWER4_COST = 20000; 
    int[] TOWER4_UPGRADE_COST = {0,10000,10000,10000};
    int[] TOWER4_POWER_LIST = {1,2,3,4};
    int[] TOWER4_RANGE_LIST = {1,2,3,4};
    int[] TOWER4_ABILITY_LIST = {1,2,3,4};
    // ======================================================
    
    
    String[] allDescriptions = {"<html>Regular Shooter: Shoots 1-4 shots at the enemy with greater speed than other towers!</html>", 
                                "<html>Shocking Tower: This tower takes a little bit longer, but it delivers a blow to 2-5 enemies!</html>", 
                                "<html>Missle Launcher: Missles are heavy! These make a lot of damage, but take forever to get another ready to shoot.</html>", 
                                "<html>Military Base: Previously named the '!Superman!', this thing alone can win against almost anything!</html>"};
    
    // Saving Colors
    Color buttonColor = new Color(202,157,123);
    Color redColor    = new Color(255,51,0);
    
    
    // Holding Variables:
    ArrayList<JLabel>allPlacements;  // This holds all the placements
    ArrayList<Tower> allTowers;     // This holds all the towers
    ArrayList<JLabel> allEnemies;    // This holds all the enemies
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
    JProgressBar roundTime;
    JLabel savingPlacement;
    JButton nextRoundButton;
    
    
    // Dynamic Variables:
    int cash;
    boolean selectionMode = false;
    JButton flashingButton;
    int flashingCounter;
    JButton savedButton;
    int roundNumber;
    
    
    // Construction Function:
    public void setUp(JLabel[] aP, JButton bt1, JButton bt2, JButton bt3, JButton bt4, 
                      JPanel m, JButton mb, JLabel t1, JLabel t2, JLabel t3, JLabel t4,
                      JLabel cT, JProgressBar ch, JPanel um, JButton c1, JButton c2, JButton c3,
                      JProgressBar c1p, JProgressBar c2p, JProgressBar c3p, JLabel ut, JLabel ud,
                      JProgressBar rt, JButton nrb){
        allPlacements = new ArrayList<>();
        allTowers  = new ArrayList<>();
        allEnemies = new ArrayList<>();
        allPlacements.addAll(Arrays.asList(aP));
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
        roundTime = rt;
        nextRoundButton = nrb;
    }
    
    


    // Get Functions
    public boolean getSelectionMode() { return selectionMode; }
    public String[] getAllDescriptions() { return allDescriptions; }
    
    
    
    
    // Public Functions:
    public void resetGame(){
        // Reseting the visuals of the placements, the icons and borders
        for(JLabel placement : allPlacements){
            placement.setIcon(null);
            placement.setBorder(null);
            placement.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        roundTime.setMaximum(100);
        roundTime.setValue(0);
        allTowers.clear();
        allEnemies.clear();
        roundNumber = 0; 
        nextRoundButton.setVisible(true);
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
            Tower targetTower = getTower(placementClicked);          // Getting the tower using the placementClicked
            if(targetTower == null) return;                          // If this is null, then we just return, better safe than sorry
            
            
            // Update the UPGRADE MENU
            upgradeTower.setIcon(placementClicked.getIcon());                        // Updating the chosen tower
            upgradeDescription.setText(allDescriptions[targetTower.getTowerType()-1]); // Update the description
            cat1Progress.setValue(targetTower.getcat1Level() * 33);                  // Updating cat 1 
            cat2Progress.setValue(targetTower.getcat2Level() * 33);                  // Updating cat 2 
            cat3Progress.setValue(targetTower.getcat3Level() * 33);                  // Updating cat 3 
            savingPlacement = placementClicked;                                      // Saving the placement here so that we can use later
            
            
            // Update the MENU BUTTON and hide the MENU
            menuButton.setText("Close Upgrades"); // Change button to be a close button
            menu.setLocation(0,535);              // Hide in case its not
            
            // Show the UPGRADE MENU
            upgradeMenu.setVisible(true);         // Show the upgrade menu
        }
    }
    
    public void upgradeSellButtonClicked(){
        // Checking if the upgrade menu is visible
        if(!upgradeMenu.isVisible())
            return;
        
        Tower targetTower = getTower(savingPlacement); // Getting the tower object
        int towerType = targetTower.getTowerType();    // Getting the tower type to get the refund cost
        int refund;
        switch(towerType){
            case 1 -> refund = TOWER1_COST/2;
            case 2 -> refund = TOWER2_COST/2;
            case 3 -> refund = TOWER3_COST/2;
            case 4 -> refund = TOWER4_COST/2;
            default -> refund = -1;
        }
        
        
        // If for some reason, the tower type was 0 or something else, then just return
        if(refund == -1) return;
        
        
        // Giving refund and showing in the amount had
        cash += refund;
        cashText.setText(Integer.toString(cash));
        
        
        // Reseting the placement cursor and icon and removing from the list
        savingPlacement.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));   // Resetting the cursor
        savingPlacement.setIcon(null);                                  // Resetting the icon to nothing
        allTowers.remove(allTowers.indexOf(getTower(savingPlacement))); // Removing the tower from the list of towers
        
        
        // Hiding the upgrade panel -> this should automatically do all of the hiding
        menuButtonClicked();
    }
    
    

    
    
    public void catButtonClicked(JButton catButtonClicked){
        // Find out what category we are looking to upgrade
        int targetCategory = 0;
        if(catButtonClicked == cat1Button)
            targetCategory = 1;
        else if(catButtonClicked == cat2Button)
            targetCategory = 2;
        else if(catButtonClicked == cat3Button)
            targetCategory = 3;
        
        if(targetCategory == 0) return;  // Making sure that targetCategory was set correctly
        
        // Getting the tower that we are going to use
        Tower targetTower = getTower(savingPlacement);
        
        // Upgrading the tower -> if the statement is false, then user cannot afford it OR its already maxed out
        if(!targetTower.upgradeCategory(targetCategory, cash)){
            flashButton(catButtonClicked); // Flash Button
            return;                        // Leave Function
        }
        
        // Upgrade was a success -> take money away !!!
        cash -= targetTower.getCurrentUpgradeCost(targetCategory);
        cashText.setText(Integer.toString(cash));
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
    
    
    // NEXT ROUND BUTTON ===================================================================================
    // THE FUN PART!! well almost lmao, here is when the user starts the match!!
    // NOTE: This is also the first time that the user starts the game so keep watch at that on how this reacts 
    public void nextRoundButtonClicked(){
        // Increasing to next round
        roundNumber++; 
        
        // Adding the amount of needed enemies
        for(int i = 0; i < roundNumber*ENEMIES_PER_ROUND; i++){
            //Enemy sendingEnemy = Enemy(); // <===========================================================< ![ HERE ]!! >====< Add the enemies >
        }
        nextRoundButton.setVisible(false); // Hiding the button until next round
        roundClock.start();                // Starting the game clock finally!!!
    }
    // ======================================================================================================
    
    
    // GAME CLOCK ===========================
    public void stopGame(){
        if(roundClock.isRunning()) roundClock.stop();
    }
    // MAIN CLOCK TIMER FOR THE ROUND
    Timer roundClock = new Timer(ROUND_TICK, e->{
        // If all enemies are currently dead, clear the board and start the pause
        if(allEnemies.isEmpty()){
            ((Timer)e.getSource()).stop();    // Stopping the timer
            nextRoundButton.setVisible(true); // Showing the next round button again
        }
    });
    
    
    
    // Private Functions:
    private Tower getTower(JLabel targetPlacement){
        for(Tower currTower : allTowers){
            if(currTower.getPlacement() == targetPlacement)
                return currTower;
        }
        return null; // Just in case
    }
    
    private void buyTowerOfficially(JButton buttonOfTower, JLabel placementClicked){
        // Setting up data to send into new object to send into "allTowers"
        int cost = 0;
        JLabel towerBought = null;
        int[] powerTEMP = {};
        int[] rangeTEMP = {};
        int[] abilityTEMP = {};
        int[] upgradeTEMP = {};
        
        int towerType = 0;
        if(buttonOfTower == buyTower1Button){
            towerType = 1;
            towerBought = tower1;
            cost = TOWER1_COST;
            upgradeTEMP = TOWER1_UPGRADE_COST;
            powerTEMP = TOWER1_POWER_LIST;
            rangeTEMP = TOWER1_RANGE_LIST;
            abilityTEMP = TOWER1_ABILITY_LIST;
        }
        else if(buttonOfTower == buyTower2Button){
            towerType = 2;
            towerBought = tower2;
            cost = TOWER2_COST;
            upgradeTEMP = TOWER2_UPGRADE_COST;
            powerTEMP = TOWER2_POWER_LIST;
            rangeTEMP = TOWER2_RANGE_LIST;
            abilityTEMP = TOWER2_ABILITY_LIST;
        }
        else if(buttonOfTower == buyTower3Button){
            towerType = 3;
            towerBought = tower3;
            cost = TOWER3_COST;
            upgradeTEMP = TOWER3_UPGRADE_COST;
            powerTEMP = TOWER3_POWER_LIST;
            rangeTEMP = TOWER3_RANGE_LIST;
            abilityTEMP = TOWER3_ABILITY_LIST;
        }
        else if(buttonOfTower == buyTower4Button){
            towerType = 4;
            towerBought = tower4;
            cost = TOWER4_COST;
            upgradeTEMP = TOWER4_UPGRADE_COST;
            powerTEMP = TOWER4_POWER_LIST;
            rangeTEMP = TOWER4_RANGE_LIST;
            abilityTEMP = TOWER4_ABILITY_LIST;
        }
        
        // JUSTTT IN CASE: we will cancel the transaction if something happened weird
        if(cost == 0 || towerBought == null)
            return;
        
        
        // Making the object and adding into the list
        Tower newTower = new Tower(placementClicked, towerType, upgradeTEMP, powerTEMP, rangeTEMP, abilityTEMP, cat1Progress, cat2Progress, cat3Progress);
        allTowers.add(newTower);
        
        
        // Applying the purchase and building the tower! (also leaving the selectionMode)
        cash -= cost;
        placementClicked.setIcon(towerBought.getIcon());
        placementClicked.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Setting the hand cursor so use knows to click later
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
