package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Minus;

public class MinusTest {
	private Minus m;
	private double exampleMinus;
	
	public MinusTest() {
		m = new Minus(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(m);
	}

	@Test
	public void testGetResult() {
		m = new Minus(new State(new EnvironmentVariables()));
		m.addArg(new Arg(2));
		exampleMinus = -2;
		assertEquals(exampleMinus, m.doCommand(), 0);
		
		m = new Minus(new State(new EnvironmentVariables()));
		m.addArg(new Arg(0));
		exampleMinus = 0;
		assertEquals(exampleMinus, m.doCommand(), 0);
		
		m = new Minus(new State(new EnvironmentVariables()));
		m.addArg(new Arg(-3));
		exampleMinus = 3;
		assertEquals(exampleMinus, m.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, m.getArgNum());
	}
}

