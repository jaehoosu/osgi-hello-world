package hello;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true)
public class Greeter {

	public void activate() throws Exception {
		System.out.println("Hello!");
	}

	public void deactivate() throws Exception {
		System.out.println("Bye...");
	}

}
