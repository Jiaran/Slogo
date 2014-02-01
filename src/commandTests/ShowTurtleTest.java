package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.ActionCommands.ShowTurtle;

public class ShowTurtleTest extends SuperCommandTest {
	private ShowTurtle myST;

	public ShowTurtleTest() {
		myST = new ShowTurtle(testState);
	}

	@Test
	public void testDoCommand() {
		testState.setVisibility(false);
		
		assertEquals(1, myST.doCommand(), 0);
		assertEquals(true, testState.getVisibility());
	}

	@Test
	public void testShowTurtle() {
		assertNotNull(myST);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, myST.getArgNum());
	}
}