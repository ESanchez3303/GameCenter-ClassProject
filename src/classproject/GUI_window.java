/**
 *
 * @author Emanuel
 */



package classproject;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class GUI_window extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUI_window.class.getName());
    public GUI_window() {
        initComponents();
        
        passwordInput.addActionListener(e -> {
            loginButtonPressed();
        });
        
        // ============================================================================================================
        // ============================================ SETTING UP CLASSES ============================================
        // ============================================================================================================
        // Setting up Game 1: -----------------------------------------------------------------------
        List<JLabel> MG_values = new ArrayList<>(Arrays.asList(
            G1_cardValue1, G1_cardValue2, G1_cardValue3, G1_cardValue4, G1_cardValue5, G1_cardValue6,
            G1_cardValue7, G1_cardValue8, G1_cardValue9, G1_cardValue10, G1_cardValue11, G1_cardValue12,
            G1_cardValue13, G1_cardValue14, G1_cardValue15, G1_cardValue16, G1_cardValue17, G1_cardValue18
        ));

        List<JLabel> MG_images = new ArrayList<>(Arrays.asList(
            G1_cardImage1, G1_cardImage2, G1_cardImage3, G1_cardImage4, G1_cardImage5, G1_cardImage6,
            G1_cardImage7, G1_cardImage8, G1_cardImage9, G1_cardImage10, G1_cardImage11, G1_cardImage12,
            G1_cardImage13, G1_cardImage14, G1_cardImage15, G1_cardImage16, G1_cardImage17, G1_cardImage18
        ));

        MG.setUp(MG_values, MG_images, G1_score, MG_timerBar, MG_disableCover, MG_startButton, G1_score);
        game1Frame.setComponentZOrder(MG_disableCover, 0); // Moving up frames
        MG_disableCover.setBackground(new Color(175, 157, 136, 128)); // // Color Frames: semi-transparent main color 
        // -------------------------------------------------------------------------------------------
        

        // Setting up Game 2: ------------------------------------------------------------------------
        DB_player1TopIcon.setText(DB.getP1Icon()); // Setting up the icons on the top for the players
        DB_player2TopIcon.setText(DB.getP2Icon()); // Setting up the icons on the top for the players
        List<JPanel> DB_lines = new ArrayList<>(Arrays.asList(
                DB_1,DB_2,DB_3,DB_4,DB_5,DB_6,DB_7,DB_8,DB_9,DB_10,DB_11,DB_12,DB_13,DB_14,DB_15,DB_16,DB_17,DB_18,DB_19,DB_20,DB_21,
                DB_22,DB_23,DB_24,DB_25,DB_26,DB_27,DB_28,DB_29,DB_30,DB_31,DB_32,DB_33,DB_34,DB_35,DB_36,DB_37,DB_38,DB_39,DB_40,DB_41,
                DB_42,DB_43,DB_44,DB_45
        ));
        List<JLabel> DB_boxes = new ArrayList<>(Arrays.asList(
                DB_b1, DB_b2, DB_b3, DB_b4, DB_b5, DB_b6, DB_b7, DB_b8, DB_b9, DB_b10, DB_b11, DB_b12, DB_b13, DB_b14, DB_b15, DB_b16, DB_b17, DB_b18
        ));
        DB.setUp(G2_player1, G2_player2, DB_lines, DB_boxes);
        // -------------------------------------------------------------------------------------------
        

        // Setting up Game 3: ------------------------------------------------------------------------
        PP_gameDescription.setText(PP_gameDescription.getText() + Integer.toString(PP.getGameTime()) + " Seconds");            // Sets up the description of the game 
        G3_gameDescription2.setText(G3_gameDescription2.getText() + Integer.toString(PP.getGameTime()) + " Seconds");          // Sets up the description of the game
        PP.setUp(PP_player, PP_computer, PP_ball, PP_playerScore, PP_computerScore, PP_countDownTimer, 
                PP_pointsPanel, PP_timerBar, PP_countDownTimer, PP_pointsPanel, PP_resetCover);
        
        // -------------------------------------------------------------------------------------------
        
        
        // Setting up Game 4: ------------------------------------------------------------------------
        T.setUp(T_mapItem1, T_mapItem2, T_mapItem3, T_player1, T_player2, T_player1Lifes, T_player2Lifes,
                T_gasBar, T_ball, T_gameBox, T_powerBar, T_floorLine, T_matchCover, T_matchWinnerText,
                T_player1Score, T_player2Score, T_explosion, T_player1Indicator, T_player2Indicator);
        // -------------------------------------------------------------------------------------------
        
        
        // Setting up Game 5: ------------------------------------------------------------------------
        JPanel[] floors = {TA_floor0,TA_floor1,TA_floor2,TA_floor3,TA_floor4,TA_floor5,TA_floor6,
                           TA_floor7,TA_floor8,TA_floor9,TA_floor10,TA_floor11,TA_floor12, TA_floor13 };
        
        TA.setUp(TA_player1, TA_player2, TA_boost1, TA_boost2, floors, TA_gameBox, 
                TA_player1Indicator, TA_player2Indicator, TA_player1Time, TA_player2Time,
                TA_choosePlayerPanel, TA_startingPlayer);
        
        
        JSpinner[] TA_spinners = {TA_maxTaggerTime, TA_runnerSpeed, TA_taggerSpeed, TA_timeFrozen, 
                                 TA_boostedSpeed, TA_boostRespawnTime, TA_boostedTime};
        for(JSpinner currentSpinner : TA_spinners){
            // Set the minimum of all spinners
            SpinnerNumberModel currSpinnerNumberModel = (SpinnerNumberModel) currentSpinner.getModel();
            currSpinnerNumberModel.setMinimum(0);
        }
        
        // Changing the gravity spinner to be a double spinner
        TA_gravity.setModel(new SpinnerNumberModel(0, 0, 100, 0.1));

        // Format to show one decimal place
        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(TA_gravity, "0.0");
        TA_gravity.setEditor(editor);
        // -------------------------------------------------------------------------------------------
        
        
        
        // Setting up Game 6: ------------------------------------------------------------------------
        
        // Making the **HUGEEE** list of panels that we have to send into game 6
        JLabel[] placements = {
            CD_placement1,CD_placement2,CD_placement3,CD_placement4,CD_placement5,CD_placement6,CD_placement7,
            CD_placement8,CD_placement9,CD_placement10,CD_placement11,CD_placement12,CD_placement13,CD_placement14,
            CD_placement15,CD_placement16,CD_placement17,CD_placement18,CD_placement19,CD_placement20,CD_placement21,
            CD_placement22,CD_placement23,CD_placement24,CD_placement25,CD_placement26,CD_placement27,CD_placement28,
            CD_placement29,CD_placement30,CD_placement31,CD_placement32,CD_placement33,CD_placement34,CD_placement35,
            CD_placement36,CD_placement37,CD_placement38,CD_placement41,CD_placement42,CD_placement43,CD_placement44,
            CD_placement45,CD_placement46,CD_placement47,CD_placement48,CD_placement49,CD_placement50,CD_placement51,
            CD_placement52,CD_placement53,CD_placement54,CD_placement55,CD_placement56,CD_placement57,CD_placement58,
            CD_placement59,CD_placement60,CD_placement61,CD_placement62,CD_placement63,CD_placement64,CD_placement65,
            CD_placement66,CD_placement67,CD_placement68,CD_placement69,CD_placement70,CD_placement71,CD_placement72,
            CD_placement73,CD_placement74,CD_placement77,CD_placement78,CD_placement79,CD_placement80,CD_placement81,
            CD_placement82,CD_placement83,CD_placement84,CD_placement85,CD_placement86,CD_placement87,CD_placement88,
            CD_placement89,CD_placement90,CD_placement91,CD_placement92,CD_placement93,CD_placement94,CD_placement95,
            CD_placement96,CD_placement97,CD_placement98,CD_placement99,CD_placement100,CD_placement101,CD_placement102,
            CD_placement103,CD_placement104,CD_placement105,CD_placement106,CD_placement107,CD_placement108,CD_placement111,
            CD_placement112,CD_placement113,CD_placement114,CD_placement115,CD_placement116,CD_placement117,CD_placement118,
            CD_placement119,CD_placement120,CD_placement121,CD_placement122,CD_placement123,CD_placement124,CD_placement125,
            CD_placement126,CD_placement127,CD_placement128,CD_placement129,CD_placement130,CD_placement131,CD_placement132,
            CD_placement133,CD_placement134,CD_placement135,CD_placement136,CD_placement137,CD_placement138,CD_placement139,
            CD_placement140,CD_placement145
        };
        JPanel[] lines = {CD_path1, CD_path2, CD_path3, CD_path4, CD_path5, CD_path6};
        
        // Send it allllllllllllllllll in!!!
        CD.setUp(placements, CD_buyTower1Button, CD_buyTower2Button, CD_buyTower3Button, CD_buyTower4Button,
                 CD_menu, CD_menuButton, CD_buyTower1, CD_buyTower2, CD_buyTower3, CD_buyTower4, CD_cash,
                 CD_castleHealth, CD_upgradeMenu, CD_cat1Button, CD_cat2Button, CD_cat3Button, CD_cat1ProgressBar,
                 CD_cat2ProgressBar, CD_cat3ProgressBar, CD_upgradeTower, CD_upgradeDescription, CD_enemiesLeftBar, 
                 CD_nextRoundButton, CD_enemyExample, CD_gameBox, lines, CD_castle, CD_bottomBar, CD_currentRoundStat,
                 CD_enemiesKilledStat, CD_pointsStat, CD_cashMadeStat, CD_gameEndedPanel, CD_gameEndedPoints,
                 CD_gameEndedHighscoreIndicator, CD_gameDescription, CD_upgradeMoveButton, 
                 CD_roundDiedAt, CD_totalEnemiesKilled, CD_cashMade, CD_messagePanel, CD_highscoreStat, 
                 CD_fastFowardButton, CD_cashSymbol);
        CD_coverDes1.setText(CD.getAllDescriptions()[0]);
        CD_coverDes2.setText(CD.getAllDescriptions()[1]);
        CD_coverDes3.setText(CD.getAllDescriptions()[2]);
        CD_coverDes4.setText(CD.getAllDescriptions()[3]);
        // -------------------------------------------------------------------------------------------
        
        
        
        // Switching into frame once everything is finished:
        switchFrame(loginFrame);
        
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        MM_topBar = new javax.swing.JPanel();
        MM_username = new javax.swing.JLabel();
        MM_userSettingsButton = new javax.swing.JButton();
        MM_logOutButton = new javax.swing.JButton();
        MM_backToMenuButton = new javax.swing.JButton();
        game1Frame = new javax.swing.JPanel();
        MG_gameArea = new javax.swing.JPanel();
        G1_card1 = new javax.swing.JPanel();
        G1_cardValue1 = new javax.swing.JLabel();
        G1_cardImage1 = new javax.swing.JLabel();
        G1_card2 = new javax.swing.JPanel();
        G1_cardValue2 = new javax.swing.JLabel();
        G1_cardImage2 = new javax.swing.JLabel();
        G1_card3 = new javax.swing.JPanel();
        G1_cardValue3 = new javax.swing.JLabel();
        G1_cardImage3 = new javax.swing.JLabel();
        G1_card4 = new javax.swing.JPanel();
        G1_cardValue4 = new javax.swing.JLabel();
        G1_cardImage4 = new javax.swing.JLabel();
        G1_card5 = new javax.swing.JPanel();
        G1_cardValue5 = new javax.swing.JLabel();
        G1_cardImage5 = new javax.swing.JLabel();
        G1_card6 = new javax.swing.JPanel();
        G1_cardValue6 = new javax.swing.JLabel();
        G1_cardImage6 = new javax.swing.JLabel();
        G1_card7 = new javax.swing.JPanel();
        G1_cardValue7 = new javax.swing.JLabel();
        G1_cardImage7 = new javax.swing.JLabel();
        G1_card8 = new javax.swing.JPanel();
        G1_cardValue8 = new javax.swing.JLabel();
        G1_cardImage8 = new javax.swing.JLabel();
        G1_card9 = new javax.swing.JPanel();
        G1_cardValue9 = new javax.swing.JLabel();
        G1_cardImage9 = new javax.swing.JLabel();
        G1_card10 = new javax.swing.JPanel();
        G1_cardValue10 = new javax.swing.JLabel();
        G1_cardImage10 = new javax.swing.JLabel();
        G1_card11 = new javax.swing.JPanel();
        G1_cardValue11 = new javax.swing.JLabel();
        G1_cardImage11 = new javax.swing.JLabel();
        G1_card12 = new javax.swing.JPanel();
        G1_cardValue12 = new javax.swing.JLabel();
        G1_cardImage12 = new javax.swing.JLabel();
        G1_card13 = new javax.swing.JPanel();
        G1_cardValue13 = new javax.swing.JLabel();
        G1_cardImage13 = new javax.swing.JLabel();
        G1_card14 = new javax.swing.JPanel();
        G1_cardValue14 = new javax.swing.JLabel();
        G1_cardImage14 = new javax.swing.JLabel();
        G1_card15 = new javax.swing.JPanel();
        G1_cardValue15 = new javax.swing.JLabel();
        G1_cardImage15 = new javax.swing.JLabel();
        G1_card16 = new javax.swing.JPanel();
        G1_cardValue16 = new javax.swing.JLabel();
        G1_cardImage16 = new javax.swing.JLabel();
        G1_card17 = new javax.swing.JPanel();
        G1_cardValue17 = new javax.swing.JLabel();
        G1_cardImage17 = new javax.swing.JLabel();
        G1_card18 = new javax.swing.JPanel();
        G1_cardValue18 = new javax.swing.JLabel();
        G1_cardImage18 = new javax.swing.JLabel();
        MG_disableCover = new javax.swing.JPanel();
        MG_timeBoard = new javax.swing.JPanel();
        MG_timerBar = new javax.swing.JProgressBar();
        MG_startButton = new javax.swing.JButton();
        MG_scoreBoard = new javax.swing.JPanel();
        G1_score = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        game6Frame = new javax.swing.JPanel();
        CD_gameBox = new javax.swing.JPanel();
        CD_messagePanel = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        CD_messageText = new javax.swing.JLabel();
        CD_messageContinueButton = new javax.swing.JButton();
        CD_bottomBar = new javax.swing.JPanel();
        CD_menuButton = new javax.swing.JButton();
        CD_cashSymbol = new javax.swing.JLabel();
        CD_cash = new javax.swing.JLabel();
        CD_castleHealth = new javax.swing.JProgressBar();
        CD_enemiesLeftBar = new javax.swing.JProgressBar();
        CD_menu = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        CD_buyTower1 = new javax.swing.JLabel();
        CD_buyTower2 = new javax.swing.JLabel();
        CD_buyTower3 = new javax.swing.JLabel();
        CD_buyTower4 = new javax.swing.JLabel();
        CD_buyTower1Button = new javax.swing.JButton();
        CD_buyTower2Button = new javax.swing.JButton();
        CD_buyTower3Button = new javax.swing.JButton();
        CD_buyTower4Button = new javax.swing.JButton();
        jLabel135 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        CD_enemiesKilledStat = new javax.swing.JLabel();
        CD_currentRoundStat = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        CD_highscoreStat = new javax.swing.JLabel();
        CD_cashMadeStat = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        CD_pointsStat = new javax.swing.JLabel();
        CD_upgradeMenu = new javax.swing.JPanel();
        CD_cat2Button = new javax.swing.JButton();
        CD_cat1Button = new javax.swing.JButton();
        CD_cat3Button = new javax.swing.JButton();
        CD_upgradeSellButton = new javax.swing.JButton();
        CD_cat1ProgressBar = new javax.swing.JProgressBar();
        CD_cat2ProgressBar = new javax.swing.JProgressBar();
        CD_cat3ProgressBar = new javax.swing.JProgressBar();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        CD_upgradeDescription = new javax.swing.JLabel();
        CD_upgradeTower = new javax.swing.JLabel();
        CD_upgradeMoveButton = new javax.swing.JButton();
        CD_path1 = new javax.swing.JPanel();
        CD_path2 = new javax.swing.JPanel();
        CD_path3 = new javax.swing.JPanel();
        CD_path4 = new javax.swing.JPanel();
        CD_path5 = new javax.swing.JPanel();
        CD_path6 = new javax.swing.JPanel();
        CD_lake = new javax.swing.JLabel();
        CD_castle = new javax.swing.JLabel();
        CD_placement1 = new javax.swing.JLabel();
        CD_placement2 = new javax.swing.JLabel();
        CD_placement3 = new javax.swing.JLabel();
        CD_placement4 = new javax.swing.JLabel();
        CD_placement5 = new javax.swing.JLabel();
        CD_placement6 = new javax.swing.JLabel();
        CD_placement7 = new javax.swing.JLabel();
        CD_placement8 = new javax.swing.JLabel();
        CD_placement9 = new javax.swing.JLabel();
        CD_placement10 = new javax.swing.JLabel();
        CD_placement11 = new javax.swing.JLabel();
        CD_placement12 = new javax.swing.JLabel();
        CD_placement13 = new javax.swing.JLabel();
        CD_placement14 = new javax.swing.JLabel();
        CD_placement15 = new javax.swing.JLabel();
        CD_placement16 = new javax.swing.JLabel();
        CD_placement17 = new javax.swing.JLabel();
        CD_placement18 = new javax.swing.JLabel();
        CD_placement19 = new javax.swing.JLabel();
        CD_placement20 = new javax.swing.JLabel();
        CD_placement21 = new javax.swing.JLabel();
        CD_placement22 = new javax.swing.JLabel();
        CD_placement23 = new javax.swing.JLabel();
        CD_placement24 = new javax.swing.JLabel();
        CD_placement25 = new javax.swing.JLabel();
        CD_placement26 = new javax.swing.JLabel();
        CD_placement27 = new javax.swing.JLabel();
        CD_placement28 = new javax.swing.JLabel();
        CD_placement29 = new javax.swing.JLabel();
        CD_placement30 = new javax.swing.JLabel();
        CD_placement31 = new javax.swing.JLabel();
        CD_placement32 = new javax.swing.JLabel();
        CD_placement33 = new javax.swing.JLabel();
        CD_placement34 = new javax.swing.JLabel();
        CD_placement35 = new javax.swing.JLabel();
        CD_placement36 = new javax.swing.JLabel();
        CD_placement37 = new javax.swing.JLabel();
        CD_placement38 = new javax.swing.JLabel();
        CD_placement41 = new javax.swing.JLabel();
        CD_placement42 = new javax.swing.JLabel();
        CD_placement43 = new javax.swing.JLabel();
        CD_placement44 = new javax.swing.JLabel();
        CD_placement45 = new javax.swing.JLabel();
        CD_placement46 = new javax.swing.JLabel();
        CD_placement47 = new javax.swing.JLabel();
        CD_placement48 = new javax.swing.JLabel();
        CD_placement49 = new javax.swing.JLabel();
        CD_placement50 = new javax.swing.JLabel();
        CD_placement51 = new javax.swing.JLabel();
        CD_placement52 = new javax.swing.JLabel();
        CD_placement53 = new javax.swing.JLabel();
        CD_placement54 = new javax.swing.JLabel();
        CD_placement55 = new javax.swing.JLabel();
        CD_placement56 = new javax.swing.JLabel();
        CD_placement57 = new javax.swing.JLabel();
        CD_placement58 = new javax.swing.JLabel();
        CD_placement59 = new javax.swing.JLabel();
        CD_placement60 = new javax.swing.JLabel();
        CD_placement61 = new javax.swing.JLabel();
        CD_placement62 = new javax.swing.JLabel();
        CD_placement63 = new javax.swing.JLabel();
        CD_placement64 = new javax.swing.JLabel();
        CD_placement65 = new javax.swing.JLabel();
        CD_placement66 = new javax.swing.JLabel();
        CD_placement67 = new javax.swing.JLabel();
        CD_placement68 = new javax.swing.JLabel();
        CD_placement69 = new javax.swing.JLabel();
        CD_placement70 = new javax.swing.JLabel();
        CD_placement71 = new javax.swing.JLabel();
        CD_placement72 = new javax.swing.JLabel();
        CD_placement73 = new javax.swing.JLabel();
        CD_placement74 = new javax.swing.JLabel();
        CD_placement77 = new javax.swing.JLabel();
        CD_placement78 = new javax.swing.JLabel();
        CD_placement79 = new javax.swing.JLabel();
        CD_placement80 = new javax.swing.JLabel();
        CD_placement81 = new javax.swing.JLabel();
        CD_placement82 = new javax.swing.JLabel();
        CD_placement83 = new javax.swing.JLabel();
        CD_placement84 = new javax.swing.JLabel();
        CD_placement85 = new javax.swing.JLabel();
        CD_placement86 = new javax.swing.JLabel();
        CD_placement87 = new javax.swing.JLabel();
        CD_placement88 = new javax.swing.JLabel();
        CD_placement89 = new javax.swing.JLabel();
        CD_placement90 = new javax.swing.JLabel();
        CD_placement91 = new javax.swing.JLabel();
        CD_placement92 = new javax.swing.JLabel();
        CD_placement93 = new javax.swing.JLabel();
        CD_placement94 = new javax.swing.JLabel();
        CD_placement95 = new javax.swing.JLabel();
        CD_placement96 = new javax.swing.JLabel();
        CD_placement97 = new javax.swing.JLabel();
        CD_placement98 = new javax.swing.JLabel();
        CD_placement99 = new javax.swing.JLabel();
        CD_placement100 = new javax.swing.JLabel();
        CD_placement101 = new javax.swing.JLabel();
        CD_placement102 = new javax.swing.JLabel();
        CD_placement103 = new javax.swing.JLabel();
        CD_placement104 = new javax.swing.JLabel();
        CD_placement105 = new javax.swing.JLabel();
        CD_placement106 = new javax.swing.JLabel();
        CD_placement107 = new javax.swing.JLabel();
        CD_placement108 = new javax.swing.JLabel();
        CD_placement111 = new javax.swing.JLabel();
        CD_placement112 = new javax.swing.JLabel();
        CD_placement113 = new javax.swing.JLabel();
        CD_placement114 = new javax.swing.JLabel();
        CD_placement115 = new javax.swing.JLabel();
        CD_placement116 = new javax.swing.JLabel();
        CD_placement117 = new javax.swing.JLabel();
        CD_placement118 = new javax.swing.JLabel();
        CD_placement119 = new javax.swing.JLabel();
        CD_placement120 = new javax.swing.JLabel();
        CD_placement121 = new javax.swing.JLabel();
        CD_placement122 = new javax.swing.JLabel();
        CD_placement123 = new javax.swing.JLabel();
        CD_placement124 = new javax.swing.JLabel();
        CD_placement125 = new javax.swing.JLabel();
        CD_placement126 = new javax.swing.JLabel();
        CD_placement127 = new javax.swing.JLabel();
        CD_placement128 = new javax.swing.JLabel();
        CD_placement129 = new javax.swing.JLabel();
        CD_placement130 = new javax.swing.JLabel();
        CD_placement131 = new javax.swing.JLabel();
        CD_placement132 = new javax.swing.JLabel();
        CD_placement133 = new javax.swing.JLabel();
        CD_placement134 = new javax.swing.JLabel();
        CD_placement135 = new javax.swing.JLabel();
        CD_placement136 = new javax.swing.JLabel();
        CD_placement137 = new javax.swing.JLabel();
        CD_placement138 = new javax.swing.JLabel();
        CD_placement139 = new javax.swing.JLabel();
        CD_placement140 = new javax.swing.JLabel();
        CD_placement145 = new javax.swing.JLabel();
        CD_nextRoundButton = new javax.swing.JButton();
        CD_enemyExample = new javax.swing.JLabel();
        CD_fastFowardButton = new javax.swing.JToggleButton();
        CD_gameEndedPanel = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        CD_roundDiedAt = new javax.swing.JLabel();
        CD_gameEndedHighscoreIndicator = new javax.swing.JLabel();
        CD_restartGameButton = new javax.swing.JButton();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        CD_totalEnemiesKilled = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        CD_cashMade = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        CD_gameEndedPoints = new javax.swing.JLabel();
        CD_cover = new javax.swing.JPanel();
        CD_startButton = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        CD_tower1 = new javax.swing.JLabel();
        CD_coverDes1 = new javax.swing.JLabel();
        CD_tower2 = new javax.swing.JLabel();
        CD_coverDes2 = new javax.swing.JLabel();
        CD_tower3 = new javax.swing.JLabel();
        CD_coverDes3 = new javax.swing.JLabel();
        CD_tower4 = new javax.swing.JLabel();
        CD_coverDes4 = new javax.swing.JLabel();
        CD_gameDescription = new javax.swing.JLabel();
        mainMenuFrame = new javax.swing.JPanel();
        gamesScrollFrame = new javax.swing.JScrollPane();
        gamesPanel = new javax.swing.JPanel();
        game1 = new javax.swing.JPanel();
        MM_game1StartButton = new javax.swing.JButton();
        game1HighScore = new javax.swing.JLabel();
        game1Username = new javax.swing.JLabel();
        game1Image_ = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        game2 = new javax.swing.JPanel();
        MM_game2StartButton = new javax.swing.JButton();
        game2HighScore = new javax.swing.JLabel();
        game2Username = new javax.swing.JLabel();
        game2Image = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        game3 = new javax.swing.JPanel();
        MM_game3StartButton = new javax.swing.JButton();
        game3HighScore = new javax.swing.JLabel();
        game3Username = new javax.swing.JLabel();
        game3Image = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        game4 = new javax.swing.JPanel();
        MM_game4StartButton = new javax.swing.JButton();
        game4HighScore = new javax.swing.JLabel();
        game4Username = new javax.swing.JLabel();
        game4Image = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel48 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        game5 = new javax.swing.JPanel();
        MM_game5StartButton = new javax.swing.JButton();
        game5HighScore = new javax.swing.JLabel();
        game5Username = new javax.swing.JLabel();
        game5Image = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel61 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        game6 = new javax.swing.JPanel();
        MM_game6StartButton = new javax.swing.JButton();
        game6HighScore = new javax.swing.JLabel();
        game6Username = new javax.swing.JLabel();
        game6Image = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel90 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        MM_userSettingsPanel = new javax.swing.JPanel();
        MM_userSettingsCancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        MM_userSettingsPanelTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MM_usernameInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        MM_passwordInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MM_passwordConfirmInput = new javax.swing.JTextField();
        MM_saveSettingsButton = new javax.swing.JButton();
        game3Frame = new javax.swing.JPanel();
        PP_gameArea = new javax.swing.JPanel();
        PP_cover = new javax.swing.JPanel();
        PP_startButton = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        PP_twoPlayerButton = new javax.swing.JButton();
        PP_singlePlayerModeCover = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        PP_gameDescription = new javax.swing.JLabel();
        PP_twoPlayerModeCover = new javax.swing.JPanel();
        G3_gameDescription2 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        PP_resetCover = new javax.swing.JPanel();
        PP_resetButton = new javax.swing.JButton();
        PP_computer = new javax.swing.JPanel();
        PP_playerEdge = new javax.swing.JPanel();
        PP_computerEdge = new javax.swing.JPanel();
        PP_player = new javax.swing.JPanel();
        PP_ball = new javax.swing.JPanel();
        PP_countDownTimer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        PP_playerLabel = new javax.swing.JLabel();
        PP_computerLabel = new javax.swing.JLabel();
        PP_playerScore = new javax.swing.JLabel();
        PP_computerScore = new javax.swing.JLabel();
        PP_scorePanel = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        PP_pointsPanel = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        JPanel991 = new javax.swing.JPanel();
        PP_timerBar = new javax.swing.JProgressBar();
        game2Frame = new javax.swing.JPanel();
        G2_resetBar = new javax.swing.JPanel();
        DB_resetButton = new javax.swing.JButton();
        G2_gameArea = new javax.swing.JPanel();
        G2_player1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DB_player1TopIcon = new javax.swing.JLabel();
        G2_player2 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        DB_player2TopIcon = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        DB_1 = new javax.swing.JPanel();
        DB_2 = new javax.swing.JPanel();
        DB_3 = new javax.swing.JPanel();
        DB_4 = new javax.swing.JPanel();
        DB_5 = new javax.swing.JPanel();
        DB_6 = new javax.swing.JPanel();
        DB_14 = new javax.swing.JPanel();
        DB_15 = new javax.swing.JPanel();
        DB_16 = new javax.swing.JPanel();
        DB_17 = new javax.swing.JPanel();
        DB_18 = new javax.swing.JPanel();
        DB_19 = new javax.swing.JPanel();
        DB_27 = new javax.swing.JPanel();
        DB_28 = new javax.swing.JPanel();
        DB_29 = new javax.swing.JPanel();
        DB_30 = new javax.swing.JPanel();
        DB_31 = new javax.swing.JPanel();
        DB_32 = new javax.swing.JPanel();
        DB_40 = new javax.swing.JPanel();
        DB_41 = new javax.swing.JPanel();
        DB_42 = new javax.swing.JPanel();
        DB_43 = new javax.swing.JPanel();
        DB_44 = new javax.swing.JPanel();
        DB_45 = new javax.swing.JPanel();
        DB_7 = new javax.swing.JPanel();
        DB_8 = new javax.swing.JPanel();
        DB_9 = new javax.swing.JPanel();
        DB_10 = new javax.swing.JPanel();
        DB_11 = new javax.swing.JPanel();
        DB_12 = new javax.swing.JPanel();
        DB_13 = new javax.swing.JPanel();
        DB_20 = new javax.swing.JPanel();
        DB_21 = new javax.swing.JPanel();
        DB_22 = new javax.swing.JPanel();
        DB_23 = new javax.swing.JPanel();
        DB_24 = new javax.swing.JPanel();
        DB_25 = new javax.swing.JPanel();
        DB_26 = new javax.swing.JPanel();
        DB_33 = new javax.swing.JPanel();
        DB_34 = new javax.swing.JPanel();
        DB_35 = new javax.swing.JPanel();
        DB_36 = new javax.swing.JPanel();
        DB_37 = new javax.swing.JPanel();
        DB_38 = new javax.swing.JPanel();
        DB_39 = new javax.swing.JPanel();
        DB_b1 = new javax.swing.JLabel();
        DB_b2 = new javax.swing.JLabel();
        DB_b3 = new javax.swing.JLabel();
        DB_b4 = new javax.swing.JLabel();
        DB_b5 = new javax.swing.JLabel();
        DB_b6 = new javax.swing.JLabel();
        DB_b7 = new javax.swing.JLabel();
        DB_b8 = new javax.swing.JLabel();
        DB_b9 = new javax.swing.JLabel();
        DB_b10 = new javax.swing.JLabel();
        DB_b11 = new javax.swing.JLabel();
        DB_b12 = new javax.swing.JLabel();
        DB_b13 = new javax.swing.JLabel();
        DB_b14 = new javax.swing.JLabel();
        DB_b15 = new javax.swing.JLabel();
        DB_b16 = new javax.swing.JLabel();
        DB_b17 = new javax.swing.JLabel();
        DB_b18 = new javax.swing.JLabel();
        game5Frame = new javax.swing.JPanel();
        TA_cover = new javax.swing.JPanel();
        TA_settingsPanel = new javax.swing.JPanel();
        TA_saveSettingsButton = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        TA_maxTaggerTime = new javax.swing.JSpinner();
        jLabel122 = new javax.swing.JLabel();
        TA_runnerSpeed = new javax.swing.JSpinner();
        jLabel123 = new javax.swing.JLabel();
        TA_resetRunnerSpeed = new javax.swing.JButton();
        TA_resetMaxTaggerTime = new javax.swing.JButton();
        TA_resetTaggerSpeed = new javax.swing.JButton();
        TA_taggerSpeed = new javax.swing.JSpinner();
        jLabel124 = new javax.swing.JLabel();
        TA_resetTimeFrozen = new javax.swing.JButton();
        TA_timeFrozen = new javax.swing.JSpinner();
        jLabel125 = new javax.swing.JLabel();
        TA_resetBoostedSpeed = new javax.swing.JButton();
        TA_boostedSpeed = new javax.swing.JSpinner();
        jLabel126 = new javax.swing.JLabel();
        TA_resetBoostRespawnTime = new javax.swing.JButton();
        TA_boostRespawnTime = new javax.swing.JSpinner();
        jLabel127 = new javax.swing.JLabel();
        TA_resetBoostedTime = new javax.swing.JButton();
        TA_boostedTime = new javax.swing.JSpinner();
        jLabel128 = new javax.swing.JLabel();
        TA_resetGravity = new javax.swing.JButton();
        TA_gravity = new javax.swing.JSpinner();
        jLabel129 = new javax.swing.JLabel();
        TA_settings = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        TA_startButton = new javax.swing.JButton();
        TA_gameBox = new javax.swing.JPanel();
        TA_choosePlayerPanel = new javax.swing.JPanel();
        TA_startingPlayer = new javax.swing.JLabel();
        TA_choosePlayerTitle = new javax.swing.JLabel();
        TA_startingPlayerButton = new javax.swing.JButton();
        TA_player1 = new javax.swing.JPanel();
        TA_player1Indicator = new javax.swing.JLabel();
        TA_player2 = new javax.swing.JPanel();
        TA_player2Indicator = new javax.swing.JLabel();
        TA_boost1 = new javax.swing.JLabel();
        TA_boost2 = new javax.swing.JLabel();
        TA_floor0 = new javax.swing.JPanel();
        TA_floor1 = new javax.swing.JPanel();
        TA_floor2 = new javax.swing.JPanel();
        TA_floor3 = new javax.swing.JPanel();
        TA_floor4 = new javax.swing.JPanel();
        TA_floor5 = new javax.swing.JPanel();
        TA_floor6 = new javax.swing.JPanel();
        TA_floor7 = new javax.swing.JPanel();
        TA_floor8 = new javax.swing.JPanel();
        TA_floor9 = new javax.swing.JPanel();
        TA_floor10 = new javax.swing.JPanel();
        TA_floor11 = new javax.swing.JPanel();
        TA_floor12 = new javax.swing.JPanel();
        TA_floor13 = new javax.swing.JPanel();
        TA_topBar = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        TA_player2Time = new javax.swing.JProgressBar();
        jPanel16 = new javax.swing.JPanel();
        TA_player1Time = new javax.swing.JProgressBar();
        JLabel = new javax.swing.JLabel();
        JLabel19 = new javax.swing.JLabel();
        game4Frame = new javax.swing.JPanel();
        T_gameBox = new javax.swing.JPanel();
        T_matchCover = new javax.swing.JPanel();
        T_matchCoverButton = new javax.swing.JButton();
        T_matchWinnerText = new javax.swing.JLabel();
        T_explosion = new javax.swing.JLabel();
        T_ball = new javax.swing.JLabel();
        T_mapItem1 = new javax.swing.JPanel();
        T_mapItem2 = new javax.swing.JPanel();
        T_floor = new javax.swing.JPanel();
        T_gasBar = new javax.swing.JProgressBar();
        jLabel64 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        T_player1Lifes = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        T_player2Lifes = new javax.swing.JLabel();
        T_powerBar = new javax.swing.JProgressBar();
        T_mapItem3 = new javax.swing.JPanel();
        T_floorLine = new javax.swing.JSeparator();
        T_player1 = new javax.swing.JLabel();
        T_player2 = new javax.swing.JLabel();
        T_cover = new javax.swing.JPanel();
        T_gameOverCover = new javax.swing.JPanel();
        T_gameOverText = new javax.swing.JLabel();
        T_restartGameButton = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        T_map1Cover = new javax.swing.JPanel();
        T_map2Cover = new javax.swing.JPanel();
        T_map3Cover = new javax.swing.JPanel();
        T_map1Button = new javax.swing.JLabel();
        T_map2Button = new javax.swing.JLabel();
        T_map3Button = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        T_player2Score = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        T_player1Score = new javax.swing.JLabel();
        T_player2Indicator = new javax.swing.JLabel();
        T_player1Indicator = new javax.swing.JLabel();
        loginFrame = new javax.swing.JPanel();
        loginButtonsFrame = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        createAccountButton = new javax.swing.JButton();
        loginTitle = new javax.swing.JLabel();
        passwordConfirmInput = new javax.swing.JPasswordField();
        loginLogo = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        passwordInput = new javax.swing.JPasswordField();
        createAccountCancelButton = new javax.swing.JButton();
        createAccountConfirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GamesAndStuff");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_topBar.setBackground(new java.awt.Color(153, 135, 108));
        MM_topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MM_username.setForeground(java.awt.Color.white);
        MM_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MM_username.setText("<Username>");
        MM_username.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MM_topBar.add(MM_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 30));

        MM_userSettingsButton.setBackground(new java.awt.Color(200, 151, 115));
        MM_userSettingsButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MM_userSettingsButton.setForeground(java.awt.Color.white);
        MM_userSettingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_userSettingsButton.setLabel("User Settings");
        MM_userSettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_userSettingsButtonMousePressed(evt);
            }
        });
        MM_topBar.add(MM_userSettingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 5, -1, 40));

        MM_logOutButton.setBackground(new java.awt.Color(200, 151, 115));
        MM_logOutButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MM_logOutButton.setForeground(java.awt.Color.white);
        MM_logOutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_logOutButton.setLabel("Log Out");
        MM_logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_logOutButtonMousePressed(evt);
            }
        });
        MM_topBar.add(MM_logOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 5, -1, 40));

        MM_backToMenuButton.setBackground(new java.awt.Color(200, 151, 115));
        MM_backToMenuButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MM_backToMenuButton.setForeground(java.awt.Color.white);
        MM_backToMenuButton.setText("Go Back To Menu");
        MM_backToMenuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_backToMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_backToMenuButtonMousePressed(evt);
            }
        });
        MM_topBar.add(MM_backToMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 5, 200, 40));

        getContentPane().add(MM_topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 50));

        game1Frame.setBackground(new java.awt.Color(214, 196, 172));
        game1Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MG_gameArea.setBackground(new java.awt.Color(175, 155, 124));
        MG_gameArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        MG_gameArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_card1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue1.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue1.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue1.setText("▲");
        G1_card1.add(G1_cardValue1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card1.add(G1_cardImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 150));

        G1_card2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue2.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue2.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue2.setText("■");
        G1_card2.add(G1_cardValue2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card2.add(G1_cardImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 100, 150));

        G1_card3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue3.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue3.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue3.setText("♠");
        G1_card3.add(G1_cardValue3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card3.add(G1_cardImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 100, 150));

        G1_card4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue4.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue4.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue4.setText("♦");
        G1_card4.add(G1_cardValue4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card4.add(G1_cardImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 100, 150));

        G1_card5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue5.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue5.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue5.setText("♥");
        G1_card5.add(G1_cardValue5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card5.add(G1_cardImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 100, 150));

        G1_card6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue6.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue6.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue6.setText("○");
        G1_card6.add(G1_cardValue6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card6.add(G1_cardImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 100, 150));

        G1_card7.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue7.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue7.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue7.setText("●");
        G1_card7.add(G1_cardValue7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card7.add(G1_cardImage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 150));

        G1_card8.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue8.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue8.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue8.setText("▼");
        G1_card8.add(G1_cardValue8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card8.add(G1_cardImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 100, 150));

        G1_card9.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue9.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue9.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardValue9.setText("⇨");
        G1_card9.add(G1_cardValue9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card9.add(G1_cardImage9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 100, 150));

        G1_card10.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue10.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue10.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card10.add(G1_cardValue10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card10.add(G1_cardImage10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 100, 150));

        G1_card11.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue11.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue11.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card11.add(G1_cardValue11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card11.add(G1_cardImage11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 100, 150));

        G1_card12.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue12.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue12.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card12.add(G1_cardValue12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card12.add(G1_cardImage12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 100, 150));

        G1_card13.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue13.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue13.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card13.add(G1_cardValue13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card13.add(G1_cardImage13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 100, 150));

        G1_card14.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue14.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue14.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card14.add(G1_cardValue14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card14.add(G1_cardImage14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 100, 150));

        G1_card15.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue15.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue15.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card15.add(G1_cardValue15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card15.add(G1_cardImage15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 100, 150));

        G1_card16.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue16.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue16.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card16.add(G1_cardValue16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card16.add(G1_cardImage16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 100, 150));

        G1_card17.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue17.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue17.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card17.add(G1_cardValue17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card17.add(G1_cardImage17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 100, 150));

        G1_card18.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_card18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_cardValue18.setFont(new java.awt.Font("Segoe UI", 0, 65)); // NOI18N
        G1_cardValue18.setForeground(new java.awt.Color(255, 102, 102));
        G1_cardValue18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_card18.add(G1_cardValue18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        G1_cardImage18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_cardImage18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGameCard.png"))); // NOI18N
        G1_cardImage18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_cardImage18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_cardClicked(evt);
            }
        });
        G1_card18.add(G1_cardImage18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 150));

        MG_gameArea.add(G1_card18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 100, 150));

        game1Frame.add(MG_gameArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 720, 530));

        MG_disableCover.setBackground(new java.awt.Color(172, 157, 136));
        MG_disableCover.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        MG_disableCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        game1Frame.add(MG_disableCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 720, 530));

        MG_timeBoard.setBackground(new java.awt.Color(153, 135, 108));
        MG_timeBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MG_timeBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MG_timerBar.setBackground(new java.awt.Color(200, 151, 115));
        MG_timerBar.setForeground(new java.awt.Color(153, 135, 108));
        MG_timerBar.setValue(30);
        MG_timeBoard.add(MG_timerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 430, 30));

        MG_startButton.setBackground(new java.awt.Color(200, 151, 115));
        MG_startButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MG_startButton.setForeground(java.awt.Color.white);
        MG_startButton.setText("Start Game");
        MG_startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MG_startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MG_startButtonMousePressed(evt);
            }
        });
        MG_timeBoard.add(MG_startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 430, 30));

        game1Frame.add(MG_timeBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 65, 440, 40));

        MG_scoreBoard.setBackground(new java.awt.Color(153, 135, 108));
        MG_scoreBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MG_scoreBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_score.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        G1_score.setForeground(java.awt.Color.white);
        G1_score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_score.setText("<score>");
        MG_scoreBoard.add(G1_score, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 140, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(java.awt.Color.white);
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Current Score: ");
        MG_scoreBoard.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        game1Frame.add(MG_scoreBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 270, 40));

        getContentPane().add(game1Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        game6Frame.setBackground(new java.awt.Color(214, 196, 172));
        game6Frame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        game6Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_gameBox.setBackground(new java.awt.Color(239, 233, 224));
        CD_gameBox.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        CD_gameBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_gameBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_messagePanel.setBackground(new java.awt.Color(165, 149, 125));
        CD_messagePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_messagePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setBackground(new java.awt.Color(200, 151, 115));
        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel100.setForeground(java.awt.Color.white);
        jLabel100.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel100.setText("[ CONGRATULATIONS ] ");
        jLabel100.setToolTipText("");
        jLabel100.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel100.setOpaque(true);
        CD_messagePanel.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 440, 50));

        CD_messageText.setBackground(new java.awt.Color(165, 149, 125));
        CD_messageText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CD_messageText.setForeground(java.awt.Color.white);
        CD_messageText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_messageText.setText("You got money! Enemies will now be harder!");
        CD_messageText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        CD_messagePanel.add(CD_messageText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 440, 60));

        CD_messageContinueButton.setBackground(new java.awt.Color(200, 151, 115));
        CD_messageContinueButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CD_messageContinueButton.setForeground(java.awt.Color.white);
        CD_messageContinueButton.setText("Continue!");
        CD_messageContinueButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_messageContinueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_messageContinueButtonMouseClicked(evt);
            }
        });
        CD_messagePanel.add(CD_messageContinueButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 480, 50));

        CD_gameBox.add(CD_messagePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 500, 200));

        CD_bottomBar.setBackground(new java.awt.Color(165, 149, 125));
        CD_bottomBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_bottomBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_bottomBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_menuButton.setBackground(new java.awt.Color(200, 151, 115));
        CD_menuButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CD_menuButton.setForeground(java.awt.Color.white);
        CD_menuButton.setText("Open Menu");
        CD_menuButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CD_menuButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_menuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_menuButtonMouseClicked(evt);
            }
        });
        CD_bottomBar.add(CD_menuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 300, 35));

        CD_cashSymbol.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CD_cashSymbol.setForeground(java.awt.Color.white);
        CD_cashSymbol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_cashSymbol.setText("$");
        CD_bottomBar.add(CD_cashSymbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 5, 30, 35));

        CD_cash.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        CD_cash.setForeground(new java.awt.Color(0, 255, 0));
        CD_cash.setText("999,9999");
        CD_bottomBar.add(CD_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 5, 100, 35));

        CD_castleHealth.setForeground(new java.awt.Color(0, 204, 51));
        CD_castleHealth.setValue(50);
        CD_castleHealth.setString("Castle Health");
        CD_castleHealth.setStringPainted(true);
        CD_bottomBar.add(CD_castleHealth, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 8, 140, 30));

        CD_enemiesLeftBar.setForeground(new java.awt.Color(0, 204, 255));
        CD_enemiesLeftBar.setValue(50);
        CD_enemiesLeftBar.setString("Enemies Left");
        CD_enemiesLeftBar.setStringPainted(true);
        CD_bottomBar.add(CD_enemiesLeftBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 8, 140, 30));

        CD_gameBox.add(CD_bottomBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 535, 740, 45));

        CD_menu.setBackground(new java.awt.Color(165, 149, 125));
        CD_menu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(200, 151, 115));
        jPanel19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_buyTower1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower1.png"))); // NOI18N
        CD_buyTower1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.add(CD_buyTower1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        CD_buyTower2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower2.png"))); // NOI18N
        CD_buyTower2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.add(CD_buyTower2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 40, 40));

        CD_buyTower3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower3.png"))); // NOI18N
        CD_buyTower3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.add(CD_buyTower3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 40, 40));

        CD_buyTower4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower4.png"))); // NOI18N
        CD_buyTower4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.add(CD_buyTower4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 40, 40));

        CD_buyTower1Button.setBackground(new java.awt.Color(255, 51, 0));
        CD_buyTower1Button.setForeground(java.awt.Color.white);
        CD_buyTower1Button.setText("Buy Tower");
        CD_buyTower1Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_buyTower1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_buyTower1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_buyTower1ButtonMouseClicked(evt);
            }
        });
        jPanel19.add(CD_buyTower1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 190, 40));

        CD_buyTower2Button.setBackground(new java.awt.Color(202, 157, 123));
        CD_buyTower2Button.setForeground(java.awt.Color.white);
        CD_buyTower2Button.setText("Buy Tower");
        CD_buyTower2Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_buyTower2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_buyTower2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_buyTower1ButtonMouseClicked(evt);
            }
        });
        jPanel19.add(CD_buyTower2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 190, 40));

        CD_buyTower3Button.setBackground(new java.awt.Color(202, 157, 123));
        CD_buyTower3Button.setForeground(java.awt.Color.white);
        CD_buyTower3Button.setText("Buy Tower");
        CD_buyTower3Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_buyTower3Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_buyTower3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_buyTower1ButtonMouseClicked(evt);
            }
        });
        jPanel19.add(CD_buyTower3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 190, 40));

        CD_buyTower4Button.setBackground(new java.awt.Color(0, 255, 51));
        CD_buyTower4Button.setForeground(java.awt.Color.white);
        CD_buyTower4Button.setText("Buy Tower");
        CD_buyTower4Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_buyTower4Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_buyTower4Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_buyTower1ButtonMouseClicked(evt);
            }
        });
        jPanel19.add(CD_buyTower4Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 190, 40));

        CD_menu.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 280, 210));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel135.setForeground(java.awt.Color.white);
        jLabel135.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel135.setText("Buy Tower");
        CD_menu.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 40));

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel112.setForeground(java.awt.Color.white);
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("Statistics:");
        CD_menu.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 280, 30));

        jPanel22.setBackground(new java.awt.Color(200, 151, 115));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel113.setForeground(java.awt.Color.white);
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel113.setText("Current Round:");
        jPanel22.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        jLabel116.setForeground(java.awt.Color.white);
        jLabel116.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel116.setText("Enemies Killed:");
        jPanel22.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 30));

        CD_enemiesKilledStat.setForeground(java.awt.Color.white);
        CD_enemiesKilledStat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_enemiesKilledStat.setText("99999");
        CD_enemiesKilledStat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel22.add(CD_enemiesKilledStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 150, 30));

        CD_currentRoundStat.setForeground(java.awt.Color.white);
        CD_currentRoundStat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_currentRoundStat.setText("99999");
        CD_currentRoundStat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel22.add(CD_currentRoundStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 150, 30));

        jLabel138.setForeground(java.awt.Color.white);
        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel138.setText("Total Cash Made:");
        jPanel22.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        CD_highscoreStat.setForeground(java.awt.Color.white);
        CD_highscoreStat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_highscoreStat.setText("99999");
        CD_highscoreStat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel22.add(CD_highscoreStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 70, 30));

        CD_cashMadeStat.setForeground(java.awt.Color.white);
        CD_cashMadeStat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_cashMadeStat.setText("99999");
        CD_cashMadeStat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel22.add(CD_cashMadeStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, 30));

        jLabel139.setForeground(java.awt.Color.white);
        jLabel139.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel139.setText("Points / High :");
        jPanel22.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 105, 30));

        CD_pointsStat.setForeground(java.awt.Color.white);
        CD_pointsStat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_pointsStat.setText("99999");
        CD_pointsStat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel22.add(CD_pointsStat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 70, 30));

        CD_menu.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 280, 170));

        CD_gameBox.add(CD_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 535, 320, 500));

        CD_upgradeMenu.setBackground(new java.awt.Color(165, 149, 125));
        CD_upgradeMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_upgradeMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_cat2Button.setBackground(new java.awt.Color(202, 157, 123));
        CD_cat2Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CD_cat2Button.setForeground(java.awt.Color.white);
        CD_cat2Button.setText("Upgrade");
        CD_cat2Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_cat2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_cat2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_cat2ButtonMouseClicked(evt);
            }
        });
        CD_upgradeMenu.add(CD_cat2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 65, 40));

        CD_cat1Button.setBackground(new java.awt.Color(202, 157, 123));
        CD_cat1Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CD_cat1Button.setForeground(java.awt.Color.white);
        CD_cat1Button.setText("Upgrade");
        CD_cat1Button.setToolTipText("");
        CD_cat1Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_cat1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_cat1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_cat2ButtonMouseClicked(evt);
            }
        });
        CD_upgradeMenu.add(CD_cat1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 65, 40));

        CD_cat3Button.setBackground(new java.awt.Color(202, 157, 123));
        CD_cat3Button.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CD_cat3Button.setForeground(java.awt.Color.white);
        CD_cat3Button.setText("Upgrade");
        CD_cat3Button.setToolTipText("");
        CD_cat3Button.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_cat3Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_cat3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_cat2ButtonMouseClicked(evt);
            }
        });
        CD_upgradeMenu.add(CD_cat3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 65, 40));

        CD_upgradeSellButton.setBackground(new java.awt.Color(184, 125, 80));
        CD_upgradeSellButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CD_upgradeSellButton.setForeground(java.awt.Color.white);
        CD_upgradeSellButton.setText("$ Sell $");
        CD_upgradeSellButton.setToolTipText("");
        CD_upgradeSellButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_upgradeSellButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_upgradeSellButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_upgradeSellButtonMouseClicked(evt);
            }
        });
        CD_upgradeMenu.add(CD_upgradeSellButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 10, 65, 40));

        CD_cat1ProgressBar.setForeground(new java.awt.Color(255, 0, 51));
        CD_cat1ProgressBar.setValue(100);
        CD_cat1ProgressBar.setString("$200");
        CD_cat1ProgressBar.setStringPainted(true);
        CD_upgradeMenu.add(CD_cat1ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 210, 40));

        CD_cat2ProgressBar.setForeground(new java.awt.Color(0, 153, 153));
        CD_cat2ProgressBar.setValue(100);
        CD_cat2ProgressBar.setString("$200");
        CD_cat2ProgressBar.setStringPainted(true);
        CD_upgradeMenu.add(CD_cat2ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 210, 40));

        CD_cat3ProgressBar.setForeground(new java.awt.Color(51, 153, 0));
        CD_cat3ProgressBar.setValue(100);
        CD_cat3ProgressBar.setString("$200");
        CD_cat3ProgressBar.setStringPainted(true);
        CD_upgradeMenu.add(CD_cat3ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 210, 40));

        jLabel110.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel110.setForeground(java.awt.Color.white);
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("Upgrade Menu");
        CD_upgradeMenu.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 220, 40));

        jLabel111.setForeground(java.awt.Color.white);
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("LVL 3");
        CD_upgradeMenu.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 40, 40));

        jLabel114.setForeground(java.awt.Color.white);
        jLabel114.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel114.setText("LVL 0");
        CD_upgradeMenu.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 40, 40));

        jLabel115.setForeground(java.awt.Color.white);
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("LVL 2");
        CD_upgradeMenu.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 40, 40));

        jLabel132.setForeground(java.awt.Color.white);
        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel132.setText("LVL 1");
        CD_upgradeMenu.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 40, 40));

        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel133.setForeground(java.awt.Color.white);
        jLabel133.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel133.setText("Power");
        CD_upgradeMenu.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 70, 40));

        jLabel134.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel134.setForeground(java.awt.Color.white);
        jLabel134.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel134.setText("Range");
        CD_upgradeMenu.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 70, 40));

        jLabel136.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel136.setForeground(java.awt.Color.white);
        jLabel136.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel136.setText("Ability");
        CD_upgradeMenu.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 70, 40));

        jPanel21.setBackground(new java.awt.Color(200, 151, 115));
        jPanel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_upgradeDescription.setBackground(new java.awt.Color(200, 151, 115));
        CD_upgradeDescription.setForeground(java.awt.Color.white);
        CD_upgradeDescription.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CD_upgradeDescription.setText("Missle Shooter: Shoots missles, but takes a long time ");
        CD_upgradeDescription.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        CD_upgradeDescription.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CD_upgradeDescription.setOpaque(true);
        jPanel21.add(CD_upgradeDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 300, 80));

        CD_upgradeTower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower3.png"))); // NOI18N
        CD_upgradeTower.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel21.add(CD_upgradeTower, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 40));

        CD_upgradeMenu.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 360, 80));

        CD_upgradeMoveButton.setBackground(new java.awt.Color(184, 125, 80));
        CD_upgradeMoveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CD_upgradeMoveButton.setForeground(java.awt.Color.white);
        CD_upgradeMoveButton.setText("Move");
        CD_upgradeMoveButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_upgradeMoveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_upgradeMoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_upgradeMoveButtonMouseClicked(evt);
            }
        });
        CD_upgradeMenu.add(CD_upgradeMoveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 65, 40));

        CD_gameBox.add(CD_upgradeMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 217, 380, 320));

        CD_path1.setBackground(new java.awt.Color(204, 204, 204));
        CD_path1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_path1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CD_gameBox.add(CD_path1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 410, 158, 40));

        CD_path2.setBackground(new java.awt.Color(204, 204, 204));
        CD_path2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_path2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CD_gameBox.add(CD_path2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 40, 320));

        CD_path3.setBackground(new java.awt.Color(204, 204, 204));
        CD_path3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_path3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CD_gameBox.add(CD_path3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 560, 40));

        CD_path4.setBackground(new java.awt.Color(204, 204, 204));
        CD_path4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_path4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CD_gameBox.add(CD_path4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 40, 240));

        CD_path5.setBackground(new java.awt.Color(204, 204, 204));
        CD_path5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_path5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CD_gameBox.add(CD_path5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 200, 40));

        CD_path6.setBackground(new java.awt.Color(204, 204, 204));
        CD_path6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_path6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        CD_gameBox.add(CD_path6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 40, 60));

        CD_lake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/CastleDefense_lake.png"))); // NOI18N
        CD_lake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_lake, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 250, 140));

        CD_castle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/CastleDefense_castle.png"))); // NOI18N
        CD_castle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_path1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_path1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_castle, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 388, 160, 160));

        CD_placement1.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 40, 40));

        CD_placement2.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 40, 40));

        CD_placement3.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 40, 40));

        CD_placement4.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 40, 40));

        CD_placement5.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 40, 40));

        CD_placement6.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 40, 40));

        CD_placement7.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 40, 40));

        CD_placement8.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 40, 40));

        CD_placement9.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 40, 40));

        CD_placement10.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 40, 40));

        CD_placement11.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 40));

        CD_placement12.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 40, 40));

        CD_placement13.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 40, 40));

        CD_placement14.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 40, 40));

        CD_placement15.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 40, 40));

        CD_placement16.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 40, 40));

        CD_placement17.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 40, 40));

        CD_placement18.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 40, 40));

        CD_placement19.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 40, 40));

        CD_placement20.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement20, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 40, 40));

        CD_placement21.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 40, 40));

        CD_placement22.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 40, 40));

        CD_placement23.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement23, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 40, 40));

        CD_placement24.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement24, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 40, 40));

        CD_placement25.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement25, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 10, 40, 40));

        CD_placement26.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement26, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 40, 40));

        CD_placement27.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement27, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 40, 40));

        CD_placement28.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement28, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 40, 40));

        CD_placement29.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement29, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 40, 40));

        CD_placement30.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement30, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 40, 40));

        CD_placement31.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement31, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 40, 40));

        CD_placement32.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement32, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 40, 40));

        CD_placement33.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement33, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 40, 40));

        CD_placement34.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement34, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 40, 40));

        CD_placement35.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement35, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 40, 40));

        CD_placement36.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement36, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 40, 40));

        CD_placement37.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement37, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 40, 40));

        CD_placement38.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement38, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 40, 40));

        CD_placement41.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 40, 40));

        CD_placement42.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement42, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 40, 40));

        CD_placement43.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement43, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 40, 40));

        CD_placement44.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement44, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 40, 40));

        CD_placement45.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement45, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 40, 40));

        CD_placement46.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement46, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 40, 40));

        CD_placement47.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower4.png"))); // NOI18N
        CD_placement47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement47, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 40, 40));

        CD_placement48.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower3.png"))); // NOI18N
        CD_placement48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement48, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 40, 40));

        CD_placement49.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower2.png"))); // NOI18N
        CD_placement49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement49, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 40, 40));

        CD_placement50.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower1.png"))); // NOI18N
        CD_placement50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement50, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 40, 40));

        CD_placement51.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement51, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 40, 40));

        CD_placement52.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement52, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 40, 40));

        CD_placement53.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement53, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 40, 40));

        CD_placement54.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement54, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 40, 40));

        CD_placement55.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement55, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 40, 40));

        CD_placement56.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement56, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 40, 40));

        CD_placement57.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement57, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 40, 40));

        CD_placement58.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement58, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 40, 40));

        CD_placement59.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement59, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 40, 40));

        CD_placement60.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement60, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 40, 40));

        CD_placement61.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement61, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 40, 40));

        CD_placement62.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement62, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 40, 40));

        CD_placement63.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement63, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 40, 40));

        CD_placement64.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement64, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 40, 40));

        CD_placement65.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement65, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 40, 40));

        CD_placement66.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement66, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 40, 40));

        CD_placement67.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement67, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 40, 40));

        CD_placement68.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement68, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 40, 40));

        CD_placement69.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement69, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 40, 40));

        CD_placement70.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement70, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 40, 40));

        CD_placement71.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement71, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 40, 40));

        CD_placement72.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement72, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 40, 40));

        CD_placement73.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement73, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 40, 40));

        CD_placement74.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement74, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 40, 40));

        CD_placement77.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement77, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 40, 40));

        CD_placement78.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement78, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 40, 40));

        CD_placement79.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement79, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 40, 40));

        CD_placement80.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement80, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 40, 40));

        CD_placement81.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement81, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 40, 40));

        CD_placement82.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement82, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 40, 40));

        CD_placement83.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement83, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 40, 40));

        CD_placement84.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement84, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 40, 40));

        CD_placement85.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement85, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 40, 40));

        CD_placement86.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement86, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 40, 40));

        CD_placement87.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement87, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 40, 40));

        CD_placement88.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement88.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CD_placement88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement88, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 40, 40));

        CD_placement89.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement89, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 40, 40));

        CD_placement90.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement90, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 40, 40));

        CD_placement91.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement91, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 40, 40));

        CD_placement92.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement92, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 40, 40));

        CD_placement93.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement93, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 40, 40));

        CD_placement94.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement94, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 40, 40));

        CD_placement95.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement95, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 40, 40));

        CD_placement96.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement96, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 40, 40));

        CD_placement97.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement97, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 40, 40));

        CD_placement98.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement98, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 40, 40));

        CD_placement99.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement99, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 40, 40));

        CD_placement100.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement100, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 40, 40));

        CD_placement101.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement101, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 40, 40));

        CD_placement102.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement102, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 40, 40));

        CD_placement103.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement103, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 40, 40));

        CD_placement104.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement104, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 40, 40));

        CD_placement105.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement105, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 40, 40));

        CD_placement106.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement106, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 40, 40));

        CD_placement107.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement107, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 40, 40));

        CD_placement108.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement108, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, 40, 40));

        CD_placement111.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement111.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        CD_placement111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement111, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 40, 40));

        CD_placement112.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement112, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 40, 40));

        CD_placement113.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement113, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 40, 40));

        CD_placement114.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement114, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 40, 40));

        CD_placement115.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement115, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 40, 40));

        CD_placement116.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement116, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 40, 40));

        CD_placement117.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement117, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 40, 40));

        CD_placement118.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement118, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 40, 40));

        CD_placement119.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement119, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 40, 40));

        CD_placement120.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement120, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, 40));

        CD_placement121.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement121, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 450, 40, 40));

        CD_placement122.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement122, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 40, 40));

        CD_placement123.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement123, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 40, 40));

        CD_placement124.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement124.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement124, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 40, 40));

        CD_placement125.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement125.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement125, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 40, 40));

        CD_placement126.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement126.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement126, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 40, 40));

        CD_placement127.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement127, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 40, 40));

        CD_placement128.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement128.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement128, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 40, 40));

        CD_placement129.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement129.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement129, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 40, 40));

        CD_placement130.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement130.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement130, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 40, 40));

        CD_placement131.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement131.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement131, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 450, 40, 40));

        CD_placement132.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement132, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 450, 40, 40));

        CD_placement133.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement133.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement133, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 40, 40));

        CD_placement134.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement134.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement134, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 40, 40));

        CD_placement135.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement135.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement135, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 40, 40));

        CD_placement136.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement136.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement136, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 40, 40));

        CD_placement137.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement137.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement137, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 40, 40));

        CD_placement138.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement138.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement138, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 40, 40));

        CD_placement139.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement139.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement139, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 40, 40));

        CD_placement140.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement140.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement140, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 40, 40));

        CD_placement145.setBackground(new java.awt.Color(255, 153, 153));
        CD_placement145.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_placement1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CD_placement1MouseEntered(evt);
            }
        });
        CD_gameBox.add(CD_placement145, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 40, 40));

        CD_nextRoundButton.setBackground(new java.awt.Color(0, 153, 51));
        CD_nextRoundButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CD_nextRoundButton.setForeground(java.awt.Color.white);
        CD_nextRoundButton.setText("Start Next Round");
        CD_nextRoundButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CD_nextRoundButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_nextRoundButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_nextRoundButtonMouseClicked(evt);
            }
        });
        CD_gameBox.add(CD_nextRoundButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 150, 30));

        CD_enemyExample.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/CastleDefense_enemy.png"))); // NOI18N
        CD_enemyExample.setText("jLabel97");
        CD_gameBox.add(CD_enemyExample, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -40, 40, 40));

        CD_fastFowardButton.setBackground(new java.awt.Color(0, 153, 51));
        CD_fastFowardButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CD_fastFowardButton.setForeground(java.awt.Color.white);
        CD_fastFowardButton.setText(">>");
        CD_fastFowardButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CD_fastFowardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_gameBox.add(CD_fastFowardButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 500, 50, 30));

        game6Frame.add(CD_gameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 580));

        CD_gameEndedPanel.setBackground(new java.awt.Color(214, 196, 172));
        CD_gameEndedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setBackground(new java.awt.Color(153, 135, 108));
        jLabel97.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel97.setForeground(java.awt.Color.white);
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("[ Game Ended ]");
        jLabel97.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel97.setOpaque(true);
        CD_gameEndedPanel.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 640, 80));

        jPanel23.setBackground(new java.awt.Color(153, 135, 108));
        jPanel23.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_roundDiedAt.setBackground(new java.awt.Color(168, 148, 118));
        CD_roundDiedAt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CD_roundDiedAt.setForeground(new java.awt.Color(255, 255, 255));
        CD_roundDiedAt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_roundDiedAt.setText("9999999");
        CD_roundDiedAt.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        CD_roundDiedAt.setOpaque(true);
        jPanel23.add(CD_roundDiedAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 260, 40));

        CD_gameEndedHighscoreIndicator.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CD_gameEndedHighscoreIndicator.setForeground(new java.awt.Color(0, 255, 51));
        CD_gameEndedHighscoreIndicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_gameEndedHighscoreIndicator.setText("!!! YOU SET THE NEW HIGH SCORE !!!");
        jPanel23.add(CD_gameEndedHighscoreIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 470, -1));

        CD_restartGameButton.setBackground(new java.awt.Color(200, 151, 115));
        CD_restartGameButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CD_restartGameButton.setForeground(java.awt.Color.white);
        CD_restartGameButton.setText("Restart Game");
        CD_restartGameButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_restartGameButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_restartGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_restartGameButtonMouseClicked(evt);
            }
        });
        jPanel23.add(CD_restartGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 580, 80));

        jLabel141.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 255, 255));
        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel141.setText("Total Enemies Killed:");
        jPanel23.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 230, 40));

        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(255, 255, 255));
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel142.setText("Died at Round:");
        jPanel23.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 230, 40));

        CD_totalEnemiesKilled.setBackground(new java.awt.Color(168, 148, 118));
        CD_totalEnemiesKilled.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CD_totalEnemiesKilled.setForeground(new java.awt.Color(255, 255, 255));
        CD_totalEnemiesKilled.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_totalEnemiesKilled.setText("9999999");
        CD_totalEnemiesKilled.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        CD_totalEnemiesKilled.setOpaque(true);
        jPanel23.add(CD_totalEnemiesKilled, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 260, 40));

        jLabel143.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(255, 255, 255));
        jLabel143.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel143.setText("Cash Made:");
        jPanel23.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 230, 40));

        CD_cashMade.setBackground(new java.awt.Color(168, 148, 118));
        CD_cashMade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CD_cashMade.setForeground(new java.awt.Color(255, 255, 255));
        CD_cashMade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_cashMade.setText("9999999");
        CD_cashMade.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        CD_cashMade.setOpaque(true);
        jPanel23.add(CD_cashMade, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 260, 40));

        jLabel144.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(255, 255, 255));
        jLabel144.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel144.setText("Points Made:");
        jPanel23.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 230, 40));

        CD_gameEndedPoints.setBackground(new java.awt.Color(168, 148, 118));
        CD_gameEndedPoints.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CD_gameEndedPoints.setForeground(new java.awt.Color(255, 255, 255));
        CD_gameEndedPoints.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_gameEndedPoints.setText("9999999");
        CD_gameEndedPoints.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        CD_gameEndedPoints.setOpaque(true);
        jPanel23.add(CD_gameEndedPoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 260, 40));

        CD_gameEndedPanel.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 640, 330));

        game6Frame.add(CD_gameEndedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 580));

        CD_cover.setBackground(new java.awt.Color(153, 135, 108));
        CD_cover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_startButton.setBackground(new java.awt.Color(200, 151, 115));
        CD_startButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CD_startButton.setForeground(java.awt.Color.white);
        CD_startButton.setText("Start Defending!");
        CD_startButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CD_startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CD_startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CD_startButtonMouseClicked(evt);
            }
        });
        CD_cover.add(CD_startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 506, 720, 60));

        jPanel17.setBackground(new java.awt.Color(200, 151, 115));
        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel99.setForeground(java.awt.Color.white);
        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setText("[ Game Instructions ]");
        jPanel17.add(jLabel99);

        CD_cover.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 700, 70));

        jPanel20.setBackground(new java.awt.Color(158, 141, 116));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CD_tower1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower1.png"))); // NOI18N
        CD_tower1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel20.add(CD_tower1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 40, 40));

        CD_coverDes1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        CD_coverDes1.setForeground(java.awt.Color.white);
        CD_coverDes1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CD_coverDes1.setText("<text>");
        jPanel20.add(CD_coverDes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 500, 60));

        CD_tower2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower2.png"))); // NOI18N
        CD_tower2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel20.add(CD_tower2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 40, 40));

        CD_coverDes2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        CD_coverDes2.setForeground(java.awt.Color.white);
        CD_coverDes2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CD_coverDes2.setText("<text>");
        jPanel20.add(CD_coverDes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 500, 60));

        CD_tower3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower3.png"))); // NOI18N
        CD_tower3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel20.add(CD_tower3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 40, 40));

        CD_coverDes3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        CD_coverDes3.setForeground(java.awt.Color.white);
        CD_coverDes3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CD_coverDes3.setText("<text>");
        jPanel20.add(CD_coverDes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 500, 60));

        CD_tower4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tower4.png"))); // NOI18N
        CD_tower4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel20.add(CD_tower4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 40, 40));

        CD_coverDes4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        CD_coverDes4.setForeground(java.awt.Color.white);
        CD_coverDes4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CD_coverDes4.setText("<text>");
        jPanel20.add(CD_coverDes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 500, 60));

        CD_gameDescription.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        CD_gameDescription.setForeground(java.awt.Color.white);
        CD_gameDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CD_gameDescription.setText("\n");
        jPanel20.add(CD_gameDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 690, 105));

        CD_cover.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, 700, 395));

        game6Frame.add(CD_cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 740, 580));

        getContentPane().add(game6Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        mainMenuFrame.setBackground(new java.awt.Color(214, 196, 172));
        mainMenuFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gamesScrollFrame.setBackground(new java.awt.Color(214, 196, 172));
        gamesScrollFrame.setForeground(new java.awt.Color(200, 151, 115));
        gamesScrollFrame.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        gamesScrollFrame.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        gamesScrollFrame.setViewportView(gamesPanel);

        gamesPanel.setBackground(new java.awt.Color(214, 196, 172));
        gamesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        game1.setBackground(new java.awt.Color(200, 151, 115));
        game1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        game1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_game1StartButton.setBackground(new java.awt.Color(217, 191, 157));
        MM_game1StartButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MM_game1StartButton.setForeground(java.awt.Color.white);
        MM_game1StartButton.setText("Start Game!");
        MM_game1StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_game1StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_game1StartButtonMousePressed(evt);
            }
        });
        game1.add(MM_game1StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 200, 40));

        game1HighScore.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game1HighScore.setForeground(java.awt.Color.white);
        game1HighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game1HighScore.setText("Not Set");
        game1.add(game1HighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 150, 30));

        game1Username.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game1Username.setForeground(java.awt.Color.white);
        game1Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game1Username.setText("1234567890123456789");
        game1Username.setToolTipText("");
        game1.add(game1Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 150, 30));

        game1Image_.setBackground(new java.awt.Color(153, 135, 108));
        game1Image_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/matchingGame.png"))); // NOI18N
        game1Image_.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        game1.add(game1Image_, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 145, 145));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        game1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 140));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel39.setForeground(java.awt.Color.white);
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Matching Game");
        game1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 200, 60));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel89.setForeground(java.awt.Color.white);
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setText("1 Player");
        game1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 150, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Game Type:");
        game1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 130, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Game Information:");
        game1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 300, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("User:");
        game1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 130, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Highest Score:");
        game1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 130, 30));

        gamesPanel.add(game1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 160));

        game2.setBackground(new java.awt.Color(200, 151, 115));
        game2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        game2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_game2StartButton.setBackground(new java.awt.Color(217, 191, 157));
        MM_game2StartButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MM_game2StartButton.setForeground(java.awt.Color.white);
        MM_game2StartButton.setText("Start Game!");
        MM_game2StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_game2StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_game2StartButtonMousePressed(evt);
            }
        });
        game2.add(MM_game2StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 200, 40));

        game2HighScore.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game2HighScore.setForeground(java.awt.Color.white);
        game2HighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game2HighScore.setText("----");
        game2.add(game2HighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 150, 30));

        game2Username.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game2Username.setForeground(java.awt.Color.white);
        game2Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game2Username.setText("----");
        game2Username.setToolTipText("");
        game2.add(game2Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 150, 30));

        game2Image.setBackground(new java.awt.Color(153, 135, 108));
        game2Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/dotsAndBoxes.png"))); // NOI18N
        game2Image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        game2.add(game2Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 145, 145));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        game2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 140));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel91.setForeground(java.awt.Color.white);
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setText("2 Players");
        game2.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 150, 30));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel92.setForeground(java.awt.Color.white);
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Dots and Boxes");
        game2.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 200, 60));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Game Type:");
        game2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 130, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Game Information:");
        game2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 300, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("User:");
        game2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 130, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Highest Score:");
        game2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 130, 30));

        gamesPanel.add(game2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 730, 160));

        game3.setBackground(new java.awt.Color(200, 151, 115));
        game3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        game3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_game3StartButton.setBackground(new java.awt.Color(217, 191, 157));
        MM_game3StartButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MM_game3StartButton.setForeground(java.awt.Color.white);
        MM_game3StartButton.setText("Start Game!");
        MM_game3StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_game3StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_game3StartButtonMousePressed(evt);
            }
        });
        game3.add(MM_game3StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 200, 40));

        game3HighScore.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game3HighScore.setForeground(java.awt.Color.white);
        game3HighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game3HighScore.setText("Not Set");
        game3.add(game3HighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 150, 30));

        game3Username.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game3Username.setForeground(java.awt.Color.white);
        game3Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game3Username.setText("Not Set");
        game3Username.setToolTipText("");
        game3.add(game3Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 150, 30));

        game3Image.setBackground(new java.awt.Color(153, 135, 108));
        game3Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pingPong.png"))); // NOI18N
        game3Image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        game3.add(game3Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 145, 145));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        game3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 140));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel23.setForeground(java.awt.Color.white);
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Ping Pong");
        game3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 200, 60));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel72.setForeground(java.awt.Color.white);
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("1-2 Players");
        game3.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 150, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Game Type:");
        game3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 130, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Game Information:");
        game3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 300, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("User:");
        game3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 130, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Highest Score:");
        game3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 130, 30));

        gamesPanel.add(game3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 730, 160));

        game4.setBackground(new java.awt.Color(200, 151, 115));
        game4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        game4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_game4StartButton.setBackground(new java.awt.Color(217, 191, 157));
        MM_game4StartButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MM_game4StartButton.setForeground(java.awt.Color.white);
        MM_game4StartButton.setText("Start Game!");
        MM_game4StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_game4StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_game4StartButtonMousePressed(evt);
            }
        });
        game4.add(MM_game4StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 200, 40));

        game4HighScore.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game4HighScore.setForeground(java.awt.Color.white);
        game4HighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game4HighScore.setText("----");
        game4.add(game4HighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 150, 30));

        game4Username.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game4Username.setForeground(java.awt.Color.white);
        game4Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game4Username.setText("----");
        game4Username.setToolTipText("");
        game4.add(game4Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 150, 30));

        game4Image.setBackground(new java.awt.Color(153, 135, 108));
        game4Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tank.png"))); // NOI18N
        game4Image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        game4.add(game4Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 145, 145));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        game4.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 140));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel48.setForeground(java.awt.Color.white);
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("2 Players");
        game4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 150, 30));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel45.setForeground(java.awt.Color.white);
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Tanks");
        game4.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 200, 60));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(java.awt.Color.white);
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Game Type:");
        game4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 130, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(java.awt.Color.white);
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Game Information:");
        game4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 300, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(java.awt.Color.white);
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("User:");
        game4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 130, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Highest Score:");
        game4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 130, 30));

        gamesPanel.add(game4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 730, 160));

        game5.setBackground(new java.awt.Color(200, 151, 115));
        game5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        game5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_game5StartButton.setBackground(new java.awt.Color(217, 191, 157));
        MM_game5StartButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MM_game5StartButton.setForeground(java.awt.Color.white);
        MM_game5StartButton.setText("Start Game!");
        MM_game5StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_game5StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_game5StartButtonMousePressed(evt);
            }
        });
        game5.add(MM_game5StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 200, 40));

        game5HighScore.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game5HighScore.setForeground(java.awt.Color.white);
        game5HighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game5HighScore.setText("----");
        game5.add(game5HighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 150, 30));

        game5Username.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game5Username.setForeground(java.awt.Color.white);
        game5Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game5Username.setText("----");
        game5Username.setToolTipText("");
        game5.add(game5Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 150, 30));

        game5Image.setBackground(new java.awt.Color(153, 135, 108));
        game5Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tag.png"))); // NOI18N
        game5Image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        game5.add(game5Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 145, 145));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        game5.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 140));

        jLabel61.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel61.setForeground(java.awt.Color.white);
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("2 Players");
        game5.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 150, 30));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel73.setForeground(java.awt.Color.white);
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Tag");
        game5.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 200, 60));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setForeground(java.awt.Color.white);
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel74.setText("Game Type:");
        game5.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 130, 30));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel86.setForeground(java.awt.Color.white);
        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setText("Game Information:");
        game5.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 300, 30));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setForeground(java.awt.Color.white);
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel87.setText("User:");
        game5.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 130, 30));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setForeground(java.awt.Color.white);
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel88.setText("Highest Score:");
        game5.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 130, 30));

        gamesPanel.add(game5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 730, 160));

        game6.setBackground(new java.awt.Color(200, 151, 115));
        game6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        game6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_game6StartButton.setBackground(new java.awt.Color(217, 191, 157));
        MM_game6StartButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        MM_game6StartButton.setForeground(java.awt.Color.white);
        MM_game6StartButton.setText("Start Game!");
        MM_game6StartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_game6StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_game6StartButtonMousePressed(evt);
            }
        });
        game6.add(MM_game6StartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 200, 40));

        game6HighScore.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game6HighScore.setForeground(java.awt.Color.white);
        game6HighScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game6HighScore.setText("999,999,999,999,999");
        game6.add(game6HighScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 150, 30));

        game6Username.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        game6Username.setForeground(java.awt.Color.white);
        game6Username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        game6Username.setText("Not Set");
        game6Username.setToolTipText("");
        game6.add(game6Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, 150, 30));

        game6Image.setBackground(new java.awt.Color(153, 135, 108));
        game6Image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/castleDefense.png"))); // NOI18N
        game6Image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        game6.add(game6Image, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 7, 145, 145));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        game6.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 30, 140));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel90.setForeground(java.awt.Color.white);
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("1 Player");
        game6.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 150, 30));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel93.setForeground(java.awt.Color.white);
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Castle Defense");
        game6.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 200, 60));

        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel118.setForeground(java.awt.Color.white);
        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel118.setText("Game Type:");
        game6.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 130, 30));

        jLabel119.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel119.setForeground(java.awt.Color.white);
        jLabel119.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel119.setText("Game Information:");
        game6.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 300, 30));

        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel120.setForeground(java.awt.Color.white);
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel120.setText("User:");
        game6.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 130, 30));

        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel121.setForeground(java.awt.Color.white);
        jLabel121.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel121.setText("Highest Score:");
        game6.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 130, 30));

        gamesPanel.add(game6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 860, 730, 160));

        gamesScrollFrame.setViewportView(gamesPanel);

        mainMenuFrame.add(gamesScrollFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 765, 590));

        MM_userSettingsPanel.setBackground(new java.awt.Color(153, 135, 108));
        MM_userSettingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_userSettingsCancelButton.setBackground(new java.awt.Color(200, 151, 115));
        MM_userSettingsCancelButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MM_userSettingsCancelButton.setForeground(java.awt.Color.white);
        MM_userSettingsCancelButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MM_userSettingsCancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_userSettingsCancelButton.setLabel("X");
        MM_userSettingsCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_userSettingsCancelButtonMousePressed(evt);
            }
        });
        MM_userSettingsPanel.add(MM_userSettingsCancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 40, 30));

        jPanel2.setBackground(new java.awt.Color(98, 82, 62));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MM_userSettingsPanelTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MM_userSettingsPanelTitle.setForeground(java.awt.Color.white);
        MM_userSettingsPanelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MM_userSettingsPanelTitle.setText("User Settings");
        jPanel2.add(MM_userSettingsPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 380, 20));

        MM_userSettingsPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Username:");
        MM_userSettingsPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 130, 30));

        MM_usernameInput.setBackground(new java.awt.Color(246, 228, 199));
        MM_usernameInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MM_userSettingsPanel.add(MM_usernameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 280, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Password:");
        MM_userSettingsPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 130, 30));

        MM_passwordInput.setBackground(new java.awt.Color(246, 228, 199));
        MM_passwordInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MM_userSettingsPanel.add(MM_passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 280, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Confirm Password:");
        MM_userSettingsPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, 30));

        MM_passwordConfirmInput.setBackground(new java.awt.Color(246, 228, 199));
        MM_passwordConfirmInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MM_userSettingsPanel.add(MM_passwordConfirmInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 280, 30));

        MM_saveSettingsButton.setBackground(new java.awt.Color(200, 151, 115));
        MM_saveSettingsButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MM_saveSettingsButton.setForeground(java.awt.Color.white);
        MM_saveSettingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MM_saveSettingsButton.setLabel("Save Settings");
        MM_saveSettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MM_saveSettingsButtonMousePressed(evt);
            }
        });
        MM_userSettingsPanel.add(MM_saveSettingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 430, 40));

        mainMenuFrame.add(MM_userSettingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 450, 220));

        getContentPane().add(mainMenuFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        game3Frame.setBackground(new java.awt.Color(214, 196, 172));
        game3Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PP_gameArea.setBackground(java.awt.Color.black);
        PP_gameArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PP_gameArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PP_gameAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PP_gameAreaKeyReleased(evt);
            }
        });
        PP_gameArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PP_cover.setBackground(new java.awt.Color(153, 135, 108));
        PP_cover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PP_startButton.setBackground(new java.awt.Color(214, 196, 172));
        PP_startButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PP_startButton.setForeground(java.awt.Color.black);
        PP_startButton.setText("Start Game!");
        PP_startButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PP_startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PP_startButtonMousePressed(evt);
            }
        });
        PP_cover.add(PP_startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 370, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(java.awt.Color.white);
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("How to Play?");
        jLabel22.setToolTipText("");
        PP_cover.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 40));

        PP_twoPlayerButton.setBackground(new java.awt.Color(204, 255, 204));
        PP_twoPlayerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PP_twoPlayerButton.setForeground(java.awt.Color.black);
        PP_twoPlayerButton.setText("Two Player Mode");
        PP_twoPlayerButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_twoPlayerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PP_twoPlayerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PP_twoPlayerButtonMousePressed(evt);
            }
        });
        PP_cover.add(PP_twoPlayerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 245, 370, 45));

        PP_singlePlayerModeCover.setBackground(new java.awt.Color(153, 135, 108));
        PP_singlePlayerModeCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel58.setForeground(java.awt.Color.white);
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setText("Move Up");
        PP_singlePlayerModeCover.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 95, 110, 35));

        jLabel59.setBackground(new java.awt.Color(153, 135, 108));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pongUpArrow.png"))); // NOI18N
        jLabel59.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_singlePlayerModeCover.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 95, 35, 35));

        jLabel60.setBackground(new java.awt.Color(153, 135, 108));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pongDownArrow.png"))); // NOI18N
        jLabel60.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_singlePlayerModeCover.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 95, 35, 35));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(java.awt.Color.white);
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Move Down");
        PP_singlePlayerModeCover.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 95, 110, 35));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel65.setForeground(java.awt.Color.white);
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Player Makes Goal: +100 Points");
        PP_singlePlayerModeCover.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 20));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel57.setForeground(java.awt.Color.white);
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Computer Makes Goal: -50 Points");
        PP_singlePlayerModeCover.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 180, 20));

        PP_gameDescription.setFont(new java.awt.Font("Segoe UI", 2, 17)); // NOI18N
        PP_gameDescription.setForeground(java.awt.Color.white);
        PP_gameDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PP_gameDescription.setText("Make as many goals as you can in ");
        PP_singlePlayerModeCover.add(PP_gameDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 380, 30));

        PP_cover.add(PP_singlePlayerModeCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 405, 140));

        PP_twoPlayerModeCover.setBackground(new java.awt.Color(153, 135, 108));
        PP_twoPlayerModeCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G3_gameDescription2.setFont(new java.awt.Font("Segoe UI", 2, 17)); // NOI18N
        G3_gameDescription2.setForeground(java.awt.Color.white);
        G3_gameDescription2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3_gameDescription2.setText("Score as many goals in");
        PP_twoPlayerModeCover.add(G3_gameDescription2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 380, 30));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel62.setForeground(java.awt.Color.white);
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel62.setText("Move Up P1");
        PP_twoPlayerModeCover.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 110, 35));

        jLabel63.setBackground(new java.awt.Color(153, 135, 108));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pingPong_wKey.png"))); // NOI18N
        jLabel63.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_twoPlayerModeCover.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 35, 35));

        jLabel66.setBackground(new java.awt.Color(153, 135, 108));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pingPong_sKey.png"))); // NOI18N
        jLabel66.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_twoPlayerModeCover.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 35, 35));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setForeground(java.awt.Color.white);
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("Move Down P1");
        PP_twoPlayerModeCover.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 35));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel68.setForeground(java.awt.Color.white);
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel68.setText("P2 Move Up ");
        jLabel68.setToolTipText("");
        PP_twoPlayerModeCover.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 110, 30));

        jLabel69.setBackground(new java.awt.Color(153, 135, 108));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pongUpArrow.png"))); // NOI18N
        jLabel69.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_twoPlayerModeCover.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 35, 35));

        jLabel70.setBackground(new java.awt.Color(153, 135, 108));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pongDownArrow.png"))); // NOI18N
        jLabel70.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_twoPlayerModeCover.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 35, 35));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel71.setForeground(java.awt.Color.white);
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("P2 Move Down");
        PP_twoPlayerModeCover.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 140, 35));

        PP_cover.add(PP_twoPlayerModeCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 405, 140));

        PP_gameArea.add(PP_cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 410, 300));

        PP_resetCover.setBackground(new java.awt.Color(153, 135, 108));
        PP_resetCover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_resetCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PP_resetButton.setBackground(new java.awt.Color(214, 196, 172));
        PP_resetButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PP_resetButton.setForeground(java.awt.Color.black);
        PP_resetButton.setText("Reset Game!");
        PP_resetButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PP_resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PP_resetButtonMousePressed(evt);
            }
        });
        PP_resetCover.add(PP_resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 370, 90));

        PP_gameArea.add(PP_resetCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 410, 120));

        PP_computer.setBackground(java.awt.Color.white);
        PP_computer.setForeground(java.awt.Color.white);
        PP_gameArea.add(PP_computer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 225, 10, 50));

        PP_playerEdge.setBackground(new java.awt.Color(204, 204, 204));
        PP_playerEdge.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PP_gameArea.add(PP_playerEdge, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 500));

        PP_computerEdge.setBackground(new java.awt.Color(204, 204, 204));
        PP_computerEdge.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PP_gameArea.add(PP_computerEdge, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 500));

        PP_player.setBackground(java.awt.Color.white);
        PP_player.setForeground(java.awt.Color.white);
        PP_player.setToolTipText("");
        PP_gameArea.add(PP_player, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 10, 50));

        PP_ball.setBackground(java.awt.Color.white);
        PP_gameArea.add(PP_ball, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 20, 20));

        PP_countDownTimer.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        PP_countDownTimer.setForeground(java.awt.Color.white);
        PP_countDownTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PP_countDownTimer.setText("3");
        PP_gameArea.add(PP_countDownTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 300, 80));

        game3Frame.add(PP_gameArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 720, 500));

        jPanel1.setBackground(new java.awt.Color(153, 135, 108));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PP_playerLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PP_playerLabel.setForeground(java.awt.Color.white);
        PP_playerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PP_playerLabel.setText("Player");
        PP_playerLabel.setToolTipText("");
        jPanel1.add(PP_playerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 5, 130, 40));

        PP_computerLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PP_computerLabel.setForeground(java.awt.Color.white);
        PP_computerLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PP_computerLabel.setText("Computer");
        PP_computerLabel.setToolTipText("");
        jPanel1.add(PP_computerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 5, 130, 40));

        PP_playerScore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PP_playerScore.setForeground(java.awt.Color.white);
        PP_playerScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PP_playerScore.setText("99");
        jPanel1.add(PP_playerScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 50, 40));

        PP_computerScore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PP_computerScore.setForeground(java.awt.Color.white);
        PP_computerScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PP_computerScore.setText("99");
        jPanel1.add(PP_computerScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 5, 50, 40));

        PP_scorePanel.setBackground(new java.awt.Color(153, 135, 108));
        PP_scorePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PP_scorePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel75.setForeground(java.awt.Color.white);
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel75.setText("Score:");
        jLabel75.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        PP_scorePanel.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 60, 20));

        PP_pointsPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PP_pointsPanel.setForeground(java.awt.Color.white);
        PP_pointsPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PP_pointsPanel.setText("999");
        PP_pointsPanel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        PP_scorePanel.add(PP_pointsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, 40, 20));

        jLabel77.setForeground(java.awt.Color.white);
        jLabel77.setText("Points");
        jLabel77.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        PP_scorePanel.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 15, 60, 20));

        jPanel1.add(PP_scorePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, 50));

        JPanel991.setBackground(new java.awt.Color(153, 135, 108));
        JPanel991.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPanel991.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(JPanel991, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 170, 50));

        game3Frame.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 55, 720, 50));

        PP_timerBar.setForeground(new java.awt.Color(0, 0, 0));
        PP_timerBar.setValue(50);
        game3Frame.add(PP_timerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 720, 30));

        getContentPane().add(game3Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        game2Frame.setBackground(new java.awt.Color(214, 196, 172));
        game2Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G2_resetBar.setBackground(new java.awt.Color(153, 135, 108));
        G2_resetBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G2_resetBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DB_resetButton.setBackground(new java.awt.Color(200, 151, 115));
        DB_resetButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DB_resetButton.setForeground(java.awt.Color.white);
        DB_resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_resetButton.setLabel("Reset Game");
        DB_resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_resetButtonMousePressed(evt);
            }
        });
        G2_resetBar.add(DB_resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 710, 30));

        game2Frame.add(G2_resetBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 720, 40));

        G2_gameArea.setBackground(new java.awt.Color(175, 155, 124));
        G2_gameArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G2_gameArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G2_player1.setBackground(new java.awt.Color(153, 135, 108));
        G2_player1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G2_player1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Player 1");
        G2_player1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 309, 40));

        DB_player1TopIcon.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        DB_player1TopIcon.setForeground(new java.awt.Color(255, 102, 102));
        DB_player1TopIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_player1TopIcon.setText("▲");
        DB_player1TopIcon.setAlignmentX(0.5F);
        G2_player1.add(DB_player1TopIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 2, 35, 35));

        G2_gameArea.add(G2_player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 359, 40));

        G2_player2.setBackground(new java.awt.Color(200, 151, 115));
        G2_player2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G2_player2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 2, 20)); // NOI18N
        jLabel24.setForeground(java.awt.Color.white);
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Player 2");
        G2_player2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 309, 40));

        DB_player2TopIcon.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        DB_player2TopIcon.setForeground(new java.awt.Color(102, 102, 255));
        DB_player2TopIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_player2TopIcon.setText("■");
        DB_player2TopIcon.setAlignmentX(0.5F);
        G2_player2.add(DB_player2TopIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2, 35, 35));

        G2_gameArea.add(G2_player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 1, 359, 40));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel26.setForeground(java.awt.Color.black);
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("●");
        G2_gameArea.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 40, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel27.setForeground(java.awt.Color.black);
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("●");
        G2_gameArea.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 40, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel28.setForeground(java.awt.Color.black);
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("●");
        G2_gameArea.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 40, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel29.setForeground(java.awt.Color.black);
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("●");
        G2_gameArea.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 40, 30));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel30.setForeground(java.awt.Color.black);
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("●");
        G2_gameArea.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 40, 30));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel33.setForeground(java.awt.Color.black);
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("●");
        G2_gameArea.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 40, 30));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel34.setForeground(java.awt.Color.black);
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("●");
        G2_gameArea.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 40, 30));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel35.setForeground(java.awt.Color.black);
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("●");
        G2_gameArea.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 40, 30));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel36.setForeground(java.awt.Color.black);
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("●");
        G2_gameArea.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 40, 30));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel37.setForeground(java.awt.Color.black);
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("●");
        G2_gameArea.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 40, 30));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel38.setForeground(java.awt.Color.black);
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("●");
        G2_gameArea.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 40, 30));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel40.setForeground(java.awt.Color.black);
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("●");
        G2_gameArea.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 40, 30));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel41.setForeground(java.awt.Color.black);
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("●");
        G2_gameArea.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 40, 30));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel42.setForeground(java.awt.Color.black);
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("●");
        G2_gameArea.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 40, 30));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel43.setForeground(java.awt.Color.black);
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("●");
        G2_gameArea.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 40, 30));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel44.setForeground(java.awt.Color.black);
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("●");
        G2_gameArea.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 40, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel31.setForeground(java.awt.Color.black);
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("●");
        G2_gameArea.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 40, 30));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel32.setForeground(java.awt.Color.black);
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("●");
        G2_gameArea.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 40, 30));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel46.setForeground(java.awt.Color.black);
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("●");
        G2_gameArea.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 40, 30));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel47.setForeground(java.awt.Color.black);
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("●");
        G2_gameArea.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 410, 40, 30));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel49.setForeground(java.awt.Color.black);
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("●");
        G2_gameArea.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 40, 30));

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel50.setForeground(java.awt.Color.black);
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("●");
        G2_gameArea.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 40, 30));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel51.setForeground(java.awt.Color.black);
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("●");
        G2_gameArea.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 40, 30));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel52.setForeground(java.awt.Color.black);
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("●");
        G2_gameArea.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 40, 30));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel53.setForeground(java.awt.Color.black);
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("●");
        G2_gameArea.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 40, 30));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel54.setForeground(java.awt.Color.black);
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("●");
        G2_gameArea.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 40, 30));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel55.setForeground(java.awt.Color.black);
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("●");
        G2_gameArea.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, 40, 30));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel56.setForeground(java.awt.Color.black);
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("●");
        G2_gameArea.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 410, 40, 30));

        DB_1.setBackground(new java.awt.Color(102, 102, 255));
        DB_1.setForeground(new java.awt.Color(102, 102, 255));
        DB_1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DB_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 126, 85, 10));

        DB_2.setBackground(new java.awt.Color(153, 153, 153));
        DB_2.setForeground(new java.awt.Color(102, 102, 255));
        DB_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 126, 85, 10));

        DB_3.setBackground(new java.awt.Color(102, 102, 255));
        DB_3.setForeground(new java.awt.Color(102, 102, 255));
        DB_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 126, 85, 10));

        DB_4.setBackground(new java.awt.Color(102, 102, 255));
        DB_4.setForeground(new java.awt.Color(102, 102, 255));
        DB_4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 126, 85, 10));

        DB_5.setBackground(new java.awt.Color(102, 102, 255));
        DB_5.setForeground(new java.awt.Color(102, 102, 255));
        DB_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 126, 85, 10));

        DB_6.setBackground(new java.awt.Color(102, 102, 255));
        DB_6.setForeground(new java.awt.Color(102, 102, 255));
        DB_6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 126, 85, 10));

        DB_14.setBackground(new java.awt.Color(102, 102, 255));
        DB_14.setForeground(new java.awt.Color(102, 102, 255));
        DB_14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 226, 85, 10));

        DB_15.setBackground(new java.awt.Color(102, 102, 255));
        DB_15.setForeground(new java.awt.Color(102, 102, 255));
        DB_15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 226, 85, 10));

        DB_16.setBackground(new java.awt.Color(102, 102, 255));
        DB_16.setForeground(new java.awt.Color(102, 102, 255));
        DB_16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_16, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 226, 85, 10));

        DB_17.setBackground(new java.awt.Color(102, 102, 255));
        DB_17.setForeground(new java.awt.Color(102, 102, 255));
        DB_17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 226, 85, 10));

        DB_18.setBackground(new java.awt.Color(102, 102, 255));
        DB_18.setForeground(new java.awt.Color(102, 102, 255));
        DB_18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 226, 85, 10));

        DB_19.setBackground(new java.awt.Color(102, 102, 255));
        DB_19.setForeground(new java.awt.Color(102, 102, 255));
        DB_19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 226, 85, 10));

        DB_27.setBackground(new java.awt.Color(102, 102, 255));
        DB_27.setForeground(new java.awt.Color(102, 102, 255));
        DB_27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_27, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 326, 85, 10));

        DB_28.setBackground(new java.awt.Color(102, 102, 255));
        DB_28.setForeground(new java.awt.Color(102, 102, 255));
        DB_28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_28, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 326, 85, 10));

        DB_29.setBackground(new java.awt.Color(102, 102, 255));
        DB_29.setForeground(new java.awt.Color(102, 102, 255));
        DB_29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_29, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 326, 85, 10));

        DB_30.setBackground(new java.awt.Color(102, 102, 255));
        DB_30.setForeground(new java.awt.Color(102, 102, 255));
        DB_30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_30, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 326, 85, 10));

        DB_31.setBackground(new java.awt.Color(102, 102, 255));
        DB_31.setForeground(new java.awt.Color(102, 102, 255));
        DB_31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_31, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 326, 85, 10));

        DB_32.setBackground(new java.awt.Color(102, 102, 255));
        DB_32.setForeground(new java.awt.Color(102, 102, 255));
        DB_32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_32, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 326, 85, 10));

        DB_40.setBackground(new java.awt.Color(102, 102, 255));
        DB_40.setForeground(new java.awt.Color(102, 102, 255));
        DB_40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_40, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 426, 85, 10));

        DB_41.setBackground(new java.awt.Color(102, 102, 255));
        DB_41.setForeground(new java.awt.Color(102, 102, 255));
        DB_41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_41, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 426, 85, 10));

        DB_42.setBackground(new java.awt.Color(102, 102, 255));
        DB_42.setForeground(new java.awt.Color(102, 102, 255));
        DB_42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_42, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 426, 85, 10));

        DB_43.setBackground(new java.awt.Color(102, 102, 255));
        DB_43.setForeground(new java.awt.Color(102, 102, 255));
        DB_43.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_43, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 426, 85, 10));

        DB_44.setBackground(new java.awt.Color(102, 102, 255));
        DB_44.setForeground(new java.awt.Color(102, 102, 255));
        DB_44.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_44, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 426, 85, 10));

        DB_45.setBackground(new java.awt.Color(102, 102, 255));
        DB_45.setForeground(new java.awt.Color(102, 102, 255));
        DB_45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_45, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 426, 85, 10));

        DB_7.setBackground(new java.awt.Color(255, 102, 102));
        DB_7.setForeground(new java.awt.Color(102, 102, 255));
        DB_7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 138, 10, 85));

        DB_8.setBackground(new java.awt.Color(255, 102, 102));
        DB_8.setForeground(new java.awt.Color(102, 102, 255));
        DB_8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_8, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 138, 10, 85));

        DB_9.setBackground(new java.awt.Color(255, 102, 102));
        DB_9.setForeground(new java.awt.Color(102, 102, 255));
        DB_9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 138, 10, 85));

        DB_10.setBackground(new java.awt.Color(255, 102, 102));
        DB_10.setForeground(new java.awt.Color(102, 102, 255));
        DB_10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 138, 10, 85));

        DB_11.setBackground(new java.awt.Color(255, 102, 102));
        DB_11.setForeground(new java.awt.Color(102, 102, 255));
        DB_11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 138, 10, 85));

        DB_12.setBackground(new java.awt.Color(255, 102, 102));
        DB_12.setForeground(new java.awt.Color(102, 102, 255));
        DB_12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_12, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 138, 10, 85));

        DB_13.setBackground(new java.awt.Color(255, 102, 102));
        DB_13.setForeground(new java.awt.Color(102, 102, 255));
        DB_13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 138, 10, 85));

        DB_20.setBackground(new java.awt.Color(255, 102, 102));
        DB_20.setForeground(new java.awt.Color(102, 102, 255));
        DB_20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_20, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 238, 10, 85));

        DB_21.setBackground(new java.awt.Color(255, 102, 102));
        DB_21.setForeground(new java.awt.Color(102, 102, 255));
        DB_21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 238, 10, 85));

        DB_22.setBackground(new java.awt.Color(255, 102, 102));
        DB_22.setForeground(new java.awt.Color(102, 102, 255));
        DB_22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 238, 10, 85));

        DB_23.setBackground(new java.awt.Color(255, 102, 102));
        DB_23.setForeground(new java.awt.Color(102, 102, 255));
        DB_23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 238, 10, 85));

        DB_24.setBackground(new java.awt.Color(255, 102, 102));
        DB_24.setForeground(new java.awt.Color(102, 102, 255));
        DB_24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 238, 10, 85));

        DB_25.setBackground(new java.awt.Color(255, 102, 102));
        DB_25.setForeground(new java.awt.Color(102, 102, 255));
        DB_25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 238, 10, 85));

        DB_26.setBackground(new java.awt.Color(255, 102, 102));
        DB_26.setForeground(new java.awt.Color(102, 102, 255));
        DB_26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 238, 10, 85));

        DB_33.setBackground(new java.awt.Color(255, 102, 102));
        DB_33.setForeground(new java.awt.Color(102, 102, 255));
        DB_33.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_33, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 338, 10, 85));

        DB_34.setBackground(new java.awt.Color(255, 102, 102));
        DB_34.setForeground(new java.awt.Color(102, 102, 255));
        DB_34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_34, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 338, 10, 85));

        DB_35.setBackground(new java.awt.Color(255, 102, 102));
        DB_35.setForeground(new java.awt.Color(102, 102, 255));
        DB_35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_35, new org.netbeans.lib.awtextra.AbsoluteConstraints(256, 338, 10, 85));

        DB_36.setBackground(new java.awt.Color(255, 102, 102));
        DB_36.setForeground(new java.awt.Color(102, 102, 255));
        DB_36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_36, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 338, 10, 85));

        DB_37.setBackground(new java.awt.Color(255, 102, 102));
        DB_37.setForeground(new java.awt.Color(102, 102, 255));
        DB_37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_37, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 338, 10, 85));

        DB_38.setBackground(new java.awt.Color(255, 102, 102));
        DB_38.setForeground(new java.awt.Color(102, 102, 255));
        DB_38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_38, new org.netbeans.lib.awtextra.AbsoluteConstraints(556, 338, 10, 85));

        DB_39.setBackground(new java.awt.Color(255, 102, 102));
        DB_39.setForeground(new java.awt.Color(102, 102, 255));
        DB_39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DB_39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DB_lineClicked(evt);
            }
        });
        G2_gameArea.add(DB_39, new org.netbeans.lib.awtextra.AbsoluteConstraints(656, 338, 10, 85));

        DB_b1.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b1.setForeground(new java.awt.Color(255, 102, 102));
        DB_b1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b1.setText("▲");
        G2_gameArea.add(DB_b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 135, 90, 90));

        DB_b2.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b2.setForeground(new java.awt.Color(102, 102, 255));
        DB_b2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b2.setText("■");
        G2_gameArea.add(DB_b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 135, 90, 90));

        DB_b3.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b3.setForeground(new java.awt.Color(102, 102, 255));
        DB_b3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b3.setText("■");
        G2_gameArea.add(DB_b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 135, 90, 90));

        DB_b4.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b4.setForeground(new java.awt.Color(102, 102, 255));
        DB_b4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b4.setText("■");
        G2_gameArea.add(DB_b4, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 135, 90, 90));

        DB_b5.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b5.setForeground(new java.awt.Color(102, 102, 255));
        DB_b5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b5.setText("■");
        G2_gameArea.add(DB_b5, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 135, 90, 90));

        DB_b6.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b6.setForeground(new java.awt.Color(102, 102, 255));
        DB_b6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b6.setText("■");
        G2_gameArea.add(DB_b6, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 135, 90, 90));

        DB_b7.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b7.setForeground(new java.awt.Color(255, 102, 102));
        DB_b7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b7.setText("▲");
        G2_gameArea.add(DB_b7, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 235, 90, 90));

        DB_b8.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b8.setForeground(new java.awt.Color(102, 102, 255));
        DB_b8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b8.setText("■");
        G2_gameArea.add(DB_b8, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 235, 90, 90));

        DB_b9.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b9.setForeground(new java.awt.Color(102, 102, 255));
        DB_b9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b9.setText("■");
        G2_gameArea.add(DB_b9, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 235, 90, 90));

        DB_b10.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b10.setForeground(new java.awt.Color(102, 102, 255));
        DB_b10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b10.setText("■");
        G2_gameArea.add(DB_b10, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 235, 90, 90));

        DB_b11.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b11.setForeground(new java.awt.Color(102, 102, 255));
        DB_b11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b11.setText("■");
        G2_gameArea.add(DB_b11, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 235, 90, 90));

        DB_b12.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b12.setForeground(new java.awt.Color(102, 102, 255));
        DB_b12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b12.setText("■");
        G2_gameArea.add(DB_b12, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 235, 90, 90));

        DB_b13.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b13.setForeground(new java.awt.Color(255, 102, 102));
        DB_b13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b13.setText("▲");
        G2_gameArea.add(DB_b13, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 335, 90, 90));

        DB_b14.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b14.setForeground(new java.awt.Color(102, 102, 255));
        DB_b14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b14.setText("■");
        G2_gameArea.add(DB_b14, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 335, 90, 90));

        DB_b15.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b15.setForeground(new java.awt.Color(102, 102, 255));
        DB_b15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b15.setText("■");
        G2_gameArea.add(DB_b15, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 335, 90, 90));

        DB_b16.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b16.setForeground(new java.awt.Color(102, 102, 255));
        DB_b16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b16.setText("■");
        G2_gameArea.add(DB_b16, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 335, 90, 90));

        DB_b17.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b17.setForeground(new java.awt.Color(102, 102, 255));
        DB_b17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b17.setText("■");
        G2_gameArea.add(DB_b17, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 335, 90, 90));

        DB_b18.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        DB_b18.setForeground(new java.awt.Color(102, 102, 255));
        DB_b18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DB_b18.setText("■");
        G2_gameArea.add(DB_b18, new org.netbeans.lib.awtextra.AbsoluteConstraints(565, 335, 90, 90));

        game2Frame.add(G2_gameArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 720, 530));

        getContentPane().add(game2Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        game5Frame.setBackground(new java.awt.Color(214, 196, 172));
        game5Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_cover.setBackground(new java.awt.Color(214, 196, 172));
        TA_cover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TA_cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_settingsPanel.setBackground(new java.awt.Color(214, 196, 172));
        TA_settingsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TA_settingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_saveSettingsButton.setBackground(new java.awt.Color(200, 151, 115));
        TA_saveSettingsButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TA_saveSettingsButton.setForeground(java.awt.Color.white);
        TA_saveSettingsButton.setText("Save and Close");
        TA_saveSettingsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_saveSettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TA_saveSettingsButtonMousePressed(evt);
            }
        });
        TA_settingsPanel.add(TA_saveSettingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 640, 80));

        jPanel14.setBackground(new java.awt.Color(153, 135, 108));
        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel117.setBackground(new java.awt.Color(200, 151, 115));
        jLabel117.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel117.setForeground(java.awt.Color.white);
        jLabel117.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel117.setText("Settings");
        jPanel14.add(jLabel117);

        TA_settingsPanel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 10, 736, 60));

        jPanel18.setBackground(new java.awt.Color(214, 196, 172));
        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_maxTaggerTime.setRequestFocusEnabled(false);
        jPanel18.add(TA_maxTaggerTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 60, 40));

        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel122.setForeground(java.awt.Color.black);
        jLabel122.setText("Max Tagger Time");
        jPanel18.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 160, 40));
        jPanel18.add(TA_runnerSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 60, 40));

        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel123.setForeground(java.awt.Color.black);
        jLabel123.setText("Runner Speed");
        jPanel18.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 160, 40));

        TA_resetRunnerSpeed.setBackground(new java.awt.Color(200, 151, 115));
        TA_resetRunnerSpeed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TA_resetRunnerSpeed.setForeground(java.awt.Color.white);
        TA_resetRunnerSpeed.setText("Reset");
        TA_resetRunnerSpeed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_resetRunnerSpeed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_resetButtonClicked(evt);
            }
        });
        jPanel18.add(TA_resetRunnerSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 70, 40));

        TA_resetMaxTaggerTime.setBackground(new java.awt.Color(200, 151, 115));
        TA_resetMaxTaggerTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TA_resetMaxTaggerTime.setForeground(java.awt.Color.white);
        TA_resetMaxTaggerTime.setText("Reset");
        TA_resetMaxTaggerTime.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_resetMaxTaggerTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_resetButtonClicked(evt);
            }
        });
        jPanel18.add(TA_resetMaxTaggerTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 70, 40));

        TA_resetTaggerSpeed.setBackground(new java.awt.Color(200, 151, 115));
        TA_resetTaggerSpeed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TA_resetTaggerSpeed.setForeground(java.awt.Color.white);
        TA_resetTaggerSpeed.setText("Reset");
        TA_resetTaggerSpeed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_resetTaggerSpeed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_resetButtonClicked(evt);
            }
        });
        jPanel18.add(TA_resetTaggerSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 154, 70, 40));
        jPanel18.add(TA_taggerSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 154, 60, 40));

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel124.setForeground(java.awt.Color.black);
        jLabel124.setText("Tagger Speed");
        jPanel18.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 154, 160, 40));

        TA_resetTimeFrozen.setBackground(new java.awt.Color(200, 151, 115));
        TA_resetTimeFrozen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TA_resetTimeFrozen.setForeground(java.awt.Color.white);
        TA_resetTimeFrozen.setText("Reset");
        TA_resetTimeFrozen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_resetTimeFrozen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_resetButtonClicked(evt);
            }
        });
        jPanel18.add(TA_resetTimeFrozen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 70, 40));
        jPanel18.add(TA_timeFrozen, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 60, 40));

        jLabel125.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel125.setForeground(java.awt.Color.black);
        jLabel125.setText("Time Frozen");
        jPanel18.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 160, 40));

        TA_resetBoostedSpeed.setBackground(new java.awt.Color(200, 151, 115));
        TA_resetBoostedSpeed.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TA_resetBoostedSpeed.setForeground(java.awt.Color.white);
        TA_resetBoostedSpeed.setText("Reset");
        TA_resetBoostedSpeed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_resetBoostedSpeed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_resetButtonClicked(evt);
            }
        });
        jPanel18.add(TA_resetBoostedSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 70, 40));
        jPanel18.add(TA_boostedSpeed, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 60, 40));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel126.setForeground(java.awt.Color.black);
        jLabel126.setText("Boost Speed");
        jPanel18.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 160, 40));

        TA_resetBoostRespawnTime.setBackground(new java.awt.Color(200, 151, 115));
        TA_resetBoostRespawnTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TA_resetBoostRespawnTime.setForeground(java.awt.Color.white);
        TA_resetBoostRespawnTime.setText("Reset");
        TA_resetBoostRespawnTime.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_resetBoostRespawnTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_resetButtonClicked(evt);
            }
        });
        jPanel18.add(TA_resetBoostRespawnTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 70, 40));
        jPanel18.add(TA_boostRespawnTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 60, 40));

        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel127.setForeground(java.awt.Color.black);
        jLabel127.setText("Boost Respawn Time");
        jPanel18.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 160, 40));

        TA_resetBoostedTime.setBackground(new java.awt.Color(200, 151, 115));
        TA_resetBoostedTime.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TA_resetBoostedTime.setForeground(java.awt.Color.white);
        TA_resetBoostedTime.setText("Reset");
        TA_resetBoostedTime.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_resetBoostedTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_resetButtonClicked(evt);
            }
        });
        jPanel18.add(TA_resetBoostedTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 154, 70, 40));
        jPanel18.add(TA_boostedTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 154, 60, 40));

        jLabel128.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel128.setForeground(java.awt.Color.black);
        jLabel128.setText("Boosted Time");
        jPanel18.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 154, 160, 40));

        TA_resetGravity.setBackground(new java.awt.Color(200, 151, 115));
        TA_resetGravity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TA_resetGravity.setForeground(java.awt.Color.white);
        TA_resetGravity.setText("Reset");
        TA_resetGravity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_resetGravity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_resetButtonClicked(evt);
            }
        });
        jPanel18.add(TA_resetGravity, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 70, 40));
        jPanel18.add(TA_gravity, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 60, 40));

        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        jLabel129.setForeground(java.awt.Color.black);
        jLabel129.setText("Gravity");
        jPanel18.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, 160, 40));

        TA_settingsPanel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 730, 290));

        TA_cover.add(TA_settingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 765, 515));

        TA_settings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/settings.png"))); // NOI18N
        TA_settings.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TA_settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_settingsMouseClicked(evt);
            }
        });
        TA_cover.add(TA_settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 80, 55, 50));

        jLabel94.setBackground(java.awt.Color.black);
        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel94.setForeground(java.awt.Color.black);
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Left - \"A\"");
        TA_cover.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 360, 40));

        jLabel95.setBackground(java.awt.Color.black);
        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(51, 51, 51));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Player 2");
        TA_cover.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 360, 50));

        jLabel96.setBackground(java.awt.Color.black);
        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel96.setForeground(java.awt.Color.black);
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("Jump - \"Up Arrow\"");
        TA_cover.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 360, 40));

        jPanel12.setBackground(new java.awt.Color(151, 133, 108));
        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel98.setBackground(java.awt.Color.white);
        jLabel98.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel98.setForeground(java.awt.Color.white);
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("- Game Instructions -");
        jPanel12.add(jLabel98);

        TA_cover.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 730, 60));

        jLabel102.setBackground(java.awt.Color.black);
        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(51, 51, 51));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("are the tagger, first to fill it up looses!");
        TA_cover.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 720, 50));

        jLabel103.setBackground(java.awt.Color.black);
        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel103.setForeground(java.awt.Color.black);
        jLabel103.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel103.setText("Right - \"Right Arrow\"");
        TA_cover.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 360, 40));

        jLabel104.setBackground(java.awt.Color.black);
        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel104.setForeground(java.awt.Color.black);
        jLabel104.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel104.setText("Left - \"Left Arrow\"");
        TA_cover.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 360, 40));

        jLabel105.setBackground(java.awt.Color.black);
        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel105.setForeground(java.awt.Color.black);
        jLabel105.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel105.setText("Right - \"D\"");
        TA_cover.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 360, 40));

        jLabel106.setBackground(java.awt.Color.black);
        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel106.setForeground(java.awt.Color.black);
        jLabel106.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel106.setText("Jump - \"W\"");
        TA_cover.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 360, 40));

        jLabel107.setBackground(java.awt.Color.black);
        jLabel107.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(51, 51, 51));
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("Player 1");
        TA_cover.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 360, 50));

        jLabel108.setBackground(java.awt.Color.black);
        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(51, 51, 51));
        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("Run to tag your opponent! The player tagged");
        TA_cover.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 720, 50));

        jLabel109.setBackground(java.awt.Color.black);
        jLabel109.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(51, 51, 51));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("will be frozen for a bit. The bar fills up as you");
        TA_cover.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 720, 50));
        TA_cover.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 265, 680, 10));

        jPanel10.setBackground(new java.awt.Color(5, 180, 89));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TA_cover.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 92, 30, 30));

        jPanel11.setBackground(new java.awt.Color(237, 28, 26));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TA_cover.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(465, 92, 30, 30));

        jPanel13.setBackground(new java.awt.Color(151, 133, 108));
        jPanel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_startButton.setBackground(new java.awt.Color(200, 151, 115));
        TA_startButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TA_startButton.setForeground(java.awt.Color.white);
        TA_startButton.setText("[ Press To Start ]");
        TA_startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_startButtonMouseClicked(evt);
            }
        });
        jPanel13.add(TA_startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 40));

        TA_cover.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 730, 60));

        game5Frame.add(TA_cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 765, 515));

        TA_gameBox.setBackground(new java.awt.Color(186, 173, 155));
        TA_gameBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        TA_gameBox.setForeground(new java.awt.Color(102, 255, 102));
        TA_gameBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TA_gameBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TA_gameBoxKeyReleased(evt);
            }
        });
        TA_gameBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_choosePlayerPanel.setBackground(new java.awt.Color(153, 135, 108));
        TA_choosePlayerPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TA_choosePlayerPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_startingPlayer.setBackground(java.awt.Color.white);
        TA_startingPlayer.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        TA_startingPlayer.setForeground(java.awt.Color.white);
        TA_startingPlayer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TA_startingPlayer.setText("<starting player>");
        TA_choosePlayerPanel.add(TA_startingPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 55, 310, 60));

        TA_choosePlayerTitle.setBackground(java.awt.Color.white);
        TA_choosePlayerTitle.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        TA_choosePlayerTitle.setForeground(java.awt.Color.white);
        TA_choosePlayerTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TA_choosePlayerTitle.setText("Starting Player:");
        TA_choosePlayerPanel.add(TA_choosePlayerTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 60));

        TA_startingPlayerButton.setBackground(new java.awt.Color(200, 151, 115));
        TA_startingPlayerButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TA_startingPlayerButton.setForeground(java.awt.Color.white);
        TA_startingPlayerButton.setText("Start Game");
        TA_startingPlayerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TA_startingPlayerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TA_startingPlayerButtonMouseClicked(evt);
            }
        });
        TA_choosePlayerPanel.add(TA_startingPlayerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 310, 60));

        TA_gameBox.add(TA_choosePlayerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 350, 190));

        TA_player1.setBackground(new java.awt.Color(5, 180, 89));
        TA_player1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TA_player1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_player1Indicator.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TA_player1Indicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TA_player1Indicator.setText("●");
        TA_player1Indicator.setToolTipText("");
        TA_player1.add(TA_player1Indicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -2, 30, 30));

        TA_gameBox.add(TA_player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 30, 30));

        TA_player2.setBackground(new java.awt.Color(237, 28, 26));
        TA_player2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TA_player2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_player2Indicator.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TA_player2Indicator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TA_player2Indicator.setText("●");
        TA_player2Indicator.setToolTipText("");
        TA_player2.add(TA_player2Indicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -2, 30, 30));

        TA_gameBox.add(TA_player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 30, 30));

        TA_boost1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tag_boost.png"))); // NOI18N
        TA_gameBox.add(TA_boost1, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 10, 50, 50));

        TA_boost2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tag_boost.png"))); // NOI18N
        TA_gameBox.add(TA_boost2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 430, 50, 50));

        TA_floor0.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor0.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor0.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor0, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 345, 100, 30));

        TA_floor1.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor1.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 485, 763, 30));

        TA_floor2.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor2.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(483, 205, 280, 30));

        TA_floor3.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor3.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 415, 240, 30));

        TA_floor4.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor4.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 345, 100, 30));

        TA_floor5.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor5.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 345, 100, 30));

        TA_floor6.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor6.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 345, 100, 30));

        TA_floor7.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor7.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 345, 100, 30));

        TA_floor8.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor8.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 415, 240, 30));

        TA_floor9.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor9.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 620, 30));

        TA_floor10.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor10.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor10, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 135, 140, 30));

        TA_floor11.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor11.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 205, 280, 30));

        TA_floor12.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor12.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 65, 380, 30));

        TA_floor13.setBackground(new java.awt.Color(204, 204, 204));
        TA_floor13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TA_floor13.setForeground(new java.awt.Color(60, 63, 65));
        TA_gameBox.add(TA_floor13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 135, 140, 30));

        game5Frame.add(TA_gameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 765, 515));

        TA_topBar.setBackground(new java.awt.Color(153, 135, 108));
        TA_topBar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TA_topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(237, 28, 26));
        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_player2Time.setBackground(java.awt.Color.white);
        TA_player2Time.setForeground(new java.awt.Color(255, 102, 102));
        TA_player2Time.setValue(50);
        jPanel15.add(TA_player2Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 210, 50));

        TA_topBar.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 6, 220, 60));

        jPanel16.setBackground(new java.awt.Color(5, 180, 89));
        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TA_player1Time.setBackground(java.awt.Color.white);
        TA_player1Time.setForeground(new java.awt.Color(153, 255, 153));
        TA_player1Time.setValue(50);
        jPanel16.add(TA_player1Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 210, 50));

        TA_topBar.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 6, 220, 60));

        JLabel.setBackground(java.awt.Color.white);
        JLabel.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        JLabel.setForeground(java.awt.Color.white);
        JLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLabel.setText("Player 2");
        TA_topBar.add(JLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 5, 140, 60));

        JLabel19.setBackground(java.awt.Color.white);
        JLabel19.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        JLabel19.setForeground(java.awt.Color.white);
        JLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLabel19.setText("Player 1");
        TA_topBar.add(JLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 140, 60));

        game5Frame.add(TA_topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 765, 70));

        getContentPane().add(game5Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        game4Frame.setBackground(new java.awt.Color(214, 196, 172));
        game4Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_gameBox.setBackground(new java.awt.Color(186, 173, 155));
        T_gameBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        T_gameBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                T_gameBoxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                T_gameBoxKeyReleased(evt);
            }
        });
        T_gameBox.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_matchCover.setBackground(new java.awt.Color(153, 135, 108));
        T_matchCover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        T_matchCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_matchCoverButton.setBackground(new java.awt.Color(200, 151, 115));
        T_matchCoverButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        T_matchCoverButton.setForeground(java.awt.Color.white);
        T_matchCoverButton.setText("Continue");
        T_matchCoverButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_matchCoverButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_matchCoverButtonMouseClicked(evt);
            }
        });
        T_matchCover.add(T_matchCoverButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 370, 40));

        T_matchWinnerText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        T_matchWinnerText.setForeground(java.awt.Color.white);
        T_matchWinnerText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_matchWinnerText.setText("Player <1/2> Wins!");
        T_matchCover.add(T_matchWinnerText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 370, 40));

        T_gameBox.add(T_matchCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 390, 110));

        T_explosion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tank_explosion.png"))); // NOI18N
        T_gameBox.add(T_explosion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 50, 50));

        T_ball.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        T_ball.setForeground(new java.awt.Color(102, 102, 102));
        T_ball.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_ball.setText("●");
        T_gameBox.add(T_ball, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 310, 15, 15));

        T_mapItem1.setBackground(new java.awt.Color(204, 204, 204));
        T_mapItem1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        T_mapItem1.setForeground(new java.awt.Color(60, 63, 65));
        T_gameBox.add(T_mapItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 100, 100));

        T_mapItem2.setBackground(new java.awt.Color(204, 204, 204));
        T_mapItem2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        T_mapItem2.setForeground(new java.awt.Color(60, 63, 65));
        T_gameBox.add(T_mapItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 100, 230));

        T_floor.setBackground(new java.awt.Color(186, 205, 146));
        T_floor.setForeground(new java.awt.Color(60, 63, 65));
        T_floor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_gasBar.setForeground(new java.awt.Color(0, 153, 0));
        T_gasBar.setValue(50);
        T_gasBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        T_floor.add(T_gasBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 11, 140, 25));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel64.setForeground(java.awt.Color.white);
        jLabel64.setText("Gas:");
        T_floor.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 11, 50, 25));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel76.setForeground(java.awt.Color.white);
        jLabel76.setText("Power:");
        T_floor.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 11, 80, 25));

        jPanel4.setBackground(new java.awt.Color(217, 210, 200));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(java.awt.Color.white);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_player1Lifes.setBackground(java.awt.Color.red);
        T_player1Lifes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        T_player1Lifes.setForeground(java.awt.Color.red);
        T_player1Lifes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_player1Lifes.setText("     ♥     ");
        jPanel4.add(T_player1Lifes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 140, -1));

        T_floor.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 9, 140, 30));

        jPanel9.setBackground(new java.awt.Color(217, 210, 200));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setForeground(java.awt.Color.white);
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_player2Lifes.setBackground(java.awt.Color.red);
        T_player2Lifes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        T_player2Lifes.setForeground(java.awt.Color.red);
        T_player2Lifes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_player2Lifes.setText("  ♥   ♥  ");
        jPanel9.add(T_player2Lifes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 140, -1));

        T_floor.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(611, 9, 140, 30));

        T_powerBar.setForeground(new java.awt.Color(255, 51, 51));
        T_powerBar.setValue(50);
        T_powerBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        T_floor.add(T_powerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 11, 140, 25));

        T_gameBox.add(T_floor, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 465, 761, 48));

        T_mapItem3.setBackground(new java.awt.Color(204, 204, 204));
        T_mapItem3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        T_mapItem3.setForeground(new java.awt.Color(60, 63, 65));
        T_gameBox.add(T_mapItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 550, 40));
        T_gameBox.add(T_floorLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 463, 762, 30));

        T_player1.setBackground(java.awt.Color.white);
        T_player1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tank_p1.png"))); // NOI18N
        T_gameBox.add(T_player1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 48, 80, 80));

        T_player2.setBackground(java.awt.Color.white);
        T_player2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tank_p2.png"))); // NOI18N
        T_gameBox.add(T_player2, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 48, 80, 80));

        game4Frame.add(T_gameBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 765, 515));

        T_cover.setBackground(new java.awt.Color(214, 196, 172));
        T_cover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        T_cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_gameOverCover.setBackground(new java.awt.Color(214, 196, 172));
        T_gameOverCover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        T_gameOverCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_gameOverText.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        T_gameOverText.setForeground(java.awt.Color.white);
        T_gameOverText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_gameOverText.setText("Player <1/2> Wins Game!");
        T_gameOverCover.add(T_gameOverText, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 700, 130));

        T_restartGameButton.setBackground(new java.awt.Color(200, 151, 115));
        T_restartGameButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        T_restartGameButton.setForeground(java.awt.Color.white);
        T_restartGameButton.setText("Restart Game");
        T_restartGameButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_restartGameButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_restartGameButtonMouseClicked(evt);
            }
        });
        T_gameOverCover.add(T_restartGameButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 590, 80));

        T_cover.add(T_gameOverCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 740, 260));

        jLabel78.setBackground(java.awt.Color.black);
        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel78.setForeground(java.awt.Color.black);
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Left / Right - Arrow Buttons");
        T_cover.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 410, 50));

        jLabel80.setBackground(java.awt.Color.black);
        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 51, 51));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel80.setText("Movement:");
        T_cover.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 270, 50));

        jLabel81.setBackground(java.awt.Color.black);
        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel81.setForeground(java.awt.Color.black);
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("Up /  Down - Arrow Buttons");
        T_cover.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 410, 50));

        jLabel83.setBackground(java.awt.Color.black);
        jLabel83.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(51, 51, 51));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel83.setText("Angle:");
        T_cover.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 270, 50));
        T_cover.add(T_map1Cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, 200));
        T_cover.add(T_map2Cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 200, 200));
        T_cover.add(T_map3Cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 200, 200));

        T_map1Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tanks_map1.png"))); // NOI18N
        T_map1Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_map1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_map1ButtonMouseClicked(evt);
            }
        });
        T_cover.add(T_map1Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, 200));

        T_map2Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tanks_map2.png"))); // NOI18N
        T_map2Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_map2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_map1ButtonMouseClicked(evt);
            }
        });
        T_cover.add(T_map2Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 200, 200));

        T_map3Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/tanks_map3.png"))); // NOI18N
        T_map3Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        T_map3Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                T_map1ButtonMouseClicked(evt);
            }
        });
        T_cover.add(T_map3Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 200, 200));

        jPanel7.setBackground(new java.awt.Color(151, 133, 108));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel79.setBackground(java.awt.Color.white);
        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel79.setForeground(java.awt.Color.white);
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("- Game Instructions -");
        jPanel7.add(jLabel79);

        T_cover.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 730, 60));

        jPanel8.setBackground(new java.awt.Color(151, 133, 108));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel82.setBackground(java.awt.Color.white);
        jLabel82.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        jLabel82.setForeground(java.awt.Color.white);
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Choose A Map To Start :");
        jPanel8.add(jLabel82);

        T_cover.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 730, 60));

        jLabel84.setBackground(java.awt.Color.black);
        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(51, 51, 51));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel84.setText("Shoot:");
        T_cover.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 270, 50));

        jLabel85.setBackground(java.awt.Color.black);
        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel85.setForeground(java.awt.Color.black);
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("Spacebar");
        T_cover.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 410, 50));

        game4Frame.add(T_cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 765, 515));

        jPanel5.setBackground(new java.awt.Color(153, 135, 108));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(237, 28, 26));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_player2Score.setBackground(java.awt.Color.white);
        T_player2Score.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        T_player2Score.setForeground(java.awt.Color.white);
        T_player2Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_player2Score.setText("0");
        jPanel3.add(T_player2Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 50));

        jPanel5.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 5, 50, 60));

        jPanel6.setBackground(new java.awt.Color(5, 180, 89));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        T_player1Score.setBackground(java.awt.Color.white);
        T_player1Score.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        T_player1Score.setForeground(java.awt.Color.white);
        T_player1Score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        T_player1Score.setText("0");
        jPanel6.add(T_player1Score, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 30, 50));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 5, 50, 60));

        T_player2Indicator.setBackground(java.awt.Color.white);
        T_player2Indicator.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        T_player2Indicator.setForeground(new java.awt.Color(225, 225, 225));
        T_player2Indicator.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        T_player2Indicator.setText("Player 2 ]");
        jPanel5.add(T_player2Indicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 5, 270, 60));

        T_player1Indicator.setBackground(java.awt.Color.white);
        T_player1Indicator.setFont(new java.awt.Font("Segoe UI", 1, 34)); // NOI18N
        T_player1Indicator.setForeground(new java.awt.Color(225, 225, 225));
        T_player1Indicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        T_player1Indicator.setText("[ Player 1");
        jPanel5.add(T_player1Indicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 250, 60));

        game4Frame.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 765, 70));

        getContentPane().add(game4Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        loginFrame.setBackground(new java.awt.Color(214, 196, 172));
        loginFrame.setPreferredSize(new java.awt.Dimension(400, 350));
        loginFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginButtonsFrame.setBackground(new java.awt.Color(214, 196, 172));
        loginButtonsFrame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginButton.setBackground(new java.awt.Color(126, 195, 111));
        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        loginButton.setForeground(java.awt.Color.white);
        loginButton.setText("Log In");
        loginButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginButtonMousePressed(evt);
            }
        });
        loginButtonsFrame.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 348, 35));

        createAccountButton.setBackground(new java.awt.Color(102, 153, 255));
        createAccountButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        createAccountButton.setForeground(java.awt.Color.white);
        createAccountButton.setText("Create New Account");
        createAccountButton.setToolTipText("");
        createAccountButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createAccountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createAccountButtonMousePressed(evt);
            }
        });
        loginButtonsFrame.add(createAccountButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 348, 35));

        loginFrame.add(loginButtonsFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 100, 360, 100));

        loginTitle.setBackground(new java.awt.Color(204, 204, 204));
        loginTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginTitle.setForeground(java.awt.Color.black);
        loginTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginTitle.setText("Welcome! Please Log In");
        loginTitle.setToolTipText("");
        loginTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginFrame.add(loginTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 6, 348, -1));

        passwordConfirmInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordConfirmInput.setPreferredSize(new java.awt.Dimension(64, 25));
        loginFrame.add(passwordConfirmInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 110, 348, 30));

        loginLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/gameLogo.png"))); // NOI18N
        loginLogo.setText("loginSideLogo");
        loginLogo.setToolTipText("");
        loginLogo.setAlignmentY(0.0F);
        loginLogo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        loginFrame.add(loginLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 198, -1));

        usernameInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameInput.setToolTipText("");
        usernameInput.setPreferredSize(new java.awt.Dimension(73, 25));
        loginFrame.add(usernameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 37, 348, 30));

        passwordInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordInput.setPreferredSize(new java.awt.Dimension(64, 25));
        loginFrame.add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 73, 348, 30));

        createAccountCancelButton.setBackground(new java.awt.Color(255, 153, 153));
        createAccountCancelButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        createAccountCancelButton.setForeground(java.awt.Color.white);
        createAccountCancelButton.setToolTipText("");
        createAccountCancelButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createAccountCancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createAccountCancelButton.setLabel("X");
        createAccountCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createAccountCancelButtonClicked(evt);
            }
        });
        loginFrame.add(createAccountCancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 150, 50, 35));

        createAccountConfirmButton.setBackground(new java.awt.Color(102, 153, 255));
        createAccountConfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        createAccountConfirmButton.setForeground(java.awt.Color.white);
        createAccountConfirmButton.setToolTipText("");
        createAccountConfirmButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createAccountConfirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createAccountConfirmButton.setLabel("Register Account");
        createAccountConfirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createAccountConfirmButtonClicked(evt);
            }
        });
        loginFrame.add(createAccountConfirmButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 150, 294, 35));

        getContentPane().add(loginFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // =======================================================================================
    // ============================ GLOBAL VARIABLES =========================================
    // ---- User Control:                                                                 //||
    private String currentUser = "";                                                      //||
    private final UsersManager allUsers = new UsersManager();                             //||
    private final HighscoreManager scores = new HighscoreManager();                       //||
                                                                                          //||
                                                                                          //||
    // ---- Games:                                                                        //||
    private final MatchingGame MG = new MatchingGame();                                   //||
    private final DotsAndBoxesGame DB = new DotsAndBoxesGame();                           //||
    private final PingPong PP = new PingPong();                                           //||
    private final TanksGame T = new TanksGame();                                          //||
    private final Tag TA = new Tag();                                                     //||
    private final CastleDefense CD = new CastleDefense();                                 //||
    // =======================================================================================
    // =======================================================================================
    
    
    
    
// SWITCH FRAME ===========================================================================
    private void switchFrame(JPanel target){  
    // Hiding all panels
    mainMenuFrame.setVisible(false);
    MM_topBar.setVisible(false);
    loginFrame.setVisible(false);
    game1Frame.setVisible(false);
    game2Frame.setVisible(false);
    game3Frame.setVisible(false);
    game4Frame.setVisible(false);
    game5Frame.setVisible(false);
    game6Frame.setVisible(false);

    

    PP.stopGame(); // Stops the timers inside the ping pong game class
    T.stopGame();  // Stops the timers inside the tank game class
    TA.stopGame(); // Stops the timers inside the tag game class
    CD.stopGame(); // Stops the timers inside the castle defense game


    // Flipping between a login frame, main menu frame, or a game frame ----------------------------------
    if(target == loginFrame){
        this.setSize(580, 237);             // Make screen small for the log in section

        loginButtonsFrame.setVisible(true); // Showing the login frame
        usernameInput.setText("");          // Resetting username 
        passwordInput.setText("");          // Resetting password
        passwordConfirmInput.setText("");   // Resetting confirm password

        passwordConfirmInput.setVisible(false);       // Making password confirm input and section invis
        createAccountCancelButton.setVisible(false);  // Hiding the options for the register account
        createAccountConfirmButton.setVisible(false); // Hiding the options for the register account
    }
    else if(target == mainMenuFrame){
        this.setSize(800, 700);                               // Make screen big for anything other than the login screen
        MM_topBar.setVisible(true);                           // Show the top bar in main menu

        MM_username.setText("Welcome, " + currentUser + "!"); // Changing username on top bar
        MM_userSettingsPanel.setVisible(false);               // Hiding the user settings panel in case it was left open
        gamesScrollFrame.setVisible(true);                    // Showing the games panel
        MM_userSettingsButton.setVisible(true);               // Showing the user settings button
        MM_logOutButton.setVisible(true);                     // Showing the log out button
        MM_backToMenuButton.setVisible(false);                // Hiding the go back to menu since we are already there

        setHighscores();
    }

    // Target frame is a game frame 
    else{
        this.setSize(800, 700);                  // Make screen big for anything other than the login screen
        MM_topBar.setVisible(true);              // Show the top bar in game frames

        MM_userSettingsButton.setVisible(false); // Hiding user settings button
        MM_logOutButton.setVisible(false);       // Hiding log out button
        MM_backToMenuButton.setVisible(true);    // Showing the back to menu button

        // Setting the corresponding game reset and variables
        if(target == game1Frame){
            MM_username.setText("Matching Game"); // Changing the title to the game name
            MG_disableCover.setVisible(true);     // Showign the disable cover so player knows to start game 
            MG_timerBar.setValue(0);              // Set timer bar to zero 
            MG_timerBar.setVisible(false);        // Hide Timer bar
            MG_startButton.setVisible(true);      // Show the start button instead of timer bar
            MG_startButton.setText("Start Game!"); // Change text to reset next press
            G1_score.setText("0");                 // Sets the score back to 0
            MG.shuffle();                          // Shuffles and resets the board
        }
        else if(target == game2Frame){
            MM_username.setText("Dots and Boxes"); // Changing the title to the game name
            DB.resetBoard();
        }
        else if(target == game3Frame){
            MM_username.setText("Ping Pong");      // Changing game title
            PP_playerScore.setText("0");           // Reseting player 1 score
            PP_computerScore.setText("0");         // Resetting player 2 / computer score
            PP_pointsPanel.setText("0");           // Resetting points label
            PP_countDownTimer.setVisible(false);   // Hiding the countdown timer
            PP.reset();                            // Resetting the game

            // Setting to single player mode
            PP.setTwoPlayerMode(false);     // Setting game class to single player mode
            PP_twoPlayerModeCover.setVisible(false);   // Hiding the two player mode display
            PP_singlePlayerModeCover.setVisible(true); // Showing the single player mode display
            PP_computerLabel.setText("Computer");      // Changing player 2 label to computer
            PP_playerLabel.setText("Player");          // Changing the player 1 label to player
            PP_twoPlayerButton.setBackground(new Color(214,196,172)); // Setting color to unclicked
            PP_resetCover.setVisible(false);           // Hiding the reset button 
            PP_cover.setVisible(true);                 // Showing the game start cover
            PP_timerBar.setValue(0);                   // Resetting the time bar
        }
        else if(target == game4Frame){
            MM_username.setText("Tanks"); // Changing the title
            
            T_cover.setVisible(true);     // Showing the cover
            T_gameBox.setVisible(false);  // Hiding the game box
            T_gameOverCover.setVisible(false); // Hiding the game over cover
            T_matchCover.setVisible(false);    // Hiding the match cover 
            
            T_player1Score.setText("0");  // Resetting scores
            T_player2Score.setText("0");  // Resetting scores
            
            T_player1Indicator.setText("[ Player 1");
            T_player2Indicator.setText("Player 2 ]");
            
            map1WonBy = 0; // Resetting the matches won by 
            map2WonBy = 0;
            map3WonBy = 0;
            
            T_map1Cover.setVisible(false); // Hidding each cover
            T_map2Cover.setVisible(false);
            T_map3Cover.setVisible(false);
        }
        else if(target == game5Frame){
            MM_username.setText("Tag");     // Changing the title

            TA_player1Time.setValue(0);
            TA_player2Time.setValue(0);
            
            // Showing the cover instead of the game box
            TA_gameBox.setVisible(false);  // Hiding the game box
            TA_settingsPanel.setVisible(false); // Hiding the settings panel
            TA_cover.setVisible(true);     // Show the cover
        }
        else if(target == game6Frame){
            MM_username.setText("Castle Defense"); // Changing the title
            
            CD_menu.setLocation(0,535);            // Hiding the menu 
            CD_menuButton.setText("Open Menu");    // Resetting the menu button text
            CD_nextRoundButton.setVisible(true);   // Showing the start next roudn button so player can click
            CD_fastFowardButton.setSelected(false);// Resetting the fast foward button
            
            
            CD_cover.setVisible(true);             // Showing the cover 
            CD_gameBox.setVisible(false);          // Hiding the game box
            CD_gameEndedPanel.setVisible(false);   // Hiding the game ended panel 
            CD_gameBox.setLayout(null);            // This is needed for some reason, we saw last time
            CD.setScore_fromOutside(scores, currentUser); // Giving access to highscores since we need it at first
            CD.resetGame();                        // Resetting everything inside the game for a new game
        }
    }

    // Showing target panel ONLY after everything finishes setting up
    target.setVisible(true);
}
// ========================================================================================
    
    
// LOGIN FUNCTIONS ========================================================================
    private void loginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMousePressed
        loginButtonPressed(); // Had to move it to another function so that we can use the code in constructor to add action listener
    }//GEN-LAST:event_loginButtonMousePressed

    private void loginButtonPressed(){
        // Getting inputs 
        String tempUsername = usernameInput.getText();
        String tempPassword = passwordInput.getText();

        // Checking credentials
        if(!allUsers.checkCredentials(tempUsername, tempPassword)){     
            JOptionPane.showMessageDialog(null, "Credentials are not valid.");
            passwordInput.setText("");
            return;
        }
        
        // Saving the username for later use
        currentUser = tempUsername;
        
        // Taking to the login screen
        switchFrame(mainMenuFrame);
    }
    
    private void createAccountButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountButtonMousePressed
        loginButtonsFrame.setVisible(false);                    // Hide the login buttons to show confirm buttons
        
        passwordConfirmInput.setVisible(true);                 // Making password confirm input and section visible 
        createAccountCancelButton.setVisible(true);            
        createAccountConfirmButton.setVisible(true);           
    }//GEN-LAST:event_createAccountButtonMousePressed

    private void createAccountConfirmButtonClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountConfirmButtonClicked
        // Grabbing all the inputs
        String tempUsername = usernameInput.getText();
        String tempPassword = passwordInput.getText();
        String tempPasswordConfirm = passwordConfirmInput.getText();
        
        // Check if all inputs have something
        if(tempUsername == null || tempUsername.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Username cannot be empty.");
            return;
        }
        if(tempPassword == null || tempPassword.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password cannot be empty.");
            return;
        }
        if(tempPasswordConfirm == null || tempPassword.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Password Confirm cannot be empty.");
            return;
        }
        
        // Check that username and password DO NOT have [,] (comma)
        if(tempUsername.contains(",") || tempPassword.contains(",") || tempPasswordConfirm.contains(",")){
            JOptionPane.showMessageDialog(null, "Inputs cannot have the comma character.");
            return;
        }
        
        // Check if username has spaces
        if(tempUsername.contains(" ")){
            JOptionPane.showMessageDialog(null, "Usernames cannot have spaces.");
            usernameInput.setText("");
            return;
        }
        
        // Check if username is valid
        if(!allUsers.validUsername(tempUsername)){
            JOptionPane.showMessageDialog(null, "This username is already taken.");
            usernameInput.setText("");
            return;
        }
        
        // Check if passwords match
        if(!tempPassword.equals(tempPasswordConfirm)){
            JOptionPane.showMessageDialog(null, "Password do not match.");
            passwordInput.setText("");
            passwordConfirmInput.setText("");
            return;
        }
        
        // Create new user -> this method saves to file too
        allUsers.addUser(tempUsername, tempPassword);
        
        // Save the current username
        currentUser = tempUsername;
        
        // Switch to mainMenu Frame
        switchFrame(mainMenuFrame);
    }//GEN-LAST:event_createAccountConfirmButtonClicked

    private void createAccountCancelButtonClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountCancelButtonClicked
        switchFrame(loginFrame);
    }//GEN-LAST:event_createAccountCancelButtonClicked
    
