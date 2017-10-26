package com.biarca.sms.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biarca.sms.ws.domain.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Integer> {
  public Optional<UserEntity> getUserByName(String name);

  public Optional<UserEntity> getUserByUserId(String userId);
}
