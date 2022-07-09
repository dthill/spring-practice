package pgfsd.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pgfsd.springpractice.dto.LoginFormDto;
import pgfsd.springpractice.entities.User;
import pgfsd.springpractice.services.LoginService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("loginForm", new LoginFormDto());
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@Validated @ModelAttribute LoginFormDto loginFormDto, Model model, HttpSession httpSession){
        User loggedUser = loginService.login(loginFormDto);
        if(loggedUser == null){
            httpSession.invalidate();
            model.addAttribute("loginError", "Unable to login");
            model.addAttribute("loginForm", new LoginFormDto(loginFormDto.getId()));
            return "login";
        }
        httpSession.setAttribute("loggedUser", loggedUser );
        return "redirect:";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession, Model model){
        httpSession.invalidate();
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String feedbackIntegrityException(HttpSession httpSession, Model model){
        httpSession.invalidate();
        model.addAttribute("loginError", "Unable to login");
        model.addAttribute("loginForm", new LoginFormDto());
        return "login";
    }
}
