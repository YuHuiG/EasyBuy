package easybuy.dao;

import java.util.List;

import easybuy.entity.User;


public interface UserDao {
		//登录
		public User login(String name,String pwd);
		//注册
		public int AddUser(User u);
		//删除
		public int delete(String name);
		//修改
		public int updates(User u);
		//查询所有用户信息
		public List<User> query(int page, int row);
}
