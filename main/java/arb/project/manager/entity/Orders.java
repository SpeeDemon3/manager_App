package arb.project.manager.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "orders")
public class Orders {

	@Column (name = "id")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "reference")
	private String reference;
	
	@Column (name = "date")
	private LocalDateTime date;
	
	@OneToMany(mappedBy = "order") // Relacion con la clase Albaran donde un pedido puede tener muchos albaranes
	private List<DeliveryNote> deliveryNotes; // Lista para guardar los albaranes del pedido
	
	@OneToOne
	@JoinColumn
	private OrderInvoice orderInvoice;
	
	@ManyToMany (mappedBy = "orders")
	private Set<Product> products;
	
	public Orders() {}
	
	public Orders(String ref, LocalDateTime date) {
		this.reference = ref;
		this.date = date;
	}

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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
		
	public List<DeliveryNote> getDeliveryNote() {
		return deliveryNotes;
	}

	public void setDeliveryNote(List<DeliveryNote> deliveryNote) {
		this.deliveryNotes = deliveryNote;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID -> " + id + " | Referencia -> " + reference + " | Fecha -> " + date);
		return sb.toString();
	}
	
	/**
	 * Metodo para añadir un producto al pedido
	 * @param product -> Producto que se desea añadir
	 */
	public void addProduct(Product product) {
		products.add(product);
	}
	
	/**
	 * Metodo para generar un albaran
	 * y añadirlos a la lista de albaranes
	 * @return -> Albaran generado
	 */
	public DeliveryNote generateDeliveryNote() {
		DeliveryNote deliveryNote = new DeliveryNote(this);
		deliveryNotes.add(deliveryNote);
		return deliveryNote;
	}
	
	/**
	 * Metodo para generar una factura
	 * @return -> Factura generada
	 */
	public OrderInvoice generateInvoice() {
		orderInvoice = new OrderInvoice(this);
		return orderInvoice;
	}
		
}
