package com.demo.webflux.service.impl;

import com.demo.webflux.dao.UserRepository;
import com.demo.webflux.entity.dao.User;
import com.demo.webflux.libraries.BeanMapper;
import com.demo.webflux.service.api.UserService;
import com.demo.webflux.service.model.UserRequestParameter;
import com.demo.webflux.service.model.UserResponseParameter;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import javax.naming.NotContextException;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Mono<UserResponseParameter> createUser(String username, UserRequestParameter userRequestParameter) {
    User user = BeanMapper.map(userRequestParameter, User.class);
    user.setUsername(username);
    log.info("Save user = {}", user);
    return Mono.just(userRepository.save(user))
        .map(response -> BeanMapper.map(response, UserResponseParameter.class))
        .switchIfEmpty(Mono.defer(() -> Mono.error(new Exception("Failed to save data"))));
  }

  @Override
  public Mono<UserResponseParameter> findById(Long id) {
    log.info("Find user by Id = {}", id);
    return Mono.just(userRepository.findById(id))
        .flatMap(user -> {
          log.info("result = {}", user);
          if (!user.isPresent()){
            return Mono.error(new Exception("No data Exist"));
          }
          return Mono.just(BeanMapper.map(user.get(), UserResponseParameter.class));
        });
  }

  @Override
  public Flux<UserResponseParameter> findAll() {
    log.info("Find All user");
    return Flux.fromIterable(userRepository.findAll())
        .switchIfEmpty(Mono.defer(() -> Mono.error(new NotContextException("No Data Exist"))))
        .map(user -> BeanMapper.map(user, UserResponseParameter.class));
  }

  @Override
  public Mono<Void> deleteById(Long id) {
    log.info("Delete user by Id= {}", id);
    userRepository.deleteById(id);
    return Mono.empty();
  }
}
