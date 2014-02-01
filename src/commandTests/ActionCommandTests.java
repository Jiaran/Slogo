package commandTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BackTest.class, ClearScreenTest.class, ForwardTest.class,
		HideTurtleTest.class, HomeTest.class, LeftTest.class,
		PenDownTest.class, PenUpTest.class, RightTest.class,
		SetHeadingTest.class, SetXYTest.class, ShowTurtleTest.class,
		TowardsTest.class })
// This is using JUnit 4... not sure if I like it yet.
public class ActionCommandTests {

}
