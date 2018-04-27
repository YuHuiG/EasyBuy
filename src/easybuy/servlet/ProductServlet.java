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

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import easybuy.dao.imp.CategoryDaoImp;
import easybuy.dao.imp.ProductDaoImp;
import easybuy.entity.Category;
import easybuy.entity.PageHelper;
import easybuy.entity.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDaoImp dao = new ProductDaoImp();
	CategoryDaoImp daoCate = new CategoryDaoImp();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
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
			//查询商品
			doquery(request, response);
		} else if ("description".equals(action)) {
			// 填写描述
			String epid = request.getParameter("dcp");
			// description = new
			// String(description.getBytes("ISO-8859-1"),"utf-8");
			Product p = dao.query(Integer.parseInt(epid));
			request.setAttribute("p", p);
			request.getRequestDispatcher("product-view.jsp").forward(request,
					response);
		} else if ("addht".equals(action)) {
			// 增加回填
			List<Category> list1 = daoCate.querybig();
			List<Category> list2 = daoCate.querysmall();
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("/manage/product-add.jsp").forward(
					request, response);

		} else if ("add".equals(action)) {
			// 文件上传
			System.out.println("service...");
			SmartUpload su = new SmartUpload();
			// 初始化上传组件（对request及response做了二次封装，原来的request不能获取页面信息）
			su.initialize(this.getServletConfig(), request, response);
			try {
				su.upload();// 上传文件至服务器内存（缓存）
				Files files = su.getFiles();// 取出上传的多个文件
				String picture = "";// 文件路径
				// 商品信息保存至数据库
				Request req = su.getRequest();// 需要从上传组件中获取request对象
				for (int i = 0; i < files.getCount(); i++) {
					File f = files.getFile(i);
					// 取文件名
					//String name = f.getFileName();
					// 在此重新给文件命名
					picture = createFileName();
					// 将文件保存在项目的指定目录中
					f.saveAs("E:/upload/" + picture);
				}
				// 获取表单的其余参数
				String epname = req.getParameter("productName");
				String epcchildid = req.getParameter("parentId");
				String epdescription = req.getParameter("description");
				String price = req.getParameter("productPrice");
				String stock = req.getParameter("productstock");
				epname = new String(epname.getBytes(), "UTF-8");// ISO-8859-1
				epdescription = new String(epdescription.getBytes(),"UTF-8");
				price = new String(price.getBytes("GBK"), "UTF-8");
				stock = new String(stock.getBytes("GBK"), "UTF-8");
				int epcid = daoCate.query(Integer.parseInt(epcchildid));
				Product p = new Product(epname, epdescription,
						Double.parseDouble(price), Integer.parseInt(stock),
						epcid, Integer.parseInt(epcchildid), picture);
				dao.AddProduct(p);
				doquery(request, response);
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("upht".equals(action)) {
			//修改回填
			List<Category> list1 = daoCate.querybig();
			List<Category> list2 = daoCate.querysmall();
			String epid = request.getParameter("flg");
			Product p = dao.query(Integer.parseInt(epid));
			request.setAttribute("list1", list1);
			request.setAttribute("list2", list2);
			request.setAttribute("p", p);
			request.getRequestDispatcher("/manage/product-modify.jsp").forward(
					request, response);
		} else if ("update".equals(action)) {
			//修改操作
			String epid = request.getParameter("epid");
			String epname = request.getParameter("productName");
			String epcchildid = request.getParameter("parentId");
			String epdescription = request.getParameter("description");
			String price = request.getParameter("productPrice");
			String stock = request.getParameter("productstock");
			String ul = request.getParameter("photo");
			int epcid = daoCate.query(Integer.parseInt(epcchildid));
			Product p = new Product(Integer.parseInt(epid), epname,
					epdescription, Double.parseDouble(price),
					Integer.parseInt(stock), epcid,
					Integer.parseInt(epcchildid), ul);
			dao.updateProduct(p);
			doquery(request, response);
		} else if ("delete".equals(action)) {
			// 删除操作
			String id = request.getParameter("flg");
			dao.deleteProduct(Integer.parseInt(id));
			doquery(request, response);
		}
	}

	private String createFileName() {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(new Date()) + ".jpg";
	}

	private void doquery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取是第几页
		String page = request.getParameter("page");
		if (page == null) {
			page = "1";
		}
		int row = 5;// 设置行数
		//分页查询
		List<Product> list = dao.query(Integer.parseInt(page), row);
		// 行数
		int total = dao.queryCount();
		PageHelper ph = new PageHelper(row, total, Integer.parseInt(page), list);
		request.setAttribute("ph", ph);
		request.getRequestDispatcher("/manage/product.jsp").forward(request,
				response);

	}

}
