<%@include file="include/include.jsp" %>
<div id="show">
	<fieldset style="padding:5px 10px 10px 10px;border:2px solid #fff;">
		<legend><h1>${news_item.title}</h1></legend>
		<p><strong>Author:</strong> ${news_item.user.fname} ${news_item.user.lname}</p>
		<p><strong>Posted:</strong> <fmt:formatDate value="${news_item.timestamp}" type="both" /></p>
		<p><strong>Message:</strong> ${news_item.content}</p>
		<c:if test="${sessionScope.user != null}">
			<p><a id="edit_news" href="#">edit</a> | <a id="delete_news" href="#">delete</a></p>
		</c:if>
	</fieldset>
</div>
<c:if test="${sessionScope.user != null}">
	<div id="edit">
		<h1>Edit item #${news_item.id}</h1>
		<form action="/golf/save_news" method="POST" >
			<input type="hidden" name="action" value="edit" />
			<input type="hidden" name="id" value="${news_item.id}" />
			<table>
				<tr>
					<td align="right">title: </td>
					<td><input type="text" name="title" value="${news_item.title}" /></td>
				</tr>
				<tr>
					<td align="right" valign="top">content: </td>
					<td><textarea rows="5" cols="30" name="content">${news_item.content}</textarea></td>
				</tr>
				<tr>
					<td align="right" colspan="3"><br /><input type="submit" value=" Save! " /></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="delete">
		<form action="/golf/save_news" id="delete_form" method="POST" >
			<input type="hidden" name="action" value="delete" />
			<input type="hidden" name="id" value="${news_item.id}" />
		</form>
	</div>
	<script language="javascript">
	$("#edit").hide() ;
	$('#edit_news').click(function() {
		  $("#show").hide() ;
		  $("#edit").show() ;
	});
	$('#delete_news').click(function(){
		var ans = confirm("Delete? For real?") ;
		if(ans){
			$('#delete_form').submit() ;
		}
	}) ;
	</script>
</c:if>