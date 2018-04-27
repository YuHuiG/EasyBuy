package easybuy.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import easybuy.dao.imp.NewsDaoImp;
import easybuy.entity.News;
import easybuy.entity.PageHelper;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NewsDaoImp dao = new NewsDaoImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("action");
		if ("query".equals(action)) {
			doquery(request, response);
		} else if ("addnew".equals(action)) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String time = createFileName();
			News p = new News(title, content, time);
			dao.AddNews(p);
			request.getRequestDispatcher("news-modify.jsp").forward(request,
					response);
		} else if ("updateht".equals(action)) {
			String id = request.getParameter("id");
			News p=dao.queryid(Integer.parseInt(id));
			request.setAttribute("p",p );
			request.getRequestDispatcher("/manage/news-modify.jsp").forward(request,
					response);
		}else if ("update".equals(action)) {
			String id= request.getParameter("id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			News n=new News(Integer.parseInt(id), title, content);
			dao.updateNews(n);
			request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,
					response);
		}else if("delete".equals(action)){
			String id= request.getParameter("id");
			dao.deleteNews(Integer.parseInt(id));
			request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,
					response);
		}
	}

	private String createFileName() {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(new Date());
	}

	private void doquery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int row = 5;
		// ≤È—Ø
		List<News> list = dao.query(Integer.parseInt(page), row);
		int total = dao.queryCount();
		PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
		request.setAttribute("ph", ph);
		request.getRequestDispatcher("/manage/news.jsp").forward(request,
				response);
	}

}
