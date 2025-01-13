package com.example.user.Service;

import com.example.user.Model.AuthenticationResponse;
import com.example.user.Model.User;
import com.example.user.Repository.UserRepository;
import com.example.user.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired

    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtservice;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(User request){
        User user = new User();
        user.setName(request.getName());

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        repository.save(user);
        String token = jwtservice.generateToken(user);
        return new AuthenticationResponse(token);


    }

    public AuthenticationResponse authenticate(LoginDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken( request.getEmail(), request.getPassword()));
        User user=repository.findByEmail(request.getEmail());
        String token=jwtservice.generateToken(user);
        return new AuthenticationResponse(token);
    }

}

