<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
	<tiles:getAsString name="title" />
</title>
<link rel="icon" href="<c:url value='/static/img/favicon.ico'/>" type="image/x-icon">
<link rel="shortcut icon" href="<c:url value='/static/img/favicon.ico'/>" type="image/x-icon"> 

<link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/bootstrap-datepicker.standalone.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/dataTables.bootstrap.min.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/animate.css' />" rel="stylesheet"></link>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="<c:url value='/static/js/jquery/jquery-3.3.1.min.js'/>"></script>
<script src="<c:url value='/static/js/jquery/jquery.blockUI.js'/>"></script>
<script src="<c:url value='/static/js/jquery/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/static/js/moment/moment.min.js'/>"></script>
<script src="<c:url value='/static/js/bootstrap/bootstrap.min.js'/>"></script>
<script src="<c:url value='/static/js/bootstrap/bootstrap-datepicker.min.js'/>"></script>
<script src="<c:url value='/static/js/bootstrap/dataTables.bootstrap.min.js'/>"></script>

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
					<li>
						<a href="${pageContext.request.contextPath}/home">Home</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/hotel-offers">Hotels</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/contactus">Contact</a>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize  access="hasRole('ROLE_USER')">   
	                    <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Welcome <%= request.getUserPrincipal().getName() %><b class="caret"></b></a>
	                        <ul class="dropdown-menu">
	                            <li><a href="${pageContext.request.contextPath}/user/search-history"><i class="icon-cog"></i> View Search History</a></li>                          
	                            <li class="divider"></li>
	                            <li><a href="${pageContext.request.contextPath}/logout"><i class="icon-off"></i> Logout</a></li>
	                        </ul>
	                    </li>
                   </sec:authorize>
                   <sec:authorize  access="!hasRole('ROLE_USER')">
                   		 <c:if test="${not fn:contains(requestScope['javax.servlet.forward.request_uri'], 'register')}">
	                    <li class="dropdown">
	                        <a href="${pageContext.request.contextPath}/user/register" class="dropdown-toggle" data-toggle="dropdown">Register <span class="caret"></span></a>
	                        <ul class="dropdown-menu dropdown-lr animated flipInX" role="menu">
	                            <div class="col-lg-12">
	                                <div class="text-center"><h3><b>Register</b></h3></div>
									<form:form id="ajax-register-form" action="${pageContext.request.contextPath}/user/register" method="post" role="form" autocomplete="off" data-toggle="validator">
										<div class="form-group">
											<input type="text" name="username" id="rusername" tabindex="1" class="form-control" placeholder="Username" value="" required>
										</div>
										<div class="form-group">
											<input type="email" name="email" id="email" tabindex="1" class="form-control" placeholder="Email Address" value="" required>
										</div>
										<div class="form-group">
											<input type="password" name="password" id="rpassword" tabindex="2" class="form-control" placeholder="Password" required>
										</div>
										<div class="form-group">
											<input type="password" name="confirmPassword" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password" data-match="#rpassword" data-match-error="Whoops, these don't match" required>
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-xs-6 col-xs-offset-3">
													<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-info" value="Register Now">
												</div>
											</div>
										</div>
									</form:form>
	                            </div>
	                        </ul>
	                    </li>
	                    </c:if>
	                    <c:if test="${not fn:contains(requestScope['javax.servlet.forward.request_uri'], 'login')}">
	                    <li class="dropdown">
	                        <a href="${pageContext.request.contextPath}/login" class="dropdown-toggle" data-toggle="dropdown">Log In <span class="caret"></span></a>
	                        <ul class="dropdown-menu dropdown-lr animated slideInRight" role="menu">
	                            <div class="col-lg-12">
	                                <div class="text-center"><h3><b>Log In</b></h3></div>
	                                <form id="ajax-login-form" action="${pageContext.request.contextPath}/login" method="post" role="form" autocomplete="off">
	                                    <div class="form-group">
	                                        <label for="username">Username</label>
	                                        <input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="Username" value="" autocomplete="off">
	                                    </div>
	
	                                    <div class="form-group">
	                                        <label for="password">Password</label>
	                                        <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" autocomplete="off">
	                                    </div>
	
	                                     <div class="form-group">
	                                        <div class="row">
	                                            <!--
	                                            <div class="col-xs-7">
	                                                <input type="checkbox" tabindex="3" name="remember" id="remember">
	                                                <label for="remember"> Remember Me</label>
	                                            </div>
	                                            -->
	                                            <div class="col-xs-5 pull-right">
	                                                <input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-success" value="Log In">
	                                            </div>
	                                        </div>
	                                    </div>
										
										<!--
	                                    <div class="form-group">
	                                        <div class="row">
	                                            <div class="col-lg-12">
	                                                <div class="text-center">
	                                                    <a href="${pageContext.request.contextPath}/user/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                     -->
	                                </form>
	                            </div>
	                        </ul>
	                    </li>
	                    </c:if>
                    </sec:authorize>
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