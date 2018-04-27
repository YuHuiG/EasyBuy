
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="/Easybuy/css/style.css" />
<script type="text/javascript" src="/Easybuy/scripts/NewFile.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="../images/logo.gif" />
		</div>
		<div class="help">
			<a href="index.jsp">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li><a href="/Easybuy/manage/index.jsp">首页</a></li>
				<li><a href="/Easybuy/UserServlet?action=query">用户</a></li>
				<li><a href="/Easybuy/ProductServlet?action=query">商品</a></li>
				<li class="current"><a href="../OrderServlet?action=query">订单</a></li>
				<li><a href="/Easybuy/CommentServlet?action=queryh">留言</a></li>
				<li><a href="/Easybuy/NewsServlet?action=query">新闻</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="welcome wrap">
			<%@include file="hear.jsp"%>
		</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
	</div>
	<div id="main" class="wrap">
		<div id="menu-mng" class="lefter">
			<div class="box">
				<dl>
					<dt>用户管理</dt>
					<dd>
						<em><a href="/Easybuy/manage/user-add.jsp">新增</a></em><a
							href="/Easybuy/UserServlet?action=query">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					<dd>
						<em><a href="/Easybuy/CategropServlet?action=addcate">新增</a></em><a
							href="/Easybuy/CategropServlet?action=query">分类管理</a>
					</dd>
					<dd>
						<em><a href="/Easybuy/ProductServlet?action=addht">新增</a></em><a
							href="/Easybuy/ProductServlet?action=query">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="/Easybuy/OrderServlet?action=query">订单管理</a>
					</dd>
					<dt>留言管理</dt>
					<dd>
						<a href="/Easybuy/CommentServlet?action=queryh">留言管理</a>
					</dd>
					<dt>新闻管理</dt>
					<dd>
						<em><a href="/Easybuy/manage/news-add.jsp">新增</a></em><a
							href="/Easybuy/NewsServlet?action=query">新闻管理</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<h2>订单管理</h2>
			<div class="manage">
				<div class="search">
					<form action="OrderServlet?action=querybat" method="post">
						订单号：<input type="text" class="text" name="orderId" /><span>${tishi}</span> 订货人：<input
							type="text" class="text" name="userName" /> <label
							class="ui-blue"><input type="submit" name="submit"
							value="查询" /></label>
					</form>
				</div>
				<div class="spacer"></div>
				<form name="listForm" action="OrderServlet?action=query"
					method="post">
					<table class="list">
						<tr>
							<th>ID</th>
							<th>姓名</th>
							<th>发货地址</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${ph.list}" var="o">
							<tr>
								<td class="first w4 c">${o.eoid}</td>
								<td class="w1 c">${o.username}</td>
								<td>${o.useraddress}</td>
								<c:if test="${o.status==0}">
									<td class="w1 c">待审核</td>
								</c:if>
								<c:if test="${o.status==1}">
									<td class="w1 c">审核通过</td>
								</c:if>
								<c:if test="${o.status==2}">
									<td class="w1 c">配货</td>
								</c:if>
								<c:if test="${o.status==3}">
									<td class="w1 c">发货</td>
								</c:if>
								<c:if test="${o.status==4}">
									<td class="w1 c">收货确认</td>
								</c:if>
								<td class="w1 c"><a
									href="OrderServlet?action=updatehuit&id=${o.eoid}">修改</a> <a
									href="javascript:del(${o.eoid})">删除</a></td>
							</tr>
						</c:forEach>
						<%@include file="page.jsp"%>
					</table>

				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>
	<script>
		/* function del(id)
		 {
		 if(confirm("确定要删除吗？")) {
		 window.location.href = "OrderServlet?action=delete&id=" + id; 
		 }
		 } */
	</script>
</body>
</html>
