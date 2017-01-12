
package JavaBasedConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
	public static void main(String [] args){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		{HelloWorld h = ctx.getBean(HelloWorld.class);
		System.out.println(h.getName());
		h.setName("JavaBased");
		System.out.println(h.getName());
		}
		System.out.println("Done");
	}
}
