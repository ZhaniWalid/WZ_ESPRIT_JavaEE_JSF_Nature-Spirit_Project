package tn.esprit.entities;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: Product
 *
 */
@Entity
@XmlRootElement
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_Product;
	private String Type_Product;
	private Double Price;
	private int Availability;
	////
    private int Quantity_of_products;
    private String Brand; // marque
    //private Date date_prod;
    private String Availability_String;
	
   
            
	@ManyToOne(cascade={CascadeType.ALL},targetEntity=Admin.class)
	@JoinColumn(name = "id_admin_fk", referencedColumnName = "id_Admin")
	private Admin admin;
	
	/* 
	 * private Member member;
	 */
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Details> details;

	private static final long serialVersionUID = 1L;

	public Product() {
		super();
	}

	public Product(String type_Product, Double price, int availability) {
		super();
		Type_Product = type_Product;
		Price = price;
		Availability = availability;
	}
	
	
	public Product(Integer id_Product, String type_Product, Double price, int availability) {
		super();
		this.id_Product = id_Product;
		Type_Product = type_Product;
		Price = price;
		Availability = availability;
	}

	
	public Product(Integer id_Product, String type_Product, Double price, int availability, int quantity_of_products,String brand) {
		super();
		this.id_Product = id_Product;
		Type_Product = type_Product;
		Price = price;
		Availability = availability;
		Quantity_of_products = quantity_of_products;
		Brand = brand;
	}

	public Integer getId_Product() {
		return id_Product;
	}

	public void setId_Product(Integer id_Product) {
		this.id_Product = id_Product;
	}

	public String getType_Product() {
		return this.Type_Product;
	}

	public void setType_Product(String Type_Product) {
		this.Type_Product = Type_Product;
	}

	public Double getPrice() {
		return this.Price;
	}

	public void setPrice(Double Price) {
		this.Price = Price;
	}

	public int getAvailability() {
		return this.Availability;
	}

	public void setAvailability(int Availability) {               
		this.Availability = Availability;
	}
	
	//
	
	public int getQuantity_of_products() {
		return Quantity_of_products;
	}

	public void setQuantity_of_products(int quantity_of_products) {
		Quantity_of_products = quantity_of_products;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}   	
	
	//
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@XmlTransient 
	public List<Details> getDetails() {
		return details;
	}

	public void setDetails(List<Details> details) {
		this.details = details;
	}

	public String getAvailability_String() {
		      
		if(this.Availability==1){
			Availability_String = "Product Available";
		}else{    
			Availability_String = "Product Not Available";
		} 
		return Availability_String;
	}
       
	public void setAvailability_String(String availability_String) {
		
		if(this.Availability==1){
			availability_String = "Product Available";
		}else{             
			availability_String = "Product Not Available";
		}  
		
		this.Availability_String=availability_String;
	}              

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Availability;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((id_Product == null) ? 0 : id_Product.hashCode());
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
		Product other = (Product) obj;
		if (Availability != other.Availability)
			return false;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (id_Product == null) {
			if (other.id_Product != null)
				return false;
		} else if (!id_Product.equals(other.id_Product))
			return false;
		return true;
	}

	/*
	 * public Member getMember() { return member; }
	 * 
	 * public void setMember(Member member) { this.member = member; }
	 */
	

}
