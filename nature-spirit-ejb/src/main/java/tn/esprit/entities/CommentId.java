package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class CommentId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer Id_Member;
	private Integer Id_Article;
	private Date Date_Of_Comment;

	public CommentId() {
		super();
	}

	public CommentId(Integer Id_Member, Integer Id_Article) {
		super();
		this.Id_Member = Id_Member;
		this.Id_Article = Id_Article;
		this.Date_Of_Comment = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id_Article == null) ? 0 : Id_Article.hashCode());
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
		CommentId other = (CommentId) obj;
		if (Id_Article == null) {
			if (other.Id_Article != null)
				return false;
		} else if (!Id_Article.equals(other.Id_Article))
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

	public Integer getId_Article() {
		return Id_Article;
	}

	public void setId_Article(Integer id_Article) {
		Id_Article = id_Article;
	}

	public Date getDate_Of_Comment() {
		return this.Date_Of_Comment;
	}

	public void setDate_Of_Comment(Date Date_Of_Comment) {
		this.Date_Of_Comment = Date_Of_Comment;
	}
}
