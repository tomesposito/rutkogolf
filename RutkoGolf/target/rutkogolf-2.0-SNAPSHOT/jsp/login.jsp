<%@include file="include/include.jsp" %>
<h2>Login</h2>
<c:if test="${user eq 'fail'}">
<h1>login failed, please try again</h1>
</c:if>
<form id="loginform" action="login" method="POST">
<table>
	<tr>
		<td align="right">username: </td>
		<td><input type="text" id="user" name="user" /></td>
	</tr>
	<tr>
		<td align="right">password: </td>
		<td><input type="password" id="pass" name="pass" /></td>
	</tr>
	<tr>
		<td align="right" colspan="3"><br /><input type="submit" name="login" value=" Login! " /></td>
	</tr>
</table>
</form>
<script language="javascript">
	$('#user').focus() ;
</script>