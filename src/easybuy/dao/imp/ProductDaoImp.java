package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easybuy.dao.ProductDao;
import easybuy.entity.Product;

public class ProductDaoImp extends DBUitl implements ProductDao {

	@Override
	public List<Product> query(int page, int row) {
		// TODO Auto-generated method stub
		// 获取数据库联接
		Connection conn = getConn();
		List<Product> list = new ArrayList<Product>();
		String sql = "select top " + row
				+ " * from easybuy_product where ep_id not in(select top "
				+ row * (page - 1) + " ep_id from easybuy_product)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Product u = new Product(rst.getInt(1), rst.getString(2),
						rst.getString(3), rst.getDouble(4), rst.getInt(5),
						rst.getInt(6), rst.getInt(7), rst.getString(8));
				list.add(u);
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
	public int AddProduct(Product p) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "insert into easybuy_product values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getEpname());
			ps.setString(2, p.getEpdescription());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getEpcid());
			ps.setInt(5, p.getEpcchildid());
			ps.setInt(6, p.getStock());
			ps.setString(7, p.getUl());
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
	public int updateProduct(Product p) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "update easybuy_product set ep_name=?,ep_description=?,rp_price=?,ep_stock=?,epc_id=?,epc_child_id=?,ep_file_name=? where ep_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getEpname());
			ps.setString(2, p.getEpdescription());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getStock());
			ps.setInt(5, p.getEpcid());
			ps.setInt(6, p.getEpcchildid());
			ps.setString(7, p.getUl());
			ps.setInt(8, p.getEpid());
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
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "delete from easybuy_product where ep_id=?";
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

	public int queryCount() {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		int count = 0;
		String sql = "select count(*) from easybuy_product";
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

	public Product query(int parseInt) {
		Connection conn = getConn();
		Product p = null;
		String sql = "select * from easybuy_product where ep_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, parseInt);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				p = new Product(rst.getInt(1), rst.getString(2),
						rst.getString(3), rst.getDouble(4), rst.getInt(5),
						rst.getInt(6), rst.getInt(7), rst.getString(8));
			}
			return p;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			closeConn();
		}
	}

}
