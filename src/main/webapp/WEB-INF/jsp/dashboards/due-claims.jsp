<%@ include file="../common/header.jspf"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Claim Officer</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link"
					href="/officer-dashboard">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link active" href="#">Claims
						to be Processed</a></li>

			</ul>
			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
				&nbsp;&nbsp; <a class="btn btn-outline-success" href="/log-out">LogOut</a>
			</form>
		</div>
	</div>
</nav>
<div class="container">
	<h1 class="text-center">Welcome ${claimOfficer.firstName}
		${claimOfficer.lastName}</h1>
	<table class="table caption-top table-striped">
		<caption>Approval Requests for Claims are</caption>
		<thead>
			<tr>
				<td>Farmer ID</td>
				<td>Claim ID</td>
				<td>Claim Type</td>
				<td>Claim Amount</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dueClaimRequests}" var="claim">
				<tr>
					<td><a href="/farmer?farmerId=${claim.farmerId}">${claim.farmerId}</a></td>
					<td>${claim.claimId}</td>
					<td>${claim.claimType}</td>
					<td>${claim.claimAmount}</td>
					<td><a href="/approve-claim?claimId=${claim.claimId}" type="button"
						class="btn btn-success">Approve</a></td>
					<td><a href="/reject-claim?claimId=${claim.claimId}" type="button"
						class="btn btn-warning">Reject</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<br>
<br>
<br>
<br>
<%@ include file="../common/footer.jspf"%>