<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
	<tiles:getAsString name="title" />
</title>
<link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/bootstrap-datepicker.standalone.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="<c:url value='/static/js/jquery/jquery-3.3.1.min.js'/>"></script>
<script src="<c:url value='/static/js/jquery/jquery.blockUI.js'/>"></script>
<script src="<c:url value='/static/js/moment/moment.min.js'/>"></script>
<script src="<c:url value='/static/js/bootstrap/bootstrap.min.js'/>"></script>
<script src="<c:url value='/static/js/bootstrap/bootstrap-datepicker.min.js'/>"></script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC2IpI8-7yLTthtyInsM_9oL7Gcx94Sgy0&libraries=places&callback=initLocationPicker" async defer></script>

<script src="<c:url value='/static/js/app.js'/>"></script>

</head>

<body data-application-context="${pageContext.request.contextPath}">
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}">
					<img src="${pageContext.request.contextPath}/static/img/hotel-icon.png">
				</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active">
						<a href="${pageContext.request.contextPath}/">Home</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/hotel-offers">Hotels</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/contactus">Contact</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="content" class="container-fluid" >
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<tiles:insertAttribute name="menu" />
			</div>
			<div id="sitebody" class="col-sm-8 text-left">
				<tiles:insertAttribute name="message" />
				<tiles:insertAttribute name="search" />
				<tiles:insertAttribute name="body" />
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
</html>