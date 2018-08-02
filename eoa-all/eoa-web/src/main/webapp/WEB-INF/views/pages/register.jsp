<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="text-center">
	<h3>
		<b>Register</b>
	</h3>
</div>
<form:form id="ajax-register-form" modelAttribute="userRegisterForm" action="${pageContext.request.contextPath}/user/register" method="post"
	role="form" autocomplete="off" data-toggle="validator">
	<c:if test="${not empty error}">
		<div class="alert alert-danger">
			<p>${error}</p>
		</div>
	</c:if>
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
		<input type="password" name="confirmPassword" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password"
			data-match="#rpassword" data-match-error="Whoops, these don't match" required>
	</div>
	<div class="form-group">
		<div class="row">
			<div class="col-xs-6 col-xs-offset-3">
				<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-info" value="Register Now">
			</div>
		</div>
	</div>
</form:form>