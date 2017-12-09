package tn.esprit.services;

import javax.ejb.Remote;

import tn.esprit.entities.Admin;

@Remote
public interface AdminServicesRemote {
	
	void addAdmin(Admin admin);

	Admin findAdminById(Integer id_admin);

	void updateAdmin(Admin admin);
}
