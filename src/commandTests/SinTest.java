package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Sin;

public class SinTest {
	private Sin s;
	private double exampleSin;
	
	public SinTest() {
		s = new Sin(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(s);
	}

	@Test
	public void testGetResult() {
		s = new Sin(new State(new EnvironmentVariables()));
		s.addArg(new Arg(90));
		exampleSin = 1;
		assertEquals(exampleSin, s.doCommand(), 0.1);
		
		s = new Sin(new State(new EnvironmentVariables()));
		s.addArg(new Arg(0));
		exampleSin = 0;
		assertEquals(exampleSin, s.doCommand(), 0.1);
		
		s = new Sin(new State(new EnvironmentVariables()));
		s.addArg(new Arg(30));
		exampleSin = 0.5;
		assertEquals(exampleSin, s.doCommand(), 0.1);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, s.getArgNum());
	}
}
