package org.asjy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.asjy.Bean.Goods;
import org.asjy.service.GoodsService;
import org.asjy.service.impl.GoodsServiseImpl;

@WebServlet("/searchgoodsservlet")
public class SearchGoodsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GoodsService service=new GoodsServiseImpl();
		int pageNum =0;
		if(request.getParameter("pageNum") == null) {
			pageNum = 1;
			System.out.println(pageNum);
		}else {
			pageNum =Integer.parseInt(request.getParameter("pageNum"));
			System.out.println(pageNum);
		}
		String goodsName=request.getParameter("goodname");
		
		Goods goods =new Goods(null, goodsName, null);
		goods.setPageNum(pageNum);

		List<Goods> goodsList =service.searchGoods(goods);
		
		request.setAttribute("goodsList", goodsList);
		request.setAttribute("pageNum", pageNum);
		
		request.getRequestDispatcher("searchgoods.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
