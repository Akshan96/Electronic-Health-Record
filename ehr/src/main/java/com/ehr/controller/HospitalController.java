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
import com.ehr.model.Hospital;
import com.ehr.model.LoginHistory;
import com.ehr.model.User;
import com.ehr.service.DoctorService;
import com.ehr.service.HospitalService;
import com.ehr.service.LoginHistoryService;
import com.ehr.service.UserService;

@Controller
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
    @Autowired
    private LoginHistoryService loginHistoryService;

	@Autowired
	private UserService userService;
	
    @GetMapping(value="/registration/hospital")
    public ModelAndView registrationHospital(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.addObject("isDoctor", false);
        modelAndView.addObject("isHospital",true);
        modelAndView.addObject("isPatient",false);
        modelAndView.setViewName("hospital/registration");
        return modelAndView;
    }
    
    @PostMapping(value = "/registration/hopsital")
    public ModelAndView createNewHospital(@Valid User user, BindingResult bindingResult) {
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
            User createdUser = userService.saveUser(user,4);
            Hospital hospital = new Hospital();
            hospital.setUserId(createdUser.getId());
            hospitalService.saveHospital(hospital);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @GetMapping(value="/hospital/home")
    public ModelAndView hospitalHome(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        LoginHistory loginHistory = new LoginHistory(new Date(),request.getRemoteAddr(),request.getHeader("User-Agent"));
        loginHistory.setUser(user);
        loginHistoryService.saveLoginHistory(loginHistory);
        modelAndView.addObject("loginHistory", loginHistory);
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Hospital Role");
        modelAndView.setViewName("hospital/home");
        Hospital hospital = hospitalService.findByUserId(user.getId());
		System.out.println(" hospital ID: "+hospital.getId());
		modelAndView.addObject("hospitalId", hospital.getId());
        modelAndView.addObject("hospitalProfile", hospital);
        return modelAndView;
    }
    
    @PostMapping("/hospital/updateProfile")
	public String updateHospitalProfile(@Valid Hospital hospital) {
		Hospital h = new Hospital();
		h.setId(hospital.getId());
		h.setUserId(hospital.getUserId());
		h.setAddress(hospital.getAddress());
	    h.setName(hospital.getName());
	    h.setPhoneNumber(hospital.getPhoneNumber());
	    hospitalService.saveHospital(h);
	    return "redirect:/hospital/home";
	}
}
