package tn.esprit.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.entities.Product;
import tn.esprit.services.ProductServicesLocal;

@Singleton
@LocalBean
@Startup
public class Util {

	@EJB
	private ProductServicesLocal productServicesLocal;
	
	public Util() {
		super();
		// TODO Auto-generated constructor stub
	}

	 @PostConstruct 
	 public void intiDB(){
		
		 Product p1 = new Product();	   
		   p1.setAvailability(0);
		   p1.setPrice(22.5);
		   p1.setType_Product("T-Shirt");
		 
		 Product p2 = new Product();
		   p2.setAvailability(1);
		   p2.setPrice(400.0);
		   p2.setType_Product("Smartphone");
		       
		 Product p3 = new Product();
		   p3.setAvailability(0);
		   p3.setPrice(1280.99);
		   p3.setType_Product("Laptop");

		 
	 }
}
