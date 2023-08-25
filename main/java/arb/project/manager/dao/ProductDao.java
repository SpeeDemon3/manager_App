package arb.project.manager.dao;

import arb.project.manager.entity.Product;

public class ProductDao extends AbstractDao<Product> {
	
	public ProductDao() {
		setClazz(Product.class);
	}
	
}
