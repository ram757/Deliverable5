import java.util.ArrayList;


public class Room
{
    private String _roomDescription = null;
    private String _peekDescription = null;
    private Trap _trap = null;
    private boolean _hasTrap = false;
    private Item _item = null;
    private boolean _hasItem = false;
    private String _itemUsable = null;
    
    public Room(String desc, String peekDesc, Item item, Trap trap, String usable)
    {
        _roomDescription = desc;
        _peekDescription = peekDesc;
        _itemUsable = usable;
        
        if(item != null)
        {
            _item = item;
            _hasItem = true;
        }
        if(trap != null)
        {
            _trap = trap;
            _hasTrap = true;
        }
    }
    
    public Room(String desc, String peekDesc)
    {
        _roomDescription = desc;
        _peekDescription = peekDesc;
        _trap = null;
        _hasTrap = false;
        _item = null;
        _hasItem = false;
        _itemUsable = null;
    }
    
    public boolean hasItem()
    {
        return _hasItem;
    }
    
    public boolean hasTrap()
    {
        return _hasTrap;
    }
  
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Room:");
        sb.append("\n\tDescription: ").append(_roomDescription);
        if(_hasTrap) { sb.append("\n\tTrap: ").append(_trap.toString()); }
        if(_hasItem) { sb.append("\n\tItem: ").append(_item.toString()); }
        if(_itemUsable != null) { sb.append("\n\tItem Usable: ").append(_itemUsable); }
        return sb.toString();
    }
    
}
