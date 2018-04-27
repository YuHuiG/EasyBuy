package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easybuy.dao.UserDao;
import easybuy.entity.User;

public class UserDaoImp extends DBUitl implements UserDao {
	// 登录
	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		// 获取数据库联接
		Connection conn = getConn();
		User u = null;
		String sql = "select*from easybuy_user where eu_user_name=? and eu_password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				u = new User(rst.getString(1), rst.getString(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getString(6), rst.getString(7), rst.getString(8),
						rst.getString(9), rst.getInt(10), rst.getInt(11));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConn();
		}
	}

	// 注册
	@Override
	public int AddUser(User u) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "insert into easybuy_user values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUid());
			ps.setString(2, u.getUname());
			ps.setString(3, u.getUpwd());
			ps.setString(4, u.getSex());
			ps.setString(5, u.getBirthday());
			ps.setString(6, u.getIdcard());
			ps.setString(7, u.getEmail());
			ps.setString(8, u.getPhone());
			ps.setString(9, u.getAddress());
			ps.setInt(10, u.getLogin());
			ps.setInt(11, u.getStatus());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}

	// 删除
	@Override
	public int delete(String name) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "delete from easybuy_user where eu_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}

	}

	// 修改
	@Override
	public int updates(User u) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "update easybuy_user set eu_user_id=?,eu_user_name=?,eu_password=?,eu_sex=?,eu_birthday=?,eu_mobile=?,eu_address=? where eu_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			String jid = u.getUid();
			ps.setString(1, u.getUid());
			ps.setString(2, u.getUname());
			ps.setString(3, u.getUpwd());
			ps.setString(4, u.getSex());
			ps.setString(5, u.getBirthday());
			ps.setString(6, u.getPhone());
			ps.setString(7, u.getAddress());
			ps.setString(8, jid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}

	// 查询所有用户信息
	@Override
	public List<User> query(int page, int row) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		List<User> list = new ArrayList<User>();
		String sql = "select top " + row
				+ " * from easybuy_user where eu_user_id not in(select top "
				+ row * (page - 1) + " eu_user_id from easybuy_user)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				if ("f".equals(rst.getString(4))) {
					User u = new User(rst.getString(1), rst.getString(2),
							rst.getString(3), "女", rst.getString(5),
							rst.getString(6), rst.getString(7),
							rst.getString(8), rst.getString(9), rst.getInt(10),
							rst.getInt(11));
					list.add(u);
				} else {
					User u = new User(rst.getString(1), rst.getString(2),
							rst.getString(3), "男", rst.getString(5),
							rst.getString(6), rst.getString(7),
							rst.getString(8), rst.getString(9), rst.getInt(10),
							rst.getInt(11));
					list.add(u);
				}

			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConn();
		}
	}

	public int queryCount() {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		int count = 0;
		String sql = "select count(*) from easybuy_user";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				count = rst.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return count;
		} finally {
			closeConn();
		}
	}

	public User queryid(String id) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		User u = null;
		String sql = "select*from easybuy_user where eu_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				u = new User(rst.getString(1), rst.getString(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getString(6), rst.getString(7), rst.getString(8),
						rst.getString(9), rst.getInt(10), rst.getInt(11));

			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConn();
		}
	}
}
