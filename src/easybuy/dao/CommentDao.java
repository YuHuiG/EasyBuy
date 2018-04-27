package easybuy.dao;

import java.util.List;

import easybuy.entity.Comment;


public interface CommentDao {
		// ²éÑ¯ËùÓĞÁôÑÔ
		public List<Comment> query(int page, int row);
		//Ôö¼ÓÁôÑÔ
		public int AddComment(Comment c);
		//ĞŞ¸ÄÁôÑÔ
		public int updateComment(Comment c);
		//É¾³ıÁôÑÔ
		public int deleteComment(int id);
}
