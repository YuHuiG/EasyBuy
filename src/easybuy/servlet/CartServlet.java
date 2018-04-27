package easybuy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easybuy.dao.imp.CartDaoImp;
import easybuy.dao.imp.ProductDaoImp;
import easybuy.entity.Cart;
import easybuy.entity.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDaoImp dao = new CartDaoImp();
	ProductDaoImp daoP = new ProductDaoImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if ("add".equals(action)) {
			
			String epid = request.getParameter("epid");
			String uesr_id = request.getParameter("uesr_id");
			Product p = daoP.query(Integer.parseInt(epid));
			request.setAttribute("p", p);
			int	count=1;
			Cart c=new Cart(uesr_id, p.getEpid(), count, p.getPrice());
			Cart a=dao.querypd(uesr_id, p.getEpid());
			if(a==null){
				dao.add(c);
			}else{
				count=a.getCount()+1;
				c=new Cart(uesr_id, p.getEpid(), count, p.getPrice()*count);
				dao.update(c);
			}
			
			doquery(request,response,uesr_id);
			
		}else if("delete".equals(action)){
		String cartid=request.getParameter("cartid");
			dao.deleteid(Integer.parseInt(cartid));
			request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
		}else if("query".equals(action)){
			String uesr_id=request.getParameter("uesr_id");
			if(!"".equals(uesr_id)){
				doquery(request,response,uesr_id);
			}else{
				String b="请先登录";
				request.setAttribute("login", b);
				request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
			}
		}else if("update".equals(action)){
			String cartid=request.getParameter("cartid");
			Cart c=dao.querycart(Integer.parseInt(cartid));
			String number=request.getParameter("number");
			Double cost=c.getCost();
			Double price=cost/c.getCount();
			dao.update(Integer.parseInt(cartid),Integer.parseInt(number),price);
			doquery(request,response,c.getUserid());
		}
		
	}

	private void doquery(HttpServletRequest request,
			HttpServletResponse response,String uesr_id) throws ServletException, IOException {
		List<Cart> list = null;
		
		list = dao.querygwc(uesr_id);
		System.out.println();
		request.setAttribute("list", list);
		request.getRequestDispatcher("shopping.jsp").forward(request, response);

	}

}
