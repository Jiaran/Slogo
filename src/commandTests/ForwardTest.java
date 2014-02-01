package commandTests;

import static org.junit.Assert.*;
import model.Arg;
import org.junit.Test;
import commands.ActionCommands.Forward;

public class ForwardTest extends SuperCommandTest {
	private Forward f;
	private int distance;

	public ForwardTest() {
		f = new Forward(testState);
	}

	@Test
	public void testDoCommand() {
		double startX = testState.getX();
		double startY = testState.getY();
		distance = 45;
		f.addArg(new Arg(distance));
		assertEquals(distance, f.doCommand(), 0);
		assertEquals(startX+distance, testState.getX(), 0);
		assertEquals(startY, testState.getY(), 0);
	}

	@Test
	public void testForward() {
		assertNotNull(f);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, f.getArgNum());
	}
}
