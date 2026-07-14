package com.orporsoft.inventory.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orporsoft.inventory.security.entity.Role;

public interface RoleRepository
extends JpaRepository<Role,Long>{

}
