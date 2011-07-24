<%@include file="include/include.jsp" %>
<script type="text/javascript">
	var sponsors =  [{}];
	
</script>
<h1>
	Sponsors
	<c:if test="${sessionScope.user != null}"> - <a id="create" href="#">new</a></c:if>
</h1>
<i>A special thank you to all of our sponsors for their support!</i>
<div id="show">
	<c:forEach var="sponsor" items="${sponsors}" varStatus="status">
	<script type="text/javascript">
		sponsors.push({"sponsor":{"id": "${sponsor.id}",
		                	   "name": "${sponsor.name}",
		                	   "desc": "${sponsor.description}",
		                	   "addr": "${sponsor.address}",
		                	   "city": "${sponsor.city}",
		                	   "state": "${sponsor.state}",
		                	   "zip": "${sponsor.zip}",
		                	   "phone": "${sponsor.phone}",
		                	   "website": "${sponsor.website}"}}) ;
	</script>
	<hr />
	<h1>
		${sponsor.name}
		<c:if test="${sessionScope.user != null}"> - 
			<a id="edit_link" href="javascript:edit(${status.count});">edit</a>
			|
			<a id="delete_link" href="javascript:del(${status.count});">delete</a>
		</c:if>
	</h1>
	<h4>${sponsor.description}</h4>
	<p>${sponsor.phone} <br />
	${sponsor.address}<br />
	${sponsor.city}, ${sponsor.state} ${sponsor.zip}<br />
	<a href="${sponsor.website}">${sponsor.website}</a></p>
	</c:forEach>
</div>
<c:if test="${sessionScope.user != null}">
	<div id="new">
		<h1>Create a Sponsor</h1>
		<form action="/rutkogolf/golf/sponsors" method="POST" >
			<input type="hidden" name="action" value="create" />
			<table>
				<tr>
					<td align="right">name: </td>
					<td><input type="text" name="name" value="" /></td>
				</tr>
				<tr>
					<td align="right" valign="top">description: </td>
					<td><textarea rows="5" cols="30" name="description"></textarea></td>
				</tr>
				<tr>
					<td align="right">address: </td>
					<td><input type="text" name="address" value="" /></td>
				</tr>
				<tr>
					<td align="right">city: </td>
					<td><input type="text" name="city" value="" /></td>
				</tr>
				<tr>
					<td align="right">state: </td>
					<td>
						<select name="state">
							<c:forEach var="state" items="${states}">
								<option value="${state}" <c:if test="${state eq 'IL' }">selected=selected</c:if>>${state}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">zipcode: </td>
					<td><input type="text" name="zip" value="" /></td>
				</tr>
				<tr>
					<td align="right">phone number: </td>
					<td><input type="text" name="phone" value="" /></td>
				</tr>
				<tr>
					<td align="right">website: </td>
					<td><input type="text" name="website" value="" /></td>
				</tr>
				<tr>
					<td align="right" colspan="3"><br /><input type="submit" value=" Save! " /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="edit">
		<h1>Edit Sponsor</h1>
		<form action="/rutkogolf/golf/sponsors" method="POST" >
			<input type="hidden" name="action" value="update" />
			<input type="hidden" id="edit_id" name="id" value="" />
			<table>
				<tr>
					<td align="right">name: </td>
					<td><input type="text" id="edit_name" name="name" value="" /></td>
				</tr>
				<tr>
					<td align="right" valign="top">description: </td>
					<td><textarea rows="5" cols="30" id="edit_desc" name="description"></textarea></td>
				</tr>
				<tr>
					<td align="right">address: </td>
					<td><input type="text" id="edit_addr" name="address" value="" /></td>
				</tr>
				<tr>
					<td align="right">city: </td>
					<td><input type="text" id="edit_city" name="city" value="" /></td>
				</tr>
				<tr>
					<td align="right">state: </td>
					<td>
						<select name="state">
							<c:forEach var="state" items="${states}">
								<option value="${state}" <c:if test="${state eq 'IL' }">selected=selected</c:if>>${state}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">zipcode: </td>
					<td><input type="text" id="edit_zip" name="zip" value="" /></td>
				</tr>
				<tr>
					<td align="right">phone number: </td>
					<td><input type="text" id="edit_phone" name="phone" value="" /></td>
				</tr>
				<tr>
					<td align="right">website: </td>
					<td><input type="text" id="edit_website" name="website" value="" /></td>
				</tr>
				<tr>
					<td align="right" colspan="3"><br /><input type="submit" value=" Save! " /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="delete">
		<form action="/rutkogolf/golf/sponsors" id="delete_form" method="POST" >
			<input type="hidden" name="action" value="delete" />
			<input type="hidden" id="delete_id" name="id" value="" />
		</form>
	</div>
	<script language="javascript">
	$("#new").hide() ;
	$("#edit").hide() ;
	$("#create").click(function(){
		$("#show").hide() ;
		$("#new").show() ;
	}) ;
	function edit(id){
		$("#edit_id").val(sponsors[id].sponsor.id) ;
		$("#edit_name").val(sponsors[id].sponsor.name) ;
		$("#edit_desc").val(sponsors[id].sponsor.desc) ;
		$("#edit_addr").val(sponsors[id].sponsor.addr) ;
		$("#edit_city").val(sponsors[id].sponsor.city) ;
		$("#edit_zip").val(sponsors[id].sponsor.zip) ;
		$("#edit_phone").val(sponsors[id].sponsor.phone) ;
		$("#edit_website").val(sponsors[id].sponsor.website) ;
		$("#show").hide() ;
		$("#edit").show() ;
	}
	function del(id){
		$("#delete_id").val(sponsors[id].sponsor.id) ;
		if(confirm("Are you sure you want to delete "+sponsors[id].sponsor.name+"?")){
			$("#delete_form").submit() ;
		}
	}
	</script>
</c:if>