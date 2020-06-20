<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>Spring Controller Example</h2>

<table>
<tr>
<td>First Name :</td><td>${user.firstName}</td>
</tr>

<tr>
<td>Last Name :</td><td>${user.lastName}</td>
</tr>


<tr>
<td>Middle Name :</td><td>${user.middleName}</td>
</tr>
</table>

</body>
</html>