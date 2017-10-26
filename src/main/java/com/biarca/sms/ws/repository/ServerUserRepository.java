package com.biarca.sms.ws.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.biarca.sms.ws.domain.ServerUserEntity;

public interface ServerUserRepository extends JpaRepository<ServerUserEntity, Integer> {
  public Collection<ServerUserEntity> getServerUserByServerId(int serverId);

  public Collection<ServerUserEntity> getServerUserByUserId(int userId);

  @Query("select su from ServerUserEntity su where su.server.id=:serverId and su.user.id=:userId")
  public Optional<ServerUserEntity> getServerUserByServerIdUserId(@Param("serverId") int serverId,
      @Param("userId") int userId);

}
