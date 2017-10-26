package com.biarca.sms.ws.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biarca.sms.ws.domain.ServerEntity;
import com.biarca.sms.ws.repository.ServerRepository;
import com.biarca.sms.ws.service.ServerService;

@Service
public class ServerServiceBean implements ServerService {
  private static final Logger LOGGER = LoggerFactory.getLogger(ServerServiceBean.class);

  @Autowired
  private ServerRepository serverRepository;

  @Override
  public Collection<ServerEntity> findAll() {
    return serverRepository.findAll();
  }

  @Override
  public Optional<ServerEntity> getServerById(int id) {
    LOGGER.debug("Getting server by id = {}", id);
    return Optional.ofNullable(serverRepository.findOne(id));
  }

  @Override
  public Optional<ServerEntity> getServerByName(String name) {
    LOGGER.debug("Getting server by name = {}", name);
    return serverRepository.getServerByName(name);
  }

  @Override
  public Optional<ServerEntity> getServerByServerId(String serverId) {
    LOGGER.debug("Getting server by serverId = {}", serverId);
    return serverRepository.getServerByServerId(serverId);
  }

  @Override
  public Optional<ServerEntity> getServerByIpAddress(String ipAddress) {
    LOGGER.debug("Getting server by ipAddress = {}", ipAddress);
    return serverRepository.getServerByServerId(ipAddress);
  }

  @Override
  public ServerEntity create(ServerEntity server) {
    if (serverRepository.exists(server.getId())) {
      return null;
    }
    LOGGER.debug("Creating server = {}", server);
    return serverRepository.saveAndFlush(server);
  }

  @Override
  public ServerEntity update(ServerEntity server) {
    if (!serverRepository.exists(server.getId())) {
      return null;
    }
    LOGGER.debug("Updating server = {}", server);
    return serverRepository.saveAndFlush(server);
  }

  @Override
  public void delete(int id) {
    LOGGER.debug("Deleting server = {}", id);
    serverRepository.delete(id);
  }

}
