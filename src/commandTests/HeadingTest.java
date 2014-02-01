package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;

import org.junit.Test;

import commands.QueryCommands.Heading;

public class HeadingTest extends SuperCommandTest{
	private Heading h;

	public HeadingTest() {
		h = new Heading(testState);
	}

	@Test
	public void testDoCommand() {
		double testAngle = 50;
		testState.addAngle(testAngle);
		assertEquals(testAngle, h.doCommand(), 0);
	}

	@Test
	public void testHeading() {
		assertNotNull(h);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, h.getArgNum());
	}
}

