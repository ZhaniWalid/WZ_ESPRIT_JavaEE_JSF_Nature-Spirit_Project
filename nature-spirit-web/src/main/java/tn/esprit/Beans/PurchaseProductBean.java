package tn.esprit.Beans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedProperty;

import tn.esprit.entities.Details;
import tn.esprit.entities.DonationTheory;
import tn.esprit.entities.Product;
import tn.esprit.services.AccountMemberServicesLocal;
import tn.esprit.services.DetailsServicesLocal;
import tn.esprit.services.MemberServicesLocal;
import tn.esprit.services.ProductServicesLocal;

@ManagedBean
@ViewScoped
public class PurchaseProductBean {

	@EJB
	private MemberServicesLocal memberServiceLocal;
	@EJB
	private ProductServicesLocal productServiceLocal;
	@EJB
	AccountMemberServicesLocal accountMemberServicesLocal;
    @EJB
    DetailsServicesLocal detailsServicesLocal;
	@ManagedProperty(value = "#{caddyBean}")
	private CaddyBean caddyBean;
    
	private List<Product> list_prod;
    private Details details = new Details();
    private DonationTheory donationTheory = new DonationTheory();
    private Product product = null;
	boolean test=false;
	private String products_search;
	private List<Product> ListProductSearch;
	private Integer quantity;
    
	
	
	public PurchaseProductBean() {
		super();
	}


	public List<Product> getList_prod() {
		return list_prod;
	}


	public void setList_prod(List<Product> list_prod) {
		this.list_prod = list_prod;
	}


	public Details getDetails() {
		return details;
	}


	public void setDetails(Details details) {
		this.details = details;
	}


	public DonationTheory getDonationTheory() {
		return donationTheory;
	}


	public void setDonationTheory(DonationTheory donationTheory) {
		this.donationTheory = donationTheory;
	}


	public boolean isTest() {
		return test;
	}


	public void setTest(boolean test) {
		this.test = test;
	}
    

	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
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


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public CaddyBean getCaddyBean() {
		return caddyBean;
	}
    

	public void setCaddyBean(CaddyBean caddyBean) {
		this.caddyBean = caddyBean;
	}


	@PostConstruct
	public void initProd()
	{   
		product = new Product();  
		details = new Details();
		donationTheory = new DonationTheory();
		list_prod = productServiceLocal.getAllProductsForDotNet();
		test=false;
	}
	 
	public String initialiser(){
		test=true; 
		return null; 
		
	}
	
	
	public List<Product> SearchByInputText(){
  
		list_prod=productServiceLocal.SearchByType(products_search);
		return ListProductSearch;
		    
	}
	 
	public void Purchase(int Quantity){
		detailsServicesLocal.PurshaseToDonate(AccountMemberBean.id_member, product.getId_Product(), Quantity);
		initProd();       
	}
	
	public String addToCaddy() {
		Map<Product, Integer> map = caddyBean.getMap();
		map.put(product, quantity);
		caddyBean.setMap(map);
		return null;
	}  

	/*public String doPurchase(Product product) {
      
		Map<Product, Integer> map = caddyBean.getMap();
		map.put(product, quantity);
		caddyBean.setMap(map);
		    
		for (Product p : map.keySet()) {
			detailsServicesLocal.purchaseJSF(AccountMemberBean.id_member, p.getId_Product(), map.get(p));
		}
  
		return null;       
	} */ 
	         
	public String doPurchase(Product product,int q) {
	   	      
		    Product p = productServiceLocal.findProductById(product.getId_Product()); 
			detailsServicesLocal.purchaseJSF(AccountMemberBean.id_member, p.getId_Product(),q);
		
		return null;       
	}     


}
