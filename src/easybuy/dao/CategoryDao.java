package easybuy.dao;

import java.util.List;

import easybuy.entity.Category;

public interface CategoryDao {
	// 查询大分类
	public List<Category> querybig();
	// 查询小分类
	public List<Category> querysmall();
	//增加类
	public int AddCategory(String name,int parentid);
	//修改类
	public int updateCategory(String name,int epcid);
	//删除类
	public int deleteCategory(int id);
	//删除大类时把小类也删了
	public int deleteCate(int parentid);
}
