package easybuy.dao;

import java.util.List;

import easybuy.entity.News;

public interface NewsDao {
	// ��ѯ��������
	public List<News> query(int page, int row);
	//��������
	public int AddNews(News p);
	//�޸�����
	public int updateNews(News p);
	//ɾ������
	public int deleteNews(int id);
}
