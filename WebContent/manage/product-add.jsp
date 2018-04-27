<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="/Easybuy/css/style.css" />
<script type="text/javascript" src="/Easybuy/scripts/function-manage.js"></script>
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="./images/logo.gif" />
		</div>
		<div class="help">
			<c:if test="${user!=null}">
				<label>管理员${user.uname}您好! ，欢迎回到管理后台。 </label>
				<a href="/Easybuy/UserServlet?action=logacb">注销</a>
				<input type="hidden" value="${user.uid}" name="uesr_id" />
			</c:if>
			<a href="index.jsp">返回前台页面</a>
		</div>
		<div class="navbar">
			<ul class="clearfix">
				<li><a href="/Easybuy/manage/index.jsp">首页</a></li>
				<li><a href="../UserServlet?action=query">用户</a></li>
				<li class="current"><a href="../ProductServlet?action=query">商品</a></li>
				<li ><a href="../OrderServlet?action=query">订单</a></li>
				<li><a href="../CommentServlet?action=queryh">留言</a></li>
				<li><a href="../NewsServlet?action=query">新闻</a></li>
			</ul>
		</div>
	</div>
	<div id="childNav">
		<div class="welcome wrap"></div>
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
						<em><a href="../manage/user-add.jsp">新增</a></em><a
							href="../UserServlet?action=query">用户管理</a>
					</dd>
					<dt>商品信息</dt>
					<dd>
						<em><a href="../CategropServlet?action=addcate">新增</a></em><a
							href="../CategropServlet?action=query">分类管理</a>
					</dd>
					<dd>
						<em><a href="../ProductServlet?action=addht">新增</a></em><a
							href="../ProductServlet?action=query">商品管理</a>
					</dd>
					<dt>订单管理</dt>
					<dd>
						<a href="../OrderServlet?action=query">订单管理</a>
					</dd>
					<dt>留言管理</dt>
					<dd>
						<a href="../CommentServlet?action=queryh">留言管理</a>
					</dd>
					<dt>新闻管理</dt>
					<dd>
						<em><a href="/Easybuy/manage/news-add.jsp">新增</a></em><a
							href="../NewsServlet?action=query">新闻管理</a>
					</dd>
				</dl>
			</div>
		</div>
		<div class="main">
			<h2>添加商品</h2>
			<div class="manage">
				<form action="ProductServlet?action=add"
					enctype="multipart/form-data" method="post">
					<table class="form">
						<tr>
							<td class="field">商品名称：</td>
							<td><input type="text" class="text" name="productName"
								value="" /></td>
						</tr>
						<tr>
							<td class="field">所属分类：</td>
							<td><select name="parentId">
									<c:forEach items="${list1}" var="ca">
										<optgroup label="${ca.epcname}">
											<c:forEach items="${list2}" var="cs">
												<c:if test="${ca.epcid==cs.parentid}">
													<option value="${cs.epcid}">${cs.epcname}</option>
												</c:if>
											</c:forEach>
										</optgroup>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="field">商品图片：</td>
							<td><input type="file" class="text" name="photo" /></td>
						</tr>
						<tr>
							<td class="field">商品价格：</td>
							<td><input type="text" class="text tiny" name="productPrice" />
								元</td>
						</tr>

						<tr>
							<td class="field">库存：</td>
							<td><input type="text" class="text tiny" name="productstock" /></td>
						</tr>
						<tr>
							<td class="field">描述：</td>
							<td><input type="text" name="description" /></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue"><input type="submit"
									name="submit" value="添加" /></label></td>
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
