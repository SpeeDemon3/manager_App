package arb.project.manager.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "product")
public class Product {

	// Atributos
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String reference;
	
	private String description;
	
	@ManyToMany
	private Set<Orders> orders = new HashSet<Orders>();
	
	// Constructores
	
	public Product() {}
	
	public Product(String ref, String desc) {
		this.reference = ref;
		this.description = desc;
	}
	
	
	// Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Orders> getOrders() {
		return orders;
	}

//	public void setOrders(Set<Orders> orders) {
//		this.orders = orders;
//	}
	
	public void addOrder(Orders order) {
		orders.add(order);
		if (!order.getProducts().contains(this)) {
			order.addProduct(this);
		}
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", reference=" + reference + ", description=" + description + "]";
	}

	
	
}
