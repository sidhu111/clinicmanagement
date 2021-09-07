package com.htc.clinicmanagement.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.htc.clinicmanagement.entity.Patient;

public interface PatientInterface extends JpaRepository<Patient, Long>{

}
