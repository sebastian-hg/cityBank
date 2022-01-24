package com.citybank.persons.service;

import reactor.core.publisher.Mono;

public interface DeletePersonRequestService {
   Mono <Boolean> execute(Long id);
}
