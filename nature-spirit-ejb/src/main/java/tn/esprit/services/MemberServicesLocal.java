package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Member;
import tn.esprit.entities.Product;

@Local
public interface MemberServicesLocal {

	void updateMember (Member member);
	 
	// Services Of Member Account & Authentification

	void SignUp(Member member); // s'inscrire

	void SingIn(String email, String pwd); // se connecter

	Member findMemberById(Integer Id_Member);

	// Services Of relation between Member & Product (*..*)

	 /// ************* méthodes qui buguent
	
	List<Product> ShowAllMyProductsInCartsById(Integer Id_Member);

}
