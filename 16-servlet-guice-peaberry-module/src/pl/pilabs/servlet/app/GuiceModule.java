package pl.pilabs.servlet.app;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

  @Override
  protected void configure() {
    requestStaticInjection(Greeter.class);
    bind(Timestamper.class).toProvider(service(Timestamper.class).single());
    bind(export(Timestamper.class)).toProvider(service(TimestamperImpl.class).export());
  }

}
