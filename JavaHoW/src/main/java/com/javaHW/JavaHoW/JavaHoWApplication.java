package com.javaHW.JavaHoW;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@SpringBootApplication
@EnableScheduling
	public class JavaHoWApplication {

		private static final Logger log = LoggerFactory.getLogger(JavaHoWApplication.class);

		public static void main(String[] args) {
			SpringApplication.run(JavaHoWApplication.class, args);
		}

		@Bean
		public RestTemplate restTemplate(RestTemplateBuilder builder) {
			return builder.build();
		}

		@Bean
		public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
			return args -> {
				threejawn();
			};
		}
		@Scheduled(fixedRate = 3000)
	public void threejawn(){
			RestTemplate restTemplate = new RestTemplate();
		LeBroad[] leBroads = restTemplate.getForObject(
				"https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?format=json&market_code=nex", LeBroad[].class);
		log.info(Arrays.toString(leBroads));
	}
	}
