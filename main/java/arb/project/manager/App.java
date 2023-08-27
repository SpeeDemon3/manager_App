package arb.project.manager;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import arb.project.manager.dao.DeliveryNoteDao;
import arb.project.manager.dao.OrdersDao;
import arb.project.manager.entity.DeliveryNote;
import arb.project.manager.entity.Orders;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

    	OrdersDao ordersDao = new OrdersDao();
   
    	Orders order = new Orders("001", LocalDateTime.now());
    	ordersDao.save(order);
    	
    	Orders order2 = new Orders("pet", LocalDateTime.now().plus(2, ChronoUnit.DAYS));
    	ordersDao.save(order2);
    	
    	// Pedido mas reciente
    	Orders mostRecent = ordersDao.mostRecentOrder();
    	System.out.println("*** Pedido más reciente: " + mostRecent);
    	
    	// Pedido mas reciente
    	Orders mostRecentCriteria = ordersDao.mostRecentOrderCriteria();
    	System.out.println("*** Pedido más reciente utilizando CRITERIA: " + mostRecentCriteria);
    	
    	System.out.println("-------------------------------------------------------------------");
    	
    	// Pedido de hace justo una semana
    	Orders order3 = new Orders("orderPass", LocalDateTime.now().minus(1, ChronoUnit.WEEKS));
    	ordersDao.save(order3);
    	
    	List<Orders> lastWeek = ordersDao.ordersLastWeek();
    	System.out.println("*** Pedidos de la semana pasada: " + lastWeek);
    	
    	System.out.println("-------------------------------------------------------------------");
    	
    	List<Orders> orders = ordersDao.getAll();
       	System.out.println("***Pedidos:");
       	for (Orders o : orders) {
       		System.out.println(o);
       	}
       	
    	System.out.println("-------------------------------------------------------------------");

    	// Albaranes
    	
    	DeliveryNoteDao deliveryNoteDao = new DeliveryNoteDao();
    	
    	DeliveryNote deliveryNote1 = new DeliveryNote("01");
    	deliveryNoteDao.save(deliveryNote1);
    	
    	DeliveryNote deliveryNote2 = new DeliveryNote("02");
    	deliveryNoteDao.save(deliveryNote2);
    	
    	List<DeliveryNote> deliveryNotes = deliveryNoteDao.getAll();
    	System.out.println("***Albaranes:");
    	for (DeliveryNote d : deliveryNotes) {
    		System.out.println(d);
    	}
    	
    }
}
