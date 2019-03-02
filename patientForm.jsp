<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Entry</title>
<%@ include file="header.jsp"%>

</head>
<body>
	<div class="container jumbotron">
		<div class="row col-md-12">
			<div class="col-md-2"></div>
			<div class="col-md-8 jumbotron">
				<fieldset style="width: 500px">
					<legend>Patient Entry</legend>
					<form action="PatientController" method="post"
						class="form-horizontal">
						<span> <input type="hidden" name="id"
							value="${patient.id }" class="form-control">
						</span>

						<div class="form-group">
							<label>Patient Name</label> <input type="text" name="pname"
								value="${patient.patientName }" class="form-control">
						</div>
						<div class="form-group">
							<label>Address</label> <input type="text" name="address"
								value="${patient.address }" class="form-control">
						</div>

						<div class="form-group">
							<label>Contact</label> <input type="tel" name="telNo"
								value="${patient.contact }" class="form-control">
						</div>


						<div class="form-group">
							<label>Age</label> <input type="number" name="age"
								value="${patient.age }" class="form-control">
						</div>

						<div class="form-group">
							<label>Gender</label> <input type="radio" name="gender"
								value="Male" ${patient.gender=='Male'?'checked':''}>Male
							<input type="radio" name="gender" value="Female"
								${patient.gender=='Female'?'checked':''}>Female

						</div>

						<div class="form-group">
							<label>Problems On</label> <input type="checkbox" name="problems"
								value="Eye"
								<c:if test="${fn:contains(patient.problems, 'Eye')}">checked</c:if>>Eye
							<input type="checkbox" name="problems" value="Skin"
								<c:if test="${fn:contains(patient.problems, 'Skin')}">checked</c:if>>Skin
							<input type="checkbox" name="problems" value="Heart"
								<c:if test="${fn:contains(patient.problems, 'Heart')}">checked</c:if>>Heart

							<input type="checkbox" name="problems" value="Ear&Nose"
								<c:if test="${fn:contains(patient.problems, 'Ear&Nose')}">checked</c:if>>Ear
							& Nose <input type="checkbox" name="problems" value="Brain"
								<c:if test="${fn:contains(patient.problems, 'Brain')}">checked</c:if>>Brain
							<input type="checkbox" name="problems" value="Other"
								<c:if test="${fn:contains(patient.problems, 'Other')}">checked</c:if>>Other
						</div>
						<div class="form-group">
							<label>Day You Prefer</label> <select name="day"
								class="form-control">
								<option value="Sunday" ${patient.day=='Sunday'?'selected':''}>Sunday</option>
								<option value="Monday" ${patient.day=='Monday'?'selected':''}>Monday</option>
								<option value="Tuesday" ${patient.day=='Tuesday'?'selected':''}>Tuesday</option>
								<option value="Wednesday"
									${patient.day=='Wednesday'?'selected':''}>Wednesday</option>
								<option value="Thursday"
									${patient.day=='Thursday'?'selected':''}>Thursday</option>
								<option value="Friday" ${patient.day=='Friday'?'selected':''}>Friday</option>
								<option value="Saturday"
									${patient.day=='Saturday'?'selected':''}>Saturday</option>

							</select>


						</div>
						<div class="form-group">
							<label>Time You Prefer</label> <select name="time"
								class="form-control">
								<option value="6:00 to 10:00 AM"
									${patient.time=='6:00 to 10:00 AM'?'selected':''}>6:00
									to 10:00 AM</option>
								<option value="11:00 AM to 2:00 PM"
									${patient.time=='11:00 AM to 2:00 PM'?'selected':''}>11:00
									AM to 2:00 PM</option>
								<option value="2:30 to 6:00 PM"
									${patient.time=='2:30 to 6:00 PM'?'selected':''}>2:30
									to 6:00 PM</option>
								<option value="Not Fixed"
									${patient.time=='Not Fixed'?'selected':''}>Not Fixed</option>

							</select>


						</div>
						<div class="form-group">
							<input type="submit" value="Submit" class="form-control">
						</div>



					</form>
				</fieldset>
			</div>

			<div class="col-md-2"></div>
		</div>
	</div>


</body>
</html>