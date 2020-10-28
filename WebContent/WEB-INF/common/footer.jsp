<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="pagination">
	<li class="page-item active"><a href="<c:url value='/index.htm'/>"
		class="page-link">Home</a></li>
	<li class="page-item active"><a
		href="<c:url value='/player_list.htm'/>" class="page-link">Players</a></li>
	<li class="page-item active"><a
		href="<c:url value='/reservation_list.htm'/>" class="page-link">Reservations</a></li>
	<li class="page-item active"><a
		href="<c:url value='/court_list.htm'/>" class="page-link">Courts</a></li>
	<li class="page-item active"><a
		href="<c:url value='/ranking_list.htm'/>" class="page-link">Club
			Rankings</a></li>


</ul>