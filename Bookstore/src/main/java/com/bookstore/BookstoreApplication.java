package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bookstore.domain.User;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.UserService;
import com.bookstore.utility.SecurityUtility;


@SpringBootApplication
@ComponentScan(basePackages = {"com.bookstore.controller", "com.bookstore",} )
@Configuration
@EnableAutoConfiguration
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Override
		public void run(String... args) throws Exception{
		    User user1 = new User();
		    user1.setFirstName("Nikola");
		    user1.setLastName("Krsmanovic");
		    user1.setUsername("n");
		    user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		    user1.setEmail("nikolakrsmanovic223@gmail.com");
		    Set<UserRole> userRoles = new HashSet<>();
		    Role role1 = new Role();
		    role1.setRoleId(1);
		    role1.setName("ROLE_USER");
		    userRoles.add(new UserRole(user1,role1));
		    
		    
		    userService.createUser(user1, userRoles);
	}
	
	
}
