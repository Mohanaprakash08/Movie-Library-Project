package ControllerPackage;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAOPackage.DAO1;
import DTOPackage.Movie;

@WebServlet("/editmovie")
public class EditMovie extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		DAO1 dao = new DAO1();
		try {
			Movie m = dao.findMovieById(id);
			req.setAttribute("movie", m);
			RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
			dispatcher.include(req, resp);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
