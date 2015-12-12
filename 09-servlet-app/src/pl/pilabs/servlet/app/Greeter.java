package pl.pilabs.servlet.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/greeter")
public class Greeter {

	@QueryParam(value = "name")
	String name;

	@GET
	public String greet() throws Exception {
		return "Hello " + name;
	}

}
