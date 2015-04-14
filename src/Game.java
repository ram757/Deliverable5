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
    
    public String peek(String direction)
    {
        String peekResponse = null;
        
        if(direction.equals("north"))
        {
            peekResponse = _house.peekNorth();
        }
        else if(direction.equals("south"))
        {
            peekResponse = _house.peekSouth();
        }
        else if(direction.equals("east"))
        {
            peekResponse = _house.peekEast();
        }
        else if(direction.equals("west"))
        {
            peekResponse =_house.peekWest();
        }
        else
        {
            Random r = new Random();
            
            peekResponse = ("You see a wall that is disturbingly " + EscapeTheGame.adjs[r.nextInt(EscapeTheGame.adjs.length)]);
        }
        
        return peekResponse;        
    }
    
    public int look()
    {
        Item item = _house.lookInCurrentRoom();
        if(item != null)
        {
            _player.addToInventory(item);
            System.out.println("You found "+ item.getName());
            return 3;
        }
        else
        {
            System.out.println("You found nothing helpful.");
            return -3;
        }
    }
    
    public int use(String itemName)
    {
        if(_player.hasItem(itemName))
        {
            if(_house.canUseItemHere(itemName))
            {
                Item itemUsed = _player.useItem(itemName);
                
                System.out.println(itemUsed.useItem());
                return 4;
            }
            else
            {
                System.out.println("You find no meaningful way to use that here...");
                return -4;
            }
        }
        else
        {
            System.out.println("You have no such item...");
            return -4;
        }
    }
    
    
}
