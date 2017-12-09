package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Admin;
import tn.esprit.entities.Product;

@Remote
public interface ProductServicesRemote {

	
	
	

	// **************************************************************************//
	
	// *************************** Partie Admin **********************************// 
	
	/////////////////////////// les méthodes qui marchent //////////////////////////
	
	Product findProductById(Integer Id_Product);
	
	void addProduct(Product product);
	
	void updateProduct(String newType,Double newPrice,int newAvailable,Product product,Admin admin);

	void AdminAddSingleProductToSellForDonation(Product product, Integer id_admin);

	void AdminAddListProductToSellForDonation(Product product, Integer id_admin);
	
    void AdminDeleteRelatedProduct(Integer id_admin,Integer id_product);
    
	void findAllAdminProducts(Admin admin);
	
	public List<Product> findAllAdminProducts2(Admin admin);

    /// méthode de consommation for DotNet
    
    public List<Product> getAllProductsForDotNet();
	
	///////////// les méthodes qui buguent ////////////////////////

	// Relation between Admin & Product (1..*)

	List<Product> ShowAllProductsToSellForDonation();
	
    void deleteProduct(Product product);
	
	void removeProduct(Product product);
	
	//void delete(Integer id_admin);

	void ParentChildRemoveProd(Product p,Admin a);

	void OrphanalProductAdminRemove(Integer id_admin);
    
    void AdminDeleteProd(Integer id_prod,Integer id_admin);

	void AdminDeleteProductFromSellForDonation(Product product, Integer id_admin);

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

}
