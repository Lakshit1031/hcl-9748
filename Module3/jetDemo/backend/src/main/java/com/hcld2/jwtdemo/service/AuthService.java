
package com.hcld2.jwtdemo.service;

import com.hcld2.jwtdemo.dto.AuthRequest;
import com.hcld2.jwtdemo.dto.AuthResponse;
import com.hcld2.jwtdemo.dto.StatusResponse;
import com.hcld2.jwtdemo.entity.User;
import com.hcld2.jwtdemo.repository.UserRepository;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    // USER REGISTRATION
    @Transactional
    public StatusResponse registerUser(AuthRequest authRequest) {

        // Check if username already exists
        if (users.findByUsername(authRequest.username()).isPresent()) {
            return new StatusResponse(
                    "error",
                    "Username already in use"
            );
        }

        // Encrypt password using BCrypt
        User user = new User(
                authRequest.username(),
                encoder.encode(authRequest.password())
        );

        // Save user in database
        users.save(user);

        return new StatusResponse(
                "message",
                "User successfully registered"
        );
    }

    // USER LOGIN
    public AuthResponse login(AuthRequest req) {

        // Find user by username
        User user = users.findByUsername(req.username())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED,
                                "Invalid username or password"
                        )
                );

        // Verify password
        if (!encoder.matches(
                req.password(),
                user.getPassword()
        )) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid username or password"
            );
        }

        // Generate JWT token
        String token = jwt.generateToken(user.getUsername());

        // Return JWT and username
        return new AuthResponse(
                token,
                user.getUsername()
        );
    }
}
