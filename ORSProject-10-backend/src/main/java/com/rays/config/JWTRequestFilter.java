package com.rays.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rays.common.UserContext;
import com.rays.common.UserContextHolder;
import com.rays.dto.UserDTO;
import com.rays.service.JWTUserDetailsService;

/**
 * JWTRequestFilter is a custom filter that intercepts incoming HTTP requests
 * to validate JWT tokens. This filter extends {@link OncePerRequestFilter} to
 * ensure it is executed once per request. It extracts the JWT token from the
 * Authorization header, validates it, and sets up the authentication context
 * in Spring Security and the custom UserContext in thread-local storage.
 *
 * @author sanjana gangrade
 */
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    /** Utility class for JWT token operations. */
    @Autowired
    private JWTUtil jwtUtil;

    /** Service for loading user details from JWT. */
    @Autowired
    private JWTUserDetailsService jwtUserDetailsService;

    /**
     * Processes each HTTP request to validate JWT tokens and set up
     * authentication context.
     *
     * @param request the HTTP request
     * @param response the HTTP response
     * @param filterChain the filter chain to continue processing
     * @throws ServletException if a servlet error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");

        System.out.println("JWT Token ======>>>>> " + authorizationHeader);

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {

            System.out.println("JWT Token ======>>>>> iiiiinnnnnn");

            String jwtToken = authorizationHeader.substring(7);

            try {

                String loginId = jwtUtil.extractLoginId(jwtToken);

                if (!jwtUtil.validateToken(jwtToken, loginId)) {
                    throw new Exception("Invalid JWT token");
                }

                if (loginId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    String role = jwtUtil.extractRole(jwtToken);
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            loginId, null,
                            List.of(new SimpleGrantedAuthority("ROLE_" + role))
                    );
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }

                UserDTO dto = new UserDTO();
                dto.setLoginId(loginId);

                System.out.println("request filter: " + dto.getLoginId());

                UserContext context = new UserContext(dto);

                // ThreadLocal me set
                UserContextHolder.setContext(context);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token is invalid... plz login again..!!");
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}