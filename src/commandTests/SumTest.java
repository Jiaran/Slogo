package commandTests;

import static org.junit.Assert.*;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Sum;

public class SumTest {
	private Sum s;
	private double exampleSum;

	public SumTest() {
		s = new Sum(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(s);
	}

	@Test
	public void testGetResult() {
		s = new Sum(new State(new EnvironmentVariables()));
		s.addArg(new Arg(3));
		s.addArg(new Arg(5));
		exampleSum = 8;
		assertEquals(exampleSum, s.doCommand(), 0);
		
		s = new Sum(new State(new EnvironmentVariables()));
		s.addArg(new Arg(2));
		s.addArg(new Arg(7));
		exampleSum = 9;
		assertEquals(exampleSum, s.doCommand(), 0);
		
		s = new Sum(new State(new EnvironmentVariables()));
		s.addArg(new Arg(3));
		s.addArg(new Arg(8));
		exampleSum = 11;
		assertEquals(exampleSum, s.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, s.getArgNum());
	}
}
