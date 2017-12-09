package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Member
 *
 */
@Entity
@XmlRootElement
public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Member;
 
	private String First_Name;
	private String Last_Name;
	private Date Date_Birth;
	private String Email;
	private String Password;
	private String Profil_Picture;
	private String Role;
	private Float balance;

	
	@ManyToOne
	private Newsletter newsletter;
	
	
	@ManyToOne
	private ReclamationMember reclamationMember;

	//
	// @ManyToMany 
	// private List<Product> products;
	//

	public ReclamationMember getReclamationMember() {
		return reclamationMember;
	}

	public void setReclamationMember(ReclamationMember reclamationMember) {
		this.reclamationMember = reclamationMember;
	}

	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Account> accounts;

	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Reclamation> reclamations;

	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Alert> alerts;

	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DonationTheory> donationTheories;

	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Photography_Competition> photoCompetitions;

	
	@OneToMany(mappedBy = "journalist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Photography_Competition> photoCompetition_journalists;

	
	@ManyToOne
	private Admin admin;

	// les relations de journalists

	
	@OneToMany(mappedBy = "journalist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Article> articles;

	// les relations de classe d'association

	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Details> details;

	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Agenda> agendas;

	
	@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments;

	
	@OneToMany(mappedBy = "sailor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Mission_Sailor> mission_sailors;

	private static final long serialVersionUID = 1L;

	public Member() {
		super();
	}

	
	public Member(Integer id_Member, String first_Name, String last_Name, Date date_Birth, String email,String password, String profil_Picture, String role, Float balance) {
		super();
		this.id_Member = id_Member;
		First_Name = first_Name;
		Last_Name = last_Name;
		Date_Birth = date_Birth;
		Email = email;
		Password = password;
		Profil_Picture = profil_Picture;
		Role = role;
		this.balance = 300F;
	}


	public Integer getId_Member() {
		return id_Member;
	}

	public void setId_Member(Integer id_Member) {
		this.id_Member = id_Member;
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

	public String getPassword() {
		return this.Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getProfil_Picture() {
		return this.Profil_Picture;
	}

	public void setProfil_Picture(String Profil_Picture) {
		this.Profil_Picture = Profil_Picture;
	}

	public String getRole() {
		return this.Role;
	}

	public void setRole(String Role) {
		this.Role = Role;
	}
	
	public Float getBalance() {
		return balance;
	}

	public void setBalance(Float balance) {
		this.balance = balance;
	}

	@XmlTransient
	public List<DonationTheory> getDonationTheories() {
		return donationTheories;
	}

	public void setDonationTheories(List<DonationTheory> donationTheories) {
		this.donationTheories = donationTheories;
	}
	
	

	/*
	 * public List<Product> getProducts() { return products; }
	 * 
	 * public void setProducts(List<Product> products) { this.products =
	 * products; }
	 */

	////////////////////////////////////


	public Admin getAdmin() {
		return admin;
	}
        
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Newsletter getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(Newsletter newsletter) {
		this.newsletter = newsletter;
	}

	/////////////////////////////////////////

	@XmlTransient
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
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
	public List<DonationTheory> getDonations() {
		return donationTheories;
	}

	public void setDonations(List<DonationTheory> donationTheories) {
		this.donationTheories = donationTheories;
	}

	@XmlTransient
	public List<Photography_Competition> getPhotoCompetitions() {
		return photoCompetitions;
	}

	public void setPhotoCompetitions(List<Photography_Competition> photoCompetitions) {
		this.photoCompetitions = photoCompetitions;
	}

	@XmlTransient
	public List<Photography_Competition> getPhotoCompetition_journalists() {
		return photoCompetition_journalists;
	}

	public void setPhotoCompetition_journalists(List<Photography_Competition> photoCompetition_journalists) {
		this.photoCompetition_journalists = photoCompetition_journalists;
	}

	@XmlTransient
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@XmlTransient
	public List<Details> getDetails() {
		return details;
	}

	public void setDetails(List<Details> details) {
		this.details = details;

	}

	@XmlTransient
	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	@XmlTransient
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@XmlTransient
	public List<Mission_Sailor> getMission_sailors() {
		return mission_sailors;
	}

	public void setMission_sailors(List<Mission_Sailor> mission_sailors) {
		this.mission_sailors = mission_sailors;
	}
	
	public void linkAccountsToThisMember(List<Account> accounts) {
		this.accounts = accounts;
		for (Account a : accounts) {
			a.setMember(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		result = prime * result + ((id_Member == null) ? 0 : id_Member.hashCode());
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
		Member other = (Member) obj;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		if (id_Member == null) {
			if (other.id_Member != null)
				return false;
		} else if (!id_Member.equals(other.id_Member))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [id_Member=" + id_Member + ", First_Name=" + First_Name + ", Last_Name=" + Last_Name
				+ ", Date_Birth=" + Date_Birth + ", Email=" + Email + ", Password=" + Password + ", Profil_Picture="
				+ Profil_Picture + ", Role=" + Role + ", balance=" + balance + "]";
	}

	
	 
	//

	/*
	 * public void linkProductsToThisMember(List<Product> products) {
	 * this.products = products; for (Product p : products) { p.setMember(this);
	 * } }
	 */
}
