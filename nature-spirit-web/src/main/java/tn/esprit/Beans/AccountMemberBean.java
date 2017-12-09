package tn.esprit.Beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import tn.esprit.entities.Account;
import tn.esprit.entities.Member;
import tn.esprit.entities.Product;
import tn.esprit.services.AccountMemberServicesLocal;
import tn.esprit.services.MemberServicesLocal;

@ManagedBean
@ViewScoped
public class AccountMemberBean {

	@EJB
	private MemberServicesLocal memberServicesLocal;
	@EJB
	AccountMemberServicesLocal accountMemberServicesLocal; 
	private Account account = new Account();
	private Member member = new Member();
	private List<Account> list_accounts;
    private Double Credit;
	private int Rib_Number;
	boolean test=false;

	public static int id_member=2;         
	
	public AccountMemberBean() {
		super();
	}

	public AccountMemberBean(List<Account> list_accounts, Double credit, int rib_Number) {
		super();
		this.list_accounts = list_accounts;
		Credit = credit;
		Rib_Number = rib_Number;
	}

	public AccountMemberBean(Double credit, int rib_Number) {
		super();
		Credit = credit;
		Rib_Number = rib_Number;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Account> getList_accounts() {
		return list_accounts;
	}

	public void setList_accounts(List<Account> list_accounts) {
		this.list_accounts = list_accounts;
	}

	public Double getCredit() {
		return Credit;
	}

	public void setCredit(Double credit) {
		Credit = credit;
	}

	public int getRib_Number() {
		return Rib_Number;
	}

	public void setRib_Number(int rib_Number) {
		Rib_Number = rib_Number;
	}

	public static int getId_member() {
		return id_member;
	}

	public static void setId_member(int id_member) {
		AccountMemberBean.id_member = id_member;
	}
	
	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	@PostConstruct
	public void initAccountMember()
	{   
		account = new Account();
		member = new Member();
		list_accounts = accountMemberServicesLocal.findAllBanksAccountsMemberById2(id_member);
		test=false;
	}
	   
	public String initialiser(){
		test=true;  
		return null; 
		
	}
	
	public void AddAccountMember(){
		accountMemberServicesLocal.addAccountToMember(account, id_member);
		initAccountMember();
	}     
	
}
