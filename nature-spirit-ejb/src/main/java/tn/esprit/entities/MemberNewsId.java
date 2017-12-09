package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class MemberNewsId implements Serializable{


	private static final long serialVersionUID = 1L;
	private Integer Id_Member;
	private Integer Id_News;
	private Date date_Of_Comment;
	
	public MemberNewsId() {
		super();
	}

	public MemberNewsId(Integer id_Member, Integer id_News) {
		super();
		Id_Member = id_Member;
		Id_News = id_News;
		this.date_Of_Comment = new Date();
	}

	public Integer getId_Member() {
		return Id_Member;
	}

	public void setId_Member(Integer id_Member) {
		Id_Member = id_Member;
	}

	public Integer getId_News() {
		return Id_News;
	}

	public void setId_News(Integer id_News) {
		Id_News = id_News;
	}

	public Date getDate_Of_Comment() {
		return date_Of_Comment;
	}

	public void setDate_Of_Comment(Date date_Of_Comment) {
		this.date_Of_Comment = date_Of_Comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Member == null) ? 0 : Id_Member.hashCode());
		result = prime * result + ((Id_News == null) ? 0 : Id_News.hashCode());
		result = prime * result + ((date_Of_Comment == null) ? 0 : date_Of_Comment.hashCode());
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
		MemberNewsId other = (MemberNewsId) obj;
		if (Id_Member == null) {
			if (other.Id_Member != null)
				return false;
		} else if (!Id_Member.equals(other.Id_Member))
			return false;
		if (Id_News == null) {
			if (other.Id_News != null)
				return false;
		} else if (!Id_News.equals(other.Id_News))
			return false;
		if (date_Of_Comment == null) {
			if (other.date_Of_Comment != null)
				return false;
		} else if (!date_Of_Comment.equals(other.date_Of_Comment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberNewsId [Id_Member=" + Id_Member + ", Id_News=" + Id_News + ", date_Of_Comment=" + date_Of_Comment
				+ "]";
	}
	
	
	
	
	
	

}
