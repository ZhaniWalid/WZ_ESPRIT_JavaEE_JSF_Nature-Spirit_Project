package tn.esprit.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.entities.Account;
import tn.esprit.entities.Member;
import tn.esprit.entities.Product;

@Local
public interface AccountMemberServicesLocal {
	
	// Service Of relation between Member & Account (1..*)
 

	// ***************************************************
	///  méthodes qui marchent
	
	    void addAccount(Account account);

	    void addAccountToMember(Account account,Integer id_member);
	    
		List<Account> findAllBanksAccountsMemberById(Member member);
		
		List<Account> findAllBanksAccountsMemberById2(Integer id_member);
		
		Account findAccountMemberById(Integer Id_ACCount);
		
		
		// ***************************************************
		///  méthodes qui buguent
		Account ViewMyAccountAmountById(Integer Id_Member);

}
