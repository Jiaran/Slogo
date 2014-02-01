package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.ActionCommands.SetXY;
import model.Arg;

public class SetXYTest extends SuperCommandTest {
	private SetXY mySetXY;
	private double xPos;
	private double yPos;

	public SetXYTest() {
		mySetXY = new SetXY(testState);
	}

	@Test
	public void testDoCommand() {

		xPos = 3;
		yPos = 4;
		double totalDist = 5;
		mySetXY.addArg(new Arg(xPos));
		mySetXY.addArg(new Arg(yPos));
		assertEquals(totalDist, mySetXY.doCommand(), 0);
		assertEquals(xPos,testState.getX(), 0);
		assertEquals(yPos,testState.getY(), 0);
		
	}

	@Test
	public void testClearScreen() {
		assertNotNull(mySetXY);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, mySetXY.getArgNum());
	}
}
