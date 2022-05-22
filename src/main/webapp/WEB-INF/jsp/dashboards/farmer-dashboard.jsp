<%@ include file="../common/header.jspf"%>
<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="#" class="navbar-brand">Insurance</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li><a href="/admin-login">Admin</a></li>
			<li  class="active"><a href="/farmer-login">Farmer</a></li>
			<li><a href="/officer-login">Claim Officer</a></li>
		</ul>
	</div>
</nav>
<div class="container">
<h1 class="text-center">Welcome ${name}</h1>
</div>
<%@ include file="../common/footer.jspf"%>