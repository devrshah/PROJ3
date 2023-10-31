package cpsc2150.extendedConnectX.models;

/*
CREATE REPO
  Janani Salai (jsalai), Janki Patel (janki7143), Dev Shah (devrshah)
  CPSC 2150 001 Project 2
  October 13, 2023
*/

public class BoardPosition
{
    private int Row;
    private int Column;

    /**
     * Constructor for the BoardPosition class
     * @param aRow is row of cell on game board
     * @param aColumn is column of cell on game board
     * @post Row = aRow, Column = aColumn
     */
    public BoardPosition(int aRow, int aColumn)
    {
        Row = aRow;
        Column = aColumn;
    }

    /**
     * Getter function to return row position of cell on board
     * @post Row = #Row
     * @return the integer row of the position
     */
    public int getRow()
    {
        return Row;
    }

    /**
     * Getter function to return column position of cell on board
     * @post Column = #Column
     * @return the integer row of the position
     */
    public int getColumn()
    {
        return Column;
    }
    /**
     * Overriding function to compare two cells on the board
     * @param obj an Object that is a cell on the board position
     * @post if the rows and columns obtained using the Object obj are equal(row = row and column = column), returns true
     *        if not, return false 
     *         Column = #Column and Row = #Row
     * @return true if cells are equal, and false if not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != getClass()) { //compare classes
            return false;
        }
        BoardPosition pos = (BoardPosition) obj;
        //compare row and col and return
        return (pos.getRow() == getRow() && pos.getColumn() == getColumn());
    }

    /**
     * Overriding function to convert two integer values into a comma-delineated string
     * @post Row = #Row and Column = #Column, returns a string in the format "<row>, <col>"
     * @return a string with position of the space
     */
    @Override
    public String toString()
    {
        return (Row + "," + Column);
    }
}