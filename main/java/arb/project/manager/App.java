package arb.project.manager;

import java.util.List;


import arb.project.manager.dao.OrdersDao;
import arb.project.manager.entity.Orders;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	OrdersDao od = new OrdersDao();
    	
    	List<Orders> orders = od.getAll();
    	
    	System.out.println("***Pedidos: " + orders);
    	
    }
}
