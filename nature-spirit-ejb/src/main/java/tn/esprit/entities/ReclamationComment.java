package tn.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: ReclamationComment
 *
 */
@Entity
@XmlRootElement
public class ReclamationComment extends Reclamation implements Serializable {

	
	private Integer idReclamationComment;
	private String Comment;
	
	
	@OneToMany(mappedBy = "reclamationComment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments;
	
	private static final long serialVersionUID = 1L;

	public ReclamationComment() {
		super();
	}   
	public Integer getIdReclamationComment() {
		return this.idReclamationComment;
	}

	public void setIdReclamationComment(Integer idReclamationComment) {
		this.idReclamationComment = idReclamationComment;
	}   
	public String getComment() {
		return this.Comment;
	}

	public void setComment(String Comment) {
		this.Comment = Comment;
	}
	
	@XmlTransient
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
   
}
