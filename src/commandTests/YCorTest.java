package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import commands.QueryCommands.YCor;

public class YCorTest extends SuperCommandTest {
	private YCor yc;

	public YCorTest() {
		yc = new YCor(testState);
	}

	@Test
	public void testDoCommand() {
		double xPos = 10;
		double yPos = 5;
		testState.setXY(xPos, yPos);
		assertEquals(yPos, yc.doCommand(), 0);
		assertEquals(yPos, testState.getY(), 0);
		
		yPos = 10;
		testState.setXY(xPos, yPos);
		assertEquals(yPos, yc.doCommand(), 0);
		assertEquals(yPos, testState.getY(), 0);
		
	}

	@Test
	public void testYCor() {
		assertNotNull(yc);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, yc.getArgNum());
	}
}