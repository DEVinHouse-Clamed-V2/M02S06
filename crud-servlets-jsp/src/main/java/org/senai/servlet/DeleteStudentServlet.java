package org.senai.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.database.Database;

@WebServlet("/delete-student")
public class DeleteStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/** Recuperar a matrícula do estudante, e removê-lo da lista de estudantes. */
		Integer registration = Integer.valueOf(request.getParameter("registration"));
		Database.remove(registration);

		/** Redirecionar novamente para a listagem de estudantes */
		response.sendRedirect("student");
	}
}
