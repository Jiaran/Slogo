package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.BooleanCommands.And;

public class AndTest {
	private And a;
	
	public AndTest() {
		a = new And(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(a);
	}

	@Test
	public void testGetResult() {
		a = new And(new State(new EnvironmentVariables()));
		a.addArg(new Arg(7));
		a.addArg(new Arg(2));
		assertEquals(1, a.doCommand(), 0);
		
		a = new And(new State(new EnvironmentVariables()));
		a.addArg(new Arg(0));
		a.addArg(new Arg(7));
		assertEquals(0, a.doCommand(), 0);
		
		a = new And(new State(new EnvironmentVariables()));
		a.addArg(new Arg(-1));
		a.addArg(new Arg(1));
		assertEquals(0, a.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, a.getArgNum());
	}
}
