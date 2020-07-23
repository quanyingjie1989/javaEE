package org.asjy.servlet;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asjy.Bean.Goods;
import org.asjy.service.GoodsService;
import org.asjy.service.impl.GoodsServiseImpl;

@WebServlet("/updategoodsservlet")
public class UpdateGoodsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(req.getParameter("id"));
		String goodsName= req.getParameter("name");
		double goodsPrice=Double.parseDouble(req.getParameter("price"));
		
		GoodsService service= new GoodsServiseImpl();
		int ret= service.update(new Goods(id,goodsName,goodsPrice));
		if(ret == -1) {
			req.setAttribute("msg", "修改失败");
			req.getRequestDispatcher("searchgoodsservlet").forward(req, resp);
		}else {
			req.setAttribute("msg", "修改成功");
			req.getRequestDispatcher("searchgoodsservlet").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	
	
	

}
