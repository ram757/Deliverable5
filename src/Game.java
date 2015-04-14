import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game
{
    private Player _player = null;
    private House _house = null;
    private Pattern pattern = Pattern.compile("\\s*([a-z]+)\\s*([a-z]*)");
    private Scanner console = new Scanner(System.in);
    
    public Game(Player p, House h)
    {
        _player = p;
        _house = h;
    }
 
    
    public int move(String direction)
    {
        boolean moveResponse = false;
        
        if(direction.equals("north"))
        {
            moveResponse = _house.moveNorth();
        }
        else if(direction.equals("south"))
        {
            moveResponse = _house.moveSouth();
        }
        else if(direction.equals("east"))
        {
            moveResponse = _house.moveEast();
        }
        else if(direction.equals("west"))
        {
            moveResponse =_house.moveWest();
        }
        else
        {
            System.out.println("Move where?");
            return -1;
        }
        
        if(!moveResponse)
        {
            System.out.println("You walked into a wall like an idiot...");
            return -1;
        }
        else
        {
            return 1;
        }
    }

    
}