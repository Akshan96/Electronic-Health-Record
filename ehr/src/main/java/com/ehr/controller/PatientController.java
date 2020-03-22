package com.ehr.controller;

import java.sql.Date;
import java.util.List;

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
import com.ehr.model.Consultation;
import com.ehr.model.Doctor;
import com.ehr.model.LoginHistory;
import com.ehr.model.User;
import com.ehr.model.MedicalHistory;
import com.ehr.service.PatientService;
import com.ehr.service.DoctorService;
import com.ehr.service.LoginHistoryService;
import com.ehr.service.UserService;
import com.ehr.service.MedicalHistoryService;

@Controller
public class PatientController 
{
	@Autowired
	private PatientService patientService;

	@Autowired
	private LoginHistoryService loginHistoryService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private MedicalHistoryService MedicalHistoryService;

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
    	public ModelAndView patientHome(HttpServletRequest request, Model model){
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
    		modelAndView.addObject("patientProfile", patient);
    		modelAndView.setViewName("patient/home");
    		return modelAndView;
    	}
        
        @GetMapping(value="/patient/MedicalHistory/{patientId}")
        public String showUpdateForm(@PathVariable("patientId") int patientId, Model model) {
        	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		User user = userService.findUserByUserName(auth.getName());
    		//Patient patient = patientService.findByUserId(user.getId());
    		//System.out.println(" PATIENT ID: "+patient.getId());
    		//model.addAttribute("patient", patient);
            //System.out.println("Medical History ID: "+medicalhistoryId);
            Patient patient = patientService.findById(patientId);
            MedicalHistory medicalhistories = MedicalHistoryService.findById(patientId);
    		//List<Consultation> consultations = consultationService.findAllByPatientId(patientId);
    		//System.out.println("L: "+consultations);
            model.addAttribute("patient", patient);
            model.addAttribute("medicalhistories", medicalhistories);
            MedicalHistory medicalhistory = new MedicalHistory();
            model.addAttribute("medicalhistory", medicalhistory);
            return "patient/MedicalHistory";
          
        }
        
        
        @PostMapping("/patient/updateProfile")
    	public String updatePatientProfile(@Valid Patient patient) {
    	    patientService.savePatient(patient);
    	    return "redirect:/patient/home";
    	}
    	
    }


