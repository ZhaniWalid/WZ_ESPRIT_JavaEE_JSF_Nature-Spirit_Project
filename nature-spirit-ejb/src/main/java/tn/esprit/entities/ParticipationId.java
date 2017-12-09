package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class ParticipationId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer Id_Member;
	private Integer Id_Event;
	private Date date_Event;

	public ParticipationId() {
		super();
	}

	public ParticipationId(Integer id_Member, Integer id_Event, Date date_Event) {
		super();
		Id_Member = id_Member;
		Id_Event = id_Event;
		this.date_Event = date_Event;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Event == null) ? 0 : Id_Event.hashCode());
		result = prime * result + ((Id_Member == null) ? 0 : Id_Member.hashCode());
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
		ParticipationId other = (ParticipationId) obj;
		if (Id_Event == null) {
			if (other.Id_Event != null)
				return false;
		} else if (!Id_Event.equals(other.Id_Event))
			return false;
		if (Id_Member == null) {
			if (other.Id_Member != null)
				return false;
		} else if (!Id_Member.equals(other.Id_Member))
			return false;
		return true;
	}

	public Integer getId_Member() {
		return Id_Member;
	}

	public void setId_Member(Integer id_Member) {
		Id_Member = id_Member;
	}

	public Integer getId_Event() {
		return Id_Event;
	}

	public void setId_Event(Integer id_Event) {
		Id_Event = id_Event;
	}

	public Date getDate_Event() {
		return this.date_Event;
	}

	public void setDate_Event(Date date_Event) {
		this.date_Event = date_Event;
	}
}
