package easybuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easybuy.dao.imp.CategoryDaoImp;
import easybuy.entity.Category;

/**
 * Servlet implementation class CategropServlet
 */
@WebServlet("/CategropServlet")
public class CategropServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoryDaoImp dao=new CategoryDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategropServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if ("query".equals(action)) {
			doquery(request,response);
		}else if("bigtype".equals(action)){
			//修改回填数据
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String epcid=request.getParameter("epcid");
			name = new String(name.getBytes("iso-8859-1"),"UTF-8");
			List<Category> list1=dao.querybig();
			request.setAttribute("list1", list1);
			request.setAttribute("typeid", id);
			request.setAttribute("epcid", epcid);
			request.setAttribute("name", name);
			request.getRequestDispatcher("/manage/productClass-modify.jsp").forward(request,
					response);
		}else if("addcate".equals(action)){
			//增加回填下拉框
			List<Category> list1=dao.querybig();
			request.setAttribute("list1", list1);
			request.getRequestDispatcher("/manage/productClass-add.jsp").forward(request,
					response);
		}else if("addcateGory".equals(action)){
			//数据库增加操作
			String parentid=request.getParameter("parentId");
			String name=request.getParameter("className");
			dao.AddCategory(name, Integer.parseInt(parentid));
			request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,
					response);
		}else if("updatecateGory".equals(action)){
			//执行修改操作
			String epcid=request.getParameter("epcid");
			String name=request.getParameter("className");
			dao.updateCategory(name,Integer.parseInt(epcid));
			doquery(request,response);
		}else if("delete".equals(action)){
			//删除操作
			String epcid=request.getParameter("id");
			//根据自增id删除大类或小类
			dao.deleteCategory(Integer.parseInt(epcid));
			//如果删的是大类则将旗下小类也删了
			dao.deleteCate(Integer.parseInt(epcid));
			doquery(request,response);
		}
		
	}

	private void doquery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//查询
		//遍历所有分类
		List<Category> list1=dao.querybig();
		List<Category> list2=dao.querysmall();
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);
		request.getRequestDispatcher("/manage/productClass.jsp").forward(request,
				response);
	}

}
