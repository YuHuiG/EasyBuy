package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easybuy.dao.NewsDao;
import easybuy.entity.News;

public class NewsDaoImp extends DBUitl implements NewsDao {

	@Override
	public List<News> query(int page, int row) {
		Connection conn = getConn();
		List<News> list = new ArrayList<News>();
		String sql = "select top " + row
				+ " * from easybuy_news where en_id not in(select top " + row
				* (page - 1) + " en_id from easybuy_news)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				News n = new News(rst.getInt(1), rst.getString(2),
						rst.getString(3), rst.getString(4));
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
public News queryid(int id){
	Connection conn = getConn();
	News n=null;
	String sql = "select * from easybuy_news where en_id=?";
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rst = ps.executeQuery();
		if (rst.next()) {
			n = new News(rst.getInt(1), rst.getString(2),
					rst.getString(3), rst.getString(4));
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
	@Override
	public int AddNews(News p) {
		Connection conn = getConn();
		String sql = "insert into easybuy_news values(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getTitle());
			ps.setString(2, p.getContent());
			ps.setString(3, p.getTime());
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
	public int updateNews(News p) {
		Connection conn = getConn();
		String sql = "update easybuy_news set en_title=?,en_content=? where en_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getTitle());
			ps.setString(2, p.getContent());
			ps.setInt(3, p.getId());
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
	public int deleteNews(int id) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "delete easybuy_news where en_id=?";
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
		String sql = "select count(*) from easybuy_news";
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

}
