package com.orporsoft.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orporsoft.inventory.entity.Role;

public interface RoleRepository
extends JpaRepository<Role,Long>{

}
