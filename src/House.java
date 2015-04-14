
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
    
    public String getCurrentRoomInfo()
    {
        if(_floorPlan[_rowLoc][_colLoc] == null)
        {
            return "Somehow you worked your way through a portal to hell.  Goodluck getting out.";
        }
        
        return _floorPlan[_rowLoc][_colLoc].getRoomInfo();
    }
    
    public Trap hasFallenIntoTrap()
    {
        Room currentRoom = _floorPlan[_rowLoc][_colLoc];
        if(currentRoom.hasTrap())
        {
            return currentRoom.getTrap();
        }
        
        return null;
    }
    
    
    public String getSurroundingsInfo()
    {
        boolean north = _rowLoc - 1 >= 0 && _floorPlan[_rowLoc - 1][_colLoc] != null;
        boolean south = _rowLoc + 1 < _floorPlan.length && _floorPlan[_rowLoc + 1][_colLoc] != null;
        boolean east = _colLoc + 1 < _floorPlan[_rowLoc].length && _floorPlan[_rowLoc][_colLoc + 1] != null;
        boolean west = _colLoc - 1 >= 0 && _floorPlan[_rowLoc][_colLoc - 1] != null;
        
        StringBuilder sb = new StringBuilder("");
        sb.append("You see a door: ");
        if(!(north || south || east || west))
        {
            sb.append("NOWHERE... You're screwed");
        }
        else
        {
            if(south)
            {
                sb.append("[south]");
            }
            if(north)
            {
                sb.append("[north]");
            }
            if(east)
            {
                sb.append("[east]");
            }
            if(west)
            {
                sb.append("[west]");
            }
        }
        
        sb.append(".");
        return sb.toString();
    }

}
