package com.biarca.sms.ws.service;

import java.util.Collection;
import java.util.Optional;

import com.biarca.sms.ws.domain.ServerEntity;

public interface ServerService {
  public Collection<ServerEntity> findAll();

  public Optional<ServerEntity> getServerById(int id);

  public Optional<ServerEntity> getServerByName(String name);

  public Optional<ServerEntity> getServerByServerId(String serverId);

  public Optional<ServerEntity> getServerByIpAddress(String ipAddress);

  public ServerEntity create(ServerEntity server);

  public ServerEntity update(ServerEntity server);

  public void delete(int id);
}
