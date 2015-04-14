import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


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
    public void testConstructorWithDescription()
    {
        Trap trap = new Trap(description);
        assertTrue(trap != null);
    }
    
    @Test
    public void testConstructorWithDescAndEscape()
    {
        boolean escape = true;
        Trap trap = new Trap(description, escape);
        assertTrue(trap != null);
    }
    
    @Test
    public void testGetTrapInfo()
    {
        Trap trap = new Trap(description);
        String expectedString = description;
        String returnedString = trap.getTrapInfo();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    public void testCanEscape()
    {
        boolean expectedReturn = true;
        Trap trap = new Trap(description, expectedReturn);
        boolean returnedValue = trap.canEscape();
        
        assertTrue(expectedReturn == returnedValue);
    }
    
    @Test
    public void testEscapableTrapToString()
    {
        Trap trap = new Trap(description, true);
        String expectedString = "ESCAPE: " + description;
        String returnedString = trap.toString();
        
        assertEquals(expectedString, returnedString);
    }
    
    @Test
    public void testNotEscapableTrapToString()
    {
        Trap trap = new Trap(description, false);
        String expectedString = "NO_ESCAPE: " + description;
        String returnedString = trap.toString();
        
        assertEquals(expectedString, returnedString);
    }

}
