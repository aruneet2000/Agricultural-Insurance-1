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
				<li class="nav-item"><a class="nav-link active"
					href="/farmer-login">Farmer</a></li>
				<li class="nav-item"><a class="nav-link" href="/officer-login">Claim
						Officer</a></li>
			</ul>
		</div>
	</div>
</nav>
<h1 class="text-center">Register as Farmer</h1>
<div class="container">
	<form:form method="post" modelAttribute="farmer">
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
			<form:select path="gender" cssClass="form-select">
				<option value="">Select Your Gender</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				<option value="Other">Other</option>
			</form:select>
			<form:errors path="gender" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="contact">Contact Number</form:label>
			<form:input class="form-control" type="text" path="contact"
				placeholder="Your Contact Number" required="true" />
			<form:errors path="contact" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="addLine1">Address Line 1</form:label>
			<form:input class="form-control" type="text" path="addLine1"
				placeholder="Enter Your Address line 1" required="true" />
			<form:errors path="addLine1" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="addLine2">Address Line 2</form:label>
			<form:input class="form-control" type="text" path="addLine2"
				placeholder="Enter Your Address line 2" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="city">City</form:label>
			<form:input class="form-control" type="text" path="city"
				placeholder="Enter City" required="true" />
			<form:errors path="city" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="state">State</form:label>
			<form:input class="form-control" type="text" path="state"
				placeholder="Enter State" required="true" />
			<form:errors path="state" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="zipCode">Zip Code</form:label>
			<form:input class="form-control" type="number" path="zipCode"
				placeholder="Enter Zip/Postal Code" required="true" />
			<form:errors path="zipCode" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="farmerId">Farmer ID</form:label>
			<form:input class="form-control" type="text" path="farmerId"
				placeholder="Create Your ID" required="true" />
			<form:errors path="farmerId" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="password">Password</form:label>
			<form:input class="form-control" type="password" path="password"
				placeholder="Create Your Password" required="true" />
			<form:errors path="password" cssClass="text-warning" />
		</fieldset>
		<button class="btn btn-success" type="submit">Submit</button>
	</form:form>
	<div>
		Already have an account? <a href="/farmer-login">Click here</a> to
		Login
	</div>
</div>
<br><br><br><br>
<%@ include file="../common/footer.jspf"%>