// ========================================================================================
    
    
    
    
    
    
    
    
    
    
    
    
    
// MAIN MENU FUNCTIONS ====================================================================
    
    // USED TO SHOW THE HIGH SCORES OF THE GAMES --  ADD NEW GAMES HERE AS WE GO!
    private void setHighscores(){
        String singlePlayerMessage = "Single Player Game";
        game1HighScore.setText(scores.getHighscore("MG"));
        game1Username.setText(scores.getUsername("MG"));
        game2HighScore.setText(singlePlayerMessage);
        game2Username.setText(singlePlayerMessage);
        game3HighScore.setText(scores.getHighscore("PP"));
        game3Username.setText(scores.getUsername("PP"));
        game4HighScore.setText(singlePlayerMessage);
        game4Username.setText(singlePlayerMessage);
        game5HighScore.setText(singlePlayerMessage);
        game5Username.setText(singlePlayerMessage);
        game6HighScore.setText(scores.getHighscore("CD"));
        game6Username.setText(scores.getUsername("CD"));
    }
    
    private void MM_logOutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_logOutButtonMousePressed
        currentUser = "";
        switchFrame(loginFrame);
    }//GEN-LAST:event_MM_logOutButtonMousePressed

    private void MM_userSettingsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_userSettingsButtonMousePressed
        // Show the user settings panel and hide games panel
        gamesScrollFrame.setVisible(false);
        MM_userSettingsPanel.setVisible(true);
        
        // Erase previous data
        MM_usernameInput.setText("");
        MM_passwordInput.setText("");
        MM_passwordConfirmInput.setText("");
    }//GEN-LAST:event_MM_userSettingsButtonMousePressed

    private void MM_userSettingsCancelButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_userSettingsCancelButtonMousePressed
        // Hide the user settings panel and showing games panel
        MM_userSettingsPanel.setVisible(false);
        gamesScrollFrame.setVisible(true);
    }//GEN-LAST:event_MM_userSettingsCancelButtonMousePressed

    private void MM_saveSettingsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_saveSettingsButtonMousePressed
        // Check instance:
        // -> no change wanted
        // ----> C: everythig is empty 
        // ----> R: hide panel
        // -> usename change
        // ----> C: username are not empty
        // ----> R: verify username is unique, have no commas, change in files 
        // -> password change
        // ----> C: password are not empty
        // ----> R: verify passwords match, have no commas, change in files 
        
        // Grab inputs
        String tempUsername = MM_usernameInput.getText();
        String tempPassword = MM_passwordInput.getText();
        String tempConfirmPassword = MM_passwordConfirmInput.getText();
        
        // No change is needed
        if(tempUsername.trim().isEmpty() && tempPassword.trim().isEmpty() && tempConfirmPassword.trim().isEmpty()){
            MM_userSettingsPanel.setVisible(false);
            return;
        }
        
        // Username is changed
        boolean userChanged = false;
        if(!tempUsername.trim().isEmpty()){
            if(!allUsers.validUsername(tempUsername)){ // Username is not unique
                JOptionPane.showMessageDialog(null, "This username is already taken.");
                MM_usernameInput.setText("");
                return;
            }
            if(tempUsername.contains(",")){            // Username contains comma
                JOptionPane.showMessageDialog(null, "Username cannot contain commas");
                MM_usernameInput.setText("");
                return;
            }
              
            // ------ Username is valid -------
            
            // Change username object (this method also saves in file)
            allUsers.setUsername(currentUser, tempUsername);
            
            // Change temp memory after using it above
            currentUser = tempUsername;             
            userChanged = true;
        }
        
        // Password is changed (use the currentUser since its the most up to date info)
        boolean passChanged = false;
        if(!tempPassword.trim().isEmpty() || !tempConfirmPassword.trim().isEmpty()){
            if(tempPassword.contains(",") || tempConfirmPassword.contains(",")){       // Passwords contains comma
                JOptionPane.showMessageDialog(null, "Passwords cannot contain commas");
                MM_passwordInput.setText("");
                MM_passwordConfirmInput.setText("");
                return;
            }
            
            if(!tempPassword.equals(tempConfirmPassword)){                             // Passowrds do not match
                JOptionPane.showMessageDialog(null, "Passwords do not match.");
                MM_passwordInput.setText("");
                MM_passwordConfirmInput.setText("");
                return;
            }
            
            // ------ Password is valid -------
            
            // Change usesr passwords
            allUsers.setPassword(currentUser, tempPassword);
            passChanged = true;
        }
        
        // Showing user their new username and password
        if(userChanged || passChanged){
            String message = "Changes Made:\n";
            if(userChanged)
                message = message + "New Username: " + tempUsername + "\n";
            if(passChanged)
                message = message + "New Password: " + tempPassword + "\n";
            
            
            JOptionPane.showMessageDialog(null, message); // Show the message built above
            switchFrame(mainMenuFrame);  // Send back to main menu frame to reset the username on top
        }
        else{
            // If nothing was changed, show message that nothing was changed
            JOptionPane.showMessageDialog(null, "No changes made.");
        }
        
    }//GEN-LAST:event_MM_saveSettingsButtonMousePressed

    private void MM_backToMenuButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_backToMenuButtonMousePressed
        switchFrame(mainMenuFrame); // Simply goes back to main menu
    }//GEN-LAST:event_MM_backToMenuButtonMousePressed

    private void MM_game1StartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_game1StartButtonMousePressed
        switchFrame(game1Frame); // Switch into game 1 Frame
    }//GEN-LAST:event_MM_game1StartButtonMousePressed

    private void MM_game2StartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_game2StartButtonMousePressed
        switchFrame(game2Frame); // Switch into game 2 Frame
    }//GEN-LAST:event_MM_game2StartButtonMousePressed

    private void MM_game3StartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_game3StartButtonMousePressed
        switchFrame(game3Frame); // Switch into game 3 Frame
    }//GEN-LAST:event_MM_game3StartButtonMousePressed

    private void MM_game4StartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_game4StartButtonMousePressed
        switchFrame(game4Frame); // Switch into game 4 Frame
    }//GEN-LAST:event_MM_game4StartButtonMousePressed

    private void MM_game5StartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_game5StartButtonMousePressed
        switchFrame(game5Frame); // Switch into game 5 Frame
    }//GEN-LAST:event_MM_game5StartButtonMousePressed

    private void MM_game6StartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MM_game6StartButtonMousePressed
        switchFrame(game6Frame);
    }//GEN-LAST:event_MM_game6StartButtonMousePressed

    
