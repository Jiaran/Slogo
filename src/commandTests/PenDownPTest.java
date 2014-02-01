package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import commands.QueryCommands.PenDownP;

public class PenDownPTest extends SuperCommandTest{
	private PenDownP p;

	public PenDownPTest() {
		p = new PenDownP(testState);
	}

	@Test
	public void testDoCommand() {
		testState.setPenIsDown(true);
		assertEquals(1, p.doCommand(), 0);
		assertEquals(true, testState.getPenIsDown());
		testState.setPenIsDown(false);
		assertEquals(0, p.doCommand(), 0);
		assertEquals(false, testState.getPenIsDown());
		
	}

	@Test
	public void testPenDownP() {
		assertNotNull(p);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, p.getArgNum());
	}
}

