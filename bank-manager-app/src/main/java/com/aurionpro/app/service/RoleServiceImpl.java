package com.aurionpro.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.aurionpro.app.entity.Role;
import com.aurionpro.app.repository.RoleRepository;

public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public Role createRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

}
