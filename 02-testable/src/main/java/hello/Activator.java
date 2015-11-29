package hello;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	static Greeter greeter;

	public void start(BundleContext bundleContext) throws Exception {
		String name = bundleContext.getBundle().getSymbolicName();
		greeter = new Greeter(name);
		System.out.println(greeter.hello());
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println(greeter.bye());
	}

}
