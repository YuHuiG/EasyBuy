package easybuy.dao;

import java.util.List;

import easybuy.entity.Product;

public interface ProductDao {
		// 查询所有商品
		public List<Product> query(int page, int row);
		//增加商品
		public int AddProduct(Product p);
		//修改商品
		public int updateProduct(Product p);
		//删除商品
		public int deleteProduct(int id);
		
		
}
