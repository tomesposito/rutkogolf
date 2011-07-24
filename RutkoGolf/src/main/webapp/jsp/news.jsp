<%@include file="include/include.jsp" %>
<h1>
	News 
	<c:if test="${sessionScope.user != null}"> - <a id="create" href="#">create</a></c:if>
</h1>
<div id="show">
	<c:forEach var="item" items="${news}">
		<h3><a href="/rutkogolf/golf/news/${item.id}">${item.title}</a></h3>
		<h5>Created by ${item.user.fname} ${item.user.lname} on <fmt:formatDate value="${item.timestamp}" type="both" /></h5>
		${item.content}
		<br /><br /><br />
	</c:forEach>
</div>
<c:if test="${sessionScope.user != null}">
	<div id="new">
		<h1>Create News</h1>
		<form action="/rutkogolf/golf/save_news" method="POST" >
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