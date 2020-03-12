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

}
