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
 * Entity implementation class for Entity: Alert
 *
 */
@Entity
@XmlRootElement
public class Alert implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Alert;
	private String Alert_Subject;
	private String Alert_Description;
	private Date Alert_Date;
	private String Alert_Location;

	
	@ManyToOne
	private Admin admin;

	
	@ManyToOne
	private Member member;

	private static final long serialVersionUID = 1L;

	public Alert() {
		super();
	}

	public Integer getId_Alert() {
		return id_Alert;
	}

	public void setId_Alert(Integer id_Alert) {
		this.id_Alert = id_Alert;
	}

	public String getAlert_Subject() {
		return this.Alert_Subject;
	}

	public void setAlert_Subject(String Alert_Subject) {
		this.Alert_Subject = Alert_Subject;
	}

	public String getAlert_Description() {
		return this.Alert_Description;
	}

	public void setAlert_Description(String Alert_Description) {
		this.Alert_Description = Alert_Description;
	}

	public Date getAlert_Date() {
		return this.Alert_Date;
	}

	public void setAlert_Date(Date Alert_Date) {
		this.Alert_Date = Alert_Date;
	}

	public String getAlert_Location() {
		return this.Alert_Location;
	}

	public void setAlert_Location(String Alert_Location) {
		this.Alert_Location = Alert_Location;
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

}
