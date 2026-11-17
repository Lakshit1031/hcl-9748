
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

    // ============================
    // USER REGISTRATION
    // ============================

    @Transactional
    public StatusResponse registerUser(AuthRequest authRequest) {

        String username = authRequest.username().trim();
        String password = authRequest.password();

        // Check existing username
        if (users.findByUsername(username).isPresent()) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Username already exists"
            );
        }

        // Encrypt password
        String encodedPassword = encoder.encode(password);

        // Create new user
        User user = new User(
                username,
                encodedPassword
        );

        users.save(user);

        return new StatusResponse(
                "success",
                "User registered successfully. Please login."
        );
    }


    // ============================
    // USER LOGIN
    // ============================

    public AuthResponse login(AuthRequest req) {

        String username = req.username().trim();
        String password = req.password();

        // Find user
        User user = users.findByUsername(username)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED,
                                "Invalid username or password"
                        )
                );

        // Verify password
        if (!encoder.matches(password, user.getPassword())) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Invalid username or password"
            );
        }

        // Generate JWT
        String token = jwt.generateToken(user.getUsername());

        // Return authentication response
        return new AuthResponse(
                token,
                user.getUsername()
        );
    }
}
