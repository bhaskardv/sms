package com.biarca.sms.ws.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biarca.sms.ws.domain.ServerUserEntity;
import com.biarca.sms.ws.repository.ServerUserRepository;
import com.biarca.sms.ws.service.ServerUserService;

@Service
public class ServerUserServiceBean implements ServerUserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServerUserServiceBean.class);

  @Autowired
  private ServerUserRepository serverUserRepo;

  @Override
  public Collection<ServerUserEntity> findAll() {
    return serverUserRepo.findAll();
  }

  @Override
  public Optional<ServerUserEntity> getServerUserById(int id) {
    LOGGER.debug("Getting server user = {}", id);
    return Optional.ofNullable(serverUserRepo.findOne(id));
  }

  @Override
  public ServerUserEntity create(ServerUserEntity serverUser) {
    if (serverUserRepo.exists(serverUser.getId())) {
      return null;
    }
    LOGGER.debug("Creating server user = {}", serverUser);
    return serverUserRepo.saveAndFlush(serverUser);
  }

  @Override
  public ServerUserEntity update(ServerUserEntity serverUser) {
    if (!serverUserRepo.exists(serverUser.getId())) {
      return null;
    }
    LOGGER.debug("Updating server user = {}", serverUser);
    return serverUserRepo.saveAndFlush(serverUser);
  }

  @Override
  public Collection<ServerUserEntity> getServerUserByServerId(int serverId) {
    LOGGER.debug("Getting server user by serverId = {}", serverId);
    return serverUserRepo.getServerUserByServerId(serverId);
  }

  @Override
  public Collection<ServerUserEntity> getServerUserByUserId(int userId) {
    LOGGER.debug("Getting server user by userId = {}", userId);
    return serverUserRepo.getServerUserByServerId(userId);
  }

  @Override
  public Optional<ServerUserEntity> getServerUserByServerIdUserId(int serverId, int userId) {
    LOGGER.debug("Getting server user by serverId and userId = {}", serverId, userId);
    return serverUserRepo.getServerUserByServerIdUserId(serverId, userId);
  }
}