// ========================================================================================
  
    
    
    
    
    
    
    
    
    
    
// GAME 1 FUNCTIONS ==================================================================== 
    private void MG_startButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MG_startButtonMousePressed
        // Resetting game by sending back into game 1 if user finished previous game
        if(MG_startButton.getText().equals("Play Again!")){
            switchFrame(game1Frame);
            return;
        }
        
        // Start game Flow:
        MG_disableCover.setVisible(false);     // Hide the disable cover to start the game
        MG_timerBar.setVisible(true);          // Show the timer bar
        MG_startButton.setVisible(false);      // Hide the start button
        MG_startButton.setText("Play Again!"); // Change text to reset next press
        
        // Update score object
        MG.setScore_fromOutside(scores, currentUser);
        
        // Start the timer for the game when start button is pressed
        MG.startGame();
    }//GEN-LAST:event_MG_startButtonMousePressed

    private void MG_cardClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MG_cardClicked
        if(MG.isBusy())                  // Checking if we are currently in showing timer, return if so
            return;
        if(MG_disableCover.isVisible()) // Checking if cover is visible (usually when the game ends or is starting)
            return;
        
        JLabel clickedLabel = (JLabel) evt.getSource();    // Getting the card that was clicked (we are really clicking on the card)
        int cardIndex = MG.getImages().indexOf(clickedLabel);
        
        if(cardIndex >= 0){                                // Double checking that it won't break
            boolean gameEnded = MG.selectCard(cardIndex);  // Selecting the card which handles the visuals
            if (gameEnded) {                               // If selectCard gave T, then all matches have been found
                MG.stopGame();
                String matchingPoints = G1_score.getText(); // Save the points given by matches before adding the time points
                
                MG.addTimeScore();      // Sending remaining time to add points, also updates the score
                MG_disableCover.setVisible(true);          // Covering up game
                MG_startButton.setVisible(true);           // Showing reset button 
                MG_timerBar.setVisible(false);             // Hiding game timer bar
                
                
                String timePoints = Integer.toString((MG.getRemainingTime())* MG.getTimeLeftScoreIncrease()); // Calculating the points made by time\
                MG.gameFinishedMessage("Game Completed!", matchingPoints, timePoints);                // Show message that the game ended with points
            }
        }
        
    }//GEN-LAST:event_MG_cardClicked
