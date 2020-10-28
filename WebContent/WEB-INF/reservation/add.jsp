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
<title>Add Reservation Form</title>

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
<script type="text/javascript">

	function addOption(selectbox, text, value) {
		var optn = document.createElement("option");
		optn.text = text;
		optn.value = value;
		selectbox.options.add(optn);
	}
	function addOption_list() {

		for (var i = 1; i <= 31; ++i) {
			addOption(document.register_form.day, i, i);
		}
		for (var i = 1; i <= 12; ++i) {
			addOption(document.register_form.month, i, i);
		}
		for (var i = 2020; i < 2022; ++i) {
			addOption(document.register_form.year, i, i);
		}
		for (var i = 7; i < 22; ++i) {
			addOption(document.register_form.hourOfReservation, i, i);
		}
		for (var i = 0; i < 61; ++i) {
			addOption(document.register_form.minuteOfReservation, i, i);
		}
		for (var i = 1; i < 5; ++i) {
			addOption(document.register_form.hoursBooked, i, i);
		}
	}
</script>
</head>

<body onload="addOption_list()">
	<div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
		<div class="wrapper wrapper--w680">
			<div class="card card-1">
				<div class="card-heading"></div>
				<div class="card-body">
					<h2 class="title">Add New Reservation Details</h2>
					<form:form action="reservation_save_new_reservation.htm"
						method="post" commandName="reservation" name="register_form"
						id="register_form">

						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">
							<div class="select-dropdown"></div>
								<form:select path="courtNumber.id">
									<form:option value="0" label="PLEASE SELECT COURT #ID" />
									<c:forEach items="${model.court}" var="r">

										<form:option value="${r.id}"></form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>

					
							<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">

									<select name="day"><option value="">Day</option></select>
									<div class="select-dropdown"></div>
								</div>
							</div>



							<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">

									<select name="month"><option value="">Month</option></select>
									<div class="select-dropdown"></div>
								</div>
							</div>

						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">

								<select name="year"><option value="">Year</option></select>

								<div class="select-dropdown"></div>
							</div>
						</div>


						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">

								<select name="hourOfReservation"><option value="">HOUR OF RESERVATION (FROM 7-21)</option></select>

								<div class="select-dropdown"></div>
							</div>
						</div>

						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">

								<select name="minuteOfReservation"><option value="">MINUTE OF RESERVATION</option></select>

								<div class="select-dropdown"></div>
							</div>
						</div>
						
						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">

								<select name="hoursBooked"><option value="">BOOKED HOURS (min 1-max 4)</option></select>

								<div class="select-dropdown"></div>
							</div>
						</div>


				

						<div class="input-group">
							<div class="rs-select2 js-select-simple select--no-search">
							<div class="select-dropdown"></div>
								<form:select path="p.id">
									<form:option value="0" label="PLEASE SELECT PLAYER #ID" />
									<c:forEach items="${model.player}" var="r">

										<form:option value="${r.id}"></form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>


						<div class="p-t-20">
							<button class="btn btn--radius btn--green" type="submit">Add
								Reservation</button>

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