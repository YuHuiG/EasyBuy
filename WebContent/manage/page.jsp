<%@ page language="java" import="easybuy.dao.*,easybuy.dao.imp.*,java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td><input type="hidden" id="totalPage" name="totalPage"
				value="${ph.totalPage}" /></td>
			<td>总共${ph.total}行,共${ph.totalPage}页&nbsp;</td>
			<td>当前第 <select id="currentPage" name="page"
				onchange="goPage(this.value)">
					<c:forEach begin="1" end="${ph.totalPage}" var="a">
						<option value="${a}">${a}</option>
					</c:forEach>
			</select> 页
			</td>
			<td><a href="javascript:firstPage()">首页</a></td>
			<td><a href="javascript:prePage()">上页</a></td>
			<td><a href="javascript:nextPage()">下页</a></td>
			<td><a href="javascript:lastPage()">末页</a></td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	document.getElementById("currentPage").value='${ph.currentPage}';
	function goPage(pg){
		listForm.submit();
	}
	function prePage(){	
		var currentPageStr=document.getElementById("currentPage").value;
		var currentPage=parseInt(currentPageStr);
		if(currentPage==1){
			alert("已经是第一页了");
		}else{
			document.getElementById("currentPage").value=currentPage-1;
			listForm.submit();
		}
	}
	function nextPage(){
		var totalPageStr=document.getElementById("totalPage").value;
		var  currentPageStr=document.getElementById("currentPage").value;
		var totalPage=parseInt(totalPageStr);
		var currentPage=parseInt(currentPageStr);
		if(currentPage==totalPage){
			alert("已经是末页了");
		}else{
			document.getElementById("currentPage").value=currentPage+1;
			listForm.submit();
		}
	}
	function lastPage(){
		var totalPageStr=document.getElementById("totalPage").value;
		var  currentPageStr=document.getElementById("currentPage").value;
		var totalPage=parseInt(totalPageStr);
		var currentPage=parseInt(currentPageStr);
		if(currentPage==totalPage){
			alert("已经是末页了");
		}else{
			document.getElementById("currentPage").value=totalPage;
			listForm.submit();
		}
	}
	function firstPage(){
		var  currentPageStr=document.getElementById("currentPage").value;
		var currentPage=parseInt(currentPageStr);
		if(currentPage==1){
			alert("已经是第一页了");
		}else{
			document.getElementById("currentPage").value=1;
			listForm.submit();
		}
	}
</script>
</html>