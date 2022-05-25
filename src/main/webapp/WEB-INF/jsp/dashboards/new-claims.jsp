<%@ include file="../common/header.jspf"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Farmer</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active" href="#">Raise
						Claim</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/farmer-dashboard">Dashboard</a></li>
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
<h1 class="text-center">Raise A Claim</h1>
<div class="container">
	<form:form method="post" modelAttribute="claimRequest">
		<fieldset class="form-group">
			<form:label path="farmerId">Farmer ID</form:label>
			<form:input class="form-control" type="text" path="farmerId"
				placeholder="${claimRequest.farmerId}" value="${claimRequest.farmerId}" disabled="true" />
			<form:errors path="farmerId" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="claimId">Claim ID</form:label>
			<form:input class="form-control" type="text" path="claimId"
				placeholder="${claimRequest.claimId}" value="${claimRequest.claimId}" />
			<form:errors path="claimId" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="claimDate">Claim Date</form:label>
			<form:input class="form-control" type="text" path="claimDate"
				placeholder="${claimRequest.claimDate}" disabled="false" />
			<form:errors path="claimDate" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="claimDate">Claim Type</form:label>
			<form:select path="claimType" cssClass="form-select">
				<c:forEach items="${claimTypeList}" var="claimType" varStatus="loop">
					<option value="${claimType}">${claimType}</option>
				</c:forEach>
			</form:select>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="policyId">Policy ID</form:label>
			<form:input class="form-control" type="text" path="policyId"
				placeholder="Enter Policy ID" required="true" />
			<form:errors path="policyId" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="claimAmount">Claim Amount</form:label>
			<form:input class="form-control" type="text" path="claimAmount"
				placeholder="Enter Claim Amount" required="true" />
			<form:errors path="claimAmount" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input class="form-control" type="text" path="desc"
				placeholder="Kindly add a description" required="true" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="remarks">Remarks</form:label>
			<form:input class="form-control" type="text" path="remarks"
				placeholder="Give Some Remarks" />
			<form:errors path="remarks" cssClass="text-warning" />
		</fieldset>
		<button class="btn btn-success" type="submit">Submit</button>
		<a class="btn btn-danger" href="/farmer-dashboard">Cancel</a>
	</form:form>
</div>
<%@ include file="../common/footer.jspf"%>