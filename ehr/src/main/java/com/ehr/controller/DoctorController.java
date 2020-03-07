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
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private LoginHistoryService loginHistoryService;

	@Autowired
	private UserService userService;

	@GetMapping(value="/registration/doctor")
	public ModelAndView registrationDoctor(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.addObject("isDoctor", true);
		modelAndView.addObject("isHospital",false);
		modelAndView.addObject("isPatient",false);
		modelAndView.setViewName("doctor/registration");
		return modelAndView;
	} 
	
    @PostMapping(value = "/registration/doctor")
    public ModelAndView createNewDoctor(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUserName(user.getUserName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            User createdUser = userService.saveUser(user,3);
            Doctor doctor = new Doctor();
            doctor.setUserId(createdUser.getId());
            doctorService.saveDoctor(doctor);
            modelAndView.addObject("successMessage", "Doctor has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("doctor/registration");

        }
        return modelAndView;
    }

	@GetMapping(value="/doctor/home")
	public ModelAndView doctorHome(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		LoginHistory loginHistory = new LoginHistory(new Date(),request.getRemoteAddr(),request.getHeader("User-Agent"));
		loginHistory.setUser(user);
		loginHistoryService.saveLoginHistory(loginHistory);
		modelAndView.addObject("loginHistory", loginHistory);
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName()  + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Doctor Role");
		modelAndView.setViewName("doctor/home");
		return modelAndView;
	}
}
