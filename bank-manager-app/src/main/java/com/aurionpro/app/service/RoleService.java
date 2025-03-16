package com.aurionpro.app.service;

import java.util.List;

import com.aurionpro.app.entity.Role;

public interface RoleService {
	Role createRole(Role role);
	Role getRoleById(int id);
	List<Role> getAllRoles();
}
