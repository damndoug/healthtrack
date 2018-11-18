<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!Doctype html>
<html>

<head>
  <%@ include file="../components/header.jsp" %>
  <link rel="stylesheet" href="../resources/css/login.css">
</head>

<body>

  <div class="container">
  	<c:if test="${not empty msg }">
  		<div class="alert alert-success">${ msg }</div>
  	</c:if>
  	<c:if test="${not empty erro }">
  		<div class="alert alert-danger">${ erro }</div>
  	</c:if>
    <div class="login">
      <div class="title">
        <h1>HEALTH TRACK</h1>
      </div>
      <div class="subtitle">
        <h2>LOGIN</h2>
      </div>
      <div class="error-message" id="error-lack-field-login-message">
        <p>Campos obrigatórios.</p>
      </div>
      <form action="usuario" class="login-form" method="post">
        <div class="form-group">
          <input id="signup-name" name="nome" type="text" class="form-control" placeholder="Seu nome">
        </div>

        <div class="form-group">
          <input id="signup-email" name="email" type="email" class="form-control" placeholder="Seu email">
        </div>

		<div class="form-group">
			<select name="sexo" class="form-control">
				<option>Masculino</option>
				<option>Feminino</option>				
			</select>
		</div>

        <div class="form-group">
          <input id="signup-password" name="senha" type="password" class="form-control" placeholder="Sua senha">
        </div>
        <div class="form-group">
          <input id="sign-up-confirm-password" name="confirmarSenha" type="password" class="form-control" placeholder="Confirme sua senha">
        </div>
        <button type="submit" class="btn btn-login">Entrar</button>
      </form>
      <small>Já possui conta? <span><a href="../login">Clique aqui</a></span></small>
    </div>
  </div>

  <script src="../resources/js/jquery.js"></script>
  <script src="../resources/css/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>