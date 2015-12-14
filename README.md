
# osgi-hello-world

OSGi Tutorial showing possible approaches to implement Hello World as an OSGi bundle.

Each example is implemented as separate Maven module. All modules use MANIFEST-frist appraoch, and are built using Tycho plugin. Each module has it's own minimal target-platform defined and an Eclipse launch file which specifies minimal set of runtime bundles for given example to work. You can run each module simply by right clicking on a launch-file in Eclipse and selcing "Run as osgi-hello-world ...".

The following examples are included:

## Console-based

- 01 - absolutely minimal, single file, with only OSGi framework as dependency
- 02 - as above, with working unit tests
- 03 - as above, with gogo console
- 04 - implemented as OSGi Declarative Service (DS)
- 05 - Declarative Service, using Java annotations to generate service descriptor via SCR plugin

## Servlets, published using [osgi-jax-rs-connector](https://github.com/hstaudacher/osgi-jax-rs-connector)

**Note:** Because of limitations of [osgi-jax-rs-connector](https://github.com/hstaudacher/osgi-jax-rs-connector) which publishes REST resources as singletons, it's not possible to inject request-scoped JAX-RS objects (@QueryParam, etc) into the resource class, as this requires resource classes to have differrent life-cycle.

- 06 - simplest servlet
- 07 - same as above, but with web-console available on <http://localhost:8080/system/console>
- 08 - same as above, with example how to inject request context objects using JAX-RS @Context annotation

## Servlets, published directly in Activator

**Note:** This approach allows REST resource classes to have request life-cycle and allow injecting @QueryParams etc directly into the class. However, because the service is no longer a singleton published into OSGi service registry it's a bit tricky to inject other OSGi services into resource class - see examples on how this is achived, using a "trick" with static field (it's not very nice - still looking for better solution).

- 09 - simplest servlet, published in Activator
- 11 - same as above, using Declarative Services injection
- 12 - same as above, using OSGi annotation-based injection
- 13 - same as above, using SCR annotation-based injection
