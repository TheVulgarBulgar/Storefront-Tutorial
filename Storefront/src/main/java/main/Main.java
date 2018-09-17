package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ImportResource("classpath:/META-INF/spring/si-components.xml")
public class Main {

	public static void main(String[] args) {
	//	AnnotationConfigApplicationContext beanFactory =
			//    new AnnotationConfigApplicationContext(IntegrationConfig.class);
		
		SpringApplication.run(Main.class, args);
	}
}
