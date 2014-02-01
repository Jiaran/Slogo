package commandTests;

import static org.junit.Assert.*;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Random;

public class RandomTest {
	private Random r;
	private double exampleRandom;
	
	public RandomTest() {
		r = new Random(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(r);
	}

	@Test
	public void testGetResult() {
		r = new Random(new State(new EnvironmentVariables()));
		r.addArg(new Arg(2));
		assertTrue(r.doCommand()<2);
		
		r = new Random(new State(new EnvironmentVariables()));
		r.addArg(new Arg(50));
		assertTrue(r.doCommand()<50);
		
		r = new Random(new State(new EnvironmentVariables()));
		r.addArg(new Arg(1));
		assertTrue(r.doCommand()<1);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, r.getArgNum());
	}
}