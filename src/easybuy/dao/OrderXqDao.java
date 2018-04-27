package easybuy.dao;

import java.util.List;

import easybuy.entity.OrderXq;

public interface OrderXqDao {
	public List<OrderXq> query(int eo_id);

	public int AddOrderXq(OrderXq p);

	public int updateOrderXq(OrderXq p);

	public int deleteOrderXq(int id);
}
