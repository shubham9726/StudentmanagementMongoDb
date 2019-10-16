package com.decipherzone.studmgntmongodb.repository;

import com.decipherzone.studentmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /* User findByEmail(String email);

     boolean existsById(String email);
 }*/
    boolean existsByEmail(String email);

    User findByEmail(String email);
/*
       @Transactional
       void deleteByUsername(String username);*/

}
