package com.ehr.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ehr.model.Doctor;
import com.ehr.model.LoginHistory;
import com.ehr.model.User;
import com.ehr.service.DoctorService;
import com.ehr.service.LoginHistoryService;
import com.ehr.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private LoginHistoryService loginHistoryService;

	@Autowired
	private UserService userService;

    @GetMapping(value="/admin/home")
    public ModelAndView home(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        LoginHistory loginHistory = new LoginHistory(new Date(),request.getRemoteAddr(),request.getHeader("User-Agent"));
        loginHistory.setUser(user);
        loginHistoryService.saveLoginHistory(loginHistory);
        modelAndView.addObject("loginHistory", loginHistory);
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
        return modelAndView;
    }
    
    
}
