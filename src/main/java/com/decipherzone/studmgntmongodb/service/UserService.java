package com.decipherzone.studmgntmongodb.service;

import com.decipherzone.studmgmtmongodb.configuration.JwtTokenProvider;
import com.decipherzone.studmgmtmongodb.exception.CustomException;
import com.decipherzone.studmgmtmongodb.model.User;
import com.decipherzone.studmgmtmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;

    /*public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }*/

    public String login(String email, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String register(User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getEmail(), user.getRoles());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String refresh(String email) {
        return jwtTokenProvider.createToken(email, userRepository.findByEmail(email).getRoles());
    }

    /*public User whoami(HttpServletRequest req) {
        return userRepository.findByEmail(jwtTokenProvider.getEmail(jwtTokenProvider.resolveToken(req)));
    }*/
}