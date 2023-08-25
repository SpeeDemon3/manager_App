package arb.project.manager.dao;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Query;

import arb.project.manager.entity.Orders;

public class OrdersDao extends AbstractDao<Orders>{

	public OrdersDao() {
		setClazz(Orders.class);
	}
	
	public Orders mostRecentOrder() {
		
		String qlString = "FROM " + Orders.class.getName() 
				+ " WHERE date < now() order by date desc";
		
		Query query = getEntityManager().createQuery(qlString).setMaxResults(1);
				 
		return (Orders) query.getSingleResult();
		
	}
	
	public List<Orders> ordersLastWeek(){
		
		String qlString = "FROM " + Orders.class.getName()
				+ " WHERE date between ?1 and ?2";
		
		Query query = getEntityManager().createQuery(qlString);
		
		LocalDate thisMonday = getThisMonday();
		
		LocalDate afterMonday = thisMonday.minusWeeks(1);
		
		query.setParameter(1, afterMonday.atStartOfDay());
		
		query.setParameter(2, thisMonday.atStartOfDay());
		
		return query.getResultList();
		
	}
	
	private static LocalDate getThisMonday() {
		
		LocalDate now = LocalDate.now();
		
		DayOfWeek dayWeek = now.getDayOfWeek();
		
		return now.minusDays(dayWeek.getValue() - 1);
		
	}
	
}
