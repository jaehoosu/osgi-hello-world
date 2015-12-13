package pl.pilabs.servlet.app;

import java.time.LocalDateTime;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;

@Component
@Service(value = Timestamper.class)
public class TimestamperImpl implements Timestamper {

	public String timestamp() {
		return LocalDateTime.now().toString();
	}

}
