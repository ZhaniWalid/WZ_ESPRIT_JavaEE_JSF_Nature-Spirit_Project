package tn.esprit.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Topic
 *
 */
@Entity
@XmlRootElement
public class Topic implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTopic;
	private String title;
	private String typeTopic;
	private String description;
	
	
	@ManyToOne
	private Admin admin;
	
	
	@OneToMany(mappedBy = "topic")
	private List<News> newss;
	
	private static final long serialVersionUID = 1L;

	public Topic() {
		super();
	}   
	public Integer getIdTopic() {
		return this.idTopic;
	}

	public void setIdTopic(Integer idTopic) {
		this.idTopic = idTopic;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getTypeTopic() {
		return this.typeTopic;
	}

	public void setTypeTopic(String typeTopic) {
		this.typeTopic = typeTopic;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	@XmlTransient  
	public List<News> getNewss() {
		return newss;
	}
	public void setNewss(List<News> newss) {
		this.newss = newss;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((idTopic == null) ? 0 : idTopic.hashCode());
		result = prime * result + ((typeTopic == null) ? 0 : typeTopic.hashCode());
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
		Topic other = (Topic) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (idTopic == null) {
			if (other.idTopic != null)
				return false;
		} else if (!idTopic.equals(other.idTopic))
			return false;
		if (typeTopic == null) {
			if (other.typeTopic != null)
				return false;
		} else if (!typeTopic.equals(other.typeTopic))
			return false;
		return true;
	}
	
	
   
}
