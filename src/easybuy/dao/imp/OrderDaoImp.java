package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easybuy.dao.OrderDao;
import easybuy.entity.News;
import easybuy.entity.Order;

public class OrderDaoImp extends DBUitl implements OrderDao {

	@Override
	public List<Order> query(String Uid, String Uname) {
		Connection conn = getConn();
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from easybuy_order where eo_user_id=? and eo_user_name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Uid);
			ps.setString(2, Uname);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Order n = new Order(rst.getInt(1), rst.getInt(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDouble(6), rst.getInt(7));
				list.add(n);
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
	public List<Order> query(int page,int row) {
		Connection conn = getConn();
		List<Order> list = new ArrayList<Order>();
		String sql = "select top " + row
				+ " * from easybuy_order where eo_id not in(select top "
				+ row * (page - 1) + " eo_id from easybuy_order)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Order n = new Order(rst.getInt(1), rst.getInt(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDouble(6), rst.getInt(7));
				list.add(n);
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
	// select c.ep_file_name ,c.ep_name,c.rp_price,b.eod_quantity from
	// easybuy_order a , easybuy_order_detail b,easybuy_product c where
	// a.eo_id=b.eo_id and b.ep_id=c.ep_id and a.eo_user_id=12 and
	// a.eo_user_name=33331

	@Override
	public int AddOrder(Order p) {
		Connection conn = getConn();
		String sql = "insert into easybuy_order values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getUserid());
			ps.setString(2, p.getUsername());
			ps.setString(3, p.getUseraddress());
			ps.setString(4, p.getTime());
			ps.setDouble(5, p.getPrice());
			ps.setInt(6, p.getStatus());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}

	@Override
	public int updateOrder(int eoid,int status) {
		Connection conn = getConn();
		String sql = "update easybuy_order set eo_status=? where eo_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, eoid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}

	@Override
	public int deleteOrder(int id) {
		Connection conn = getConn();
		String sql = "delete easybuy_order where eo_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}

	@Override
	public int queryid(String time) {
		Connection conn = getConn();
		int eo_id = 0;
		String sql = "select eo_id from easybuy_order where eo_create_time=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, time);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				eo_id = rst.getInt(1);
			}
			return eo_id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}
	public Order queryepid(int id) {
		Connection conn = getConn();
		Order n=null;
		String sql = "select * from easybuy_order where eo_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				 n = new Order(rst.getInt(1), rst.getInt(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDouble(6), rst.getInt(7));
			}
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConn();
		}
	}
	public Order queryepid(int id,String username) {
		Connection conn = getConn();
		Order n=null;
		String sql = "select * from easybuy_order where eo_id=? and eo_user_name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, username);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				 n = new Order(rst.getInt(1), rst.getInt(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDouble(6), rst.getInt(7));
			}
			return n;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConn();
		}
	}

	public List<Order> query() {
		Connection conn = getConn();
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from easybuy_order";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Order n = new Order(rst.getInt(1), rst.getInt(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDouble(6), rst.getInt(7));
				list.add(n);
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
		Connection conn = getConn();
		int count = 0;
		String sql = "select count(*) from easybuy_order";
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
	public List<Order> queryname(String username) {
		Connection conn = getConn();
		List<Order> list = new ArrayList<Order>();
		String sql = "select * from easybuy_order where eo_user_name=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Order n = new Order(rst.getInt(1), rst.getInt(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getDouble(6), rst.getInt(7));
				list.add(n);
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

}
