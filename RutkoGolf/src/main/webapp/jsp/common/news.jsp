<%@include file="../include/include.jsp"%>
<div id="right">
	<h1>
		<a style="font-size:18px;" href="/golf/news">Latest news</a>
	</h1>
	<br />
	<c:forEach var="item" items="${news}" varStatus="status">
		<c:if test="${status.count <= 5}">
			<fieldset style="padding:5px 10px 10px 10px;border:2px solid #fff;">
				<legend>
					<h4>
						<a href="/golf/news/${item.id}">${item.title}</a>
					</h4>
				</legend>
				<h5>${item.user.fname} - <fmt:formatDate value="${item.timestamp}" type="both" /></h5>
				${item.content}
			</fieldset>
			<br />
		</c:if>
	</c:forEach>
</div>