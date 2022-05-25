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
				<li class="nav-item"><a class="nav-link active" href="#">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/due-claims">Claims to be Processed</a></li>

			</ul>
			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
				&nbsp;&nbsp;
			<a class="btn btn-outline-success" href="/log-out">LogOut</a>
			</form>
		</div>
	</div>
</nav>
<div class="container">
	<h1 class="text-center">Welcome ${claimOfficer.firstName}
		${claimOfficer.lastName}</h1>
	<table class="table caption-top table-striped">
		<caption>Your Profile Details are</caption>
		<thead>
			<tr>
				<td>Fields</td>
				<td>Values</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Name</td>
				<td>${claimOfficer.firstName} ${claimOfficer.lastName}</td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${claimOfficer.dOB}" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>${claimOfficer.gender}</td>
			</tr>
			<tr>
				<td>Contact</td>
				<td>${claimOfficer.contact}</td>
			</tr>
			<tr>
				<td>Address</td>
				<td>${claimOfficer.addLine1},${claimOfficer.city},${claimOfficer.state},${claimOfficer.zipCode}</td>
			</tr>
		</tbody>
	</table>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="../common/footer.jspf"%>