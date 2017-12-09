package tn.esprit.services;

import javax.ejb.Local;

import tn.esprit.entities.Admin;

@Local
public interface AdminServicesLocal {
	
	void addAdmin(Admin admin);

	Admin findAdminById(Integer id_admin);

	void updateAdmin(Admin admin);
}
