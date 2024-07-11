<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table border="3">
<tr><td>State Name</td><td>User Name</td><td>Mobile</td><td>District Name</td></tr>
<c:forEach items="${lst}" var="bb">
<tr><td><c:out value="${bb.stName}"></c:out></td>
<td><c:out value="${bb.name}"></c:out></td>
<td><c:out value="${bb.mob}"></c:out></td>
<td><c:out value="${bb.distName}"></c:out></td>


</tr>

</c:forEach>
<tr><td><a href=downloadPDF>DOWNLOAD_PDF</a></td></tr>

</table>


</body>
</html>