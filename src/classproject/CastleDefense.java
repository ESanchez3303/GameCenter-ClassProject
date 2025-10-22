package classproject;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.geom.Line2D;


// ===================================================================================
// ========================     T O W E R   C L A S S ================================
// ===================================================================================
class Tower{
    private final JLabel placement;
    private int towerType = 0;
    private int cat1Level = 0;
    private int cat2Level = 0;
    private int cat3Level = 0;
    private int power;
    private int range;
    private int ability;
    private final int reloadTime;
    private int reloadCounter;
    private Enemy currentTarget;
    private final int[] upgradeCosts;
    private final int[] powerList;
    private final int[] rangeList;
    private final int[] abilityList;
    private final JProgressBar cat1ProgressBar;
    private final JProgressBar cat2ProgressBar;
    private final JProgressBar cat3ProgressBar;
    private final Color projectileColor;

    
    // Constructor 
    public Tower(JLabel placementInput, int towerTypeInput, int[] upgradeCostsInput, int[] powerListInput, int[] rangeListInput, int[] abilityListInput,
                 JProgressBar c1Progress, JProgressBar c2Progress, JProgressBar c3Progress, int reloadTimeInput, Color projectileColorInput){
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
        reloadTime = reloadTimeInput;
        reloadCounter = 0;
        projectileColor = projectileColorInput;
        
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
    public int reloadTime()   { return reloadTime; }
    public Enemy getCurrentTarget() { return currentTarget; }
    public Color getProjectileColor() { return projectileColor; }
    
    
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
                System.out.println("Previous range was: " + range);
                cat2Level++;
                range = rangeList[cat2Level];
                cat2ProgressBar.setValue(cat2ProgressBar.getValue() + 33);
                System.out.println("Changing range to: " + range);
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
    
    public boolean update(ArrayList<Enemy> allEnemies) {
        // Rechecking if the current target we have is still alive and is in range
        if (currentTarget != null) {
            if (!currentTarget.isAlive() || !isInRange(currentTarget))
                currentTarget = null;
        }

        // Finding a new target
        if (currentTarget == null)
            currentTarget = findTarget(allEnemies);

        
        // If new target was found, and we are reloading, then return true and reset reloadcounter
        if (currentTarget != null && reloadCounter <= 0) {
            reloadCounter = reloadTime;
            return true; 
        }

        // Was not able to shoot, return false and keep going down in reloadCounter (negative numbers are still caught above)
        if (reloadCounter > 0)
            reloadCounter--;
        return false;
    }

    
    // Finds the first alive enemy in range
    private Enemy findTarget(ArrayList<Enemy> allEnemies) {
        for (Enemy e : allEnemies) {
            if (e.isAlive() && isInRange(e) &&e.getIsMoving()) // DOUBLE CHECKING THAT WE ARENT TARGETING SOME THAT ARENT SPAWNED YET!
                return e; // Return the first one found
        }
        return null; // No target was found, just return null to say that we are not shooting
    }

    
    // Checking if this target is in range using MaAAaaAAtTTTHhhHHHh lol using triangles ofc :)
    private boolean isInRange(Enemy targetEnemy) {
        int dx = targetEnemy.getX() - placement.getX();
        int dy = targetEnemy.getY() - placement.getY();
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance <= range; 
    }


}


// ===================================================================================
// ========================     E N E M Y   C L A S S ================================
// ===================================================================================

class Enemy{
    private final JLabel hitBox; // This is the actual enemy itself
    private int health;          // Amount of health this object has 
    private final int moneyDrop;       // Amount of money the obeject drops
    private final int damage;          // Amount of damage the object can make
    private boolean isMoving;    // This is used by the clock to know if we should be moving this object
    private JPanel line;         // The line that the enemy is currently on
    private boolean isAlive;     // To know if this enemy is alive, that way we can destroy after rounds intead of during rounds
    
    // Constructor:
    public Enemy(JLabel hitBoxInput, int currentRound, int startingHealth, int healthIncrease, int startingDrop, int dropIncrese,
                 int startingDamage, int damageIncrease, JPanel lineInput){
        currentRound--; // Decreasing in case we are in round 1, we need to upgrade nothing
        hitBox = hitBoxInput;
        health = startingHealth + (healthIncrease * currentRound);
        moneyDrop = startingDrop + (dropIncrese * currentRound);
        damage = startingDamage + (damageIncrease * currentRound);
        isMoving = false;
        line = lineInput;
        isAlive = true;
    }

