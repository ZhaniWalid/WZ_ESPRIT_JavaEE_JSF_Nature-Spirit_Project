package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Admin;
import tn.esprit.entities.Product;

@Local
public interface ProductServicesLocal {
	
	
	
	// **************************************************************************//
	
	// *************************** Partie Admin **********************************// 
	
	/////////////////////// les méthodes qui marchent ///////////////////////////
	
	Product findProductById(Integer Id_Product);

	void addProduct(Product product);
	void add(Product product);
    
	void updateProduct(String newType,Double newPrice,int newAvailable,Product product,Admin admin);
	
	void updateProductJSF(String newType,String newBrand,Double newPrice,int newQuantity,int newAvailable,Product product,Admin admin);
	
	void updateP(Product product);
	
	Boolean updateProd(Product product);
	
	void AdminAddSingleProductToSellForDonation(Product product, Integer id_admin);

	void AdminAddListProductToSellForDonation(Product product, Integer id_admin);
	
	void findAllAdminProducts(Admin admin);
	
	public List<Product> findAllAdminProducts2(Admin admin);
	
    void AdminDeleteRelatedProduct(Integer id_admin,Integer id_product);
        
    public List<Product> SearchByType(String input_text);
    
    /// méthode de consommation for DotNet
    
    public List<Product> getAllProductsForDotNet();
	
	///////////// les méthodes qui buguent ////////////////////////


	List<Product> ShowAllProductsToSellForDonation();

	
	
	void removeProduct(Product product);
	
	void deleteProduct(Product product);
	
	void AdminDeleteProductFromSellForDonation(Product product, Integer id_admin);

  
	//void delete(Integer id_admin);
	
	void ParentChildRemoveProd(Product p,Admin a);

	void OrphanalProductAdminRemove(Integer id_admin);
	
	// Relation between Admin & Product (1..*)

	

    
    void AdminDeleteProd(Integer id_prod,Integer id_admin);
	

	void AdminUpdateProductToSellForDonation(Product product, Integer id_admin);

	List<Product> findAllProductsByAdmin();
	
	
	// **************************************************************************//
	
	// *************************** Partie Member *********************************//
	
	// Relation between Member & Product (1..*)

	void MemberAddSingleProductToBuyForDonation(Product product, Integer id_member);

	void MemberAddListProductToBuyForDonation(Product product, Integer id_member);

	void MemberDeleteProductFromBuyForDonation(Product product, Integer id_member);

	void MemberUpdateProductToBuyForDonation(Product product, Integer id_member);

	List<Product> ShowAllProductsToBuyForDonationAddedByMember(Integer id_member);
	
	

	/*
	 * void AddProductToSellForDonation(Admin admin, Product product);
	 * 
	 * void DeleteProductFromSellForDonation(Admin admin, Product product);
	 * 
	 * void UpdateProductToSellForDonation(Admin admin, Product product);
	 */

}
