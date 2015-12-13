package pl.pilabs.servlet.app;

import java.time.LocalDateTime;

import org.osgi.service.component.annotations.Component;

@Component
public class TimestamperImpl implements Timestamper {

	public String timestamp() {
		return LocalDateTime.now().toString();
	}

}
