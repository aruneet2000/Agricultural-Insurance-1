<%@ include file="../common/header.jspf"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Farmer</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link"
					href="/farmer-dashboard">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link active" href="#">Claims</a></li>

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
	<h1 class="text-center">Welcome ${farmer.firstName}
		${farmer.lastName}</h1>
	<table class="table caption-top table-striped">
		<caption>Your Claims Are</caption>
		<thead>
			<tr>
				<td>Claim ID</td>
				<td>Farmer ID</td>
				<td>Policy ID</td>
				<td>Claim Type</td>
				<td>Claim Date</td>
				<td>Claim Amount</td>
				<td>Description</td>
				<td>Remarks</td>
				<td>Status</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${claimRequest}" var="claim">
				<tr>
					<td>${claim.claimId}</td>
					<td>${claim.farmerId}</td>
					<td>${claim.policyId}</td>
					<td>${claim.claimType}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${claim.claimDate}" /></td>
					<td>${claim.claimAmount}</td>
					<td>${claim.desc}</td>
					<td>${claim.remarks}</td>
					<td>${claim.due}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="../common/footer.jspf"%>