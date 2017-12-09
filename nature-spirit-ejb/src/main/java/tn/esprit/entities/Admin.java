package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@XmlRootElement
public class Admin implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Admin=1;
	    
	private String First_Name;  
	private String Last_Name;
	private Date Date_Birth;
	private String Email;
	private String Login;
	private String Password;
	private String Profile_Picture;
     
	
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Reclamation> reclamations;

	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Alert> alerts;

	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Member> members;

	
	@OneToMany(mappedBy = "admin", cascade = {CascadeType.ALL,CascadeType.REMOVE}, fetch = FetchType.EAGER , orphanRemoval=false) 
	private List<Product> products;
	
	public void removeProduct(Product product) {
		if(this.products!=null){
	        this.products.remove(product);
			product.setAdmin(null);;
		}   
	}
 
	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Sea_Mission> sea_missions;

	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Event> events;

	
	@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Photography_Competition> photography_competitions;

	private static final long serialVersionUID = 1L;

	public Admin() {
		super();
	}

	// les getters et les setters de les relations 1..* de l'admin

	public Admin(Integer id_Admin, String first_Name, String last_Name, Date date_Birth, String email, String login,String password, String profile_Picture) {
		super();
		this.id_Admin = id_Admin;
		First_Name = first_Name;
		Last_Name = last_Name;
		Date_Birth = date_Birth; 
		Email = email;
		Login = login;
		Password = password;
		Profile_Picture = profile_Picture;
	}

	public Integer getId_Admin() {
		return this.id_Admin;
	}

	public void setId_Admin(int id_Admin) {
		this.id_Admin = id_Admin;
	}

	public String getFirst_Name() {
		return this.First_Name;
	}

	public void setFirst_Name(String First_Name) {
		this.First_Name = First_Name;
	}

	public String getLast_Name() {
		return this.Last_Name;
	}

	public void setLast_Name(String Last_Name) {
		this.Last_Name = Last_Name;
	}

	public Date getDate_Birth() {
		return this.Date_Birth;
	}

	public void setDate_Birth(Date Date_Birth) {
		this.Date_Birth = Date_Birth;
	}

	public String getEmail() {
		return this.Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getLogin() {
		return this.Login;
	}

	public void setLogin(String Login) {
		this.Login = Login;
	}

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getProfile_Picture() {
		return this.Profile_Picture;
	}

	public void setProfile_Picture(String Profile_Picture) {
		this.Profile_Picture = Profile_Picture;
	}

	@XmlTransient
	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	@XmlTransient
	public List<Alert> getAlerts() {
		return alerts;
	}

	public void setAlerts(List<Alert> alerts) {
		this.alerts = alerts;
	}

	@XmlTransient
	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@XmlTransient
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@XmlTransient
	public List<Sea_Mission> getSea_missions() {
		return sea_missions;
	}

	public void setSea_missions(List<Sea_Mission> sea_missions) {
		this.sea_missions = sea_missions;
	}

	@XmlTransient
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@XmlTransient
	public List<Photography_Competition> getPhotography_competitions() {
		return photography_competitions;
	}

	public void setPhotography_competitions(List<Photography_Competition> photography_competitions) {
		this.photography_competitions = photography_competitions;
	}

	public void setId_Admin(Integer id_Admin) {
		this.id_Admin = id_Admin;
	}

	////

	public void linkProductsToThisAdmin(List<Product> products) {
		this.products = products;
		for (Product p : products) {
			p.setAdmin(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Date_Birth == null) ? 0 : Date_Birth.hashCode());
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Login == null) ? 0 : Login.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((id_Admin == null) ? 0 : id_Admin.hashCode());
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
		Admin other = (Admin) obj;
		if (Date_Birth == null) {
			if (other.Date_Birth != null)
				return false;
		} else if (!Date_Birth.equals(other.Date_Birth))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Login == null) {
			if (other.Login != null)
				return false;
		} else if (!Login.equals(other.Login))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (id_Admin == null) {
			if (other.id_Admin != null)
				return false;
		} else if (!id_Admin.equals(other.id_Admin))
			return false;
		return true;
	}
}
