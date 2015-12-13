package pl.pilabs.servlet.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/greeter")
public class Greeter {

	private static Timestamper timestamper;
	
	public void setTimestamper(Timestamper t) {
		timestamper = t;
	}
	
	public void unsetTimestamper(Timestamper t) {
		timestamper = null;
	}
	
	@QueryParam(value = "name")
	String name;

	@GET
	public String greet() throws Exception {
		return "Hello " + name + " at " + timestamper.timestamp();
	}

}
