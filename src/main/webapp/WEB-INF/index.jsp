 <%@ taglib uri="http://www.springframework.org/tags" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<html>
 <head> 
<h2>Hello World!</h2>
<a href = "allEmp"> show employee</a>
</head>
<body>
<form action="add" method ="GET">
ID<input type="number" name = "id" value ="${employee.id }" >
NAME<input type="text" name ="name" value ="${employee.name}">
ADDRESS<input type="text"  name = "address" value="${employee.address}">
 <input type="submit" value="${isEdit?'edit':'save'}" name = "action">
</form>
${message}
</body>
</html>
