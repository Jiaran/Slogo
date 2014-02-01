package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import org.junit.Test;
import commands.ActionCommands.Right;

public class RightTest extends SuperCommandTest {
	private Right myR;
	private double setAngle;
	
	
	public RightTest() {
		myR = new Right(testState);
	}

	@Test
	public void testDoCommand() {
		double startingAngle = testState.getAngle();
		setAngle = 50;

		myR.addArg(new Arg(setAngle));
		assertEquals(setAngle, myR.doCommand(), 0);
		assertEquals(startingAngle+setAngle, testState.getAngle(), 0);
	}

	@Test
	public void testRight() {
		assertNotNull(myR);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, myR.getArgNum());
	}
}
