/*
Hung Vu
CS110                     
Assignment#10
/*

/*
The card class sets, holds and gets the rank and suit
of a playing card 
*/

public class Card{
   //initializing private int for class
   private int rank;
   private String suit;
   

   public Card(){
      rank = 0;
      suit = null;   
   }
   //Alternate constructor sets rank and suit.
   
   public Card(int rank,String suit)
   {
      this.rank = rank;
      this.suit = suit;
   }
   
   //setRank method sets the numeric value of the card

   public void setRank(int rank)
   {
      this.rank = rank;
   }
   
   //setSuit method sets the suit of the card
  
   public void setSuit( String suit)
   {
      this.suit = suit;
   }
   
   // getRank method returns the numeric value of the card
  
   public int getRank()
   {
      return rank;
   }
   
   //getSuit method returns the suit of the card
 
   public String getSuit()
   {
      return suit;
   }
   
   // compareTo method returns the integer -1,0, or 1 depending on which card has a greater rank
    
   public int compareTo(Card card1){
      int status;
      if(rank == card1.getRank())
        status = 0;
      else if(rank > card1.getRank())
         status = 1;
      else
         status = -1;
      return status;   
   }
   
   //toString method returns a string that has the rank and suit of a card
   
 
   public String toString(Card card){
      String string = card.getRank() + " of " + card.getSuit();
      System.out.println(string);
      return string;
   }
}