package com.kshitij.patient.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kshitij.patient.dto.Patient;
import com.kshitij.patient.util.DbUtil;

public class PatientDaoImpl implements PatientDao {
	PreparedStatement ps = null;
	
	@Override
	public void updatePatientInfo(Patient patient) {

		String sql = "update patient_table set patient_name=?, patient_address=?, patient_contact=?, day=?, time=?, age=?, problems=?, gender=? where id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, patient.getPatientName());
			ps.setString(2, patient.getAddress());
			ps.setString(3, patient.getContact());
			ps.setString(4, patient.getDay());
			ps.setString(5, patient.getTime());
			ps.setInt(6, patient.getAge());
			ps.setString(7, patient.getProblems());
			ps.setString(8, patient.getGender());
			ps.setInt(9, patient.getId());
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public void savePatientInfo(Patient patient) {
		String sql = "insert into patient_table(patient_name, patient_address, patient_contact, day, time, age, problems, gender)values(?,?,?,?,?,?,?,?)";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, patient.getPatientName());
			ps.setString(2, patient.getAddress());
			ps.setString(3, patient.getContact());
			ps.setString(4, patient.getDay());
			ps.setString(5, patient.getTime());
			ps.setInt(6, patient.getAge());
			ps.setString(7, patient.getProblems());
			ps.setString(8, patient.getGender());

			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Patient> getAllPatientInfo() {

		String sql = "select * from patient_table";
		List<Patient> patientList = new ArrayList<>();
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Patient patient = new Patient();
				patient.setId(rs.getInt("id"));
				patient.setPatientName(rs.getString("patient_name"));
				patient.setAddress(rs.getString("patient_address"));
				patient.setContact(rs.getString("patient_contact"));
				patient.setDay(rs.getString("day"));
				patient.setTime(rs.getString("time"));
				patient.setAge(rs.getInt("age"));
				patient.setProblems(rs.getString("problems"));
				patient.setGender(rs.getString("gender"));
				patientList.add(patient);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@Override
	public void deletePatientInfo(int id) {
		String sql = "delete from patient_table where id=?";
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Patient getPatientInfoById(int id) {

		String sql = "select * from patient_table where id=?";
		Patient patient = new Patient();
		try {
			ps = DbUtil.getConnection().prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				patient.setId(rs.getInt("id"));
				patient.setPatientName(rs.getString("patient_name"));
				patient.setAddress(rs.getString("patient_address"));
				patient.setContact(rs.getString("patient_contact"));
				patient.setDay(rs.getString("day"));
				patient.setTime(rs.getString("time"));
				patient.setAge(rs.getInt("age"));
				patient.setProblems(rs.getString("problems"));
				patient.setGender(rs.getString("gender"));

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return patient;
	}

	

	}


