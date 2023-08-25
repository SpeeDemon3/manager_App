package arb.project.manager.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "deliveryNote")
public class DeliveryNote {
	
	// Atributos
	
	private static final String PREFIX = "ALB-";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String reference;
	private LocalDateTime issueDate;
	private LocalDateTime dateOfReceipt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Orders order; // Atributo de la relacion 1:N -> Un pedido puede tener muchos albaranes pero un albaran solo puede pertenecer a un pedido
	
	// Constructores
	
	public DeliveryNote() {}
	
	public DeliveryNote(Orders order) {
		this.order = order;
	}
	
	public DeliveryNote(String refOrder) {
		reference = PREFIX + refOrder;
		issueDate = LocalDateTime.now();
	}
	
	// Getter & Setters
	
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

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDateTime getDateOfReceipt() {
		return dateOfReceipt;
	}

	public void setDateOfReceipt(LocalDateTime dateOfReceipt) {
		this.dateOfReceipt = dateOfReceipt;
	}
	
	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "DeliveryNote [id=" + id + ", reference=" + reference + ", issueDate=" + issueDate + ", dateOfReceipt="
				+ dateOfReceipt + "]";
	}
	
	
	
}