    // Get Functions:
    public int getX(){ return hitBox.getX(); }
    public int getY(){ return hitBox.getY(); }
    public int getHealth() { return health; }
    public int getMoneyDrop() { return moneyDrop; }
    public int getDamage() { return damage; }
    public boolean getIsMoving() { return isMoving; } 
    public JPanel getLine() { return line; } 
    public JLabel getHitBox() { return hitBox; }
    public boolean isAlive() { return isAlive; }

    
    
    // Set Functions
    public void setLocation(int newX, int newY) { hitBox.setLocation(newX, newY); }
    public void setIsMoving() {isMoving = true; }
    public void setLine(JPanel lineInput) { line = lineInput; }
    public void kill() { isAlive = false; }
    
    // Helper Functions:
    public boolean takeDamage(int dmg) {
        health -= dmg;
        System.out.println();
        if (health <= 0 && isAlive) {
            kill();
            hitBox.setVisible(false);
            return true;
        }
        return false;
    }    
}




// ===================================================================================
// ======================  P R O J E C T I L E   C L A S S ===========================
// ===================================================================================

class Projectile {
    private final int LIGHTNING_SHOW_TIME = 200; // AMOUNT OF TIME THAT THE LIGHTNING IS SHOWING FOR
    private final Tower shootingTower;
    private final JLabel sprite;
    private final Color spriteColor;
    private Enemy target;
    private final int step;
    private final int damage;
    private boolean active;
    private final JPanel gameBox;
    private final JPanel menu;        // Needed to push back to the top
    private final JPanel upgradeMenu; // Needed to push back to the top
    private final JPanel bottomBar;   // Needed to push back to the top
    
    public Projectile(Tower shootingTowerInput, Enemy targetInput, int damageInput, 
                      int stepinput, Color spriteColorInput, JPanel gameBoxInput, JPanel menuInput, 
                      JPanel upgradeMenuInput, JPanel bottomBarInput) {
        target = targetInput;
        damage = damageInput;
        step = stepinput;
        active = true;
        shootingTower = shootingTowerInput;
        JLabel towerPlacement = shootingTower.getPlacement();
        gameBox = gameBoxInput;
        menu = menuInput;
        upgradeMenu = upgradeMenuInput;
        bottomBar = bottomBarInput;
        spriteColor = spriteColorInput;
        
        sprite = new JLabel();
        sprite.setBounds(
            towerPlacement.getX() + towerPlacement.getWidth() / 2 - 5,
            towerPlacement.getY() + towerPlacement.getHeight() / 2 - 5,
            10, 10
        );
        
        sprite.setBackground(spriteColorInput);
        sprite.setOpaque(true);
    }

    public JLabel getSprite() { return sprite; }
    public boolean isActive() { return active; }
    public boolean killedTarget() { return !target.isAlive(); }

