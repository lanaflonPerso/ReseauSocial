package com.via.reseauSocial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.via.reseauSocial.beans.Role;

@Repository
public interface RoleDao  extends JpaRepository<Role , Integer> {
	Role findByRoleName(String roleName);
}