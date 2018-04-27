package easybuy.dao;
//2018-4-27
import java.util.List;

import easybuy.entity.Cart;

public interface CartDao {
	// 根据用户id查询购物车信息
	public List<Cart> query(String userid);

	// 为某个用户增加购物车信息（已经存在和不存在）
	public int add(Cart c);

	// 修改某件商品数量（同时价格也要跟着变）
	public int update(Cart c);

	// 删除某件商品信
	public int deleteid(String userid, int shopid);

	// 清空购物车
	public int deleteuserid(String userid);
}
