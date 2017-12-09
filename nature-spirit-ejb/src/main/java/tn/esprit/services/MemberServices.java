package tn.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Member;
import tn.esprit.entities.Product;

/**
 * Session Bean implementation class MemberServices
 */
@Stateless
@LocalBean
@WebService(
name="ServicesMemberPortType",
portName="ServicesMemberPort",
serviceName="ServicesMember",
targetNamespace="http://ServicesMember.com")
@Named("MemberServices")
public class MemberServices implements MemberServicesRemote, MemberServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public MemberServices() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void SignUp(Member member) {
		entityManager.merge(member);
	}

	@Override
	public void SingIn(String email, String pwd) {
		entityManager.createNativeQuery("SELECT m FROM Member m WHERE m.Email='email' and m.Password='pwd' ");

	}

	@WebResult(name="ResultFindMemberById")
	@Override
	public Member findMemberById(Integer Id_Member) {
		return entityManager.find(Member.class, Id_Member);
	}

	@WebResult(name="ResultUpdateMember")
	@Override
	public void updateMember(Member member) {
        entityManager.merge(member);
	}

/// ******* lés méthodes qui buguent
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> ShowAllMyProductsInCartsById(Integer Id_Member) {
		return (List<Product>) entityManager.find(Member.class, Id_Member);
	}


}
