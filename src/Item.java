
public class Item
{
    private String _itemName = null;
    private String _foundDescription = null;
    private String _useItem = null;
    
    public Item(String name, String foundDesc, String use)
    {
        _itemName = name;
        _foundDescription = foundDesc;
        _useItem = use;
    }
    
    public String getName()
    {
        return _itemName;
    }
    
    public String findItem()
    {
        return _foundDescription;
    }
    
    public String useItem()
    {
        return _useItem;
    }
    
    public String toString()
    {
        return (_itemName + ": \n\t" + _foundDescription + "\n\t" + _useItem);
    }
}
