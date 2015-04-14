import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/* PlayerTest Class
 *     Test cases used to develop the Player Class through TDD
 */
public class PlayerTest
{
    @Mock
    Item mockItem1 = Mockito.mock(Item.class);
    Item mockItem2 = Mockito.mock(Item.class);
    
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(mockItem1);
        MockitoAnnotations.initMocks(mockItem2);
    }
    
    @Test
    /*
     * Test the constructor and verify it produces a Player
     */
    public void testPlayerConstructor()
    {
        Player player = new Player();
        
        assertTrue(player != null);
    }
    
    @Test
    /*
     * Test the addToInventory() method by adding one item and verify 
     * that the expected result is returned
     */
    public void testAddOneItemToInventory()
    {
        Player player = new Player();
        
        assertTrue(player.addToInventory(mockItem1));
    }
    
    @Test
    /*
     * Test the addToInventory() method by adding multiple items and 
     * verify that the expected results are produced with each add
     */
    public void testAddMultipleItemToInventory()
    {
        Player player = new Player();
        
        assertTrue(player.addToInventory(mockItem1));
        assertTrue(player.addToInventory(mockItem2));
    }
    
    @Test
    /*
     * Test the hasItem() method given that the item exists in 
     * the Players inventory and verify that the correct response 
     * is produced
     */
    public void testHasItemWithExistingItems()
    {
        String itemString1 = "Aloe Fresh Lotion";
        String itemString2 = "Jelly Beans";
        
        when(mockItem1.getName()).thenReturn(itemString1);
        when(mockItem2.getName()).thenReturn(itemString2);
        
        Player player = new Player();
        player.addToInventory(mockItem1);
        player.addToInventory(mockItem2);
        
        assertTrue(player.hasItem(itemString1));
        assertTrue(player.hasItem(itemString2));
    }
    
    @Test
    /*
     * Test the hasItem() method given that the Player an empty 
     * inventory and verify that the correct results are produced
     */
    public void testHasItemWithEmptyInventory()
    {
        String itemString1 = "Aloe Fresh Lotion";
        String itemString2 = "Jelly Beans";

        Player player = new Player();

        assertFalse(player.hasItem(itemString1));
        assertFalse(player.hasItem(itemString2));
    }
    
    @Test
    /*
     * Test the hasItem() method given that the Player has items 
     * in their inventory but not the specified item and verify 
     * that the correct results are produced
     */
    public void testHasItemWithoutItemInInventory()
    {
        String itemString1 = "Aloe Fresh Lotion";
        String itemString2 = "Jelly Beans";
        String itemString3 = "Failure";
        
        when(mockItem1.getName()).thenReturn(itemString1);
        when(mockItem2.getName()).thenReturn(itemString2);
        
        Player player = new Player();
        player.addToInventory(mockItem1);
        player.addToInventory(mockItem2);
        
        assertFalse(player.hasItem(itemString3));
    }
    
    @Test
    /*
     * Test the useItem() method given that the Player's inventory 
     * is empty and verify the correct result is produced
     */
    public void testUseItemWithEmptyInventory()
    {
        String someItem = "dog bowl";
        
        Player player = new Player();

        Item returnedItem = player.useItem(someItem);
        
        assertNull(returnedItem);
    }
    
    @Test
    /*
     * Test the useItem() method when the specified item is not 
     * in the Player's inventory and verify that the correct 
     * results are produced
     */
    public void testUseItemWithItemNotInInventory()
    {
        String itemString1 = "Aloe Fresh Lotion";
        String itemString2 = "Jelly Beans";
        String itemString3 = "cats";
        
        when(mockItem1.getName()).thenReturn(itemString1);
        when(mockItem2.getName()).thenReturn(itemString2);
        
        Player player = new Player();
        player.addToInventory(mockItem1);
        player.addToInventory(mockItem2);
        
        Item returnedItem = player.useItem(itemString3);
        
        assertNull(returnedItem);
    }
    
    @Test
    /*
     * Test the useItem() method given that the Player has the 
     * specified item in their inventory and verify that the 
     * correct results are produced
     */
    public void testUseItemWithItemInInventory()
    {
        String itemString1 = "Aloe Fresh Lotion";
        String itemString2 = "Jelly Beans";
        
        when(mockItem1.getName()).thenReturn(itemString1);
        when(mockItem2.getName()).thenReturn(itemString2);
        
        Player player = new Player();
        player.addToInventory(mockItem1);
        player.addToInventory(mockItem2);
        
        //Finds item and should remove from inventory
        Item returnedItem = player.useItem(itemString2);
        
        assertNotNull(returnedItem);
        
        //Item should no longer be in inventory 
        returnedItem = player.useItem(itemString2);
        
        assertNull(returnedItem);
    }
    
}
