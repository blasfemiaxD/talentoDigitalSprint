package cl.talentodigital.sprint_JSP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"cl.talentodigital.sprint_JSP.controller"})
public class SprintJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintJspApplication.class, args);
	}

}
