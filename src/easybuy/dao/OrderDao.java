package easybuy.dao;

import java.util.List;

import easybuy.entity.Order;
public interface OrderDao {
		// ��ѯ��������
		public List<Order> query(String Uid, String Uname);
		public int queryid(String time);
		//��������
		public int AddOrder(Order p);
		//�޸�����
		public int updateOrder(int eoid,int status);
		//ɾ������
		public int deleteOrder(int id);
}
