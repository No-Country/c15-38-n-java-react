package com.c1538njavareact.serviLink.security;

import com.c1538njavareact.serviLink.repository.IUserRepository;
import com.c1538njavareact.serviLink.utils.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtService;
    @Autowired
    private IUserRepository IUserRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Get jwt token from header
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");
            var username = jwtService.getSubject(token); // extract username
            if (username != null) { // Valid token
                UserDetails user = IUserRepository.findByUsername(username);
                var authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities()); // Forced login
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }
}
