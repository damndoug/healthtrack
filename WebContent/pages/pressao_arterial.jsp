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
      <h1 class="common-title">PRESSÃO ARTERIAL</h1>
      <div>
    	<c:if test="${not empty msg }">
  			<div class="alert alert-success">${ msg }</div>
  		</c:if>
		<c:if test="${not empty erro }">
  			<div class="alert alert-danger">${ erro }</div>
  		</c:if>      
        <form action="pressoes" method="post">
          <div class="row">
            <div class="col-sm-4 col-md-4">
              <input type="text" name="data" class="form-control" placeholder="dd/mm/aaaa">
            </div>
            <div class="col-md-3 col-sm-4">
              <input type="text" name="pressao_arterial" class="form-control" placeholder="Pressão Arterial">
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

      <h1 class="common-title">Histórico de Pressão Arterial</h1>

      <table class="table">
        <thead>
          <tr>
            <th>Data</th>
            <th>Pressão arterial</th>
            <th>Editar</th>
            <th>Apagar</th>
          </tr>
        </thead>
        <tbody>
	        <c:forEach items="${pressoes}" var="pressao">
	        	<tr>
	        		<td>${ pressao.getDataCadastro() }</td>
	        		<td>${ pressao.getPressaoArterial() }</td>
	        		<td><a href="editar?tipo=pressao&id=${ pressao.getId() }">editar</a></td>
	       			<td><a href="pressoes?acao=remover&id=${ pressao.getId() }">x</a></td>
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