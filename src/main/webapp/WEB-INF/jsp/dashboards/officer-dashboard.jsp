<%@ include file="../common/header.jspf"%>
<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="#" class="navbar-brand">Insurance</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="/">Home</a></li>
			<li><a href="/admin-login">Admin</a></li>
			<li><a href="/farmer-login">Farmer</a></li>
			<li  class="active"><a href="/officer-login">Claim Officer</a></li>
		</ul>
	</div>
</nav>
<div class="container">
<h1 class="text-center">Welcome ${claimOfficer.firstName} ${claimOfficer.lastName}</h1>
<p>Your Details are</p>
<ul>
<li>First Name : ${claimOfficer.firstName}</li>
<li>Last Name : ${claimOfficer.lastName}</li>
<li>Date of Birth : ${claimOfficer.dOB}</li>
<li>Gender : ${claimOfficer.gender}</li>
<li>Contact : ${claimOfficer.contact}</li>
<li>Bank Name : ${claimOfficer.bankName}</li>
<li>Branch Name : ${claimOfficer.bankBranch}</li>
<li>Address Line 1 : ${claimOfficer.addLine1}</li>
<li>Address Line 2 : ${claimOfficer.addLine2}</li>
<li>City : ${claimOfficer.city}</li>
<li>State : ${claimOfficer.state}</li>
<li>Zip Code : ${claimOfficer.zipCode}</li>
<li>Officer Id : ${claimOfficer.officerId}</li>
<li>Password : ${claimOfficer.password}</li>
</ul>
</div>
<%@ include file="../common/footer.jspf"%>