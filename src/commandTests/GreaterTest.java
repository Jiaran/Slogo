package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.BooleanCommands.Greater;

public class GreaterTest {
	private Greater g;
	
	public GreaterTest() {
		g = new Greater(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(g);
	}

	@Test
	public void testGetResult() {
		g = new Greater(new State(new EnvironmentVariables()));
		g.addArg(new Arg(7));
		g.addArg(new Arg(2));
		assertEquals(1, g.doCommand(), 0);
		
		g = new Greater(new State(new EnvironmentVariables()));
		g.addArg(new Arg(0));
		g.addArg(new Arg(7));
		assertEquals(0, g.doCommand(), 0);
		
		g = new Greater(new State(new EnvironmentVariables()));
		g.addArg(new Arg(-1));
		g.addArg(new Arg(-1));
		assertEquals(0, g.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, g.getArgNum());
	}
}

