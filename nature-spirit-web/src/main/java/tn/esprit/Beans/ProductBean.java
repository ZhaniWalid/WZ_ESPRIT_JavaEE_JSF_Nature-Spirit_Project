package tn.esprit.Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Admin;
import tn.esprit.entities.Product;
import tn.esprit.services.AdminServicesLocal;
import tn.esprit.services.ProductServicesLocal;

@ManagedBean
@ViewScoped
public class ProductBean {

	@EJB
	ProductServicesLocal productServicesLocal;
	@EJB
	AdminServicesLocal adminServicesLocal;
	private Product product = new Product();
	private Product selectedProduct = new Product();
	private List<Product> list_prod;
	private int availability; 
	private String availability_string;
	private Double price;
	private String type_prod;
	private String brand;
	private int quantity;
	boolean test=false;
	private String products_search;
	private List<Product> ListProductSearch;

	public ProductBean() {
		super();
	}
	  	
	public ProductBean(Product product, Product selectedProduct, List<Product> list_prod, int availability,String availability_string, Double price, String type_prod) {
		super();
		this.product = product;
		this.selectedProduct = selectedProduct;
		this.list_prod = list_prod;
		this.availability = availability;
		this.availability_string = availability_string;
		this.price = price;
		this.type_prod = type_prod;
	} 
	
	public ProductBean(int availability, Double price, String type_prod, String brand, int quantity) {
		super();
		this.availability = availability;
		this.price = price;
		this.type_prod = type_prod;
		this.brand = brand;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Product> getList_prod() {
		return list_prod;
	}
	public void setList_prod(List<Product> list_prod) {
		this.list_prod = list_prod;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public String getAvailability_string() {
		return availability_string;
	}
	public void setAvailability_string(String availability_string) {
		this.availability_string = availability_string;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getType_prod() { 
		return type_prod;
	}
	public void setType_prod(String type_prod) {
		this.type_prod = type_prod;
	}    
	
	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProducts_search() {
		return products_search;
	}

	public void setProducts_search(String products_search) {
		this.products_search = products_search;
	}

	public List<Product> getListProductSearch() {
		return ListProductSearch;
	}

	public void setListProductSearch(List<Product> listProductSearch) {
		ListProductSearch = listProductSearch;
	}

	@PostConstruct
	public void initProd()
	{   
		product = new Product();  
		selectedProduct = new Product(); 
		list_prod = productServicesLocal.getAllProductsForDotNet();
		test=false;
	}
	    

	public void ajouter(){ 
		Admin a = new Admin();
		a= adminServicesLocal.findAdminById(1);
		product.setAdmin(a);
		System.out.println("azezarzarzarzarza");
		productServicesLocal.add(product);
	}
	public Boolean ShowPanel(Product prod){
		selectedProduct = prod;
		return true;
	} 
	public void deleteP(){
		Admin a = new Admin();
		a= adminServicesLocal.findAdminById(1);
		product.setAdmin(a);
		productServicesLocal.deleteProduct(product);
		initProd();
	}
	
	//partie admin 
	  
	public void AddProduct(){
		productServicesLocal.AdminAddSingleProductToSellForDonation(product,1);
		initProd(); 
	}                 
 	                       
	public void DeleteProduct(Product product){  
		productServicesLocal.AdminDeleteRelatedProduct(1,product.getId_Product());
		initProd();
	               
	}    
	        
	// edit table             
                   
	public void updateProduct(Product selectedProduct){  
	     	Admin a = new Admin();   
	    	a.setId_Admin(1);   
	    	Product foundedProduct = productServicesLocal.findProductById(selectedProduct.getId_Product());
	    	foundedProduct.setAdmin(a);     
	    	foundedProduct.setId_Product(1); 
	    	foundedProduct.setType_Product(selectedProduct.getType_Product());
	    	foundedProduct.setBrand(selectedProduct.getBrand());
	    	foundedProduct.setPrice(selectedProduct.getPrice());
	    	foundedProduct.setQuantity_of_products(selectedProduct.getQuantity_of_products());
	    	foundedProduct.setAvailability(selectedProduct.getAvailability());
		    productServicesLocal.updateP(foundedProduct);                         
		    initProd();    
	}               
	 
	public String initialiser(){
		test=true; 
		return null; 
		
	}
	
	public String updateProd(){
		productServicesLocal.updateProd(product);
		initProd();  
		return null; 
	}
	
	public List<Product> SearchByInputText(){

		list_prod=productServicesLocal.SearchByType(products_search);
		return ListProductSearch;
		  
		}
	
}
