package tn.esprit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: ReclamationMember
 *
 */
@Entity
@XmlRootElement
public class ReclamationMember extends Reclamation implements Serializable {

	private Integer idReclamtionMember;
	private String First_Name;
	private String Last_Name;

	
	@OneToMany(mappedBy = "reclamationMember" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Member> members;

	private static final long serialVersionUID = 1L;

	public ReclamationMember() {
		super();
	}

	public Integer getIdReclamtionMember() {
		return this.idReclamtionMember;
	}

	public void setIdReclamtionMember(Integer idReclamtionMember) {
		this.idReclamtionMember = idReclamtionMember;
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

	@XmlTransient 
	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}
