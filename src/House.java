
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
    
    public Item lookInCurrentRoom()
    {
        if(_floorPlan[_rowLoc][_colLoc] != null && _floorPlan[_rowLoc][_colLoc].hasItem())
        {
            return _floorPlan[_rowLoc][_colLoc].getItem();
        }
        
        return null;
    }
    
    public boolean canUseItemHere(String itemName)
    {
        if(_floorPlan[_rowLoc][_colLoc] != null)
        {
            String itemUsable = _floorPlan[_rowLoc][_colLoc].getItemUsable();
            if(itemUsable != null && itemUsable.equalsIgnoreCase(itemName))
            {
                return true;
            }
        }
        return false;
    }
    
    public String peekNorth()
    {
        int peek = _rowLoc - 1;
        if(peek >= 0 && _floorPlan[peek][_colLoc] != null)
        {
            return _floorPlan[peek][_colLoc].peekInRoom();
        }
        return null;
    }
    
    public String peekSouth()
    {
        int peek = _rowLoc + 1;
        if(peek < _floorPlan.length && _floorPlan[peek][_colLoc] != null)
        {
            return _floorPlan[peek][_colLoc].peekInRoom();
        }
        return null;
    }
    
    public String peekEast()
    {
        int peek = _colLoc + 1;
        if(peek < _floorPlan[_rowLoc].length && _floorPlan[_rowLoc][peek] != null)
        {
            return _floorPlan[_rowLoc][peek].peekInRoom();
        }
        return null;
    }
    
    public String peekWest()
    {
        int peek = _colLoc - 1;
        if(peek >= 0 && _floorPlan[_rowLoc][peek] != null)
        {
            return _floorPlan[_rowLoc][peek].peekInRoom();
        }
        return null;
    }
    
    public boolean moveNorth()
    {
        int move = _rowLoc - 1;
        if(move >= 0 && _floorPlan[move][_colLoc] != null)
        {
            _rowLoc = move;
            return true;
        }
        return false;
    }
    
    public boolean moveSouth()
    {
        int move = _rowLoc + 1;
        if(move < _floorPlan.length && _floorPlan[move][_colLoc] != null)
        {
            _rowLoc = move;
            return true;
        }
        return false;
    }
    
    public boolean moveEast()
    {
        int move = _colLoc + 1;
        if(move < _floorPlan[_rowLoc].length && _floorPlan[_rowLoc][move] != null)
        {
            _colLoc = move;
            return true;
        }
        return false;
    }
    
    public boolean moveWest()
    {
        int move = _colLoc - 1;
        if(move >= 0 && _floorPlan[_rowLoc][move] != null)
        {
            _colLoc = move;
            return true;
        }
        return false;
    }
    
    public boolean checkForEndRoom()
    {
        if(_colLoc == _endCol && _rowLoc == _endRow)
        {
            return true;
        }
        return false;
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0; i < _floorPlan.length; i++)
        {
            for(int j = 0; j < _floorPlan[i].length; j++)
            {
                if(_floorPlan[i][j] == null)
                {
                    sb.append("Location: row-" + i + " col-" + j + "\n");
                    sb.append("\tEmpty\n");
                }
                else
                {
                    sb.append("Location: row-" + i + " col-" + j + "\n");
                    sb.append(_floorPlan[i][j].toString() + "\n");
                }
            }
        }
        return sb.toString();
    }

    public String printFloorPlan()
    {
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0; i < _floorPlan.length; i++)
        {
            for(int j = 0; j < _floorPlan[i].length; j++)
            {
                if(_floorPlan[i][j] == null)
                {
                    sb.append("o");
                }
                else
                {
                    sb.append("x");
                }
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    
}
