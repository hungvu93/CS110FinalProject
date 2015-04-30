/*
Hung Vu
CS110                      
Assignment# 10
Due Date: 12/6/13

This program simulates a war
card game on a graphical 
user interface (GUI);
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
WarGame class creates a GUI in which a war
game is implemented. Extends the JFrame class which allows the GUI
*/
public class WarGame extends JFrame{//A
   //Class fields declarations
   private JFrame frame = new JFrame();
   private JButton button1 = new JButton("Flip");
   private Deck deck = new Deck(2,15);
   private Deck pile1 = new Deck();
   private Deck pile2 = new Deck();
   private Card card1 = new Card();
   private Card card2 = new Card();
   private Card card5 = new Card();
   private Card card6 = new Card();
   private Card card9 = new Card();
   private Card card10 = new Card();
   
   //Labels
   private JLabel labelx = new JLabel();
   private JLabel labely = new JLabel();
   private JLabel labela = new JLabel();
   private JLabel labelb = new JLabel();
   private JLabel labelc = new JLabel();
   private JLabel labelwar1 = new JLabel();
   private JLabel labelwar2 = new JLabel();
   private JLabel labelwar3 = new JLabel();
   private JLabel labelwar4 = new JLabel();
   private JLabel score1 = new JLabel();
   private JLabel score2 = new JLabel();
   private JLabel label5 = new JLabel();
   private JLabel labelwar5 = new JLabel();
   private JLabel labelwar6 = new JLabel();
   private JLabel labelwar7 = new JLabel();
   private JLabel labelwar8 = new JLabel();
   
   //Panels
   private JPanel panelx = new JPanel();
   private JPanel panely = new JPanel();
   private JPanel panelCenter = new JPanel();
   private JPanel panelSouth = new JPanel();
   private JPanel panelA = new JPanel();
   private JPanel panelB = new JPanel();
   private JPanel panelC = new JPanel();
   private JPanel panelD = new JPanel();
   
   //ImageIcons
   private ImageIcon backCard = new ImageIcon("back.jpg");
   private ImageIcon frontCard = new ImageIcon("aced.jpg");
   
   public WarGame(){
         //Shuffle deck
         deck.shuffle();
         //Create two piles of cards
         for(int i = 0; !deck.isEmpty() ; i++){ 
         //Creates Two piles of cards from 1 deck
            card1 = deck.RemoveCard();
            pile1.AddCard(card1);
            //labelc.setText("PLayer 1 wins wars");
            card2 = deck.RemoveCard();
            pile2.AddCard(card2); 
            //labelc.setText("Player 2 wins war");
         }
         
      //Show the amount of cards
      score1 = new JLabel("Player 1 Cards: " + pile1.size());
      score2 = new JLabel("Player 2 Cards: " + pile2.size());
      
      //Initialize JFrame window
      setTitle("War to the door, what..");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      
      //Create new method labels
      JLabel label1 = new JLabel();
      JLabel label2 = new JLabel();
   
      //Get the images for the backCard
      label1.setIcon(backCard);
      label2.setIcon(backCard);
      
      //Create method panels
      JPanel panelNorth = new JPanel();
      JPanel panelEast = new JPanel();
      JPanel panelWest = new JPanel();
      JPanel panelC = new JPanel();
      JPanel panelD = new JPanel();

      //Create ActionListener Object
      button1.addActionListener(new ButtonListener());
      
      //Add buttons and labels to panels
      panelNorth.add(score1);
      panelNorth.add(button1);
      panelNorth.add(score2);
      panelCenter.add(labelc);
      panelEast.add(labelx);
      panelSouth.add(labela);
      panelSouth.add(labelb);
      panelEast.add(label1);
      panelWest.add(label2);
      panelWest.add(labely);
      panelSouth.add(label5);
      panelSouth.add(labelwar1);
      panelSouth.add(labelwar4);
      panelSouth.add(labelwar3);
      panelSouth.add(labelwar2);
      panelSouth.add(labelwar5);
      panelSouth.add(labelwar8);
      panelSouth.add(labelwar7);
      panelSouth.add(labelwar6);
   
   
      //Location for panels
      add(panelNorth, BorderLayout.NORTH); 
      add(panelCenter, BorderLayout.CENTER);
      add(panelEast, BorderLayout.EAST);
      add(panelWest, BorderLayout.WEST);
      add(panelSouth, BorderLayout.SOUTH);
      
      
      
      //Prepare and set GUI size
      pack();
      setSize(800,600);
      setVisible(true);
   } 
   
