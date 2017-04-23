package pw.eiti.pik;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pw.eiti.pik.entity.User;
import pw.eiti.pik.service.UserService;

@SpringBootApplication
public class SocialnetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialnetworkApplication.class, args);
	}


	@Bean
	public CommandLineRunner runApp(UserService serv) {
		return (args) -> {

			User u = new User();
			u.setFirstName("asd");
			u.setSurname("zcs");
			u.setEmail("asd@gasd.com");
			u.setPassword("12345");
			serv.addPerson(u);
			serv.getAllPersons().forEach(pr -> System.out.println(pr));

		};

	}
}