    public void update(ArrayList<Enemy> enemies) {
        // If target is already dead, then just remove this projectile
        if (!target.isAlive()) {
            active = false;
            sprite.setVisible(false);
            return;
        }

        // Finding out the distance now
        int dx = target.getX() - sprite.getX();
        int dy = target.getY() - sprite.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        // Finding out the tower type
        int towerType = shootingTower.getTowerType();

        // ========== Tower Type 2: Shocking Shooter ==========
        if (towerType == 2) {
            active = false;                                  // Signaling for removal since we are using lines instead of the projectile
            sprite.setVisible(false);                        // Removing the projectile since we are doing lines for this tower instead
            target.takeDamage(damage);                       // Initial hit to the first enemy
            int towerJumps = shootingTower.getAbility() - 1; // Finding out the remaining jumps
            int range = shootingTower.getRange();            // Finding the range that the shock can jump
            ArrayList<Enemy> alreadyShot = new ArrayList<>();// Holds the previously shot enemies 
            alreadyShot.add(target);                         // Adding the inital enemy here
            
            
            // Finding the points that we are going to draw and then make the lightning
            JLabel startingBox = shootingTower.getPlacement();
            JLabel endBox = target.getHitBox();
            Point start = new Point(startingBox.getX() + (startingBox.getWidth()/2), startingBox.getY() + (startingBox.getHeight()/2));
            Point end = new Point(endBox.getX() + (endBox.getWidth()/2), endBox.getY() + (endBox.getHeight()/2));
            createLightningLine(start,end); 
            
            for (int i = 0; i < towerJumps; i++) {           // For how ever many time we have left to jump
                Enemy nextTarget = null;                     // Holding variable for next jump-to enemy
                double closestDistance = Double.MAX_VALUE;   // Setting to a really high number for first search (aka MAX_VALUE)

                // Finding the next target
                for (Enemy currentEnemy : enemies) {
                    if (alreadyShot.contains(currentEnemy) || !currentEnemy.isAlive()) // If enemy is already shot or dead, continue
                        continue;

                    // Calculating the distance between current "target" and potential enemy jump-to
                    int newDX = target.getX() - currentEnemy.getX();
                    int newDY = target.getY() - currentEnemy.getY();
                    double newDistance = Math.sqrt(newDX * newDX + newDY * newDY);
                    

                    // If this enemy is in range ANDDDD if it is the closest enemy avaliable
                    if (newDistance <= range && newDistance < closestDistance) {
                        closestDistance = newDistance;
                        nextTarget = currentEnemy;
                    }
                }

                // Shooting this next enemy and moving "target" to that /now/ last hit enemy
                if (nextTarget != null) {
                    start = end;                   // Setting the start to the end of the last one so that the lines touch
                    endBox = nextTarget.getHitBox(); // Getting the box that we are going to hit, then calculating the middle to set as the end
                    end = new Point(endBox.getX() + (endBox.getWidth()/2), endBox.getY() + (endBox.getHeight()/2));
                    nextTarget.takeDamage(damage); // Dealing damage to the next
                    alreadyShot.add(nextTarget);   // Adding to the already shot
                    target = nextTarget;           // Moving the current target to the nextTarget
                    createLightningLine(start,end);
                } 
                else {
                    break; // No valid enemy, then we cant jump anywhere, jsut leave :)
                }
            }

            return; // done, no projectile movement needed for this case
        }

        
        // ========== Tower Type 4 ==========
        if (towerType == 4) {
            // Do something special for this later
            return;
        }
        

        // ========== Tower Type 1 & 3 ==========
        if (distance <= step) {
            target.takeDamage(damage);
            active = false;
            sprite.setVisible(false);
        } else {
            sprite.setLocation(
                (int)(sprite.getX() + dx / distance * step),
                (int)(sprite.getY() + dy / distance * step)
            );
        }
    }
    
    // HELPER FUNCTIONS:
    private void createLightningLine(Point start, Point end) {
        int x1 = start.x;
        int y1 = start.y;
        int x2 = end.x;
        int y2 = end.y;

        // Top-left corner of panel
        int panelX = Math.min(x1, x2);
        int panelY = Math.min(y1, y2);

        int panelWidth = Math.max(1, Math.abs(x2 - x1));
        int panelHeight = Math.max(1, Math.abs(y2 - y1));

        JPanel linePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(spriteColor);
                g2.setStroke(new BasicStroke(6));

                // draw line relative to panel
                g2.drawLine(x1 - panelX, y1 - panelY, x2 - panelX, y2 - panelY);
            }
        };

        linePanel.setOpaque(false);
        linePanel.setBounds(panelX, panelY, panelWidth, panelHeight);
        gameBox.add(linePanel);
        gameBox.setComponentZOrder(linePanel, 0);
        gameBox.setComponentZOrder(menu, 0);
        gameBox.setComponentZOrder(upgradeMenu, 0);
        gameBox.setComponentZOrder(bottomBar, 0);
        gameBox.repaint();

        // Remove after the show time duration! very important lmao, you wouldn't belive what it looked like without this
        new Timer(LIGHTNING_SHOW_TIME, e -> {
            gameBox.remove(linePanel);
            gameBox.repaint();
            ((Timer)e.getSource()).stop();
        }).start();
    }
}



