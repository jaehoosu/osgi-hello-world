package hello;

import hello.Greeter;

import org.junit.Assert;
import org.junit.Test;

public class ActivatorTest {

	@Test
	public void testBundleWasActivated() {
		Greeter g = Activator.greeter;
		Assert.assertNotNull(g);
	}

	@Test
	public void testGreeter() {
		Assert.assertEquals("Hello from osgi-hello-world-02-testable", Activator.greeter.hello());
	}

}