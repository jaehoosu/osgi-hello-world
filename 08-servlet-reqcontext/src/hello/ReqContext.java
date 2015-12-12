package hello;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;

@Path("/context")
@Component(service = Object.class, servicefactory = true)
public class ReqContext {

	@Context
	UriInfo uriInfo;

	@Context
	ServletContext sc;

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	@GET
	public String context() throws Exception {
		return "uri=" + uriInfo.getRequestUri() + " server=" + sc.getServerInfo() + " req=" + request + " res=" + response;
	}

}
