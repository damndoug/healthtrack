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
      <h1 class="common-title">ATIVIDADES</h1>
      <div>
      <c:if test="${not empty msg }">
  		<div class="alert alert-success">${ msg }</div>
  	  </c:if>
	  <c:if test="${not empty erro }">
  		<div class="alert alert-danger">${ erro }</div>
  	  </c:if>      
      	<form action="atividades" method="post">
	        <div class="row">
	          <div class="col-md-4 col-sm-4">
	            <input type="text" name="data" class="form-control" placeholder="Data">
	          </div>
	          <div class="col-md-2 col-sm-4">
	            <input type="text" name="atividade" class="form-control" placeholder="Atividades">
	          </div>
	          <div class="col-md-2 col-sm-4">
	            <input type="text" name="calorias" class="form-control" placeholder="Calorias">
	          </div>
	          <div class="col-md-2 col-sm-4">
	            <input type="text" name="tempo" class="form-control" placeholder="Tempo">
	          </div>
	        </div>
	        <div class="common-add-button-wrapper">
	          <button class="btn common-add-btn float-right">Adicionar</button>
	        </div>
        </form>
      </div>
    </div>
  </section>

  <section class="common-table-wrapper">
    <div class="container">

      <h1 class="common-title">Histórico de Atividades</h1>

      <table class="table">
        <thead>
          <tr>
            <th>Data</th>
            <th>Atividade</th>
            <th>Calorias</th>
            <th>Duração</th>
            <th>Editar</th>
            <th>Apagar</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${atividades}" var="atividade">
	       	<tr>
	       		<td>${ atividade.getDataCadastro() }</td>
	       		<td>${ atividade.getDescAtividade() }</td>
	       		<td>${ atividade.getCalorias() }</td>
	       		<td>${ atividade.getTempo() }</td>
	       		<td>editar</td>
	       		<td>x</td>
	       	</tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </section>

  <script src="../resources/js/jquery.js"></script>
  <script src="../resources/js/helpers.js"></script>
  <script src="../resources/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>