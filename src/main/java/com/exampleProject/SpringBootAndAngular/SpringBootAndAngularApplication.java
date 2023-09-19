package com.exampleProject.SpringBootAndAngular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringBootAndAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAndAngularApplication.class, args);
	}

	/*@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/

	/*@Bean
	CommandLineRunner runner(UserService userService, RoleService roleService) {
		return args -> {
			roleService.save(new Role(null,"ROLE_PRF"));
			roleService.save(new Role(null,"ROLE_ADMIN"));
			roleService.save(new Role(null,"ROLE_APPRENANT"));

			userService.save(new Utilisateur(null, "bouchra", "bouchra123", "123", new ArrayList<>()));
			userService.save(new Utilisateur(null, "karim", "karim2", "123", new ArrayList<>()));
			userService.save(new Utilisateur(null, "sami", "sami123", "123", new ArrayList<>()));

			userService.addRoleToUser("bouchra123", "ROLE_PRF");
			userService.addRoleToUser("karim2", "ROLE_APPRENANT");
			userService.addRoleToUser("sami123", "ROLE_ADMIN");

		};
	} */

}
