package com.hsquare.project;

import com.hsquare.project.model.AppUsers;
import com.hsquare.project.model.ERole;
import com.hsquare.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
