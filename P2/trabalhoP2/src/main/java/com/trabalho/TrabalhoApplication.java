package com.trabalho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TrabalhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoApplication.class, args);
                System.out.println(new BCryptPasswordEncoder().encode("1234"));
	}

}