// ========================================================================================
    
    
    
    
    
 // GAME 2 FUNCTIONS ==================================================================== 
    private void DB_resetButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DB_resetButtonMousePressed
        switchFrame(game2Frame);
    }//GEN-LAST:event_DB_resetButtonMousePressed


    private void DB_lineClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DB_lineClicked
        if(DB.gameOver()) // If game is over, ignore all clicks
            return;
        
        JPanel clickedLine = (JPanel) evt.getSource();
        if(DB.lineClicked(clickedLine)){
           int winner = DB.getWinner();                 // Get the winner!
           String message = "Game Finished!\nResults: ";
           if(winner == 0)
               message = message + "DRAW!";
           else
               message = message + (winner == 1 ? "Player 1" : "Player 2") + " Wins!";
           JOptionPane.showMessageDialog(this, message);
        }
    }//GEN-LAST:event_DB_lineClicked

    // ========================================================================================
    
    
    
    
    
    
    
// GAME 3 FUNCTIONS ==================================================================== 
    private void PP_gameAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PP_gameAreaKeyPressed
        // If player is pushing the "P", they want to pause the game
        if(evt.getKeyCode() == KeyEvent.VK_P){
            // Making sure to ignore when the timer is visible and is counting down
            if(PP_countDownTimer.isVisible() && 
               !PP_countDownTimer.getText().equals("Game Paused")) 
                return;
            PP.setPause(!PP.getPause()); // Toggle the pause button
            if(PP.getPause())            // Pause the Game 
                PP.pauseGame();
            else                         // Continue the Game
                PP.continueGame();
        }
        
        if(PP_countDownTimer.getText().equals("Game Paused")) // If the countdown are numbers! then we can just ignore this key
            return;

        
        // Player hits a key to move their character
        if(!PP.isTwoPlayerMode()){ // If we are in single player
            if(evt.getKeyCode() == KeyEvent.VK_UP){ 
                PP.upPressed();
            }
            if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                PP.downPressed();
            }
        }
        
        else{
            if(evt.getKeyCode() == KeyEvent.VK_W){ // Player 1 plays with W/S
                PP.upPressed();
            }
            if(evt.getKeyCode() == KeyEvent.VK_S){
                PP.downPressed();
            }
            if(evt.getKeyCode() == KeyEvent.VK_UP){  // Player two plays with arrows
                PP.upPressed2();
            }
            if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                PP.downPressed2();
            }
        }
    }//GEN-LAST:event_PP_gameAreaKeyPressed

    private void PP_gameAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PP_gameAreaKeyReleased
        if(PP_countDownTimer.isVisible())
            return;
        
        if(!PP.isTwoPlayerMode()){
            if(evt.getKeyCode() == KeyEvent.VK_UP){
                PP.upReleased();
            }
            if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                PP.downReleased();
            }
        }
        else{
            if(evt.getKeyCode() == KeyEvent.VK_W){ // Player 1 plays with W/S
                PP.upReleased();
            }
            if(evt.getKeyCode() == KeyEvent.VK_S){
                PP.downReleased();
            }
            if(evt.getKeyCode() == KeyEvent.VK_UP){  // Player two plays with arrows
                PP.upReleased2();
            }
            if(evt.getKeyCode() == KeyEvent.VK_DOWN){
                PP.downReleased2();
            }
        }
    }//GEN-LAST:event_PP_gameAreaKeyReleased

    private void PP_startButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PP_startButtonMousePressed
        PP_cover.setVisible(false);         // Hide the cover 
        PP.startGame();                     // Start the game
        PP.setScores_fromOutside(scores,currentUser); // Send in again the scores from here
        PP_gameArea.requestFocusInWindow(); // Sends focus to the game window
    }//GEN-LAST:event_PP_startButtonMousePressed

    private void PP_resetButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PP_resetButtonMousePressed
        switchFrame(game3Frame);
    }//GEN-LAST:event_PP_resetButtonMousePressed

    private void PP_twoPlayerButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PP_twoPlayerButtonMousePressed
        if(!PP.isTwoPlayerMode()){ // Going into Two Player Mode
            PP_twoPlayerButton.setBackground(new Color(204,255,204));
            PP_twoPlayerModeCover.setVisible(true);
            PP_singlePlayerModeCover.setVisible(false);
            PP.setTwoPlayerMode(true);
            PP_scorePanel.setVisible(false);
            PP_computerLabel.setText("Player 2");
            PP_playerLabel.setText("Player 1");
           
        }
        else{ // Going into Single Player Mode
            PP_twoPlayerButton.setBackground(new Color(214,196,172));
            PP_twoPlayerModeCover.setVisible(false);
            PP_singlePlayerModeCover.setVisible(true);
            PP.setTwoPlayerMode(false);
            PP_scorePanel.setVisible(true);
            PP_computerLabel.setText("Computer");
            PP_playerLabel.setText("Player");
            
        }
    }//GEN-LAST:event_PP_twoPlayerButtonMousePressed

