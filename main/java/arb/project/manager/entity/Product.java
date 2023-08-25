package arb.project.manager.entity;

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
	
	@Column (unique = true)
	private String reference;
	
	private String description;
	
	@ManyToMany
	private Set<Orders> orders;
	
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", reference=" + reference + ", description=" + description + "]";
	}
	
	
	
}
