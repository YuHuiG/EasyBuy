package easybuy.dao;

import java.util.List;

import easybuy.entity.Product;

public interface ProductDao {
		// ��ѯ������Ʒ
		public List<Product> query(int page, int row);
		//������Ʒ
		public int AddProduct(Product p);
		//�޸���Ʒ
		public int updateProduct(Product p);
		//ɾ����Ʒ
		public int deleteProduct(int id);
		
		
}
