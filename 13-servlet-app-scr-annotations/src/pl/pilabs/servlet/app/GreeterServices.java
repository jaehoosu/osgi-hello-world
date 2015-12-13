package pl.pilabs.servlet.app;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

@Component
@Service(value = GreeterServices.class)
public class GreeterServices {

	@Reference
	Timestamper timestamper;

	public Timestamper getTimestamper() {
		return timestamper;
	}

}
