package hello;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;

public class Activator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Hello!");
		bundleContext.getBundle(Constants.SYSTEM_BUNDLE_ID).stop();
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Bye...");
	}

}