// ========================================================================================
 
    
    
    
    
// GAME 4 FUNCTIONS ====================================================================
    int map1WonBy = 0;
    int map2WonBy = 0;
    int map3WonBy = 0;
    private void T_map1ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_map1ButtonMouseClicked
        
        if(T_gameOverCover.isVisible())
            return;
        
        // Drawing the map depending on which button was pressed (1-3)
        JLabel clickedMap = (JLabel) evt.getSource();
        T_gameBox.setLayout(null);
        if(clickedMap == T_map1Button){
            if(map1WonBy != 0) // If someone already won this map, do not go into it
                return;
            T.drawMap(1);
        }
        else if(clickedMap == T_map2Button){
            if(map2WonBy != 0)
                return;
            T.drawMap(2);
        }
        else if(clickedMap == T_map3Button){
            if(map3WonBy != 0)
                return;
            T.drawMap(3);
        }
        
        // Uncovering the game after the map has loaded
        T_cover.setVisible(false);
        T_gameBox.setVisible(true);
        T_gameBox.requestFocusInWindow();  // Giving focus to the window so it can grab clicks
    }//GEN-LAST:event_T_map1ButtonMouseClicked

    private void T_gameBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T_gameBoxKeyPressed
        // Ignore inputs if the cover is visible 
        if(T_cover.isVisible())
            return;
        
        // Calling functions when keys are pressed down
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT  -> T.leftPressed();
            case KeyEvent.VK_RIGHT -> T.rightPressed();
            case KeyEvent.VK_UP    -> T.upPressed();
            case KeyEvent.VK_DOWN  -> T.downPressed();
            case KeyEvent.VK_SPACE -> T.spacePressed();
        }
    }//GEN-LAST:event_T_gameBoxKeyPressed

    private void T_gameBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_T_gameBoxKeyReleased
        // Ignore inputs if the cover is visible 
        if(T_cover.isVisible())
            return;
        
        // Calling functions when keys are pressed down
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT  -> T.leftReleased();
            case KeyEvent.VK_RIGHT -> T.rightReleased();
            case KeyEvent.VK_UP    -> T.upReleased();
            case KeyEvent.VK_DOWN  -> T.downReleased();
            case KeyEvent.VK_SPACE -> T.spaceReleased();
        }
        
        
    }//GEN-LAST:event_T_gameBoxKeyReleased

    private void T_matchCoverButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_matchCoverButtonMouseClicked
        // Saving who won the match so we can show that in the next screen
        switch(T.getMap()){
            case 1 -> {map1WonBy = T.getMatchWonBy();}
            case 2 -> {map2WonBy = T.getMatchWonBy();}
            case 3 -> {map3WonBy = T.getMatchWonBy();}
        }
        
        // Making the covers for the game maps if they have already been played and won by someone
        Color green = new Color(5,180,89,150);
        Color red = new Color(237,28,36,150);
        if(map1WonBy != 0){
            T_map1Cover.setBackground((map1WonBy == 1) ? green : red);
            T_map1Cover.setVisible(true); 
        }
        if(map2WonBy != 0){
            T_map2Cover.setBackground((map2WonBy == 1) ? green : red);
            T_map2Cover.setVisible(true);
        }
        if(map3WonBy != 0){
            T_map3Cover.setBackground((map3WonBy == 1) ? green : red);
            T_map3Cover.setVisible(true);
        }
        
        T_matchCover.setVisible(false); // Hiding again the match cover so that it does not show with through regular cover
        T_cover.setVisible(true); // Bringing back the cover with new covers on top
        T_gameBox.setVisible(false); // Hiding the game
        
        // If player 1 wins the entire game
        if((map1WonBy == 1 && map2WonBy == 1) ||
           (map1WonBy == 1 && map3WonBy == 1) ||
            map2WonBy == 1 && map3WonBy == 1){
            T_gameOverText.setText("Player 1 Wins Game!");
            T_gameOverCover.setVisible(true);
        }
        // If player 2 wins the entire game
        else if((map1WonBy == 2 && map2WonBy == 2) ||
                (map1WonBy == 2 && map3WonBy == 2) ||
                 map2WonBy == 2 && map3WonBy == 2){
            T_gameOverText.setText("Player 2 Wins Game!");
            T_gameOverCover.setVisible(true);
        }
    }//GEN-LAST:event_T_matchCoverButtonMouseClicked

    private void T_restartGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_T_restartGameButtonMouseClicked
        switchFrame(game4Frame);
    }//GEN-LAST:event_T_restartGameButtonMouseClicked


