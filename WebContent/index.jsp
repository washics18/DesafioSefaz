<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="RESOURCES/CSS/style.css">
</head>
<body>

<div class="login-page">
<center><h2>Cadastro de Usuários</h2></center>
  <div class="form">

<form action="UserController?action=listUser" method="post" class="login-form">

Login:
<input type="text" id="login" name="login">
<br/>

Senha:
<input type="password" id="senha" name="senha">
<br/>

<button type="submit" value="Logar">Logar</button> 


</form>

</div>
</div>

</body>
</html>