package com.sendEmails.Emails.repository;

import com.sendEmails.Emails.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String Email);
    Boolean existsByEmail(String Email);
}
