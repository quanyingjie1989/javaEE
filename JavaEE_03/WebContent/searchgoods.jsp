<%@page import="org.asjy.user.bean.XxUser"%>
<%@page import="org.asjy.Bean.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
你好:<%=session.getAttribute("user") == null ? " " :((XxUser)session.getAttribute("user")).getUsername() %>
<h1>商品列表</h1>
<%=request.getAttribute("msg") == null ?"":request.getAttribute("msg") %>
<form action="searchgoodsservlet">
商品名称 :<input type="text" name="goodname"/><input type="submit" value="查询">
</form>

<table width="500px" border="1">
<tr> 
	<th>编号</th>
	<th>商品名称</th>
	<th>价格</th>
	<th>操作</th>
</tr>
<%
List<Goods> list=(List<Goods>)request.getAttribute("goodsList");
for (Goods good : list) {
%>
<tr> 
	<th><%=good.getId() %></th>
	<th><%=good.getGoodsName() %></th>
	<th><%=good.getGoodsPricae() %></th>
	<th>
		<a href="getgoodbyidservlet?id=<%=good.getId() %>">修改</a> 
		<a href="javascript:void(0);" onclick="del(<%=good.getId() %>)">删除</a>
	</th>
</tr>
<% } %>
</table>

<p><a href="searchgoodsservlet?pageNum=<%=Integer.parseInt(request.getAttribute("pageNum").toString()) + 1%>">下一页</a></p>
<p><a href="searchgoodsservlet?pageNum=<%=Integer.parseInt(request.getAttribute("pageNum").toString()) - 1%>">上一页</a></p>

<a href="addgoods.jsp">添加商品</a>
</body>
<script type="text/javascript">
	function del(id) {
		if(confirm("是否确定删除?")){
			window.location.href="deletegoodservlet?id="+id;
		}
	}

</script>
</html>