package com.sendEmails.Emails.repository;

import com.sendEmails.Emails.model.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.module.Configuration;
@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation,Long> {
    Confirmation findByToken(String token);
}
