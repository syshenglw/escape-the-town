// Big thank you to RyiSnow's videos who guided me through creating my first "application" with Java ~ this game.
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game{

    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int playerHP;
    String weapon, position;

    Font titleFont = new Font("Century Gothic", Font.PLAIN, 100);
    Font startButtonFont = new Font("Century Gothic", Font.PLAIN,25);

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args){
        new Game();
    }
    public Game(){
        window = new JFrame();
        window.setSize(800, 600);
        // The code below creates the x button so the application can be closed.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // The code below sets the color of the window.
        window.getContentPane().setBackground(Color.black);
        //It removes the default layout for the JFrame and allows me to create a custom layout.
        window.setLayout(null);
        // You need to make it so that the window actually appears so you can see it.
        window.setVisible(true);
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        // These are the dimensions of the "space" for the title.
        titleNamePanel.setBounds(100, 80, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ENTER THE TOWN");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(startButtonFont);
        // After so many hours of wasted time, this gets rid of the focus border for the text in the button.
        startButton.setFocusPainted(false);

        startButton.addActionListener(tsHandler);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(mainTextPanel);
    }
    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Ghetto Text");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(startButtonFont);
        mainTextArea.setLineWrap(true);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(startButtonFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(startButtonFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(startButtonFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(startButtonFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 20, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);

        hpLabel = new JLabel(" HP:");
        hpLabel.setFont(startButtonFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(startButtonFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(startButtonFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(startButtonFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        playerSetup();
    }
    public void playerSetup(){
        playerHP = 15;
        weapon = "Knife";
        weaponLabelName.setText(weapon);
        hpLabelNumber.setText("" + playerHP);
        townGate();
    }
    public void townGate(){
        position = "townGate";
        mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n \n What do you do?");
        choice1.setText("Talk to the guard");
        choice2.setText("Attack the guard");
        choice3.setText("Leave");
        choice4.setText("");
    }
    public void talkGuard(){
        position = "talkGuard";
        mainTextArea.setText("Guard: Hello stranger. \nI have never seen your face. \nI'm sorry but we cannot let you into our town.\n Please leave.");
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guard: Guard: Hey! Don't be stupid! \n \nThe guard fought back and hit you hard. \nYou received 3 damage and ran away.");
        playerHP-= 3;
        hpLabelNumber.setText("" + playerHP);
        choice1.setText("");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }
    public void win(){
        position = "win";
        mainTextArea.setText("You win!");
    }
    public void lose(){
        position = "lose";
        mainTextArea.setText("You are dead!\n\nGAME OVER!");
    }
    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            switch(position){
            case "townGate":
                switch(yourChoice){
                case "c1": talkGuard(); break;
                case "c2": break;
                case "c3": break;
                }
            case "talkGuard":
                switch(yourChoice){
                case "c1": break;
                case "c2": break;
                case "c3": break;
                case "c4": break;
                }
            }
            
        }
    }
}
/* choice1.setText("");
    choice2.setText("");
    choice3.setText("");
    choice4.setText("");
*/
// Base Stats: Knife does 1 DMG