// ========================================================================================
    
    
    
    
// GAME 5 FUNCTIONS ====================================================================
    private void TA_startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TA_startButtonMouseClicked
       
        // Choosing a random player to be the tagger and changing the text to show user
        String startingPlayer = ((((int)(Math.random() * 2) + 1) == 1) ? "1" : "2");  // Choose the starting player and setting to string for next line
        TA_startingPlayer.setText("Player " + startingPlayer);
        
        // NOTE: We set up visuals here because we need them to be ready since
        //       player already sees the map at this point
        TA_player1.setLocation(120,360);  // Moving p1 to position
        TA_player2.setLocation(610,360);  // Moving p2 to position
        TA_player1Indicator.setVisible(false); // Hiding the indicator
        TA_player2Indicator.setVisible(false); // Hiding the indicator
        TA_boost1.setVisible(true);       // Showing the boost on top
        TA_boost2.setVisible(true);       // Showing the boost on the bottom
        
        // Reseting the chooseplayer panel
        TA_choosePlayerTitle.setText("Starting Player:");
        TA_startingPlayerButton.setText("Start Game");
        
       
        // After everything is ready, show the game
        TA_cover.setVisible(false);            // Hiding the game cover
        TA_choosePlayerPanel.setVisible(true); // Showing the starting player panel
        TA_gameBox.setVisible(true);           // Showing the game box
    }//GEN-LAST:event_TA_startButtonMouseClicked

    private void TA_startingPlayerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TA_startingPlayerButtonMouseClicked
        // If the panel showing with the replay button, then we are resetting
        if(TA_startingPlayerButton.getText().equals("Replay Game")){
            switchFrame(game5Frame);
            return;
        }
        
        TA_gameBox.requestFocusInWindow();   // Giving focus to the game box        

        // Hiding the panel to start the game
        TA_choosePlayerPanel.setVisible(false);
        TA_player1Indicator.setVisible(true);
        TA_player2Indicator.setVisible(true);
        
        
        // Setting the chooseplayer panel for when it comes back
        TA_choosePlayerTitle.setText("Winning Player:");
        TA_startingPlayerButton.setText("Replay Game");
        
        
        // Starting the game once the player agrees with starting player
        int startingPlayer = (TA_startingPlayer.getText().equals("Player 1") ? 1 : 2);
        TA.start(startingPlayer);
    }//GEN-LAST:event_TA_startingPlayerButtonMouseClicked

    private void TA_gameBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TA_gameBoxKeyPressed
        if(TA_choosePlayerPanel.isVisible())
            return;
        
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT  -> TA.p2LeftPressed();
            case KeyEvent.VK_RIGHT -> TA.p2RightPressed();
            case KeyEvent.VK_UP    -> TA.p2UpPressed();
            
            case KeyEvent.VK_W     -> TA.p1UpPressed();
            case KeyEvent.VK_A     -> TA.p1LeftPressed();
            case KeyEvent.VK_D     -> TA.p1RightPressed();
        }
    }//GEN-LAST:event_TA_gameBoxKeyPressed

    private void TA_gameBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TA_gameBoxKeyReleased
        if(TA_choosePlayerPanel.isVisible())
            return;
        
        // There is no up released because button is a tap, not a hold
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT  -> TA.p2LeftReleased();
            case KeyEvent.VK_RIGHT -> TA.p2RightReleased();
            case KeyEvent.VK_A     -> TA.p1LeftReleased();
            case KeyEvent.VK_D     -> TA.p1RightReleased();
        }
    }//GEN-LAST:event_TA_gameBoxKeyReleased

    private void TA_settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TA_settingsMouseClicked
        // Set up the variables shown to user
        TA_maxTaggerTime.setValue(TA.getGameMaxTime());
        TA_runnerSpeed.setValue(TA.getRunnerStep());
        TA_taggerSpeed.setValue(TA.getTaggerStep());
        TA_timeFrozen.setValue(TA.getTimeFrozen());
        TA_boostedSpeed.setValue(TA.getBoostStep());
        TA_boostRespawnTime.setValue(TA.getBoostRespawnTime());
        TA_boostedTime.setValue(TA.getBoostedTime());
        TA_gravity.setValue(TA.getGravity());
         
        // Show the settings panel
        TA_settingsPanel.setVisible(true);
        
        // Bug fix:
        TA_startButton.setVisible(false);
    }//GEN-LAST:event_TA_settingsMouseClicked

    private void TA_saveSettingsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TA_saveSettingsButtonMousePressed
        // Make the list
        JSpinner[] TA_spinners = {
            TA_maxTaggerTime, TA_runnerSpeed, TA_taggerSpeed, TA_timeFrozen,
            TA_boostedSpeed, TA_boostRespawnTime, TA_boostedTime, TA_gravity
        };
        
        // Committing every spinner
        for (JSpinner spinner : TA_spinners) {
            try {
                spinner.commitEdit();           
            } catch (java.text.ParseException e) {
                return;
            }
        }
        

        // Get values
        int maxTaggerTime    = (int) TA_maxTaggerTime.getValue();
        int runnerSpeed      = (int) TA_runnerSpeed.getValue();
        int taggerSpeed      = (int) TA_taggerSpeed.getValue();
        int timeFrozen       = (int) TA_timeFrozen.getValue();
        int boostedSpeed     = (int) TA_boostedSpeed.getValue();
        int boostRespawnTime = (int) TA_boostRespawnTime.getValue();
        int boostedTime      = (int) TA_boostedTime.getValue();
        double gravity       = (double) TA_gravity.getValue();
        
        // Validate Data (we already set up the bounds in the constructor, but this is just in case)
        if(maxTaggerTime < 0 || runnerSpeed < 0 || taggerSpeed < 0 || timeFrozen < 0 || boostedSpeed < 0 || boostRespawnTime < 0 || boostedTime < 0 || gravity  < 0)
            return;
        
        // Call Change Settings Function
        TA.changeSettings(maxTaggerTime, runnerSpeed, taggerSpeed, timeFrozen, boostedSpeed, boostRespawnTime, boostedTime, gravity);
        
        // Hide the settings panel
        TA_settingsPanel.setVisible(false);
        
        // Bug fix:
        TA_startButton.setVisible(true);
    }//GEN-LAST:event_TA_saveSettingsButtonMousePressed

    private void TA_resetButtonClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TA_resetButtonClicked
        String target;
        JButton buttonClicked = (JButton) evt.getSource();
        
        if     (buttonClicked == TA_resetMaxTaggerTime)    target = "GameMaxTime";
        else if(buttonClicked == TA_resetRunnerSpeed)      target = "RunnerStep";
        else if(buttonClicked == TA_resetTaggerSpeed)      target = "TagerStep";
        else if(buttonClicked == TA_resetTimeFrozen)       target = "TimeFrozen";
        else if(buttonClicked == TA_resetBoostedSpeed)     target = "BoostedStep";
        else if(buttonClicked == TA_resetBoostRespawnTime) target = "BoostRespawnTime";
        else if(buttonClicked == TA_resetBoostedTime)      target = "BoostedTime";
        else                                               target = "Gravity";
        
        TA.resetVariables(target);
    }//GEN-LAST:event_TA_resetButtonClicked

 // ========================================================================================
   
   
  
    
      
