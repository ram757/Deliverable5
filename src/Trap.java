
public class Trap
{
    private String description = null;
    private boolean canEscape = false;
    
    public Trap(String desc)
    {
        description = desc;
        canEscape = false;
    }
    
    public Trap(String desc, boolean canSurvive)
    {
        description = desc;
        canEscape = canSurvive;
    }
    
    public String getTrapInfo()
    {
        return description;
    }
    
    public boolean canEscape()
    {
        return canEscape;
    }
    
    public String toString()
    {
        if(canEscape)
        {
            return ("ESCAPE: " + description);
        }
        else
        {
            return ("NO_ESCAPE: " + description);
        }
    }
    
}
