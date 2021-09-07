package com.htc.clinicmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htc.clinicmanagement.entity.Patient;
import com.htc.clinicmanagement.persistence.PatientInterface;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api")
public class PatientController {
	
	@Autowired
	private PatientInterface patientInterface;
	
	
	@GetMapping("/patients/{patientId}") 
	public Patient getPatientById(@PathVariable Long patientId) {
		Patient patient =null;
	
		patient=patientInterface.findById(patientId).get();
		return patient;
		
	}
//	
//	@GetMapping("/patientsupdate/{patientId}")
//	public Patient updateById(@PathVariable Long patientId) {
//		patient=patientInterface.u
//		return patient;
//	}
	
	@GetMapping("/patients")
	public List<Patient> getAllPatientss(){
		return patientInterface.findAll();
	}
	
	
	@PostMapping("/addpatients") 
	public Patient createProduct(@RequestBody Patient patient) {
		   
		 return patientInterface.save(patient);
	}
	@PutMapping("/patients/{patientId}")
	Patient replacePatient(@RequestBody Patient newPatient, @PathVariable Long patientId) {
	    
	    return patientInterface.findById(patientId)
	      .map(patient -> {
	    	  patient.setPhoneNumber(newPatient.getPhoneNumber());
	        return patientInterface.save(patient);
	      })
	      .orElseGet(() -> {
	    	  newPatient.setPatientId(patientId);
	        return patientInterface.save(newPatient);
	      });
	  }

	@DeleteMapping("/patients/{patientId}")
	  void deletePatient(@PathVariable Long patientId) {
		patientInterface.deleteById(patientId);
	  }

	
	
}


