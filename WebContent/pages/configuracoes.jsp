<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
  <%@ include file="../components/header.jsp" %>
  <link rel="stylesheet" href="../resources/css/configuracoes.css">
  <link rel="stylesheet" href="../resources/css/dashboard.css">
</head>

<body>

  <%@ include file="../components/navbar.jsp" %>

  <section class="change-email">
    <div class="container">
      <div class="wrapper">
        <div>
          <h1 class="common-title">Configurações</h1>
        </div>
        
	      <c:if test="${not empty msg }">
	  		<div class="alert alert-success">${ msg }</div>
	  	  </c:if>
		  <c:if test="${not empty erro }">
	  		<div class="alert alert-danger">${ erro }</div>
	  	  </c:if> 
        
        <div>
          <h2 class="common-subtitle change-email-subtitle">Alterar e-mail</h2>
        </div>
        <form action="configuracoes" method="post">
	        <div>
	          <input type="text" class="form-control" name="email" value="${ usuario.getEmail() }" placeholder="Novo e-mail">
	        </div>
	        <div class="common-btn-wrapper">
	          <button class="btn common-add-btn float-right">Alterar</button>
	        </div>
	      </div>
	      <div class="wrapper">
	        <div>
	          <h2 class="common-subtitle">Alterar senha</h2>
	        </div>
	        <div class="group">
	          <input class="form-control" name="senhaAntiga" type="text" placeholder="Antiga senha">
	          <input class="form-control" name="novaSenha" type="text" placeholder="Nova senha">
	          <input class="form-control" name="confirmarSenha" type="text" placeholder="Confirmar nova senha">
	        </div>
	        <div class="common-btn-wrapper">
	          <button class="btn common-add-btn float-right">Salvar</button>
	        </div>
        </form>
      </div>
      </div>
  </section>

  <script src="../resources/js/jquery.js"></script>
  <script src="../resources/js/helpers.js"></script>
  <script src="../resources/css/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>