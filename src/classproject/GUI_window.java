/**
 *
 * @author Emanuel
 */



package classproject;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GUI_window extends javax.swing.JFrame {
    // GAME VARIABLES: -----------------------------------------------------------
    // Game 1:
    private static final int GAME1_TIME = 60;                  // Time for game round
    private static final int MG_showingTimeAfterAttempt = 500; // Time for user to see cards chosen (milliseconds)
    private static final int MG_matchScoreIncrease = 200;      // Points given per match
    private static final int MG_timerScoreIncrease = 100;      // Points given per second after completion
    
    // Game 2:
    private static final String DB_player1Icon = "▲";   // Icon used to show player 1
    private static final String DB_player2Icon = "■";  // Icon used to show player 2
    
    // Game 3:
    private static final int GAME3_TIME = 120; // Time for the ping pong game (in seconds)
    
    // Game 4:
    
    // ----------------------------------------------------------------------------
    
    
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUI_window.class.getName());
    public GUI_window() {
        initComponents();
        switchFrame(loginFrame);
        
        // SINGLE TIME CODE!!! ----------------------------------------------------------------------
        // Moving up frames
        game1Frame.setComponentZOrder(G1_disableCover, 0); 
        
        
        // Color Frames:
        G1_disableCover.setBackground(new Color(175, 157, 136, 128)); // semi-transparent main color 
        
        passwordInput.addActionListener(e -> {
            loginButtonPressed();
        });
        // -------------------------------------------------------------------------------------------
        
        
        
        
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

        MG.setUp(MG_values, MG_images, G1_score, MG_matchScoreIncrease, MG_timerScoreIncrease, MG_showingTimeAfterAttempt);
        // -------------------------------------------------------------------------------------------
        

        // Setting up Game 2: ------------------------------------------------------------------------
        DB_player1TopIcon.setText(DB_player1Icon); // Setting up the icons on the top for the players
        DB_player2TopIcon.setText(DB_player2Icon); // Setting up the icons on the top for the players
        List<JPanel> DB_lines = new ArrayList<>(Arrays.asList(
                DB_1,DB_2,DB_3,DB_4,DB_5,DB_6,DB_7,DB_8,DB_9,DB_10,DB_11,DB_12,DB_13,DB_14,DB_15,DB_16,DB_17,DB_18,DB_19,DB_20,DB_21,
                DB_22,DB_23,DB_24,DB_25,DB_26,DB_27,DB_28,DB_29,DB_30,DB_31,DB_32,DB_33,DB_34,DB_35,DB_36,DB_37,DB_38,DB_39,DB_40,DB_41,
                DB_42,DB_43,DB_44,DB_45
        ));
        List<JLabel> DB_boxes = new ArrayList<>(Arrays.asList(
                DB_b1, DB_b2, DB_b3, DB_b4, DB_b5, DB_b6, DB_b7, DB_b8, DB_b9, DB_b10, DB_b11, DB_b12, DB_b13, DB_b14, DB_b15, DB_b16, DB_b17, DB_b18
        ));
        List<JPanel> DB_outsideHorz = new ArrayList<>(Arrays.asList(
                DB_1,DB_2,DB_3,DB_4,DB_5,DB_6,DB_40,DB_41,DB_42,DB_43,DB_44
        ));
        List<JPanel> DB_outsideVert = new ArrayList<>(Arrays.asList(
                DB_7,DB_20,DB_33,DB_13,DB_26,DB_39
        ));
        DB.setUp(DB_player1Icon, DB_player2Icon, G2_player1, G2_player2, DB_lines, DB_outsideHorz, DB_outsideVert, DB_boxes);
        // -------------------------------------------------------------------------------------------
        

        // Setting up Game 3: ------------------------------------------------------------------------
        G3_gameDescription.setText(G3_gameDescription.getText() + Integer.toString(GAME3_TIME) + " Seconds");            // Sets up the description of the game 
        G3_gameDescription2.setText(G3_gameDescription2.getText() + Integer.toString(GAME3_TIME) + " Seconds");          // Sets up the description of the game
        PP.setUp(G3_player, G3_computer, G3_ball, G3_playerScore, G3_computerScore, G3_countDownTimer, G3_pointsPanel);
        
        // -------------------------------------------------------------------------------------------
        
        
        // Setting up Game 4: ------------------------------------------------------------------------
        T.setUp(T_mapItem1, T_mapItem2, T_mapItem3, T_player1, T_player2, T_player1Lifes, T_player2Lifes,
                T_gasBar, T_ball, T_gameBox, T_powerBar, T_floorLine, T_matchCover, T_matchWinnerText,
                T_player1Score, T_player2Score);
        
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MM_topBar = new javax.swing.JPanel();
        MM_username = new javax.swing.JLabel();
        MM_userSettingsButton = new javax.swing.JButton();
        MM_logOutButton = new javax.swing.JButton();
        MM_backToMenuButton = new javax.swing.JButton();
        game4Frame = new javax.swing.JPanel();
        T_gameBox = new javax.swing.JPanel();
        T_matchCover = new javax.swing.JPanel();
        T_matchCoverButton = new javax.swing.JButton();
        T_matchWinnerText = new javax.swing.JLabel();
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
        G3_gameArea = new javax.swing.JPanel();
        G3_cover = new javax.swing.JPanel();
        G3_startButton = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        G3_twoPlayerButton = new javax.swing.JButton();
        G3_singlePlayerModeCover = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        G3_gameDescription = new javax.swing.JLabel();
        G3_twoPlayerModeCover = new javax.swing.JPanel();
        G3_gameDescription2 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        G3_resetCover = new javax.swing.JPanel();
        G3_resetButton = new javax.swing.JButton();
        G3_computer = new javax.swing.JPanel();
        G2_playerEdge = new javax.swing.JPanel();
        G3_computerEdge = new javax.swing.JPanel();
        G3_player = new javax.swing.JPanel();
        G3_ball = new javax.swing.JPanel();
        G3_countDownTimer = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        G3_playerLabel = new javax.swing.JLabel();
        G3_computerLabel = new javax.swing.JLabel();
        G3_playerScore = new javax.swing.JLabel();
        G3_computerScore = new javax.swing.JLabel();
        G3_scorePanel = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        G3_pointsPanel = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        JPanel991 = new javax.swing.JPanel();
        G3_timerBar = new javax.swing.JProgressBar();
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
        game2Frame = new javax.swing.JPanel();
        G2_resetBar = new javax.swing.JPanel();
        G2_resetButton = new javax.swing.JButton();
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
        game1Frame = new javax.swing.JPanel();
        G1_gameArea = new javax.swing.JPanel();
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
        G1_disableCover = new javax.swing.JPanel();
        G1_timeBoard = new javax.swing.JPanel();
        G1_timerBar = new javax.swing.JProgressBar();
        G1_startButton = new javax.swing.JButton();
        G1_scoreBoard = new javax.swing.JPanel();
        G1_score = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

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
        T_player2Indicator.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        T_player2Indicator.setForeground(new java.awt.Color(225, 225, 225));
        T_player2Indicator.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        T_player2Indicator.setText("Player 2 ] -------");
        jPanel5.add(T_player2Indicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 5, 250, 60));

        T_player1Indicator.setBackground(java.awt.Color.white);
        T_player1Indicator.setFont(new java.awt.Font("Segoe UI", 0, 34)); // NOI18N
        T_player1Indicator.setForeground(new java.awt.Color(225, 225, 225));
        T_player1Indicator.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        T_player1Indicator.setText("-------[ Player 1");
        jPanel5.add(T_player1Indicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 5, 250, 60));

        game4Frame.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 765, 70));

        getContentPane().add(game4Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

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

        G3_gameArea.setBackground(java.awt.Color.black);
        G3_gameArea.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        G3_gameArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                G3_gameAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                G3_gameAreaKeyReleased(evt);
            }
        });
        G3_gameArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G3_cover.setBackground(new java.awt.Color(153, 135, 108));
        G3_cover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G3_startButton.setBackground(new java.awt.Color(214, 196, 172));
        G3_startButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        G3_startButton.setForeground(java.awt.Color.black);
        G3_startButton.setText("Start Game!");
        G3_startButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G3_startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                G3_startButtonMousePressed(evt);
            }
        });
        G3_cover.add(G3_startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 370, 50));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(java.awt.Color.white);
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("How to Play?");
        jLabel22.setToolTipText("");
        G3_cover.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 40));

        G3_twoPlayerButton.setBackground(new java.awt.Color(204, 255, 204));
        G3_twoPlayerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        G3_twoPlayerButton.setForeground(java.awt.Color.black);
        G3_twoPlayerButton.setText("Two Player Mode");
        G3_twoPlayerButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_twoPlayerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G3_twoPlayerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                G3_twoPlayerButtonMousePressed(evt);
            }
        });
        G3_cover.add(G3_twoPlayerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 245, 370, 45));

        G3_singlePlayerModeCover.setBackground(new java.awt.Color(153, 135, 108));
        G3_singlePlayerModeCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel58.setForeground(java.awt.Color.white);
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel58.setText("Move Up");
        G3_singlePlayerModeCover.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 95, 110, 35));

        jLabel59.setBackground(new java.awt.Color(153, 135, 108));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pongUpArrow.png"))); // NOI18N
        jLabel59.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_singlePlayerModeCover.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 95, 35, 35));

        jLabel60.setBackground(new java.awt.Color(153, 135, 108));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pongDownArrow.png"))); // NOI18N
        jLabel60.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_singlePlayerModeCover.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 95, 35, 35));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(java.awt.Color.white);
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Move Down");
        G3_singlePlayerModeCover.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 95, 110, 35));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel65.setForeground(java.awt.Color.white);
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Player Makes Goal: +100 Points");
        G3_singlePlayerModeCover.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 170, 20));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel57.setForeground(java.awt.Color.white);
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Computer Makes Goal: -50 Points");
        G3_singlePlayerModeCover.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 180, 20));

        G3_gameDescription.setFont(new java.awt.Font("Segoe UI", 2, 17)); // NOI18N
        G3_gameDescription.setForeground(java.awt.Color.white);
        G3_gameDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3_gameDescription.setText("Make as many goals as you can in ");
        G3_singlePlayerModeCover.add(G3_gameDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 380, 30));

        G3_cover.add(G3_singlePlayerModeCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 405, 140));

        G3_twoPlayerModeCover.setBackground(new java.awt.Color(153, 135, 108));
        G3_twoPlayerModeCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G3_gameDescription2.setFont(new java.awt.Font("Segoe UI", 2, 17)); // NOI18N
        G3_gameDescription2.setForeground(java.awt.Color.white);
        G3_gameDescription2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3_gameDescription2.setText("Score as many goals in");
        G3_twoPlayerModeCover.add(G3_gameDescription2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 380, 30));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel62.setForeground(java.awt.Color.white);
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel62.setText("Move Up P1");
        G3_twoPlayerModeCover.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 110, 35));

        jLabel63.setBackground(new java.awt.Color(153, 135, 108));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pingPong_wKey.png"))); // NOI18N
        jLabel63.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_twoPlayerModeCover.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 35, 35));

        jLabel66.setBackground(new java.awt.Color(153, 135, 108));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pingPong_sKey.png"))); // NOI18N
        jLabel66.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_twoPlayerModeCover.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 35, 35));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel67.setForeground(java.awt.Color.white);
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("Move Down P1");
        G3_twoPlayerModeCover.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 35));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel68.setForeground(java.awt.Color.white);
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel68.setText("P2 Move Up ");
        jLabel68.setToolTipText("");
        G3_twoPlayerModeCover.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 110, 30));

        jLabel69.setBackground(new java.awt.Color(153, 135, 108));
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pongUpArrow.png"))); // NOI18N
        jLabel69.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_twoPlayerModeCover.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 35, 35));

        jLabel70.setBackground(new java.awt.Color(153, 135, 108));
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/classproject/pongDownArrow.png"))); // NOI18N
        jLabel70.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_twoPlayerModeCover.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 35, 35));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel71.setForeground(java.awt.Color.white);
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setText("P2 Move Down");
        G3_twoPlayerModeCover.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 140, 35));

        G3_cover.add(G3_twoPlayerModeCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 40, 405, 140));

        G3_gameArea.add(G3_cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 410, 300));

        G3_resetCover.setBackground(new java.awt.Color(153, 135, 108));
        G3_resetCover.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_resetCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G3_resetButton.setBackground(new java.awt.Color(214, 196, 172));
        G3_resetButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        G3_resetButton.setForeground(java.awt.Color.black);
        G3_resetButton.setText("Reset Game!");
        G3_resetButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G3_resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                G3_resetButtonMousePressed(evt);
            }
        });
        G3_resetCover.add(G3_resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 370, 90));

        G3_gameArea.add(G3_resetCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 410, 120));

        G3_computer.setBackground(java.awt.Color.white);
        G3_computer.setForeground(java.awt.Color.white);
        G3_gameArea.add(G3_computer, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 225, 10, 50));

        G2_playerEdge.setBackground(new java.awt.Color(204, 204, 204));
        G2_playerEdge.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        G3_gameArea.add(G2_playerEdge, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 500));

        G3_computerEdge.setBackground(new java.awt.Color(204, 204, 204));
        G3_computerEdge.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        G3_gameArea.add(G3_computerEdge, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 500));

        G3_player.setBackground(java.awt.Color.white);
        G3_player.setForeground(java.awt.Color.white);
        G3_player.setToolTipText("");
        G3_gameArea.add(G3_player, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 10, 50));

        G3_ball.setBackground(java.awt.Color.white);
        G3_gameArea.add(G3_ball, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 20, 20));

        G3_countDownTimer.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        G3_countDownTimer.setForeground(java.awt.Color.white);
        G3_countDownTimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3_countDownTimer.setText("3");
        G3_gameArea.add(G3_countDownTimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 300, 80));

        game3Frame.add(G3_gameArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 720, 500));

        jPanel1.setBackground(new java.awt.Color(153, 135, 108));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G3_playerLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        G3_playerLabel.setForeground(java.awt.Color.white);
        G3_playerLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        G3_playerLabel.setText("Player");
        G3_playerLabel.setToolTipText("");
        jPanel1.add(G3_playerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 5, 130, 40));

        G3_computerLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        G3_computerLabel.setForeground(java.awt.Color.white);
        G3_computerLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        G3_computerLabel.setText("Computer");
        G3_computerLabel.setToolTipText("");
        jPanel1.add(G3_computerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 5, 130, 40));

        G3_playerScore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        G3_playerScore.setForeground(java.awt.Color.white);
        G3_playerScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3_playerScore.setText("99");
        jPanel1.add(G3_playerScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 50, 40));

        G3_computerScore.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        G3_computerScore.setForeground(java.awt.Color.white);
        G3_computerScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3_computerScore.setText("99");
        jPanel1.add(G3_computerScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 5, 50, 40));

        G3_scorePanel.setBackground(new java.awt.Color(153, 135, 108));
        G3_scorePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G3_scorePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel75.setForeground(java.awt.Color.white);
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel75.setText("Score:");
        jLabel75.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        G3_scorePanel.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 60, 20));

        G3_pointsPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        G3_pointsPanel.setForeground(java.awt.Color.white);
        G3_pointsPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G3_pointsPanel.setText("999");
        G3_pointsPanel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        G3_scorePanel.add(G3_pointsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 15, 40, 20));

        jLabel77.setForeground(java.awt.Color.white);
        jLabel77.setText("Points");
        jLabel77.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        G3_scorePanel.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 15, 60, 20));

        jPanel1.add(G3_scorePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, 50));

        JPanel991.setBackground(new java.awt.Color(153, 135, 108));
        JPanel991.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        JPanel991.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(JPanel991, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 170, 50));

        game3Frame.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 55, 720, 50));

        G3_timerBar.setForeground(new java.awt.Color(0, 0, 0));
        G3_timerBar.setValue(50);
        game3Frame.add(G3_timerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 720, 30));

        getContentPane().add(game3Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

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

        game2Frame.setBackground(new java.awt.Color(214, 196, 172));
        game2Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G2_resetBar.setBackground(new java.awt.Color(153, 135, 108));
        G2_resetBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G2_resetBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G2_resetButton.setBackground(new java.awt.Color(200, 151, 115));
        G2_resetButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        G2_resetButton.setForeground(java.awt.Color.white);
        G2_resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G2_resetButton.setLabel("Reset Game");
        G2_resetButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                G2_resetButtonMousePressed(evt);
            }
        });
        G2_resetBar.add(G2_resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 710, 30));

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

        game1Frame.setBackground(new java.awt.Color(214, 196, 172));
        game1Frame.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_gameArea.setBackground(new java.awt.Color(175, 155, 124));
        G1_gameArea.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_gameArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        G1_gameArea.add(G1_card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 150));

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

        G1_gameArea.add(G1_card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 100, 150));

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

        G1_gameArea.add(G1_card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 100, 150));

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

        G1_gameArea.add(G1_card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 100, 150));

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

        G1_gameArea.add(G1_card5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 100, 150));

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

        G1_gameArea.add(G1_card6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 100, 150));

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

        G1_gameArea.add(G1_card7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, 150));

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

        G1_gameArea.add(G1_card8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 100, 150));

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

        G1_gameArea.add(G1_card9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 100, 150));

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

        G1_gameArea.add(G1_card10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 100, 150));

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

        G1_gameArea.add(G1_card11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 100, 150));

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

        G1_gameArea.add(G1_card12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 100, 150));

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

        G1_gameArea.add(G1_card13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 100, 150));

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

        G1_gameArea.add(G1_card14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, 100, 150));

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

        G1_gameArea.add(G1_card15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 100, 150));

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

        G1_gameArea.add(G1_card16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 100, 150));

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

        G1_gameArea.add(G1_card17, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 100, 150));

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

        G1_gameArea.add(G1_card18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 100, 150));

        game1Frame.add(G1_gameArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 720, 530));

        G1_disableCover.setBackground(new java.awt.Color(172, 157, 136));
        G1_disableCover.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        G1_disableCover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        game1Frame.add(G1_disableCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 720, 530));

        G1_timeBoard.setBackground(new java.awt.Color(153, 135, 108));
        G1_timeBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G1_timeBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_timerBar.setBackground(new java.awt.Color(200, 151, 115));
        G1_timerBar.setForeground(new java.awt.Color(153, 135, 108));
        G1_timerBar.setValue(30);
        G1_timeBoard.add(G1_timerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 430, 30));

        G1_startButton.setBackground(new java.awt.Color(200, 151, 115));
        G1_startButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        G1_startButton.setForeground(java.awt.Color.white);
        G1_startButton.setText("Start Game");
        G1_startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        G1_startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                G1_startButtonMousePressed(evt);
            }
        });
        G1_timeBoard.add(G1_startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 430, 30));

        game1Frame.add(G1_timeBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 65, 440, 40));

        G1_scoreBoard.setBackground(new java.awt.Color(153, 135, 108));
        G1_scoreBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        G1_scoreBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        G1_score.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        G1_score.setForeground(java.awt.Color.white);
        G1_score.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        G1_score.setText("<score>");
        G1_scoreBoard.add(G1_score, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 140, 40));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(java.awt.Color.white);
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Current Score: ");
        G1_scoreBoard.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        game1Frame.add(G1_scoreBoard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 65, 270, 40));

        getContentPane().add(game1Frame, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // =======================================================================================
    // ============================ GLOBAL VARIABLES =========================================
    // ---- User Control:                                                                 //||
    private String currentUser = "";                                                      //||
    private final UsersManager allUsers = new UsersManager();                             //||
    private final HighscoreManager scores = new HighscoreManager();                       //||
                                                                                          //||
    // ---- Timers:                                                                       //||
    private int timePassed;                                                               //||
    private int fullTime;                                                                 //||
    private Timer gameTimer;                                                              //||
                                                                                          //||
    // ---- Games:                                                                        //||
    private final MatchingGame MG = new MatchingGame();                                   //||
    private final DotsAndBoxesGame DB = new DotsAndBoxesGame();                           //||
    private final PingPong PP = new PingPong();                                           //||
    private final TanksGame T = new TanksGame();                                          //||
    // =======================================================================================
    // =======================================================================================
    
    
    
    
// SWITCH FRAME ===========================================================================
private void switchFrame(javax.swing.JPanel target){  
    // Hiding all panels
    mainMenuFrame.setVisible(false);
    MM_topBar.setVisible(false);
    loginFrame.setVisible(false);
    game1Frame.setVisible(false);
    game2Frame.setVisible(false);
    game3Frame.setVisible(false);
    game4Frame.setVisible(false);

    // Stop all timers
    if(gameTimer != null) gameTimer.stop();

    PP.stopGame(); // Stops the timers inside the ping pong game class
    T.stopGame();  // Stops the timers inside the tank game class


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
            G1_disableCover.setVisible(true);     // Showign the disable cover so player knows to start game 
            G1_timerBar.setValue(0);              // Set timer bar to zero 
            G1_timerBar.setVisible(false);        // Hide Timer bar
            G1_startButton.setVisible(true);      // Show the start button instead of timer bar
            G1_startButton.setText("Start Game!"); // Change text to reset next press
            G1_score.setText("0");                 // Sets the score back to 0
            MG.shuffle();                          // Shuffles and resets the board
        }
        else if(target == game2Frame){
            MM_username.setText("Dots and Boxes"); // Changing the title to the game name
            DB.resetBoard();
        }
        else if(target == game3Frame){
            MM_username.setText("Ping Pong");      // Changing game title
            G3_playerScore.setText("0");           // Reseting player 1 score
            G3_computerScore.setText("0");         // Resetting player 2 / computer score
            G3_pointsPanel.setText("0");           // Resetting points label
            G3_countDownTimer.setVisible(false);   // Hiding the countdown timer
            PP.reset();                            // Resetting the game

            // Setting to single player mode
            twoPlayerMode = false;          // Setting to single player mode
            PP.setTwoPlayerMode(false);     // Setting game class to single player mode
            G3_twoPlayerModeCover.setVisible(false);   // Hiding the two player mode display
            G3_singlePlayerModeCover.setVisible(true); // Showing the single player mode display
            G3_computerLabel.setText("Computer");      // Changing player 2 label to computer
            G3_playerLabel.setText("Player");          // Changing the player 1 label to player
            G3_twoPlayerButton.setBackground(new Color(214,196,172)); // Setting color to unclicked
            G3_resetCover.setVisible(false);           // Hiding the reset button 
            G3_cover.setVisible(true);                 // Showing the game start cover
            G3_timerBar.setValue(0);                   // Resetting the time bar
        }
        else if(target == game4Frame){
            MM_username.setText("Tanks"); // Changing the title
            
            T_cover.setVisible(true);     // Showing the cover
            T_gameBox.setVisible(false);  // Hiding the game box
            T_gameOverCover.setVisible(false); // Hiding the game over cover
            T_matchCover.setVisible(false);    // Hiding the match cover 
            
            T_player1Score.setText("0");  // Resetting scores
            T_player2Score.setText("0");  // Resetting scores
            
            map1WonBy = 0; // Resetting the matches won by 
            map2WonBy = 0;
            map3WonBy = 0;
            
            T_map1Cover.setVisible(false); // Hidding each cover
            T_map2Cover.setVisible(false);
            T_map3Cover.setVisible(false);
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
        game1HighScore.setText(scores.getHighscore("MG"));
        game1Username.setText(scores.getUsername("MG"));
        game3HighScore.setText(scores.getHighscore("PP"));
        game3Username.setText(scores.getUsername("PP"));
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

    
// ========================================================================================
  
    
    
    
    
    
    
    
    
    
    
// GAME 1 FUNCTIONS ==================================================================== 
    private void startG1Timer(){
        fullTime = GAME1_TIME;               // Resetting the fulltime to the time amount we want
        timePassed = 0;                      // Resettinig the timePassed to 0 so that it can start at this amount
        G1_timerBar.setMaximum(GAME1_TIME);  // Setting the max to that amount so each tick is that much
        G1_timerBar.setValue(0);             // Setting the bar to 0, as time goes, it will grow
        
        gameTimer = new Timer(1000,e->{       // Function for each tick of the timer (every 1 second)
           timePassed++;                       // Up the amount by 1
           G1_timerBar.setValue(timePassed);   // Set the bar to this amount
           
           if(timePassed >= fullTime){         // When the timer reaches Full Time:
               gameTimer.stop();                                 // Stop the timer tick
               G1_disableCover.setVisible(true);                  // Disable the game using the cover
               G1_timerBar.setVisible(false);                     // Hide the timer bar 
               G1_startButton.setVisible(true);                   // Show the start button which now says "play again!"
               
               game1FinishedMessage("Times Up!", G1_score.getText(), "0"); // Calls function to show the end of the game message
           }
        });
        
        gameTimer.start();                   // Start the timer 
    } 

    private void game1FinishedMessage(String gMessage, String matchingPoints, String timePoints){
        int maxMatchingScore = MG_matchScoreIncrease * 9;
        int maxTimeScore = GAME1_TIME * MG_timerScoreIncrease;
        
        String message = gMessage;                                               // The top section of message is added
        message +=  "\nMatching Points: "     + matchingPoints;                  // Matching points that were made
        message += "/" + Integer.toString(maxMatchingScore);                     // Showing the max possible matching points
        message +=  "\nTime Points:         " + timePoints;                      // Time Points given
        message += "/" + Integer.toString(maxTimeScore);                         // SHowing the max possible time points
        message += "\n--------------------------------------------------------"; // Line for Visual
        message += "\nTotal Points:         " + G1_score.getText();              // Total Points given
        message += "/" + Integer.toString(maxMatchingScore + maxTimeScore);      // Total points possible (time+matching)
        if(scores.reportScore("MG", currentUser, G1_score.getText()))            // If this user made a new high score
            message = message + "\nYOU SET THE NEW HIGH SCORE!";
        
        
         // Show all data to users
        JOptionPane.showMessageDialog(this, message);        
            
    }

    private void G1_startButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G1_startButtonMousePressed
        // Resetting game by sending back into game 1 if user finished previous game
        if(G1_startButton.getText().equals("Play Again!")){
            switchFrame(game1Frame);
            return;
        }
        
        // Start game Flow:
        G1_disableCover.setVisible(false);     // Hide the disable cover to start the game
        G1_timerBar.setVisible(true);          // Show the timer bar
        G1_startButton.setVisible(false);      // Hide the start button
        G1_startButton.setText("Play Again!"); // Change text to reset next press
        
        // Start the timer for the game when start button is pressed
        startG1Timer();
    }//GEN-LAST:event_G1_startButtonMousePressed

    private void MG_cardClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MG_cardClicked
        if(MG.isBusy())                  // Checking if we are currently in showing timer, return if so
            return;
        if(G1_disableCover.isVisible()) // Checking if cover is visible (usually when the game ends or is starting)
            return;
        
        JLabel clickedLabel = (JLabel) evt.getSource();    // Getting the card that was clicked (we are really clicking on the card)
        int cardIndex = MG.getImages().indexOf(clickedLabel);
        
        if(cardIndex >= 0){                                // Double checking that it won't break
            boolean gameEnded = MG.selectCard(cardIndex);  // Selecting the card which handles the visuals
            if (gameEnded) {                               // If selectCard gave T, then all matches have been found
                gameTimer.stop();
                String matchingPoints = G1_score.getText(); // Save the points given by matches before adding the time points
                
                MG.addTimeScore(fullTime-timePassed);      // Sending remaining time to add points, also updates the score
                G1_disableCover.setVisible(true);          // Covering up game
                G1_startButton.setVisible(true);           // Showing reset button 
                G1_timerBar.setVisible(false);             // Hiding game timer bar
                
                
                String timePoints = Integer.toString((fullTime-timePassed)* MG_timerScoreIncrease); // Calculating the points made by time\
                game1FinishedMessage("Game Completed!", matchingPoints, timePoints);                // Show message that the game ended with points
                
                
            }
        }
        
    }//GEN-LAST:event_MG_cardClicked
