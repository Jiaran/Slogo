package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Cos;

public class CosTest {
	private Cos c;
	private double exampleCos;
	
	public CosTest() {
		c = new Cos(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(c);
	}

	@Test
	public void testGetResult() {
		c = new Cos(new State(new EnvironmentVariables()));
		c.addArg(new Arg(90));
		exampleCos = 0;
		assertEquals(exampleCos, c.doCommand(), 0.1);
		
		c = new Cos(new State(new EnvironmentVariables()));
		c.addArg(new Arg(0));
		exampleCos = 1;
		assertEquals(exampleCos, c.doCommand(), 0.1);
		
		c = new Cos(new State(new EnvironmentVariables()));
		c.addArg(new Arg(60));
		exampleCos = 0.5;
		assertEquals(exampleCos, c.doCommand(), 0.1);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, c.getArgNum());
	}
}

