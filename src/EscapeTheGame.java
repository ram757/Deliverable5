import java.io.BufferedReader;
import java.io.FileReader;


public class EscapeTheGame
{
    
    public int runIntroduction(String name)
    {
        System.out.println("Insert Instructions here... and like... don't forget");
        return 0;
    }
    

    
    
    public int[] parseDimensionsFromString(String dimensions)
    {
        int[] toReturn = new int[2];
        String [] pieces = dimensions.split(";");
        toReturn[0] = Integer.parseInt(pieces[0]);
        toReturn[1] = Integer.parseInt(pieces[1]);
        return toReturn;
    }
    
    public Item parseItemFromString(String itemString)
    {
        if(itemString.equalsIgnoreCase("none"))
        {
            return null;
        }
        else
        {
            String[] pieces = itemString.split(";");
            return new Item(pieces[0], pieces[1], pieces[2]);
        }
    }
    
    public Trap parseTrapFromString(String trapString)
    {
        if(trapString.equalsIgnoreCase("none"))
        {
            return null;
        }
        else
        {
            String[] pieces = trapString.split(";");
            if(pieces[0].equalsIgnoreCase("dead"))
            {
                return new Trap(pieces[1]);
            }
            else
            {
                return new Trap(pieces[1], true);
            }
        }
    }

    
    public static void main(String[] args)
    {
        System.out.println("Insert title here...");
        
        EscapeTheGame escapeGame = new EscapeTheGame();
        
        escapeGame.runIntroduction("Bob");

        
    }
    
    
    public static String[] adjs = { "Small",  "Quaint", 
        "Shiny", "Magenta", "Funny", "Sad", "Fuchsia", "Beige", "Massive", "Refinanced", "Tight", "Loose",
        "Dead", "Smart", "Dumb", "Flat", "Bumpy", "Vivacious", 
        "Slim", "Bloodthirsty", "Beautiful", 
        "Flowery", "Purple", "Sandy", "Rough",
        "Perfect", "Heroic", "Minimalist", "Shoe-Losing", "Major", 
        "Wonderful", "Loving", "Fun-Loving",
        "High-Level", "Functional","Static", "Dynamic",
        "Fast", "Bulletproof", "Late", "Silly",
        "Salty", "Sour", 
        "Chair-Adjusting", "Brave", "Forgetful", "Chair-Sitting", "Mind-Blowing", "Crazy",
        "Funny", "Birdlike", "Bird-Brained", "Miniature", 
        "High-Strung", "Famous", "Light", "Dark", "Feral", "Hairy",
        "Leaky", "Criminal", "Sassy", "Frumpy", "Tiny", 
        "Prehistoric", "Metallic", "Sharp", "Historical", "Fierce", "Loud",
        "Lunar", "Bohemian", "Bored", "Suspicious", 
        "Flirtatious", "Street-Smart", "Forgetful",  
        "Tooth-Filled", "Ravenous", 
        "Well-Directed", "Well-Fed", "Well-Maintained", "Deep", "Shallow",
        "Victorian", "Formal", "Creamy", "Tangy", "Fresh", "Magical", "Mystical",
        "Secret", "Prophetic", "Immortal", "Far-Sighted",
        "Short-Sighted",  "Latin", "Nepalese",  "Medical",
        "Straightforward", "Literary", "Critical", "Backward", "Rabid", "Bombastic",
        "Smelly", "Wanton", "Confusing", "Cheesy",
        "Devious", "Pumpkin Spice", "Submerged", "Muscular",
        "Well-Organized", "Smooth", "Delicious", "Creamy", "Dry", 
        "Independent", "Free", "Cheap", "Diaphonous", "Tired",
        "Sultry", "Beguiling", "Long-Lived", "Repetitive",
        "Disgusting", "Swampy", "Dirty", "Muddy", "Clean", "Dry", "Wet",
        "Clear", "Transparent", "Glorious", "Sacrificial", "Electric", "Mechanical",
        "Automatic", "Rapid", "Nervous", "Calm", "Contemplative",
        "Cerebral", "Voracious", "Starving", "Full", "Killer", "Wicked", "Rational", "Real",
        "Homemade", "Cigar-Chomping", "Sinister", "Doubting",
        "Robotic", "Monosyllabic", "Maniacal", "Postmodern", "Prehistoric" };
    
    public static String[] snarkyRemarks = { "Do you even know proper English?",
        "Use the help command if you don't know how to use English.",
        "How hard is it: [ACTION] (NOUN)",
        "What?",
        "You're probably a middle aged man, you should understand directions by now.",
        "*Sigh* ERROR ERROR... I don't understand what you mean.",
        "This is a random message basically saying that you're a failure.",
        "Wellllllllllll, try again.",
        "Lol nice try.  Try again.",
        "Idiot.",
        "What do you mean?",
        "GAME OVER: Wrong command typed... Just kidding... try again."};
}
