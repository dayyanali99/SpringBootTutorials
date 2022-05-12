package com.springboottutorials.springboottutorials.dao;

import com.springboottutorials.springboottutorials.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    // Custom finder methods | Derived Query methods (no implementation needed as spring gives the implementation by method's name)
    List<User> findByNameIgnoreCase(String name);
    User findDistinctUserByCity(String city);
    User getUserByNameContaining(String myName);

    @Query("from User ")
    List<User> getAllUsersQuery();

    @Query("from User as u where u.name=:x")
    User getUserByNameQuery(@Param("x") String name);

    @Query(value = "select * from user",nativeQuery = true)
    List<User> getUsersByNativeQuery();
}
