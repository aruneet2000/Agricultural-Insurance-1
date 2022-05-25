<%@ include file="../common/header.jspf"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Insurance</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/admin-login">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="/farmer-login">Farmer</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="/officer-login">Claim Officer</a></li>
			</ul>
		</div>
	</div>
</nav>
<h1 class="text-center">Login as Claim Officer</h1>
<div class="container">
	<font color="red">${errorMessage}</font>
	<form method="post">
		<fieldset class="form-group">
			<label>Officer ID</label> <input class="form-control" type="text"
				name="officerId" placeholder="Enter Your ID" autofocus required />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input class="form-control" type="password"
				name="password" placeholder="Enter Password" required />
		</fieldset>
		<input class="btn btn-success" type="submit" value="Submit" />
	</form>
	<div>
		Don't have an account? <a href="/officer-registration">Click here</a>
		to Create a new account
	</div>
</div>
<br><br><br><br>
<br><br><br>
<%@ include file="../common/footer.jspf"%>