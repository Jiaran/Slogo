package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Log;

public class LogTest {
	private Log l;
	private double exampleLog;
	
	public LogTest() {
		l = new Log(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(l);
	}

	@Test
	public void testGetResult() {
		l = new Log(new State(new EnvironmentVariables()));
		l.addArg(new Arg(1));
		exampleLog = 0;
		assertEquals(exampleLog, l.doCommand(), 0.1);
		
		l = new Log(new State(new EnvironmentVariables()));
		l.addArg(new Arg(10));
		exampleLog = 2.30;
		assertEquals(exampleLog, l.doCommand(), 0.1);
		
		l = new Log(new State(new EnvironmentVariables()));
		l.addArg(new Arg(100));
		exampleLog = 4.605;
		assertEquals(exampleLog, l.doCommand(), 0.1);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(1, l.getArgNum());
	}
}
