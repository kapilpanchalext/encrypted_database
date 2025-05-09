package com.java.encryption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.encryption.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {

}
