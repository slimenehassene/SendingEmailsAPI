package com.sendEmails.Emails.service;

import com.sendEmails.Emails.model.User;

public interface UserService {
    User saveUser(User user);
    Boolean verifyToken(String token);
}
