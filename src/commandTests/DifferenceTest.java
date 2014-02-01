package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;
import org.junit.Test;
import commands.EvalCommands.Difference;

public class DifferenceTest {
	private Difference d;
	private double exampleDifference;

	public DifferenceTest() {
		d = new Difference(new State(new EnvironmentVariables()));
	}

	@Test
	public void testDifference() {
		assertNotNull(d);
	}

	@Test
	public void testGetResult() {
		d = new Difference(new State(new EnvironmentVariables()));
		d.addArg(new Arg(7));
		d.addArg(new Arg(2));
		exampleDifference = 5;
		assertEquals(exampleDifference, d.doCommand(), 0);
		
		d = new Difference(new State(new EnvironmentVariables()));
		d.addArg(new Arg(9));
		d.addArg(new Arg(11));
		exampleDifference = -2;
		assertEquals(exampleDifference, d.doCommand(), 0);
		
		d = new Difference(new State(new EnvironmentVariables()));
		d.addArg(new Arg(5));
		d.addArg(new Arg(5));
		exampleDifference = 0;
		assertEquals(exampleDifference, d.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, d.getArgNum());
	}
}
