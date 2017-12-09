package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity
@XmlRootElement
public class Event implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Event;
	private String NameEvent;
	private String TypeEvent;
	private String Description_Event;
	private String Location_Event;
	private Date Date_Event;

	
	@OneToMany(mappedBy = "event")
	private List<Donation> donations;
	
	
	@ManyToOne
	private Admin admin;

	
	@OneToMany(mappedBy = "event")
	private List<Participation> participations;

	private static final long serialVersionUID = 1L;

	public Event() {
		super();
	}

	public Event(String nameEvent, String typeEvent, String description_Event, String location_Event, Date date_Event) {
		super();
		NameEvent = nameEvent;
		TypeEvent = typeEvent;
		Description_Event = description_Event;
		Location_Event = location_Event;
		Date_Event = date_Event;
	}

	public Integer getId_Event() {
		return id_Event;
	}

	public void setId_Event(Integer id_Event) {
		this.id_Event = id_Event;
	}

	public String getNameEvent() {
		return NameEvent;
	}

	public void setNameEvent(String nameEvent) {
		NameEvent = nameEvent;
	}

	public String getDescription_Event() {
		return this.Description_Event;
	}

	public void setDescription_Event(String Description_Event) {
		this.Description_Event = Description_Event;
	}

	public String getLocation_Event() {
		return Location_Event;
	}

	public void setLocation_Event(String location_Event) {
		Location_Event = location_Event;
	}

	public Date getDate_Event() {
		return Date_Event;
	}

	public void setDate_Event(Date date_Event) {
		Date_Event = date_Event;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@XmlTransient
	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}

	@XmlTransient
	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public String getTypeEvent() {
		return TypeEvent;
	}

	public void setTypeEvent(String typeEvent) {
		TypeEvent = typeEvent;
	}

}
