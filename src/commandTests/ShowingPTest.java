package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import commands.QueryCommands.ShowingP;

public class ShowingPTest extends SuperCommandTest{
	private ShowingP s;

	public ShowingPTest() {
		s = new ShowingP(testState);
	}

	@Test
	public void testDoCommand() {
		testState.setVisibility(true);
		assertEquals(1, s.doCommand(), 0);
		assertEquals(true, testState.getVisibility());
		testState.setVisibility(false);
		assertEquals(0, s.doCommand(), 0);
		assertEquals(false, testState.getVisibility());
		
	}

	@Test
	public void testShowingP() {
		assertNotNull(s);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(0, s.getArgNum());
	}
}


