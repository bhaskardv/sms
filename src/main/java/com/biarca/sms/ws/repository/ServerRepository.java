package com.biarca.sms.ws.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biarca.sms.ws.domain.ServerEntity;

public interface ServerRepository extends JpaRepository<ServerEntity, Integer> {
  public Optional<ServerEntity> getServerByServerId(String serverId);

  public Optional<ServerEntity> getServerByIpAddress(String ipAddress);

  public Optional<ServerEntity> getServerByName(String name);
}
