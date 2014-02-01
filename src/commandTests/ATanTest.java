package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.ATan;

public class ATanTest {
	private ATan aT;
	private double exampleATan;
	
	public ATanTest() {
		aT = new ATan(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(aT);
	}

	@Test
	public void testGetResult() {
		aT = new ATan(new State(new EnvironmentVariables()));
		aT.addArg(new Arg(90));
		exampleATan = 57.51;
		assertEquals(exampleATan, aT.doCommand(), 0.1);
		
		aT = new ATan(new State(new EnvironmentVariables()));
		aT.addArg(new Arg(0));
		exampleATan = 0;
		assertEquals(exampleATan, aT.doCommand(), 0.1);
		
		aT = new ATan(new State(new EnvironmentVariables()));
		aT.addArg(new Arg(45));
		exampleATan = 38.1;
		assertEquals(exampleATan, aT.doCommand(), 0.1);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, aT.getArgNum());
	}
}