// ===================================================================================
// ====================  M A I N   C A S T L E   C L A S S ===========================
// ===================================================================================
public class CastleDefense {
    // MAIN GAME VARIABLES:
    int ROUND_TICK = 5;           // Tick for the round
    int STARTING_CASH = 20000;    // Starting money
    int CASH_PER_KILL = 200;      // Amount of cash you get per kill     
    int CASTLE_HEALTH = 1000;      // Amount of health the castle has
    
    
    // ENEMY VARIABLES: =========================================
    int ENEMY_STARTING_HEALTH = 100;// Starting health of the enemy
    int ENEMY_HEALTH_INCREASE = 20; // Amount of more health per round
    int ENEMY_STARTING_DROP = 100;  // Amount of money the enemy drops in beginning
    int ENEMY_DROP_INCREASE = 100;  // Amount more money per round the enemy drops
    int ENEMY_STARTING_DAMAGE = 10; // Amount of damage the enemy does on round 1
    int ENEMY_DAMAGE_INCREASE = 1;  // Amount of damage the enemy does every round after
    int ENEMIES_PER_ROUND = 2;      // How many enemies are made per round -> Round=2 * enemies_per_round=2 = 4 enemies
    int ENEMY_STEP = 1;             // Speed of the enmies through the map
    int ENEMY_SPAWN_X = -40;        // Location X of where the enemies should spawn
    int ENEMY_SPAWN_Y = 410;        // Location Y of where the enemies should spawn
    int ENEMY_SIZE = 40;            // The size of the enemy, this should match the size of the path we are following
    int ENEMY_SPACING = 10;         // Spacing between the enemies (where enemy 1 needs to be when we send out enemy 2)
    
    // ======================================================
    
    
    // PROJECTILE VARIABELES : ===============================
    int PROJECTILE_STEP = 8; // Really fast so that it never misses 
    Color TOWER1_PROJECTILE_COLOR = new Color(0,0,0);
    
    Color TOWER2_PROJECTILE_COLOR = new Color(204,51,0);
    
    Color TOWER3_PROJECTILE_COLOR = new Color(0,255,51);
    
    Color TOWER4_PROJECTILE_COLOR = new Color(215,215,215);
    // =======================================================
    
    
    // TOWER VARIABLES: ====================================
    int RANGE_SCALE_FACTOR = 55; // To scale up the range
    int POWER_SCALE_FACTOR = 50; // To scale up the power
    
    // REGULAR SHOOTER:
    int TOWER1_COST = 200;
    int TOWER1_RELOAD_TICKS = 65;
    int[] TOWER1_UPGRADE_COST = {0,200,400,600};
    int[] TOWER1_POWER_LIST = {2,4,5,6};
    int[] TOWER1_RANGE_LIST = {2,3,4,5};
    int[] TOWER1_ABILITY_LIST = {1,2,3,4};
    
    // ELECTRIC SHOOTER:
    int TOWER2_COST = 400;
    int TOWER2_RELOAD_TICKS = 150;
    int[] TOWER2_UPGRADE_COST = {0,400,800,1000};
    int[] TOWER2_POWER_LIST = {1,2,3,4};
    int[] TOWER2_RANGE_LIST = {1,2,3,4};
    int[] TOWER2_ABILITY_LIST = {2,3,4,5};
    
    // MISSLE SHOOTER:
    int TOWER3_COST = 1000;
    int TOWER3_RELOAD_TICKS = 600;
    int[] TOWER3_UPGRADE_COST = {0,1000,1000,1000};
    int[] TOWER3_POWER_LIST = {3,4,5,6};
    int[] TOWER3_RANGE_LIST = {3,4,5,6};
    int[] TOWER3_ABILITY_LIST = {1,2,3,4};
    
    // MILITARY BASE SHOOTER:
    int TOWER4_COST = 20000; 
    int TOWER4_RELOAD_TICKS = 10;
    int[] TOWER4_UPGRADE_COST = {0,10000,10000,10000};
    int[] TOWER4_POWER_LIST = {10,20,25,30};
    int[] TOWER4_RANGE_LIST = {6,7,8,9};
    int[] TOWER4_ABILITY_LIST = {1,2,3,4};
    // ======================================================
    
    
    String[] allDescriptions = {"<html>Regular Shooter: Shoots 1-4 shots at the enemy with greater speed than other towers!</html>", 
                                "<html>Shocking Tower: This tower takes a little bit longer, but it delivers a blow to 2-5 enemies!</html>", 
                                "<html>Missle Launcher: Missles are heavy! These make a lot of damage, but take forever to get another ready to shoot.</html>", 
                                "<html>Military Base: Previously named the '!Superman!', this thing alone can win against almost anything!</html>"};
    
