package tn.esprit.services;

import javax.ejb.Remote;

import tn.esprit.entities.Details;

@Remote
public interface DetailsServicesRemote {

	// Services Of relation between Member & Product (*..*)



 /// ** méthodes qui marchent

	void PurshaseToDonate(Integer Id_Member, Integer Id_Product,Integer Quantity); // 10% of total amounts will be redirected to donation

	Details findDetailsById(Integer id_details);
	
	// ***************************** méthodes qui buguent

	void AddProductToCart(Details details);

	double CalculateAndShowTotalAmmounts(Integer Id_Member, Integer Id_Product, Integer Quantityr); 

}
