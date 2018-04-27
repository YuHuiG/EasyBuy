<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.gif" />
		</div>
		<c:if test="${user!=null}">
			<label>会员${user.uname}您好! </label>
			<a href="/Easybuy/UserServlet?action=logacb">注销</a>
			<input type="text" id="aday" value="${user.uid}" name="uesr_id" />
		</c:if>
		<div class="help">
			<a href="#" class="shopping">购物车</a><a href="login.html">登录</a><a
				href="register.html">注册</a><a href="guestbook.html">留言</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li class="current"><a href="#">首页</a></li>
				<li><a href="#">图书</a></li>
				<li><a href="#">百货</a></li>
				<li><a href="#">品牌</a></li>
				<li><a href="#">促销</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="wrap">
			<ul class="clearfix">
				<li class="first"><a href="#">音乐</a></li>
				<li><a href="#">影视</a></li>
				<li><a href="#">少儿</a></li>
				<li><a href="#">动漫</a></li>
				<li><a href="#">小说</a></li>
				<li><a href="#">外语</a></li>
				<li><a href="#">数码相机</a></li>
				<li><a href="#">笔记本</a></li>
				<li><a href="#">羽绒服</a></li>
				<li><a href="#">秋冬靴</a></li>
				<li><a href="#">运动鞋</a></li>
				<li><a href="#">美容护肤</a></li>
				<li><a href="#">家纺用品</a></li>
				<li><a href="#">婴幼奶粉</a></li>
				<li><a href="#">饰品</a></li>
				<li class="last"><a href="#">Investor Relations</a></li>
			</ul>
		</div>
	</div>
	<div id="position" class="wrap">
		您现在的位置：<a href="index.html">易买网</a> &gt; <a href="product-list.html">图书音像</a>
		&gt; 图书
	</div>
	<div id="main" class="wrap">
		<div class="lefter">
			<div class="box">
				<h2>商品分类</h2>
				<dl>
					<dt>图书音像</dt>
					<dd>
						<a href="product-list.jsp">图书</a>
					</dd>
					<dd>
						<a href="product-list.jsp">音乐</a>
					</dd>
					<dt>百货</dt>
					<dd>
						<a href="product-list.jsp">运动健康</a>
					</dd>
					<dd>
						<a href="product-list.jsp">服装</a>
					</dd>
					<dd>
						<a href="product-list.jsp">家居</a>
					</dd>
					<dd>
						<a href="product-list.jsp">美妆</a>
					</dd>
					<dd>
						<a href="product-list.jsp">母婴</a>
					</dd>
					<dd>
						<a href="product-list.jsp">食品</a>
					</dd>
					<dd>
						<a href="product-list.jsp">手机数码</a>
					</dd>
					<dd>
						<a href="product-list.jsp">家具首饰</a>
					</dd>
					<dd>
						<a href="product-list.jsp">手表饰品</a>
					</dd>
					<dd>
						<a href="product-list.jsp">鞋包</a>
					</dd>
					<dd>
						<a href="product-list.jsp">家电</a>
					</dd>
					<dd>
						<a href="product-list.jsp">电脑办公</a>
					</dd>
					<dd>
						<a href="product-list.jsp">玩具文具</a>
					</dd>
					<dd>
						<a href="product-list.jsp">汽车用品</a>
					</dd>
				</dl>
			</div>
		</div>
		<div id="product" class="main">
			<h1>${p.epname}</h1>
			<div class="infos">
				<div class="thumb">
					<img src="/index/${p.ul}" />
				</div>
				<div class="buy">
					<p>
						商城价：<span class="price">￥${p.price}</span>
					</p>
					<p>库 存：有货</p>
					<p>库 存：有货</p>
					<p>库 存：有货</p>
					<p>库 存：有货</p>
					<div class="button">
						<input type="button" name="button" value="" onclick="window.location.href='CartServlet?action=add&epid=${p.epid}&uesr_id=${message.uid}'" /><a
							href="CartServlet?action=add&epid=${p.epid}&uesr_id=${message.uid}">放入购物车</a>
							 
					</div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="introduce">
				<h2>
					<strong>商品详情</strong>
				</h2>
				<div class="text">
					${p.epdescription}<br />

				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2015 天智立软件教育 All Rights
		Reserved. 京ICP证1000001号</div>
</body>
</html>
