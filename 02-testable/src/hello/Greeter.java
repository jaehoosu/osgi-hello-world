package hello;

public class Greeter {

	private String name;

	public Greeter(String name) {
		this.name = name;
	}

	public String hello() {
		return "Hello from " + name;
	}

	public String bye() {
		return "Bye from " + name;
	}

}
