<%@ include file="../common/header.jspf"%>
<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="#" class="navbar-brand">Insurance</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li><a href="/admin-login">Admin</a></li>
			<li class="active"><a href="/farmer-login">Farmer</a></li>
			<li><a href="/officer-login">Claim Officer</a></li>
		</ul>
	</div>
</nav>
<h1 class="text-center">Login as Farmer</h1>
<div class="container">
	<font color="red">${errorMessage}</font>
	<form method="post">
		<fieldset class="form-group">
			<label>Farmer ID</label> <input class="form-control" type="text"
				name="name" placeholder="Enter Your ID" autofocus required />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input class="form-control" type="password"
				name="password" placeholder="Enter Password" required />
		</fieldset>
		<input class="btn btn-success" type="submit" value="Submit" />
	</form>
	<div>
		Don't have an account? <a href="/farmer-registration">Click here</a>
		to Create a new account
	</div>
</div>
<br><br><br><br><br>
<br><br><br><br><br>
<br><br>
<%@ include file="../common/footer.jspf"%>