package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easybuy.dao.CategoryDao;
import easybuy.entity.Category;

public class CategoryDaoImp extends DBUitl implements CategoryDao {
	// 查询分类
	@Override
	public List<Category> querybig() {
		// TODO Auto-generated method stub
		// 获取数据库联接
		Connection conn = getConn();
		List<Category> list = new ArrayList<Category>();
		String sql = "select * from easybuy_product_category where epc_parent_id=0";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Category u = new Category(rst.getInt(1), rst.getString(2), rst.getInt(3));
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
	public List<Category> querysmall() {
		// TODO Auto-generated method stub
		// 获取数据库联接
				Connection conn = getConn();
				List<Category> list = new ArrayList<Category>();
				String sql = "select * from easybuy_product_category where epc_parent_id!=0";
				try {
					PreparedStatement ps = conn.prepareStatement(sql);
					ResultSet rst = ps.executeQuery();
					while (rst.next()) {
						Category u = new Category(rst.getInt(1), rst.getString(2), rst.getInt(3));
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
	public int AddCategory(String name, int parentid) {
		// TODO Auto-generated method stub
		Connection conn=getConn();
		String sql="insert into easybuy_product_category values(?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, parentid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			closeConn();
		}
	}
	//修改类
	@Override
	public int updateCategory(String name,int epcid) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "update easybuy_product_category set epc_name=? where epc_id=?";
		int i = -1;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,name );
			ps.setInt(2, epcid);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
		} finally {
				closeConn();
		}
		return i;
	}
	//删除类
	@Override
	public int deleteCategory(int id) {
		// TODO Auto-generated method stub
		Connection conn=getConn();
		String sql="delete from easybuy_product_category where epc_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,id);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			closeConn();
		}
	}

	@Override
	public int deleteCate(int parentid) {
		// TODO Auto-generated method stub
		Connection conn=getConn();
		String sql="delete from easybuy_product_category where epc_parent_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,parentid);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally{
			closeConn();
		}
	}

	public int query(int parseInt) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		int parentid=-1;
		String sql = "select epc_parent_id from easybuy_product_category where epc_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, parseInt);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				parentid = rst.getInt(1);
			}
			return parentid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return parentid;
		} finally {
			closeConn();
		}
	}
	

}
