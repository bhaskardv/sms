package com.biarca.sms.ws.service;

import java.util.Collection;
import java.util.Optional;

import com.biarca.sms.ws.domain.SmsUserEntity;


public interface SmsUserService {
  public Collection<SmsUserEntity> findAll();

  public Optional<SmsUserEntity> getUserById(String id);

  public Optional<SmsUserEntity> getUserByEmail(String email);

  public SmsUserEntity create(SmsUserEntity user);

  // Should Not be implementing
  public SmsUserEntity update(SmsUserEntity user);

  // Should Not be implementing
  public void delete(String id);

  public Collection<SmsUserEntity> getUserByOwner(SmsUserEntity owner);
}
