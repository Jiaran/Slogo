package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Tan;

public class TanTest {
	private Tan t;
	private double exampleTan;
	
	public TanTest() {
		t = new Tan(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(t);
	}

	@Test
	public void testGetResult() {
		t = new Tan(new State(new EnvironmentVariables()));
		t.addArg(new Arg(45));
		exampleTan = 1;
		assertEquals(exampleTan, t.doCommand(), 0.1);
		
		t = new Tan(new State(new EnvironmentVariables()));
		t.addArg(new Arg(0));
		exampleTan = 0;
		assertEquals(exampleTan, t.doCommand(), 0.1);
		
		t = new Tan(new State(new EnvironmentVariables()));
		t.addArg(new Arg(60));
		exampleTan = 1.732;
		assertEquals(exampleTan, t.doCommand(), 0.1);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, t.getArgNum());
	}
}

