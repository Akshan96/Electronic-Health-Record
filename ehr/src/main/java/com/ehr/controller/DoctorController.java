package com.ehr.controller;

import java.util.Date;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ehr.model.Consultation;
import com.ehr.model.Doctor;
import com.ehr.model.LoginHistory;
import com.ehr.model.Patient;
import com.ehr.model.RolePermission;
import com.ehr.model.User;
import com.ehr.service.ConsultationService;
import com.ehr.service.DoctorService;
import com.ehr.service.LoginHistoryService;
import com.ehr.service.PatientService;
import com.ehr.service.RolePermissionService;
import com.ehr.service.UserService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private ConsultationService consultationService;

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
	
	 @PostMapping(value = "/admin/d/verify")
	 public String verifyDoctor(@Valid Doctor doctor) {
			Doctor doctor1 = doctorService.findByUserId(doctor.getUserId());
			doctor1.setVerified(true);
			doctorService.saveDoctor(doctor1);
			return "redirect:/admin/home";  
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
	public ModelAndView doctorHome(HttpServletRequest request, Model model){
		ModelAndView modelAndView = new ModelAndView();
		boolean isMedicalHistory = false;
		boolean isConsultation = false;
		boolean isInsurence = false;
		boolean isPatientDetails = false;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		LoginHistory loginHistory = new LoginHistory(new Date(),request.getRemoteAddr(),request.getHeader("User-Agent"));
		loginHistory.setUser(user);
		loginHistoryService.saveLoginHistory(loginHistory);
		RolePermission permission = rolePermissionService.findByUserId(user.getId());
		if(permission != null) {
			isMedicalHistory = permission.isMedicalHistory();
			isConsultation = permission.isConsultation();
			isInsurence = permission.isInsurence();
			isPatientDetails = permission.isPatientInfo();
		}
		modelAndView.addObject("isMedicalHistory", isMedicalHistory);
		modelAndView.addObject("isConsultation", isConsultation);
		modelAndView.addObject("isInsurence", isInsurence);
		modelAndView.addObject("isPatientDetails", isPatientDetails);
		modelAndView.addObject("loginHistory", loginHistory);
		modelAndView.addObject("userName", "Welcome " + user.getUserName() + "/" + user.getName()  + " (" + user.getEmail() + ")");
		Doctor doctor = doctorService.findByUserId(user.getId());
		System.out.println(" DOCTOR ID: "+doctor.getId());
		modelAndView.addObject("doctorId", doctor.getId());
		modelAndView.addObject("adminMessage","Content Available Only for Users with Doctor Role");
		modelAndView.setViewName("doctor/home");
		modelAndView.addObject("doctorProfile", doctor);
		//Patients Information
		List<Patient> patients = patientService.getAllPatients();
        modelAndView.addObject("patients", patients);
		return modelAndView;
	}
	
	@PostMapping("/doctor/updateProfile")
	public String updateDoctorProfile(@Valid Doctor doctor) {
	    doctorService.saveDoctor(doctor);
	    return "redirect:/doctor/home";
	}
	 
    
    @GetMapping("/doctor/patientDetails/{patientId}")
    public String showUpdateForm(@PathVariable("patientId") int patientId, Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		Doctor doctor = doctorService.findByUserId(user.getId());
		System.out.println(" DOCTOR ID: "+doctor.getId());
		model.addAttribute("doctor", doctor);
        System.out.println("Patient Details patient ID: "+patientId);
        Patient patient = patientService.findById(patientId);
		List<Consultation> consultations = consultationService.findAllByPatientId(patientId);
		System.out.println("L: "+consultations);
        model.addAttribute("patient", patient);
        model.addAttribute("consultations", consultations);
        Consultation consultation = new Consultation();
        model.addAttribute("consultation", consultation);
        return "doctor/patient_details";
    }
    
    @PostMapping("/doctor/addConsultation")
   	public String addConsultation(@Valid Consultation consultation, RedirectAttributes redirectAttributes) {
   	    consultationService.saveConsultation(consultation);
   	    int patientId = consultation.getPatientId();
   	    //redirectAttributes.addAttribute(patientId);
   	    return "redirect:/doctor/patientDetails/"+patientId;
   	}
}
