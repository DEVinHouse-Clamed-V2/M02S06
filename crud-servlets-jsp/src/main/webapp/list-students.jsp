<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem de Estudantes</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container mt-3">

		<c:if test="${isRegisterRequest}">
			<div class="alert alert-success alert-dismissible fade show"
				role="alert">
				Estudante cadastrado(a) com sucesso!
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
		</c:if>

		<div class="mb-2 d-flex justify-content-end">
			<a href="/clamed/create-student" class="btn btn-success">Novo
				estudante</a>
		</div>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>Matrícula</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.registration}</td>
						<td>${student.name}</td>
						<td>${student.email}</td>
						<td>
							<a class="btn btn-warning btn-sm text-white"
							href="/clamed/update-student?registration=${student.registration}">Editar</a>
							
							<a class="btn btn-danger btn-sm"
							href="/clamed/delete-student?registration=${student.registration}">Remover</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

		<c:if test="${empty students}">
			<h4>Não há estudantes cadastrados.</h4>
		</c:if>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>