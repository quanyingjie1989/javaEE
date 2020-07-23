package org.asjy.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.asjy.user.bean.XxUser;
import org.asjy.user.service.XxUserService;
import org.asjy.user.service.impl.XxUserServiceImpl;


@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		
		XxUserService service= new XxUserServiceImpl();
		try {
			XxUser user = service.login(username, password);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
			request.getRequestDispatcher("searchgoodsservlet").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
