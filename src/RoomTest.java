import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import org.mockito.*;
import org.junit.Before;

/* RoomTest Class
 *     Test cases used to develop the Room Class through TDD
 */
public class RoomTest
{
    @Mock
    Trap mockTrap = Mockito.mock(Trap.class);
    Item mockItem = Mockito.mock(Item.class);
    String description;
    String peekDescription;
    String itemUsable;
    
    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(mockTrap);
        MockitoAnnotations.initMocks(mockItem);
        
        description = "You are in a room full of clowns with cat ears.";
        peekDescription = "Listening at the door, you hear cat sounds.";
        itemUsable = "peanut butter";
    }
    
    @Test
    /*
     * Test the constructor produces Room object given no trap
     */
    public void testConstructorWithNoItemTrap()
    {
        Room room = new Room(description, peekDescription);
        
        assertTrue(room != null);
    }
    
    @Test
    /*
     * Test the constructor produces Room object given a trap
     */
    public void testConstructorWithItemTrap()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        assertTrue(room != null);
    }
    
    @Test
    /*
     * Test the hasItem() method and verify that the expected response is returned
     */
    public void testRoomHasItem()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        boolean expectedValue = true;
        boolean returnedValue = room.hasItem();
        
        assertEquals(expectedValue, returnedValue);
    }
    
    @Test
    /*
     * Test the hasTrap() method and verify that the expected response is returned
     */
    public void testRoomHasTrap()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        boolean expectedValue = true;
        boolean returnedValue = room.hasTrap();
        
        assertEquals(expectedValue, returnedValue);
    }
    
    @Test
    /*
     * Test the getItem() method given that the method is only called once
     * and verify that the correct output is produced
     */
    public void testRoomGetExistingItemOnce()
    {
        String itemString = "cats";
        when(mockItem.toString()).thenReturn(itemString);
        
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        Item returnedItem = room.getItem();
        assertEquals(mockItem, returnedItem);
        assertEquals(itemString, returnedItem.toString());
    }
    
    @Test
    /*
     * Test the getItem() method given that the method is called a second time
     * and verify that the item is correctly "removed" from the Room
     */
    public void testRoomGetExistingItemTwice()
    {
        String itemString = "cats";
        when(mockItem.toString()).thenReturn(itemString);
        
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        Item returnedItem = room.getItem();
        assertEquals(mockItem, returnedItem);

        returnedItem = room.getItem();
        assertTrue(returnedItem == null);
    }
    
    @Test
    /*
     * Test getItemUsable() method given that there is an itemUsable
     */
    public void testRoomGetItemUsable()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        String expectedString = itemUsable;
        String returnedString = room.getItemUsable();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test the getTrap() method given that the Room has a trap and verify 
     * the correct output
     */
    public void testRoomWithTrapGetTrap()
    {
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);

        assertEquals(mockTrap, room.getTrap());
    }
    
    @Test
    /*
     * Test the getTrap() method given that the Room does not have a trap 
     * and verify the correct output
     */
    public void testRoomWithoutTrapGetTrap()
    {
        Room room = new Room(description, peekDescription);

        assertEquals(null, room.getTrap());
    }
    
    @Test
    /*
     * Test the getRoomInfo() method and verify it returns the description 
     * of the Room
     */
    public void testRoomGetRoomInfo()
    {
        Room room = new Room(description, peekDescription);
        
        String expectedString = description;
        String returnedString = room.getRoomInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test the peekInRoom() method and verify that it produces the 
     * "peek" information of that room
     */
    public void testRoomPeekInRoom()
    {
        Room room = new Room(description, peekDescription);
        
        String expectedString = peekDescription;
        String returnedString = room.peekInRoom();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test the toString() method given that the Room has no trap and 
     * no item in it and verify that it produces the expected response
     */
    public void testRoomToStringWithoutItemAndTrap()
    {
        Room room = new Room(description, peekDescription);
        
        String expectedString = ("Room:\n\tDescription: " + description);
        
        String returnedString = room.toString();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test the toString() method given that the Room has an Item and 
     * a Trap and verify that the correct response is produced
     */
    public void testRoomToStringWithItemAndTrap()
    {
        String trapString = "Eaten by cats";
        String itemString = "unicycle";
        
        when(mockItem.toString()).thenReturn(itemString);
        when(mockTrap.toString()).thenReturn(trapString);
        
        Room room = new Room(description, peekDescription, mockItem, mockTrap, itemUsable);
        
        String expectedString = ("Room:\n\tDescription: " +
                                description +
                                "\n\tTrap: " + trapString +
                                "\n\tItem: " + itemString +
                                "\n\tItem Usable: " + itemUsable);
        
        String returnedString = room.toString();
        
        assertEquals(expectedString, returnedString);
    }

}
