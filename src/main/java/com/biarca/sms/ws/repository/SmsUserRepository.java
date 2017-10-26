package com.biarca.sms.ws.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biarca.sms.ws.domain.SmsUserEntity;


public interface SmsUserRepository extends JpaRepository<SmsUserEntity, String> {

  Optional<SmsUserEntity> findOneByEmail(String email);

  Collection<SmsUserEntity> getSmsUserByOwner(SmsUserEntity owner);

}
