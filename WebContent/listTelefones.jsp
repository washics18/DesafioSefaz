<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Users</title>

<style type="text/css">

@import "media/CSS/jquery.dataTables.css"
</style>
<link  rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>


</head>
<body>

<center>
  <h1>Cadastro de Telefones</h1>
        
   <form method="Post" action='TelefoneController' name="frmAddUser">

 <input type="text" name="userid" value="${id}" hidden=true/>
 
 <input type="text" name="name" value="${name}" hidden=true/>
 DDD : <input type="number" name="ddd" value="<c:out value="${user.nome}" />" /> <br />
 Número : <input type="text" name="numero" value="<c:out value="${user.email}" />" /> <br />
 Tipo : 
 <select name="tipo">
  <option value="Casa">Casa</option> 
  <option value="Celular" selected>Celular</option>
  <option value="Trabalho">Trabalho</option>
</select><br />
 
 <input type="submit" value="Cadastrar">

</form>
<table id="minhaTabela" class="display" cellspacing="0"  width="100%">
<caption><h2>Telefones de ${name}</h2></caption>
<thead>
<tr>
<th>DDD</th>
<th>Número</th>
<th>Tipo</th>
<th>Update</th>
<th>Delete</th>

</tr>
</thead>
<tbody>
<c:forEach items="${telefones}" var="telefone">
<tr>
<td><c:out value="${telefone.DDD}" /></td>
<td><c:out value="${telefone.numero}" /></td>
<td><c:out value="${telefone.tipo}" /></td>

<td><a href="UserController?action=edit&id=<c:out value="${user.userid}"/>"><img alt="Update" title="Update" src="RESOURCES/img/editar.png" width="20px" height="20px" ></a></td>
<td><a href="UserController?action=delete&id=<c:out value="${user.userid}"/>"><img alt="Delete" title="Delete" src="RESOURCES/img/excluir.jpg" width="20px" height="20px" ></a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
<script type="text/javascript">

$(document).ready(function() {
    $('#minhaTabela').DataTable();
} );

</script>
</html>