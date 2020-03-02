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
<h5 style="color:red">Usuário ou senha inválidos</h5>
</div>
</div>

</body>
</html>