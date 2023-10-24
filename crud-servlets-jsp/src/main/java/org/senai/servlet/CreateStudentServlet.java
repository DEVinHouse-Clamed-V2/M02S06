package org.senai.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.database.Database;
import org.senai.model.Student;

@WebServlet("/create-student")
public class CreateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * Despachando a requisição interceptada por esse Servlet para o nosso JSP
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("/create-student.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/** Recuperando dados enviados através do formulário */
		Integer registration = Integer.valueOf(request.getParameter("registration"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		/** Criando a instância do estudante, e salvando-o */
		Student student = new Student(registration, name, email);
		Database.add(student);

		/**
		 * Redirecionar a aplicação para a listagem de estudantes, informando que um
		 * novo foi registrado
		 */
		response.sendRedirect("student?registered=true");
	}
}
