package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;
import model.Arg;
import commands.ActionCommands.SetHeading;

public class SetHeadingTest extends SuperCommandTest {
	private SetHeading mySetH;
	private double setAngle;
	
	public SetHeadingTest() {
		mySetH = new SetHeading(testState);
	}

	@Test
	public void testDoCommand() {
	
		setAngle = 50;
		
		mySetH.addArg(new Arg(setAngle));
		assertEquals(setAngle, mySetH.doCommand(), 0);
		assertEquals(setAngle, testState.getAngle(), 0);
	}

	@Test
	public void testClearScreen() {
		assertNotNull(mySetH);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, mySetH.getArgNum());
	}
}
