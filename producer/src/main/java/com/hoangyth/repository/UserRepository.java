package com.hoangyth.repository;

import com.hoangyth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.NamedQuery;
import java.util.Optional;

import static javax.persistence.LockModeType.PESSIMISTIC_READ;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT u FROM User u WHERE u.id = :userId")
    Optional<User> findUserById(String userId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT u FROM User u WHERE u.userName = :userName")
    Optional<User> findUserByUserName(String userName);
}
