<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Info Page</title>
</head>
<body>
	<center>
		<h1>DeleteInfo DetailsPage</h1>
	</center>
	<form:form method="post" modelAttribute="user" action="/user-web/processdeleteuser.do" >
		
		<table>
			<tr>
				<td><font color="blue" size=3>Enter UserId To Be
						Deleted:</font></td><br/>
				<td><form:input path="userId" /></td>
			</tr>
			
			<center>
		<br/>	<td colspan="2"><input type="submit" value="Delete User" /></td><br/>
			
		</table>
		</center>
	</form:form>
</body>
</html>