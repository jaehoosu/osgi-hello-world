package hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.osgi.service.component.annotations.Component;

@Path("/greeter")
@Component(service = Object.class, servicefactory = true)
public class Greeter {

	@GET
	public String greet(@QueryParam(value = "name") String name) throws Exception {
		return "Hello " + name;
	}

}
