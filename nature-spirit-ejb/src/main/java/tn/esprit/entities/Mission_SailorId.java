package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Mission_SailorId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer Id_Member;
	private Integer Id_SeaMission;
	private Date start_Date;
	private Date end_Date;

	public Mission_SailorId() {
		super();
	}

	public Mission_SailorId(Integer Id_Member, Integer Id_SeaMission) {
		super();
		this.Id_Member = Id_Member;
		this.Id_SeaMission = Id_SeaMission;
		this.start_Date = new Date();
		this.end_Date = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Member == null) ? 0 : Id_Member.hashCode());
		result = prime * result + ((Id_SeaMission == null) ? 0 : Id_SeaMission.hashCode());
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
		Mission_SailorId other = (Mission_SailorId) obj;
		if (Id_Member == null) {
			if (other.Id_Member != null)
				return false;
		} else if (!Id_Member.equals(other.Id_Member))
			return false;
		if (Id_SeaMission == null) {
			if (other.Id_SeaMission != null)
				return false;
		} else if (!Id_SeaMission.equals(other.Id_SeaMission))
			return false;
		return true;
	}

	public Integer getId_Member() {
		return Id_Member;
	}

	public void setId_Member(Integer id_Member) {
		Id_Member = id_Member;
	}

	public Integer getId_SeaMission() {
		return Id_SeaMission;
	}

	public void setId_SeaMission(Integer id_SeaMission) {
		Id_SeaMission = id_SeaMission;
	}

	public Date getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(Date start_Date) {
		this.start_Date = start_Date;
	}

	public Date getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(Date end_Date) {
		this.end_Date = end_Date;
	}

}
