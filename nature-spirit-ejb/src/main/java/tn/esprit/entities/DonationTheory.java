package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Donation
 *
 */
@Entity
@XmlRootElement
public class DonationTheory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Donation_Theory;
	private Double Amount_of_money;
	private Date Date_of_transfert;
 
	
	@ManyToOne
	private Member member;

	private static final long serialVersionUID = 1L;

	public DonationTheory() {
		super();
	}
	
	
	
	public DonationTheory(Integer id_Donation_Theory) {
		super();
		this.id_Donation_Theory = id_Donation_Theory;
		this.Date_of_transfert = new Date();     
	}



	public DonationTheory(Integer id_Donation_Theory, Double Amount_of_money, Date date_of_transfert) {
		super();
		this.id_Donation_Theory = id_Donation_Theory;
		this.Amount_of_money = Amount_of_money;
		this.Date_of_transfert = new Date();      
	}

	public Integer getId_Donation_Theory() {
		return id_Donation_Theory;
	}

	public void setId_Donation_Theory(Integer id_Donation_Theory) {
		this.id_Donation_Theory = id_Donation_Theory;
	}

	public Double getAmount_of_money() {
		return this.Amount_of_money;
	} 

	public void setAmount_of_money(Double Amount_of_money) {
		this.Amount_of_money = Amount_of_money;
	}

	public Date getDate_of_transfert() {
		return this.Date_of_transfert;
	}

	public void setDate_of_transfert(Date Date_of_transfert) {
		this.Date_of_transfert = Date_of_transfert;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
