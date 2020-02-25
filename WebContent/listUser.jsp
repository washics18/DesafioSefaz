<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
</head>
<body>
<table border=1>
<thead>
<tr>
<th>User Id</th>
<th>Nome</th>
<th>Email</th>
<th>Senha</th>
<th>Telefone</th>
<th colspan=2>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${users}" var="user">
<tr>
<td><c:out value="${user.userid}" /></td>
<td><c:out value="${user.nome}" /></td>
<td><c:out value="${user.email}" /></td>
<td><c:out value="${user.senha}" /></td>
<td><c:out value="${user.telefone}" /></td>
<td><a href="UserController?action=edit&id=<c:out value="${user.userid}"/>">Update</a></td>
<td><a href="UserController?action=delete&id=<c:out value="${user.userid}"/>">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<p><a href="user.jsp">Add User</a></p>
<a href="index.jsp">Index</a>


</body>
</html>