<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">


		<h1>Your Todos Are :</h1>
		<br>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Description</th>
					<th>Date</th>
					<th>Is It Done ?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">

					<tr>
						<td>${todo.desc}</td>
						<td><fmt:formatDate value="${todo.targetDate}"
								pattern="dd/MM/yyyy"></fmt:formatDate></td>
						<td>${todo.isdone}</td>
						<td><a class="btn btn-success"
							href="/update-todo?id=${todo.id}" type="button">Update</a></td>

						<td><a class="btn btn-warning" type="button"
							href="/delete-todo?id=${todo.id }">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<div>
			<a class="btn-btn-default" href="/addtodo">Add New Todo</a>
		</div>


	</div>
<%@ include file="common/footer.jspf" %>