package easybuy.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import easybuy.dao.CommentDao;
import easybuy.entity.Comment;

public class CommentDaoImp extends DBUitl implements CommentDao {

	@Override
	public List<Comment> query(int page, int row) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		List<Comment> list = new ArrayList<Comment>();
		String sql = "select top " + row
				+ " * from easybuy_comment where ec_id not in(select top "
				+ row * (page - 1) + " ec_id from easybuy_comment)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rst = ps.executeQuery();
			while (rst.next()) {
				Comment c = new Comment(rst.getInt(1), rst.getString(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getString(6));
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
	public int AddComment(Comment c) {
		Connection conn = getConn();
		String sql = "insert into easybuy_comment values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getEconten());
			ps.setString(2, c.getEcrettime());
			ps.setString(3, null);
			ps.setString(4, null);
			ps.setString(5, c.getEcnicename());
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
	public int updateComment(Comment c) {
		// TODO Auto-generated method stub
		Connection conn = getConn();
		String sql = "update easybuy_comment set ec_reply=?,ec_reply_time=? where ec_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getEcreply());
			ps.setString(2, c.getEcreplytime());
			ps.setInt(3, c.getEcid());
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
	public int deleteComment(int id) {
		Connection conn = getConn();
		String sql = "delete easybuy_comment where ec_id=?";
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
		String sql = "select count(*) from easybuy_comment";
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

	public Comment queryid(int id) {
		Connection conn = getConn();
		Comment c = null;
		String sql = "select * from easybuy_comment where ec_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rst = ps.executeQuery();
			if (rst.next()) {
				c = new Comment(rst.getInt(1), rst.getString(2),
						rst.getString(3), rst.getString(4), rst.getString(5),
						rst.getString(6));
			}
			return c;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally{
			closeConn();
		}

		

	}

}
