package com.test.restapi;

import com.test.restapi.util.ConsoleColor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);

		System.out.println("\n==============================================\n||" + ConsoleColor.YELLOW_BRIGHT + "\t\trestapi application started :)\t\t" + ConsoleColor.RESET + "||\n==============================================\n");
	}

}
