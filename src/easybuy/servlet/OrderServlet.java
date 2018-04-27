package easybuy.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easybuy.dao.imp.CartDaoImp;
import easybuy.dao.imp.OrderDaoImp;
import easybuy.dao.imp.OrderXqImp;
import easybuy.dao.imp.ProductDaoImp;
import easybuy.dao.imp.UserDaoImp;
import easybuy.entity.Cart;
import easybuy.entity.Order;
import easybuy.entity.OrderXq;
import easybuy.entity.PageHelper;
import easybuy.entity.Product;
import easybuy.entity.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDaoImp dao = new OrderDaoImp();
	OrderXqImp daoX = new OrderXqImp();
	ProductDaoImp daoP = new ProductDaoImp();
	UserDaoImp daoU = new UserDaoImp();
	CartDaoImp daoCart = new CartDaoImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if ("query".equals(action)) {
			// 查询所有商品
			doquery(request, response);
		} else if ("add".equals(action)) {
			//
			String uesr_id = request.getParameter("uesr_id");
			System.out.println(uesr_id);
			List<Cart> list = daoCart.querygwc(uesr_id);
			Double price = 0.0;
			for (Cart c : list) {
				price += c.getCost();
			}
			User u = daoU.queryid(uesr_id);
			Order o = new Order(Integer.parseInt(u.getUid()), u.getUname(),
					u.getAddress(), time(), price, 1);
			dao.AddOrder(o);
			int eoid = dao.queryid(o.getTime());// 根据订单生成时间查询订单id生成订单详细
			for (Cart c : list) {
				OrderXq x = new OrderXq(eoid, c.getShopid(), c.getCount(),
						c.getCost());
				daoX.AddOrderXq(x);
			}

			daoCart.deleteuserid(uesr_id);
			request.getRequestDispatcher("reg-result.jsp").forward(request, response);
			// doquery(request, response);
		} else if ("delete".equals(action)) {
			System.out.println("dfd");
			String id = request.getParameter("id");
			dao.deleteOrder(Integer.parseInt(id));
			doquery(request, response);
		} else if ("updatehuit".equals(action)) {
			String id = request.getParameter("id");
			Order oder=dao.queryepid(Integer.parseInt(id));
			request.setAttribute("od", oder);
			request.getRequestDispatcher("/manage/order-modify.jsp").forward(request, response);
		}else if ("update".equals(action)) {
			String id = request.getParameter("orderId");
			String status = request.getParameter("statusad");
			dao.updateOrder(Integer.parseInt(id),Integer.parseInt(status));
			doquery(request, response);
		}else if ("querybat".equals(action)) {
			String orderId = request.getParameter("orderId");
			String userName = request.getParameter("userName");
			if("".equals(orderId) && "".equals(userName)){
				doquery(request, response);
			}else if("".equals(orderId) && (!"".equals(userName))){
				String page =  "1";
				int row = 10;
				List<Order> list = dao.queryname(userName);
				int total = list.size();
				PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
				request.setAttribute("ph", ph);
				request.getRequestDispatcher("/manage/order.jsp").forward(request,
						response);
			}else if((!"".equals(orderId)) && "".equals(userName)){
				String page =  "1";
				int row = 10;
				Order order = dao.queryepid(Integer.parseInt(orderId));
				List<Order> list = new ArrayList<Order>();
				list.add(order);
				int total = 1;
				PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
				request.setAttribute("ph", ph);
				request.getRequestDispatcher("/manage/order.jsp").forward(request,
						response);
			}else if((!"".equals(orderId)) && (!"".equals(userName))){
				String page =  "1";
				int row = 10;
				Order order = dao.queryepid(Integer.parseInt(orderId),userName);
				List<Order> list = new ArrayList<Order>();
				list.add(order);
				int total = 1;
				PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
				request.setAttribute("ph", ph);
				request.getRequestDispatcher("/manage/order.jsp").forward(request,
						response);
			}else{
				String tishi="您输入有误";
				request.setAttribute("tishi", tishi);
				request.getRequestDispatcher("/manage/order.jsp").forward(request,
						response);
			}
			
		}

	}

	private String time() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}

	private void doquery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int row = 10;// 每页显示行数
		// 查询
		List<Order> list = dao.query(Integer.parseInt(page), row);
		// 取到总行数
		int total = dao.queryCount();
		PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
		// 将结果放入request作用域
		request.setAttribute("ph", ph);
		request.getRequestDispatcher("/manage/order.jsp").forward(request,
				response);
	}
}
