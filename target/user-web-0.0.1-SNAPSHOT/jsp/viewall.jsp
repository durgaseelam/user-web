<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Info Page</title>
</head>
<body>
	<center>
		<h1>View All Users</h1>

		<form:form method="post" modelAttribute="user">
			<table border="1" cellpadding="5">
				<caption>
					<h2>All Users in User Table</h2>
				</caption>
				<tr>
					<th>UserId</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>MiddleName</th>
				</tr>
				<c:forEach items="${users}" var="id">
					<tr>
						<td><c:out value="${id.userId}" /></td>
						<td><c:out value="${id.firstName}" /></td>
						<td><c:out value="${id.lastName}" /></td>
						<td><c:out value="${id.middleName}" /></td>

					</tr>

				</c:forEach>
			</table>
	</center>
	</form:form>
</body>
</html>