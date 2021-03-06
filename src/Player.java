import java.util.ArrayList;


public class Player
{
    private ArrayList<Item> _inventory = null;
    
    public Player()
    {
        _inventory = new ArrayList<Item>();
    }
    
    public boolean addToInventory(Item item)
    {
        return _inventory.add(item);
    }
    
    public boolean hasItem(String itemName)
    {
        for(Item i : _inventory)
        {
            if(itemName.equalsIgnoreCase(i.getName()))
            {
                return true;
            }
        }
        return false;
    }
    
    public Item useItem(String itemName)
    {
        for(Item item : _inventory)
        {
            if(itemName.equalsIgnoreCase(item.getName()))
            {
                _inventory.remove(item);
                return item;
            }
        }
        return null;
    }
    
}
