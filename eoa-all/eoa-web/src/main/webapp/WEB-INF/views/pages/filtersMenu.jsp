<nav>
	<h3> Filter Options </h3>
	<div id="guestRatingFilterContainer" class="filter-padding">
		<fieldset>
			<details open>
				<summary>
					<span id="guestRating-legend"> Guest Rating </span>
					<span>
						<a id="rankingResetFilterButton" href="#" style="display: none;"> Reset </a>
					</span>
				</summary>
				<div id="guestRating">
					<label id="guestRating5-label">
						<input type="radio" id="guestRating5" name="minGuestRating" value="5">
						<span> 5/5 </span>
					</label>
					<label id="guestRating4-label">
						<input type="radio" id="guestRating4" name="minGuestRating" value="4">
						<span> 4/5 &amp; up </span>
					</label>
					<label id="guestRating3-label">
						<input type="radio" id="guestRating3" name="minGuestRating" value="3.5">
						<span> 3.5/5 &amp; up </span>
					</label>
				</div>
			</details>
		</fieldset>
	</div>

	<div id="starRatingFilterContainer" class="filter-padding">
		<fieldset>
			<details open>
				<summary>
					<span id="starRating-legend"> Star Rating </span>
					<span>
						<a id="starRatingResetFilterButton" href="#" style="display: none;"> Reset </a>
					</span>
				</summary>
				<div id="starRating">
					<label id="starRating5-label">
						<input type="radio" id="starRating5" name="starRating" value="5">
						<span id="5-stars-filter-input"></span>
					</label>
					<label id="starRating4-label">
						<input type="radio" id="starRating4" name="starRating" value="4">
						<span id="4-stars-filter-input"></span>
					</label>
					<label id="starRating3-label">
						<input type="radio" id="starRating3" name="starRating" value="3">
						<span id="3-stars-filter-input"></span>
					</label>
				</div>
			</details>
		</fieldset>
	</div>

	<div id="totalRateFilterContainer" class="filter-padding">
		<fieldset>
			<details open>
				<summary>
					<span id="totalRate-legend"> Price Per Night </span>
					<span>
						<a id="totalRateResetFilterButton" href="#" style="display: none;"> Reset </a>
					</span>
				</summary>
				<div id="totalRate">
					<label id="totalRate-1-label">
						<input type="radio" id="totalRate1" name="totalAverageRate" value="1">
						<span>Less than $75</span>
					</label>
					<label id="totalRate-2-label">
						<input type="radio" id="totalRate2" name="totalAverageRate" value="2">
						<span>$75 to $124</span>
					</label>
					<label id="totalRate-3-label">
						<input type="radio" id="totalRate3" name="totalAverageRate" value="3">
						<span>$125 to $199</span>
					</label>
					<label id="totalRate-4-label">
						<input type="radio" id="totalRate4" name="totalAverageRate" value="4">
						<span>more than $200</span>
					</label>
				</div>
			</details>
		</fieldset>
	</div>
</nav>