package com.kshitij.patientController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kshitij.patient.dao.PatientDao;
import com.kshitij.patient.dao.PatientDaoImpl;
import com.kshitij.patient.dto.Patient;

@WebServlet("/PatientController")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PatientDao patientDao = new PatientDaoImpl();
	private static final String PATIENT_LIST = "patientDetail.jsp";
	private static final String PATIENT_NEW = "patientForm.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("actions");
		String forward = "";
		if (action.equals("patient_new")) {
			forward = PATIENT_NEW;

		} else if (action.equals("patient_edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("patient", patientDao.getPatientInfoById(id));
			forward = PATIENT_NEW;

		} else if (action.equals("patient_delete")) {

			int id = Integer.parseInt(request.getParameter("id"));
			patientDao.deletePatientInfo(id);
			request.setAttribute("patients", patientDao.getAllPatientInfo());
			forward = PATIENT_LIST;
		} else if (action.equals("patient_list")) {

			request.setAttribute("patients", patientDao.getAllPatientInfo());
			forward = PATIENT_LIST;
		}

		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Patient patient = new Patient();

		patient.setPatientName(request.getParameter("pname"));
		patient.setAddress(request.getParameter("address"));
		patient.setContact(request.getParameter("telNo"));
		patient.setDay(request.getParameter("day"));
		patient.setTime(request.getParameter("time"));
		patient.setGender(request.getParameter("gender"));
		patient.setAge(Integer.parseInt(request.getParameter("age")));
		

		String[] problem = request.getParameterValues("problems");
		String problemssss = "";
		for (String pro : problem) {

			problemssss = problemssss + pro + "/";
		}

		patient.setProblems(problemssss);
		
		String patientId=request.getParameter("id");
		
		if (patientId==null || patientId.isEmpty()) {
			
			patientDao.savePatientInfo(patient);
		}
		
		else {
			patient.setId(Integer.parseInt(patientId));
			patientDao.updatePatientInfo(patient);
		}

		
		response.sendRedirect("PatientController?actions=patient_list");
	}

}
