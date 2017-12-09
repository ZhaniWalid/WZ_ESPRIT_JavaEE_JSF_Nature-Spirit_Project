package tn.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.entities.Account;
import tn.esprit.entities.Member;

@Remote
public interface AccountMemberServicesRemote {
	
	// Service Of relation between Member & Account (1..*)

	///*************************************************
	// les méthodes qui marchent
	
        void addAccount(Account account);

	    void addAccountToMember(Account account,Integer id_member);
         
		Account ViewMyAccountAmountById(Integer Id_Member);

		List<Account> findAllBanksAccountsMemberById(Member member);
		
   /// *****************************************************
   // les méthodes qui buguent
		
		Account findAccountMemberById(Integer Id_ACCount);


}
