package commandTests;

import static org.junit.Assert.*;
import model.Arg;
import org.junit.Test;

import commands.ActionCommands.Back;

public class BackTest extends SuperCommandTest {
	private Back b;
	private int distance;
	
	public BackTest() {
		b = new Back(testState);
	}

	@Test
	public void testDoCommand() {
		double startX = testState.getX();
		double startY = testState.getY();
		distance = 35;
		b.addArg(new Arg(distance));
		assertEquals(distance, b.doCommand(), 0);
		assertEquals(startX-distance, testState.getX(), 0);
		assertEquals(startY, testState.getY(), 0);
	}

	@Test
	public void testBack() {
		assertNotNull(b);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, b.getArgNum());
	}
}

