package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import commands.QueryCommands.XCor;

public class XCorTest extends SuperCommandTest {
	private XCor xc;

	public XCorTest() {
		xc = new XCor(testState);
	}

	@Test
	public void testDoCommand() {
		double xPos = 10;
		double yPos = 5;
		testState.setXY(xPos, yPos);
		assertEquals(xPos, xc.doCommand(), 0);
		assertEquals(xPos, testState.getX(), 0);
		
		xPos = 10;
		testState.setXY(xPos, yPos);
		assertEquals(xPos, xc.doCommand(), 0);
		assertEquals(xPos, testState.getX(), 0);
		
	}

	@Test
	public void testXCor() {
		assertNotNull(xc);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, xc.getArgNum());
	}
}
