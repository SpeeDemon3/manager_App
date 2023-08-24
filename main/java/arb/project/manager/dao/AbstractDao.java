package arb.project.manager.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import arb.project.manager.tools.EntityManagerTool;

public abstract class AbstractDao<T> implements Dao {
	
	private EntityManager em = EntityManagerTool.getEntityManager();
	private Class<T> clazz;

	@Override
	public Optional get(long id) {
		return Optional.ofNullable(em.find(clazz, id));
	}

	@Override
	public List getAll() {
		String qlString = "FROM " + clazz.getName();
		Query query = em.createQuery(qlString);
		return query.getResultList();
	}

	@Override
	public void save(Object t) {
		executeInsideTransaction(em -> em.persist(t));
	}

	@Override
	public void update(Object t) {
		executeInsideTransaction(em -> em.merge(t));
	}

	@Override
	public void delete(Object t) {
		executeInsideTransaction(em -> em.remove(t));
	}

	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	private void executeInsideTransaction(Consumer<EntityManager> action) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			action.accept(em);
			et.commit();
		} catch (RuntimeException e) {
			et.rollback();
			throw e;
		}
	}
	
}
