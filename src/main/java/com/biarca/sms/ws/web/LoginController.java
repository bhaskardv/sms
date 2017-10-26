package com.biarca.sms.ws.web;

import java.security.Principal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biarca.sms.ws.form.Login;
import com.biarca.sms.ws.web.layout.Layout;

@Controller
public class LoginController {
  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  @Layout(value = "layouts/blank")
  @RequestMapping(value = "/sms/login", method = RequestMethod.GET)
  public ModelAndView getLoginPage(Login login, @RequestParam Optional<String> error,
      Principal principal) {
    LOGGER.debug("Getting login page, error = {}", error);
    if (principal != null && principal.getName() != null) {
      return new ModelAndView("redirect:/sms/dashboard");
    }

    return new ModelAndView("signin/login", "error", error);
  }
}
