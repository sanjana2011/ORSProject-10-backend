package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rays.dto.UserDTO;

/**
 * JWTUserDetailsService is a service class that implements Spring Security's
 * {@link UserDetailsService} interface for JWT authentication.
 * 
 * <p>This service is responsible for loading user-specific data during
 * authentication. It retrieves user details from the database using the
 * username (login ID) and returns a Spring Security UserDetails object
 * containing the user's credentials and authorities for token validation.</p>
 *
 * @author sanjana gangrade
 */
@Service
public class JWTUserDetailsService implements UserDetailsService {

    /**
     * Provides a password encoder bean for encrypting passwords.
     * This method creates and returns a BCryptPasswordEncoder instance
     * which is used to encode passwords before storing them in the database
     * and to validate passwords during authentication.
     *
     * @return PasswordEncoder implementation (BCryptPasswordEncoder)
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** Service for user-related operations. */
    @Autowired
    UserServiceInt userService;

    /**
     * Loads a user by their username (login ID) for authentication.
     * This method fetches the user from the database using the login ID,
     * and constructs a Spring Security UserDetails object with the user's
     * credentials and authorities.
     *
     * @param username the login ID of the user to load
     * @return UserDetails object containing user authentication information
     * @throws UsernameNotFoundException if no user is found with the given username
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO user = userService.findByLoginId(username, null);

        if (user == null) {
            System.out.println("user found nuulllll");
            throw new UsernameNotFoundException("User not found with username : " + username);
        }

        return User.builder().username(user.getLoginId()).password(passwordEncoder().encode(user.getPassword()))
                .roles("USER").build();
    }
}