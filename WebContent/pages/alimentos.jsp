<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!Doctype html>
<html>

<head>
  <%@ include file="../components/header.jsp" %>
</head>

<body>

  <%@ include file="../components/navbar.jsp" %>

  <section class="common-main-section">
    <div class="container">
      <h1 class="common-title">ALIMENTOS</h1>
      <c:if test="${not empty msg }">
  		<div class="alert alert-success">${ msg }</div>
  	  </c:if>
	  <c:if test="${not empty erro }">
  		<div class="alert alert-danger">${ erro }</div>
  	  </c:if>
      <form action="alimentos" method="post">
        <div class="row">
          <div class="col-md-4 col-sm-4">
            <input type="text" name="data" class="form-control" placeholder="dd/mm/aaaa">
          </div>
          <div class="col-md-2 col-sm-4">
            <input type="text" name="desc_alimento" class="form-control" placeholder="Alimentos">
          </div>
          <div class="col-md-2 col-sm-4">
            <input type="text" name="calorias" class="form-control" placeholder="Calorias">
          </div>
        </div>
        <div class="common-textarea-wrapper">
          <textarea class="form-control" name="comentarios" rows="5"></textarea>
        </div>
        <div class="common-add-button-wrapper">
          <button class="btn common-add-btn float-right">Adicionar</button>
        </div>
      </form>
    </div>
  </section>

  <section class="common-table-wrapper">
    <div class="container">

      <h1 class="common-title">Histórico de Alimentos</h1>

      <table class="table">
        <thead>
          <tr>
            <th>Data</th>
            <th>Alimento</th>
            <th>Calorias</th>
            <th>Comentários</th>
            <th>Editar</th>
            <th>Apagar</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${alimentos}" var="alimento">
        	<tr>
        		<td>${ alimento.getDataCadastro() }</td>
        		<td>${ alimento.getDescAlimento() }</td>
        		<td>${ alimento.getCalorias() }</td>
        		<td>${ alimento.getComentarios() }</td>
        		<td><a href="editar?tipo=alimento&id=${ alimento.getId() }">editar</a></td>
	       		<td><a href="alimentos?acao=remover&id=${ alimento.getId() }">x</a></td>
        	</tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </section>

  <script src="../resources/js/jquery.js"></script>
  <script src="../resources/js/helpers.js"></script>
  <script src="../resources/css/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>