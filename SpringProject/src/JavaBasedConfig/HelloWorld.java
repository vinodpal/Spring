/**
 * 
 */
package JavaBasedConfig;

public class HelloWorld {
	private String name = null;

	public HelloWorld(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void initMethod() {
		System.out.println("initMethod");
	}

	public void destroyMethod() {
		System.out.println("destroyMethod");
	}
}
