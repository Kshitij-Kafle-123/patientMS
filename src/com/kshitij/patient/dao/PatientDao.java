package com.kshitij.patient.dao;

import java.util.List;

import com.kshitij.patient.dto.Patient;

public interface PatientDao {
	
	public void savePatientInfo(Patient patient);
	public void updatePatientInfo(Patient patient);
	public List<Patient> getAllPatientInfo();
	public void deletePatientInfo(int id);
	public Patient getPatientInfoById(int id);
	

}
