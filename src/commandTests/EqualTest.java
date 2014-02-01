package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.BooleanCommands.Equal;

public class EqualTest {
	private Equal l;
	
	public EqualTest() {
		l = new Equal(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(l);
	}

	@Test
	public void testGetResult() {
		l = new Equal(new State(new EnvironmentVariables()));
		l.addArg(new Arg(7));
		l.addArg(new Arg(2));
		assertEquals(0, l.doCommand(), 0);
		
		l = new Equal(new State(new EnvironmentVariables()));
		l.addArg(new Arg(0));
		l.addArg(new Arg(7));
		assertEquals(0, l.doCommand(), 0);
		
		l = new Equal(new State(new EnvironmentVariables()));
		l.addArg(new Arg(-1));
		l.addArg(new Arg(-1));
		assertEquals(1, l.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, l.getArgNum());
	}
}

