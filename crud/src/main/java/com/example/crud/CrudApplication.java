package com.example.crud;


import com.example.crud.dao.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataLoader(TaskRepository repo) {
		return new CommandLineRunner() {
			// saves the data in the db -> replaces the data.sql in jpa
			@Override
			public void run(String... args) throws Exception {

			}
		};

	}

}




