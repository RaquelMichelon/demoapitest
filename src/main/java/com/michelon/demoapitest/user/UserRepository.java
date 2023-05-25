package com.michelon.demoapitest.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @autor raqueldarellimichelon
 * created on 24/05/23 inside the package - com.michelon.demoapitest.user
 **/
@Repository //if extends jpa this annotation is dispensable
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("" +
            "SELECT CASE WHEN COUNT(u) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM User u " +
            "WHERE u.email = ?1"
    )
    Boolean selectExistsEmail(String email);

}


