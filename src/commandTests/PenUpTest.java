package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import commands.StateCommands.PenUp;

public class PenUpTest extends SuperCommandTest {
	private PenUp myPenUp;
	
	
	public PenUpTest() {
		myPenUp = new PenUp(testState);
	}

	@Test
	public void testDoCommand() {
		assertEquals(0, myPenUp.doCommand(), 0);
		assertEquals(false, testState.getPenIsDown());
	}

	@Test
	public void testPenUp() {
		assertNotNull(myPenUp);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, myPenUp.getArgNum());
	}
}