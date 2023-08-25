package arb.project.manager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "orderInvoice")
public class OrderInvoice {
	
	// Atributos
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String number;
	
	@OneToOne (mappedBy = "orderInvoice")
	private Orders order; // Relacion con la clase factura donde un pedido solo puede tener una factura y una factura solo puede pertenecer a un pedido 1:1
	
	// Constructores
	
	public OrderInvoice() {}
	
	public OrderInvoice(Orders order) {
		this.order = order;
	}
	
	public OrderInvoice(String number) {
		this.number = number;
	}
	
	// Getters & Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderInvoice [id=" + id + ", number=" + number + ", order=" + order + "]";
	}

	
	
	
}
