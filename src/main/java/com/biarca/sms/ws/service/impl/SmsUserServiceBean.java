package com.biarca.sms.ws.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biarca.sms.ws.domain.SmsUserEntity;
import com.biarca.sms.ws.repository.SmsUserRepository;
import com.biarca.sms.ws.service.SmsUserService;


@Service
public class SmsUserServiceBean implements SmsUserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SmsUserServiceBean.class);

  @Autowired
  private SmsUserRepository smsUserRepository;

  @Override
  public Collection<SmsUserEntity> findAll() {
    return smsUserRepository.findAll();
  }

  @Override
  public Optional<SmsUserEntity> getUserById(String id) {
    LOGGER.debug("Getting sms user = {}", id);
    return Optional.ofNullable(smsUserRepository.findOne(id));
  }

  @Override
  public Optional<SmsUserEntity> getUserByEmail(String email) {
    LOGGER.debug("Getting sms user by email = {}", email);
    return smsUserRepository.findOneByEmail(email);
  }

  @Override
  public SmsUserEntity create(SmsUserEntity user) {
    if (smsUserRepository.exists(user.getId())) {
      return null;
    }
    LOGGER.debug("Creating sms user = {}", user);
    return smsUserRepository.saveAndFlush(user);
  }

  @Override
  public SmsUserEntity update(SmsUserEntity user) {
    if (!smsUserRepository.exists(user.getId())) {
      return null;
    }

    LOGGER.debug("Updating sms user = {}", user);
    return smsUserRepository.saveAndFlush(user);
  }

  @Override
  public void delete(String id) {
    LOGGER.debug("Deleting sms user = {}", id);
    smsUserRepository.delete(id);
  }

  @Override
  public Collection<SmsUserEntity> getUserByOwner(SmsUserEntity owner) {
    LOGGER.debug("Getting sms user by owner = {}", owner);
    return smsUserRepository.getSmsUserByOwner(owner);
  }
}
