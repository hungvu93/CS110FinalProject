/*
Hung Vu
CS110                      
Assignment#10
*/
import java.util.Random;
import java.util.ArrayList;

// The Deck class Creates a deck of cards using an arrayList

public class Deck{
   //Field declarations
   private Card card = new Card();
   private Card temp = new Card();
   private ArrayList<Card> deck = new ArrayList<Card>();
   private ArrayList<Card> pile1 = new ArrayList<Card>();
   private ArrayList<Card> pile2 = new ArrayList<Card>();
   private Random rand = new Random();;
   

   public Deck(){
   }
   
   
   //Constructor creates a Deck of 4 suits between a high and low card value
  
   public Deck(int low,int high){
      for(int i = low;i < high;i++)
         deck.add(new Card(i, "c"));
      for(int i = low;i < high;i++)
         deck.add(new Card(i, "d"));
      for(int i = low;i < high;i++)
         deck.add(new Card(i, "h"));
      for(int i = low;i < high;i++)
         deck.add(new Card(i, "s"));   
      }
   
   
   //size method returns the size of the deck
 
   public int size() 
   {
      return deck.size();
   }
   
   
   //isEmpty method returns boolean if deck is empty or not
   
   public boolean isEmpty() 
   {
      return deck.size() == 0;
   }
   
   //RemoveCard method returns the last card in the deck
  
   public Card RemoveCard()
   {
          card = deck.remove(deck.size()-1);
          return card;
   }
   
   
   //AddCard adds a card to the beginning of deck
  
   public void AddCard(Card card){
      deck.add(0,card);
   }
   
   //getDeck method returns an arrayList of cards
  
   public ArrayList<Card> getDeck(){
      return deck;
   }
   
   
   //shuffle method shuffles the card in a deck
   
   public void shuffle(){
      for(int i = 0; i < 1000; i++){      
         int randNum = rand.nextInt(deck.size());
         temp = deck.remove(deck.size()-1);
         deck.add(randNum,temp);        
      }
   }  
}