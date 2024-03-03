package com.sendEmails.Emails.service.impl;

import com.sendEmails.Emails.model.Confirmation;
import com.sendEmails.Emails.model.User;
import com.sendEmails.Emails.repository.ConfirmationRepository;
import com.sendEmails.Emails.repository.UserRepository;
import com.sendEmails.Emails.service.EmailService;
import com.sendEmails.Emails.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;

    private final EmailService emailService;
    @Override
    public User saveUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){throw new RuntimeException("user exist");}
        user.setIsEnable(false);
        userRepository.save(user);

        Confirmation confirmation = new Confirmation(user);
        confirmationRepository.save(confirmation);

        /* TODO send emails to users */

        //emailService.sendSimpleMailMessage(user.getName(), user.getEmail(), confirmation.getToken());
        //emailService.sendMimeMessageWithAttachments(user.getName(), user.getEmail(), confirmation.getToken());
        //emailService.sendMimeMessageWithEmbeddedFiles(user.getName(), user.getEmail(), confirmation.getToken());
        emailService.sendHtmlEmail(user.getName(), user.getEmail(), confirmation.getToken());


        return user;
    }

    @Override
    public Boolean verifyToken(String token) {
        Confirmation confirmation = confirmationRepository.findByToken(token);
        User user = userRepository.findByEmail(confirmation.getUser().getEmail());
        user.setIsEnable(true);
        userRepository.save(user);
        return Boolean.TRUE;
    }
}
