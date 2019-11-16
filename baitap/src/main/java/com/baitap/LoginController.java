package com.baitap;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Controller
public class LoginController extends WebMvcConfigurerAdapter {
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
    }

    @GetMapping("/")
    public String showForm(LoginForm loginForm) {
        return "login";
    }

    @PostMapping("/")
    public String validateLogin(Model model, @Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        model.addAttribute("user", loginForm.getuserName());
        return "home";
    }
}
