package com.task.secureuser.repository;

import com.task.secureuser.model.AllUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<AllUsers,Long> {

    Optional<AllUsers> findByUsername(String Username);
}
