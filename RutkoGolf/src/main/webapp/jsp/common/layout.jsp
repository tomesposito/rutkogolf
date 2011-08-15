<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en" dir="ltr" id="website" class="no-js">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/css_screen.css" media="screen">
<link rel="stylesheet" href="/css/nav.css" type="text/css" media="screen"/>
<script src="/js/jquery-1.4.4.min.js" type="text/javascript"></script>
<link rel="icon" href="/img/favicon.ico">
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
<tiles:insertAttribute name="login" />
<div id="main">
	<div id="header">
	<tiles:insertAttribute name="masthead" />
	</div>
	
	<tiles:insertAttribute name="nav" />
	
	<div id="content">
	  <div id="left">
	    <tiles:insertAttribute name="content" />
	  </div>
	  
    <tiles:insertAttribute name="news" />
	</div>

</div>
<tiles:insertAttribute name="footer" />
</body>
</html>