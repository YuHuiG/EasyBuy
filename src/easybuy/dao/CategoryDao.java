package easybuy.dao;

import java.util.List;

import easybuy.entity.Category;

public interface CategoryDao {
	// ��ѯ�����
	public List<Category> querybig();
	// ��ѯС����
	public List<Category> querysmall();
	//������
	public int AddCategory(String name,int parentid);
	//�޸���
	public int updateCategory(String name,int epcid);
	//ɾ����
	public int deleteCategory(int id);
	//ɾ������ʱ��С��Ҳɾ��
	public int deleteCate(int parentid);
}
