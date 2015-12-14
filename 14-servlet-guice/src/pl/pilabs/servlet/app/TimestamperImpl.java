package pl.pilabs.servlet.app;

import java.time.LocalDateTime;

public class TimestamperImpl implements Timestamper {

	public String timestamp() {
		return LocalDateTime.now().toString();

	}

}
