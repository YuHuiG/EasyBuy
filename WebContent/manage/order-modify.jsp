
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<a href="index.jsp">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li><a href="/Easybuy/manage/index.jsp">首页</a></li>
				<li><a href="/Easybuy/UserServlet?action=query">用户</a></li>
				<li><a href="/Easybuy/ProductServlet?action=query">商品</a></li>
				<li class="current"><a href="/Easybuy/OrderServlet?action=query">订单</a></li>
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
		您现在的位置：<a href="index.html">易买网</a> &gt; 管理后台
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
			<h2>修改订单</h2>
			<div class="manage">
				<form action="OrderServlet?action=update" method="post">
					<table class="form">
						<tr>
							<td class="field">订单ID：</td>
							<td><input type="text" class="text" name="orderId"
								value="${od.eoid}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td class="field">订购人姓名：</td>
							<td><input type="text" class="text" name="username"
								value="${od.username}" /></td>
						</tr>
						<tr>
							<td class="field">订购人地址：</td>
							<td><input type="text" class="text" name="useraddress"
								value="${od.useraddress}" /></td>
						</tr>
						<tr>
							<td class="field">总金额：</td>
							<td><input type="text" class="text" name="price"
								value="${od.price}" /></td>
						</tr>
						<tr>
							<td class="field">下单日期：</td>
							<td><input type="text" class="text" name="time"
								value="${od.time}" /></td>
						</tr>
						<tr>
							<td class="field">订单状态：</td>
							<td><select name="statusad" id="selec">
									<option value="0">待审核</option>
									<option value="1">审核通过</option>
									<option value="2">配货</option>
									<option value="3">发货</option>
									<option value="4">收货确认</option>
							</select> <script type="text/javascript">
								document.getElementById("selec").value = '${od.status}';
							</script></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="更新" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>
</body>
</html>
