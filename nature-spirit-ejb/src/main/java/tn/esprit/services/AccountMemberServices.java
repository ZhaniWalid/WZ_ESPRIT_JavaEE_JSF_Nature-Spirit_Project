package tn.esprit.services;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.entities.Account;
import tn.esprit.entities.Admin;
import tn.esprit.entities.Member;
import tn.esprit.entities.Product;

/**
 * Session Bean implementation class AccountMemberServices
 */
@Stateless
@LocalBean
@WebService(
name="ServicesAccountMemberPortType",
portName="ServicesAccountMemberPort",
serviceName="ServicesAccountMember",
targetNamespace="http://ServicesAccountMember.com")
@Named("AccountMemberServices")
public class AccountMemberServices implements AccountMemberServicesRemote, AccountMemberServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private MemberServicesLocal memberServicesLocal;

	/**
	 * Default constructor.
	 */
	public AccountMemberServices() {
		// TODO Auto-generated constructor stub
	}

	//*********************************************************************
	// les méthodes qui marchent
	
	@WebResult(name="ResultAddAccountMember")
	@Override
	public void addAccount(Account account) {
		entityManager.merge(account);		
	}
	
	@WebResult(name="ResultAddAccountToMember")
	@Override
	public void addAccountToMember(Account account, Integer id_member) {
	
		// added for jsf ///
		Random rand = new Random(); 
		int  x = rand.nextInt(100);
		account.setRib_Number(x);
		// /. added for jsf //  
		Member foundMember = memberServicesLocal.findMemberById(id_member);
		List<Account> accountsOfmember = foundMember.getAccounts();
		accountsOfmember.add(account);
		foundMember.linkAccountsToThisMember(accountsOfmember);
         
		memberServicesLocal.updateMember(foundMember);		
	}
	 
	@WebResult(name="ResultFindAccountMemberById")
	@Override
	public Account findAccountMemberById(Integer Id_ACCount) {
		return entityManager.find(Account.class,Id_ACCount );
	}
        
	@WebResult(name="ResultFindAllBankAccountMemberById")
	@Override
	public List<Account> findAllBanksAccountsMemberById(Member member) {
		Member m = entityManager.find(Member.class, member.getId_Member());
		System.out.println("Liste de comptes bancaires du member num :'#"+m.getId_Member()+"' sont :\n");
		List<Account> listAccounts = m.getAccounts();
		for(Account a : listAccounts){
			System.out.println("Id Account :'#"+a.getId_Account()+"'\n");
			System.out.println("Number of RIB Account :"+a.getRib_Number()+"\n");
			System.out.println("Credit of Account :"+a.getCredit()+"\n");
			System.out.println("-----------------------------------------------------\n");
		}
		return listAccounts; 
	} 
	
	@Override
	public List<Account> findAllBanksAccountsMemberById2(Integer id_member) {
		Member m = entityManager.find(Member.class, id_member);
		System.out.println("Liste de comptes bancaires du member num :'#"+m.getId_Member()+"' sont :\n");
		List<Account> listAccounts = m.getAccounts();
		for(Account a : listAccounts){
			System.out.println("Id Account :'#"+a.getId_Account()+"'\n");
			System.out.println("Number of RIB Account :"+a.getRib_Number()+"\n");
			System.out.println("Credit of Account :"+a.getCredit()+"\n");
			System.out.println("-----------------------------------------------------\n");
		}
		return listAccounts; 
	}


   //************************************************************************
   // les méthodes qui buguent
	
	@Override
	public Account ViewMyAccountAmountById(Integer Id_Member) {
		return entityManager.find(Account.class, Id_Member);
	}

	
	

	


}
