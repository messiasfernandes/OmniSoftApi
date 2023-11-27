package br.com.omnisoftapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.omnisoftapi")
public class OmniSoftApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OmniSoftApiApplication.class, args);
	}

}
