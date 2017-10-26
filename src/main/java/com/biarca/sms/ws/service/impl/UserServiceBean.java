package com.biarca.sms.ws.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biarca.sms.ws.domain.UserEntity;
import com.biarca.sms.ws.repository.UserRepository;
import com.biarca.sms.ws.service.UserService;

@Service
public class UserServiceBean implements UserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceBean.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public Collection<UserEntity> findAll() {
    return userRepository.findAll();
  }

  @Override
  public Optional<UserEntity> getUserById(int id) {
    LOGGER.debug("Getting user = {}", id);
    return Optional.ofNullable(userRepository.findOne(id));
  }

  @Override
  public Optional<UserEntity> getUserByName(String name) {
    LOGGER.debug("Getting user by name= {}", name);
    return userRepository.getUserByName(name);
  }

  @Override
  public Optional<UserEntity> getUserByUserId(String userId) {
    LOGGER.debug("Getting user by userId= {}", userId);
    return userRepository.getUserByUserId(userId);
  }

  @Override
  public UserEntity create(UserEntity user) {
    if (userRepository.exists(user.getId())) {
      return null;
    }
    LOGGER.debug("Creating sms user = {}", user);
    return userRepository.saveAndFlush(user);
  }

  @Override
  public UserEntity update(UserEntity user) {
    if (!userRepository.exists(user.getId())) {
      return null;
    }
    LOGGER.debug("Updating user = {}", user);
    return userRepository.saveAndFlush(user);
  }

  @Override
  public void delete(int id) {
    LOGGER.debug("Deleting user = {}", id);
    userRepository.delete(id);
  }

}
