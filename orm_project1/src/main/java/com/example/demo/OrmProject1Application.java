package com.example.demo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
@SpringBootApplication

public class OrmProject1Application implements CommandLineRunner{
	@Autowired
	private StudentRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(OrmProject1Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Fetching students from database...");

		repo.findById(102).ifPresent(student -> {
		    System.out.println(student);
		});
	}
}