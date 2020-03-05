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

<a href="listUser.jsp"><img alt="Inicio" title="Inicio" src="RESOURCES/img/inicio.jpg" width="30px" height="30px" ></a>
<a href="index.jsp"><img alt="Sair" title="Sair" src="RESOURCES/img/sair.jpg" width="30px" height="30px" ></a>
<center style="padding-top:10%;"><a href="user.jsp"><img alt="Adicionar" title="Adicionar" src="RESOURCES/img/adicionar.png" width="80px" height="80px" ></a></center>
<center><h2><b>Cadastro de Usuários<b></b></h2></center>
<form method="Post" action='UserController' name="frmAddUser">
<ul class="form-style-1"><li>
<center>
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
 </center>
 
  </li>
</ul>
</form>
</body>
</html>