// GAME 6 FUNCTIONS ====================================================================   
    private void CD_startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_startButtonMouseClicked
        CD_gameBox.setVisible(true); // Showing the game box
        CD_cover.setVisible(false);  // Hiding the game cover
        CD_gameBox.setLayout(null);  // Setting the layout to null just in case
        
        // Sending in the current user and scores, mainly only used to set the current user, but eh doesnt hurt
        CD.setScore_fromOutside(scores, currentUser);
    }//GEN-LAST:event_CD_startButtonMouseClicked

    // Menu Button was clicked (open/close menu, cancel buy, close upgrade menu))
    private void CD_menuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_menuButtonMouseClicked
        if(!CD_messagePanel.isVisible())
            CD.menuButtonClicked();
    }//GEN-LAST:event_CD_menuButtonMouseClicked
    
    // Hovering over a location, show the hover. NEW: now also shows the range circle
    private void CD_placement1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_placement1MouseEntered
        // Send this location to the class, it wll handle eveyrthing there 
        JLabel currentPlacement = (JLabel)evt.getSource();
        if(!CD_messagePanel.isVisible())
            CD.highlightPlacement(currentPlacement);
    }//GEN-LAST:event_CD_placement1MouseEntered

    // The user wants to buy a tower, we find let the handler inside find out cost w the button
    private void CD_buyTower1ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_buyTower1ButtonMouseClicked
        // Sending in which tower buy button was clicked, we will find out later what the cost it
        JButton clickedButton = (JButton) evt.getSource();
        if(!CD_messagePanel.isVisible())
            CD.buyTowerButtonClicked(clickedButton);
    }//GEN-LAST:event_CD_buyTower1ButtonMouseClicked

    // Location was clicked, either an empty to buy or a tower to open upgrade
    private void CD_placement1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_placement1MouseClicked
        JLabel placementClicked = (JLabel) evt.getSource();
        if(!CD_messagePanel.isVisible())
            CD.placementClicked(placementClicked);
    }//GEN-LAST:event_CD_placement1MouseClicked

    // Category button is clicked to upgrade it
    private void CD_cat2ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_cat2ButtonMouseClicked
        JButton catButtonClicked = (JButton) evt.getSource();
        if(!CD_messagePanel.isVisible())
            CD.catButtonClicked(catButtonClicked);
    }//GEN-LAST:event_CD_cat2ButtonMouseClicked

    // Sell button was clicked in the upgrad emenu
    private void CD_upgradeSellButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_upgradeSellButtonMouseClicked
        if(!CD_messagePanel.isVisible())
            CD.upgradeSellButtonClicked();
    }//GEN-LAST:event_CD_upgradeSellButtonMouseClicked

    // Next round was clicked 
    private void CD_nextRoundButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_nextRoundButtonMouseClicked
        if(!CD_messagePanel.isVisible())
            CD.nextRoundButtonClicked();
    }//GEN-LAST:event_CD_nextRoundButtonMouseClicked

    // Restart button was clicked -> just send back to this game frame, it will reset everything
    private void CD_restartGameButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_restartGameButtonMouseClicked
        switchFrame(game6Frame);
    }//GEN-LAST:event_CD_restartGameButtonMouseClicked

    // If user moved into a path, we want to hide the range thing and set all to not highlighted
    private void CD_path1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_path1MouseEntered
        if(!CD_messagePanel.isVisible())
            CD.highlightPlacement(null);
        
            
    }//GEN-LAST:event_CD_path1MouseEntered

    // If user clicked the move button, handle inside the class
    private void CD_upgradeMoveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_upgradeMoveButtonMouseClicked
        if(!CD_messagePanel.isVisible())
            CD.upgradeMoveButtonClicked();
    }//GEN-LAST:event_CD_upgradeMoveButtonMouseClicked

    // User clicked continue on the message board that we are showing
    private void CD_messageContinueButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_messageContinueButtonMouseClicked
        CD.messageContinueButtonClicked(); // Making sure that the messagepanel is not visible
    }//GEN-LAST:event_CD_messageContinueButtonMouseClicked
    
    // User clicked out of the menu
    private void CD_path1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CD_path1MouseClicked
        if(!CD_messagePanel.isVisible())
            CD.closeAllMenus();
    }//GEN-LAST:event_CD_path1MouseClicked

    

    
