package pl.pilabs.servlet.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;

@Path("/greeter")
@Component(immediate = true)
public class Greeter {

	@Reference
	static GreeterServices services;

	@QueryParam(value = "name")
	String name;

	@GET
	public String greet() throws Exception {
		return "Hello " + name + " at " + services.getTimestamper().timestamp();
	}

	protected void bindServices(GreeterServices s) {
		services = s;
	}

	protected void unbindServices(GreeterServices s) {
		services = null;
	}

}
