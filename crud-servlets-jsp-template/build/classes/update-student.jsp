<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Atualizar Cadastro de Estudante</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container mt-3">
		<div class="mb-2 d-flex justify-content-start">
			<a href="#" class="btn btn-primary">Voltar</a>
		</div>
		<div class="mt-2 mb-2">
			<h2>Atualizar informações do estudante</h2>
		</div>
		<form action="#" method="POST">
			<div class="row">
				<div class="mb-3 col-6">
					<input type="hidden" class="form-control" name="registration"
						id="registration" value="1" />
				</div>
			</div>
			<div class="row">
				<div class="mb-3 col-6">
					<label for="name" class="form-label">Nome</label> <input
						type="text" class="form-control" name="name" id="name"
						value="student" />
				</div>
			</div>
			<div class="row">
				<div class="mb-3 col-6">
					<label for="email" class="form-label">E-mail</label> <input
						type="email" class="form-control" name="email" id="email"
						value="student@example.com" />
				</div>
			</div>

			<button type="submit" class="btn btn-success">Salvar
				alterações</button>
		</form>
	</div>
</body>
</html>