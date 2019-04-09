package dev.kociolek.jmoney;

//import dev.kociolek.jmoney.config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class JMoneyApplication {

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//																		WebMvcConfig.class,
//																		WebSecurityConfig.class,
//																		DataSourceConfig.class);
//		context.register(JMoneyApplication.class);
		SpringApplication.run(JMoneyApplication.class, args);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles("vaadin");
	}

}