// ========================================================================================
 
    
    
 
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUI_window().setVisible(true));
      
    }

    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CD_bottomBar;
    private javax.swing.JLabel CD_buyTower1;
    private javax.swing.JButton CD_buyTower1Button;
    private javax.swing.JLabel CD_buyTower2;
    private javax.swing.JButton CD_buyTower2Button;
    private javax.swing.JLabel CD_buyTower3;
    private javax.swing.JButton CD_buyTower3Button;
    private javax.swing.JLabel CD_buyTower4;
    private javax.swing.JButton CD_buyTower4Button;
    private javax.swing.JLabel CD_cash;
    private javax.swing.JLabel CD_cashMade;
    private javax.swing.JLabel CD_cashMadeStat;
    private javax.swing.JLabel CD_cashSymbol;
    private javax.swing.JLabel CD_castle;
    private javax.swing.JProgressBar CD_castleHealth;
    private javax.swing.JButton CD_cat1Button;
    private javax.swing.JProgressBar CD_cat1ProgressBar;
    private javax.swing.JButton CD_cat2Button;
    private javax.swing.JProgressBar CD_cat2ProgressBar;
    private javax.swing.JButton CD_cat3Button;
    private javax.swing.JProgressBar CD_cat3ProgressBar;
    private javax.swing.JPanel CD_cover;
    private javax.swing.JLabel CD_coverDes1;
    private javax.swing.JLabel CD_coverDes2;
    private javax.swing.JLabel CD_coverDes3;
    private javax.swing.JLabel CD_coverDes4;
    private javax.swing.JLabel CD_currentRoundStat;
    private javax.swing.JLabel CD_enemiesKilledStat;
    private javax.swing.JProgressBar CD_enemiesLeftBar;
    private javax.swing.JLabel CD_enemyExample;
    private javax.swing.JToggleButton CD_fastFowardButton;
    private javax.swing.JPanel CD_gameBox;
    private javax.swing.JLabel CD_gameDescription;
    private javax.swing.JLabel CD_gameEndedHighscoreIndicator;
    private javax.swing.JPanel CD_gameEndedPanel;
    private javax.swing.JLabel CD_gameEndedPoints;
    private javax.swing.JLabel CD_highscoreStat;
    private javax.swing.JLabel CD_lake;
    private javax.swing.JPanel CD_menu;
    private javax.swing.JButton CD_menuButton;
    private javax.swing.JButton CD_messageContinueButton;
    private javax.swing.JPanel CD_messagePanel;
    private javax.swing.JLabel CD_messageText;
    private javax.swing.JButton CD_nextRoundButton;
    private javax.swing.JPanel CD_path1;
    private javax.swing.JPanel CD_path2;
    private javax.swing.JPanel CD_path3;
    private javax.swing.JPanel CD_path4;
    private javax.swing.JPanel CD_path5;
    private javax.swing.JPanel CD_path6;
    private javax.swing.JLabel CD_placement1;
    private javax.swing.JLabel CD_placement10;
    private javax.swing.JLabel CD_placement100;
    private javax.swing.JLabel CD_placement101;
    private javax.swing.JLabel CD_placement102;
    private javax.swing.JLabel CD_placement103;
    private javax.swing.JLabel CD_placement104;
    private javax.swing.JLabel CD_placement105;
    private javax.swing.JLabel CD_placement106;
    private javax.swing.JLabel CD_placement107;
    private javax.swing.JLabel CD_placement108;
    private javax.swing.JLabel CD_placement11;
    private javax.swing.JLabel CD_placement111;
    private javax.swing.JLabel CD_placement112;
    private javax.swing.JLabel CD_placement113;
    private javax.swing.JLabel CD_placement114;
    private javax.swing.JLabel CD_placement115;
    private javax.swing.JLabel CD_placement116;
    private javax.swing.JLabel CD_placement117;
    private javax.swing.JLabel CD_placement118;
    private javax.swing.JLabel CD_placement119;
    private javax.swing.JLabel CD_placement12;
    private javax.swing.JLabel CD_placement120;
    private javax.swing.JLabel CD_placement121;
    private javax.swing.JLabel CD_placement122;
    private javax.swing.JLabel CD_placement123;
    private javax.swing.JLabel CD_placement124;
    private javax.swing.JLabel CD_placement125;
    private javax.swing.JLabel CD_placement126;
    private javax.swing.JLabel CD_placement127;
    private javax.swing.JLabel CD_placement128;
    private javax.swing.JLabel CD_placement129;
    private javax.swing.JLabel CD_placement13;
    private javax.swing.JLabel CD_placement130;
    private javax.swing.JLabel CD_placement131;
    private javax.swing.JLabel CD_placement132;
    private javax.swing.JLabel CD_placement133;
    private javax.swing.JLabel CD_placement134;
    private javax.swing.JLabel CD_placement135;
    private javax.swing.JLabel CD_placement136;
    private javax.swing.JLabel CD_placement137;
    private javax.swing.JLabel CD_placement138;
    private javax.swing.JLabel CD_placement139;
    private javax.swing.JLabel CD_placement14;
    private javax.swing.JLabel CD_placement140;
    private javax.swing.JLabel CD_placement145;
    private javax.swing.JLabel CD_placement15;
    private javax.swing.JLabel CD_placement16;
    private javax.swing.JLabel CD_placement17;
    private javax.swing.JLabel CD_placement18;
    private javax.swing.JLabel CD_placement19;
    private javax.swing.JLabel CD_placement2;
    private javax.swing.JLabel CD_placement20;
    private javax.swing.JLabel CD_placement21;
    private javax.swing.JLabel CD_placement22;
    private javax.swing.JLabel CD_placement23;
    private javax.swing.JLabel CD_placement24;
    private javax.swing.JLabel CD_placement25;
    private javax.swing.JLabel CD_placement26;
    private javax.swing.JLabel CD_placement27;
    private javax.swing.JLabel CD_placement28;
    private javax.swing.JLabel CD_placement29;
    private javax.swing.JLabel CD_placement3;
    private javax.swing.JLabel CD_placement30;
    private javax.swing.JLabel CD_placement31;
    private javax.swing.JLabel CD_placement32;
    private javax.swing.JLabel CD_placement33;
    private javax.swing.JLabel CD_placement34;
    private javax.swing.JLabel CD_placement35;
    private javax.swing.JLabel CD_placement36;
    private javax.swing.JLabel CD_placement37;
    private javax.swing.JLabel CD_placement38;
    private javax.swing.JLabel CD_placement4;
    private javax.swing.JLabel CD_placement41;
    private javax.swing.JLabel CD_placement42;
    private javax.swing.JLabel CD_placement43;
    private javax.swing.JLabel CD_placement44;
    private javax.swing.JLabel CD_placement45;
    private javax.swing.JLabel CD_placement46;
    private javax.swing.JLabel CD_placement47;
    private javax.swing.JLabel CD_placement48;
    private javax.swing.JLabel CD_placement49;
    private javax.swing.JLabel CD_placement5;
    private javax.swing.JLabel CD_placement50;
    private javax.swing.JLabel CD_placement51;
    private javax.swing.JLabel CD_placement52;
    private javax.swing.JLabel CD_placement53;
    private javax.swing.JLabel CD_placement54;
    private javax.swing.JLabel CD_placement55;
    private javax.swing.JLabel CD_placement56;
    private javax.swing.JLabel CD_placement57;
    private javax.swing.JLabel CD_placement58;
    private javax.swing.JLabel CD_placement59;
    private javax.swing.JLabel CD_placement6;
    private javax.swing.JLabel CD_placement60;
    private javax.swing.JLabel CD_placement61;
    private javax.swing.JLabel CD_placement62;
    private javax.swing.JLabel CD_placement63;
    private javax.swing.JLabel CD_placement64;
    private javax.swing.JLabel CD_placement65;
    private javax.swing.JLabel CD_placement66;
    private javax.swing.JLabel CD_placement67;
    private javax.swing.JLabel CD_placement68;
    private javax.swing.JLabel CD_placement69;
    private javax.swing.JLabel CD_placement7;
    private javax.swing.JLabel CD_placement70;
    private javax.swing.JLabel CD_placement71;
    private javax.swing.JLabel CD_placement72;
    private javax.swing.JLabel CD_placement73;
    private javax.swing.JLabel CD_placement74;
    private javax.swing.JLabel CD_placement77;
    private javax.swing.JLabel CD_placement78;
    private javax.swing.JLabel CD_placement79;
    private javax.swing.JLabel CD_placement8;
    private javax.swing.JLabel CD_placement80;
    private javax.swing.JLabel CD_placement81;
    private javax.swing.JLabel CD_placement82;
    private javax.swing.JLabel CD_placement83;
    private javax.swing.JLabel CD_placement84;
    private javax.swing.JLabel CD_placement85;
    private javax.swing.JLabel CD_placement86;
    private javax.swing.JLabel CD_placement87;
    private javax.swing.JLabel CD_placement88;
    private javax.swing.JLabel CD_placement89;
    private javax.swing.JLabel CD_placement9;
    private javax.swing.JLabel CD_placement90;
    private javax.swing.JLabel CD_placement91;
    private javax.swing.JLabel CD_placement92;
    private javax.swing.JLabel CD_placement93;
    private javax.swing.JLabel CD_placement94;
    private javax.swing.JLabel CD_placement95;
    private javax.swing.JLabel CD_placement96;
    private javax.swing.JLabel CD_placement97;
    private javax.swing.JLabel CD_placement98;
    private javax.swing.JLabel CD_placement99;
    private javax.swing.JLabel CD_pointsStat;
    private javax.swing.JButton CD_restartGameButton;
    private javax.swing.JLabel CD_roundDiedAt;
    private javax.swing.JButton CD_startButton;
    private javax.swing.JLabel CD_totalEnemiesKilled;
    private javax.swing.JLabel CD_tower1;
    private javax.swing.JLabel CD_tower2;
    private javax.swing.JLabel CD_tower3;
    private javax.swing.JLabel CD_tower4;
    private javax.swing.JLabel CD_upgradeDescription;
    private javax.swing.JPanel CD_upgradeMenu;
    private javax.swing.JButton CD_upgradeMoveButton;
    private javax.swing.JButton CD_upgradeSellButton;
    private javax.swing.JLabel CD_upgradeTower;
    private javax.swing.JPanel DB_1;
    private javax.swing.JPanel DB_10;
    private javax.swing.JPanel DB_11;
    private javax.swing.JPanel DB_12;
    private javax.swing.JPanel DB_13;
    private javax.swing.JPanel DB_14;
    private javax.swing.JPanel DB_15;
    private javax.swing.JPanel DB_16;
    private javax.swing.JPanel DB_17;
    private javax.swing.JPanel DB_18;
    private javax.swing.JPanel DB_19;
    private javax.swing.JPanel DB_2;
    private javax.swing.JPanel DB_20;
    private javax.swing.JPanel DB_21;
    private javax.swing.JPanel DB_22;
    private javax.swing.JPanel DB_23;
    private javax.swing.JPanel DB_24;
    private javax.swing.JPanel DB_25;
    private javax.swing.JPanel DB_26;
    private javax.swing.JPanel DB_27;
    private javax.swing.JPanel DB_28;
    private javax.swing.JPanel DB_29;
    private javax.swing.JPanel DB_3;
    private javax.swing.JPanel DB_30;
    private javax.swing.JPanel DB_31;
    private javax.swing.JPanel DB_32;
    private javax.swing.JPanel DB_33;
    private javax.swing.JPanel DB_34;
    private javax.swing.JPanel DB_35;
    private javax.swing.JPanel DB_36;
    private javax.swing.JPanel DB_37;
    private javax.swing.JPanel DB_38;
    private javax.swing.JPanel DB_39;
    private javax.swing.JPanel DB_4;
    private javax.swing.JPanel DB_40;
    private javax.swing.JPanel DB_41;
    private javax.swing.JPanel DB_42;
    private javax.swing.JPanel DB_43;
    private javax.swing.JPanel DB_44;
    private javax.swing.JPanel DB_45;
    private javax.swing.JPanel DB_5;
    private javax.swing.JPanel DB_6;
    private javax.swing.JPanel DB_7;
    private javax.swing.JPanel DB_8;
    private javax.swing.JPanel DB_9;
    private javax.swing.JLabel DB_b1;
    private javax.swing.JLabel DB_b10;
    private javax.swing.JLabel DB_b11;
    private javax.swing.JLabel DB_b12;
    private javax.swing.JLabel DB_b13;
    private javax.swing.JLabel DB_b14;
    private javax.swing.JLabel DB_b15;
    private javax.swing.JLabel DB_b16;
    private javax.swing.JLabel DB_b17;
    private javax.swing.JLabel DB_b18;
    private javax.swing.JLabel DB_b2;
    private javax.swing.JLabel DB_b3;
    private javax.swing.JLabel DB_b4;
    private javax.swing.JLabel DB_b5;
    private javax.swing.JLabel DB_b6;
    private javax.swing.JLabel DB_b7;
    private javax.swing.JLabel DB_b8;
    private javax.swing.JLabel DB_b9;
    private javax.swing.JLabel DB_player1TopIcon;
    private javax.swing.JLabel DB_player2TopIcon;
    private javax.swing.JButton DB_resetButton;
    private javax.swing.JPanel G1_card1;
    private javax.swing.JPanel G1_card10;
    private javax.swing.JPanel G1_card11;
    private javax.swing.JPanel G1_card12;
    private javax.swing.JPanel G1_card13;
    private javax.swing.JPanel G1_card14;
    private javax.swing.JPanel G1_card15;
    private javax.swing.JPanel G1_card16;
    private javax.swing.JPanel G1_card17;
    private javax.swing.JPanel G1_card18;
    private javax.swing.JPanel G1_card2;
    private javax.swing.JPanel G1_card3;
    private javax.swing.JPanel G1_card4;
    private javax.swing.JPanel G1_card5;
    private javax.swing.JPanel G1_card6;
    private javax.swing.JPanel G1_card7;
    private javax.swing.JPanel G1_card8;
    private javax.swing.JPanel G1_card9;
    private javax.swing.JLabel G1_cardImage1;
    private javax.swing.JLabel G1_cardImage10;
    private javax.swing.JLabel G1_cardImage11;
    private javax.swing.JLabel G1_cardImage12;
    private javax.swing.JLabel G1_cardImage13;
    private javax.swing.JLabel G1_cardImage14;
    private javax.swing.JLabel G1_cardImage15;
    private javax.swing.JLabel G1_cardImage16;
    private javax.swing.JLabel G1_cardImage17;
    private javax.swing.JLabel G1_cardImage18;
    private javax.swing.JLabel G1_cardImage2;
    private javax.swing.JLabel G1_cardImage3;
    private javax.swing.JLabel G1_cardImage4;
    private javax.swing.JLabel G1_cardImage5;
    private javax.swing.JLabel G1_cardImage6;
    private javax.swing.JLabel G1_cardImage7;
    private javax.swing.JLabel G1_cardImage8;
    private javax.swing.JLabel G1_cardImage9;
    private javax.swing.JLabel G1_cardValue1;
    private javax.swing.JLabel G1_cardValue10;
    private javax.swing.JLabel G1_cardValue11;
    private javax.swing.JLabel G1_cardValue12;
    private javax.swing.JLabel G1_cardValue13;
    private javax.swing.JLabel G1_cardValue14;
    private javax.swing.JLabel G1_cardValue15;
    private javax.swing.JLabel G1_cardValue16;
    private javax.swing.JLabel G1_cardValue17;
    private javax.swing.JLabel G1_cardValue18;
    private javax.swing.JLabel G1_cardValue2;
    private javax.swing.JLabel G1_cardValue3;
    private javax.swing.JLabel G1_cardValue4;
    private javax.swing.JLabel G1_cardValue5;
    private javax.swing.JLabel G1_cardValue6;
    private javax.swing.JLabel G1_cardValue7;
    private javax.swing.JLabel G1_cardValue8;
    private javax.swing.JLabel G1_cardValue9;
    private javax.swing.JLabel G1_score;
    private javax.swing.JPanel G2_gameArea;
    private javax.swing.JPanel G2_player1;
    private javax.swing.JPanel G2_player2;
    private javax.swing.JPanel G2_resetBar;
    private javax.swing.JLabel G3_gameDescription2;
    private javax.swing.JLabel JLabel;
    private javax.swing.JLabel JLabel19;
    private javax.swing.JPanel JPanel991;
    private javax.swing.JPanel MG_disableCover;
    private javax.swing.JPanel MG_gameArea;
    private javax.swing.JPanel MG_scoreBoard;
    private javax.swing.JButton MG_startButton;
    private javax.swing.JPanel MG_timeBoard;
    private javax.swing.JProgressBar MG_timerBar;
    private javax.swing.JButton MM_backToMenuButton;
    private javax.swing.JButton MM_game1StartButton;
    private javax.swing.JButton MM_game2StartButton;
    private javax.swing.JButton MM_game3StartButton;
    private javax.swing.JButton MM_game4StartButton;
    private javax.swing.JButton MM_game5StartButton;
    private javax.swing.JButton MM_game6StartButton;
    private javax.swing.JButton MM_logOutButton;
    private javax.swing.JTextField MM_passwordConfirmInput;
    private javax.swing.JTextField MM_passwordInput;
    private javax.swing.JButton MM_saveSettingsButton;
    private javax.swing.JPanel MM_topBar;
    private javax.swing.JButton MM_userSettingsButton;
    private javax.swing.JButton MM_userSettingsCancelButton;
    private javax.swing.JPanel MM_userSettingsPanel;
    private javax.swing.JLabel MM_userSettingsPanelTitle;
    private javax.swing.JLabel MM_username;
    private javax.swing.JTextField MM_usernameInput;
    private javax.swing.JPanel PP_ball;
    private javax.swing.JPanel PP_computer;
    private javax.swing.JPanel PP_computerEdge;
    private javax.swing.JLabel PP_computerLabel;
    private javax.swing.JLabel PP_computerScore;
    private javax.swing.JLabel PP_countDownTimer;
    private javax.swing.JPanel PP_cover;
    private javax.swing.JPanel PP_gameArea;
    private javax.swing.JLabel PP_gameDescription;
    private javax.swing.JPanel PP_player;
    private javax.swing.JPanel PP_playerEdge;
    private javax.swing.JLabel PP_playerLabel;
    private javax.swing.JLabel PP_playerScore;
    private javax.swing.JLabel PP_pointsPanel;
    private javax.swing.JButton PP_resetButton;
    private javax.swing.JPanel PP_resetCover;
    private javax.swing.JPanel PP_scorePanel;
    private javax.swing.JPanel PP_singlePlayerModeCover;
    private javax.swing.JButton PP_startButton;
    private javax.swing.JProgressBar PP_timerBar;
    private javax.swing.JButton PP_twoPlayerButton;
    private javax.swing.JPanel PP_twoPlayerModeCover;
    private javax.swing.JLabel TA_boost1;
    private javax.swing.JLabel TA_boost2;
    private javax.swing.JSpinner TA_boostRespawnTime;
    private javax.swing.JSpinner TA_boostedSpeed;
    private javax.swing.JSpinner TA_boostedTime;
    private javax.swing.JPanel TA_choosePlayerPanel;
    private javax.swing.JLabel TA_choosePlayerTitle;
    private javax.swing.JPanel TA_cover;
    private javax.swing.JPanel TA_floor0;
    private javax.swing.JPanel TA_floor1;
    private javax.swing.JPanel TA_floor10;
    private javax.swing.JPanel TA_floor11;
    private javax.swing.JPanel TA_floor12;
    private javax.swing.JPanel TA_floor13;
    private javax.swing.JPanel TA_floor2;
    private javax.swing.JPanel TA_floor3;
    private javax.swing.JPanel TA_floor4;
    private javax.swing.JPanel TA_floor5;
    private javax.swing.JPanel TA_floor6;
    private javax.swing.JPanel TA_floor7;
    private javax.swing.JPanel TA_floor8;
    private javax.swing.JPanel TA_floor9;
    private javax.swing.JPanel TA_gameBox;
    private javax.swing.JSpinner TA_gravity;
    private javax.swing.JSpinner TA_maxTaggerTime;
    private javax.swing.JPanel TA_player1;
    private javax.swing.JLabel TA_player1Indicator;
    private javax.swing.JProgressBar TA_player1Time;
    private javax.swing.JPanel TA_player2;
    private javax.swing.JLabel TA_player2Indicator;
    private javax.swing.JProgressBar TA_player2Time;
    private javax.swing.JButton TA_resetBoostRespawnTime;
    private javax.swing.JButton TA_resetBoostedSpeed;
    private javax.swing.JButton TA_resetBoostedTime;
    private javax.swing.JButton TA_resetGravity;
    private javax.swing.JButton TA_resetMaxTaggerTime;
    private javax.swing.JButton TA_resetRunnerSpeed;
    private javax.swing.JButton TA_resetTaggerSpeed;
    private javax.swing.JButton TA_resetTimeFrozen;
    private javax.swing.JSpinner TA_runnerSpeed;
    private javax.swing.JButton TA_saveSettingsButton;
    private javax.swing.JLabel TA_settings;
    private javax.swing.JPanel TA_settingsPanel;
    private javax.swing.JButton TA_startButton;
    private javax.swing.JLabel TA_startingPlayer;
    private javax.swing.JButton TA_startingPlayerButton;
    private javax.swing.JSpinner TA_taggerSpeed;
    private javax.swing.JSpinner TA_timeFrozen;
    private javax.swing.JPanel TA_topBar;
    private javax.swing.JLabel T_ball;
    private javax.swing.JPanel T_cover;
    private javax.swing.JLabel T_explosion;
    private javax.swing.JPanel T_floor;
    private javax.swing.JSeparator T_floorLine;
    private javax.swing.JPanel T_gameBox;
    private javax.swing.JPanel T_gameOverCover;
    private javax.swing.JLabel T_gameOverText;
    private javax.swing.JProgressBar T_gasBar;
    private javax.swing.JLabel T_map1Button;
    private javax.swing.JPanel T_map1Cover;
    private javax.swing.JLabel T_map2Button;
    private javax.swing.JPanel T_map2Cover;
    private javax.swing.JLabel T_map3Button;
    private javax.swing.JPanel T_map3Cover;
    private javax.swing.JPanel T_mapItem1;
    private javax.swing.JPanel T_mapItem2;
    private javax.swing.JPanel T_mapItem3;
    private javax.swing.JPanel T_matchCover;
    private javax.swing.JButton T_matchCoverButton;
    private javax.swing.JLabel T_matchWinnerText;
    private javax.swing.JLabel T_player1;
    private javax.swing.JLabel T_player1Indicator;
    private javax.swing.JLabel T_player1Lifes;
    private javax.swing.JLabel T_player1Score;
    private javax.swing.JLabel T_player2;
    private javax.swing.JLabel T_player2Indicator;
    private javax.swing.JLabel T_player2Lifes;
    private javax.swing.JLabel T_player2Score;
    private javax.swing.JProgressBar T_powerBar;
    private javax.swing.JButton T_restartGameButton;
    private javax.swing.JButton createAccountButton;
    private javax.swing.JButton createAccountCancelButton;
    private javax.swing.JButton createAccountConfirmButton;
    private javax.swing.JPanel game1;
    private javax.swing.JPanel game1Frame;
    private javax.swing.JLabel game1HighScore;
    private javax.swing.JLabel game1Image_;
    private javax.swing.JLabel game1Username;
    private javax.swing.JPanel game2;
    private javax.swing.JPanel game2Frame;
    private javax.swing.JLabel game2HighScore;
    private javax.swing.JLabel game2Image;
    private javax.swing.JLabel game2Username;
    private javax.swing.JPanel game3;
    private javax.swing.JPanel game3Frame;
    private javax.swing.JLabel game3HighScore;
    private javax.swing.JLabel game3Image;
    private javax.swing.JLabel game3Username;
    private javax.swing.JPanel game4;
    private javax.swing.JPanel game4Frame;
    private javax.swing.JLabel game4HighScore;
    private javax.swing.JLabel game4Image;
    private javax.swing.JLabel game4Username;
    private javax.swing.JPanel game5;
    private javax.swing.JPanel game5Frame;
    private javax.swing.JLabel game5HighScore;
    private javax.swing.JLabel game5Image;
    private javax.swing.JLabel game5Username;
    private javax.swing.JPanel game6;
    private javax.swing.JPanel game6Frame;
    private javax.swing.JLabel game6HighScore;
    private javax.swing.JLabel game6Image;
    private javax.swing.JLabel game6Username;
    private javax.swing.JPanel gamesPanel;
    private javax.swing.JScrollPane gamesScrollFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginButtonsFrame;
    private javax.swing.JPanel loginFrame;
    private javax.swing.JLabel loginLogo;
    private javax.swing.JLabel loginTitle;
    private javax.swing.JPanel mainMenuFrame;
    private javax.swing.JPasswordField passwordConfirmInput;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
