package tn.esprit.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Account;
import tn.esprit.entities.Details;
import tn.esprit.entities.Member;
import tn.esprit.entities.Product;

/**
 * Session Bean implementation class ProductPurchaseManagementServices
 */
@Stateless
@LocalBean
public class ProductPurchaseManagementServices implements ProductPurchaseManagementServicesRemote, ProductPurchaseManagementServicesLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private MemberServicesLocal memberServicesLocal;
	@EJB
	private ProductServicesLocal productServicesLocal;
	@EJB
	private AccountMemberServicesLocal accountMemberServicesLocal;
		
    public ProductPurchaseManagementServices() {
        // TODO Auto-generated constructor stub
    }

    
// **************************************************************************//
	
// *************************** Partie Member/Product (Details)  **********************************// 
 		
///////////////////////////// les méthodes qui marchent ////////////////////////
 	
	@Override
	public void MemberPurchaseProduct(Integer id_member, Integer id_product,Integer id_account, Integer Quantity, Double total_amount) {
         Member  member = memberServicesLocal.findMemberById(id_member);
         Product product = productServicesLocal.findProductById(id_product);
	
         Details detailsPurchase = new Details(Quantity, total_amount,member, product);
         if(member.getAccounts().isEmpty()){ 
        	System.out.println("Sorry Mr/Ms : "+member.getLast_Name()+" "+member.getFirst_Name()+"You Dont Have Any 'Bank Account' Yet To Proceed The Purchase,Please Try When You Have At Least One"); 
         }else{
        	 List<Account> my_accounts = member.getAccounts();
        	 member.linkAccountsToThisMember(my_accounts);
        	 Account  account= accountMemberServicesLocal.findAccountMemberById(id_account);
		  	 account.setMember(member);
        	 Double totalCredits = account.getCredit() ;
        	 totalCredits -= total_amount;
        	 if(totalCredits>total_amount){
        		 
        	 }
        		 
        	 
         }
         entityManager.merge(detailsPurchase);
	}

}
