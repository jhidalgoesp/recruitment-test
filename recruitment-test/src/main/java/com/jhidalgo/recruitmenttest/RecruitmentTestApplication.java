package com.jhidalgo.recruitmenttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class RecruitmentTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentTestApplication.class, args);
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext();
		ctx.register(TestConfiguration.class);
		ctx.refresh();
	}
}
