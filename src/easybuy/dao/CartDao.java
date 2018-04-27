package easybuy.dao;

import java.util.List;

import easybuy.entity.Cart;

public interface CartDao {
	// �����û�id��ѯ���ﳵ��Ϣ
	public List<Cart> query(String userid);

	// Ϊĳ���û����ӹ��ﳵ��Ϣ���Ѿ����ںͲ����ڣ�
	public int add(Cart c);

	// �޸�ĳ����Ʒ������ͬʱ�۸�ҲҪ���ű䣩
	public int update(Cart c);

	// ɾ��ĳ����Ʒ��
	public int deleteid(String userid, int shopid);

	// ��չ��ﳵ
	public int deleteuserid(String userid);
}
