/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab5;

/**
 *
 * @author Shaan Hossain 500882569
 */
public class Card implements Comparable {
    //Symbolic constants

  public static final int CLUB = 0;
  public static final int DIAMOND = 1;
  public static final int HEART = 2;
  public static final int SPADE = 3;

  /**
   * Construct a card of the given rank, suit and whether it is faceup or
   * facedown. The rank is an integer from 2 to 14. Numbered cards (2 to 10)
   * have a rank equal to their number. Jack, Queen, King and Ace have the ranks
   * 11, 12, 13, and 14 respectively. The suit is an integer from 0 to 3 for
   * Clubs, Diamonds, Hearts and Spades respectively.
   *
   * @param rank
   * @param suit
   * @param faceUp
   */
  private int rank;
  private int suit; 
  private boolean faceUp;
  
  public Card(int rank, int suit, boolean faceUp) {
   this.rank = rank;
   this.suit = suit;
   this.faceUp = faceUp;//FIX THIS
  }

  /**
   * @return the faceUp
   */
  public boolean isFaceUp() {
    return faceUp;
  }

  /**
   * @param faceUp the faceUp to set
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }

  /**
   * @return the rank
   */
  public int getRank() {
    return rank; 
  }

  /**
   * @return the suit
   */
  public int getSuit() {
    return suit;
  }

  @Override
  public boolean equals(Object ob) {
    if (!(ob instanceof Card)) {
      return false;
    }
    Card c = (Card) ob;  
    if (c.getSuit() == this.getSuit() && c.getRank() == this.getRank()) {
        return true;
    }
  return false;
    
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + this.getRank();
    hash = 31 * hash + this.getSuit();
    return hash;
  }

  @Override
  public int compareTo(Object obj) {
    return compareTo((Card) obj);
  }

  public int compareTo(Card c) {
      if (c.getRank() != this.getRank()) {
          return ((c.getRank() > this.getRank()) ? -1 : 1);
      }
      else {
          if (c.getSuit() != this.getSuit()) {
              return ((c.getSuit() > this.getSuit()) ? -1 : 1);
          }
          return 0;
          
      }
  
  }

  /**
   * Return the rank as a String. For example, the 3 of Hearts produces the
   * String "3". The King of Diamonds produces the String "King".
   *
   * @return the rank String
   */
  public String getRankString() {
      
    if (this.getRank() < 11 && this.getRank() > 1) {
          return (""+this.getRank());
      }
      else {
          switch(this.getRank()) {
              case 11:
                  return ("Jack");
              case 12:
                  return ("Queen");
              case 13:
                  return ("King");
              case 14:
                  return ("Ace");
              default:
                  return (null);
       
  }
  }
  } 

  /**
   * Return the suit as a String: "Clubs", "Diamonds", "Hearts" or "Spades".
   *
   * @return the suit String
   */
  public String getSuitString(){
      if (this.suit== 0)
      {
          return "Clubs";
      }
      else if (this.suit==1)
      {
          return "Diamonds";
         
      }
      else if (this.suit ==2)
      {
          return "Hearts";
      }
      else if(this.suit ==3)
      {
          return "Spades";
      }
    return null; 
  }

  /**
   * Return "?" if the card is facedown; otherwise, the rank and suit of the
   * card.
   *
   * @return the String representation
   */
  @Override
  public String toString() {
    if (this.faceUp == false)
    {
    return " ?"; 
    }
    return (" "+this.getRankString()+" of "+this.getSuitString());
  }

  public static void main(String[] args) {
    //Create 5 of clubs
    Card club5 = new Card(5, 0, true);
    System.out.println("club5: " + club5);
    Card spadeAce = new Card(14, SPADE, true);
    System.out.println("spadeAce: " + spadeAce);
    System.out.println("club5 compareTo spadeAce: "
            + club5.compareTo(spadeAce));
    System.out.println("club5 compareTo club5: "
            + club5.compareTo(club5));
    System.out.println("club5 equals spadeAce: "
            + club5.equals(spadeAce));
    System.out.println("club5 equals club5: "
            + club5.equals(club5));
  }
}

