package com.example.JDBCEMPLOYEE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
@EnableSwagger2
@SpringBootApplication
public class JdbcemployeeApplication {

	@Bean
	JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		jdbcTemplate.setQueryTimeout(20); //20 seconds
		jdbcTemplate.setFetchSize(10);  //fetch 10 rows at a time
		return jdbcTemplate;
	}
	public static void main(String[] args) {
		SpringApplication.run(JdbcemployeeApplication.class, args);
	}

}
