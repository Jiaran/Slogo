package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import org.junit.Test;
import commands.ActionCommands.Left;

public class LeftTest extends SuperCommandTest {
	private Left myLeft;
	private double setAngle;

	public LeftTest() {
		myLeft = new Left(testState);
	}

	@Test
	public void testDoCommand() {

		double startingAngle = testState.getAngle();
		setAngle = 50;

		myLeft.addArg(new Arg(setAngle));
		assertEquals(setAngle, myLeft.doCommand(), 0);
		assertEquals(startingAngle-setAngle, testState.getAngle(), 0);
	}

	@Test
	public void testLeft() {
		assertNotNull(myLeft);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, myLeft.getArgNum());
	}
}

