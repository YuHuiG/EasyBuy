package easybuy.dao;

import java.util.List;

import easybuy.entity.News;

public interface NewsDao {
	// 查询所有新闻
	public List<News> query(int page, int row);
	//增加新闻
	public int AddNews(News p);
	//修改新闻
	public int updateNews(News p);
	//删除新闻
	public int deleteNews(int id);
}
