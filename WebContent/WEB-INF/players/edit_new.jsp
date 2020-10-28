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
<title>Edit Player Form</title>

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

		for (var i = 5; i <= 100; ++i) {
			addOption(document.register_form.age, i, i);
		}
		for (var i = 5; i <= 10; ++i) {
			addOption(document.register_form.playerLevel, i, i);
		}
		for (var i = 0; i <= 500; ++i) {
			addOption(document.register_form.matchesPlayed, i, i);
		}
		for (var i = 0; i <=500; ++i) {
			addOption(document.register_form.matchesWon, i, i);
		}
		for (var i = 0; i <=500; ++i) {
			addOption(document.register_form.matchesLost, i, i);
		}
		for (var i = 0; i <=500; ++i) {
			addOption(document.register_form.leaguePoints, i, i);
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
					<h2 class="title"> Edit Player Details</h2>
					<form:form action="player_save.htm" method="post"
						commandName="player" name="register_form" id="register_form">
						<div class="input-group">

							<form:input path="id" class="input--style-1" type="number"
								readonly="true" placeholder="# ID" name="id" />
						</div>

						<div class="input-group">
							<form:input path="firstName" class="input--style-1" type="text"
							readonly="true"	placeholder="FIRST NAME" name="firstName" />
						</div>

						<div class="input-group">
							<form:input path="lastName" class="input--style-1" type="text"
							readonly="true" placeholder="LAST NAME" name="lastName" />
						</div>

						<div class="input-group">
							<form:input path="email" class="input--style-1" type="email"
								placeholder="EMAIL" name="email" />
						</div>

						<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">

									<select name="age"><option value="">AGE</option></select>
									<div class="select-dropdown"></div>
								</div>
							</div>
						
						<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">

									<select name="playerLevel"><option value="">PLAYER LEVEL( 5 to 10)</option></select>
									<div class="select-dropdown"></div>
								</div>
							</div>

						<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">

									<select name="matchesPlayed"><option value="">PLAYED MATCHES (UP TO 500)</option></select>
									<div class="select-dropdown"></div>
								</div>
							</div>


						<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">

									<select name="matchesWon"><option value="">WON MATCHES (UP TO 500)</option></select>
									<div class="select-dropdown"></div>
								</div>
							</div>
						

						<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">

									<select name="matchesLost"><option value="">LOST MATCHES (UP TO 500)</option></select>
									<div class="select-dropdown"></div>
								</div>
							</div>

						<div class="input-group">
								<div class="rs-select2 js-select-simple select--no-search">

									<select name="leaguePoints"><option value="">LEAGUE POINTS</option></select>
									<div class="select-dropdown"></div>
								</div>
							</div>
						

						<div class="p-t-20">
							<button class="btn btn--radius btn--green" type="submit">Save Changes
								</button>

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
