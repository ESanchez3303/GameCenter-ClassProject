package classproject;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


// ===================================================================================
// ========================     T O W E R   C L A S S ================================
// ===================================================================================
class Tower{
    private JLabel placement;
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
    
    
    // Set Functions
    public void resetReload(){
        reloadCounter = 0;
    }
    
    public void moveTower(JLabel newPlacement){
        placement = newPlacement;
    }
    
    
    
    // Helper Functions
    public int getCurrentUpgradeCost(int targetCategory){
        switch (targetCategory) {
            case 1  -> { return upgradeCosts[cat1Level]; }
            case 2  -> { return upgradeCosts[cat2Level]; }
            default -> { return upgradeCosts[cat3Level]; }
        }
    }
    public int getNextUpgradeCost(int targetCategory){
        // If this category + 1 is out of bounds then return -1, this mneans we are at the max level already 
        switch (targetCategory) {
            case 1  -> { 
                if(cat1Level+1 >= 4)
                    return -1;
                return upgradeCosts[cat1Level+1]; 
            }
            case 2  -> { 
                if(cat2Level+1 >= 4)
                    return -1;
                return upgradeCosts[cat2Level+1]; 
            }
            default -> { 
                if(cat3Level+1 >= 4)
                    return -1;
                return upgradeCosts[cat3Level+1]; 
            }
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
    
    public boolean update(ArrayList<Enemy> allEnemies) {
        // Rechecking if the current target we have is still alive and is in range
        if (currentTarget != null) {
            if (!currentTarget.isAlive() || !isInRange(currentTarget))
                currentTarget = null;
        }

        // Finding a new target
        if (currentTarget == null)
            currentTarget = findTarget(allEnemies);

        
        // If new target was found, and reload time is ready then return true and reset reloadcounter
        
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
            if (e.isAlive() && isInRange(e) &&e.getIsMoving() && e.getHitBox().getX() > 0) // DOUBLE CHECKING THAT WE ARENT TARGETING SOME THAT ARENT SPAWNED YET!
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
    private final int damage;    // Amount of damage the object can make
    private boolean isMoving;    // This is used by the clock to know if we should be moving this object
    private JPanel line;         // The line that the enemy is currently on
    private boolean isAlive;     // To know if this enemy is alive, that way we can destroy after rounds intead of during rounds
    
    // Constructor:
    public Enemy(JLabel hitBoxInput, int currentRound, int startingHealth, int healthIncrease,
                 int startingDamage, int damageIncrease, JPanel lineInput){
        currentRound--; // Decreasing in case we are in round 1, we need to upgrade nothing
        hitBox = hitBoxInput;
        health = startingHealth + (healthIncrease * currentRound);
        damage = startingDamage + (damageIncrease * currentRound);
        isMoving = false;
        line = lineInput;
        isAlive = true;
    }

    // Get Functions:
    public int getX(){ return hitBox.getX(); }
    public int getY(){ return hitBox.getY(); }
    public int getHealth() { return health; }
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
    private final int EXPLOSION_SHOW_TIME = 400; // AMOUNT OF TIME THAT THE EXPLOSION IS SHOWING FOR
    private final Tower shootingTower;
    private final JLabel sprite;
    private final Color spriteColor;
    private Enemy target;
    private final int step;
    private final int damage;
    private boolean active;
    private final JPanel gameBox;
    private final JPanel rangeVisual; // Needed to push back to the top
    private final JPanel menu;        // Needed to push back to the top
    private final JPanel upgradeMenu; // Needed to push back to the top
    private final JPanel bottomBar;   // Needed to push back to the top
    private final int towerType;      // Used to know the projectile type we are going to use
    private Point missleTarget = null; // Keeps track of the missle target so that it can reach destination even if the enemy is dead
    
    public Projectile(Tower shootingTowerInput, int towerTypeInput, Enemy targetInput, int damageInput, 
                      int stepinput, Color spriteColorInput, JPanel gameBoxInput, JPanel menuInput, 
                      JPanel upgradeMenuInput, JPanel bottomBarInput, JPanel rv) {
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
        towerType = towerTypeInput;
        rangeVisual = rv;
        
        sprite = new JLabel();
        sprite.setBounds(
            towerPlacement.getX() + towerPlacement.getWidth() / 2 - 5,
            towerPlacement.getY() + towerPlacement.getHeight() / 2 - 5,
            10, 10
        );
        
        sprite.setBackground(spriteColorInput);
        sprite.setOpaque(true);
        
        // Changing the location where projectile is going if its a missle (will only be used it its tower3)
        missleTarget = new Point(target.getX(), target.getY());
    }

    public JLabel getSprite() { return sprite; }
    public boolean isActive() { return active; }
    public boolean killedTarget() { return !target.isAlive(); }

    public int update(ArrayList<Enemy> enemies) {
        int enemiesKilled = 0;
        // If target is already dead, then just remove this projectile
        if ((target == null || !target.isAlive()) && (towerType != 3)) {
            active = false;
            sprite.setVisible(false);
            return enemiesKilled; // Enemy was not killed here, it was already dead before this was called
        }


        // NOTE: when we are sending in tower type, if its 4, then we are sending it as either 1,2, or 3

        // ========== Tower Type 2: Shocking Shooter ==========
        if (towerType == 2) {
            active = false;                                  // Signaling for removal since we are using lines instead of the projectile
            sprite.setVisible(false);                        // Removing the projectile since we are doing lines for this tower instead
            if(target.takeDamage(damage))                    // Initial hit to the first enemy
                enemiesKilled++;                             // Add that we killed this enemy
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
                    if(nextTarget.takeDamage(damage)) // Dealing damage to the next
                        enemiesKilled++;              // If this killed the enemy increase count again
                    alreadyShot.add(nextTarget);      // Adding to the already shot
                    target = nextTarget;              // Moving the current target to the nextTarget
                    createLightningLine(start,end);
                } 
                else {
                    break; // No valid enemy, then we cant jump anywhere, jsut leave :)
                }
            }

            return enemiesKilled; // Return the amount of enemies that were killed with this projectile
        }

        
        
        

        // ========== Tower Type 1 & 3 ==========
        // Finding out the distance now
        int dx = 0, dy = 0;
        if(towerType == 1){                        // If tower 1, then move toward the target
            dx = target.getX() - sprite.getX();
            dy = target.getY() - sprite.getY();
        }
        else if(towerType ==3){                   // If tower3, then move toward the misslteTarget
            dx = missleTarget.x - sprite.getX();
            dy = missleTarget.y - sprite.getY();
        }
            
        
        double distance = Math.sqrt(dx * dx + dy * dy);
        // If we made impact
        if (distance <= step) {
            // If tower type is 1, then jsut take damage
            if(towerType == 1 && target != null && target.isAlive()){ 
                if(target.takeDamage(damage))
                    enemiesKilled++;
                active = false;
                sprite.setVisible(false);
                return enemiesKilled;
            }
            // If tower type is 3, then we need to make it explode and hurt around
            else if(towerType == 3){
                // Making the visual of the explosion in helper function
                int explosionRadius = shootingTower.getAbility()*50;          // Setting the radius according to the current ability
                Point epicenter = new Point(missleTarget.x, missleTarget.y);   // Finding the center of the impact
                createExplosion(epicenter, explosionRadius);                  // Making the visual
                
                // Dealing damage to the enemies inside explosion
                for(Enemy currEnemy : enemies){
                    if(!currEnemy.isAlive() || currEnemy.getX() < 0) // Dont hurt not in board and dead enemies
                        continue;
                    double dx_explosion = currEnemy.getX() - epicenter.x;
                    double dy_explosion = currEnemy.getY() - epicenter.y;
                    double distanceToEpicenter = Math.sqrt(dx_explosion*dx_explosion + dy_explosion*dy_explosion);
                    
                    if(distanceToEpicenter <= explosionRadius){
                        if(currEnemy.takeDamage(damage))
                            enemiesKilled++;
                    }
                }
                active = false;
                sprite.setVisible(false);
                return enemiesKilled; // Return the amount of enemies that are killed
            }
        } else {
        // Regular chasing projectile 
            sprite.setLocation(
                (int)(sprite.getX() + dx / distance * step),
                (int)(sprite.getY() + dy / distance * step)
            );
            return 0; // Show that no enemies were killed
        }
        return 0; // We shouldn't ever reach here since we checked every tower, but just in case
    }
    
    // HELPER FUNCTIONS:
    
   private void createExplosion(Point center, int radius){
        final JPanel explosion = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int x1 = spriteColor.getRed();
                int x2 = spriteColor.getGreen();
                int x3 = spriteColor.getBlue();
                g.setColor(new Color(x1,x2,x3,150));
                g.fillOval(0, 0, getWidth(), getHeight());
            }
        };

