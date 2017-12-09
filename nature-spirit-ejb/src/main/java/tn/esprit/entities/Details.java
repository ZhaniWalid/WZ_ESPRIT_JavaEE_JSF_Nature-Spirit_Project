package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Details
 *
 */
@Entity
@XmlRootElement
public class Details implements Serializable {

	@EmbeddedId
	private DetailsId detailsId;
	private Integer Quantity;
	private Boolean state; // true -> Member Has Paied / false -> Member Has not Paied yet
	private Double total_amount; 
	
	
	@ManyToOne
	@JoinColumn(name = "Id_Member", referencedColumnName = "id_Member", updatable = false, insertable = false)
	private Member member;

	
	@ManyToOne
	@JoinColumn(name = "Id_Product", referencedColumnName = "id_Product", updatable = false, insertable = false)
	private Product product;

	private static final long serialVersionUID = 1L;

	public Details() {
		super();
	}
 
	public Details(Integer Quantity, Member member, Product product) {
		super();
		this.Quantity = Quantity;// default=0 products to buy
		this.member = member;
		this.product = product;
		this.state = false; // false -> Member Has not Paied yet
		this.total_amount=0.0;// default = 0 DTN
		this.detailsId = new DetailsId(member.getId_Member(), product.getId_Product());
	}
	
	

	public Details(Integer Quantity, Double total_amount, Member member, Product product) {
		super();
		this.Quantity = Quantity;
		this.total_amount = total_amount;
		this.member = member;
		this.product = product;
	}

	
	
	public Details(Integer Quantity, Boolean state, Double total_amount, Member member, Product product) {
		super();
		this.Quantity = Quantity;
		this.state = state;
		this.total_amount = total_amount;
		this.member = member;
		this.product = product;
	} 

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public Integer getQuantity() {
		return this.Quantity;
	}

	public void setQuantity(Integer Quantity) {
		this.Quantity = Quantity;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public DetailsId getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(DetailsId detailsId) {
		this.detailsId = detailsId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
