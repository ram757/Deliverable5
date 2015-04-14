import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/* TrapTest Class
 *     Test cases used to develop the Test Class through TDD
 */
public class TrapTest
{
    String description;
    boolean canEscape;

    @Before
    public void setUp() throws Exception
    {
        description = "You have been eatin by a velociraptor.";
    }
    
    @Test
    /*
     * Test that constructor works just given a description
     */
    public void testConstructorWithDescription()
    {
        Trap trap = new Trap(description);
        assertTrue(trap != null);
    }
    
    @Test
    /*
     * Test that constructor works with description and escape
     */
    public void testConstructorWithDescAndEscape()
    {
        boolean escape = true;
        Trap trap = new Trap(description, escape);
        assertTrue(trap != null);
    }
    
    @Test
    /*
     * Test getTrapInfo() method and verify that it produces the 
     * correct response
     */
    public void testGetTrapInfo()
    {
        Trap trap = new Trap(description);
        String expectedString = description;
        String returnedString = trap.getTrapInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test canEscape() method and verify that it produces the 
     * correct response
     */
    public void testCanEscape()
    {
        boolean expectedReturn = true;
        Trap trap = new Trap(description, expectedReturn);
        boolean returnedValue = trap.canEscape();
        
        assertTrue(expectedReturn == returnedValue);
    }
    
    @Test
    /*
     * Test an escapable trap's toString() method and verify the 
     * correct response is produced
     */
    public void testEscapableTrapToString()
    {
        Trap trap = new Trap(description, true);
        String expectedString = "ESCAPE: " + description;
        String returnedString = trap.toString();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    /*
     * Test a NOT escapable trap's toString() method and verify the 
     * correct response is produced
     */
    public void testNotEscapableTrapToString()
    {
        Trap trap = new Trap(description, false);
        String expectedString = "NO_ESCAPE: " + description;
        String returnedString = trap.toString();
        
        assertEquals(expectedString, returnedString);
    }

}
