<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Update User</title>
</head>
<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">
	<center>

		<h2>Update User</h2>

	</center>

	<!--Body: add contact information-->

	<center>
		<form method="post" action="/user-web/processupdateuser.do">

			<table cellpadding="0" cellspacing="0" width="50%"">
				
				<tr>

					<td bgcolor="#FAFAF9" style="padding-left: 10px;">User Id</td>

					<td><input type="text" name="userId" maxlength="12"
						value=${user.userId} /></td>

				</tr>

				<tr>

					<td bgcolor="#FAFAF9" style="padding-left: 10px;">First Name</td>

					<td><input type="text" name="firstName" maxlength="12"
						value=${user.firstName} /></td>

				</tr>
				<tr>
				
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Middle Name</td>

					<td><input type="text" name="middleName" maxlength="12"
						value=${user.middleName} /></td>

				</tr>
				<tr>
				
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">Last Name</td>

					<td><input type="text" name="lastName" maxlength="12"
						value=${user.lastName} /></td>

				</tr>
				<table  width="30%">
				<tr>
					<td><input type="submit" name="save" value="Update"/></td>
					<td width="201"><input type="reset" name="clear" value="Clear" />&nbsp;</td>
				</tr>
			</table>
			</td>

</body>

