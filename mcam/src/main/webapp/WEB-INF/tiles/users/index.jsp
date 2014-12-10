<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<s:message var="lp" code="list.lp" />
<s:message var="fname" code="list.fname" />
<s:message var="lname" code="list.lname" />
<s:message var="remove" code="form.action.remove" />
<s:message var="edit" code="form.action.edit" />

<f:form action="${baseUrl}users/process" 
		method="POST" 
		modelAttribute="form">
	<table>
		<thead>
			<tr>
				<th>&nbsp;</th>
				<th>${lp}</th>
				<th>${fname}</th>
				<th>${lname}</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td colspan="4">
					<input type="submit" name="remove" value="${remove}" />
					<input type="submit" name="edit" value="${edit}" />
				</td>
			</tr>
			<c:forEach var="user" items="${users}" varStatus="loop">
				<tr>
					<td><f:checkbox path="usersId" value="${user.id}" /></td>
					<td>${loop.index+1}</td>
					<td>${user.fname}</td>
					<td>${user.lname}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</f:form>