package com.biarca.sms.ws.web.security.user;

import com.biarca.sms.ws.domain.SmsCurrentUser;

public interface SmsCurrentUserService {

  public boolean canAccessUser(SmsCurrentUser currentUser, String userId);

}
