
public class House
{
    private Room[][] _floorPlan;
    private int _rowLoc = 0;
    private int _colLoc = 0;
    
    private int _endRow = 0;
    private int _endCol = 0;
    

    public House(Room[][] board)
    {
        _floorPlan = board;
    }
    
    public House(Room[][] board, int startRow, int startCol, int endRow, int endCol)
    {
        _floorPlan = board;
        _rowLoc = startRow;
        _colLoc = startCol;
        _endRow = endRow;
        _endCol = endCol;
    }
 
    
}
