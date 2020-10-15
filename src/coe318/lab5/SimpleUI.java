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
import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
      System.out.println("The House Holds:\n"+game.getHouseCards().toString());
      System.out.println("You have:\n"+game.getYourCards().toString());  //FIX THIS
        
    }

  @Override
    public boolean hitMe() {
        System.out.println("Another card?");
        System.out.println("Enter (y for yes or n for no): ");
        String userInput=user.nextLine();
        if (userInput.toLowerCase().equals("y")){
            return true;
        }
        else if (userInput.toLowerCase().equals("n")){
            return false;
        }
     
            return this.hitMe();
              
        
    }

  @Override
    public void gameOver() {
        boolean userWin = false;
        int houseScore= game.score(game.getHouseCards());
        int userScore = game.score(game.getYourCards());
        for(int i = 0; i < game.getHouseCards().getCards().size(); i++) {
            game.getHouseCards().getCards().get(i).setFaceUp(true);
        }
        for(int i = 0; i < game.getYourCards().getCards().size(); i++) {
            game.getYourCards().getCards().get(i).setFaceUp(true);
        }
        System.out.println("The House's Final Cards:\n"+game.getHouseCards().toString());
        System.out.println("Your Final Cards:\n"+game.getYourCards().toString());     

        if (houseScore > 21 && userScore <= 21) {
            userWin  = true;
        }
        else if (houseScore <= 21 && userScore <= 21 && userScore>houseScore) {
            userWin  = true;
        }
        System.out.println("House Score: "+ houseScore +"     Your Score: "+userScore);
        if (userWin  ==true) {
            System.out.println("You Win!");
        }
        else {
            System.out.println("The House Wins!");
        }
        System.out.println("Game Over! Please Come Again!");
        
    }

}