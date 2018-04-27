function del(id)
{

	if(confirm("确定要删除吗？")) {
		 window.location.href = "OrderServlet?action=delete&id=" + id; 
	}
}