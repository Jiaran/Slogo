package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import commands.ActionCommands.HideTurtle;

public class HideTurtleTest extends SuperCommandTest {
	private HideTurtle myHT;

	public HideTurtleTest() {
		myHT = new HideTurtle(testState);
	}

	@Test
	public void testDoCommand() {
		boolean startingVisibility = testState.getVisibility();
		
		assertEquals(0, myHT.doCommand(), 0);
		assertEquals(!startingVisibility, testState.getVisibility());
	}

	@Test
	public void testHideTurtle() {
		assertNotNull(myHT);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, myHT.getArgNum());
	}
}
