
<%@ page language="java" import="easybuy.entity.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				<li class="current"><a href="../UserServlet?action=query">用户</a></li>
				<li><a href="/Easybuy/ProductServlet?action=query">商品</a></li>
				<li><a href="/Easybuy/OrderServlet?action=query">订单</a></li>
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
			<h2>修改用户</h2>
			<div class="manage">
				<form action="UserServlet?action=update" method="post">
					<table class="form">
						<tr>
							<td class="field">用户名：</td>
							<td><input type="text" class="text" name="userName"
								value="${u.uid}" readonly="readonly" /></td>
						</tr>
						<tr>
							<td class="field">姓名：</td>
							<td><input type="text" class="text" name="name"
								value="${u.uname}" /></td>
						</tr>
						<tr>
							<td class="field">密码：</td>
							<td><input type="text" class="text" name="passWord"
								value="${u.upwd}" /></td>
						</tr>
						<tr>
							<td class="field">性别：</td>

							<%
								User u = (User) request.getAttribute("u");
								if ("女".equals(u.getSex())) {
							%>
							<td><input type="radio" name="sex" value="1" />男 <input
								type="radio" name="sex" value="1" checked="checked" />女</td>
							<%
								} else {
							%>

							<td><input type="radio" name="sex" value="1"
								checked="checked" />男 <input type="radio" name="sex" value="1" />女</td>
							<%
								}
							%>

						</tr>
						<tr>
							<td class="field">出生日期：</td>
							<td><input type="text" name="birthday" class="text"
								value="${u.birthday}" /></td>
						</tr>
						<tr>
							<td class="field">手机号码：</td>
							<td><input type="text" class="text" name="mobile"
								value="${u.phone}" /></td>
						</tr>
						<tr>
							<td class="field">送货地址：</td>
							<td><input type="text" class="text" name="address"
								value="${u.address}" /></td>
						</tr>
						<tr>
							<td class="field">头像：</td>
							<td><input type="file" class="text" name="photo" /></td>
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
