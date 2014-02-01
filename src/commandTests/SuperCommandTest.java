package commandTests;

import model.EnvironmentVariables;
import model.State;

public class SuperCommandTest {
	public State testState;
	
	public SuperCommandTest(){
		testState = new State(new EnvironmentVariables());
		testState.addTurtle(1);
	}
}
