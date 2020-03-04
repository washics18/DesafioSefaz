<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="model.Telefone,java.util.List,java.util.Arrays" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="RESOURCES/CSS/tela.css">
<%!

List<Telefone> telefones = Arrays.asList(new Telefone(81,"92828282","celular",0));

%>
</head>
<body>

<h2>Add New User</h2>
<form method="Post" action='UserController' name="frmAddUser">
<ul class="form-style-1"><li>
<table>
<tr>
<td>User Id :</td> <td><input type="text" readonly="readonly" name="userid" value="<c:out value="${user.userid}"  />" class="field-long" /></td>
</tr> 
<tr>
<td>Nome :</td> <td><input type="text" name="nome" value="<c:out value="${user.nome}" />" /></td>
</tr> 
<tr>
<td>Email :</td> <td><input type="email" name="email" value="<c:out value="${user.email}" />" /></td>
</tr> 
<tr>
 <td>Senha :</td> <td><input type="text" name="senha" value="<c:out value="${user.senha}" />" /></td>
 </tr> 
 <tr>
 <td></td>
 <td><input type="submit" value="Submit"></td>
 
 </tr>
 </table>
 
  </li>
</ul>
</form>
</body>
</html>