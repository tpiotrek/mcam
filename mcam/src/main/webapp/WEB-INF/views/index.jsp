<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${baseUrl}<c:url value="resources/css/style.css"/>" rel="stylesheet" />
		<title>Insert title here</title>
	</head>
	<body>
		<div id="layout">
			<div id="header">
				<tiles:insertAttribute name="header" />
			</div>
			<div id="menu">
				<tiles:insertAttribute name="menu" />
			</div>
			<div id="body">
				<tiles:insertAttribute name="body" />
			</div>
			<div id="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</body>
</html>