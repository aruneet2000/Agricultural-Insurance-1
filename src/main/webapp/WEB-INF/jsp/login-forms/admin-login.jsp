<%@ include file="../common/header.jspf"%>
<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="#" class="navbar-brand">Insurance</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li class="active"><a href="/admin-login">Admin</a></li>
			<li><a href="/farmer-login">Farmer</a></li>
			<li><a href="/officer-login">Claim Officer</a></li>
		</ul>
	</div>
</nav>
<h1 class="text-center">Login as Admin</h1>
<div class="container">
	<font color="red">${errorMessage}</font>
	<form method="post">
		<fieldset class="form-group">
			<label>User ID</label> <input class="form-control" type="text"
				name="userId" placeholder="Enter Your ID" autofocus required />
		</fieldset>
		<fieldset class="form-group">
			<label>Password</label> <input class="form-control" type="password"
				name="password" placeholder="Enter Password" required />
		</fieldset>
		<input class="btn btn-success" type="submit" value="Submit" />
	</form>
</div>
<br>
<%@ include file="../common/footer.jspf"%>