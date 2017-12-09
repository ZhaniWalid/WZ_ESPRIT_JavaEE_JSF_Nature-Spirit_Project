package tn.esprit.entities;

import java.io.File;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: News
 *
 */
@Entity
@XmlRootElement
public class News implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idNews;
	private String description;
	private String picture;
	private File video=null;

	
	@ManyToOne
	private Topic topic;
	
	
	@ManyToOne
	private Admin admin;
	
	private static final long serialVersionUID = 1L;

	public News() {
		super();
	}   
	public Integer getIdNews() {
		return this.idNews;
	}

	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}   
	public File getVideo() {
		if(video==null){
			return null;
		}else{
			return this.video;
		}
	}

	public void setVideo(File video) {
		if(video==null){
			this.video=null;
		}else{
			this.video = video;
		}
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((idNews == null) ? 0 : idNews.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
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
		News other = (News) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (idNews == null) {
			if (other.idNews != null)
				return false;
		} else if (!idNews.equals(other.idNews))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		return true;
	}
	
	

   
}
