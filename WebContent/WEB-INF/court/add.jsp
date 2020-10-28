<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@
taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">

<!-- Title Page-->
<title>Add Court Form</title>

<!-- Icons font CSS-->
<link rel="stylesheet" media="all"
	href="<c:url value='/vendor/mdi-font/css/material-design-iconic-font.min.css'/>">
<link rel="stylesheet" media="all"
	href="<c:url value='/vendor/font-awesome-4.7/css/font-awesome.min.css'/>">



<!-- Font special for pages-->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i"
	rel="stylesheet">

<!-- Vendor CSS-->
<link rel="stylesheet" media="all"
	href="<c:url value='/vendor/select2/select2.min.css'/>">

<link rel="stylesheet" media="all"
	href="<c:url value='/vendor/datepicker/daterangepicker.css'/>">

<!-- Main CSS-->
<link rel="stylesheet" media="all" href="<c:url value='/css/main.css'/>">

</head>

<body>
	<div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
		<div class="wrapper wrapper--w680">
			<div class="card card-1">
				<div class="card-heading"></div>
				<div class="card-body">
					<h2 class="title">Add New Court Details</h2>
					<form:form action="court_save_new_court.htm" method="post"
						commandName="court">

						<div class="input-group">
							<form:input path="courtNumber" class="input--style-1"
								onfocus="this.value=''" min="1" max="10" value="COURT NUMBER"
								type="number" placeholder="COURT NUMBER" name="courtNumber" />
						</div>

						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">

								<select name="courtSurface">
									<option disabled="disabled" selected="selected">Court
										Surface </option>
									<option>Clay</option>
									<option>Hard</option>
									<option>Grass</option>
								</select>
								<div class="select-dropdown"></div>
							</div>
						</div>

						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">

								<select name="courtType">
									<option disabled="disabled" selected="selected">Court
										Type</option>
									<option>Training</option>
									<option>Kids</option>
									<option>Tournament</option>
								</select>
								<div class="select-dropdown"></div>
							</div>
						</div>


						<div class="p-t-20">
							<button class="btn btn--radius btn--green" type="submit">Add
								Court</button>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<!-- Jquery JS-->

	<script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
	<!-- Vendor JS-->

	<script src="<c:url value='/vendor/select2/select2.min.js'/>"></script>
	<script src="<c:url value='/vendor/datepicker/moment.min.js'/>"></script>
	<script src="<c:url value='/vendor/datepicker/daterangepicker.js'/>"></script>

	<!-- Main JS-->
	<script src="<c:url value='/js/global.js'/>"></script>

</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->