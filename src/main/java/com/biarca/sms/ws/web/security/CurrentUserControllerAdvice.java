package com.biarca.sms.ws.web.security;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.biarca.sms.ws.domain.SmsCurrentUser;

@ControllerAdvice
public class CurrentUserControllerAdvice {

  @ModelAttribute("currentUser")
  public SmsCurrentUser getCurrentUser(Authentication authentication) {
    return (authentication == null) ? null : (SmsCurrentUser) authentication.getPrincipal();
  }
}
