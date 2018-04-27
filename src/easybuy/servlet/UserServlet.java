package easybuy.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import easybuy.dao.imp.UserDaoImp;
import easybuy.entity.PageHelper;
import easybuy.entity.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDaoImp dao = new UserDaoImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		// 登录
		if ("login".equals(action)) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("passWord");
			// 判断账号是否已经登录
			boolean hasLogin = checkLogin(userName);
			// 比对验证码
			HttpSession session = request.getSession();
			String safecode = (String) session.getAttribute("safecode");
			String yz = request.getParameter("veryCode");
			if (!safecode.equals(yz)) {
				request.setAttribute("error", "验证码错误！");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}else{
			if (hasLogin) {
				request.setAttribute("error", userName + "此账号已登录。");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				User u = dao.login(userName, password);
				if (u != null) {
					// 登录验证成功，将用户信息放入session作用域
					HttpSession s = request.getSession();
					s.setAttribute("user", u);
					ServletContext a = this.getServletContext();
					a.setAttribute("message", u);
					// 加入到已经登录的记录中
					OnlineUtil.accountList.add(userName);
					// 如果是管理员登录管理员界面否则登录普通用户界面
					if (u.getStatus() == 2) {
						// request.getRequestDispatcher("/manage/index.jsp")
						// .forward(request, response);
						response.sendRedirect("/Easybuy/manage/index.jsp");
					} else {
						response.sendRedirect("index.jsp");
						// request.getRequestDispatcher("index.jsp").forward(
						// request, response);
					}

				} else {
					request.setAttribute("error", "登录失败，请检查用户名和密码");
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				}
			}
			}
		} else if ("logacb".equals(action)) {
			// 退出
			HttpSession s = request.getSession();
			User u = (User) s.getAttribute("user");

			// 在线记录中清除退出的用户
			OnlineUtil.accountList.remove(u.getUname());
			s.removeAttribute("user");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
			// 注册
		} else if ("reg".equals(action)) {

			String userName = request.getParameter("userName");
			String password = request.getParameter("passWord");
			String uid = "id" + userName;
			HttpSession session = request.getSession();
			String safecode = (String) session.getAttribute("safecode");
			String yz = request.getParameter("veryCode");
			if (!safecode.equals(yz)) {
				request.setAttribute("error", "验证码错误！");
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			}else{
			User u = new User(uid, userName, password, "t", "1990-01-01",
					"123456789012345678", "123@aa.com", "13456789210",
					"荆州江津路50", 1, 1);// 创建Users对象
			int flag = dao.AddUser(u);// 调用userDaoimp的addchat()
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("reg-result.jsp").forward(request,
					response);
			}
		} else if ("get".equals(action)) {
			// 根据ID查询
			// 1、接收ID
			String id = request.getParameter("id");
			User u = dao.queryid(id);
			// 2、放入作用域
			request.setAttribute("u", u);
			// 转发到修改页面
			request.getAttribute("u");
			// 转发给展示页面
			request.getRequestDispatcher("/manage/user-modify.jsp").forward(
					request, response);
		} else if ("query".equals(action)) {
			doQuery(request, response);
		} else if ("update".equals(action)) {
			// 1、接收信息
			String uid = request.getParameter("userName");
			String uname = request.getParameter("name");
			String upwd = request.getParameter("passWord");
			String sex = request.getParameter("sex");
			String birthday = request.getParameter("birthday");
			String phone = request.getParameter("mobile");
			String address = request.getParameter("address");
			System.out.println(uid + "\t" + uname + "\t" + upwd + "\t" + sex
					+ "\t" + address + "\t");
			if ("女".equals(sex)) {
				sex = "f";
			} else {
				sex = "t";
			}
			User u = new User(uid, uname, upwd, sex, birthday, phone, address);
			// 2、调用DAO修改
			dao.updates(u);

			doQuery(request, response);
		} else if ("delete".equals(action)) {
			// 删除
			// 1、接收ID
			String id = request.getParameter("id");
			// 2、调用dao删除
			dao.delete(id);
			doQuery(request, response);

		} else if ("reght".equals(action)) {

			String userName = request.getParameter("userName");
			String password = request.getParameter("passWord");
			String uid = "id" + userName;
			User u = new User(uid, userName, password, "t", "1990-01-01",
					"123456789012345678", "123@aa.com", "13456789210",
					"荆州江津路50", 1, 1);// 创建Users对象
			int flag = dao.AddUser(u);// 调用userDaoimp的addchat()
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/manage/manage-result.jsp").forward(
					request, response);
		}

	}

	private void doQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取这是第几页
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int row = 5;// 每页显示行数
		// 查询
		List<User> list = dao.query(Integer.parseInt(page), row);
		// 取到总行数
		int total = dao.queryCount();
		PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
		// 将结果放入request作用域
		request.setAttribute("ph", ph);
		// 转发给展示页面
		request.getRequestDispatcher("/manage/user.jsp").forward(request,
				response);
	}

	private boolean checkLogin(String name) {
		// TODO Auto-generated method stub
		boolean has = false;
		for (String acc : OnlineUtil.accountList) {
			if (acc.equals(name)) {
				has = true;
			}
		}
		return has;
	}
}
