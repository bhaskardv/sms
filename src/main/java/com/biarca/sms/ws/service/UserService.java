package com.biarca.sms.ws.service;

import java.util.Collection;
import java.util.Optional;

import com.biarca.sms.ws.domain.UserEntity;

public interface UserService {
  public Collection<UserEntity> findAll();

  public Optional<UserEntity> getUserById(int id);

  public Optional<UserEntity> getUserByName(String name);

  public Optional<UserEntity> getUserByUserId(String userId);

  public UserEntity create(UserEntity user);

  public UserEntity update(UserEntity user);

  public void delete(int id);
}
