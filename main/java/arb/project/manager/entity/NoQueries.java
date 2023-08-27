package arb.project.manager.entity;

import arb.project.manager.dao.OrdersDao;

/**
 * Clase para recuperar datos sin consultas
 */
public class NoQueries {

	public static void main(String[] args) {
		
		OrdersDao ordersDao = new OrdersDao();
		Orders order = ordersDao.mostRecentOrderCriteria();
		System.out.println("*** Factura: " + order.getOrderInvoice());
		System.out.println("*** Albaranes: " + order.getDeliveryNotes());
		System.out.println("*** Productos : " + order.getProducts());
	}
	
}
