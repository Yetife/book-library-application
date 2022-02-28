package com.example.bookapplication.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.bookapplication.data.model.BookUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private ObjectMapper objectMapper;


    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try{
            BookUser bookUser = objectMapper.readValue(request.getInputStream(), BookUser.class);
            //create usernamepasswordtoken
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(bookUser.getEmail(), bookUser.getPassword());
            //pass token to authentucation manager
            return authenticationManager.authenticate(authenticationToken);
        }catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //first generate token
        String jwtToken = JWT.create().withSubject(((User)
                authResult.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis()+864_000_000))
                .sign(Algorithm.HMAC512("BookSecret@".getBytes()));
        response.addHeader("Authorization", jwtToken);
    }
}
