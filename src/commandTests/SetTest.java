package commandTests;

import commands.CreationCommands.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

public class SetTest {
	private Set s;
	private State testState;
	
	public SetTest() {
		testState = new State(new EnvironmentVariables());
		s = new Set(testState);
	}

	@Test
	public void testSum() {
		assertNotNull(s);
	}

	@Test
	public void testGetResult() {
		s.addArg(new Arg("a"));
		s.addArg(new Arg(7));
		assertEquals(7, s.doCommand(), 0);
		assertEquals(testState.getEnvVarRef().getVariable("a"), 7, 0);
		
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, s.getArgNum());
	}
}