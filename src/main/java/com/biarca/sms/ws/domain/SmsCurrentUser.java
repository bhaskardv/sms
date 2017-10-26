package com.biarca.sms.ws.domain;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class SmsCurrentUser extends User {
  private static final long serialVersionUID = 1977217205557818587L;
  private SmsUserEntity smsUserEntity;

  public SmsCurrentUser(SmsUserEntity userEntity) {
    super(userEntity.getId(), userEntity.getPassword(),
        AuthorityUtils.createAuthorityList(userEntity.getRole().toString()));
    this.smsUserEntity = userEntity;
  }

  public SmsUserEntity getUser() {
    return smsUserEntity;
  }

  public String getId() {
    return smsUserEntity.getId();
  }

  public Role getRole() {
    return smsUserEntity.getRole();
  }

  public boolean isAdmin() {
    return smsUserEntity.getAdminStatus();
  }

  @Override
  public String toString() {
    return "SmsCurrentUser{" + "user=" + smsUserEntity + "} " + super.toString();
  }
}
