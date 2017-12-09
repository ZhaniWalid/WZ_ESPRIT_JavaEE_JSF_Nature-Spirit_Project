package tn.esprit.entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: SeaMissionAward
 *
 */
@Entity
@XmlRootElement
public class SeaMissionAward implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSeaMissionAward;
	private String Destination;
	private Double longitude;
	private Double altitude;
	private Date startDate;
	private Date endStart;
	private String goal;
	private String warning;
	
	
	@OneToOne
	private Sailor sailor;
	
	
	@ManyToOne
	private Admin admin;
	
	private static final long serialVersionUID = 1L;

	public SeaMissionAward() {
		super();
	}   
	public Integer getIdSeaMissionAward() {
		return this.idSeaMissionAward;
	}

	public void setIdSeaMissionAward(Integer idSeaMissionAward) {
		this.idSeaMissionAward = idSeaMissionAward;
	}   
	public String getDestination() {
		return this.Destination;
	}

	public void setDestination(String Destination) {
		this.Destination = Destination;
	}   
	public Double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}   
	public Double getAltitude() {
		return this.altitude;
	}

	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}   
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}   
	public Date getEndStart() {
		return this.endStart;
	}

	public void setEndStart(Date endStart) {
		this.endStart = endStart;
	}   
	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}   
	public String getWarning() {
		return this.warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}
   
}
