package com.estudo.rivals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RivalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RivalsApplication.class, args);
	}

}
