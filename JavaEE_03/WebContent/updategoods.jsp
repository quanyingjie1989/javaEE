<%@page import="org.asjy.user.bean.XxUser"%>
<%@page import="org.asjy.Bean.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
你好 :<%=session.getAttribute("user") == null ? "" :((XxUser)session.getAttribute("user")).getUsername() %>
<h1>添加商品</h1>
<%=request.getAttribute("msg") == null ?"":request.getAttribute("msg") %>
<form action="updategoodsservlet" method="post">
<% Goods good=(Goods)request.getAttribute("good"); %>

<p>商品编号 : <input type="text" name="id" value="<%=good.getId() %>"></p>
<p>商品名称 :<input type="text" name="name" value="<%=good.getGoodsName() %>"></p>
<p>商品价格 :<input type="text" name="price" value="<%=good.getGoodsPricae() %>"></p>
<p><input type="submit" value="提交"></p>

</form>
</body>
</html>