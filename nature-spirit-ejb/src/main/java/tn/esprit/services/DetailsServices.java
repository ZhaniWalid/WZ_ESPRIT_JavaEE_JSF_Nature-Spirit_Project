package tn.esprit.services;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Account;
import tn.esprit.entities.Details;
import tn.esprit.entities.DonationTheory;
import tn.esprit.entities.Member;
import tn.esprit.entities.Product;

/**
 * Session Bean implementation class DetailsServices
 */
@Stateless
@LocalBean
@WebService(
name="ServicesDetailsrPortType",
portName="ServicesDetailsPort",
serviceName="ServicesDetails",
targetNamespace="http://ServicesDetails.com")
@Named("DetailsServices")
public class DetailsServices implements DetailsServicesRemote, DetailsServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
	@EJB
	private MemberServicesLocal memberServiceLocal;
	@EJB
	private ProductServicesLocal productServiceLocal;
	@EJB
	AccountMemberServicesLocal accountMemberServicesLocal;

	/**
	 * Default constructor.
	 */
	public DetailsServices() {
		// TODO Auto-generated constructor stub
	}

	
	// **************************************************
	/// Méthodes qui marchent
	
	
	@WebResult(name="ResultPurshaseToDonate")
	@Override
	public void PurshaseToDonate(Integer Id_Member, Integer Id_Product, Integer Quantity) {

		Member member = memberServiceLocal.findMemberById(Id_Member);
		Product product = productServiceLocal.findProductById(Id_Product);
		
		//Account account = accountMemberServicesLocal.findAccountMemberById(member.getAccou);
		//account.setMember(member);
	 	   
		//Details details = this;
		
		List<Account> listAccountsOfMember = member.getAccounts();
		member.setAccounts(listAccountsOfMember);
		for (Account a : listAccountsOfMember){	
			  if(product.getAvailability()==1){
					System.out.println("le Produit d'ID '#"+product.getId_Product()+"' , de type '"+product.getType_Product()+"' ,de prix : '"+product.getPrice()+" , est #'Disponible'# ");
 	                
					Double total_Buy_Ammounts = product.getPrice() * Quantity;
					if(a.getCredit() > total_Buy_Ammounts){
						
					//details.setTotal_amount(0.0);
				    System.out.println("Félicitation :) :D Mr/Mme : '"+member.getLast_Name()+" "+member.getFirst_Name()+"'  votre Achat a été accomplie avec #'succés'# ");
					System.out.println("ID Produit acheté : '"+product.getId_Product()+"\n");
					System.out.println("Type :"+product.getType_Product()+"\n");
					System.out.println("Availability :"+product.getAvailability()+"\n");
					System.out.println("Quantité du produit acheté :"+Quantity);     
					System.out.println("Frais total du reçu des produit acheté est :"+total_Buy_Ammounts+" Dinars");      
					System.out.println("Credit Before the Buy :"+a.getCredit());
					Details details = new Details(Quantity, member, product);
					details.setTotal_amount(product.getPrice() * Quantity);
					details.setState(true);
					entityManager.merge(details);
					
					// déduction of credit after buying a product
					Double total_credit_after_buy = a.getCredit() - total_Buy_Ammounts;
					a.setCredit(total_credit_after_buy);
					entityManager.merge(a);
					System.out.println("Credit After the Buy :"+total_credit_after_buy);
					System.out.println("--------------------------------------------------\n");
					// 10 % of donation after buying a product 
					Double Total_Deduced_Percentage_Ammount_To_Donation = 0.0;   
					Total_Deduced_Percentage_Ammount_To_Donation +=(total_Buy_Ammounts*10)/100;
					Date date_of_donation = new Date();
					DonationTheory donationTheory = new DonationTheory(); 
					donationTheory.setId_Donation_Theory(1);  
					donationTheory.setAmount_of_money(Total_Deduced_Percentage_Ammount_To_Donation);
					donationTheory.setDate_of_transfert(date_of_donation);
					donationTheory.setMember(member);  
					entityManager.merge(donationTheory); 
					System.out.println("Thanks For Buying Our Product , we have deduced 10% of total amount your products who you have been buy to be donated for the nautre :) "); 
				      	    
					}else{  
					System.out.println("Désolé Mr/Mme :"+member.getLast_Name()+" "+member.getFirst_Name()+" , vous ne pouvez pas poursuivre l'achat car votre solde est insuffisant");
					}
				}else{  
					System.out.println("le Produit d'ID '#"+product.getId_Product()+"' , de type '"+product.getType_Product()+"' , est #'Indisponible'# ");
					System.out.println("Désolé :( :/ Mr/Mme : '"+member.getLast_Name()+" "+member.getFirst_Name()+"'  votre Achat a été #'échoué'# ");
				} 		
		}
	 	  
	}

	@WebResult(name="ResultFindDetailsById")
	@Override
	public Details findDetailsById(Integer id_details) {
		return entityManager.find(Details.class, id_details);
	}

	
	@Override
	public void purchaseJSF(Integer idMember, Integer idProduct, Integer quantity) {
		
		Member member = memberServiceLocal.findMemberById(idMember);
		Product product = productServiceLocal.findProductById(idProduct);
		List<Account> accounts = member.getAccounts();
		for(Account a:accounts){
			a.setId_Account(1);           
			if(a.getCredit() >= (quantity * product.getPrice())){
				Details details = new Details(quantity, member, product);
				details.setState(true);
				a.setCredit(a.getCredit() - (quantity * product.getPrice()));
				entityManager.merge(details);			 
			}else{
				Details details = new Details(quantity, member, product);
				entityManager.merge(details);	
			}
			entityManager.merge(a);
		}
		
		     
	}
	
	/// ****** autres méthodes qui buguent
	
	@Override
	public void AddProductToCart(Details details) {
		entityManager.merge(details);
	}

	@Override
	public double CalculateAndShowTotalAmmounts(Integer Id_Member, Integer Id_Product, Integer Quantityr) {
		// TODO Auto-generated method stub
		return 0;
	}



	
}
