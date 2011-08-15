<%@include file="include/include.jsp" %>
<h1>
	News 
	<c:if test="${sessionScope.user != null}"> - <a id="create" href="#">create</a></c:if>
</h1>
<br />
<div id="show">
	<c:forEach var="item" items="${news}">
		<fieldset style="padding:5px 10px 10px 10px;border:2px solid #fff;">
		<legend><h4><a href="/golf/news/${item.id}">${item.title}</a></h4></legend>
		<h5>Created by ${item.user.fname} ${item.user.lname} on <fmt:formatDate value="${item.timestamp}" type="both" /></h5>
		${item.content}
		</fieldset>
		<br />
	</c:forEach>
</div>
<c:if test="${sessionScope.user != null}">
	<div id="new">
		<h1>Create News</h1>
		<form action="/golf/save_news" method="POST" >
			<input type="hidden" name="action" value="edit" />
			<table>
				<tr>
					<td align="right">title: </td>
					<td><input type="text" name="title" value="" /></td>
				</tr>
				<tr>
					<td align="right" valign="top">content: </td>
					<td><textarea rows="5" cols="30" name="content"></textarea></td>
				</tr>
					<tr>
					<td align="right" colspan="3"><br /><input type="submit" value=" Save! " /></td>
				</tr>
			</table>
		</form>
	</div>
	
	<script language="javascript">
	$("#new").hide() ;
	$("#create").click(function(){
		$("#show").hide() ;
		$("#new").show() ;
	}) ;
	</script>
</c:if>