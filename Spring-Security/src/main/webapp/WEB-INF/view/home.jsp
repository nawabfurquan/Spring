<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
	<title>ABC Company Home Page</title>
</head>
<body>
	<h2>ABC Company Home Page</h2>
	<hr>
	Welcome to the ABC Company Home Page
	<hr>
	<p>
		User: <security:authentication property="principal.username" />
		<br><br>
		Role(s): <security:authentication property="principal.authorities" />
	</p>
	<security:authorize access="hasRole('MANAGER')">
		<hr>
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
		<hr>
    	<p>
			<a href="${pageContext.request.contextPath}/systems">Admin Meeting</a>
		</p>
	</security:authorize>
	<br>
	<form:form method="POST" action="${pageContext.request.contextPath}/logout">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>