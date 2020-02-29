<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>
<link rel="stylesheet" href="RESOURCES/CSS/cadastro.css">
</head>
<body>


<center>
  <h1>User Management</h1>
        <h2>
        <a href="user.jsp">Add New User</a>
             &nbsp;&nbsp;&nbsp;
         <a href="list">List All Users</a>
             &nbsp;&nbsp;&nbsp;
         <a href="index.jsp">Index</a>
         
        </h2>
        
   
<table border=1 cellpadding="5" >
<caption><h2>List of Users</h2></caption>
<thead>
<tr>
<th>User Id</th>
<th>Nome</th>
<th>Email</th>
<th>Senha</th>
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

<td><a href="UserController?action=edit&id=<c:out value="${user.userid}"/>">Update</a></td>
<td><a href="UserController?action=delete&id=<c:out value="${user.userid}"/>">Delete</a></td>
</tr>
</c:forEach>
</tbody>

</table>





</body>
</html>