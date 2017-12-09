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
 * Entity implementation class for Entity: Reclamation
 *
 */
@Entity
@XmlRootElement
public class Reclamation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Reclamation;
	private String Subject_Reclamation;
	private String Description_Reclamation;
	private Date Date_Reclamation;
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	private Admin admin;
	
	
	@ManyToOne
	private Member member;

	public Reclamation() {
		super();
	}

	public Integer getId_Reclamation() {
		return id_Reclamation;
	}

	public void setId_Reclamation(Integer id_Reclamation) {
		this.id_Reclamation = id_Reclamation;
	}

	public String getSubject_Reclamation() {
		return this.Subject_Reclamation;
	}

	public void setSubject_Reclamation(String Subject_Reclamation) {
		this.Subject_Reclamation = Subject_Reclamation;
	}

	public String getDescription_Reclamation() {
		return this.Description_Reclamation;
	}

	public void setDescription_Reclamation(String Description_Reclamation) {
		this.Description_Reclamation = Description_Reclamation;
	}

	public Date getDate_Reclamation() {
		return this.Date_Reclamation;
	}

	public void setDate_Reclamation(Date Date_Reclamation) {
		this.Date_Reclamation = Date_Reclamation;
	}

	// les getters et les setters de les relations *..1 du reclamation-admin

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
	

}
