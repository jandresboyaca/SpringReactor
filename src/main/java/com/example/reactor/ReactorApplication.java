package com.example.reactor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@SpringBootApplication
public class ReactorApplication implements CommandLineRunner {

    private final ApiWebClient webClient;

    public ReactorApplication(ApiWebClient webClient) {
        this.webClient = webClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(ReactorApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");

        List<Mono<ResourceDTO>> requests = IntStream.rangeClosed(1, 5).mapToObj(webClient::test).collect(Collectors.toList());

        Mono.zip(requests, objects -> {
            log.info(Arrays.toString(objects));
            return objects;
        }).block();


    }
}
