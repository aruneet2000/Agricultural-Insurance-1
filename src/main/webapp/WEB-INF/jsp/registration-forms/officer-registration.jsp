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
			<li class="active"><a href="/officer-login">Claim Officer</a></li>
		</ul>
	</div>
</nav>
<h1 class="text-center">Register as Claim Officer</h1>
<div class="container">
	<form:form method="post" modelAttribute="claimOfficer">
		<fieldset class="form-group">
			<form:label path="firstName">First Name</form:label>
			<form:input class="form-control" type="text" path="firstName"
				placeholder="Your First Name" autofocus="true" required="true" />
			<form:errors path="firstName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="lastName">Last Name</form:label>
			<form:input class="form-control" type="text" path="lastName"
				placeholder="Your Last Name" required="true" />
			<form:errors path="lastName" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
				<form:label path="dOB">Date of Birth</form:label>
				<form:input path="dOB" type="text" class="form-control"
					placeholder="Your Date of Birth" required="required" />
				<form:errors path="dOB" cssClass="text-warning" />
			</fieldset>
		<fieldset class="form-group">
			<form:label path="gender">Gender</form:label>
			<form:input class="form-control" type="text" path="gender"
				maxlength="1" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="contact">Contact Number</form:label>
			<form:input class="form-control" type="text" path="contact"
				placeholder="Your Contact Number" minlength="10" maxlength="10" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="bankName">Bank Name</form:label>
			<form:input class="form-control" type="text" path="bankName"
				placeholder="Enter Bank Name" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="bankBranch">Bank Branch</form:label>
			<form:input class="form-control" type="text" path="bankBranch"
				placeholder="Enter Bank's Branch Name" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="addLine1">Address Line 1</form:label>
			<form:input class="form-control" type="text" path="addLine1"
				placeholder="Enter Your Address line 1" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="addLine2">Address Line 2</form:label>
			<form:input class="form-control" type="text" path="addLine2"
				placeholder="Enter Your Address line 2" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="city">City</form:label>
			<form:input class="form-control" type="text" path="city"
				placeholder="Enter City" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="state">State</form:label>
			<form:input class="form-control" type="text" path="state"
				placeholder="Enter State" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="zipCode">Zip Code</form:label>
			<form:input class="form-control" type="number" path="zipCode"
				placeholder="Enter Zip/Postal Code" maxlength="6" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="officerId">Claim Officer ID</form:label>
			<form:input class="form-control" type="text" path="officerId"
				placeholder="Create Your ID" required="true" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="password">Password</form:label>
			<form:input class="form-control" type="password" path="password"
				placeholder="Create Your Password" required="true" />
		</fieldset>
		<button class="btn btn-success" type="submit">Submit</button>
	</form:form>
	<div>
		Already have an account? <a href="/officer-login">Click here</a> to
		Login
	</div>
</div>
<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
		
	<script>
		$('#targetDate').datepicker({
			format : 'dd/mm/yyyy'
		});
	</script>
<%@ include file="../common/footer.jspf"%>