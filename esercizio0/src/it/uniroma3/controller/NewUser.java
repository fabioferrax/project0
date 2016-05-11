package it.uniroma3.controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma3.dialog.Dialog;
import it.uniroma3.model.Utente;
import it.uniroma3.persistence.DAO;
import it.uniroma3.persistence.UserDAO;
@WebServlet("newUser")
public class NewUser extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("users-unit");
		
		Utente user = new Utente(request.getParameter("username"),request.getParameter("password"));		
		DAO userDao = new UserDAO(emf);
		userDao.save(user);
		
		request.setAttribute("Utente", user);
		request.setAttribute("Dialog", new Dialog("Utente registrato"));
		String nextPage = "/success.jsp";
		ServletContext application = getServletContext();		
		RequestDispatcher rd = application.getRequestDispatcher(nextPage);		
		rd.forward(request, response);
	}

}
