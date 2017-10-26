package com.biarca.sms.ws.web;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biarca.sms.ws.web.layout.Layout;

@Controller
public class PasswordController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PasswordController.class);

  @Layout(value = "layouts/default")
  @RequestMapping("/sms/passwordlist")
  public ModelAndView getPasswordList(HttpSession session, @RequestParam Optional<String> error,
      Principal principal) {
    LOGGER.info("Getting sms password list page of password vault = {}");

    ModelAndView modelView = new ModelAndView("passwords/passwordlist", "error", error);
    return modelView;
  }

  @Layout(value = "layouts/default")
  @RequestMapping(value = "/sms/password"/* , method = RequestMethod.POST */)
  public ModelAndView addPassword(@RequestParam Optional<String> error, Principal principal) {
    LOGGER.info("Getting sms password page for a = {}");

    ModelAndView modelView = new ModelAndView("passwords/password", "error", error);
    return modelView;
  }
}
