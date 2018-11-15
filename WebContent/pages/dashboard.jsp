<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!Doctype html>
<html>

<head>
  <%@ include file="../components/header.jsp" %>
  <link rel="stylesheet" href="../resources/css/dashboard.css">
</head>

<body>

  <%@ include file="../components/navbar.jsp" %>

  <section class="container section-dashboard">
    <div class="row dashboard">
      <div class="item">

          <a href="./pesos?acao=listar">Pesos</a>

      </div>
      <div class="item">

          <a href="./alimentos?acao=listar">Alimentos</a>

      </div>
      <div class="item">

          <a href="./pressao_arterial?acao=listar">Pressão Arterial</a>

      </div>
      <div class="item">

          <a href="./atividades?acao=listar">Atividades</a>

      </div>
    </div>
  </section>


  <script src="../resources/js/jquery.js"></script>
  <script src="../resources/js/helpers.js"></script>
  <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
 

</body>

</html>