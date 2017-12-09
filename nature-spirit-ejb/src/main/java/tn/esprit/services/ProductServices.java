package tn.esprit.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entities.Admin;
import tn.esprit.entities.Product;

/**
 * Session Bean implementation class ProductServices
 */
@Stateless
@LocalBean
@WebService(
name="ServicesProductPortType",
portName="ServicesProductPort",
serviceName="ServicesProduct",
targetNamespace="http://ServicesProduct.com")
@Named("ProductServices")
public class ProductServices implements ProductServicesRemote, ProductServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
	@PersistenceContext
	EntityManager session;
	@EJB
	AdminServicesLocal adminServicesLocal;
	@EJB
	MemberServicesLocal memberServicesLocal;
	@EJB
	ProductServicesLocal productServicesLocal;

	/**
	 * Default constructor.
	 */
	 
	public ProductServices() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// **************************************************************************//
	
	// *************************** Partie Admin **********************************// 
	
	///////////////////////////// les méthodes qui marchent ////////////////////////
	
	@WebResult(name="FindProductById")
	@Override
	public Product findProductById(Integer Id_Product) {
		return entityManager.find(Product.class, Id_Product);
	}

	//@WebMethod(operationName="AdminAddProduct")
	@WebResult(name="ResultAdminAddProduct")
	@Override
	public void AdminAddSingleProductToSellForDonation(@WebParam(name="product") Product product,@WebParam(name="id_admin") Integer id_admin) {
		Admin foundAdmin = adminServicesLocal.findAdminById(id_admin);
		product.setAdmin(foundAdmin); 
        if(product.getAvailability()==1){
        	product.setAvailability_String("Product Available");
        }else{
        	product.setAvailability_String("Product Not Available");
        }             
		addProduct(product);
	}

	//@WebMethod(operationName="adminFindAllProducts")
	@WebResult(name="ResultAdminAddResultProducts")
	@Override
	public void AdminAddListProductToSellForDonation(Product product, Integer id_admin) {
		Admin foundAdmin = adminServicesLocal.findAdminById(id_admin);
		List<Product> productsOfAdmin = foundAdmin.getProducts();
		productsOfAdmin.add(product);
		foundAdmin.linkProductsToThisAdmin(productsOfAdmin);

		adminServicesLocal.updateAdmin(foundAdmin);
	}
	
	@WebResult(name="ResultAddProduct")
	@Override
	public void addProduct(Product product) {
		entityManager.merge(product);
	}
	 
	
	//@WebMethod(operationName="adminUpdateProduct")
	@WebResult(name="ResultDisplayAdminAllProducts")
	@Override
	public void updateProduct(String newType,Double newPrice,int newAvailable,Product product,Admin admin) {
		/*Product productToBeUpdated = entityManager.find(Product.class, product.getId_Product());
		Query query = (Query) entityManager.merge(productToBeUpdated);
		int result = query.executeUpdate();*/
		 
		Query query2 = entityManager.createQuery("Update Product p set p.Type_Product=:new_type , p.Price=:new_price , p.Availability=:new_available where p.id_Product=:id_prod and p.admin.id_Admin=:id_admin ");
		query2.setParameter("new_type", newType);
		query2.setParameter("new_price", newPrice);
		query2.setParameter("new_available", newAvailable);
		query2.setParameter("id_prod", product.getId_Product());
		query2.setParameter("id_admin", admin.getId_Admin());
		 
		int result = query2.executeUpdate();
		if(result == 1){
			System.out.println("Update is executing ........... %");
			System.out.println("Update Has been Succeed of Product ID :"+product.getId_Product()+" , to :");
			System.out.println("Type Produit :"+product.getType_Product()+"\n");
			System.out.println("Prix Produit :"+product.getPrice()+"\n");
			System.out.println("Disponibilté Produit :"+product.getAvailability()+"\n");
			System.out.println("---------------------------------------------------------");
		}else{
			 System.out.println("Update has been failed");
			 System.out.println("---------------------------------------------------------");
		}		
	}
		
	
	@Override
	public void updateProductJSF(String newType, String newBrand, Double newPrice, int newQuantity, int newAvailable,Product product, Admin admin) {
		
		Query query2 = entityManager.createQuery("Update Product p set p.Type_Product=:new_type , p.Brand=:new_brand , p.Price=:new_price , p.Quantity_of_products=:new_quantity , p.Availability=:new_available where p.id_Product=:id_prod and p.admin.id_Admin=:id_admin ");
		query2.setParameter("new_type", newType);
		query2.setParameter("new_brand", newBrand);
		query2.setParameter("new_price", newPrice);   
		query2.setParameter("new_quantity", newQuantity);
		query2.setParameter("new_available", newAvailable);
		query2.setParameter("id_prod", product.getId_Product());
		query2.setParameter("id_admin", admin.getId_Admin());
		 
		int result = query2.executeUpdate();
		if(result == 1){
			System.out.println("Update is executing ........... %");
			System.out.println("Update Has been Succeed of Product ID :"+product.getId_Product()+" , to :");
			System.out.println("Type Produit :"+product.getType_Product()+"\n");
			System.out.println("Prix Produit :"+product.getPrice()+"\n");
			System.out.println("Disponibilté Produit :"+product.getAvailability()+"\n");
			System.out.println("---------------------------------------------------------");
		}else{
			 System.out.println("Update has been failed");
			 System.out.println("---------------------------------------------------------");
		}
		
	}

	
	
	//@WebMethod(operationName="adminDeleteProduct")
	@WebResult(name="ResultDeleteAdminProduct")
	@Override
	public void AdminDeleteRelatedProduct(Integer id_admin, Integer id_product) {

		Query query = entityManager.createQuery("Delete from Product P Where P.id_Product =:IdP");
		Query query2 = entityManager.createQuery("Delete from Admin A Where A.id_Admin =:IdA");
		query.setParameter("IdP", id_product);
		query2.setParameter("IdA", id_admin);
		int result = query.executeUpdate();
		int result2 = query2.executeUpdate();
		if (result == 1 && result2 == 1) {
			System.out.println("Requete Suppression du Produit d'ID'#"+id_product+"' a été éffectué avec succés");
		} else {
			System.out.println("Requete Suppression du Produit d'ID'#"+id_product+"' a été échoué");
		}
	}
	  
	@Override
	public void findAllAdminProducts(Admin admin) {
		
		Admin a = entityManager.find(Admin.class, admin.getId_Admin());
		System.out.println("Liste de produit de l'admin num :'#"+admin.getId_Admin()+"' sont :\n"+a.getProducts());
		List<Product> listProds = a.getProducts();
		for(Product p : listProds){
			System.out.println("Id Produit :'#"+p.getId_Product()+"'\n");
			System.out.println("Prix Produit :"+p.getPrice()+"\n");
			System.out.println("Disponibilté Produit :"+p.getAvailability()+"\n");
			System.out.println("Type Produit :"+p.getType_Product()+"\n");
			System.out.println("-----------------------------------------------------\n");
		}
		 
	}
	
	//@WebMethod(operationName="adminFindAllProducts")
	@WebResult(name="ResultDisplayAdminAllProducts")
	@Override
	public List<Product> findAllAdminProducts2(@WebParam(name="admin") Admin admin) {
		Admin a = entityManager.find(Admin.class, admin.getId_Admin());
		System.out.println("Liste de produit de l'admin num :'#"+admin.getId_Admin()+"' sont :\n"+a.getProducts());
		List<Product> listProds = a.getProducts();
		String availability; 
		for(Product p : listProds){
			System.out.println("Id Produit :'#"+p.getId_Product()+"'\n");
			System.out.println("Prix Produit :"+p.getPrice()+"\n");
			if(p.getAvailability()==1){
				availability="Product Available";
			}else{ 
				availability="Product Not Available";
			}
			System.out.println("Disponibilté Produit :"+availability+"\n");
			System.out.println("Type Produit :"+p.getType_Product()+"\n");
			System.out.println("-----------------------------------------------------\n");
		}
		return listProds; 
    }
	
	//méthde à consommer pour Asp dotNet
	@WebResult(name="ResultDisplayAllProductsForDotNet")
	@Override 
	public List<Product> getAllProductsForDotNet(){
		Admin admin = new Admin();
	    admin.setId_Admin(1);
	    Admin foundedAdmin =  entityManager.find(Admin.class, admin.getId_Admin()); 
		List<Product> listProducts = foundedAdmin.getProducts();        
		String availability; 
		 
		System.out.println("List of product to consume for ASP.Net :\n");
		
		for(Product p : listProducts){
			System.out.println("Id Produit :'#"+p.getId_Product()+"'\n");
			System.out.println("Prix Produit :"+p.getPrice()+"\n");
			if(p.getAvailability()==1){
				availability="Product Available";
			}else{ 
				availability="Product Not Available";
			}
			System.out.println("Disponibilté Produit :"+availability+"\n");
			System.out.println("Type Produit :"+p.getType_Product()+"\n");
			System.out.println("-----------------------------------------------------\n");
		}
		return listProducts; 

	}
	
	@Override
	public void add(Product product) {
		entityManager.persist(product);
		
	}
	  
	@Override   
	public void updateP(Product product) { 
		Product p = findProductById(product.getId_Product());
		Admin a = new Admin();
		a.setId_Admin(1);
		p.setAdmin(a); 
		entityManager.merge(p);		 
	}       
	    
	

	@Override
	public List<Product> SearchByType(String input_text) {
		
		Query query = entityManager.createQuery("SELECT p FROM Product p where p.Type_Product like:search or p.Brand like:search")
				.setParameter("search", "%" + input_text + "%");
		List<Product> ListProd = query.getResultList();
		return ListProd;   
		
	}
	
	//////////////////////////// les méthodes qui buguent ////////////////////////
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> ShowAllProductsToSellForDonation() {
		return (List<Product>) entityManager.find(Product.class, null);
	}

	
	@Override
	public void AdminUpdateProductToSellForDonation(Product product, Integer id_admin) {
		Admin foundadmin = adminServicesLocal.findAdminById(id_admin);
		product.setAdmin(foundadmin);

		//updateProduct(product);
	}
	// Admin & Product



	@Override
	public void AdminDeleteProductFromSellForDonation(Product product, Integer id_admin) {
		Admin foundAdmin = adminServicesLocal.findAdminById(id_admin);
		product.setAdmin(foundAdmin);
		//ParentChildRemoveProd(product, foundAdmin);
		// entityManager.merge(product);
		// entityManager.remove(product);
           
		 deleteProduct(product);
	//	 findAllAdminProducts(foundAdmin); 
		// foundAdmin.setId_Admin(id_admin);
		// updateProduct(product);
		// AdminDeleteRelatedProduct(id_admin, product.getId_Product());
		// deleteProduct(product.getId_Product());

	}

	
	/*
	 * public List<Product>
	 * AdminShowAllProductsToSellForDonationAddedByAdmin(Integer id_admin) {
	 * return (List<Product>) entityManager.find(Admin.class, id_admin); }
	 */

	// Member & Product

	@Override
	public void MemberAddSingleProductToBuyForDonation(Product product, Integer id_member) {
		/*
		 * Member foundMember = memberServicesLocal.findMemberById(id_member);
		 * product.setMember(foundMember);
		 * 
		 * updateProduct(product);
		 */
	}

	@Override
	public void MemberAddListProductToBuyForDonation(Product product, Integer id_member) {
		/*
		 * Member foundMember = memberServicesLocal.findMemberById(id_member);
		 * List<Product> productsOfMember = foundMember.getProducts();
		 * productsOfMember.add(product);
		 * foundMember.linkProductsToThisMember(productsOfMember);
		 * 
		 * memberServicesLocal.updateMember(foundMember);
		 */
	}

	@Override
	public void MemberDeleteProductFromBuyForDonation(Product product, Integer id_member) {
		// TODO Auto-generated method stub

	}

	@Override
	public void MemberUpdateProductToBuyForDonation(Product product, Integer id_member) {
		// TODO Auto-generated method stub

	}


	

	@Override
	public void deleteProduct(Product product) {
		// entityManager.remove(entityManager.contains(product) ? product :
		// entityManager.merge(product));
		/*
		 * Object managed=entityManager.merge(product);
		 * entityManager.remove(managed);
		 */

		Product productToBeRemoved = entityManager.find(Product.class, product.getId_Product());
		// productToBeRemoved.getAdmin().getProducts().remove(productToBeRemoved);
		entityManager.remove(entityManager.merge(productToBeRemoved));
		// entityManager.refresh(productToBeRemoved);
		// entityManager.close();
	}



	/*@SuppressWarnings("unchecked")
	@Override
	public List<Product> AdminShowAllProductsToSellForDonationAddedByAdmin(Integer id_admin) {
		Query query = session.createQuery("Select * from Product P ");
		Query query2 = session.createQuery("Select * from Admin A Where A.id_Admin =:IdA ");
		// query.setParameter("IdP", id_product);
		query2.setParameter("IdA", id_admin);
		// List Res1=query.getResultList();
		@SuppressWarnings("rawtypes")
		List Res2 = query2.getResultList();

		int result = query.executeUpdate();
		if (result == 1) {
			System.out.println("Requete Suppression a été éffectué avec succés");
			return Res2;
		} else {
			System.out.println("Requete Suppression a été échoué");
			return null;
		}
	}*/

	@Override
	public List<Product> ShowAllProductsToBuyForDonationAddedByMember(Integer id_member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AdminDeleteProd(Integer id_prod, Integer id_admin) {
		// Requete JPQL
		Admin Foundedadmin = adminServicesLocal.findAdminById(id_admin);
		// Product Foundedproduct =
		// productServicesLocal.findProductById(id_prod);
		Query query = entityManager.createQuery("Delete From Product p WHERE p.id_Product=:idP AND p.admin=:idA");
		query.setParameter("idP", id_prod);
		query.setParameter("idA", Foundedadmin);
		Foundedadmin.removeProduct(productServicesLocal.findProductById(id_prod));

		// Requete HQL
		/*
		 * Query query3 = session.createQuery(
		 * "Delete From Product WHERE id_Product=:IdP AND admin_id_Admin=:IdA");
		 * query3.setParameter("IdP", id_prod); query3.setParameter("IdA",
		 * id_admin);
		 */

		int result = query.executeUpdate();
		// int result = query3.executeUpdate();
		if (result == 1) {
			System.out.println("Requete Suppression a été éffectué avec succés");
		} else {
			System.out.println("Requete Suppression a été échoué");
		}
	}

	@Override  
	public void removeProduct(Product product) {
		entityManager.find(Product.class, product.getId_Product());
		entityManager.merge(product.getId_Product());
		entityManager.remove(product.getId_Product());
	}
   
	/*@Override
	public void delete(Integer id_admin) {
		Product prod = new Product();
		prod.setAdmin(entityManager.find(Admin.class, id_admin));
		entityManager.persist(prod);

		Admin admin = entityManager.find(Admin.class, id_admin);
		entityManager.persist(admin);

		entityManager.remove(prod);
 
	}*/

	@Override
	public void ParentChildRemoveProd(Product p, Admin a) {
		/*
		 * p = (Product) a.getProducts(); a.getProducts().remove(p);
		 * entityManager.remove(p);
		 */
		
		 a = entityManager.find(Admin.class,a.getId_Admin());
		 a.removeProduct(p); entityManager.merge(a); entityManager.merge(p);
		 

/*		Product productToBeRemoved = entityManager.find(Product.class, p.getId_Product());
		entityManager.remove(productToBeRemoved);*/
	}

	@Override
	public void OrphanalProductAdminRemove(Integer id_admin) {
		/*
		 * Admin admin = (Admin) entityManager.createQuery(
		 * "select a from Admin a join fetch a.products where a.id_Admin = :idA"
		 * ) .setParameter("idA", id_admin) .getSingleResult();
		 * 
		 * admin.removeProduct(admin.getProducts().get(0));
		 */
		/*
		 * entityManager.getTransaction().begin(); Admin admin =
		 * entityManager.find(Admin.class, id_admin);
		 * admin.getProducts().get(0).setAdmin(admin);
		 * admin.getProducts().clear(); entityManager.getTransaction().commit();
		 */

	}

	@SuppressWarnings("unchecked") 
	@Override
	public List<Product> findAllProductsByAdmin() {
		 Query query = entityManager.createQuery("select * from Product p");
		 query.getResultList();
         // query.setParameter("a",adminn);
          int res = query.executeUpdate();
          if(res==1){ 
       	   System.out.println("Affichage Liste Produits de l'Admin a été éffectué avec succés");
       	   return (List<Product>) query;
          }else{
       	    System.out.println("Affichage Liste Produits de l'Admin a été échoué");
       	    return null;
          }
	}



	@Override
	public Boolean updateProd(Product product) {
		          
		try {
			 if(product.getAvailability()==1){
		        	product.setAvailability_String("Product Available");
		        }else{
		        	product.setAvailability_String("Product Not Available");
		        } 
			entityManager.merge(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false; 
		}
		return true;
	}









	
	
	
}