// ========================================================================================
    
    
    
    
    
 // GAME 2 FUNCTIONS ==================================================================== 
    private void G2_resetButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G2_resetButtonMousePressed
        switchFrame(game2Frame);
    }//GEN-LAST:event_G2_resetButtonMousePressed


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
    boolean twoPlayerMode = false;
    private void startG3Timer(){
        fullTime = GAME3_TIME;
        timePassed = 0;
        G3_timerBar.setMaximum(fullTime);
        G3_timerBar.setValue(0);
        
        gameTimer = new Timer(1000, e->{
            if(G3_countDownTimer.isVisible() && timePassed != fullTime){ // DO NOT COUNT WHEN WE ARE IN A COUNTDOWN, unless!! the game is waiting for next point
                return;
            }
            timePassed++;
            
            if(timePassed >= fullTime) // Clamping time passed to be at a max of full tiem
                timePassed = fullTime;
            
            G3_timerBar.setValue(timePassed);
            if(timePassed >= fullTime){
                if(!twoPlayerMode){ // If in single player mode, report score and show score
                    gameTimer.stop();
                    PP.stopGame();
                    String message = "Game Finsihed!\nPoints: " + G3_pointsPanel.getText();
                    if(scores.reportScore("PP", currentUser, G3_pointsPanel.getText()))
                        message = message + "\nYOU SET THE NEW HIGH SCORE!";
                    JOptionPane.showMessageDialog(this, message);    
                    G3_resetCover.setVisible(true);
                }
                else{ // If in two player mode
                    if(G3_countDownTimer.isVisible()){   // When the countdown timer becomes visible, end the game
                        G3_countDownTimer.setVisible(false); // Remake invisible
                        gameTimer.stop();
                        PP.stopGame();
                        
                        // Build the end of game message
                        String message = "Game Finished!\n";
                        if(Integer.parseInt(G3_playerScore.getText()) > Integer.parseInt(G3_computerScore.getText()))
                            message += "Player 1 Wins!";
                        else if(Integer.parseInt(G3_playerScore.getText()) < Integer.parseInt(G3_computerScore.getText()))
                            message += "Player 2 Wins";
                        else
                            message += "Its a draw!";
                        JOptionPane.showMessageDialog(this, message);  
                        G3_resetCover.setVisible(true);
                    }
                }
            }
        });
        gameTimer.start();
    }
    
    private boolean gamePaused = false;
    private void G3_gameAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G3_gameAreaKeyPressed
        // If player is pushing the "P", they want to pause the game
        if(evt.getKeyCode() == KeyEvent.VK_P){
            // Making sure to ignore when the timer is visible and is counting down
            if(G3_countDownTimer.isVisible() && 
               !G3_countDownTimer.getText().equals("Game Paused")) 
                return;
            gamePaused = !gamePaused;  // Toggle the pause button
            if(gamePaused)             // Pause the Game 
                PP.pauseGame();
            else                       // Continue the Game
                PP.continueGame();
        }
        
        if(G3_countDownTimer.getText().equals("Game Paused")) // If the countdown are numbers! then we can just ignore this key
            return;

        
        // Player hits a key to move their character
        if(!twoPlayerMode){ // If we are in single player
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
    }//GEN-LAST:event_G3_gameAreaKeyPressed

    private void G3_gameAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_G3_gameAreaKeyReleased
        if(G3_countDownTimer.isVisible())
            return;
        
        if(!twoPlayerMode){
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
    }//GEN-LAST:event_G3_gameAreaKeyReleased

    private void G3_startButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G3_startButtonMousePressed
        G3_cover.setVisible(false);         // Hide the cover 
        PP.startGame();                     // Start the game
        startG3Timer();                     // Start the tick
        G3_gameArea.requestFocusInWindow(); // Sends focus to the game window
    }//GEN-LAST:event_G3_startButtonMousePressed

    private void G3_resetButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G3_resetButtonMousePressed
        switchFrame(game3Frame);
    }//GEN-LAST:event_G3_resetButtonMousePressed

    private void G3_twoPlayerButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_G3_twoPlayerButtonMousePressed
        if(!twoPlayerMode){ // Going into Two Player Mode
            G3_twoPlayerButton.setBackground(new Color(204,255,204));
            G3_twoPlayerModeCover.setVisible(true);
            G3_singlePlayerModeCover.setVisible(false);
            twoPlayerMode = true;
            PP.setTwoPlayerMode(true);
            G3_scorePanel.setVisible(false);
            G3_computerLabel.setText("Player 2");
            G3_playerLabel.setText("Player 1");
           
        }
        else{ // Going into Single Player Mode
            G3_twoPlayerButton.setBackground(new Color(214,196,172));
            G3_twoPlayerModeCover.setVisible(false);
            G3_singlePlayerModeCover.setVisible(true);
            twoPlayerMode = false;
            PP.setTwoPlayerMode(false);
            G3_scorePanel.setVisible(true);
            G3_computerLabel.setText("Computer");
            G3_playerLabel.setText("Player");
            
        }
    }//GEN-LAST:event_G3_twoPlayerButtonMousePressed

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
        switch(T.map){
            case 1 -> {map1WonBy = T.matchWonBy;}
            case 2 -> {map2WonBy = T.matchWonBy;}
            case 3 -> {map3WonBy = T.matchWonBy;}
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
    private javax.swing.JPanel G1_disableCover;
    private javax.swing.JPanel G1_gameArea;
    private javax.swing.JLabel G1_score;
    private javax.swing.JPanel G1_scoreBoard;
    private javax.swing.JButton G1_startButton;
    private javax.swing.JPanel G1_timeBoard;
    private javax.swing.JProgressBar G1_timerBar;
    private javax.swing.JPanel G2_gameArea;
    private javax.swing.JPanel G2_player1;
    private javax.swing.JPanel G2_player2;
    private javax.swing.JPanel G2_playerEdge;
    private javax.swing.JPanel G2_resetBar;
    private javax.swing.JButton G2_resetButton;
    private javax.swing.JPanel G3_ball;
    private javax.swing.JPanel G3_computer;
    private javax.swing.JPanel G3_computerEdge;
    private javax.swing.JLabel G3_computerLabel;
    private javax.swing.JLabel G3_computerScore;
    private javax.swing.JLabel G3_countDownTimer;
    private javax.swing.JPanel G3_cover;
    private javax.swing.JPanel G3_gameArea;
    private javax.swing.JLabel G3_gameDescription;
    private javax.swing.JLabel G3_gameDescription2;
    private javax.swing.JPanel G3_player;
    private javax.swing.JLabel G3_playerLabel;
    private javax.swing.JLabel G3_playerScore;
    private javax.swing.JLabel G3_pointsPanel;
    private javax.swing.JButton G3_resetButton;
    private javax.swing.JPanel G3_resetCover;
    private javax.swing.JPanel G3_scorePanel;
    private javax.swing.JPanel G3_singlePlayerModeCover;
    private javax.swing.JButton G3_startButton;
    private javax.swing.JProgressBar G3_timerBar;
    private javax.swing.JButton G3_twoPlayerButton;
    private javax.swing.JPanel G3_twoPlayerModeCover;
    private javax.swing.JPanel JPanel991;
    private javax.swing.JButton MM_backToMenuButton;
    private javax.swing.JButton MM_game1StartButton;
    private javax.swing.JButton MM_game2StartButton;
    private javax.swing.JButton MM_game3StartButton;
    private javax.swing.JButton MM_game4StartButton;
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
    private javax.swing.JLabel T_ball;
    private javax.swing.JPanel T_cover;
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
    private javax.swing.JPanel gamesPanel;
    private javax.swing.JScrollPane gamesScrollFrame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
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
