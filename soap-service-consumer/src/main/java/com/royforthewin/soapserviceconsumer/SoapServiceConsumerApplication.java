package com.royforthewin.soapserviceconsumer;

import com.royforthewin.consumingwebservice.wsdl.GetCountryResponse;
import com.royforthewin.soapserviceconsumer.services.CountryClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoapServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapServiceConsumerApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(CountryClient quoteClient) {
		return args -> {
			String country = "Spain";

			if (args.length > 0) {
				country = args[0];
			}
			GetCountryResponse response = quoteClient.getCountry(country);
			System.err.println(response.getCountry().getCurrency());
		};
	}

}
