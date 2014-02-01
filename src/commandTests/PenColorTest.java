package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import commands.QueryCommands.PenColor;

public class PenColorTest extends SuperCommandTest {
	private PenColor h;

	public PenColorTest() {
		h = new PenColor(testState);
	}

	@Test
	public void testDoCommand() {
		int testIndex = 5;
		testState.setPenColor(testIndex);
		
		assertEquals(testIndex, h.doCommand(), 0);
		assertEquals(testIndex, testState.getColorIndex(), 0);
	}

	@Test
	public void testPenColor() {
		assertNotNull(h);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, h.getArgNum());
	}
}
