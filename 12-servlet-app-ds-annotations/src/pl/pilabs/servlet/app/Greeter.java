package pl.pilabs.servlet.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Path("/greeter")
@Component(immediate = true)
public class Greeter {

	private static Timestamper timestamper;

	@Reference
	protected void setTimestamper(Timestamper t) {
		timestamper = t;
	}

	protected void unsetTimestamper(Timestamper t) {
		timestamper = null;
	}

	@QueryParam(value = "name")
	String name;

	@GET
	public String greet() throws Exception {
		return "Hello " + name + " at " + timestamper.timestamp();
	}

}
