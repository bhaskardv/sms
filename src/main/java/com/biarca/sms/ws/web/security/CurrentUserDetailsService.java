package com.biarca.sms.ws.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biarca.sms.ws.domain.SmsCurrentUser;
import com.biarca.sms.ws.domain.SmsUserEntity;
import com.biarca.sms.ws.service.SmsUserService;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

  private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

  private final SmsUserService userService;

  @Autowired
  public CurrentUserDetailsService(SmsUserService userService) {
    this.userService = userService;
  }

  @Override
  public SmsCurrentUser loadUserByUsername(String id) throws UsernameNotFoundException {
    SmsUserEntity user = userService.getUserById(id).orElseThrow(
        () -> new UsernameNotFoundException(String.format("User with id=%s was not found", id)));

    SmsCurrentUser currentUser = null;
    if (user.getActiveStatus()) {
      LOGGER.debug("Authenticating user with id = {}", id);
      currentUser = new SmsCurrentUser(user);
    }

    if (currentUser == null) {
      String message = String.format("User with id=%s is disabled = {}", id);
      LOGGER.info(message);
      throw new UsernameNotFoundException(message);
    }
    return currentUser;
  }

}
