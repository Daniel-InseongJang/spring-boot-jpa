package com.example.jpa.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM user where user_key = :user_key",nativeQuery = true)
    Optional<User> findByUserKey(@Param("user_key") String user_key);

}
