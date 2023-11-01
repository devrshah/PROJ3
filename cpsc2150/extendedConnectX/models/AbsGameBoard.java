package cpsc2150.extendedConnectX.models;

/*
  Janani Salai (jsalai), Janki Patel (janki7143), Dev Shah (devrshah)
  CPSC 2150 001 Project 2
  October 13, 2023
*/

public abstract class AbsGameBoard implements IGameBoard {
    /**
     * Function to print game board as a string
     * @post returns the string with the current grid and rows = #rows and columns = #columns
     */
    @Override
    // public String toString() {
    //     int count = 0;
    //     StringBuilder gameBoard = new StringBuilder();
    //     //array of cells on board
    //     BoardPosition[] boardPosition = new BoardPosition[getNumRows() * getNumColumns()];

    //     //construct top row of board
    //     for(int i = 0; i < getNumColumns(); i++) {
    //         gameBoard.append("|" + i);
    //     }
    //     //end of top row
    //     gameBoard.append("|\n");

    //     //construct the rest of the board recursively
    //     for(int i = 0; i < getNumRows(); i++) {
    //         for(int j = 0; j < getNumColumns(); j++) {
    //             boardPosition[count] = new BoardPosition(i, j);
    //             gameBoard.append("|" + this.whatsAtPos(boardPosition[count]));
    //         }
    //         //end of each row
    //         gameBoard.append("|\n");
    //     }

    //     //print game board
    //     return gameBoard.toString();
    // }
    public String toString() {
        int count = 0;
        StringBuilder gameBoard = new StringBuilder();
        // Array of cells on board
        BoardPosition[] boardPosition = new BoardPosition[getNumRows() * getNumColumns()];
    
        // Construct top row of board
        for (int i = 0; i < getNumColumns(); i++) {
            gameBoard.append("| " + i);
        }
        // End of top row
        gameBoard.append("|\n");
    
        // Construct the rest of the board recursively, but invert the rows
        for (int i = getNumRows() - 1; i >= 0; i--) {
            for (int j = 0; j < getNumColumns(); j++) {
                boardPosition[count] = new BoardPosition(i, j);
                gameBoard.append("| " + this.whatsAtPos(boardPosition[count]));
            }
            // End of each row
            gameBoard.append("|\n");
        }
    
        // Print the inverted game board
        return gameBoard.toString();
    }    
}
