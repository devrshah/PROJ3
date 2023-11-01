package cpsc2150.extendedConnects;

import cpsc2150.extendedConnectX.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
  Janani Salai (jsalai), Janki Patel (janki7143), Dev Shah (devrshah)
  CPSC 2150 001 Project 3
  November 3, 2023
*/

public class GameScreen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int isPlayer = 1, numInput;
        char playAgainChar = 'Y';
        boolean playAgain;
        boolean hasWon = false;
        final int minPlayerNum=2;
        final int maxPlayerNum=10;
        int numPlayers=0;
        int rows=0;
        int cols=0;
        int numToWin=0;
        int playerInd=0;
        int colChoice= -1;
        //String input;
        List<Character> turn = new ArrayList<>(numPlayers);
        IGameBoard board = new GameBoard();


        while (playAgainChar == 'Y' || playAgainChar == 'y') {
            //number of players
            System.out.println("How many Players?");
            String input = scanner.nextLine();
            numPlayers = Integer.parseInt(input);
            //input validaton with maximum and minimum players numbers
            while (numPlayers < minPlayerNum || numPlayers > maxPlayerNum) {
                System.out.println("Invalid number of players -- please enter a value between 2 and 10: ");
                System.out.println("How many players?");
                input = scanner.nextLine();
                numPlayers = Integer.parseInt(input);
            }

            for (int i = 1; i <= numPlayers; i++) {
                System.out.println("Enter character to represent the player " + i);
                char token = Character.toUpperCase(scanner.next().charAt(0));
                //input validation to make sure there are no tokens repeated
                while (turn.contains(token)) {
                    System.out.println("The token " + token + " is already taken.");
                    System.out.println("Enter character to represent player " + i);
                    token = Character.toUpperCase(scanner.next().charAt(0));
                }
                turn.add(token);
            }
            //get number of rows
            do{
                System.out.println("How many rows are there on the board?");
                input = scanner.nextLine();
                rows = Integer.parseInt(input);
                if(rows < IGameBoard.numRows || rows > IGameBoard.MAX_LENGTH) {
                    System.out.println("Invalid row number -- enter a number between 3 and 100: ");
                }
            }while(rows < IGameBoard.numRows || rows > IGameBoard.MAX_LENGTH);
            //get number of colums
            do{
                System.out.println("How many columns are there on the board?");
                input=scanner.nextLine();
                rows=Integer.parseInt(input);
                if(cols < IGameBoard.numRows || cols > IGameBoard.MAX_LENGTH) {
                    System.out.println("Invalid columns number -- enter a number between 3 and 100: ");
                }
            }while(cols < IGameBoard.numCols || cols > IGameBoard.MAX_LENGTH);

            //get number in a row to win
            do {
                System.out.println("How many in a row to win?");
                input = scanner.nextLine();
                numToWin = Integer.parseInt(input);
                if(numToWin< IGameBoard.numRows ||numToWin > rows || numToWin > cols || numToWin < IGameBoard.numToWin) {
                    System.out.println("Invalid number to win -- enter a number between 3 and 25: ");
                }
            }while(numToWin < IGameBoard.numRows || numToWin > rows || numToWin > cols || numToWin < IGameBoard.numToWin);

            // type of game
            char game;
            do {
                System.out.println("Would you like a fast game or a memory efficient game?\nEnter F (fast) or M (memory efficient): ");
                game = Character.toUpperCase(scanner.next().charAt(0));
                if(game != 'F' && game != 'M') {
                    System.out.println("Invalid input. Enter F for a fast game or M for a memory-efficient game: ");
                }
            }while(game != 'F' && game != 'M');

            //if fast
            if(game=='F') {
                board = new GameBoard();
            }

            if(game=='M') {
                board= new GameBoardMem(rows, cols, numToWin);
            }
            System.out.println(board.toString());

        }


        while (!hasWon) {

            System.out.println("Player " + turn.get(playerInd) + ": choose a column to place token.");
            String input = scanner.nextLine();
            int numInput = Integer.parseInt(input);

            while (numInput < 0 || numInput >= board.getNumColumns()) {
                if (numInput < 0) {
                    System.out.println("Column can not be less than 0");
                }else {
                    System.out.println("Column cannot be greater than " + (board.getNumColumns()-1));
                }
                System.out.println("Player " + turn.get(playerInd) + ": choose a column to place token.");
                input = scanner.nextLine();
                numInput = Integer. parseInt(input);
            }

            if (board.checkIfFree(numInput)) {

                board.dropToken(turn.get(playerInd), numInput);
                if (board.checkForWin(numInput)) {
                    hasWon = true;
                }else if (board.checkTie()){
                    hasWon = true;
                }
            }else{
                System.out.println("Column is full");
                board.toString();
            }
        }


        if (!board.checkTie()) {
            System.out.println("Player " + turn.get(playerInd) + " has won!");
        }else{

            System.out.println("This game has ended in a tie!");
        }

        System.out.println("Would you like to play again? Y/N");
        String input = scanner.nextLine();
        playAgainChar = input.charAt(0);
        if (playAgainChar == 'Y' || playAgainChar == 'y') {
            playerInd = -1;
            hasWon = false;
            playAgain= true;
        }else{
            hasWon = true;
            playAgain = false;
        }

        //reset player index for new game
        if((playerInd + 1) != numPlayers) {
            playerInd++;
        }else {
            playerInd = 0;

        }
    }
}
