package hello;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Persons> personsList = null;
		try {
			personsList = new PersonsDAO().showPersons();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("personsList", personsList);
		req.getRequestDispatcher("./show.jsp").forward(req, resp);
	}
}
