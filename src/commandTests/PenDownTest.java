package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import commands.StateCommands.PenDown;

public class PenDownTest extends SuperCommandTest{
	private PenDown myPenDown;
	
	public PenDownTest() {
		myPenDown = new PenDown(testState);
	}

	@Test
	public void testDoCommand() {
		testState.setPenIsDown(false);
		boolean startPen = testState.getPenIsDown();
		
		assertEquals(1, myPenDown.doCommand(), 0);
		assertEquals(!startPen, testState.getPenIsDown());
		
	}

	@Test
	public void testPenDown() {
		assertNotNull(myPenDown);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, myPenDown.getArgNum());
	}
}