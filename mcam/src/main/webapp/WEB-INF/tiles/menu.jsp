<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="ss" %>
<ul>
	<li><a href="${baseUrl}">Strona główna</a></li>
	<ss:authorize access="isAnonymous()">
		<li><a href="${baseUrl}login/index.html">Zaloguj się</a></li>
		<li><a href="${baseUrl}registration/form.html">Zarejestruj się</a></li>
	</ss:authorize>
	<ss:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="${baseUrl}admin/index.html">Administracja</a></li>
	</ss:authorize>
	<ss:authorize access="isAuthenticated()">
		<li><a href="${baseUrl}login/logout">Wyloguj mnie</a>
	</ss:authorize>
</ul>