<%@ include file="../common/header.jspf"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Admin</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="/admin-dashboard">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link active" href="#">Pending Requests</a></li>
				<li class="nav-item"><a class="nav-link"
					href="#">Dummy function</a></li>

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
	<h1 class="text-center">Welcome ${admin.userId}</h1>

	<table class="table caption-top table-striped">
		<caption>Pending Requests of Claim Officer(s) For Approval are</caption>
		<thead>
			<tr>
				<td>Officer ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${unApprovedOfficer}" var="officer">
				<tr>
					<td>${officer.officerId}</td>
					<td>${officer.firstName}</td>
					<td>${officer.lastName}</td>
					<td><a href="/approve-officer?id=${officer.id}" type="button"
						class="btn btn-success">Approve</a></td>
					<td><a href="/reject-officer?id=${officer.id}" type="button"
						class="btn btn-warning">Reject</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1 class="text-center">${emptyList}</h1>
	
	<table class="table caption-top table-striped">
		<caption>Pending Requests of Farmer(s) For Approval are</caption>
		<thead>
			<tr>
				<td>Farmer ID</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${unApprovedFarmer}" var="farmer">
				<tr>
					<td>${farmer.farmerId}</td>
					<td>${farmer.firstName}</td>
					<td>${farmer.lastName}</td>
					<td><a href="/approve-farmer?id=${farmer.id}" type="button"
						class="btn btn-success">Approve</a></td>
					<td><a href="/reject-farmer?id=${farmer.id}" type="button"
						class="btn btn-warning">Reject</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h1 class="text-center">${emptyList}</h1>
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
<br>
<br>
<br>
<br>
<br>
<br>
<%@ include file="../common/footer.jspf"%>