package pl.pilabs.servlet.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/greeter")
public class Greeter {

	@GET
	public String greet(@QueryParam(value = "name") String name) throws Exception {
		return "Hello " + name;
	}

}
