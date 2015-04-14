import static org.junit.Assert.*;

import org.junit.Test;


public class EscapeTheGameTest
{

    @Test
    /*
     * Test that running the introduction method will work
     * properly
     */
    public void testRunIntroduction()
    {
        EscapeTheGame game = new EscapeTheGame();
        assertEquals(0, game.runIntroduction("Name"));
    }

    @Test
    /*
     * Test that dimensions can be parsed from String when
     * dimensions are parsable
     */
    public void testParseDimensionsFromString()
    {
        int row = 5;
        int col = 9;
        
        EscapeTheGame escapeGame = new EscapeTheGame();
        
        String dimensionString = (row + ";" + col);
        int[] dimensions = escapeGame.parseDimensionsFromString(dimensionString);
        
        assertTrue(dimensions[0] == row);
        assertTrue(dimensions[1] == col);
    }
    
    @Test
    /*
     * Test that parsing Item from String returns an Item when 
     * Item is parsable
     */
    public void testParseItemFromStringWithItem()
    {
        String itemAsString = "key;This is a black key; Using key unlocks door";
        
        EscapeTheGame escapeGame = new EscapeTheGame();
        
        Item item = escapeGame.parseItemFromString(itemAsString);
        
        assertNotNull(item);
    }
    
    @Test
    /*
     * Test that parsing Item from String returns null when 
     * item is not parsable
     */
    public void testParseItemFromStringWithoutItem()
    {
        String itemAsString = "none";
        
        EscapeTheGame escapeGame = new EscapeTheGame();
        
        Item item = escapeGame.parseItemFromString(itemAsString);
        
        assertNull(item);
    }
    
    @Test
    /*
     * Test that parsing Trap from String returns a Trap when 
     * trap is parsable
     */
    public void testParseTrapFromStringWithTrap()
    {
        String trapAsString = "dead;You encounter a hoard of sorority chicks.";
        
        EscapeTheGame escapeGame = new EscapeTheGame();
        
        Trap trap = escapeGame.parseTrapFromString(trapAsString);
        
        assertNotNull(trap);
    }
    
    @Test
    /*
     * Test that parsing Trap from String returns Null when 
     * there is no Trap parsable
     */
    public void testParseTrapFromStringWithoutTrap()
    {
        String trapAsString = "none";
        
        EscapeTheGame escapeGame = new EscapeTheGame();
        
        Trap trap = escapeGame.parseTrapFromString(trapAsString);
        
        assertNull(trap);
    }
    
}