    // Saving Colors (used for flashing a button red)
    Color buttonColor = new Color(202,157,123);
    Color redColor    = new Color(255,51,0);
    
    
    // Holding Variables:
    ArrayList<JLabel> allPlacements;      // This holds all the placements
    ArrayList<Tower> allTowers;           // This holds all the towers
    ArrayList<Enemy> allEnemies;          // This holds all the enemies
    ArrayList<Projectile> allProjectiles; // This holds all proejectils
    ArrayList<JPanel> allLines;           // This holds all the lines that are the path in the game
    ArrayList<JLabel> activeLightningLines ; // This holds the lightnings that we make so that users can experience them visually
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
    JProgressBar enemiesLeftBar;
    JLabel savingPlacement;
    JButton nextRoundButton;
    JLabel enemyExample;
    JPanel gameBox;
    JLabel castle;
    JPanel bottomBar;
    
    
    // Dynamic Variables:
    int cash;
    boolean selectionMode = false;
    JButton flashingButton;
    int flashingCounter;
    JButton savedButton;
    int currentRound;
    int lastSentEnemy;
    
    
    // Construction Function:
    public void setUp(JLabel[] aP, JButton bt1, JButton bt2, JButton bt3, JButton bt4, 
                      JPanel m, JButton mb, JLabel t1, JLabel t2, JLabel t3, JLabel t4,
                      JLabel cT, JProgressBar ch, JPanel um, JButton c1, JButton c2, JButton c3,
                      JProgressBar c1p, JProgressBar c2p, JProgressBar c3p, JLabel ut, JLabel ud,
                      JProgressBar elb, JButton nrb, JLabel ee, JPanel gb, JPanel[] l, JLabel cst,
                      JPanel bb){
        allPlacements = new ArrayList<>();
        allProjectiles = new ArrayList<>();
        allTowers  = new ArrayList<>();
        allEnemies = new ArrayList<>();
        allLines = new ArrayList<>();
        activeLightningLines = new ArrayList<>();
        allPlacements.addAll(Arrays.asList(aP));
        allLines.addAll(Arrays.asList(l));
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
        enemiesLeftBar = elb;
        nextRoundButton = nrb;
        enemyExample = ee;
        gameBox = gb;
        castle = cst;
        bottomBar = bb;
        for(int i = 0; i < 4; i++){
            TOWER1_RANGE_LIST[i] *= RANGE_SCALE_FACTOR;
            TOWER2_RANGE_LIST[i] *= RANGE_SCALE_FACTOR;
            TOWER3_RANGE_LIST[i] *= RANGE_SCALE_FACTOR;
            TOWER4_RANGE_LIST[i] *= RANGE_SCALE_FACTOR;
            TOWER1_POWER_LIST[i] *= POWER_SCALE_FACTOR;
            TOWER2_POWER_LIST[i] *= POWER_SCALE_FACTOR;
            TOWER3_POWER_LIST[i] *= POWER_SCALE_FACTOR;
            TOWER4_POWER_LIST[i] *= POWER_SCALE_FACTOR;
        }
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
        allTowers.clear();
        
        // Removing any previous enemies from previous games and projectiles
        removeAllEnemies();
        removeAllProjectiles();
        removeAllLightning();
        
        
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
        enemiesLeftBar.setMaximum(100);
        enemiesLeftBar.setValue(0);
        currentRound = 0; 
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
        currentRound++; 
        
        // Adding the amount of needed enemies
        for(int i = 0; i < (currentRound*ENEMIES_PER_ROUND); i++){
            JLabel sendingHitBox = new JLabel(); // ERROR: we need to set its parent to game box!!
            sendingHitBox.setLocation(ENEMY_SPAWN_X, ENEMY_SPAWN_Y); // Moving the object to the spawn location
            sendingHitBox.setSize(ENEMY_SIZE, ENEMY_SIZE);  // Setting the hit boxes to fit on in the size of the path 
            sendingHitBox.setIcon(enemyExample.getIcon()); // Setting up the icon of this hitBox
            
            
            // Adding this to the gameBox
            gameBox.add(sendingHitBox);                    // Settting the parent-child relationship
            gameBox.setComponentZOrder(sendingHitBox, 0);  // Moving it to the very top
            gameBox.repaint();                             // Repainting the gamebox
            
            // Making object
            Enemy sendingEnemy = new  Enemy(sendingHitBox, currentRound, 
                                            ENEMY_STARTING_HEALTH, ENEMY_HEALTH_INCREASE, 
                                            ENEMY_STARTING_DROP, ENEMY_DROP_INCREASE, 
                                            ENEMY_STARTING_DAMAGE, ENEMY_DAMAGE_INCREASE, allLines.get(0));
            
            // Saving the object into the array that we have currently
            allEnemies.add(sendingEnemy);
        }
        
        // Moving up the menu and upgrade menu so taht we can see it above the enemies
        gameBox.setComponentZOrder(menu, 0);
        gameBox.setComponentZOrder(upgradeMenu, 0);
        gameBox.setComponentZOrder(bottomBar, 0);
        
        allEnemies.get(0).setIsMoving();   // Setting the first enemy to moving so it can go
        lastSentEnemy = 0;                 // Setting to 1 so that we can send the next one
        nextRoundButton.setVisible(false); // Hiding the button until next round
        enemiesLeftBar.setMaximum(currentRound*ENEMIES_PER_ROUND); // Setting the max as the enemies left to kill
        enemiesLeftBar.setValue(currentRound*ENEMIES_PER_ROUND);   // Filling up the bar to the max!
        roundClock.start();                // Starting the game clock finally!!!
    }
    // ======================================================================================================
    
    
    // GAME CLOCK ===========================
    public void stopGame(){
        if(roundClock.isRunning()) roundClock.stop();
    }
    // =================================================================================================================================================
    // MAIN CLOCK TIMER FOR THE ROUND ================================================================================================================
    // =================================================================================================================================================
    Timer roundClock = new Timer(ROUND_TICK, e->{
        
        // Checking if any previous tick move killed the castle
        if(castleHealth.getValue() <= 0){
            ((Timer)e.getSource()).stop();
            System.out.println("GAME HAS ENDED");
            removeAllEnemies(); 
        }
       
        // If all enemies are currently dead, clear the board and start the pause section
        if(enemiesLeft() == 0){
            ((Timer)e.getSource()).stop();    // Stopping the timer
            removeAllEnemies(); 
            nextRoundButton.setVisible(true); // Showing the next round button again
            enemiesLeftBar.setValue(0);       // Setting to no enemies left
        }
        else{
            enemiesLeftBar.setValue(enemiesLeft());
        }
        
        // Moving the enemies through the map if their isMoving is set to true AND they are still alive (duh lmao)
        for(Enemy currEnemy : allEnemies){
            if(currEnemy.getIsMoving() && currEnemy.isAlive())
                moveEnemy(currEnemy);
        }
        
        // Checking if we need to start moving the next enemy (lastSentEnemy is still in array AND the last enemy is at location to allow ENEMY_SPACING)
        if((lastSentEnemy + 1 < allEnemies.size()) && 
           (allEnemies.get(lastSentEnemy).getX() > ENEMY_SPACING)){
            lastSentEnemy++;                             // Increasing the last sent enemy to show which is moving last and to send in next line
            allEnemies.get(lastSentEnemy).setIsMoving(); // Setting this new one to moving now
        }
        
        
        
        // Updating every tower -> finding a new target and returning if we can shoot!
        for (Tower tower : allTowers) {
            // If we can shoot, create a new projectile and set the start and stop of it for direction,
            // also put it on top of everything so that we can see it on the paths
            boolean canShoot = tower.update(allEnemies);
            if (canShoot) {
                Projectile sendingProjectile = new Projectile(tower, tower.getCurrentTarget(), tower.getPower(), PROJECTILE_STEP, 
                                                              tower.getProjectileColor(), gameBox, menu, upgradeMenu, bottomBar);
                allProjectiles.add(sendingProjectile);
                gameBox.add(sendingProjectile.getSprite());
                gameBox.setComponentZOrder(sendingProjectile.getSprite(), 0);
                gameBox.setComponentZOrder(menu, 0);
                gameBox.setComponentZOrder(upgradeMenu, 0);
                gameBox.setComponentZOrder(bottomBar, 0);
            }
        }

        
        
        // Update all projectiles -> move the projectile and check if we hit:
        //                           If we KILLED in process, bring down the enemies left
        //                           If we HIT, then remove the projectile
        for (int i = 0; i < allProjectiles.size(); i++) {
            Projectile currentProjectile = allProjectiles.get(i);
            
            // Moves the projectile and also sets the isActive to false if it already made impact
            currentProjectile.update(allEnemies);
                    
            // If last move made us hit, then remove the projectile
            if (!currentProjectile.isActive()) {
                // Check if this impact killed the target (by checking if the target is still alive)
                if(currentProjectile.killedTarget()){
                    cash += CASH_PER_KILL;
                    cashText.setText(Integer.toString(cash)); // Updating the cash if we did go up in cash
                }
                gameBox.remove(currentProjectile.getSprite());
                allProjectiles.remove(i);
                i--;
            }
            
            // Checking if some lighning lines were made
            
        }
        
        // Repainting everything!! just in case something is tripping up
        gameBox.revalidate();
        gameBox.repaint();
    });
    
    
    
