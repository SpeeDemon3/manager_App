package arb.project.manager.dao;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import arb.project.manager.entity.Orders;

public class OrdersDao extends AbstractDao<Orders>{

	public OrdersDao() {
		setClazz(Orders.class);
	}
	
	/**
	 * Matodo para obtener el pedido mas reciente
	 * @return -> Consulta con el pedido mas reciente
	 */
	public Orders mostRecentOrder() {
		
		String qlString = "FROM " + Orders.class.getName() 
				+ " WHERE date < now() order by date desc";
		
		Query query = getEntityManager().createQuery(qlString).setMaxResults(1);
				 
		return (Orders) query.getSingleResult();
		
	}
	
	/**
	 * Metodo para obtener el pedido mas reciente
	 * utilizando criteria
	 * @return -> Consulta con el pedido mas reciente
	 */
	public Orders mostRecentOrderCriteria() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Orders> criteriaQuery = cb.createQuery(Orders.class);
		Root<Orders> root = criteriaQuery.from(Orders.class);
		criteriaQuery.select(root).where(cb.lessThan(root.get("date"), LocalDateTime.now()));
		criteriaQuery.orderBy(cb.desc(root.get("date")));
		Query query = getEntityManager().createQuery(criteriaQuery).setMaxResults(1);
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
