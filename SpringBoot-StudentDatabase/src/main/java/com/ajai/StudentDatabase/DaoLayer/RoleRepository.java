package com.ajai.StudentDatabase.DaoLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajai.StudentDatabase.Entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
