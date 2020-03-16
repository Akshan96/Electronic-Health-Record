package com.ehr.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ehr.model.Patient;
import com.ehr.model.Doctor;
import com.ehr.model.LoginHistory;
import com.ehr.model.User;
import com.ehr.service.PatientService;
import com.ehr.service.DoctorService;
import com.ehr.service.LoginHistoryService;
import com.ehr.service.UserService;

@Controller
public class PatientController 
{
	@Autowired
	private PatientService patientService;

	@Autowired
	private LoginHistoryService loginHistoryService;

	@Autowired
	private UserService userService;

	@GetMapping(value="/registration/patient")
	public ModelAndView registrationPatient(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.addObject("isDoctor", false);
		modelAndView.addObject("isHospital",false);
		modelAndView.addObject("isPatient",true);
		modelAndView.setViewName("patient/registration");
		return modelAndView;
	}
	
	@PostMapping(value = "/admin/p/verify")
	 public String verifyPatient(@Valid Patient patient) {
			Patient patient1 = patientService.findByUserId(patient.getUserId());
			patient1.setVerified(true);
			patientService.savePatient(patient1);
			return "redirect:/admin/home";  
	 }
	
	@PostMapping(value = "/registration/patient")
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
            User createdUser = userService.saveUser(user,2);
            Patient patient = new Patient();
            patient.setUserId(createdUser.getId());
            patientService.savePatient(patient);
            modelAndView.addObject("successMessage", "Patient has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("patient/registration");

        }
        return modelAndView;
	}
        
        @GetMapping(value="/patient/home")
    	public ModelAndView doctorHome(HttpServletRequest request, Model model){
    		ModelAndView modelAndView = new ModelAndView();
    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		User user = userService.findUserByUserName(auth.getName());
    		LoginHistory loginHistory = new LoginHistory(new Date(0),request.getRemoteAddr(),request.getHeader("User-Agent"));
    		loginHistory.setUser(user);
    		loginHistoryService.saveLoginHistory(loginHistory);
    		modelAndView.addObject("loginHistory", loginHistory);
    		modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName()  + " (" + user.getEmail() + ")");
    		Patient patient = patientService.findByUserId(user.getId());
    		System.out.println(" PATIENT ID: "+patient.getPatientId());
    		modelAndView.addObject("patientId", patient.getPatientId());
    		modelAndView.addObject("adminMessage","Content Available Only for Users with patient Role");
    		modelAndView.setViewName("patient/home");
    		modelAndView.addObject("patientProfile", patient);
    		return modelAndView;
    	}
        
        @PostMapping("/patient/updateProfile")
    	public String updatePatientProfile(@Valid Patient patient) {
    	    patientService.savePatient(patient);
    	    return "redirect:/patient/home";
    	}
    	
    }


