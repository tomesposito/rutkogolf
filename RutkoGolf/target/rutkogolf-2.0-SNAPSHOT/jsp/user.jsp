<%@include file="include/include.jsp" %>
<c:choose>
	<c:when test="${sessionScope.user != null}">
		<div id="show">
			<h1>Welcome, ${user.fname} ${user.lname}</h1>
			<p><a id="change_pass_link" href="#">change password</a></p>
			<p><a id="create_user_link" href="#">create another user</a></p>
		</div>
		<div id="change_pass">
			<h1>Change Password</h1>
			<form action="/golf/update_user" method="post">
				<input type="hidden" name="action" value="changepass" />
				<input type="hidden" name="username" value="${user.username}" />
				<table>
					<tr>
						<td align="right">
							password: 
						</td>
						<td>
							<input type="password" id="pass" name="pass">
						</td>
					</tr>
					<tr>
						<td align="right">
							confirm: 
						</td>
						<td>
							<input type="password" id="confirm">
						</td>
						<td><span id="confirm_status"></span></td>
					</tr>
					<tr>
						<td align="right" colspan="2"><br /><input type="submit" id="submit_button" value=" Submit! "></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="create_user">
			<h1>Create a New User</h1>
			<form action="/golf/update_user" method="post">
				<input type="hidden" name="action" value="create" />
				<table>
					<tr>
						<td align="right">
							username: 
						</td>
						<td>
							<input type="text" id="username" name="username">
						</td>
					</tr>
					<tr>
						<td align="right">
							password: 
						</td>
						<td>
							<input type="password" id="pass2" name="pass">
						</td>
					</tr>
					<tr>
						<td align="right">
							confirm: 
						</td>
						<td>
							<input type="password" id="confirm2">
						</td>
						<td><span id="confirm_status2"></span></td>
					</tr>
					<tr>
						<td align="right">
							first name: 
						</td>
						<td>
							<input type="text" name="fname">
						</td>
					</tr>
					<tr>
						<td align="right">
							last name: 
						</td>
						<td>
							<input type="text" name="lname">
						</td>
					</tr>
					<tr>
						<td align="right" colspan="2"><br /><input type="submit" id="submit_button2" value=" Submit! "></td>
					</tr>
				</table>
			</form>
		</div>
		<script type="text/javascript">
			$("#create_user").hide() ;
			$("#change_pass").hide() ;
			
			$("#change_pass_link").click(function(){
				$("#show").hide() ;
				$("#change_pass").show() ;
				$("#pass").focus() ;
			}) ;
			$("#create_user_link").click(function(){
				$("#show").hide() ;
				$("#create_user").show() ;
				$("#username").focus() ;
			}) ;
			$("#confirm").keyup(function(){
				if($("#pass").val() === $("#confirm").val()){
					$("#confirm_status").html("<i style='color:green;'>confirmed</i>") ;
					$("#submit_button").attr('disabled', '');
				}else{
					$("#confirm_status").html("<i style='color:red;'>not confirmed!</i>") ;
					$("#submit_button").attr('disabled', 'disabled');
				}
			}) ;
			$("#confirm2").keyup(function(){
				if($("#pass2").val() === $("#confirm2").val()){
					$("#confirm_status2").html("<i style='color:green;'>confirmed</i>") ;
					$("#submit_button2").attr('disabled', '');
				}else{
					$("#confirm_status2").html("<i style='color:red;'>not confirmed!</i>") ;
					$("#submit_button2").attr('disabled', 'disabled');
				}
			}) ;
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			$(location).attr('href', '/golf/home') ;
		</script>
	</c:otherwise>
</c:choose>