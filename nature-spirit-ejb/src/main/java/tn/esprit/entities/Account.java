package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity
@XmlRootElement
public class Account implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Account;
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "id_member_fk") private Member member;
	 */

	private Double Credit;

	
	@ManyToOne
	private Member member;

	// Added Attribute
	
	private int Rib_Number;
	
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}

	public Integer getId_Account() {
		return id_Account;
	}

	public void setId_Account(Integer id_Account) {
		this.id_Account = id_Account;
	}

	public Double getCredit() {
		return this.Credit;
	}

	public void setCredit(Double Credit) {
		this.Credit = Credit;
	}
	
	public int getRib_Number() {
		return Rib_Number;
	}

	public void setRib_Number(int rib_Number) {
		Rib_Number = rib_Number;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Credit == null) ? 0 : Credit.hashCode());
		result = prime * result + Rib_Number;
		result = prime * result + ((id_Account == null) ? 0 : id_Account.hashCode());
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
		Account other = (Account) obj;
		if (Credit == null) {
			if (other.Credit != null)
				return false;
		} else if (!Credit.equals(other.Credit))
			return false;
		if (Rib_Number != other.Rib_Number)
			return false;
		if (id_Account == null) {
			if (other.id_Account != null)
				return false;
		} else if (!id_Account.equals(other.id_Account))
			return false;
		return true;
	}

	
	  
}
