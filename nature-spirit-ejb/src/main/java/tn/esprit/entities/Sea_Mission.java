package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Sea_Mission
 *
 */
@Entity
@XmlRootElement
public class Sea_Mission implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_SeaMission;
	private String Destination;
	private String Goal;
	private int Ship_Number;

	
	@ManyToOne
	private Admin admin;

	
	@OneToMany(mappedBy = "sea_Mission", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Mission_Sailor> mission_sailors;

	private static final long serialVersionUID = 1L;

	public Sea_Mission() {
		super();
	}

	public Integer getId_SeaMission() {
		return id_SeaMission;
	}

	public void setId_SeaMission(Integer id_SeaMission) {
		this.id_SeaMission = id_SeaMission;
	}

	public String getDestination() {
		return this.Destination;
	}

	public void setDestination(String Destination) {
		this.Destination = Destination;
	}

	public String getGoal() {
		return this.Goal;
	}

	public void setGoal(String Goal) {
		this.Goal = Goal;
	}

	public int getShip_Number() {
		return this.Ship_Number;
	}

	public void setShip_Number(int Ship_Number) {
		this.Ship_Number = Ship_Number;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@XmlTransient  
	public List<Mission_Sailor> getMission_sailors() {
		return mission_sailors;
	}

	public void setMission_sailors(List<Mission_Sailor> mission_sailors) {
		this.mission_sailors = mission_sailors;
	}

}
