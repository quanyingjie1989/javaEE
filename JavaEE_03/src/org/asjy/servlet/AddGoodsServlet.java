package org.asjy.servlet;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asjy.Bean.Goods;
import org.asjy.service.GoodsService;
import org.asjy.service.impl.GoodsServiseImpl;


@WebServlet("/addgoodsservlet")
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AddGoodsServlet() {
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String goodsName= request.getParameter("name");
		double goodsPrice=Double.parseDouble(request.getParameter("price"));
		
		GoodsService service= new GoodsServiseImpl();
		int ret= service.addGoods(new Goods(id,goodsName,goodsPrice));
		
		if(ret == -1) {
			request.setAttribute("msg", "ÃÌº” ß∞‹");
			request.getRequestDispatcher("addgoodsservlet").forward(request, response);
		}else {
			request.getRequestDispatcher("searchgoodsservlet").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
