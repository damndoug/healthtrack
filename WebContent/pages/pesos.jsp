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
      <h1 class="common-title">PESOS</h1>
      <div>
    	<c:if test="${not empty msg }">
  			<div class="alert alert-success">${ msg }</div>
  		</c:if>
		<c:if test="${not empty erro }">
  			<div class="alert alert-danger">${ erro }</div>
  		</c:if>
      	<form action="pesos" method="post">
    	   	<div class="form-group">
				
				<input type="text" name="data" class="form-control" placeholder="dd/mm/aaaa">				
				
				<input type="text" name="peso" class="form-control" placeholder="Peso">
			
				<div class="common-textarea-wrapper">
				  <textarea name="comentarios" class="form-control" rows="5"></textarea>
				</div>
				<div class="common-add-button-wrapper">
				  <button type="submit" class="btn common-add-btn float-right">Adicionar</button>
				</div>
			</div>
       	</form>
      </div>
    </div>
  </section>

  <section class="common-table-wrapper">
    <div class="container">

      <h1 class="common-title">Histórico de Pesos</h1>

      <table class="table">
        <thead>
          <tr>
            <th>Data</th>
            <th>Peso</th>
            <th>Comentários</th>
            <th>Editar</th>
            <th>Apagar</th>
          </tr>
        </thead>
         <c:forEach items="${pesos}" var="peso">
	       	<tr>
	       		<td>${ peso.getDataCadastro() }</td>
	       		<td>${ peso.getPeso() }</td>
	       		<td>${ peso.getComentario() }</td>
	       		<td><a href="editar?tipo=peso&id=${ peso.getId() }">editar</a></td>
	       		<td><a href="pesos?acao=remover&id=${ peso.getId() }">x</a></td>
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