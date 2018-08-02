<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table id="userSearchHistoryTable" class="table table-striped table-bordered" style="width: 100%">
	<thead>
		<tr>
			<th>Search Location</th>
			<th>Search Trip Start Date</th>
			<th>Search Trip End Date</th>
			<th>Search Execution Time</th>
		</tr>
	</thead>
	<c:forEach var="userSearchHistoryRecord" items="${userSearchHistoryForm.userSearchHistory}">
		<tbody>
			<tr>
				<td>
					<c:out value="${userSearchHistoryRecord.searchLocation}" />
				</td>
				<td>
					<c:out value="${userSearchHistoryRecord.searchStartDate}" />
				</td>
				<td>
					<c:out value="${userSearchHistoryRecord.searchEndDate}" />
				</td>
				<td>
					<c:out value="${userSearchHistoryRecord.searchExecutionDate}" />
				</td>
			</tr>
		</tbody>
	</c:forEach>
</table>