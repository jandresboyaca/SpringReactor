package com.example.reactor.service;

import com.example.reactor.dto.ResourceDTO;
import com.example.reactor.logAnnotation.LoggableReactor;
import com.example.reactor.port.ApiWebClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service("SERVICE_2")
@RequiredArgsConstructor
public class CleanService2 implements GeneralService {

    private final ApiWebClient webClient;

    @Override
    @LoggableReactor
    public Mono<? extends ResourceDTO> test() {
        return webClient.test(1);
    }

}
