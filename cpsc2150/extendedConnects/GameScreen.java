package cpsc2150.extendedConnects;

import cpsc2150.extendedConnectX.models.BoardPosition;
import cpsc2150.extendedConnectX.models.GameBoard;
import cpsc2150.extendedConnectX.models.IGameBoard;

import java.util.Scanner;

/*
  Janani Salai (jsalai), Janki Patel (janki7143), Dev Shah (devrshah)
  CPSC 2150 001 Project 2
  October 13, 2023
*/

public class GameScreen {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    int isPlayer = 1, numInput;
    char playAgain = 'Y', player;
    String input;
    boolean hasWon = false;

    IGameBoard game = new GameBoard(10,10,4);

    while (playAgain == 'Y' || playAgain == 'y') {
      while (!hasWon) {
        
        if(isPlayer % 2 == 0){
          player = 'O';
        }else{
          player = 'X';
        }
        isPlayer++;

        System.out.println(game.toString());
        System.out.println("Player " + player + ", what column do you want to place your marker in?");
        input = scnr.nextLine();
        numInput = Integer.parseInt(input);

        while (numInput < 0 || numInput >= game.getNumColumns()) {
          if (numInput < 0) {
            System.out.println("Column can not be less than 0");
          }else {
            System.out.println("Column cannot be greater than " + (game.getNumColumns()-1));
          }

          System.out.println("Player " + player + ", what column do you want to place your marker in?");
          input = scnr.nextLine();
          numInput = Integer. parseInt(input);
        }

        if (game.checkIfFree(numInput)) {
          
          game.dropToken(player, numInput);
          if (game.checkForWin(numInput)) {
            --isPlayer;
            hasWon = true;
          }else if (game.checkTie()){
            hasWon = true;
          }
        }else{
            System.out.println("Column is full");
            game.toString();
          }
      }
      
      
      if (isPlayer % 2 == 0) {
          
        player = 'O';
      }else{

        player = 'X';
      }

      if (!game.checkTie()) {
        System.out.println("Player " + player + " has won!");
      }else{

        System.out.println("This game has ended in a tie!");
      }

      System.out.println("Would you like to play again? Y/N");
      input = scnr.nextLine();
      playAgain = input.charAt(0);
      if (playAgain == 'Y' || playAgain == 'y') {
        game = new GameBoard(20,20,4);
        hasWon = false;
      }else{
        playAgain = 'N';
      }
    }
  }
}
