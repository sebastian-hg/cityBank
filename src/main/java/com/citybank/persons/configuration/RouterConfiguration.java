package com.citybank.persons.configuration;

import com.citybank.persons.handler.CreatePersonRequestHandler;
import com.citybank.persons.handler.DeletePersonRequestHandler;
import com.citybank.persons.handler.UpdatePersonRequestHandler;
import com.citybank.persons.handler.ViewPersonByIdHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfiguration {
    @Bean
    public RouterFunction<ServerResponse> routeRequest(ViewPersonByIdHandler viewPersonByIdHandler, CreatePersonRequestHandler createPersonRequestHandler,
                                                       DeletePersonRequestHandler deletePersonRequestHandler, UpdatePersonRequestHandler updatePersonRequestHandler) {
        return route(RequestPredicates.GET("cityBank/person"), viewPersonByIdHandler::executeWithoutBodyValidation)
                .and(route(RequestPredicates.POST("cityBank/person/create"), createPersonRequestHandler::execute))
                .and(route(RequestPredicates.DELETE("cityBank/person/delete"), deletePersonRequestHandler::executeWithoutBodyValidation))
                .and(route(RequestPredicates.PUT("cityBank/person/update"), updatePersonRequestHandler::executeWithBodyValidation))
                ;

    }
}
