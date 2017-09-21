<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div class="jumbotron">
		<h1 style="text-align: center">Add Todos</h1>
	</div>
	<form:form method="post" modelAttribute="todo">
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="desc">Description ::</form:label>
			<form:input path="desc" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="desc" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="targetDate">Target Date ::</form:label>
			<form:input path="targetDate" type="text" class="form-control"
				required="required" />
			<br>
			<form:errors path="targetDate" cssClass="text-warning"></form:errors>
		</fieldset>
		<button class="btn btn-success">Add</button>

	</form:form>

</div>

<%@ include file="common/footer.jspf" %>