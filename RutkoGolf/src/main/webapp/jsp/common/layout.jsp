<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="/rutkogolf/css/style.css" rel="stylesheet" media="screen" type="text/css" />
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
<div id="container">
	<div id="header">
	<tiles:insertAttribute name="masthead" />
	<tiles:insertAttribute name="nav" />
	</div>
	<div id="content">
	  <div id="left">
	    <tiles:insertAttribute name="content" />
	  </div>
	  
    <tiles:insertAttribute name="news" />
	  
    <div id="footerline"></div>
	</div>
	<tiles:insertAttribute name="footer" />
</div>
</body>
</html>