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

import easybuy.dao.imp.CommentDaoImp;
import easybuy.entity.Comment;
import easybuy.entity.PageHelper;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CommentDaoImp dao = new CommentDaoImp();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
		String action = request.getParameter("action");
		if ("queryq".equals(action)) {
			doquery(request, response);
			request.getRequestDispatcher("guestbook.jsp").forward(request,
					response);
		}if ("queryh".equals(action)) {
			doquery(request, response);
			request.getRequestDispatcher("/manage/guestbook.jsp").forward(request,
					response);
		}else if ("huifuht".equals(action)) {
			String ecpid=request.getParameter("ecpid");
			Comment c=dao.queryid(Integer.parseInt(ecpid));
			request.setAttribute("c", c);
			request.getRequestDispatcher("/manage/guestbook-modify.jsp").forward(request,
					response);
		}else if ("huifu".equals(action)) {
			String ecpid=request.getParameter("orderId");
			String ecreplytime=createtime();
			String ecreply=request.getParameter("replyContent");
			Comment	c=new Comment(Integer.parseInt(ecpid), ecreply, ecreplytime);
			dao.updateComment(c);
			request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,
					response);
		}else if ("delete".equals(action)) {
			String ecpid=request.getParameter("ecpid");
			dao.deleteComment(Integer.parseInt(ecpid));
			request.getRequestDispatcher("/manage/manage-result.jsp").forward(request,
					response);
		}else if ("add".equals(action)) {
			String econten=request.getParameter("guestContent");
			String ecrettime=createtime();
			String ecnicename=request.getParameter("guestName");
			Comment c=new Comment(econten, ecrettime, ecnicename);
			dao.AddComment(c);
			request.getRequestDispatcher("index.jsp").forward(request,
					response);
		}
			
		
	}

	private String createtime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		List<Comment> list = dao.query(Integer.parseInt(page), row);
		int total = dao.queryCount();
		PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
		request.setAttribute("ph", ph);
		
		
	}

}
