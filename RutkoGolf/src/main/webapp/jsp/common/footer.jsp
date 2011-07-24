<%@include file="../include/include.jsp" %>
<jsp:useBean id="currentDate" class="java.util.Date" />
<fmt:formatDate var="currentYear" value="${currentDate}" pattern="yyyy" />
<div id="footer">Copyright &copy;${currentYear} RutkoGolf.  All rights reserved.</div>