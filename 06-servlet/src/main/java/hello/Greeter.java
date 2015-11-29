package hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.osgi.service.component.annotations.Component;

@Path("/greeter")
@Component(immediate = true, service = Object.class)
public class Greeter {

	@GET
	public String greet() throws Exception {
		return "Hello!";
	}

}
