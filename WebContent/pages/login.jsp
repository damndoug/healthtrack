<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
  <meta name="description" content="BOOTSTRAP">
  <link rel="stylesheet" href="../resources/css/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="../resources/css/login.css">
</head>

<body>

  <div class="container">
    <div class="login">
      <div class="title">
        <a href="/">HEALTH TRACK</a>
      </div>
      
		<c:if test="${not empty erro }">
 			<div class="alert alert-danger">${ erro }</div>
		</c:if>
      
      <div class="subtitle">
        <h2>LOGIN</h2>
      </div>
      <form action="login" class="login-form" method="post">
        <div class="form-group">
          <input type="email" name="email" class="form-control" placeholder="Seu email">
        </div>
        <div class="form-group">
          <input type="password" name="senha" class="form-control" placeholder="Sua senha">
        </div>
        <button type="submit" class="btn btn-login">Entrar</button>
      </form>
      <small>Não possui conta? <span><a href="pages/cadastrar.jsp">Cadastre-se</a></span></small>
    </div>
  </div>

  <script src="../resources/js/jquery.js"></script>
  <script src="../resources/js/helpers.js"></script>
  <script src="../resources/css/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>