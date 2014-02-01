package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Pow;

public class PowTest {
	private Pow p;
	private double examplePow;

	public PowTest() {
		p = new Pow(new State(new EnvironmentVariables()));
	}

	@Test
	public void testPow() {
		assertNotNull(p);
	}

	@Test
	public void testGetResult() {
		p = new Pow(new State(new EnvironmentVariables()));
		p.addArg(new Arg(5));
		p.addArg(new Arg(3));
		examplePow = 125;
		assertEquals(examplePow, p.doCommand(), 0);
		
		p = new Pow(new State(new EnvironmentVariables()));
		p.addArg(new Arg(2));
		p.addArg(new Arg(-1));
		examplePow = 0.5;
		assertEquals(examplePow, p.doCommand(), 0);
		
		p = new Pow(new State(new EnvironmentVariables()));
		p.addArg(new Arg(8));
		p.addArg(new Arg(0));
		examplePow = 1;
		assertEquals(examplePow, p.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, p.getArgNum());
	}
}
