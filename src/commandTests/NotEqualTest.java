package commandTests;

import static org.junit.Assert.*;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.BooleanCommands.NotEqual;

public class NotEqualTest {
	private NotEqual n;
	
	public NotEqualTest() {
		n = new NotEqual(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(n);
	}

	@Test
	public void testGetResult() {
		n = new NotEqual(new State(new EnvironmentVariables()));
		n.addArg(new Arg(7));
		n.addArg(new Arg(7));
		assertEquals(0, n.doCommand(), 0);
		
		n = new NotEqual(new State(new EnvironmentVariables()));
		n.addArg(new Arg(0));
		n.addArg(new Arg(0));
		assertEquals(0, n.doCommand(), 0);
		
		n = new NotEqual(new State(new EnvironmentVariables()));
		n.addArg(new Arg(-4));
		n.addArg(new Arg(0));
		assertEquals(1, n.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, n.getArgNum());
	}
}
