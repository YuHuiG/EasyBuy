package easybuy.dao;

import java.util.List;

import easybuy.entity.Comment;


public interface CommentDao {
		// ��ѯ��������
		public List<Comment> query(int page, int row);
		//��������
		public int AddComment(Comment c);
		//�޸�����
		public int updateComment(Comment c);
		//ɾ������
		public int deleteComment(int id);
}
