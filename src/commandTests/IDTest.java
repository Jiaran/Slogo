package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import commands.QueryCommands.ID;

public class IDTest extends SuperCommandTest {
	private ID i;

	public IDTest() {
		i = new ID(testState);
	}

	@Test
	public void testDoCommand() {
		int testID = 5;
		testState.addTurtle(testID);
		
		assertEquals(testID, i.doCommand(), 0);
		assertEquals(testID, testState.getLastActiveTurtleID(), 0);
		
	}

	@Test
	public void testID() {
		assertNotNull(i);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, i.getArgNum());
	}
}

