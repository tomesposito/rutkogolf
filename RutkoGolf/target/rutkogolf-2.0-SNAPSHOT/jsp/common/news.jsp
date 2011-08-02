<%@include file="../include/include.jsp"%>
<div id="right">
	<h2>
		<a href="/golf/news">Latest news</a>
	</h2>
	<c:forEach var="item" items="${news}" varStatus="status">
		<c:if test="${status.count <= 5}">
			<h3>
				<a href="/golf/news/${item.id}">${item.title}</a>
			</h3>
			<h5>${item.user.fname} - <fmt:formatDate value="${item.timestamp}" type="both" /></h5>
			${item.content}
			<br /><br />
		</c:if>
	</c:forEach>
</div>