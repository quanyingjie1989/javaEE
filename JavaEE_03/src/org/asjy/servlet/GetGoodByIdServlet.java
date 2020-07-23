package org.asjy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asjy.Bean.Goods;
import org.asjy.service.GoodsService;
import org.asjy.service.impl.GoodsServiseImpl;

@WebServlet("/getgoodbyidservlet")
public class GetGoodByIdServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		
		GoodsService service =new GoodsServiseImpl();
		try {
			Goods goods=service.getGoodsById(id);
			req.setAttribute("good", goods);
			req.getRequestDispatcher("updategoods.jsp").forward(req, resp);
		}catch (Exception e) {
			e.getMessage();
		}
	}
}
