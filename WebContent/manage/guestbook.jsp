
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="/Easybuy/css/style.css" />
<script type="text/javascript" src="/Easybuy/scripts/function-manage.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="../images/logo.gif" />
		</div>
		<div class="help">
			<a href="../index.jsp">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li><a href="/Easybuy/manage/index.jsp">首页</a></li>
				<li><a href="/Easybuy/UserServlet?action=query">用户</a></li>
				<li><a href="/Easybuy/ProductServlet?action=query">商品</a></li>
				<li><a href="/Easybuy/OrderServlet?action=query">订单</a></li>
				<li class="current"><a href="/Easybuy/CommentServlet?action=queryh">留言</a></li>
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
		您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
	</div>
	<form name="listForm" action="/Easybuy/CommentServlet?action=queryh"
		method="post">
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
				<h2>留言管理</h2>
				<div class="manage">
					<table class="list">
						<tr>
							<th>ID</th>
							<th>姓名</th>
							<th>留言内容</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<c:forEach items="${ph.list}" var="gb">
							<tr>
								<td class="first w4 c">${gb.ecid}</td>
								<td class="w1 c">${gb.ecnicename}</td>
								<td>${gb.econten}</td>
								<td class="w1 c"><c:if test="${gb.ecreply!=null}">已回复</c:if>
									<c:if test="${gb.ecreply==null}">未回复</c:if></td>
								<td class="w1 c"><c:if test="${gb.ecreply==null}">
										<a href="CommentServlet?action=huifuht&ecpid=${gb.ecid}">回复</a>
									</c:if> <a href="CommentServlet?action=delete&ecpid=${gb.ecid}">删除</a></td>
							</tr>
						</c:forEach>
					</table>
					<%@include file="page.jsp"%>
				</div>
			</div>
			<div class="clear"></div>
		</div>
	</form>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>
</body>
</html>
