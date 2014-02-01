package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.BooleanCommands.Not;

public class NotTest {
	private Not n;
	
	public NotTest() {
		n = new Not(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(n);
	}

	@Test
	public void testGetResult() {
		n = new Not(new State(new EnvironmentVariables()));
		n.addArg(new Arg(7));
		assertEquals(0, n.doCommand(), 0);
		
		n = new Not(new State(new EnvironmentVariables()));
		n.addArg(new Arg(0));
		assertEquals(1, n.doCommand(), 0);
		
		n = new Not(new State(new EnvironmentVariables()));
		n.addArg(new Arg(-4));
		assertEquals(0, n.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, n.getArgNum());
	}
}
