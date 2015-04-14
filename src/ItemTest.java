import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/* ItemTest Class
 *     Test cases used to develop the Test Class through TDD
 */
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
    /*
     * Test that Item object can be created appropriately
     */
    public void testItemConstructor()
    {
        Item item = new Item(name, description, usage);
        assertTrue(item != null);
    }
    
    @Test
    /*
     * Tests that an item can be converted to a String
     */
    public void testItemToString()
    {
        Item item = new Item(name, description, usage);
        String expectedString = (name + ": \n\t" + description + "\n\t" + usage);
        String returnedString = item.toString();
        assertEquals(expectedString, returnedString);
        assertTrue(expectedString.equals(returnedString));
    }
    
    @Test 
    /*
     * Tests that created item has correct name by testing the
     * getName() method
     */
    public void testGetName()
    {
        Item item = new Item(name, description, usage);
        String expectedString = name;
        String returnedString = item.getName();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Tests findItem() method to verify it returns the 
     * description of item
     */
    public void testFindItem()
    {
        Item item = new Item(name, description, usage);
        String expectedString = description;
        String returnedString = item.findItem();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test useItem() method to verify that it produces the 
     * correct return value
     */
    public void testUseItem()
    {
        Item item = new Item(name, description, usage);
        String expectedString = usage;
        String returnedString = item.useItem();
        
        assertEquals(expectedString, returnedString);
    }

}
