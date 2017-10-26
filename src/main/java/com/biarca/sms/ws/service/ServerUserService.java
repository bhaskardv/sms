package com.biarca.sms.ws.service;

import java.util.Collection;
import java.util.Optional;

import com.biarca.sms.ws.domain.ServerUserEntity;


public interface ServerUserService {
  public Collection<ServerUserEntity> findAll();

  public Optional<ServerUserEntity> getServerUserById(int id);

  public ServerUserEntity create(ServerUserEntity serverUser);

  public ServerUserEntity update(ServerUserEntity serverUser);

  public Collection<ServerUserEntity> getServerUserByServerId(int serverId);

  public Collection<ServerUserEntity> getServerUserByUserId(int userId);

  public Optional<ServerUserEntity> getServerUserByServerIdUserId(int serverId, int userId);

}
