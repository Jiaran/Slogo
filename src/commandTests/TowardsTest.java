package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.ActionCommands.Towards;
import model.Arg;

public class TowardsTest extends SuperCommandTest{
	private Towards myTowards;
	private double myXTowards;
	private double myYTowards;

	public TowardsTest() {
		myTowards = new Towards(testState);
	}

	@Test
	public void testDoCommand() {
		myXTowards = 5;
		myYTowards = 10;
		double finalAngle = -63;
		
		myTowards.addArg(new Arg(myXTowards));
		myTowards.addArg(new Arg(myYTowards));
		assertEquals(finalAngle, myTowards.doCommand(), 1);
		assertEquals(finalAngle, testState.getAngle(), 1);
	}

	@Test
	public void testTowards() {
		assertNotNull(myTowards);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, myTowards.getArgNum());
	}
}
