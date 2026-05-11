package com.rays.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurityConfig is the main security configuration class for the application.
 * This class extends {@link WebSecurityConfigurerAdapter} and configures Spring Security
 * settings including request authorization, session management, and JWT authentication.
 * 
 * <p>Key configurations:</p>
 * <ul>
 *   <li>Disables CSRF protection for stateless APIs</li>
 *   <li>Configures public access to authentication and certain endpoints</li>
 *   <li>Requires authentication for all other requests</li>
 *   <li>Sets session management to STATELESS for JWT-based authentication</li>
 *   <li>Registers JWT request filter before the username-password authentication filter</li>
 *   <li>Enables CORS support</li>
 * </ul>
 *
 * @author sanjana gangrade
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** The JWT request filter for token validation. */
    @Autowired
    private JWTRequestFilter jwtRequestFilter;

    /**
     * Configures HTTP security settings including request authorization,
     * session management, and filter chain.
     *
     * @param http the HttpSecurity object to configure
     * @throws Exception if an error occurs during configuration
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/Auth/**", "/User/profilePic/**", "/Jasper/report/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.cors();
    }
}