import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ItemTest
{
    String name;
    String description;
    String usage;
    
    @Before
    public void setUp() throws Exception
    {
        name = "MagicStick";
        description = "Lil Kim's got this...";
        usage = "50 Cent appears.";
    }
    
    @Test
    public void testItemConstructor()
    {
        Item item = new Item(name, description, usage);
        assertTrue(item != null);
    }
    
    @Test
    public void testItemToString()
    {
        Item item = new Item(name, description, usage);
        String expectedString = (name + ": \n\t" + description + "\n\t" + usage);
        String returnedString = item.toString();
        assertEquals(expectedString, returnedString);
        assertTrue(expectedString.equals(returnedString));
    }
    
    @Test 
    public void testGetName()
    {
        Item item = new Item(name, description, usage);
        String expectedString = name;
        String returnedString = item.getName();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    public void testFindItem()
    {
        Item item = new Item(name, description, usage);
        String expectedString = description;
        String returnedString = item.findItem();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    public void testUseItem()
    {
        Item item = new Item(name, description, usage);
        String expectedString = usage;
        String returnedString = item.useItem();
        
        assertEquals(expectedString, returnedString);
    }

}
