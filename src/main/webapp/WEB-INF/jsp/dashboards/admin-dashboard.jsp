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
				<li class="nav-item"><a class="nav-link active" href="#">Dashboard</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/pending-requests">Pending Requests</a></li>

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
<br>
<br>
<br>
<%@ include file="../common/footer.jspf"%>