package tn.esprit.services;

import javax.ejb.Local;

import tn.esprit.entities.Details;

@Local
public interface DetailsServicesLocal {

	// Services Of relation between Member & Product (*..*)

	// void AddProductToCartByIds(Integer Id_Member, Integer Id_Product);


	//double CalculateAndShowTotalAmmounts(Integer Id_Member); // la facture
	

	void PurshaseToDonate(Integer Id_Member, Integer Id_Product, Integer Quantity); // 10% of money will be redirected to Donation

	void purchaseJSF(Integer idMember, Integer idProduct, Integer quantity);
	
	Details findDetailsById(Integer id_details);
	
	// ***************************** méthodes qui buguent
	
	void AddProductToCart(Details details);
	
	double CalculateAndShowTotalAmmounts(Integer Id_Member, Integer Id_Product, Integer Quantityr); // la facture


}
