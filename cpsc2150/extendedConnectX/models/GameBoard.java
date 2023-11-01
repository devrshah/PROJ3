package cpsc2150.extendedConnectX.models;

/*
  Janani Salai (jsalai), Janki Patel (janki7143), Dev Shah (devrshah)
  CPSC 2150 001 Project 2
  October 13, 2023
*/

public class GameBoard extends AbsGameBoard {


    private char[][] gameboard;
    private int numToWin;
    private int numRows;
    private int numCols;

    /**
     * Constructor for the GameBoard class that instantiates a 2-D array of blank
     * cells
     * 
     * @invariant game board is of dimension 8x6 with 42 positions
     * @post GameBoard sets all spaces to empty char- [' ']
     * @post GameBoard instance is in usable state
     */
    public GameBoard(int row, int col, int win) {

        numToWin = win;
        numRows = row;
        numCols = col;
        gameboard = new char[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                gameboard[i][j] = ' ';
            }
        }
    }
    
    /**
     * @param pos is a BoardPosition object that gives the coordinates of a cell
     * @post self = #self
     * @return the char at the position or [" "] if the location is empty
     */
    public char whatsAtPos(BoardPosition pos) {
        
        return gameboard[pos.getRow()][pos.getColumn()];
    }

    @Override
    public int getNumRows() {
        return numRows;
    }

    @Override
    public int getNumColumns() {
        return numCols;
    }

    @Override
    public int getNumToWin() {
        return numToWin;
    }

    /**
     * Drops the token p in column c
     * @pre c >= 0 and c <= numCol and p is a valid token and checkIfFree(int c) = true
     * @param p is the token to be placed on the game board
     * @param c is the column in which the token will be placed
     * @post the lowest empty slot in column c = char p
     */
    public void dropToken(char p, int c){
        // check if the spot is free
        if (checkIfFree(c)) {
            // find the lowest empty spot in the column
            // while (i >= 0 && gameboard[i][c] != ' ') {
            //     i--;
            // }
           
                for (int i = 0; i < gameboard.length; i++) {
                    if (gameboard[i][c] == ' ') {
                        gameboard[i][c] = p;
                        break;
                    }
                }
            }
            // place the token at the lowest empty spot in the column
        }
    
}