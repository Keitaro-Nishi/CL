package jp.co.gyosei.botlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootChatbotApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootChatbotApplication.class, args);
	}
}
