package com.aurionpro.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.app.entity.Role;
import com.aurionpro.app.exceptions.RoleApiException;
import com.aurionpro.app.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public Role createRole(Role role) {
		Role roleDb = roleRepo.save(role);
		return roleDb;
	}

	@Override
	public Role getRoleById(int id) {
		return roleRepo.findById(id).orElseThrow(() ->
				new RoleApiException("Role with ID:" + id + " not found"));
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepo.findAll();
	}

}
