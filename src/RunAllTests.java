
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EscapeTheGameTest.class, ItemTest.class, TrapTest.class, 
                RoomTest.class, HouseTest.class, PlayerTest.class, Game.class})

public class RunAllTests
{

}
