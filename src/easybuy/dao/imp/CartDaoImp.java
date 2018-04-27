package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easybuy.dao.CartDao;
import easybuy.entity.Cart;

public class CartDaoImp extends DBUitl implements CartDao {

	@Override
	public List<Cart> query(String userid) {
		Connection conn = getConn();
		List<Cart> list = new ArrayList<Cart>();
		String sql = "select * from easybuy_cart where eo_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Cart c = new Cart(rst.getInt(1), rst.getString(2),
						rst.getInt(3), rst.getInt(4), rst.getDouble(5));
				list.add(c);
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

	public Cart querypd(String userid, int Shop_id) {
		Connection conn = getConn();
		Cart c = null;
		String sql = "select * from easybuy_cart where eo_user_id=? and Shop_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setInt(2, Shop_id);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				c = new Cart(rst.getInt(1), rst.getString(2), rst.getInt(3),
						rst.getInt(4), rst.getDouble(5));

			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConn();
		}
	}

	public List<Cart> querygwc(String userid) {
		Connection conn = getConn();
		List<Cart> list = new ArrayList<Cart>();
		Double cost=0.0;
		String sql = "select * from easybuy_cart,easybuy_product where easybuy_cart.Shop_id=easybuy_product.ep_id and easybuy_cart.eo_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Cart c = new Cart(rst.getInt("cart_id"),
						rst.getString("ep_file_name"), rst.getInt("Shop_id"),
						rst.getInt("Buy_count"), rst.getDouble("eo_cost"),
						rst.getString("ep_name"), rst.getString("ep_file_name"));
				cost+=rst.getDouble("eo_cost");
				list.add(c);
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
	public int add(Cart c) {
		Connection conn = getConn();
		String sql = "insert into easybuy_cart values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getUserid());
			ps.setInt(2, c.getShopid());
			ps.setInt(3, c.getCount());
			ps.setDouble(4, c.getCost());
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
	public int update(Cart c) {
		Connection conn = getConn();
		String sql = "update easybuy_cart set Buy_count=?,eo_cost=? where eo_user_id=? and Shop_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getCount());
			ps.setDouble(2, c.getCost());
			ps.setString(3, c.getUserid());
			ps.setInt(4, c.getShopid());
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}
	public int update(int cartid,int number,Double price) {
		Connection conn = getConn();
		String sql = "update easybuy_cart set Buy_count=?,eo_cost=? where cart_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, number);
			ps.setDouble(2, price*number);
			ps.setInt(3, cartid);
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
	public int deleteid(String userid, int shopid) {
		Connection conn = getConn();
		String sql = "delete from easybuy_cart where eo_user_id=? and Shop_id";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setInt(2, shopid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}
	public int deleteid(int cartid) {
		Connection conn = getConn();
		String sql = "delete from easybuy_cart where cart_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartid);
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
	public int deleteuserid(String userid) {
		Connection conn = getConn();
		String sql = "delete from easybuy_cart where eo_user_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} finally {
			closeConn();
		}
	}

	public Cart querycart(int cartid) {
		Connection conn = getConn();
		Cart c = null;
		String sql = "select * from easybuy_cart where cart_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, cartid);
			ResultSet rst = ps.executeQuery();
			if(rst.next()) {
				c = new Cart(rst.getInt(1), rst.getString(2), rst.getInt(3),
						rst.getInt(4), rst.getDouble(5));

			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConn();
		}
	}

}
