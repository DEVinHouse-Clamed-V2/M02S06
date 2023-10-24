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

@WebServlet("/update-student")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/** Recuperando o identificador do estudante e buscando-o na base de dados */
		Integer registration = Integer.valueOf(request.getParameter("registration"));
		Student student = Database.getStudent(registration);

		/** Adicionando o estudante na requisição de atualização */
		request.setAttribute("student", student);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** Recuperar as informações enviadas através do formulário. */
		Integer registration = Integer.valueOf(request.getParameter("registration"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		/** Recuperar o estudante no banco de dados e atualizá-lo. */
		Student student = Database.getStudent(registration);
		if (student != null) {
			student.setName(name);
			student.setEmail(email);
		}

		/** Redirecionar a requisição para a listagem de estudantes. */
		response.sendRedirect("student");
	}
}
