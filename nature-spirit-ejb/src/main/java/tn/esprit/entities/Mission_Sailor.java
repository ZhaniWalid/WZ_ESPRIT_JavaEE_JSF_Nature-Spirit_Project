package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Mission_Sailor
 *
 */
@Entity
@XmlRootElement
public class Mission_Sailor implements Serializable {

	@EmbeddedId
	private Mission_SailorId mission_SailorId;
	private Boolean state; // true -> mission has been started / false ->
							// mission has not yet started

	
	@ManyToOne
	@JoinColumn(name = "Id_Member", referencedColumnName = "id_Member", updatable = false, insertable = false)
	private Member sailor;

	
	@ManyToOne
	@JoinColumn(name = "Id_SeaMission", referencedColumnName = "id_SeaMission", updatable = false, insertable = false)
	private Sea_Mission sea_Mission;

	private static final long serialVersionUID = 1L;

	public Mission_Sailor() {
		super();
	}

	public Mission_Sailor(Member sailor, Sea_Mission sea_Mission) {
		super();
		this.sailor = sailor;
		this.sea_Mission = sea_Mission;
		this.state = false; // false => default : mission has not yet started
		this.mission_SailorId = new Mission_SailorId(sailor.getId_Member(), sea_Mission.getId_SeaMission());

	}

	public Mission_SailorId getMission_SailorId() {
		return mission_SailorId;
	}

	public void setMission_SailorId(Mission_SailorId mission_SailorId) {
		this.mission_SailorId = mission_SailorId;
	}

	public Member getSailor() {
		return sailor;
	}

	public void setSailor(Member sailor) {
		this.sailor = sailor;
	}

	public Sea_Mission getSea_Mission() {
		return sea_Mission;
	}

	public void setSea_Mission(Sea_Mission sea_Mission) {
		this.sea_Mission = sea_Mission;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

}
