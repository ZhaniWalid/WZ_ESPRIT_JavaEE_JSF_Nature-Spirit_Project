package tn.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: ReclamationPicture
 *
 */
@Entity
@XmlRootElement
public class ReclamationPicture extends Reclamation implements Serializable {

	
	private Integer idReclamationPicture;
	private String Picture;
	
	
	@OneToMany(mappedBy = "reclamationPicture" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Photography_Competition> photographyCompetition;
	
	private static final long serialVersionUID = 1L;

	public ReclamationPicture() {
		super();
	}   
	public Integer getIdReclamationPicture() {
		return this.idReclamationPicture;
	}

	public void setIdReclamationPicture(Integer idReclamationPicture) {
		this.idReclamationPicture = idReclamationPicture;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	
	@XmlTransient 
	public List<Photography_Competition> getPhotographyCompetition() {
		return photographyCompetition;
	}
	public void setPhotographyCompetition(List<Photography_Competition> photographyCompetition) {
		this.photographyCompetition = photographyCompetition;
	}
	
	
	
   
}
