<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/hotel-offers/search" var="userActionUrl" />
<spring:url value="Enter a location e.g. Florida, London" var="detsinationPlaceHolder" />

<div class="row row-margin-bottom">
	<div class="col-md-12 panel-padding lib-item" data-category="view">
		<div class="lib-panel searchbox">
			<div class="row box-shadow">
				<div class="form-group">
					<form:form method="post" modelAttribute="searchForm" action="${userActionUrl}">
						<div class="form-horizontal">
							<div class="col-sm-8">
								<div class="form-group">
									<div class="col-sm-3 control-label">
										<label for="hotelSearchTitle" class="control-label"></label>
									</div>
									<div class="col-sm-5">
										<div class="input-group col-sm-12" id="hotelSearchTitle">
											<h3>Search Hotel Offers:</h3>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-8">
								<div class="form-group">
									<div class="col-sm-3 control-label">
										<label for="destinationFormattedAddress" class="control-label"></label>
									</div>
									<div class="col-sm-5">
										<div class="input-group col-sm-12" id="destinationFormattedAddress">
											<form:input path="destinationFormattedAddress" type="text" id="pac-input" cssClass="form-control" placeholder="${detsinationPlaceHolder}" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-8">
								<div class="form-group">
									<div class="col-sm-3 control-label">
										<label for="startdate" class="control-label">StartDate</label>
									</div>
									<div class="col-sm-5">
										<div class="input-group date" id="startdate">
											<fmt:formatDate value="${searchForm.tripStartDate}" var="tripStartDateStr" pattern="MM/dd/yyyy" />
											<form:input id="startDateInput" path="tripStartDate" type="text" cssClass="form-control" value="${tripStartDateStr}" />
											<span class="input-group-addon">
												<span class="glyphicon-calendar glyphicon"></span>
											</span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-8">
								<div class="form-group">
									<div class="col-sm-3 control-label">
										<label for="enddate">EndDate</label>
									</div>
									<div class="col-sm-5">
										<div class="input-group date" id="enddate">
											<fmt:formatDate value="${searchForm.tripEndDate}" var="tripEndDateStr" pattern="MM/dd/yyyy" />
											<form:input id="endDateInput" path="tripEndDate" type="text" cssClass="form-control" value="${tripEndDateStr}" />
											<span class="input-group-addon">
												<span class="glyphicon-calendar glyphicon"></span>
											</span>
										</div>
									</div>
								</div>
							</div>

							<div class="col-sm-8">
								<div class="form-group">
									<div class="col-sm-3 control-label">
										<label for="submitBtn" class="control-label"></label>
									</div>
									<div class="col-sm-5">
										<div class="input-group col-sm-12" id="submitBtn">
											<button type="submit" class="btn btn-default">Submit</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>