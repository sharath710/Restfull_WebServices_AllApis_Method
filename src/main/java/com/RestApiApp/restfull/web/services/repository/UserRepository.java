package com.RestApiApp.restfull.web.services.repository;

import com.RestApiApp.restfull.web.services.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
