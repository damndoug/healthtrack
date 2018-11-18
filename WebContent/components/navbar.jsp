<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  <section class="top-navbar">
    <nav class="navbar navbar-expand-lg navbar-light bg-light default-navbar">
      <a class="navbar-brand" href="dashboard">HEALTH TRACK</a>

	<div style="display:flex;flex-direction:column;text-align:center;width:100%;align-items: flex-end;">
      <ul style="display:flex;flex-direction:row" class="navbar-nav ml-auto">

        <li>
          <a href="configuracoes">Configurações</a>
        </li>
        <li>
          <a href="/">Sair</a>
        </li>
      </ul>
	   	<c:if test="${not empty user }">
	     <span style="color:#fff" class="navbar-text">
	      ${ user }
	     </span> 
	   </c:if>
	</div>
    </nav>
  </section>
  
  