    // Private Functions:
    // MOVES THE ENEMY LABEL THROUGH THE MAP AS WE HAVE SET
    // Explanation: We have 6 lines that the enemy can be on, so we are going to keep track of that
    //              and then we are going to check every time that it is ready to move to another line.
    //              Once we know what line we are on, we can move along that lines longer axis
    private void moveEnemy(Enemy targetEnemy){
        
    
        // Checking if we have to hop the object from one line to the next
        int currentLineIndex = allLines.indexOf(targetEnemy.getLine());
        
        
        // If the current line is a horz, check if we need to hop to the next vert. one
        if(currentLineIndex == 0 || currentLineIndex == 2 || currentLineIndex == 4){
            if(targetEnemy.getX() == allLines.get(currentLineIndex+1).getX())
                targetEnemy.setLine(allLines.get(currentLineIndex+1));
        }
        
        // If the current line is a vert, check if we need to hop to the next horz. one
        else if(currentLineIndex == 1 || currentLineIndex == 3){
            if(targetEnemy.getY() == allLines.get(currentLineIndex+1).getY())
                targetEnemy.setLine(allLines.get(currentLineIndex+1));
        }
        
        // If the object is on the LAST LINE, check if it has hit the castle
        else if(currentLineIndex == 5){
            if(targetEnemy.getY()+ENEMY_SIZE >= castle.getY()){                          // If the object bottom is greater or equal to castle y, then it made impact
               castleHealth.setValue(castleHealth.getValue() - targetEnemy.getDamage()); // Damaging the castle with this enemy health
               targetEnemy.getHitBox().setVisible(false);                                // Hide it temp, we will remove it after this round ends
               targetEnemy.kill();                                                       // Change the status to dead x.x
               enemiesLeftBar.setValue(enemiesLeftBar.getValue() - 1);                   // Showing that there is one less enemy
               return;                                                                   // Return since we are not moving this object later
            }
        }
        
        // If it is out of bounds, then do nothing to prevent errors
        else{
            System.out.println("ERORR: Entered into error state of moveEnemy()");
            return;
        }
        
        
        // OKAY!!! Now this person is in the correct path, we can move them! (INFO: make sure to not overshoot the move so that the previous if statements can work)
        
        // Finding the newx and newy and snaping to points if this move would overshoot the hoping position
        int newX = 0;
        int newY = 0;
        switch(currentLineIndex){
            case 0 -> {
                newX = targetEnemy.getX() + ENEMY_STEP;
                newY = targetEnemy.getY();
                if(newX > allLines.get(1).getX())
                    newX = allLines.get(1).getX();
            }
            case 1 -> {
                newX = targetEnemy.getX();
                newY = targetEnemy.getY() - ENEMY_STEP;
                if(newY < allLines.get(2).getY())
                    newY = allLines.get(2).getY();
            }
            case 2 -> {
                newX = targetEnemy.getX() + ENEMY_STEP;
                newY = targetEnemy.getY();
                if(newX > allLines.get(3).getX())
                    newX = allLines.get(3).getX();
            }
            case 3 -> {
                newX = targetEnemy.getX();
                newY = targetEnemy.getY() + ENEMY_STEP;
                if(newY > allLines.get(4).getY())
                    newY = allLines.get(4).getY();
            }
            case 4 -> {
                newX = targetEnemy.getX() - ENEMY_STEP;
                newY = targetEnemy.getY();
                if(newX < allLines.get(5).getX())
                    newX = allLines.get(5).getX();
            }
            case 5 -> { 
                newX = targetEnemy.getX();
                newY = targetEnemy.getY() + ENEMY_STEP;
                if(newY > (castle.getY() - ENEMY_SIZE))
                    newY = (castle.getY() - ENEMY_SIZE);
            }
        }
        
        // Now finally moving!
        targetEnemy.setLocation(newX, newY);
    }
    
