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
 * Entity implementation class for Entity: Photography_Competition
 *
 */
@Entity
@XmlRootElement
public class Photography_Competition implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_PhotoCompetition;
	private String Description;
	private String Picture;
	private Date Date_Of_Capture;

	
	@ManyToOne
	private Admin admin;

	@ManyToOne
	private Member member;

	@ManyToOne
	private Member journalist;
	
	@ManyToOne
	private ReclamationPicture reclamationPicture;

	public ReclamationPicture getReclamationPicture() {
		return reclamationPicture;
	}

	public void setReclamationPicture(ReclamationPicture reclamationPicture) {
		this.reclamationPicture = reclamationPicture;
	}

	private static final long serialVersionUID = 1L;

	public Photography_Competition() {
		super();
	}

	public Integer getId_PhotoCompetition() {
		return id_PhotoCompetition;
	}

	public void setId_PhotoCompetition(Integer id_PhotoCompetition) {
		this.id_PhotoCompetition = id_PhotoCompetition;
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getPicture() {
		return this.Picture;
	}

	public void setPicture(String Picture) {
		this.Picture = Picture;
	}

	public Date getDate_Of_Capture() {
		return this.Date_Of_Capture;
	}

	public void setDate_Of_Capture(Date Date_Of_Capture) {
		this.Date_Of_Capture = Date_Of_Capture;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getJournalist() {
		return journalist;
	}

	public void setJournalist(Member journalist) {
		this.journalist = journalist;
	}

}
