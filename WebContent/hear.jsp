<%@ page language="java" import="easybuy.entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<c:if test="${user!=null}">
			<label>会员${user.uname}您好! ，欢迎来到易买网。
			</label><a href="/Easybuy/UserServlet?action=logacb">注销</a>
			<input type="hidden" value="${user.uid}" name="uesr_id"/>
			</c:if>
</body>
</html>