package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Turtle;

import org.junit.Test;

import commands.ActionCommands.ClearScreen;

public class ClearScreenTest extends SuperCommandTest {
	private ClearScreen myCS;
	
	public ClearScreenTest() {
		myCS = new ClearScreen(testState);
	}

	@Test
	public void testDoCommand() {
		Turtle testTurtle = testState.getTurtles().get(1);
		double distanceTotal = 50;
		double distance1 = 30;
		double distance2 = 40;
		testState.moveForward(distance1);
		testState.addAngle(90);
		testState.moveForward(distance2);
			
		assertEquals(testTurtle.getTrails().isEmpty(),false);
		assertEquals(distanceTotal, myCS.doCommand(), 0);
		assertEquals(testTurtle.getTrails().isEmpty(),true);
	}

	@Test
	public void testClearScreen() {
		assertNotNull(myCS);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, myCS.getArgNum());
	}
}