        explosion.setBounds(center.x - radius, center.y - radius, radius * 2, radius * 2);
        explosion.setOpaque(false);

        gameBox.add(explosion, 0);
        gameBox.setComponentZOrder(explosion, 0);
        gameBox.setComponentZOrder(rangeVisual, 0);
        gameBox.setComponentZOrder(menu, 0);
        gameBox.setComponentZOrder(upgradeMenu, 0);
        gameBox.setComponentZOrder(bottomBar, 0);
        gameBox.repaint();

        new Timer(EXPLOSION_SHOW_TIME, e -> {
            gameBox.remove(explosion);
            gameBox.repaint();
            ((Timer)e.getSource()).stop();
        }).start();
    }
    
    
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
        gameBox.setComponentZOrder(rangeVisual, 0);
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
    private final int ROUND_TICK       = 7;       // Tick for the round
    private final int ROUND_FAST_TICK   = 1;      // Tifk for the round if the fast foward button is on
    private final int STARTING_CASH     = 400;    // Starting money
    private final int CASH_PER_KILL     = 150;    // Amount of cash you get per kill     
    private final int CASTLE_HEALTH     = 1000;   // Amount of health the castle has
    private final int FLASH_AMOUNT      = 6;      // Amount of times the flash happens for the buttons
    private final int MOVE_COST_FACTOR  = 4;      // Amount by which the cost of the tower is divided to move a tower
    private final int TOWER_SELL_FACTOR = 2;      // Amount by which teh cost of the tower is divided to give as refund
    private final int CASH_GIFT_TICK    = 200;    // Flashing tick for when a cash gift is given
    
    
    // ENEMY VARIABLES: =========================================
    private final int ENEMY_STARTING_HEALTH = 100;// Starting health of the enemy
    private final int ENEMY_HEALTH_INCREASE = 20; // Amount of more health per round
    private final int ENEMY_STARTING_DAMAGE = 10; // Amount of damage the enemy does on round 1
    private final int ENEMY_DAMAGE_INCREASE = 1;  // Amount of damage the enemy does every round after
    private final int ENEMIES_PER_ROUND = 2;      // How many enemies are made per round -> Round=2 * enemies_per_round=2 = 4 enemies
    private final int ENEMY_STEP = 1;             // Speed of the enmies through the map
    private final int ENEMY_SPAWN_X = -40;        // Location X of where the enemies should spawn
    private final int ENEMY_SPAWN_Y = 410;        // Location Y of where the enemies should spawn
    private final int ENEMY_SIZE = 40;            // The size of the enemy, this should match the size of the path we are following
    private final int ENEMY_SPACING = 10;         // Spacing between the enemies (where enemy 1 needs to be when we send out enemy 2)
    
    // Enemy difficulty boundaries
    int ENEMY_DIF_BOUNDARY_1 = 15;  // (2x) the enemy starting health at this level
    int ENEMY_DIF_BOUNDARY_2 = 30;  // (2x) the enemy starting health every 5 levels until next boundary
    int ENEMY_DIF_BOUNDARY_3 = 50;  // (1.3x) the enmy starting health every level until next boundary
    int ENEMY_DIF_BOUNDARY_4 = 65;  // (exponential on exponential on linear increase... yeah its crazy) but nobody should get past this here
    int[] CASH_GIFT_LIST = {20000,50000,100000,500000}; // Amount of money you get on each of the boundary's lapse
    
    // ======================================================
    
    
    // TOWER VARIABLES: ====================================
    private final int RANGE_SCALE_FACTOR = 55; // To scale up the range
    private final int POWER_SCALE_FACTOR = 50; // To scale up the power
    
    // REGULAR SHOOTER:
    private final int TOWER1_COST = 200;
    private final int TOWER1_RELOAD_TICKS = 130;
    private final int TOWER1_PROJECTILE_SPACING = 50;
    private final int TOWER1_PROJECTILE_STEP = 5;
    private final int[] TOWER1_UPGRADE_COST = {0,200,400,600};
    private final int[] TOWER1_POWER_LIST = {2,4,5,6};
    private final int[] TOWER1_RANGE_LIST = {2,3,4,5};
    private final int[] TOWER1_ABILITY_LIST = {1,2,3,4};
    private final Color TOWER1_PROJECTILE_COLOR = new Color(0,0,0);      // Black
    
    
    // ELECTRIC SHOOTER:
    private final int TOWER2_COST = 400;
    private final int TOWER2_RELOAD_TICKS = 180;
    private final int TOWER2_PROJECTILE_STEP = 8;  // Technically is not used for this shooter type
    private final int[] TOWER2_UPGRADE_COST = {0,400,800,1000};
    private final int[] TOWER2_POWER_LIST = {1,2,3,4};
    private final int[] TOWER2_RANGE_LIST = {1,2,3,4};
    private final int[] TOWER2_ABILITY_LIST = {2,3,4,5};
    private final Color TOWER2_PROJECTILE_COLOR = new Color(204,51,0);   // Red ish 
    
    // MISSLE SHOOTER:
    private final int TOWER3_COST = 1000;
    private final int TOWER3_RELOAD_TICKS = 600;
    private final int TOWER3_PROJECTILE_STEP = 3;
    private final int[] TOWER3_UPGRADE_COST = {0,1000,2500,3000};
    private final int[] TOWER3_POWER_LIST = {3,4,5,10};
    private final int[] TOWER3_RANGE_LIST = {3,4,5,6};
    private final int[] TOWER3_ABILITY_LIST = {1,2,3,4};
    private final Color TOWER3_PROJECTILE_COLOR = new Color(255,100,0);  // Orange ish 
    
    
    // MILITARY BASE SHOOTER:
    private final int TOWER4_COST = 20000; 
    private final int TOWER4_RELOAD_TICKS = 280;
    private final int[] TOWER4_UPGRADE_COST = {0,10000,12000,20000};
    private final int[] TOWER4_POWER_LIST = {8,10,15,20};
    private final int[] TOWER4_RANGE_LIST = {4,5,6,9};
    private final int[] TOWER4_ABILITY_LIST = {3,4,7,9}; // Used in missle range, eletric hop, and shots made from regular shooter 
    // NOTE: this tower does not need a color or speed, since its using above stats
    // ======================================================
    
    // Other Final Variables:
    private final String[] ALL_DESCRIPTIONS = 
                               {
                                "<html>Regular Shooter: Shoots 1-4 following bullets at the enemy with greater speed than other towers!</html>", 
                                "<html>Shocking Tower: This tower takes a little bit longer, but it delivers a blow to 2-5 enemies!</html>", 
                                "<html>Missle Launcher: A lot of boom! More damage, but missle has to lock onto location, not an enemy!</html>", 
                                "<html>Military Base: Previously named the '!Superman!', this thing has 1 of each tower on this base!</html>"
                               };
    private final Color CAT_BUTTON_COLOR   = new Color(202,157,123);
    private final Color RANGE_VISUAL_COLOR = new Color(153,204,255);
    private final Color MOVE_BUTTON_COLOR  = new Color(184,125,80);
    private final Color RED_COLOR          = new Color(255,51,0);
    private final Color GREEN_COLOR        = new Color(0,255,0);
    private final Color WHITE_COLOR        = new Color(255,255,255);
    private final int RANGE_VISUAL_OPACITY = 150;
    
    
    // Holding Variables:
    private ArrayList<JLabel> allPlacements;      // This holds all the placements
    private ArrayList<Tower> allTowers;           // This holds all the towers
    private ArrayList<Enemy> allEnemies;          // This holds all the enemies
    private ArrayList<Projectile> allProjectiles; // This holds all proejectils
    private ArrayList<JPanel> allLines;           // This holds all the lines that are the path in the game
    private ArrayList<JLabel> activeLightningLines ; // This holds the lightnings that we make so that users can experience them visually
    private JButton buyTower1Button;
    private JButton buyTower2Button;
    private JButton buyTower3Button;
    private JButton buyTower4Button;
    private JPanel menu;
    private JButton menuButton;
    private JLabel tower1;
    private JLabel tower2;
    private JLabel tower3;
    private JLabel tower4;
    private JLabel cashText;
    private JProgressBar castleHealth;
    private JPanel upgradeMenu;
    private JButton cat1Button;
    private JButton cat2Button;
    private JButton cat3Button;
    private JButton moveButton;
    private JProgressBar cat1Progress;
    private JProgressBar cat2Progress;
    private JProgressBar cat3Progress;
    private JLabel upgradeTower;
    private JLabel upgradeDescription;
    private JProgressBar enemiesLeftBar;
    private JLabel savingPlacement;
    private JButton nextRoundButton;
    private JLabel enemyExample;
    private JPanel gameBox;
    private JLabel castle;
    private JPanel bottomBar;
    private JPanel gameEndedPanel;
    private JLabel gameEndedPoints;
    private JLabel totalEnemiesKilled;
    private JLabel roundDiedAt;
    private JLabel totalCashMade;
    private JLabel gameEndedHighscoreIndicator;
    private HighscoreManager scores_fromOutside;
    private String currentUser_fromOutside;
    private JPanel rangeVisual;
    private JPanel messagePanel;
    
    
    
    // Stats Variables
    private JLabel currentRoundStat;
    private JLabel enemiesKilledStat;
    private JLabel castleHealthStat;
    private JLabel cashMadeStat;
    private int currentRound;
    private int enemiesKilled;
    private int cashMade;
    // we dont need a castle health since we already have the progressbar of it
    
    
    // Dynamic Variables:
    private boolean selectionMode = false;
    private boolean movingTowerMode = false;
    private int cash;
    private JButton savedButton;
    private int lastSentEnemy;
    private JButton flashingButton;
    private int flashingCounter;
    private int spawningEnemyHealth;
    private boolean fastFoward = false;
    private int cashGift;
    
    // Construction Function:
    public void setUp(JLabel[] aP, JButton bt1, JButton bt2, JButton bt3, JButton bt4, 
                      JPanel m, JButton mb, JLabel t1, JLabel t2, JLabel t3, JLabel t4,
                      JLabel cT, JProgressBar ch, JPanel um, JButton c1, JButton c2, JButton c3,
                      JProgressBar c1p, JProgressBar c2p, JProgressBar c3p, JLabel ut, JLabel ud,
                      JProgressBar elb, JButton nrb, JLabel ee, JPanel gb, JPanel[] l, JLabel cst,
                      JPanel bb, JLabel crs, JLabel eks, JLabel chs, JLabel cms, JPanel gep, 
                      JLabel gepoints, JLabel hsi, JLabel gameDescription, JButton umb,
                      JLabel rda, JLabel tek, JLabel tcm, JPanel mp){
        
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
        moveButton = umb;
        cat1Progress = c1p;
        cat2Progress = c2p;
        cat3Progress = c3p;
        upgradeTower = ut;
        upgradeDescription = ud;
        enemiesLeftBar = elb;
        nextRoundButton = nrb;
        enemyExample = ee;
        gameBox = gb;
        gameBox.setLayout(null);
        castle = cst;
        bottomBar = bb;
        currentRoundStat = crs;
        enemiesKilledStat = eks;
        castleHealthStat = chs;
        cashMadeStat = cms;
        gameEndedPanel = gep;
        gameEndedPoints = gepoints;
        gameEndedHighscoreIndicator = hsi;
        roundDiedAt = rda;
        totalEnemiesKilled = tek;
        totalCashMade = tcm;
        messagePanel = mp;
        
        gameDescription.setText(
            "<html><div style='text-align: center; width: 400px;'>"
          + "Defend the castle! Enemies will get harder as rounds go!<br>"
          + "Open the menu to buy a tower and place it. Press the tower to upgrade it.<br>"
          + "Each tower can upgrade its power, range, and ability.<br>"
          + "Sell Refund = Tower Price/" + TOWER_SELL_FACTOR + "  "
          + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
          + " Move Price = Tower Price/" + MOVE_COST_FACTOR + "<br>"
          + "<b>-- Good luck! --</b>"
          + "</div></html>"
        );
        
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
        
        
        rangeVisual = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int x1 = RANGE_VISUAL_COLOR.getRed();
                int x2 = RANGE_VISUAL_COLOR.getGreen();
                int x3 = RANGE_VISUAL_COLOR.getBlue();
                g.setColor(new Color(x1,x2,x3,RANGE_VISUAL_OPACITY));
                g.fillOval(0, 0, getWidth(), getHeight());
            }
        };

        
        // Temporaly putting it in away, we will show it later when we need to
        rangeVisual.setBounds(-10, -10, 10, 10);
        rangeVisual.setOpaque(false);
        rangeVisual.setCursor(new Cursor(Cursor.HAND_CURSOR));

        gameBox.add(rangeVisual, 0);
        gameBox.setComponentZOrder(rangeVisual, 0);
        bringMenusUp();
        gameBox.repaint();
        
    }
    
    


    
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
        buyTower1Button.setBackground(CAT_BUTTON_COLOR);
        buyTower2Button.setBackground(CAT_BUTTON_COLOR);
        buyTower3Button.setBackground(CAT_BUTTON_COLOR);
        buyTower4Button.setBackground(CAT_BUTTON_COLOR);
        moveButton.setBackground(MOVE_BUTTON_COLOR);
        menu.setLocation(0,535); 
        selectionMode = false;
        movingTowerMode = false;
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
        cashMade = 0;
        enemiesKilled = 0;
        currentRoundStat.setText("0");
        enemiesKilledStat.setText("0");
        castleHealthStat.setText(Integer.toString(CASTLE_HEALTH) + "/" + Integer.toString(CASTLE_HEALTH));
        cashMadeStat.setText("0");
        nextRoundButton.setVisible(true);
        gameEndedHighscoreIndicator.setVisible(false);
        spawningEnemyHealth = ENEMY_STARTING_HEALTH;
        rangeVisual.setBounds(-10,-10,10,10); // Moving the location we KNOW is outside
        fastFoward = false;
        cashGift = 0;
        cashText.setForeground(WHITE_COLOR);
        messagePanel.setVisible(false);
    }
    
    
    // Get Functions
    public boolean getSelectionMode() { return selectionMode; }
    public String[] getAllDescriptions() { return ALL_DESCRIPTIONS; }
    
    
    // Set Functions
    public void setFastFoward(boolean f) { fastFoward = f; }
    
    
    
    
    public void menuButtonClicked(){
        // Return if the message panel is showing, treating this as a pause section
        if(messagePanel.isVisible())
            return;
        
        // Any time we click on this, we should get rid of the rangeVisual no matter what
        rangeVisual.setBounds(-10,-10,10,10);
        
        
        
        // ===================== IF WE ARE IN SELECTION MODE ==============================
        // If we are currently in selection mode, then this click means cancel instead
        if(selectionMode){
            selectionMode = false;            // Canceling the selection mode
            menuButton.setText("Close Menu"); // Resetting the menu button 
            menu.setLocation(0,40);           // Moving menu back to open
            highlightPlacement(null);         // Unhighlighting every placement in case it gets stuck
            return;                           // Getting out so user can go back into menu as needed
        }
        
        // ===================== IF WE ARE IN MOVING TOWER MODE ============================
        // If we arre currently in moving tower mode, this this means to cancel the move 
        if(movingTowerMode){
            movingTowerMode = false;
            menuButton.setText("Close Upgrades");
            upgradeMenu.setVisible(true);
            highlightPlacement(null);
            return;
        }
        
        
        // ===================== IF THE UPGRADE MENU IS SHOWING ==============================
        if(menuButton.getText().equals("Close Upgrades")){
            upgradeMenu.setVisible(false);
            menuButton.setText("Open Menu");
            menu.setLocation(0,535);
            return;
        }
        
        
        
        // ===================== REGULAR MENU OPEN AND CLOSING =--=============================
        // If the menu is currently CLOSED, we are OPENING it now
        if(menuButton.getText().equals("Open Menu")){
            upgradeMenu.setVisible(false);       // Hhiding the upgrade menu in case its open
            menuButton.setText("Close Menu");    // Change the button text
            menu.setLocation(0, 40);
        }
        // If the menu is currently OPENED, we are now CLOSING (currently it says "Close Menu")
        else{
            menuButton.setText("Open Menu");     // Change the button text
            menu.setLocation(0,535);
        }
    }
    
    
    
    
    public void buyTowerButtonClicked(int clickedTower, JButton clickedButton){
        // Return if the message panel is showing, treating this as a pause section
        if(messagePanel.isVisible())
            return;
        
        // Setting the amount that this tower would cost to buy and saving the clicked button
        int cost = 0;
        switch(clickedTower){
            case 1 -> { cost = TOWER1_COST; }
            case 2 -> { cost = TOWER2_COST; }
            case 3 -> { cost = TOWER3_COST; }
            case 4 -> { cost = TOWER4_COST; }
        }
        
        // If user does not have enough cash to buy this, flash the button and return
        if(cost > cash){
            flashButton(clickedButton,CAT_BUTTON_COLOR);       
            return;
        }
        
        
        // User had enough money, go ahead and set the next steps up
        selectionMode = true;             // Turning on the selection mode
        savedButton = clickedButton;      // Saving this button so we know what tower was bought
        menuButton.setText("Cancel Buy"); // Changing this button to be a cancel button
        menu.setLocation(0,535);          // Hiding the menu from the user
    }
    
    
    public void upgradeMoveButtonClicked(){
        // Return if the message panel is showing, treating this as a pause section
        if(messagePanel.isVisible())
            return;
        
        
        if(!upgradeMenu.isVisible())
            return;
        
        // First check if user has enough money to move this piece
        Tower targetTower = getTower(savingPlacement);
        int cost = getCostOfTower(targetTower)/MOVE_COST_FACTOR;   // To Move a tower, it cost this much
        
        // If user does not have enough money, flash this button
        if(cost > cash){
            flashButton(moveButton, MOVE_BUTTON_COLOR);
            return;
        }
        
        // Now set the mode to movingtowermode and hide the upgrade menu so we can see all spaces
        upgradeMenu.setVisible(false);
        menuButton.setText("Cancel Move");
        movingTowerMode = true;
    }
    
    
    
    public void upgradeSellButtonClicked(){
        // Return if the message panel is showing, treating this as a pause section
        if(messagePanel.isVisible())
            return;
        
        // Checking if the upgrade menu is visible
        if(!upgradeMenu.isVisible())
            return;
        
        Tower targetTower = getTower(savingPlacement);              // Getting the tower object
        int refund = getCostOfTower(targetTower)/TOWER_SELL_FACTOR; // Getting the amount that is needed to be refunded
        
        
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
        // Return if the message panel is showing, treating this as a pause section
        if(messagePanel.isVisible())
            return;
        
        // Find out what category we are looking to upgrade
        int targetCategory = 0;
        JProgressBar targetProgressBar = null;
        if(catButtonClicked == cat1Button){
            targetCategory = 1;
            targetProgressBar = cat1Progress;
        }
        else if(catButtonClicked == cat2Button){
            targetCategory = 2;
            targetProgressBar = cat2Progress;
        }
        else if(catButtonClicked == cat3Button){
            targetCategory = 3;
            targetProgressBar = cat3Progress;
        }
        
        if(targetCategory == 0 || targetProgressBar == null) 
            return;  // Making sure that targetCategory and targetProgressBar was set correctly
        
        // Getting the tower that we are going to use
        Tower targetTower = getTower(savingPlacement);
        
        // Upgrading the tower -> if the statement is false, then user cannot afford it OR its already maxed out
        if(!targetTower.upgradeCategory(targetCategory, cash)){
            flashButton(catButtonClicked, CAT_BUTTON_COLOR); // Flash Button
            return;                        // Leave Function
        }
        
        // Upgrade was a success -> take money away !!!
        int cost = targetTower.getCurrentUpgradeCost(targetCategory);
        cash -= cost;
        cashText.setText(Integer.toString(cash));
        
        // Updating the target progressbar with the targets new upgrade cost of the current category .... tripyyyy i know 
        int nextUpgradeCost = targetTower.getNextUpgradeCost(targetCategory);                                       // Collecting the next cost, but if its maxed out, then this is -1
        String stringForBar = (nextUpgradeCost == -1 ? "FULLY UPGRADED" : "COST: $ " + Integer.toString(nextUpgradeCost)); // Make the message of next cost OR make it show "FULLY UPGRADE"
        targetProgressBar.setString(stringForBar);                                                                  // Set the string of the bar to this
    }
    
    
    
    
    public void highlightPlacement(JLabel targetPlacement){
        // Return if the message panel is showing, treating this as a pause section
        if(messagePanel.isVisible())
            return;
        
        
        // ======================== IF "NULL" THEN JUST HIDE EVERYTHING ============================
        // If what we wanted to do was reset and unhighlight everything
        if(targetPlacement == null){
            rangeVisual.setBounds(-10,-10,10,10);
            for(JLabel placement: allPlacements)
                placement.setBorder(null);
            return;
        }
        
        
        // =============================== IN MOVING TOWER MODE ========================================
        
        if(movingTowerMode){
            // If we are hovering over a tower, clear the visuals of everything
            if(targetPlacement.getIcon() != null){
                highlightPlacement(null);
                return;
            }
            Point center;
            int radius;
            for(JLabel placement : allPlacements){
                if(placement == targetPlacement && placement.getIcon() == null){
                    placement.setBorder(BorderFactory.createSoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

                    // Saving the center of this placement to draw the range
                    center = new Point(placement.getX()+placement.getWidth()/2,
                                       placement.getY()+placement.getHeight()/2);

                    // Saving the range of the tower we are buying to draw the range
                    radius = getTower(savingPlacement).getRange();
                    
                    // Drawing the range now that we have everything we need
                    rangeVisual.setBounds(center.x - radius, center.y-radius, radius*2, radius*2);
                }
                else{
                    placement.setBorder(null);
                }
            }
        }
        
        
        
        
        // ================================== IN SELECTION MODE ====================================
        
        else if(selectionMode){
            // If we are hovering over a tower, clear the visuals of everything
            if(targetPlacement.getIcon() != null){
                highlightPlacement(null);
                return;
            }
            // Give selected panel the BORDER and the RANGE VISUAL, everything else set to NORMAL
            Point center;
            int radius;
            for(JLabel placement : allPlacements){
                if(placement == targetPlacement && placement.getIcon() == null){
                    placement.setBorder(BorderFactory.createSoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

                    // Saving the center of this placement to draw the range
                    center = new Point(placement.getX()+placement.getWidth()/2,
                                       placement.getY()+placement.getHeight()/2);

                    // Saving the range of the tower we are buying to draw the range
                    if(savedButton == buyTower1Button) 
                        radius = TOWER1_RANGE_LIST[0];
                    else if(savedButton == buyTower2Button)
                        radius = TOWER2_RANGE_LIST[0];
                    else if(savedButton == buyTower3Button)
                        radius = TOWER3_RANGE_LIST[0];
                    else 
                        radius = TOWER4_RANGE_LIST[0];

                    // Drawing the range now that we have everything we need
                    rangeVisual.setBounds(center.x - radius, center.y-radius, radius*2, radius*2);
                }
                else{
                    placement.setBorder(null);
                }
            }
        }
        
        
        
        // ================================ NOT IN SELECTION MODE ===============================
        else{
            // If menu is open do not show the background range 
            if(menu.getY() == 40 || upgradeMenu.isVisible())
                return;
            // Hovering over a tower -> show the range of the tower
            if(targetPlacement.getIcon() != null){
                Point center = new Point(targetPlacement.getX() + targetPlacement.getWidth()/2,
                                         targetPlacement.getY() + targetPlacement.getHeight()/2);
                int towerRange = getTower(targetPlacement).getRange();
                rangeVisual.setBounds(center.x-towerRange, center.y-towerRange, towerRange*2, towerRange*2);
            }

            // Hovering over a NON-TOWER placement, hide the range visual
            else{
               rangeVisual.setBounds(-10,-10,10,10);
            }
        }
    }
    
    
    public void placementClicked(JLabel placementClicked){
        // Return if the message panel is showing, treating this as a pause section
        if(messagePanel.isVisible())
            return;
        
        
        // ================= VALID SELECTION MODE CHOICE ========================
        if(selectionMode && placementClicked.getBorder() != null){
            buyTowerOfficially(savedButton, placementClicked);
            selectionMode = false;
            menu.setLocation(0,40); // Open menu back up
            menuButton.setText("Close Menu"); // Changing back to change menu
            return;
        }    
        
        // ================= VALID MOVING TOWER MODE CHOICE =======================
        if(movingTowerMode && placementClicked.getBorder() != null){
            // Collecting information with information we have
            JLabel oldPlacement = savingPlacement;
            JLabel newPlacement = placementClicked;
            Tower movingTower = getTower(oldPlacement);
            
            
            // Moving the tower
            newPlacement.setIcon(oldPlacement.getIcon()); // Setting new placement with the icon of the old
            oldPlacement.setIcon(null);                   // Setting the old placement with no icon
            movingTower.moveTower(placementClicked);      // Change the placement we have saved inside tower
            movingTowerMode = false;                      // Go back to regular mode
            
            // Showing again the upgrade menu of this tower
            savingPlacement = newPlacement;               // Changing this to the new placement so that upgradeMenu can work
            upgradeMenu.setVisible(true);                 // All data here should work now
            menuButton.setText("Close Upgrades");
            
            // Charging the custoemr
            int cost = getCostOfTower(movingTower)/MOVE_COST_FACTOR;
            cash -= cost;
            cashText.setText(Integer.toString(cash));
        }
        
        
        // =================== TOWER CLICKCED --> OPENING UPGRADES MENU =====================================
        else if(placementClicked.getIcon() != null && !selectionMode && !movingTowerMode){
            Tower targetTower = getTower(placementClicked);          // Getting the tower using the placementClicked
            if(targetTower == null) return;                          // If this is null, then we just return, better safe than sorry
            
            
            // Update the UPGRADE MENU
            upgradeTower.setIcon(placementClicked.getIcon());                        // Updating the chosen tower
            upgradeDescription.setText(ALL_DESCRIPTIONS[targetTower.getTowerType()-1]); // Update the description
            cat1Progress.setValue(targetTower.getcat1Level() * 33);                  // Updating cat 1 
            cat2Progress.setValue(targetTower.getcat2Level() * 33);                  // Updating cat 2 
            cat3Progress.setValue(targetTower.getcat3Level() * 33);                  // Updating cat 3 
            savingPlacement = placementClicked;                                      // Saving the placement here so that we can use later
            
            
            // Showing the prices in the UPGRADE MENU with the value of the NEXT upgrade!! (I had to make another function for this) UPDATE: wow this is complicated, but it just changes between the two possible messages
            cat1Progress.setString(targetTower.getNextUpgradeCost(1) == -1 ? "FULLY UPGRADED" : "COST: $ " + Integer.toString(targetTower.getNextUpgradeCost(1)));
            cat2Progress.setString(targetTower.getNextUpgradeCost(2) == -1 ? "FULLY UPGRADED" : "COST: $ " + Integer.toString(targetTower.getNextUpgradeCost(2)));
            cat3Progress.setString(targetTower.getNextUpgradeCost(3) == -1 ? "FULLY UPGRADED" : "COST: $ " + Integer.toString(targetTower.getNextUpgradeCost(3)));
            
            
            // Update the MENU BUTTON and hide the MENU
            menuButton.setText("Close Upgrades"); // Change button to be a close button
            menu.setLocation(0,535);              // Hide in case its not
            
            
            // Show the UPGRADE MENU
            upgradeMenu.setVisible(true);         // Show the upgrade menu
        }
    }
    
    public void messageContinueButtonClicked(){
        // Hide message and start the cash timer 
        messagePanel.setVisible(false); 
        cashFlashTimer.start();
    }
    
    // NEXT ROUND BUTTON ===================================================================================
    // THE FUN PART!! well almost lmao, here is when the user starts the match!!
    // NOTE: This is also the first time that the user starts the game so keep watch at that on how this reacts 
    public void nextRoundButtonClicked(){
        // Return if the message panel is showing, treating this as a pause section
        if(messagePanel.isVisible())
            return;
        
        // Personal prefrence, Do not allow the user to start another round until the gift animation finished
        if(cashFlashTimer.isRunning())
            return;
        
        // Increasing to next round
        currentRound++; 
        
        
        
        // Making the enemy harder by giving them more health
        if(currentRound == ENEMY_DIF_BOUNDARY_1){
            spawningEnemyHealth = spawningEnemyHealth  * 2;
            cashGift = CASH_GIFT_LIST[0]; // Giving money because game was "too hard" as my testers said
        }
        else if(currentRound >= ENEMY_DIF_BOUNDARY_2 && currentRound < ENEMY_DIF_BOUNDARY_3 && (currentRound % 5 == 0)){
            spawningEnemyHealth = spawningEnemyHealth  * 2;
            cashGift = CASH_GIFT_LIST[1]; // Giving money because game was "too hard" as my testers said
        }
        else if(currentRound >= ENEMY_DIF_BOUNDARY_3 && currentRound < ENEMY_DIF_BOUNDARY_4){ // TESTING PHASE SHOWS THAT NOBODY MAKES IT PAST HERE, but keep like this bc it ISSS possible (i think)
            spawningEnemyHealth = (int)((double)spawningEnemyHealth  * 1.3); // Lowered down ratio because again testers said it was too hard
            cashGift = CASH_GIFT_LIST[2]; // Giving money because game was "too hard" as my testers said
        }
        
        // Yeah this is just unfair, but I need to end the game somehow, exponent on an exponent on a linear ... weirddddd
        else if(currentRound >= ENEMY_DIF_BOUNDARY_4){
            int multiple = currentRound - (ENEMY_DIF_BOUNDARY_4-5);
            spawningEnemyHealth = spawningEnemyHealth * multiple;
            cashGift = CASH_GIFT_LIST[3]; // Giving money because game was "too hard" as my testers said
        }
        
        // Adding the amount of needed enemies
        for(int i = 0; i < (currentRound*ENEMIES_PER_ROUND); i++){
            JLabel sendingHitBox = new JLabel();                     // ERROR: we need to set its parent to game box!!
            sendingHitBox.setLocation(ENEMY_SPAWN_X, ENEMY_SPAWN_Y); // Moving the object to the spawn location
            sendingHitBox.setSize(ENEMY_SIZE, ENEMY_SIZE);           // Setting the hit boxes to fit on in the size of the path 
            sendingHitBox.setIcon(enemyExample.getIcon());           // Setting up the icon of this hitBox
            
            
            // Adding this to the gameBox
            gameBox.add(sendingHitBox);                    // Settting the parent-child relationship
            gameBox.setComponentZOrder(sendingHitBox, 0);  // Moving it to the very top
            gameBox.repaint();                             // Repainting the gamebox
            
            
            
                
            Enemy sendingEnemy = new  Enemy(sendingHitBox, currentRound, 
                                            spawningEnemyHealth, ENEMY_HEALTH_INCREASE,  
                                            ENEMY_STARTING_DAMAGE, ENEMY_DAMAGE_INCREASE, allLines.get(0));
            
            // Saving the object into the array that we have currently
            allEnemies.add(sendingEnemy);
        }
        
        
        // Moving up the menu and upgrade menu so taht we can see it above the enemies
        bringMenusUp();
        
        allEnemies.get(0).setIsMoving();   // Setting the first enemy to moving so it can go
        lastSentEnemy = 0;                 // Setting to 1 so that we can send the next one
        nextRoundButton.setVisible(false); // Hiding the button until next round
        enemiesLeftBar.setMaximum(currentRound*ENEMIES_PER_ROUND); // Setting the max as the enemies left to kill
        enemiesLeftBar.setValue(currentRound*ENEMIES_PER_ROUND);   // Filling up the bar to the max!
        currentRoundStat.setText(Integer.toString(currentRound));
        
        
        for(Tower currTower : allTowers) // Resetting the reload so that tower can shoot again
            currTower.resetReload();
        
        roundClock.start();                // Starting the game clock finally!!!
    }
    // ======================================================================================================
    
    
    
    // =================================================================================================================================================
    // MAIN CLOCK TIMERS FOR THE GAME ==================================================================================================================
    // =================================================================================================================================================
    
    // GAME CLOCK ===========================
    public void stopGame(){
        if(roundClock.isRunning()) roundClock.stop();
        if(cashFlashTimer.isRunning()) cashFlashTimer.stop();
    }
    
    // Timer for the visual of flashing the cash when we are gifiting to player
    Timer cashFlashTimer = new Timer(CASH_GIFT_TICK, x->{
        // Ending the loop when we are done with the transfer
        if(cashGift <= 0){
            ((Timer)x.getSource()).stop();
            cashText.setForeground(WHITE_COLOR);
            cashGift = 0;
            return;
        }

        // Moving money from the cashGift to the cash and showing
        int interval = 5000;
        cashGift -= interval;
        cash += interval;
        cashText.setText(Integer.toString(cash));

        // Cycling the colors until we reach the top color
        if(cashText.getForeground() == WHITE_COLOR)
            cashText.setForeground(GREEN_COLOR);
        else
            cashText.setForeground(WHITE_COLOR);
    });
    
    Timer roundClock = new Timer(ROUND_TICK, e->{
        
        // Checking if we need to change the tick speed
        Timer thisTimer = ((Timer)e.getSource());
        if(thisTimer.getDelay() == ROUND_TICK && fastFoward){
            thisTimer.setDelay(ROUND_FAST_TICK);
            thisTimer.restart();
        }
        else if(thisTimer.getDelay() == ROUND_FAST_TICK && !fastFoward){
            thisTimer.setDelay(ROUND_TICK);
            thisTimer.restart();
        }
        
    
        
        // GAME HAS ENDED!! =================================================================
        if(castleHealth.getValue() <= 0){
            // Stopping and Cleaning game
            ((Timer)e.getSource()).stop();        // Stop the timer
            removeAllProjectiles();               // Remove all projectiles for next game
            removeAllEnemies();                   // Remove all enemies for next game
            removeAllLightning();                 // Removes any left lightning 
            
            
            
            // Setting Game Ending Cover
            int points = (int)(enemiesKilled/2) + currentRound;          // Simple equation for calculting the points user earned
            roundDiedAt.setText(Integer.toString(currentRound));         // Setting the round we died at
            totalCashMade.setText(Integer.toString(cashMade));           // Setting the total cash we made
            totalEnemiesKilled.setText(Integer.toString(enemiesKilled)); // Setting the total enemies killed
            gameEndedPoints.setText(Integer.toString(points));           // Setting the points calculated into the panel
            
            
            // Reporting the scores and showing the game ended panel
            if(scores_fromOutside.reportScore("CD", currentUser_fromOutside, gameEndedPoints.getText())){ 
                gameEndedHighscoreIndicator.setVisible(true); // This was false originally, but if we set a high score, let the user know
            }
            
            // Switching to Game Ended Cover Frame
            gameBox.setVisible(false);            // Hiding the game
            gameEndedPanel.setVisible(true);      // Showing the game ended panel
        }
       
        // ROUND HAS ENDED!! ===================================================================
        if(enemiesLeft() == 0){
            ((Timer)e.getSource()).stop();    // Stopping the timer
            removeAllEnemies(); 
            removeAllProjectiles();
            removeAllLightning();
            nextRoundButton.setVisible(true); // Showing the next round button again
            enemiesLeftBar.setValue(0);       // Setting to no enemies left
            
            // Check if we are giving user a cash gift for completing a set of rounds
            if(cashGift != 0){
                menu.setLocation(0,535);
                upgradeMenu.setVisible(false);
                menuButton.setText("Open Menu");
                messagePanel.setVisible(true);
            }
        }
        else{
            enemiesLeftBar.setValue(enemiesLeft());
        }
        // ========================================================================================
        
        // Moving the enemies through the map if their isMoving is set to true AND they are still alive (duh lmao)
        for(Enemy currEnemy : allEnemies){
            if(currEnemy.getIsMoving() && currEnemy.isAlive())
                moveEnemy(currEnemy);
        }
        
        // Checking if we need to start moving the next enemy (lastSentEnemy is still in array AND the last enemy is at location to allow ENEMY_SPACING)
        if((lastSentEnemy + 1 < allEnemies.size()) && 
           (allEnemies.get(lastSentEnemy).getX() > ENEMY_SPACING)){ // BUG FIX: checking if the last one is already dead, sent next one
            lastSentEnemy++;                             // Increasing the last sent enemy to show which is moving last and to send in next line
            allEnemies.get(lastSentEnemy).setIsMoving(); // Setting this new one to moving now
        }
        
        // Double check that there are enemies on the board, if there are not AND there are enemies left then send next
        else if(!enemiesWalking() && lastSentEnemy + 1 < allEnemies.size()){
            lastSentEnemy++;
            allEnemies.get(lastSentEnemy).setIsMoving();
        }
        
        
        
        // Updating every tower -> finding a new target and returning if we can shoot!
        for (Tower tower : allTowers) {
            // If we can shoot, create a new projectile and set the start and stop of it for direction,
            // also put it on top of everything so that we can see it on the paths
            boolean canShoot = tower.update(allEnemies);
            int towerType = tower.getTowerType();
            if (canShoot){
                
                
                switch (towerType) {
                    // Tower 1 shoots the <ability> amount of projectiles
                    case 1 -> {
                        Projectile currPro = new Projectile(tower, towerType, tower.getCurrentTarget(), tower.getPower(), TOWER1_PROJECTILE_STEP,
                                tower.getProjectileColor(), gameBox, menu, upgradeMenu, bottomBar, rangeVisual);
                        allProjectiles.add(currPro);
                        gameBox.add(currPro.getSprite());
                        gameBox.setComponentZOrder(currPro.getSprite(), 0);
                        bringMenusUp();
                        // Adding all the other ones slowly -> also checks if target is dead before making new ones so that we dont get a runtime crash, very very important lmao
                        for(int i = 0; i < tower.getAbility()-1; i++){
                            int spawnTime = i+1 * TOWER1_PROJECTILE_SPACING; // since i is 0 at first, set to 1, then multiply by the wait that we set in main variables
                            Timer temp = new Timer(spawnTime, x->{
                                ((Timer)x.getSource()).stop();
                                if(tower.getCurrentTarget() != null){
                                    Projectile timedProjectile = new Projectile(tower, towerType, tower.getCurrentTarget(), tower.getPower(), TOWER1_PROJECTILE_STEP,
                                            tower.getProjectileColor(), gameBox, menu, upgradeMenu, bottomBar, rangeVisual);
                                    allProjectiles.add(timedProjectile);
                                    gameBox.add(timedProjectile.getSprite());
                                    gameBox.setComponentZOrder(timedProjectile.getSprite(), 0);
                                    bringMenusUp();
                                }
                            });
                            temp.start();
                        }
                    }
                    // Tower 2 and 3 shoot regular projectiles ONE time
                    case 2, 3 -> {
                        int projectileStep = (towerType == 2 || towerType == 4 ? TOWER2_PROJECTILE_STEP : TOWER3_PROJECTILE_STEP);
                        Projectile newProjectile = new Projectile(tower, towerType, tower.getCurrentTarget(), tower.getPower(), projectileStep,
                                tower.getProjectileColor(), gameBox, menu, upgradeMenu, bottomBar, rangeVisual);
                        allProjectiles.add(newProjectile);
                        gameBox.add(newProjectile.getSprite());
                        gameBox.setComponentZOrder(newProjectile.getSprite(), 0);
                        bringMenusUp();
                    }
                    
                    // Tower 4 shoots one of each projectile type
                    case 4 -> {
                        // Making projectile for regular (JSUT 1 FOR THIS TOWER)
                        Projectile projectile1 = new Projectile(tower, 1, tower.getCurrentTarget(), tower.getPower(), TOWER1_PROJECTILE_STEP,
                                TOWER1_PROJECTILE_COLOR, gameBox, menu, upgradeMenu, bottomBar, rangeVisual);
                        // Making the projectile for shocking tower
                        Projectile projectile2 = new Projectile(tower, 2, tower.getCurrentTarget(), tower.getPower(), TOWER2_PROJECTILE_STEP,
                                TOWER2_PROJECTILE_COLOR, gameBox, menu, upgradeMenu, bottomBar, rangeVisual);
                        // Making the projectile for the missle tower
                        Projectile projectile3 = new Projectile(tower, 3, tower.getCurrentTarget(), tower.getPower(), TOWER3_PROJECTILE_STEP,
                                TOWER3_PROJECTILE_COLOR, gameBox, menu, upgradeMenu, bottomBar, rangeVisual);
                        allProjectiles.add(projectile1);
                        allProjectiles.add(projectile2);
                        allProjectiles.add(projectile3);
                        gameBox.add(projectile1.getSprite());
                        gameBox.add(projectile2.getSprite());
                        gameBox.add(projectile3.getSprite());
                        gameBox.setComponentZOrder(projectile2.getSprite(), 0);
                        gameBox.setComponentZOrder(projectile3.getSprite(), 0);
                        gameBox.setComponentZOrder(projectile1.getSprite(), 0); // Addding this one last so that it can be the upmost one
                        bringMenusUp();
                    }
                    
                    default -> {}
                }
                
            }
        }

        
        
        // Update all projectiles -> move the projectile and check if we hit:
        //                           If we KILLED in process, bring down the enemies left
        //                           If we HIT, then remove the projectile
        for (int i = 0; i < allProjectiles.size(); i++) {
            Projectile currentProjectile = allProjectiles.get(i);
            
            // Moves the projectile and also sets the isActive to false if it already made impact
            int enemiesKilledWithProjectile = currentProjectile.update(allEnemies); // Saving if this update killed enemies and how many
            if(enemiesKilledWithProjectile > 0){                      // If it kiled enemies
                int cashMadeThisUpdate = CASH_PER_KILL * enemiesKilledWithProjectile; // Finding out how much cash is made this update
                cash += cashMadeThisUpdate;                           // Give cash to the amount of enemies killed
                cashText.setText(Integer.toString(cash));             // Update the text on bottom right of the cash
                cashMade += cashMadeThisUpdate;                       // Updating the running count of the cash made
                cashMadeStat.setText(Integer.toString(cashMade));     // Updating the running count visually
                enemiesKilled += enemiesKilledWithProjectile;         // Update the amount of enemies that were killed
                enemiesKilledStat.setText(Integer.toString(enemiesKilled)); // Updating the stat visual amount
            }
                    
            // If last move made us hit, then remove the projectile
            if (!currentProjectile.isActive()) {
                gameBox.remove(currentProjectile.getSprite());
                allProjectiles.remove(i);
                i--;
            }
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
        
        switch (currentLineIndex) {
            // If the current line is a horz, check if we need to hop to the next vert. one
            case 0, 2, 4 -> {
                if(targetEnemy.getX() == allLines.get(currentLineIndex+1).getX())
                    targetEnemy.setLine(allLines.get(currentLineIndex+1));
            }
            
            // If the current line is a vert, check if we need to hop to the next horz. one
            case 1, 3 -> {
                if(targetEnemy.getY() == allLines.get(currentLineIndex+1).getY())
                    targetEnemy.setLine(allLines.get(currentLineIndex+1));
            }
            
            // If the object is on the LAST LINE, check if it has hit the castle
            case 5 -> {
                if(targetEnemy.getY()+ENEMY_SIZE >= castle.getY()){                          // If the object bottom is greater or equal to castle y, then it made impact
                    castleHealth.setValue(castleHealth.getValue() - targetEnemy.getDamage()); // Damaging the castle with this enemy health
                    castleHealthStat.setText(Integer.toString(castleHealth.getValue()) + "/" + CASTLE_HEALTH); // Updating the castle health visually in the stat
                    targetEnemy.getHitBox().setVisible(false);                                // Hide it temp, we will remove it after this round ends
                    targetEnemy.kill();                                                       // Change the status to dead x.x
                    enemiesLeftBar.setValue(enemiesLeftBar.getValue() - 1);                   // Showing that there is one less enemy
                    return;                                                                   // Return since we are not moving this object later
                }
            }
            default -> {
                System.out.println("ERORR: Entered into error state of moveEnemy()");
                return;
            }
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
    
    private boolean enemiesWalking(){
        for(Enemy currEnemy : allEnemies){
            if(currEnemy.isAlive() && currEnemy.getIsMoving())
                return true;
        }
        return false;
    }
    
    private void bringMenusUp(){
        gameBox.setComponentZOrder(rangeVisual, 0);
        gameBox.setComponentZOrder(menu, 0);
        gameBox.setComponentZOrder(upgradeMenu, 0);
        gameBox.setComponentZOrder(bottomBar, 0);
        gameBox.setComponentZOrder(messagePanel,0);
    }
    
    private Tower getTower(JLabel targetPlacement){
        for(Tower currTower : allTowers){
            if(currTower.getPlacement() == targetPlacement)
                return currTower;
        }
        return null; // Just in case
    }
    
    private int getCostOfTower(Tower target){
        switch(target.getTowerType()){
            case 1 -> {return TOWER1_COST;}
            case 2 -> {return TOWER2_COST;}
            case 3 -> {return TOWER3_COST;}
            case 4 -> {return TOWER4_COST;}
            default ->{
                System.out.println("ERROR AT: getCostOfTower():");
                return -1;
            }
        }
    }
    
    private void buyTowerOfficially(JButton buttonOfTower, JLabel placementClicked){
        // Remove the range visual that we made when we were hovering over things
        rangeVisual.setBounds(-10,-10,10,10);
        
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
            projectileColor = TOWER3_PROJECTILE_COLOR; // This is never used because we actually ignore it for this tower
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
        
        // Closing the menu
        menuButton.setText("Open Menu");
        menu.setLocation(0,535); 
        
        // Updating the cash on the bottom right
        cashText.setText(Integer.toString(cash));
    }
    
    
    
    
    
    private void flashButton(JButton targetButton, Color regularColor){
        flashingButton = targetButton;  // Saving the target button so lambda can use it 
        flashingCounter = 0;            // Resetting the counter to 0
        flashingButton.setBackground(RED_COLOR); // First flash to feel instant
        Timer tempTimer = new Timer(100, e->{
            flashingCounter++;                               // Increasing count
            if(flashingCounter >= FLASH_AMOUNT){                        // If >6, then stop and set back to normal
                ((Timer)e.getSource()).stop();
                flashingButton.setBackground(regularColor);
            }
            else{                                            // If not, then continue bouncing
                if(flashingCounter % 2 != 0)
                    flashingButton.setBackground(regularColor);
                else
                    flashingButton.setBackground(RED_COLOR);
            }
        });
        tempTimer.start();
    }
    
    // Used to set up the current user and high score manager for this game
    public void setScore_fromOutside(HighscoreManager inputScores, String inputUser){
        scores_fromOutside = inputScores;
        currentUser_fromOutside = inputUser;
    }
}
