
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Personal Info Page</title>
</head>
<body>
<center><h1>Personal Info Page</h1></center>
<form:form method="post" modelAttribute ="user" action="/user-web/processgetdtlsforupdateuser.do">
     <table  cellpadding="0" cellspacing="0" width="50%"">
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">User ID:</td>
			<td><form:input path="userId" maxlength="50"  /></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<br>
			<table  width="50%">
				<tr>
					<td><input type="submit" name="save" value="Modify"/></td>
					<td width="201"><input type="reset" name="clear" value="Clear" />&nbsp;</td>
				</tr>
			</table>
</form:form>
</body>
</html>