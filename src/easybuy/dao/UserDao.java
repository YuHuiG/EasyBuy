package easybuy.dao;

import java.util.List;

import easybuy.entity.User;


public interface UserDao {
		//��¼
		public User login(String name,String pwd);
		//ע��
		public int AddUser(User u);
		//ɾ��
		public int delete(String name);
		//�޸�
		public int updates(User u);
		//��ѯ�����û���Ϣ
		public List<User> query(int page, int row);
}
