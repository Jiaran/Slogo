package commandTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ATanTest.class, CosTest.class, DifferenceTest.class,
		LogTest.class, MinusTest.class, ProductTest.class, QuotientTest.class,
		RandomTest.class, RemainderTest.class, SinTest.class, SumTest.class,
		TanTest.class })
public class EvalCommandTests {

}
