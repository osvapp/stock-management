package jp.co.rakus.stockmanagement.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
	@Primary
    PasswordEncoder sha256PasswordEncoder() {
    	return new StandardPasswordEncoder();
//    	return new PasswordEncoder();
    }

//    @Bean
//    @Primary
//    PasswordEncoder bcryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}