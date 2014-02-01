package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Remainder;

public class RemainderTest {
	private Remainder r;
	private double exampleRemainder;
	
	public RemainderTest() {
		r = new Remainder(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(r);
	}

	@Test
	public void testGetResult() {
		r = new Remainder(new State(new EnvironmentVariables()));
		r.addArg(new Arg(7));
		r.addArg(new Arg(2));
		exampleRemainder = 1;
		assertEquals(exampleRemainder, r.doCommand(), 0);
		
		r = new Remainder(new State(new EnvironmentVariables()));
		r.addArg(new Arg(0));
		r.addArg(new Arg(1));
		exampleRemainder = 0;
		assertEquals(exampleRemainder, r.doCommand(), 0);
		
		r = new Remainder(new State(new EnvironmentVariables()));
		r.addArg(new Arg(8));
		r.addArg(new Arg(2));
		exampleRemainder = 0;
		assertEquals(exampleRemainder, r.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, r.getArgNum());
	}
}
