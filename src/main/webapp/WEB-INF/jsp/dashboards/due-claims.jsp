<%@ include file="../common/header.jspf"%>
<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="#" class="navbar-brand">Insurance</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li><a href="/officer-dashboard">Dashboard</a></li>
			<li class="active"><a href="#">Claims to be Processed</a></li>
			<li class="log-out"><a href="/">Log Out</a></li>
		</ul>
	</div>
</nav>
<div class="container">
<h1 class="text-center">Welcome ${claimOfficer.firstName} ${claimOfficer.lastName}</h1>
<table class="table table-striped">
		<caption>Approval Requests are</caption>
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
</div>

<br><br><br><br>
<%@ include file="../common/footer.jspf"%>