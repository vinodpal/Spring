/**
 * 
 */
package JavaBasedConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
	@Bean(initMethod="initMethod",destroyMethod="destroyMethod")
	public HelloWorld getName(){
		return new HelloWorld("Hello");
	}
}
