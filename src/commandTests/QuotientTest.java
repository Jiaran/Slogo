package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;

import org.junit.Test;

import commands.EvalCommands.Quotient;

public class QuotientTest {
	private Quotient q;
	private double exampleQuotient;
	
	public QuotientTest() {
		q = new Quotient(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(q);
	}

	@Test
	public void testGetResult() {
		q = new Quotient(new State(new EnvironmentVariables()));
		q.addArg(new Arg(7));
		q.addArg(new Arg(2));
		exampleQuotient = 3.5;
		assertEquals(exampleQuotient, q.doCommand(), 0);
		
		q = new Quotient(new State(new EnvironmentVariables()));
		q.addArg(new Arg(2));
		q.addArg(new Arg(2));
		exampleQuotient = 1;
		assertEquals(exampleQuotient, q.doCommand(), 0);
		
		q = new Quotient(new State(new EnvironmentVariables()));
		q.addArg(new Arg(0));
		q.addArg(new Arg(2));
		exampleQuotient = 0;
		assertEquals(exampleQuotient, q.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, q.getArgNum());
	}
}
