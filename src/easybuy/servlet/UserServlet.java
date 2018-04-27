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
		// ��¼
		if ("login".equals(action)) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("passWord");
			// �ж��˺��Ƿ��Ѿ���¼
			boolean hasLogin = checkLogin(userName);
			// �ȶ���֤��
			HttpSession session = request.getSession();
			String safecode = (String) session.getAttribute("safecode");
			String yz = request.getParameter("veryCode");
			if (!safecode.equals(yz)) {
				request.setAttribute("error", "��֤�����");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}else{
			if (hasLogin) {
				request.setAttribute("error", userName + "���˺��ѵ�¼��");
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			} else {
				User u = dao.login(userName, password);
				if (u != null) {
					// ��¼��֤�ɹ������û���Ϣ����session������
					HttpSession s = request.getSession();
					s.setAttribute("user", u);
					ServletContext a = this.getServletContext();
					a.setAttribute("message", u);
					// ���뵽�Ѿ���¼�ļ�¼��
					OnlineUtil.accountList.add(userName);
					// ����ǹ���Ա��¼����Ա��������¼��ͨ�û�����
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
					request.setAttribute("error", "��¼ʧ�ܣ������û���������");
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				}
			}
			}
		} else if ("logacb".equals(action)) {
			// �˳�
			HttpSession s = request.getSession();
			User u = (User) s.getAttribute("user");

			// ���߼�¼������˳����û�
			OnlineUtil.accountList.remove(u.getUname());
			s.removeAttribute("user");
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
			// ע��
		} else if ("reg".equals(action)) {

			String userName = request.getParameter("userName");
			String password = request.getParameter("passWord");
			String uid = "id" + userName;
			HttpSession session = request.getSession();
			String safecode = (String) session.getAttribute("safecode");
			String yz = request.getParameter("veryCode");
			if (!safecode.equals(yz)) {
				request.setAttribute("error", "��֤�����");
				request.getRequestDispatcher("register.jsp").forward(request,
						response);
			}else{
			User u = new User(uid, userName, password, "t", "1990-01-01",
					"123456789012345678", "123@aa.com", "13456789210",
					"���ݽ���·50", 1, 1);// ����Users����
			int flag = dao.AddUser(u);// ����userDaoimp��addchat()
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("reg-result.jsp").forward(request,
					response);
			}
		} else if ("get".equals(action)) {
			// ����ID��ѯ
			// 1������ID
			String id = request.getParameter("id");
			User u = dao.queryid(id);
			// 2������������
			request.setAttribute("u", u);
			// ת�����޸�ҳ��
			request.getAttribute("u");
			// ת����չʾҳ��
			request.getRequestDispatcher("/manage/user-modify.jsp").forward(
					request, response);
		} else if ("query".equals(action)) {
			doQuery(request, response);
		} else if ("update".equals(action)) {
			// 1��������Ϣ
			String uid = request.getParameter("userName");
			String uname = request.getParameter("name");
			String upwd = request.getParameter("passWord");
			String sex = request.getParameter("sex");
			String birthday = request.getParameter("birthday");
			String phone = request.getParameter("mobile");
			String address = request.getParameter("address");
			System.out.println(uid + "\t" + uname + "\t" + upwd + "\t" + sex
					+ "\t" + address + "\t");
			if ("Ů".equals(sex)) {
				sex = "f";
			} else {
				sex = "t";
			}
			User u = new User(uid, uname, upwd, sex, birthday, phone, address);
			// 2������DAO�޸�
			dao.updates(u);

			doQuery(request, response);
		} else if ("delete".equals(action)) {
			// ɾ��
			// 1������ID
			String id = request.getParameter("id");
			// 2������daoɾ��
			dao.delete(id);
			doQuery(request, response);

		} else if ("reght".equals(action)) {

			String userName = request.getParameter("userName");
			String password = request.getParameter("passWord");
			String uid = "id" + userName;
			User u = new User(uid, userName, password, "t", "1990-01-01",
					"123456789012345678", "123@aa.com", "13456789210",
					"���ݽ���·50", 1, 1);// ����Users����
			int flag = dao.AddUser(u);// ����userDaoimp��addchat()
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/manage/manage-result.jsp").forward(
					request, response);
		}

	}

	private void doQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ��ȡ���ǵڼ�ҳ
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int row = 5;// ÿҳ��ʾ����
		// ��ѯ
		List<User> list = dao.query(Integer.parseInt(page), row);
		// ȡ��������
		int total = dao.queryCount();
		PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
		// ���������request������
		request.setAttribute("ph", ph);
		// ת����չʾҳ��
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
