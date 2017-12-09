package tn.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.entities.Admin;

/**
 * Session Bean implementation class AdminServices
 */
@Stateless
@LocalBean
@WebService(
name="ServicesAdminrPortType",
portName="ServicesAdminPort",
serviceName="ServicesAdmin",
targetNamespace="http://ServicesAdmin.com")
@Named("AdminServices")
public class AdminServices implements AdminServicesRemote, AdminServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public AdminServices() {
		// TODO Auto-generated constructor stub
	}

	@WebResult(name="ResultFindAdminById")
	@Override
	public Admin findAdminById(Integer id_admin) {
		return entityManager.find(Admin.class, id_admin);
	}

	@WebResult(name="ResultUpdateAdmin")
	@Override
	public void updateAdmin(Admin admin) {
		entityManager.merge(admin);
	}

	@WebResult(name="ResultAddAdmin")
	@Override
	public void addAdmin(Admin admin) {
         entityManager.merge(admin);		
	}

}
