package learning.api.persistanceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class PersistanceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistanceapiApplication.class, args);
		
		
	}

}
