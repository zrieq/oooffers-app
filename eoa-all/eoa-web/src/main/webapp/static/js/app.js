var applicationContext;

$(document).ready(
		function() {
			initApplicationContext();

			$('#rankingResetFilterButton').click(
					function(e) {
						resetFilterButton(e,
								'input[name=minGuestRating]:checked', this);
					});
			$('#starRatingResetFilterButton').click(
					function(e) {
						resetFilterButton(e,
								'input[name=minStarRating]:checked', this);
					});
			$('#totalRateResetFilterButton').click(
					function(e) {
						resetFilterButton(e,
								'input[name=totalAverageRate]:checked', this);
					});

			$('input[type=radio][name=minGuestRating]').change(function(e) {
				filterInputChange('#rankingResetFilterButton');
			});

			$('input[type=radio][name=minStarRating]').change(function(e) {
				filterInputChange('#starRatingResetFilterButton');
			});

			$('input[type=radio][name=totalAverageRate]').change(function(e) {
				filterInputChange('#totalRateResetFilterButton');
			});

			$.fn.center = function center() {
				this.css("position", "absolute");
				this.css("top", ($(window).height() - this.height()) / 2
						+ $(window).scrollTop() + "px");
				this.css("left", ($(window).width() - this.width()) / 2
						+ $(window).scrollLeft() + "px");
				return this;
			};

			initFiltersSection();
			initSearchDatePickers();
			initHotelsRating();
		});

function initApplicationContext() {
	applicationContext = $("body").attr("data-application-context") + "/";
}

function initFiltersSection() {
	$('#5-stars-filter-input').html(createStarsSpan(5));
	$('#4-stars-filter-input').html(createStarsSpan(4));
	$('#3-stars-filter-input').html(createStarsSpan(3));
}

function resetFilterButton(e, filterRadioSelector, resetFilterButtonElement) {
	e.preventDefault();
	$(filterRadioSelector).each(function() {
		$(this).prop('checked', false);
	});
	$(resetFilterButtonElement).hide();
	performAjaxCall(applicationContext + "hotel-offers/search",
			getInputValues());
}

function filterInputChange(resetFilterButtonID) {
	$(resetFilterButtonID).show();
	performAjaxCall(applicationContext + "hotel-offers/search",
			getInputValues());
}

function getInputValues() {
	var $inputs = $(':input');
	var values = {};
	$inputs.each(function() {
		if (this.name === "") {
			return;
		}

		switch (this.type) {
		case 'text':
		case 'hidden':
		case 'password':
			values[this.name] = $(this).val();
			break;
		case 'checkbox':
		case 'radio':
			if (this.checked) {
				values[this.name] = $(this).val();
			}
			break;
		case 'button':
		case 'reset':
		case 'submit':
			break;
		}

	});
	return values;
}

function initSearchForm() {
	initSearchDatePickers();
	initLocationPicker();
	initHotelsRating();
}

function initHotelsRating() {
	$('[data-hotel-star-rating]').each(function() {
		$(this).html(createStars($(this).attr('data-hotel-star-rating')));
	});
}

function initSearchDatePickers() {
	// set default dates
	var start = new Date();
	// set end date to max one year period:
	var end = new Date(new Date().setYear(start.getFullYear() + 1));

	$('#startdate').datepicker({
		startDate : start,
		endDate : end,
		autoclose : true,
	// update "toDate" defaults whenever "fromDate" changes
	}).on(
			'changeDate',
			function(selected) {
				// set the "toDate" start to not be later than
				// "fromDate" ends:
				$('#enddate').datepicker('setStartDate',
						new Date(selected.date.valueOf()));
			});

	$('#enddate').datepicker({
		startDate : start,
		endDate : end,
		autoclose : true,
	// update "fromDate" defaults whenever "toDate" changes
	}).on('changeDate', function(selected) {
		// set the "fromDate" end to not be later than "toDate"
		// starts:
		var endDate = new Date(selected.date.valueOf());
		$('#startdate').datepicker('setEndDate', endDate);
	});

	if ($('#endDateInput').val() != "") {
		$('#startdate').datepicker('setEndDate',
				new Date($('#endDateInput').val()));
	}
	if ($('#startDateInput').val() != "") {
		$('#enddate').datepicker('setStartDate',
				new Date($('#startDateInput').val()));
	}
}
function initLocationPicker() {
	// var latlng = new google.maps.LatLng(-33.8688, 151.2195);
	// var map = new google.maps.Map(document.getElementById('map'), {
	// center : latlng,
	// zoom : 13,
	// mapTypeId : 'roadmap'
	// });
	//
	// // Create the search box and link it to the UI element.
	// var input = document.getElementById('pac-input');
	// var searchBox = new google.maps.places.SearchBox(input);
	// map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

	var autocomplete = new google.maps.places.Autocomplete((document
			.getElementById('pac-input')), {
		types : [ 'geocode' ]
	});
	google.maps.event
			.addListener(
					autocomplete,
					'place_changed',
					function() {
						var place = autocomplete.getPlace();
						if (typeof place.formatted_address !== "undefined") {
							document.getElementById('pac-input').value = place.formatted_address;
						}
					});

}

function performAjaxCall(url, data) {
	$.ajax({
		url : url,
		data : data,
		error : function() {

		},
		beforeSend : function() {
			$('#content').block({
				message : '<h3>Loading your data...</h1>',
			});
			$('.blockUI.blockMsg').center();
		},
		success : function(data) {
			$('#sitebody').replaceWith(data);
			initSearchForm();
		},
		type : 'GET',
		complete : function() {
			$('#content').unblock();
		}
	});
}

function createStars(numberOfStars) {
	var stars = "";
	for ( var i = 0; i < numberOfStars; i++) {
		stars += '<span class="glyphicon glyphicon-star"></span>';
	}
	return stars;
}

function createStarsSpan(numberOfStars) {
	var stars = createStars(numberOfStars);
	stars += " " + numberOfStars + "Stars";
	return stars;
}