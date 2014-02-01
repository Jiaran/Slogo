package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import commands.ActionCommands.Home;

public class HomeTest extends SuperCommandTest {
	private Home myH;
	
	public HomeTest(){
		myH = new Home(testState);
	}

	@Test
	public void testDoCommand() {
		double distanceTotal = 50;
		double distance1 = 30;
		double distance2 = 40;
		testState.moveForward(distance1);
		testState.addAngle(90);
		testState.moveForward(distance2);
		
		assertEquals(distanceTotal, myH.doCommand(), 0);
		assertEquals(0, testState.getX(), 0);
		assertEquals(0, testState.getY(), 0);
		
	}

	@Test
	public void testClearScreen() {
		assertNotNull(myH);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, myH.getArgNum());
	}
}
