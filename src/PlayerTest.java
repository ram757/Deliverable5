import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


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
    public void testPlayerConstructor()
    {
        Player player = new Player();
        
        assertTrue(player != null);
    }
    
    @Test
    public void testAddOneItemToInventory()
    {
        Player player = new Player();
        
        assertTrue(player.addToInventory(mockItem1));
    }
    
    @Test
    public void testAddMultipleItemToInventory()
    {
        Player player = new Player();
        
        assertTrue(player.addToInventory(mockItem1));
        assertTrue(player.addToInventory(mockItem2));
    }
    
    @Test
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
    public void testHasItemWithEmptyInventory()
    {
        String itemString1 = "Aloe Fresh Lotion";
        String itemString2 = "Jelly Beans";

        Player player = new Player();

        assertFalse(player.hasItem(itemString1));
        assertFalse(player.hasItem(itemString2));
    }
    
    @Test
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
    
    

}
