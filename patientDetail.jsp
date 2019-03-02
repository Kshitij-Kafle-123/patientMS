<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
<%@ include file="header.jsp"%>

</head>
<body>
	<a href="PatientController?actions=patient_new">New Patient</a>
	<c:if test="${!empty patients}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>SN</th>
					<th>ID</th>
					<th>Patient Name</th>
					<th>Address</th>
					<th>Contact</th>
					<th>Preferable Day</th>
					<th>Preferable Time</th>
					<th>Age</th>
					<th>Problems</th>
					<th>Gender</th>
					<th>Actions</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${patients}" var="p" varStatus="d">
					<tr>
						<td><c:out value="${d.count}" /></td>
						<td><c:out value="${p.id}" /></td>
						<td><c:out value="${p.patientName}" /></td>
						<td><c:out value="${p.address}" /></td>
						<td><c:out value="${p.contact}" /></td>
						<td><c:out value="${p.day}" /></td>
						<td><c:out value="${p.time}" /></td>
						<td><c:out value="${p.age}" /></td>
						<td><c:out value="${p.problems}" /></td>
						<td><c:out value="${p.gender}" /></td>
						<td>
						<a href="PatientController?actions=patient_delete&id=${p.id}">Delete</a>
						|<a href="PatientController?actions=patient_edit&id=${p.id}">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
<img src="image\l.jpg" style="position: relative;"><span style="position: absolute; top: 0px; right: 5px;"></span></img>
</body>
</html>