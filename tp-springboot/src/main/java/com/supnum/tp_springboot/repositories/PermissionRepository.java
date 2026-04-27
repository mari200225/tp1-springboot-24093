package com.supnum.tp_springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.supnum.tp_springboot.entities.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    boolean existsByName(String name);
}