    private void removeAllEnemies(){
        for(Enemy currEnemy : allEnemies){
            gameBox.remove(currEnemy.getHitBox());
        }
        gameBox.revalidate();
        gameBox.repaint();
        allEnemies.clear();
    }
    
    private void removeAllProjectiles(){
        for(Projectile p : allProjectiles){
            gameBox.remove(p.getSprite());
        }
        gameBox.revalidate();
        gameBox.repaint();
        allProjectiles.clear();
    }
    
    private void removeAllLightning(){
        for(JLabel currLine : activeLightningLines ){
            gameBox.remove(currLine);
        }
        gameBox.revalidate();
        gameBox.repaint();
        activeLightningLines.clear();
    }
    
    private int enemiesLeft(){
        int enemiesLeft = 0;
        for(Enemy currEnemy : allEnemies){
            if(currEnemy.isAlive())
                enemiesLeft++;
        }
        return enemiesLeft;
    }
    
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
        int reloadTime = 0;
        Color projectileColor = null;
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
            reloadTime = TOWER1_RELOAD_TICKS;
            upgradeTEMP = TOWER1_UPGRADE_COST;
            powerTEMP = TOWER1_POWER_LIST;
            rangeTEMP = TOWER1_RANGE_LIST;
            abilityTEMP = TOWER1_ABILITY_LIST;
            projectileColor = TOWER1_PROJECTILE_COLOR;
        }
        else if(buttonOfTower == buyTower2Button){
            towerType = 2;
            towerBought = tower2;
            cost = TOWER2_COST;
            reloadTime = TOWER2_RELOAD_TICKS;
            upgradeTEMP = TOWER2_UPGRADE_COST;
            powerTEMP = TOWER2_POWER_LIST;
            rangeTEMP = TOWER2_RANGE_LIST;
            abilityTEMP = TOWER2_ABILITY_LIST;
            projectileColor = TOWER2_PROJECTILE_COLOR;
        }
        else if(buttonOfTower == buyTower3Button){
            towerType = 3;
            towerBought = tower3;
            cost = TOWER3_COST;
            reloadTime = TOWER3_RELOAD_TICKS;
            upgradeTEMP = TOWER3_UPGRADE_COST;
            powerTEMP = TOWER3_POWER_LIST;
            rangeTEMP = TOWER3_RANGE_LIST;
            abilityTEMP = TOWER3_ABILITY_LIST;
            projectileColor = TOWER3_PROJECTILE_COLOR;
        }
        else if(buttonOfTower == buyTower4Button){
            towerType = 4;
            towerBought = tower4;
            cost = TOWER4_COST;
            reloadTime = TOWER4_RELOAD_TICKS;
            upgradeTEMP = TOWER4_UPGRADE_COST;
            powerTEMP = TOWER4_POWER_LIST;
            rangeTEMP = TOWER4_RANGE_LIST;
            abilityTEMP = TOWER4_ABILITY_LIST;
            projectileColor = TOWER4_PROJECTILE_COLOR;
        }
        
        // JUSTTT IN CASE: we will cancel the transaction if something happened weird
        if(cost == 0 || towerBought == null)
            return;
        
        
        // Making the object and adding into the list
        Tower newTower = new Tower(placementClicked, towerType, upgradeTEMP, powerTEMP, rangeTEMP, abilityTEMP, 
                                   cat1Progress, cat2Progress, cat3Progress, reloadTime, projectileColor);
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
