package com.demo.webflux.service.api;


import com.demo.webflux.rest.model.UserRequestParameter;
import com.demo.webflux.rest.model.UserResponseParameter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

  Mono<UserResponseParameter> createUser(String username, UserRequestParameter userRequestParameter);

  Mono<UserResponseParameter> findById(Long id);

  Flux<UserResponseParameter> findAll();

  Mono<Void> deleteById(Long id);
}
