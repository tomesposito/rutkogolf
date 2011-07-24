<%@include file="../include/include.jsp" %>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="/rutkogolf/js/shadowbox/shadowbox.css">
<script type="text/javascript" src="/rutkogolf/js/shadowbox/shadowbox.js"></script>
<script type="text/javascript">
	Shadowbox.init({
		handleOversize: "resize",
	  counterType: "skip"
	});
</script>
<div id="logo_w1">Rutkowski</div>
<div id="logo_w2">Invitational Golf Outing</div>
<div id="login">
<c:choose>
	<c:when test="${sessionScope.user != null}">
		<a href="/rutkogolf/golf/user">${user.fname}</a> |
		<a href="/rutkogolf/golf/logout">logout</a>
	</c:when>
	<c:otherwise>
		<a href="/rutkogolf/golf/login">login</a>
	</c:otherwise>
</c:choose>
</div>
<div id="header_text">
        <p>Come out and join us as we "drive for a cure"</p>
        <a href="/rutkogolf/golf/signup">Sign Up Now!</a>
</div>