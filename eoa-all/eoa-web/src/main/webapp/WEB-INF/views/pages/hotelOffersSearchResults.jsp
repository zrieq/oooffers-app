<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:choose>
	<c:when test="${not empty hotelOffersModel.offers.hotel}">
		<c:forEach var="hotel" items="${hotelOffersModel.offers.hotel}">
			<c:set var="hotelUrl" value = "${fn:replace(hotel.hotelInfo.hotelImageUrl, '_t.jpg', '_b.jpg')}" />
			<div class="col-md-12 panel-padding lib-item" data-category="view">
				<div class="lib-panel">
					<div class="row box-shadow">
						<div class="col-md-4">
							<img class="lib-img-show" src="<c:out value='${hotelUrl}'/>">
						</div>
						<div class="col-md-4">
							<div class="col-md-12 panel-elements-padding">
								<span class="text-large2"><c:out value="${hotel.hotelInfo.hotelName}" /></span>
							</div>
							<div class="col-md-12 panel-elements-padding">
								<span data-hotel-star-rating="<c:out value="${hotel.hotelInfo.hotelStarRating}" />"></span>
							</div>
							<div class="col-md-12 panel-elements-padding">
								<span ><c:out value="${hotel.hotelInfo.hotelStreetAddress}" />,<c:out value="${hotel.hotelInfo.hotelLongDestination}" /></span>
							</div>
						</div>
						<div class="col-md-4">
							<div class="col-md-12 panel-elements-padding">
								<span class="pull-right"><fmt:formatNumber type = "number" maxFractionDigits = "1" value = "${hotel.hotelInfo.hotelGuestReviewRating}" />/5 
								<c:choose>
									<c:when test="${hotel.hotelInfo.hotelGuestReviewRating eq 5}">
										Exceptional!
									</c:when>
									<c:when test="${hotel.hotelInfo.hotelGuestReviewRating gt 4}">
										Very Good!
									</c:when>
									<c:when test="${hotel.hotelInfo.hotelGuestReviewRating gt 3.4}">
										Good!
									</c:when>
									<c:otherwise>
								</c:otherwise>
								</c:choose>
								</span>
							</div>
							<div class="col-md-12 panel-elements-padding">
								<span class="pull-right"><c:out value="${hotel.hotelInfo.hotelReviewTotal}" /> reviews</span>
							</div>
							<div class="col-md-12 panel-elements-padding">
								<div>
									<span class="pull-right text-large"><i class="fa fa-<c:out value='${hotel.hotelPricingInfo.currency}'/>"></i><c:out value="${hotel.hotelPricingInfo.averagePriceValue}" /></span>
								</div>
								<c:if test="${hotel.hotelPricingInfo.percentSavings ne 0}">
									<div>
										<span class="pull-right text-large panel-elements-right-padding"><del><i class="fa fa-<c:out value='${hotel.hotelPricingInfo.currency}'/>"></i><c:out value="${hotel.hotelPricingInfo.crossOutPriceValue}" /></del></span>
									</div>
								 </c:if>
							</div>
							<div class="col-md-12 panel-elements-padding">
							<span class="pull-right small"><b>Avg/Night</b></span>
							</div>
							<c:if test="${hotel.hotelPricingInfo.percentSavings ne 0}">
									<div class="col-md-12">
										<span class="pull-right text-large" style="color: red;">Save %<c:out value="${hotel.hotelPricingInfo.percentSavings}" /></span>
									</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
   <h3>No results found for your search ...</h3> 
  </c:otherwise>
</c:choose>


<!-- <div class="row row-margin-bottom"> -->
<!-- 	<div class="col-md-12 panel-padding lib-item" data-category="view"> -->
<!-- 		<div class="lib-panel"> -->
<!-- 			<div class="row box-shadow"> -->
<!-- 				<div class="col-md-6"> -->
<!-- 					<img class="lib-img-show" src="http://lorempixel.com/850/850/?random=123"> -->
<!-- 				</div> -->
<!-- 				<div class="col-md-6"> -->
<!-- 					<div class="lib-row lib-header"> -->
<!-- 						Example library 2 -->
<!-- 						<div class="lib-header-seperator"></div> -->
<!-- 					</div> -->
<!-- 					<div class="lib-row lib-desc">Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->
<!-- <div class="row row-margin-bottom"> -->
<!-- 	<div class="col-md-12 no-padding lib-item" data-category="view"> -->
<!-- 		<div class="lib-panel"> -->
<!-- 			<div class="row box-shadow"> -->
<!-- 				<div class="col-md-6"> -->
<!-- 					<img class="lib-img-show" src="http://lorempixel.com/850/850/?random=123"> -->
<!-- 				</div> -->
<!-- 				<div class="col-md-6"> -->
<!-- 					<div class="lib-row lib-header"> -->
<!-- 						Example library 3 -->
<!-- 						<div class="lib-header-seperator"></div> -->
<!-- 					</div> -->
<!-- 					<div class="lib-row lib-desc">Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor Lorem ipsum dolor</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
</div>