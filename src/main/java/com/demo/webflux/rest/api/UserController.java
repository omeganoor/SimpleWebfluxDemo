package com.demo.webflux.rest.api;


import com.demo.webflux.service.api.UserService;
import com.demo.webflux.rest.model.UserRequestParameter;
import com.demo.webflux.rest.model.UserResponseParameter;
import io.swagger.v3.oas.annotations.Parameter;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<UserResponseParameter> createSystemParameter(
      @Parameter(hidden = true) @Valid @RequestHeader String username,
      @RequestBody UserRequestParameter userRequestParameter) {
    log.info(
        "create User Request, username = {}, User= {}", username, userRequestParameter);
    return userService.createUser(username, userRequestParameter);
  }

  @GetMapping("/{id}")
  public Mono<ResponseEntity<UserResponseParameter>> findById(@PathVariable("id") Long id) {
    return userService.findById(id)
        .map(userResponseParameter -> ResponseEntity.ok()
                 .body(userResponseParameter));
  }

  @GetMapping
  public Flux<UserResponseParameter> findAll() {
    return userService.findAll();
  }

  @DeleteMapping("{id}")
  public Mono<Void> deleteById(@PathVariable("id") Long id) {
    return userService.deleteById(id);
  }
}
