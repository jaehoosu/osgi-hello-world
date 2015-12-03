package hello;

import hello.Greeter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GreeterTest {

	private Greeter greeter;

	@Before
	public void init() {
		greeter = new Greeter("Joe");
	}
	
	@Test
	public void testHello() {
		Assert.assertEquals("Hello from Joe", greeter.hello());
	}

	@Test
	public void testBye() {
		Assert.assertEquals("Bye from Joe", greeter.bye());
	}

}
