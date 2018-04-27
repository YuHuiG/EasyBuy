package easybuy.dao;

import java.util.List;

import easybuy.entity.Order;
public interface OrderDao {
		// 查询所有新闻
		public List<Order> query(String Uid, String Uname);
		public int queryid(String time);
		//增加新闻
		public int AddOrder(Order p);
		//修改新闻
		public int updateOrder(int eoid,int status);
		//删除新闻
		public int deleteOrder(int id);
}
