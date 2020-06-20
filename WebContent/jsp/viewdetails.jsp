
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info Page</title>
</head>
<body>
<center><h1>User Info Page</h1></center>
<form:form method="post" modelAttribute ="user" action="/user-web/processgetuser.do">
      <table>
          <tr>
              <td>User Id:</td>
              <td><form:input path="userId" /></td>
          </tr>
         
          <br/>
              <td colspan="2">
                  <input type="submit" value="View Details" />   
              </td>
          </tr>
      </table>

</form:form>
</body>
</html>