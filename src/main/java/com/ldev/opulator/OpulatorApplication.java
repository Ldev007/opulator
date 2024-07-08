package com.ldev.opulator;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ldev.opulator.configs.FirebaseConfig;

@SpringBootApplication
public class OpulatorApplication {

	public static void main(String[] args) {
		FirebaseConfig config = new FirebaseConfig();
		try {
			config.configureFirebaseConnection();
		} catch (IOException e) {
			System.out.println("IN MAIN");
			e.printStackTrace();
		}
		SpringApplication.run(OpulatorApplication.class, args);
	}

}
