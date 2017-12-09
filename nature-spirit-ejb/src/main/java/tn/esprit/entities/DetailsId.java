package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class DetailsId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer Id_Member;
	private Integer Id_Product;
	private Date date_Of_Purchase;

	public DetailsId() {
		super();
	} 

	public DetailsId(Integer Id_Member, Integer Id_Product) {
		super();
		this.Id_Member = Id_Member;
		this.Id_Product = Id_Product;
		this.date_Of_Purchase = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_Of_Purchase == null) ? 0 : date_Of_Purchase.hashCode());
		result = prime * result + ((Id_Member == null) ? 0 : Id_Member.hashCode());
		result = prime * result + ((Id_Product == null) ? 0 : Id_Product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailsId other = (DetailsId) obj;
		if (date_Of_Purchase == null) {
			if (other.date_Of_Purchase != null)
				return false;
		} else if (!date_Of_Purchase.equals(other.date_Of_Purchase))
			return false;
		if (Id_Member == null) {
			if (other.Id_Member != null)
				return false;
		} else if (!Id_Member.equals(other.Id_Member))
			return false;
		if (Id_Product == null) {
			if (other.Id_Product != null)
				return false;
		} else if (!Id_Product.equals(other.Id_Product))
			return false;
		return true;
	}

	public Integer getId_Member() {
		return Id_Member;
	}

	public void setId_Member(Integer Id_Member) {
		this.Id_Member = Id_Member;
	}

	public Integer getId_Product() {
		return Id_Product;
	}

	public void setId_Product(Integer Id_Product) {
		this.Id_Product = Id_Product;
	}

	public Date getDate_Of_Purchase() {
		return date_Of_Purchase;
	}

	public void setDate_Of_Purchase(Date date_Of_Purchase) {
		this.date_Of_Purchase = date_Of_Purchase;
	}

}
