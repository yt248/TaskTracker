package com.eugene.spring.boot.pet.project.TaskTracker.service;

import com.eugene.spring.boot.pet.project.TaskTracker.entity.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {

    User readUserById(Long id);

    void updateUser(Long id, User newUser);

    void deleteUser(Long id);

    List<User> getAllUsers();


    void register(User user, String siteURL)  throws UnsupportedEncodingException, MessagingException;

    /**
     * @param user
     * @param siteURL
     */
    private void sendVerificationEmail(User user, String siteURL) {

    }

    /**
     * @param verificationCode код верификации
     * @return удаление кода верификации и активация user
     */
    boolean verify(String verificationCode);
}
