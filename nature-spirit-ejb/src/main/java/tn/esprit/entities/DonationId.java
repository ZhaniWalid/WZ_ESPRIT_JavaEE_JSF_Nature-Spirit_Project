package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DonationId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idMember;
	private Integer idEvent;

	public DonationId() {
		// TODO Auto-generated constructor stub
	}

	public DonationId(Integer idMember, Integer idEvent) {
		super();
		this.idMember = idMember;
		this.idEvent = idEvent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEvent == null) ? 0 : idEvent.hashCode());
		result = prime * result + ((idMember == null) ? 0 : idMember.hashCode());
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
		DonationId other = (DonationId) obj;
		if (idEvent == null) {
			if (other.idEvent != null)
				return false;
		} else if (!idEvent.equals(other.idEvent))
			return false;
		if (idMember == null) {
			if (other.idMember != null)
				return false;
		} else if (!idMember.equals(other.idMember))
			return false;
		return true;
	}

	public Integer getIdMember() {
		return idMember;
	}

	public void setIdMember(Integer idMember) {
		this.idMember = idMember;
	}

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

}
