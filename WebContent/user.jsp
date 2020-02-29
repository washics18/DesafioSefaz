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
<link rel="stylesheet" href="RESOURCES/CSS/cadastro.css">
<%!

List<Telefone> telefones = Arrays.asList(new Telefone(81,"92828282","celular",0));

%>
</head>
<body>
<form method="Post" action='UserController' name="frmAddUser">

 User Id : <input type="text" readonly="readonly" name="userid" value="<c:out value="${user.userid}" />" /> <br />
 Nome : <input type="text" name="nome" value="<c:out value="${user.nome}" />" /> <br />
 Email : <input type="text" name="email" value="<c:out value="${user.email}" />" /> <br />
 Senha : <input type="text" name="senha" value="<c:out value="${user.senha}" />" /> <br />
 <input type="button" value="+ telefone" /> <br />
 <input type="hidden" name="telefones"  value="<%=telefones%>"/>
 <input type="number" name="ddd" hidden=true/>
 <input type="text" name="ddd" hidden=true/>
 <input type="text" name="tipo" hidden=true/>
 <input type="button" value="add" hidden=true><br/>
 <input type="submit" value="Submit">

</form>
</body>
</html>