package arb.project.manager.dao;

import arb.project.manager.entity.Orders;

public class OrdersDao extends AbstractDao<Orders>{

	public OrdersDao() {
		setClazz(Orders.class);
	}
	
}
