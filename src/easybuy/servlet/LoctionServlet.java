package easybuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easybuy.dao.imp.NewsDaoImp;
import easybuy.dao.imp.ProductDaoImp;
import easybuy.entity.News;
import easybuy.entity.PageHelper;
import easybuy.entity.Product;

/**
 * Servlet implementation class LoctionServlet
 */
@WebServlet("/LoctionServlet")
public class LoctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NewsDaoImp daonew = new NewsDaoImp();
	ProductDaoImp daopdt = new ProductDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//(1).显示最新公告(新闻)
		//(2).显示商品
		// 查询
		String action = request.getParameter("action");
		if ("query".equals(action)) {
			List<News> listnew = daonew.query(1,5);
			request.setAttribute("listnew", listnew);
			List<Product> listpdt = daopdt.query(1, 10);
			request.setAttribute("listpdt", listpdt);
			request.getRequestDispatcher("index.jsp").forward(request,
					response);
		} else if("view".equals(action)){
			String id=request.getParameter("id");
			Product p=daopdt.query(Integer.parseInt(id));
			request.setAttribute("p", p);
			request.getRequestDispatcher("product-view.jsp").forward(request,
					response);
		}
		
	}

}
