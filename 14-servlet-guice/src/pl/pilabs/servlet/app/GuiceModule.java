package pl.pilabs.servlet.app;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    requestStaticInjection(Greeter.class);
    bind(Timestamper.class).to(TimestamperImpl.class);
  }

}
