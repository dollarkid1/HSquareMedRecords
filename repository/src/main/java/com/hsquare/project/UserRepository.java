package com.hsquare.project;

import com.hsquare.project.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUsers, Long> {

    Optional<AppUsers> findById(Long Id);

    Optional<AppUsers> findByPhoneNumber(String phoneNumber);

    Boolean existsByPhoneNumber(String phoneNumber);
    Boolean existsByEmail(String email);

}
