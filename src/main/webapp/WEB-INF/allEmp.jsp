<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<a href="add"> Add</a>
<title>Employee List</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>address</th>
				<th>action</th>
			</tr>
		</thead>
		<c:forEach var="employee" items="${empList}">
			<tbody>
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.address}</td>
					<td><a href="edit?id=${employee.id}">
						<button>edit</button>
					</a></td>
					<td><button>delet</button>
				</tr>
			</tbody>



		</c:forEach>
	</table>
</body>
</html>