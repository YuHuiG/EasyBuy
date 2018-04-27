package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easybuy.dao.OrderXqDao;
import easybuy.entity.Order;
import easybuy.entity.OrderXq;

public class OrderXqImp extends DBUitl implements OrderXqDao {

	@Override
	public List<OrderXq> query(int eo_id) {
		Connection conn = getConn();
		List<OrderXq> list = new ArrayList<OrderXq>();
		String sql = "select * from easybuy_order_detail where eo_id=?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				OrderXq n = new OrderXq(rst.getInt(1), rst.getInt(2),
						rst.getInt(3), rst.getInt(4), rst.getDouble(5));
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

	@Override
	public int AddOrderXq(OrderXq p) {
		Connection conn = getConn();
		String sql = "insert into easybuy_order_detail values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getEoid());
			ps.setInt(2, p.getEpid());
			ps.setInt(3, p.getNum());
			ps.setDouble(4, p.getPrice());
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
	public int updateOrderXq(OrderXq p) {
		Connection conn = getConn();
		String sql = "update easybuy_order_detail set eod_quantity=? where eod_cost=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, p.getNum());
			ps.setDouble(2, p.getPrice());
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
	public int deleteOrderXq(int id) {
		Connection conn = getConn();
		String sql = "delete easybuy_order_detail where eo_id=?";
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

	
}
