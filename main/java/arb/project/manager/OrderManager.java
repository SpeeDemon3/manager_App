package arb.project.manager;

import java.time.LocalDateTime;

import arb.project.manager.dao.OrdersDao;
import arb.project.manager.entity.DeliveryNote;
import arb.project.manager.entity.OrderInvoice;
import arb.project.manager.entity.Orders;
import arb.project.manager.entity.Product;

public class OrderManager {

	public static void main(String[] args) {

		OrdersDao orderDao = new OrdersDao();
		
		Product book = new Product("libJava", "Manual Imprescindible Java");
		
		Product textbook = new Product("cuaRojo", "Cuaderno rojo");
		
		Product pencil = new Product("lapHB", "Lápiz HB");
		
		Orders backToSchool = new Orders("333", LocalDateTime.now());
		backToSchool.addProduct(book);
		backToSchool.addProduct(textbook);
		backToSchool.addProduct(pencil);
		
		orderDao.save(backToSchool);
		
		DeliveryNote deliveryNote = backToSchool.generateDeliveryNote();
		OrderInvoice orderInvoice = backToSchool.generateInvoice();
		
		System.out.println("Pedido:\n" + backToSchool);
		
		orderDao.update(backToSchool);
		
		System.out.println("Pedido actualizado:\n" + backToSchool);
		
	}

}
