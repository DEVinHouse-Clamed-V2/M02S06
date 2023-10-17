<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<!-- VALIDAR SE O ESTUDANTE FOI CADASTRADO PARA EXIBIR A MENSAGEM -->
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			Estudante cadastrado(a) com sucesso!
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>

		<div class="mb-2 d-flex justify-content-end">
			<a href="#" class="btn btn-success">Novo estudante</a>
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

				<!-- TORNAR A LISTAGEM DE ESTUDANTES DINÂMICA -->
				<tr>
					<td>12345</td>
					<td>student</td>
					<td>student@example.com</td>
					<td><a class="btn btn-warning btn-sm text-white" href="#">Editar</a>

						<a class="btn btn-danger btn-sm" href="#">Remover</a></td>
				</tr>

			</tbody>
		</table>

		<!-- ADICIONAR VALIDAÇÃO DE LISTAGEM DE ESTUDANTES VAZIA -->
		<h4>Não há estudantes cadastrados.</h4>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>