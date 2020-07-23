package org.asjy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.asjy.Bean.Goods;
import org.asjy.service.GoodsService;
import org.asjy.service.impl.GoodsServiseImpl;

@WebServlet("/deletegoodservlet")
public class DeleteGoodServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id = Integer.parseInt(req.getParameter("id"));
	GoodsService service=new GoodsServiseImpl();

	try {
		service.deleteGood(id);
		req.setAttribute("msg", "É¾³ý³É¹¦");
		req.getRequestDispatcher("searchgoodsservlet").forward(req, resp);
	}catch(Exception e){
		//req.setAttribute("msg", "É¾³ýÊ§°Ü");
		//req.getRequestDispatcher("searchgoodsservlet").forward(req, resp);
		resp.sendRedirect("error.jsp");
		}
	}
}
