package commandTests;

import static org.junit.Assert.*;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.BooleanCommands.Or;

public class OrTest {
	private Or o;
	
	public OrTest() {
		o = new Or(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(o);
	}

	@Test
	public void testGetResult() {
		o = new Or(new State(new EnvironmentVariables()));
		o.addArg(new Arg(7));
		o.addArg(new Arg(7));
		assertEquals(1, o.doCommand(), 0);
		
		o = new Or(new State(new EnvironmentVariables()));
		o.addArg(new Arg(0));
		o.addArg(new Arg(7));
		assertEquals(1, o.doCommand(), 0);
		
		o = new Or(new State(new EnvironmentVariables()));
		o.addArg(new Arg(0));
		o.addArg(new Arg(0));
		assertEquals(0, o.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, o.getArgNum());
	}
}