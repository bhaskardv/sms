package com.biarca.sms.ws.web;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biarca.sms.ws.service.SmsUserService;
import com.biarca.sms.ws.web.layout.Layout;

@Controller
public class SmsUserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(SmsUserController.class);

  @Autowired
  private SmsUserService smsUserService;

  @Layout(value = "layouts/default")
  @RequestMapping("/sms/dashboard")
  public ModelAndView getUserPage(HttpSession session, @RequestParam Optional<String> error,
      Principal principal) {
    LOGGER.info("Getting sms user page for user = {}");

    ModelAndView modelView = new ModelAndView("user/dashboard", "error", error);
    return modelView;
  }

  @Layout(value = "layouts/default")
  @RequestMapping("/sms/services")
  public ModelAndView getServicesPage(HttpSession session, @RequestParam Optional<String> error,
      Principal principal) {
    LOGGER.info("Getting sms services page for user = {}");

    ModelAndView modelView = new ModelAndView("user/services", "error", error);
    return modelView;
  }


  @Layout(value = "layouts/default")
  @RequestMapping("/sms/about")
  public ModelAndView getAboutPage(HttpSession session, @RequestParam Optional<String> error,
      Principal principal) {
    LOGGER.info("Getting sms about page for user = {}");

    ModelAndView modelView = new ModelAndView("user/about", "error", error);
    return modelView;
  }

  @Layout(value = "layouts/default")
  @RequestMapping("/sms/contact")
  public ModelAndView getContactPage(HttpSession session, @RequestParam Optional<String> error,
      Principal principal) {
    LOGGER.info("Getting sms contact page for user = {}");

    ModelAndView modelView = new ModelAndView("user/contact", "error", error);
    return modelView;
  }
}
