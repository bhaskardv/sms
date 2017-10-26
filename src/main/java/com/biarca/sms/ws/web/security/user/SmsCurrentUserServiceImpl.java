package com.biarca.sms.ws.web.security.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.biarca.sms.ws.domain.Role;
import com.biarca.sms.ws.domain.SmsCurrentUser;


public class SmsCurrentUserServiceImpl implements SmsCurrentUserService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SmsCurrentUserServiceImpl.class);

  @Override
  public boolean canAccessUser(SmsCurrentUser currentUser, String userId) {
    LOGGER.debug("Checking if sms user={} has access to the current login user = {}", currentUser,
        userId);
    return currentUser != null
        && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
  }

}
