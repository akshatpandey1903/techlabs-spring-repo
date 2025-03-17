package com.aurionpro.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.app.entity.Role;
import com.aurionpro.app.service.RoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bankapp")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/roles")
	public ResponseEntity<List<Role>> getAllRoles(){
		return ResponseEntity.ok(roleService.getAllRoles());
	}
	
	@PostMapping("/roles")
	public ResponseEntity<Role> createRole(@RequestBody @Valid Role role){
		return ResponseEntity.ok(roleService.createRole(role));
	}
	
	@GetMapping("/roles/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable int id){
		return ResponseEntity.ok(roleService.getRoleById(id));
	}
}
