package cpsc2150.extendedConnectX.models;

import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.ArrayList;

public class GameBoardMem extends AbsGameBoard {
    private Map<Character, List<BoardPosition>> mapBoard;
    private int numRows, numCols, numToWin;

    public GameBoardMem(int row, int col, int win) {
        mapBoard = new HashMap<>();
        numRows = row;
        numCols = col;
        numToWin = win;
    }

    /**
     * Function to return number of rows on board (length)
     * @return row number
     */
    public int getNumRows() {
        return numRows;
    }

    /**
     * Function to return number of columns on board (width)
     * @return column number
     */
    public int getNumColumns() {
        return numCols;
    }

    /**
     * Function to return number of token to be placed in a row in order for game to result in a win
     * @return number to win
     */
    public int getNumToWin() {
        return numToWin;
    }

    /**
     * Function to place specific character token in given position
     * @param p is the token to be placed on the game board
     * @param c is the column in which the token will be placed
     * @pre p is existing character token, c is a valid column in which a token can be placed
     * @post given character token will be placed in specified column
     */
    public void dropToken(char p, int c) {
//        if(mapBoard.containsKey(p) == false) {
//            mapBoard.put(p, new ArrayList<>());
//        }else {
//            for(int i = 0; i < getNumRows(); i++) {
//                BoardPosition board = new BoardPosition(i, c);
//                if(whatsAtPos(board) == ' ') {
//                    mapBoard.get(p).add(board);
//                    break;
//                }
//            }
//        }
        for (int r = 0; r < getNumColumns(); r++) {
            BoardPosition pos = new BoardPosition(r, c);
            if (whatsAtPos(pos) == ' ') {
                if (mapBoard.containsKey(p)) {
                    mapBoard.get(p).add(pos);
                }
                else {
                    List<BoardPosition> newList = new ArrayList<>();
                    newList.add(pos);
                    mapBoard.put(p, newList);
                }
                //Breaks the loop
                r = getNumColumns();
            }
        }
    }

    /**
     * Function to determine what is at the given position
     * @param pos is a BoardPosition object that gives the coordinates of a cell
     * @post will return token of a player, or ' '
     * @return the character token of a player at position, or ' ' if blank
     */
    public char whatsAtPos(BoardPosition pos) {
        for(HashMap.Entry<Character, List<BoardPosition>> map : mapBoard.entrySet()) {
            if(isPlayerAtPos(pos, map.getKey())) {
                return map.getKey();
            }
        }
        return ' ';
    }

    /**
     * Overridden function to determine if the player is at the given position
     * @param pos is a position in grid
     * @param p is the character token of the player
     * @pre character must be existing token character, and pos is of format (row, col)
     * @post true iff pos on board is available, false otherwise
     * @return true if player is at given position, false otherwise
     */
    @Override
    public boolean isPlayerAtPos(BoardPosition pos, char p) {
        if(mapBoard.containsKey(p)) {
            return false;
        }else {
            for(BoardPosition boardpos : mapBoard.get(p)) {
                if(boardpos.equals(pos)) {
                    return true;
                }
            }
        }
        return false;
    }
}