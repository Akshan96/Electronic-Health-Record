package com.ehr.controller;

import com.ehr.model.Doctor;
import com.ehr.model.Hospital;
import com.ehr.model.LoginHistory;
import com.ehr.model.User;
import com.ehr.service.DoctorService;
import com.ehr.service.HospitalService;
import com.ehr.service.LoginHistoryService;
import com.ehr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private LoginHistoryService loginHistoryService;
    
    @Autowired
    private DoctorService doctorService;
    
    @Autowired
    private HospitalService hospitalService;

    @GetMapping(value={"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping(value="/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.addObject("isDoctor", false);
        modelAndView.addObject("isHospital",false);
        modelAndView.addObject("isPatient",true);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    
    @GetMapping(value="/registration/d")
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
    
    @GetMapping(value="/registration/h")
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
    
    

    @PostMapping(value = "/registration")
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
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
            userService.saveUser(user,2);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
    
    @PostMapping(value = "/registration/doc")
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

    @GetMapping(value="/admin/home")
    public ModelAndView home(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        LoginHistory loginHistory = new LoginHistory(new Date(),request.getRemoteAddr(),request.getHeader("User-Agent"));
        loginHistory.setUser(user);
        loginHistoryService.saveLoginHistory(loginHistory);
        modelAndView.addObject("loginHistory", loginHistory);
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("admin/home");
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
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Doctor Role");
        modelAndView.setViewName("doctor/home");
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
        modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Hospital Role");
        modelAndView.setViewName("hospital/home");
        return modelAndView;
    }


}
