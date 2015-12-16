package pl.pilabs.servlet.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.google.inject.Inject;

@Path("/greeter")
public class Greeter {

  @Inject
  private static Timestamper timestamper;

  @QueryParam(value = "name")
  String name;

  @GET
  public String greet() throws Exception {
    return "Hello " + name + " at " + timestamper.timestamp();
  }

}
