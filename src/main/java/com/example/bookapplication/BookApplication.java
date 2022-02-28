package com.example.bookapplication;

import com.example.bookapplication.data.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookApplication {

    private static final Logger log = LoggerFactory.getLogger(BookApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(BookApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            Book book = restTemplate.getForObject("https://gutendex.com/books/", Book.class);
//            assert book != null;
//            log.info(book.toString());
//        };
//    }
}
