<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.error {
color: red;
}
</style>
<title>Shopping Website</title>
</head>
<body>

<h1> *******************************************************</h1>
<h1> ***************** Shopping Website ********************</h1>
<h1> *******************************************************</h1>
<h3 class="info"> ${ logoutInfo } </h3>
<h1> *******************************************************</h1>
<h3 class="error"> ${ errorInfo } </h3>
<h1> *******************************************************</h1>
<sf:form action="processLogin" method="post" modelAttribute="user">
<sf:errors path="users" cssaClass="error" element="div" />
<sf:label path="Username"> Username: </sf:label>
<sf:input path="Username" /> <br/>
<sf:label path="Password"> Password: </sf:label>
<sf:input path="Password" /> <br/>
<input type="submit" value="Login">
</sf:form>

</body>
</html>