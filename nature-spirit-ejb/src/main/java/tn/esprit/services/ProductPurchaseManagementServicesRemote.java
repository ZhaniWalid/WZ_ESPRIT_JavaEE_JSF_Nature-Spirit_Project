package tn.esprit.services;

import javax.ejb.Remote;

@Remote
public interface ProductPurchaseManagementServicesRemote {

	// **************************************************************************//
	
			// *************************** Partie Member/Product (Details)  **********************************// 
			
			///////////////////////////// les méthodes qui marchent ////////////////////////
		
		void MemberPurchaseProduct(Integer id_member,Integer id_product,Integer id_account,Integer Quantity,Double total_amount);
	
}
