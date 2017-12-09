package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Donation
 *
 */
@Entity
@XmlRootElement
public class Donation implements Serializable {
	@EmbeddedId
	private DonationId donationId;
	private Float amount;
	private Date dateOfDonation;

	
	@ManyToOne
	@JoinColumn(name = "idEvent", referencedColumnName = "id_Event", updatable = false, insertable = false)
	private Event event;
	
	       
	@ManyToOne
	@JoinColumn(name = "idMember", referencedColumnName = "id_Member", updatable = false, insertable = false)
	private Member member;
	private static final long serialVersionUID = 1L;

	public Donation() {
		super();
	}

	public Donation(Float amount, Event event, Member member) {
		this.setDateOfDonation(new Date());
		this.donationId = new DonationId(member.getId_Member(), event.getId_Event());
		this.amount = amount;
		this.event = event;
		this.member = member;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getDateOfDonation() {
		return this.dateOfDonation;
	}

	public void setDateOfDonation(Date dateOfDonation) {
		this.dateOfDonation = dateOfDonation;
	}

	public DonationId getDonationId() {
		return donationId;
	}

	public void setDonationId(DonationId donationId) {
		this.donationId = donationId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
