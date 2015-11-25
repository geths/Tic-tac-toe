/*
 * Title        : Tic-Tac-Toe Game 
 * Author       : Getha Jagannathan
 * Date Created : 10/10/2015
 * Description  : Simple game of tic-tac-toe implemented using core java and swing gui interface. 
 * Date Modified: 11/22/2015
 * Modified By  : Getha Jagannathan
 * Modifications: 
 * 
 */
package firstswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FirstSwing extends JFrame implements ActionListener
{
        /*Declaring all global variables*/
    
        // Number of players set to default value of 1 player
        public static int numPlayer=1; 
        // 9 buttons form the tic-tac-toe board
        JButton b1 = new JButton(""); 
        JButton b2 = new JButton("");
        JButton b3 = new JButton("");
        JButton b4 = new JButton("");
        JButton b5 = new JButton("");
        JButton b6 = new JButton("");
        JButton b7 = new JButton("");
        JButton b8 = new JButton("");
        JButton b9 = new JButton("");
        // Settings button used to change player settings
        JButton bSettings = new JButton("Settings");
        // symbol refers to the current player either "X" or "O"
        String symbol = new String("X");
        //array i refers to each button in the game board
        int [][] i = {{0,0,0},{0,0,0},{0,0,0}};
        // winner of the game
        String winner = new String("no");
        // Swing GUI initializations
        JFrame frame = new JFrame("First");
        JPanel pFull = new JPanel(new BorderLayout());
        JPanel pLabel = new JPanel(new FlowLayout());
        JPanel pButton = new JPanel(new GridLayout(3,3,10,10));
        // each time a button on the game board is clicked count increments by 1. Max value = 9
        int count=0;
    
    //Constructor        
    public FirstSwing()
    {
        playGame();
    }
    //playGame function creates the game board and adds action listeners
    public void playGame()
    {
        //Frame settings
        //Frame has 2 panels - pLabel and pButton
        frame.setLocation(500,200);
        frame.setSize(550,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(pFull);
        
        // pLabel panel holds the Title Label and the Settings Button
        pFull.add(pLabel,BorderLayout.PAGE_START);
        JLabel titleLabel = new JLabel("Tic-Tac-Toe");   
        titleLabel.setFont(new Font("Courier New", Font.BOLD, 20));
        pLabel.add(titleLabel);//Title Label      
        pLabel.add(bSettings);//Settings Button
        pFull.add(pButton,BorderLayout.CENTER);
        
        //Game Board Settings
        b1.setBackground(Color.cyan);
        b2.setBackground(Color.cyan);
        b3.setBackground(Color.cyan);
        b4.setBackground(Color.cyan);
        b5.setBackground(Color.cyan);
        b6.setBackground(Color.cyan);
        b7.setBackground(Color.cyan);
        b8.setBackground(Color.cyan);
        b9.setBackground(Color.cyan);
        
        //Add buttons to the pButton Panel
        pButton.add(b1);
        pButton.add(b2);
        pButton.add(b3);
        pButton.add(b4);
        pButton.add(b5);
        pButton.add(b6);
        pButton.add(b7);
        pButton.add(b8);
        pButton.add(b9);
        
        //Add action listener to each button in the game board
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        
        //Action Listener for the settings button
        bSettings.addActionListener(this);
    }
    
    //Overriding the actionPerformed function of the ActionListener class that has been extended
    //actionPErformed function has to be overridden to add our own logic of what needs to be done when a button is clicked
    @Override
     public void actionPerformed(ActionEvent event) {
        //If the settings button is clicked then a dialog box is displayed with the player settings
        if (event.getSource() == bSettings)
        {
            int n;
            n = playerSelector();
            if (n==JOptionPane.YES_OPTION)
            {
                numPlayer = 1;
            }
            else if(n==JOptionPane.NO_OPTION)
            {
                numPlayer = 2;
            }
            else if (n==JOptionPane.CLOSED_OPTION)
            {
                numPlayer=1;
            }
            bSettings.setEnabled(false);
        }
        else //Settings button should be disabled when the game is being played
        {
            bSettings.setEnabled(false);
        }
        /* If any of the 9 buttons on the game board is clicked
         * 1. Set the Button's text as the current player's symbol
         * 2. Disable the button
         * 3. Set the value of i[][] based on the current player
        */
        if(event.getSource() == b1)
        {
            count++;
            b1.setText(symbol);
            b1.setEnabled(false);
            if (symbol.equals("X")) i[0][0]=1;
            else if (symbol.equals("O")) i[0][0]=5;
        }
        else if(event.getSource() == b2)
        {
            count++;
            b2.setText(symbol);
            b2.setEnabled(false);
            if (symbol.equals("X")) i[0][1]=1;
            else if (symbol.equals("O")) i[0][1]=5;
        }
        else if(event.getSource() == b3)
        {
            count++;
            b3.setText(symbol);
            b3.setEnabled(false);
            if (symbol.equals("X")) i[0][2]=1;
            else if (symbol.equals("O")) i[0][2]=5;
        }
        else if(event.getSource() == b4)
        {
            count++;
            b4.setText(symbol);
            b4.setEnabled(false);
            if (symbol.equals("X")) i[1][0]=1;
            else if (symbol.equals("O")) i[1][0]=5;
        }
        else if(event.getSource() == b5)
        {
            count++;
            b5.setText(symbol);
            b5.setEnabled(false);
            if (symbol.equals("X")) i[1][1]=1;
            else if (symbol.equals("O")) i[1][1]=5;
        }
        else if(event.getSource() == b6)
        {
            count++;
            b6.setText(symbol);
            b6.setEnabled(false);
            if (symbol.equals("X")) i[1][2]=1;
            else if (symbol.equals("O")) i[1][2]=5;
        }
        else if(event.getSource() == b7)
        {
            count++;
            b7.setText(symbol);
            b7.setEnabled(false);
            if (symbol.equals("X")) i[2][0]=1;
            else if (symbol.equals("O")) i[2][0]=5;
        }
        else if(event.getSource() == b8)
        {
            count++;
            b8.setText(symbol);
            b8.setEnabled(false);
            if (symbol.equals("X")) i[2][1]=1;
            else if (symbol.equals("O")) i[2][1]=5;
        }
        else if(event.getSource() == b9)
        {
            count++;
            b9.setText(symbol);
            b9.setEnabled(false);
            if (symbol.equals("X")) i[2][2]=1;
            else if (symbol.equals("O")) i[2][2]=5;
        }
        //Toggle the player symbols
        if (symbol.equals("X")) {symbol="O";}
        else if (symbol.equals("O")) {symbol="X";}
        
        checkResult();//Check the result after each button click;
 
        // Check and display the result
        // Ask the player if they your like to continue the game
        if (winner=="X")
        { 
            clearBoard();
            JOptionPane.showMessageDialog(null, "X is the Winner.");
            int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION)
            {
                frame.setVisible(false);
                frame.dispose();
            }
        }
        else if (winner == "O")
        {
            clearBoard();
            JOptionPane.showMessageDialog(null, "O is the Winner.");
            int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION)
            {
                frame.setVisible(false);
                frame.dispose();
            }
        }
        else if (winner == "none")
        {
            JOptionPane.showMessageDialog(null, "Its a Draw.");
            int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION)
            {
               frame.setVisible(false);
               frame.dispose();
            } 
            clearBoard();
        }
        //Single Player
        if ((numPlayer ==1) && (symbol=="O"))
        {
             int w = 0;
             Random rand = new Random(); // Computer's turn to play
             int random;
             do
             {
                random = (rand.nextInt(9))+1;
                switch (random)
                {
                    case 1:
                            if (b1.isEnabled()==true)
                            {
                                b1.doClick();
                                w=1;
                            }
                            break;
                    case 2:
                            if (b2.isEnabled()==true)
                            {
                                b2.doClick();
                                w=1;
                            }
                            break;
                    case 3:
                            if (b3.isEnabled()==true)
                            {
                                b3.doClick();
                                w=1;
                            }
                            break;
                    case 4:
                            if (b4.isEnabled()==true)
                            {
                                b4.doClick();
                                w=1;
                            }
                            break;
                    case 5:
                            if (b5.isEnabled()==true)
                            {
                                b5.doClick();
                                w=1;
                            }
                            break;
                    case 6:
                            if (b6.isEnabled()==true)
                            {
                                b6.doClick();
                                w=1;
                            }
                            break;
                    case 7:
                            if (b7.isEnabled()==true)
                            {
                                b7.doClick();
                                w=1;
                            }
                            break;
                    case 8:
                            if (b8.isEnabled()==true)
                            {
                                b8.doClick();
                                w=1;
                            }
                            break;
                    case 9:
                            if (b9.isEnabled()==true)
                            {
                                b9.doClick();
                                w=1;
                            }
                            break;
                    default:
                            break;
                }
            }while (w==0);
        }
    } // End of ActionPerformed
     
   //Once the game is completed the board has to be cleared to play the next game
    public void clearBoard()
    {
        b1.setText(""); b1.setEnabled(true);
        b2.setText(""); b2.setEnabled(true);
        b3.setText(""); b3.setEnabled(true);
        b4.setText(""); b4.setEnabled(true);
        b5.setText(""); b5.setEnabled(true);
        b6.setText(""); b6.setEnabled(true);
        b7.setText(""); b7.setEnabled(true);
        b8.setText(""); b8.setEnabled(true);
        b9.setText(""); b9.setEnabled(true);
        bSettings.setEnabled(true);
        symbol="X";
        winner="no";
        count = 0;
        for (int a = 0; a<3;a++)
            for (int b = 0;b<3;b++)
                i[a][b]=0;
     }
    //Check the Results to determine the winner after each button click
    public void checkResult()
     {
        if ((i[0][0]+i[0][1]+i[0][2]) == 3) 
        {
            winner = "X";
        }
        else if ((i[0][0]+i[0][1]+i[0][2]) == 15) 
        {
            winner = "O";
        }
        if ((i[1][0]+i[1][1]+i[1][2]) == 3) 
        {
            winner = "X";
        }
        else if ((i[1][0]+i[1][1]+i[1][2]) == 15) 
        {
            winner = "O";
        }
        if ((i[2][0]+i[2][1]+i[2][2]) == 3) 
        {
            winner = "X";
        }
        else if ((i[2][0]+i[2][1]+i[2][2]) == 15) 
        {
            winner = "O";
        }
        if ((i[0][0]+i[1][0]+i[2][0]) == 3) 
        {
            winner = "X";
        }
        else if ((i[0][0]+i[1][0]+i[2][0]) == 15) 
        {
            winner = "O";
        }
        if ((i[0][1]+i[1][1]+i[2][1]) == 3) 
        {
            winner = "X";
        }
        else if ((i[0][1]+i[1][1]+i[2][1]) == 15) 
        {
            winner = "O";
        }
        if ((i[0][2]+i[1][2]+i[2][2]) == 3) 
        {
            winner = "X";
        }
        else if ((i[0][2]+i[1][2]+i[2][2]) == 15) 
        {
            winner = "O";
        }
        if ((i[0][0]+i[1][1]+i[2][2]) == 3) 
        {
            winner = "X";
        }
        else if ((i[0][0]+i[1][1]+i[2][2]) == 15) 
        {
            winner = "O";
        }
        if ((i[0][2]+i[1][1]+i[2][0]) == 3) 
        {
            winner = "X";
        }
        else if ((i[0][2]+i[1][1]+i[2][0]) == 15) 
        {
            winner = "O";
        }
        if (count == 9)
        {
            if (winner == "no")
            {
                winner = "none";
            }
        }
    }
    //Select Player Options
    public static int playerSelector()
    {
        Object[] options = {"1 Player","2 Players"};
        int n = JOptionPane.showOptionDialog(null,"Choose Player Settings","Settings",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[1]);
        return n;
    }
    public static void main(String[] args) {
        int n;
        n= playerSelector();
        if (n==JOptionPane.YES_OPTION)
        {
            numPlayer = 1;
        }
        else if (n==JOptionPane.NO_OPTION)
        {
            numPlayer = 2;
        }
        else if (n==JOptionPane.CLOSED_OPTION)
        {
            numPlayer = 1;
        }
        
        new FirstSwing();
    }
}