   //Create instance of the WarGame   
   public static void main(String[] args){
      new WarGame();    
   }
   
//_______Button Listener______
   private class ButtonListener implements ActionListener{
   
      public void actionPerformed(ActionEvent e){
      try{
         //Clear war labels each time button pushed
         labelwar1.setIcon(null);    
         labelwar2.setIcon(null);
         labelwar3.setIcon(null);    
         labelwar4.setIcon(null);
         labelc.setText(null);
       
         
         //Update Pile 
         score2.setText("Player 2 Cards: " + pile1.size());
         score1.setText("Player 1 Cards: " + pile2.size());
         
         //Get Card from each pile
         card1 = pile1.RemoveCard();
         card2 = pile2.RemoveCard();
         
         
         //shuffle piles 
         pile1.shuffle();
         pile2.shuffle();
         
         //Compare Cards
         //Call compare method
         //Add cards to winning player pile
         int value = card1.compareTo(card2);
         if(value > 0){
            pile1.AddCard(card1);
            pile1.AddCard(card2);
         }
         else if(value < 0){
            pile2.AddCard(card1);
            pile2.AddCard(card2);
         }
         else{
            //Call War Method
            labelc.setText("WAR!");
            war(pile1,pile2,card1,card2);
            labelwar1.setIcon(backCard);    //Set down Card image
            labelwar2.setIcon(backCard);    //Set down Card image
            
            //Display War Cards
            
            ImageIcon warCard1 = new ImageIcon(getJPG(card5));
            labelwar3.setIcon(warCard1);
            //Get and set Card Pic 2
            ImageIcon warCard2 = new ImageIcon(getJPG(card6));
            labelwar4.setIcon(warCard2);  
         
            
         labelwar5.setIcon(null);
         labelwar6.setIcon(null);
         labelwar7.setIcon(null);
         labelwar8.setIcon(null);
         //card5 = pile1.RemoveCard();
         //card6 = pile2.RemoveCard();
         
         
         //int value2 = card5.compareTo(card6); 
         /*if (value2 > 0){
         pile1.AddCard(card1);
         pile1.AddCard(card2);
         pile1.AddCard(card5);
         pile1.AddCard(card6);
         }
         else if (value2 < 0){
         pile2.AddCard(card1);
         pile2.AddCard(card2);
         pile2.AddCard(card5);
         pile2.AddCard(card6);
         }
         */
         if (card5.equals(card6)){ //(card5.equals(card6))
         labelc.setText("second WAR!!!");
         war(pile1,pile2,card1,card2);
         labelwar5.setIcon(backCard);    //Set down Card image
         labelwar6.setIcon(backCard);    //Set down Card image
         
            
         //Display War Cards
         ImageIcon warCard5 = new ImageIcon(getJPG(card9));
         labelwar7.setIcon(warCard5);
         //Get and set Card Pic 2
         
         ImageIcon warCard6 = new ImageIcon(getJPG(card10));
         labelwar8.setIcon(warCard6);  
         }
         }
         
         
         
         
         
//_____Get and Display Cards_____
         //Get Card Pictures
         String getPic1 = getJPG(card1);
         String getPic2 = getJPG(card2);
         
         try{
            //Get and set Card Pic 1
            ImageIcon frontCard1 = new ImageIcon(getPic1);
            labelx.setIcon(frontCard1);
            //Get and set Card Pic 2
            ImageIcon frontCard2 = new ImageIcon(getPic2);
            labely.setIcon(frontCard2);    
            }//try
         
         catch(Exception eee){
            System.out.println("Picture do not exist");
         }
      }
      
      catch(Exception ee){
      
         //If player 1 wins
         if(pile2.size() > pile1.size()){
            System.out.println("Player 1 Wins");
            labelc.setText("Player 1 Wins");
            score1.setText(null);
            score2.setText(null);
         }     
         else{
            //If player 2 wins
            System.out.println("Player 2 Wins");
            labelc.setText("Player 2 Wins");
            score1.setText(null);
            score2.setText(null); 
         }
      }
   }
   
   }
//____WAR____
   /*
   The war method draws two extra cards from each pile, 
   and compares the 2nd card.  Whichever player wins, gets all
   6 cards
   */
   public void war(Deck pile1, Deck pile2, Card card1, Card card2){//static
         //Create new cards
         Card card3 = new Card();
         Card card4 = new Card();
        
         
         
         //Remove War cards from each pile
         card3 = pile1.RemoveCard();
         card4 = pile2.RemoveCard();
         card5 = pile1.RemoveCard();
         card6 = pile2.RemoveCard();
         //card7 = pile1.RemoveCard();
         //card8 = pile2.RemoveCard();
       
         
         //Call compareTo method
         int value = card5.compareTo(card6);
         
         if(value > 0){
            //If player 1 war card is greater
            pile1.AddCard(card1);
            pile1.AddCard(card2);
            pile1.AddCard(card3);
            pile1.AddCard(card4);
            pile1.AddCard(card5);
            pile1.AddCard(card6);
            //labela.setText("Player 1 wins war");
         }
         else if(value < 0){
           //If player 2 war card is greater
            pile2.AddCard(card1);
            pile2.AddCard(card2);
            pile2.AddCard(card3);
            pile2.AddCard(card4);
            pile2.AddCard(card5);
            pile2.AddCard(card6);
            //labelb.setText("Player 2 wins war");
         }
         
         else {
         Card card7 = new Card();
         Card card8 = new Card();
         card7 = pile1.RemoveCard();
         card8 = pile2.RemoveCard(); 
         card9 = pile1.RemoveCard();
         card10 = pile2.RemoveCard();
         int value2 = card9.compareTo(card10);
         
            //If a second war happens during a war
           if(value2 > 0){
            //If player 1 war card is greater
            pile1.AddCard(card1);
            pile1.AddCard(card2);
            pile1.AddCard(card3);
            pile1.AddCard(card4);
            pile1.AddCard(card5);
            pile1.AddCard(card6);
            pile1.AddCard(card7);
            pile1.AddCard(card8);
            pile1.AddCard(card9);
            pile1.AddCard(card10);
         }
         else if(value2 < 0){
           //If player 2 war card is greater
            pile2.AddCard(card1);
            pile2.AddCard(card2);
            pile2.AddCard(card3);
            pile2.AddCard(card4);
            pile2.AddCard(card5);
            pile2.AddCard(card6);
            pile2.AddCard(card7);
            pile2.AddCard(card8);
            pile2.AddCard(card9);
            pile2.AddCard(card10);
         }
            //labelc.setText("YOU ARE TOO VIOLENT. GAME OVER");
            //System.exit(0);
            }
         }                       
     
        
//____Get JPG_____ 
     /*
     getJPG method gets the corresponding picture of
     the card that is deal
     */
     public String getJPG(Card card2){
        String getPic2;
        
        /*
        Switch statement converts rank of 11 
        */
        switch(card2.getRank()){
        case 11:
           getPic2 = "jack" + card2.getSuit() + ".jpg";
           break;
        case 12:
           getPic2 = "queen" + card2.getSuit() + ".jpg";
           break;
        case 13:
           getPic2 = "king" + card2.getSuit() + ".jpg";
           break;
        case 14:
           getPic2 = "ace" + card2.getSuit() + ".jpg";
           break;
        default:
           getPic2 = card2.getRank() + card2.getSuit() + ".jpg";
        }
        //Return the card filename 
        return getPic2;
     }
}