package commandTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import model.Arg;
import model.EnvironmentVariables;
import model.State;
import org.junit.Test;
import commands.EvalCommands.Product;

public class ProductTest {
	private Product p;
	private double exampleProduct;
	
	public ProductTest() {
		p = new Product(new State(new EnvironmentVariables()));
	}

	@Test
	public void testSum() {
		assertNotNull(p);
	}

	@Test
	public void testGetResult() {
		p = new Product(new State(new EnvironmentVariables()));
		p.addArg(new Arg(2));
		p.addArg(new Arg(7));
		exampleProduct = 14;
		assertEquals(exampleProduct, p.doCommand(), 0);
		
		p = new Product(new State(new EnvironmentVariables()));
		p.addArg(new Arg(0));
		p.addArg(new Arg(7));
		exampleProduct = 0;
		assertEquals(exampleProduct, p.doCommand(), 0);
		
		p = new Product(new State(new EnvironmentVariables()));
		p.addArg(new Arg(-1));
		p.addArg(new Arg(7));
		exampleProduct = -7;
		assertEquals(exampleProduct, p.doCommand(), 0);
	}

	@Test
	public void testGetArgNum() {
		assertEquals(2, p.getArgNum());
	}
}

